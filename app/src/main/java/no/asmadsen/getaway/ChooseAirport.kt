package no.asmadsen.getaway

import android.os.Bundle
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.TransitionInflater
import com.minimize.android.rxrecycleradapter.RxDataSource
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.choose_airport_fragment.*
import kotlinx.android.synthetic.main.view_choose_airport.*
import no.asmadsen.getaway.adapters.AirportsAdapter
import no.asmadsen.getaway.databinding.AirportItemBinding
import no.asmadsen.getaway.databinding.ChooseAirportFragmentBinding
import no.asmadsen.getaway.room.entities.AirportWithCityAndDistance
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ChooseAirport : Fragment() {
    companion object {
        fun newInstance() = ChooseAirport()
    }

    private val bag = CompositeDisposable()
    private val viewModel: ApplicationViewModel by sharedViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move).apply {
                duration = 250
            }
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
        binding.lifecycleOwner = this
        binding.airportName = viewModel.airport
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        closeButtonYourAirport.setOnClickListener {
            if (viewModel.airport.value.isNullOrEmpty()) {
                findNavController().popBackStack()
            } else {
                viewModel.airport.postValue("")
            }
        }

        editTextYourAirport.filters = arrayOf(InputFilter.AllCaps())
        /*
        val airportsAdapter =
            RxDataSource<AirportItemBinding, AirportWithCityAndDistance>(R.layout.airport_item, listOf())
        airportsAdapter.bindRecyclerView(chooseAirportRecyclerView)
        airportsAdapter.asObservable().subscribe { holder ->
            val binding = holder.viewDataBinding ?: return@subscribe
            binding.airportName.text = holder.item?.name?.toUpperCase()
            binding.airportIata.text = holder.item?.iata
            binding.airportCity.text = holder.item?.city?.name
            /*binding.airportItemLayout.setOnTouchListener { v, event ->
                println("actual touch")
                false
            }
            */
            binding.airportItemLayout.setOnClickListener {
                println("actual click")
            }
        }.addTo(bag)
        */

        val adapter = AirportsAdapter(listOf())
        chooseAirportRecyclerView.apply {
            this.adapter = adapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.airport.observe(this, Observer { name ->
            val userLocation = viewModel.userLocation.value
            if (userLocation != null) {
                viewModel.getNearestAirports(name, userLocation.latitude, userLocation.longitude)
                    .subscribe { airports ->
                        adapter.airports = airports
                        adapter.notifyDataSetChanged()
                        /*airportsAdapter.updateDataSet(airports)
                        airportsAdapter.updateAdapter()*/
                    }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        bag.clear()
    }
}