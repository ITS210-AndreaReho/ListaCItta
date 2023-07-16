package com.example.listacitta

import City
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CityAdapter(private val mList: List< City >) : RecyclerView.Adapter<CityAdapter.CityViewHolder>(){
    class CityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nomeCitta: TextView = view.findViewById(R.id.cityName)
        val image: ImageView = view.findViewById(R.id.cityImage)
        val intent: Intent = Intent(view.context, Detail::class.java)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val city = LayoutInflater.from(parent.context).inflate(R.layout.city_item, parent, false)
        return CityViewHolder(city)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = mList[position]
        holder.nomeCitta.text = city.name
        Picasso.get().load("https://picsum.photos/seed/picsum/200").into(holder.image);

        holder.itemView.setOnClickListener {
            holder.intent.putExtra("Nome citta", city.name)
            holder.intent.putExtra("Numero grattacieli", city.skyscrapers)
            holder.intent.putExtra("Temperatura media annua", city.avgTemp)
            holder.intent.putExtra("Umidita media", city.avgHumidity)
            holder.intent.putExtra("Popolazione", city.population)
            holder.intent.putExtra("Nazione", city.country)

            holder.image.context.startActivity(holder.intent)

        }
    }


}