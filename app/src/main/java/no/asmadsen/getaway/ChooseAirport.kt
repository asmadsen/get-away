package no.asmadsen.getaway

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Transition
import androidx.transition.TransitionInflater
import androidx.transition.TransitionListenerAdapter
import com.minimize.android.rxrecycleradapter.RxDataSource
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.choose_airport_fragment.*
import no.asmadsen.getaway.databinding.AirportItemBinding
import no.asmadsen.getaway.databinding.ChooseAirportFragmentBinding
import no.asmadsen.getaway.room.entities.AirportWithCity
import no.asmadsen.getaway.room.entities.AirportWithCityAndDistance
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import kotlin.math.roundToInt


class ChooseAirport : Fragment() {

    private val bag = CompositeDisposable()
    private val viewModel: ApplicationViewModel by sharedViewModel()
    private val airportSearch = MutableLiveData<String>().apply { value = "" }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move).apply {
                duration = 250
            }.addListener(object : TransitionListenerAdapter() {
                override fun onTransitionEnd(transition: Transition) {
                    super.onTransitionEnd(transition)
                    chooseAirportView.requestFocus()
                }
            })
        sharedElementReturnTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move).apply {
                duration = 250
            }
        val binding = DataBindingUtil.inflate<ChooseAirportFragmentBinding>(
            inflater,
            R.layout.choose_airport_fragment,
            container,
            false
        )
        airportSearch.postValue(viewModel.airport.value?.name ?: "")
        binding.lifecycleOwner = this
        binding.airportName = airportSearch
        binding.airport = viewModel.airport
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chooseAirportView.setOnCloseListener {
            findNavController().popBackStack()
        }

        chooseAirportRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
        }
        val airportsAdapter =
            RxDataSource<AirportItemBinding, AirportWithCity>(R.layout.airport_item, listOf())
        airportsAdapter.bindRecyclerView(chooseAirportRecyclerView)
        airportsAdapter.asObservable().subscribe { holder ->
            val binding = holder.viewDataBinding ?: return@subscribe
            val airport = holder.item ?: return@subscribe
            binding.airportName.text = airport.name.toUpperCase()
            binding.airportIata.text = airport.iata
            binding.airportCity.text = airport.city.name
            val distance = if (airport is AirportWithCityAndDistance) airport.distance else null
            binding.distanceFromLocation.text = if (distance != null) {
                val distanceInKm = (distance/1000f).roundToInt()
                if (distanceInKm > 200) "" else "${distanceInKm}km"
            } else ""
            binding.airportItemLayout.setOnClickListener {
                viewModel.airport.postValue(airport)
                airportSearch.postValue(airport.name)
                findNavController().popBackStack()
            }
        }.addTo(bag)


        airportSearch.observe(this, Observer { name ->
            val userLocation = viewModel.userLocation.value
            if (userLocation != null) {
                viewModel.getNearestAirports(
                    if (name.equals(viewModel.airport.value?.name, true)) "" else name, userLocation.latitude, userLocation.longitude)
                    .subscribe { airports ->
                        airportsAdapter.updateDataSet(airports)
                        airportsAdapter.updateAdapter()
                    }
            } else {
                viewModel.getAirports(if (name.equals(viewModel.airport.value?.name, true)) "" else name)
                    .subscribe { airports ->
                        airportsAdapter.updateDataSet(airports)
                        airportsAdapter.updateAdapter()
                    }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        bag.clear()
    }
}