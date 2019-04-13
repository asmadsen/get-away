package no.asmadsen.getaway

import android.Manifest
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.landing_fragment.*
import kotlinx.android.synthetic.main.view_choose_airport.*
import no.asmadsen.getaway.databinding.LandingFragmentBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class Landing : Fragment() {

    companion object {
        fun newInstance() = Landing()
    }

    val viewModel: ApplicationViewModel by sharedViewModel()

    val chooseYourAirportCollapsed = MutableLiveData<Boolean>().apply { value = true }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        android.R.color.transparent
        val binding =
            DataBindingUtil.inflate<LandingFragmentBinding>(inflater, R.layout.landing_fragment, container, false)
        binding.lifecycleOwner = this
        binding.airportName = viewModel.airport
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.btn_point_on_map.setOnClickListener {
            findNavController().navigate(R.id.action_landing_to_map)
        }

        if (checkSelfPermission(
                activity!!,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 2)
        } else {
            val locationManager = getSystemService(context!!.applicationContext, LocationManager::class.java)

            locationManager?.let {
                val location = it.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                viewModel.userLocation.postValue(location)
            }
        }

        editTextYourAirport.setOnTouchListener { _, event ->
            chooseAirportView.onTouchEvent(event)
            false
        }

        chooseAirportView.setOnClickListener {
            val extras = FragmentNavigatorExtras(
                chooseAirportView to "chooseAirportView"
            )
            findNavController().navigate(R.id.action_landing_to_chooseAirport, null, null, extras)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            2 -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    if (checkSelfPermission(
                            activity!!,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                    } else {
                        val locationManager =
                            getSystemService(context!!.applicationContext, LocationManager::class.java)

                        locationManager?.let {
                            val location = it.getLastKnownLocation(LocationManager.GPS_PROVIDER)

                            viewModel.userLocation.postValue(location)
                        }
                    }
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}
