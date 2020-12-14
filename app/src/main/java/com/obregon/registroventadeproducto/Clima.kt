package com.obregon.registroventadeproducto

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_clima.*

class Clima : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clima)

        if (Network.hayRed(this))
        {
            Toast.makeText(this, "No hay Red", Toast.LENGTH_LONG).show()

            solicitudHTTPVolley("https://api.openweathermap.org/data/2.5/weather?id=3616253&appid=800cb27d0a49e5fad421f606bad06f93\n" +
                    "&lang=es&units=metric\n")
        } else{
            Toast.makeText(this, "hay Red", Toast.LENGTH_LONG).show()
        }
    }

    fun solicitudHTTPVolley(url:String)

    {
        val queue = Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET, url,Response.Listener<String> {
                response ->
            try {
                Log.d("ResultadoVolley", response)
                val gson = Gson()
                val ciudad = gson.fromJson(response, Ciudad::class.java)

                val tvgrados:TextView=findViewById(R.id.tvGrados)
                val tvCiudad:TextView=findViewById(R.id.tvCiudad)
                val tvDescripcion:TextView=findViewById(R.id.tvDescipcion)

                tvgrados.text = ciudad.main!!.temp.toString() + "°"
                tvCiudad.text = ciudad.name
                tvDescripcion.text = ciudad.weather!!.get(0).description
            } catch (e:Exception){

            }

        }, Response.ErrorListener {
            Log.e("ErrorVolley","ERROR EXTRA;o")
        })
        queue.add(solicitud)
    }
}