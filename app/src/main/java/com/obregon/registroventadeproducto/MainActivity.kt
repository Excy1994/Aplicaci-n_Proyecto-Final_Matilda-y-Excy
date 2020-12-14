package com.obregon.registroventadeproducto

<<<<<<< HEAD
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_new_productos.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var productoViewModel: ProductosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productoListAdapter = ProductosListAdapter(this)
        recyclerview.adapter = productoListAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)

        Fab.setOnClickListener{
            val intent = Intent(this, NewProductosActivity:: class.java)
            startActivityForResult(intent, NEW_NOTE_ACTIVITY_REQUEST_CODE)
        }

        productoViewModel = ViewModelProvider(this, ProductosViewModelFactory(application))[ProductosViewModel::class.java]
        productoViewModel.allProductoss.observe(this, androidx.lifecycle.Observer { productos ->
            productos?.let {
                productoListAdapter.setProductoss(productos)
            }

        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == NEW_NOTE_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val id = UUID.randomUUID().toString()
            val etProductoNombre = data!!.getStringExtra(NewProductosActivity.NEW_PRODUCTO)!!
            val etCantidadProduct = data.getStringExtra(NewProductosActivity.NEW_PRECIO)!!
            val etprecio = data.getStringExtra(NewProductosActivity.NEW_CANTIDAD)!!

            val producto = Productos(id, etProductoNombre, etCantidadProduct, etprecio)
            productoViewModel.insert(producto)
            Toast.makeText(
                applicationContext,
                R.string.saved,
                Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(
                applicationContext,
                R.string.not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    companion object {
        private const val NEW_NOTE_ACTIVITY_REQUEST_CODE = 1
=======
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlin.properties.Delegates



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun lanzarClima(view: View) {

        val intent = Intent(this, Clima::class.java)
        startActivity(intent)
>>>>>>> 4389a9fab35b2a71912eab9a712554b164b4e64a
    }
}