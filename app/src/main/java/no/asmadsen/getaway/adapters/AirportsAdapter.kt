package no.asmadsen.getaway.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.airport_tmp.view.*
import no.asmadsen.getaway.R
import no.asmadsen.getaway.room.entities.AirportWithCityAndDistance

class AirportsAdapter(var airports : List<AirportWithCityAndDistance>) : RecyclerView.Adapter<AirportsAdapter.ViewHolder>() {
    private val mOnClickListener: View.OnClickListener = View.OnClickListener { v ->
        val destinationId = ViewHolder(v).airportName.text.toString()
        println(destinationId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val airportView = inflater.inflate(R.layout.airport_tmp, parent, false)

        return ViewHolder(airportView)
    }

    override fun getItemCount() = airports.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val airport = airports[position]

        holder.airportName.text = airport.name
        holder.airportCity.text = airport.city.name
        holder.airportIata.text = airport.iata
    }


    inner class ViewHolder(val mView : View) : RecyclerView.ViewHolder(mView) {
        val airportName = mView.airportName
        val airportIata = mView.airportIata
        val airportCity = mView.airportCity

        init {
            itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val position = adapterPosition
                    println("clicked $position")
                }
            })
        }
    }
}