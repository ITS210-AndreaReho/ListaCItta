package com.example.listacitta

import City
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val reciclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val button1 = findViewById<android.widget.Button>(R.id.button)
        val button2 = findViewById<android.widget.Button>(R.id.button2)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        button1.setOnClickListener {
        //   reciclerView.layoutManager = androidx.recyclerview.widget.GridLayoutManager(this , 2)
            onSNACK(it, "Snack Bar")

        }
        button2.setOnClickListener {
        //    reciclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)


           // onSNACK(it, "Flexbox Layout")
        }

        val jsonString = getJsonDataFromAsset(applicationContext, "city.json")

        val gson = Gson()



        val listCity = gson.fromJson(jsonString, object : TypeToken<List<City>>() {}.type) as List<City>



        Log.d("MainActivityList", "list: $listCity")
        val adapter = CityAdapter(listCity)

        reciclerView.adapter = adapter
        reciclerView.layoutManager = androidx.recyclerview.widget.GridLayoutManager(this , 2, androidx.recyclerview.widget.GridLayoutManager.VERTICAL, false)


    }
}

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}

fun onSNACK(view: View, message: String){
    //Snackbar(view)
    val snackbar = Snackbar.make(view, message,
        Snackbar.LENGTH_LONG).setAction("Action", null)
    snackbar.setActionTextColor(Color.BLUE)
    val snackbarView = snackbar.view
    snackbarView.setBackgroundColor(Color.LTGRAY)
    val textView =
        snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
    textView.setTextColor(Color.BLUE)
    textView.textSize = 28f
    snackbar.show()
}