package com.example.listacitta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = findViewById<TextView>(R.id.title)
        val skyscrapers = findViewById<TextView>(R.id.grattacieliDesciption)
        val avgTemp = findViewById<TextView>(R.id.temperatureDesciption)
        val avgHumidity = findViewById<TextView>(R.id.umidityDesciption)
        val population = findViewById<TextView>(R.id.populationDesciption)
        val country = findViewById<TextView>(R.id.nationDesciption)
        val image = findViewById<ImageView>(R.id.imageView)

        title.text = intent.getStringExtra("Nome citta")
        skyscrapers.text = intent.getIntExtra("Numero grattacieli", 0).toString()
        avgTemp.text = intent.getDoubleExtra("Temperatura media annua", 0.0).toString()
        avgHumidity.text = intent.getDoubleExtra("Umidita media", 0.0).toString()
        population.text = intent.getIntExtra("Popolazione", 0).toString()
        country.text = intent.getStringExtra("Nazione")


    }
}