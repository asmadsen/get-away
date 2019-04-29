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
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.landing_fragment.*
import no.asmadsen.getaway.databinding.LandingFragmentBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class Landing : Fragment() {

    private val viewModel: ApplicationViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        android.R.color.transparent
        val binding =
            DataBindingUtil.inflate<LandingFragmentBinding>(inflater, R.layout.landing_fragment, container, false)
        binding.lifecycleOwner = this
        binding.airport = viewModel.airport
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.btn_point_on_map.setOnClickListener {
            if (viewModel.airport.value == null) {
                Snackbar.make(view, resources.getString(R.string.explain_missing_airport), Snackbar.LENGTH_LONG)
                    .setAction(R.string.tell_me_more) {
                        setSelectedAirportToLatestKnownLocation()
                    }
                    .show()
                return@setOnClickListener
            }
            findNavController().navigate(R.id.action_landing_to_map)
        }

        setSelectedAirportToLatestKnownLocation()

        chooseAirportView.setOnClickListener {
            val extras = FragmentNavigatorExtras(
                chooseAirportView to "chooseAirportView"
            )
            findNavController().navigate(R.id.action_landing_to_chooseAirport, null, null, extras)
        }
    }

    private fun setSelectedAirportToLatestKnownLocation() {
        if (checkSelfPermission(
                activity!!,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
                banner.setLeftButtonListener { it.dismiss() }
                banner.setRightButtonListener {
                    requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_FINE_LOCATION)
                    it.dismiss()
                }
                banner.show()
            } else {
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_FINE_LOCATION)
            }
        } else {
            val locationManager = getSystemService(context!!.applicationContext, LocationManager::class.java)

            locationManager?.let {
                val location = it.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                viewModel.userLocation.postValue(location)
                if (viewModel.airport.value == null) {
                    viewModel.getNearestAirport(location.latitude, location.longitude).subscribe { airport ->
                        viewModel.airport.postValue(airport)
                    }
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_FINE_LOCATION -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    if (checkSelfPermission(
                            activity!!,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                    } else {
                        setSelectedAirportToLatestKnownLocation()
                    }
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
