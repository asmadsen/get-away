package no.asmadsen.getaway.utils

import android.hardware.*
import io.reactivex.disposables.Disposable

/**
 * Heavily inspired by https://github.com/square/seismic
 */
class ShakeDetection(private val listener: Listener) : SensorEventListener {
    constructor(listener: () -> Unit) : this(object : Listener {
        override fun onShake() {
            listener()
        }
    })

    companion object {
        public const val SENSITIVITY_LIGHT = 11
        public const val SENSITIVITY_MEDIUM = 13
        public const val SENSITIVITY_HARD = 15
        private const val DEFAULT_ACCELERATION_THRESHOLD = SENSITIVITY_MEDIUM
    }

    var accelerationThreshold = DEFAULT_ACCELERATION_THRESHOLD

    interface Listener {
        fun onShake(): Unit
    }

    private val queue = SampleQueue()

    private var sensorManager: SensorManager? = null
    private var accelerometer: Sensor? = null

    fun start(sensorManager: SensorManager): Boolean{
        if (accelerometer != null) return true

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        if (accelerometer != null) {
            this.sensorManager = sensorManager
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_FASTEST)
        }
        return accelerometer != null
    }

    fun stop() {
        if (accelerometer != null) {
            queue.clear()
            sensorManager!!.unregisterListener(this, accelerometer)
            sensorManager = null
            accelerometer = null
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            val accelerating = isAccelerating(event)
            val timestamp = event.timestamp
            queue.add(timestamp, accelerating)
            if (queue.isShaking()) {
                queue.clear()
                listener.onShake()
            }
        }
    }

    private fun isAccelerating(event: SensorEvent): Boolean {
        val ax: Float = event.values[0]
        val ay: Float = event.values[1]
        val az: Float = event.values[2]

        val magnitudeSquared = (ax * ax + ay * ay + az * az).toDouble()
        return magnitudeSquared > accelerationThreshold * accelerationThreshold
    }

    class SampleQueue {
        companion object {
            private const val MAX_WINDOW_SIZE = 500000000L // 0.5s
            private const val MIN_WINDOW_SIZE = MAX_WINDOW_SIZE shr 1 // 0.25s
            private const val MIN_QUEUE_SIZE = 4
        }

        private val pool = SamplePool()

        private var oldest: Sample? = null
        private var newest: Sample? = null
        private var sampleCount = 0
        private var acceleratingCount = 0

        fun add(timestamp: Long, accelerating: Boolean) {
            purge(timestamp - MAX_WINDOW_SIZE)

            val added = pool.acquire()
            added.timestamp = timestamp
            added.accelerating = accelerating
            added.next = null

            newest?.apply{
                next = added
            }
            newest = added

            if (oldest == null) {
                oldest = added
            }

            sampleCount++
            if (accelerating) {
                acceleratingCount++
            }
        }

        fun clear() {
            var removed = oldest
            while (removed != null) {
                oldest = removed.next
                oldest = removed.next
                removed = oldest
            }
            newest = null
            sampleCount = 0
            acceleratingCount = 0
        }

        fun purge(cutoff: Long) {
            var removed = oldest
            while (sampleCount >= MIN_QUEUE_SIZE
                && removed != null && cutoff - removed.timestamp!! > 0) {
                if (removed.accelerating == true) {
                    acceleratingCount--
                }
                sampleCount--

                oldest = removed.next
                if(oldest == null) {
                    newest = null
                }

                pool.release(removed)
                removed = oldest
            }
        }

        fun asList(): List<Sample> {
            val list = arrayListOf<Sample>()
            var sample = oldest
            while (sample != null) {
                list.add(sample)
                sample = sample.next
            }
            return list
        }

        fun isShaking(): Boolean {
            val tmpNewest = newest
            val tmpOldest = oldest

            return tmpNewest != null
                    && tmpOldest != null
                    && tmpNewest.timestamp!! - tmpOldest.timestamp!! >= MIN_WINDOW_SIZE
                    && acceleratingCount >= (sampleCount shr 1) + (sampleCount shr 2)
        }
    }

    data class Sample(var timestamp: Long? = null, var accelerating: Boolean? = null, var next : Sample? = null)

    class SamplePool {
        private var head: Sample? = null

        fun acquire() : Sample {
            var acquired = head
            if (acquired == null) {
               acquired = Sample()
            } else {
                head = acquired.next
            }

            return acquired
        }

        fun release(sample: Sample) {
            sample.next = head
            head = sample
        }
    }
}
