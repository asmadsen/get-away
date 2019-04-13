package no.asmadsen.getaway


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MapBottomSheet : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.map_bottom_sheet_fragment, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            MapBottomSheet().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
