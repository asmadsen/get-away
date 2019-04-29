package no.asmadsen.getaway

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.hardware.SensorManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.minimize.android.rxrecycleradapter.RxDataSource
import com.squareup.picasso.Picasso
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.zipWith
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import kotlinx.android.synthetic.main.fare_result.*
import kotlinx.android.synthetic.main.map_bottom_sheet_fragment.*
import kotlinx.android.synthetic.main.map_fragment.*
import no.asmadsen.getaway.providers.flickr.entities.Photo
import no.asmadsen.getaway.providers.sas.entities.PassengerType
import no.asmadsen.getaway.room.entities.AirportWithCityAndDistance
import no.asmadsen.getaway.utils.ShakeDetection
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.pow


class Map : Fragment() {
    private val bag = CompositeDisposable()
    private val applicationViewModel: ApplicationViewModel by sharedViewModel()
    private val viewModel: MapViewModel by viewModel()

    private lateinit var shakeDetection: ShakeDetection
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    private val airportStream = ReplaySubject.create<AirportWithCityAndDistance>(1)
    private val photoStream = ReplaySubject.create<PhotoRequest>(1)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.map_fragment, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.frg) as SupportMapFragment
        var mapMarker : Marker? = null

        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                val scale = (1 - slideOffset * 2.5f).run {
                    if (this > 1f || slideOffset < 0f) 1f
                    else if (this < 0f) 0f
                    else this
                }
                helpBtn.animate().scaleX(scale).scaleY(scale).setDuration(0).start();
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {}
        })

        bottom_sheet.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
            }
        }

        banner.setRightButtonListener {
            banner.dismiss()
        }

        helpBtn.setOnClickListener {
            banner.show()
        }

        val position = applicationViewModel.userLocation.value
        shakeDetection = ShakeDetection {
            banner.dismiss()
            viewModel.findRandomWithCity(position!!.latitude, position.longitude).subscribe { airport ->
                mapFragment.getMapAsync {
                    val googlePlex = CameraPosition.builder()
                        .target(LatLng(airport.latitude, airport.longitude))
                        .zoom(8f)
                        .build()
                    it.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 1000, null)

                    airportStream.onNext(airport)
                    photoStream.onNext(PhotoRequest(airport.city.name, airport.latitude, airport.longitude))
                }
            }.addTo(bag)
        }.apply {
            start(activity!!.getSystemService(SensorManager::class.java))
        }

        photosRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
        val photosAdapter =
            RxDataSource<no.asmadsen.getaway.databinding.PhotoItemBinding, Photo>(R.layout.photo_item, listOf())
        photosAdapter.bindRecyclerView(photosRecyclerView)
        photosAdapter.asObservable().subscribe { holder ->
            val binding = holder.viewDataBinding ?: return@subscribe
            Picasso.get()
                .load("https://farm${holder.item?.farm}.staticflickr.com/${holder.item?.server}/${holder.item?.id}_${holder.item?.secret}_z.jpg")
                .into(binding.photoImage)
        }.addTo(bag)

        airportStream.subscribe { airport ->
            mapMarker?.remove()
            mapFragment.getMapAsync { map ->
                mapMarker = map.addMarker(MarkerOptions().position(LatLng(airport.latitude, airport.longitude)))
            }
        }.addTo(bag)

        airportStream
            .flatMap { airport ->
                val fromIata = applicationViewModel.airport.value!!.iata
                val toIata = airport.iata
                val departureDate = Calendar.getInstance().getTime()
                val returnDate = Calendar.getInstance().run {
                    time = departureDate
                    add(Calendar.DATE, 60)
                    Date(timeInMillis)
                }

                viewModel.fetchLowFareToAirport(
                    fromIata,
                    toIata,
                    departureDate,
                    returnDate,
                    PassengerType.Adult
                ).toObservable()
            }
            .map { res -> res.searchResponse.firstOrNull() }
            .subscribe { lowestFare ->
                if (lowestFare == null) return@subscribe
                if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                }
                val fromAirport = applicationViewModel.airport.value!!
                originCity.text = fromAirport.city.name
                originIata.text = fromAirport.iata
                destinationCity.text = lowestFare.destinationCity.name
                destinationIata.text = lowestFare.destinationAirport.code
                val fare = lowestFare.flightProducts.first()
                farePrice.text = fare.lowestPrice.formattedTotalPrice
                farePeriod.text = if (fare.lowestPrice.formattedTotalPrice.equals("NA", true)) {
                    ""
                } else {
                    val formatter = SimpleDateFormat("dd. MMMM", resources.configuration.locales.get(0))
                    "${formatter.format(fare.outBoundDate)} - ${formatter.format(fare.inBoundDate)}"
                }
            }
            .addTo(bag)

        photoStream
            .flatMap { photoRequest ->
                val byLocation = viewModel.fetchPhotosByLocation(photoRequest.latitude, photoRequest.longitude)
                    .map { response -> response.photos.photo }
                    .toObservable()
                val byTags = viewModel.fetchPhotosByTags(photoRequest.placeName, "sightseeing")
                    .map { response -> response.photos.photo }
                    .toObservable()
                byLocation.zipWith(byTags) { photos1: List<Photo>, photos2: List<Photo> ->
                    photos1.union(photos2)
                }
            }
            .subscribe { photos ->
                photosAdapter.updateDataSet(photos.toList())
                photosAdapter.updateAdapter()
            }
            .addTo(bag)

        mapFragment.getMapAsync { map ->
            map.mapType = GoogleMap.MAP_TYPE_NORMAL

            val googlePlex = CameraPosition.builder()
                .target(LatLng(59.8939529, 10.6450354))
                .zoom(6f)
                .build()

            map.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 1000, null)

            map.setOnMapClickListener {
                banner.dismiss()
                applicationViewModel.getNearestAirport(it.latitude, it.longitude)
                    .filter { airport -> !airport.iata.equals(applicationViewModel.airport.value!!.iata, true) }
                    .subscribe { airport ->
                        photoStream.onNext(PhotoRequest(airport.city.name, it.latitude, it.longitude))
                        airportStream.onNext(airport)
                    }
            }

        }
    }

    override fun onStart() {
        super.onStart()
        if (!airportStream.hasValue()) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        shakeDetection.stop()
        bag.clear()
    }


    data class PhotoRequest(val placeName: String, val latitude: Double, val longitude: Double)
}
