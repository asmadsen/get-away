package no.asmadsen.getaway

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.map_bottom_sheet_fragment.*
import no.asmadsen.getaway.services.FlickrService
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class Map : Fragment() {

    companion object {
        fun newInstance() = Map()
    }

    private lateinit var viewModel: MapViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.map_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MapViewModel::class.java)
        val mapFragment = childFragmentManager.findFragmentById(R.id.frg) as SupportMapFragment

        val bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)

        mapFragment.getMapAsync {
            it.mapType = GoogleMap.MAP_TYPE_NORMAL

            val googlePlex = CameraPosition.builder()
                .target(LatLng(59.8939529,10.6450354))
                .zoom(10f)
                .build()

            it.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 1000, null)

            it.setOnMapClickListener {
                doAsync {
                    FlickrService(context!!.applicationContext).fetchPhotosByLocation(it.latitude, it.longitude) { photos ->
                        photos.forEach {
                            Log.d("photos", "${it.title}")
                        }
                    }
                    val nearest = viewModel.getNearest(it.latitude, it.longitude)
                    val string = nearest.fold("Clicked - ${it.latitude},${it.longitude}") { acc, it ->
                        return@fold "$acc\n${it.name}"
                    }
                    uiThread {
                        if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                        }
                        editTest.text = string
                    }
                }
            }

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            2 -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    if (ContextCompat.checkSelfPermission(
                            activity!!,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) != PackageManager.PERMISSION_GRANTED) {
                    } else {
                        val locationManager =
                            ContextCompat.getSystemService(context!!.applicationContext, LocationManager::class.java)

                        locationManager?.let {
                            val location = it.getLastKnownLocation(LocationManager.GPS_PROVIDER)

                            Log.d("Location", location.toString())

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

}
