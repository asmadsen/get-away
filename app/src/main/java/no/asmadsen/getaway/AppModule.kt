package no.asmadsen.getaway

import com.google.gson.*
import no.asmadsen.getaway.repositories.AirportRepository
import no.asmadsen.getaway.repositories.SasRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.lang.reflect.Type

val appModule = module {
    viewModel { ApplicationViewModel(get(), get()) }
    viewModel { MapViewModel(get(), get(), get(), get()) }

    single { MyDatabase.getDatabase(get()) }

    single { AirportRepository(get()) }
    single { SasRepository(get()) }

    single {
        GsonBuilder()
            .registerTypeAdapter(Boolean::class.java, object : JsonDeserializer<Boolean> {
                override fun deserialize(
                    json: JsonElement?,
                    typeOfT: Type?,
                    context: JsonDeserializationContext?
                ): Boolean {
                    if (json == null) return false
                    return if (json.isJsonPrimitive) {
                        val primitive = json.asJsonPrimitive
                        if (primitive.isBoolean) primitive.asBoolean
                        else if (primitive.isNumber) {
                            primitive.asInt == 1
                        } else false
                    } else false
                }
            })
            .registerTypeAdapter(Double::class.java, object : JsonDeserializer<Double> {
                override fun deserialize(
                    json: JsonElement?,
                    typeOfT: Type?,
                    context: JsonDeserializationContext?
                ): Double {
                    if (json == null) return 0.0
                    return if (json.isJsonPrimitive) {
                        val primitive = json.asJsonPrimitive
                        if (primitive.isNumber) {
                            return primitive.asDouble
                        } else if (primitive.isString) {
                            try { primitive.asDouble }
                            catch (_: NumberFormatException) { 0.0 }
                        }else 0.0
                    } else 0.0
                }
            })
            .create()
    }
}