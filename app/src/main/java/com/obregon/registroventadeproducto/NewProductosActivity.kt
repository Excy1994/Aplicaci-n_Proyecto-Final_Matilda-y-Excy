package com.obregon.registroventadeproducto

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import kotlinx.android.synthetic.main.activity_new_productos.*

class NewProductosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_productos)
        btAdd.setOnClickListener {
            val resultIntent = Intent()

            if (TextUtils.isEmpty(etProductoNombre.text) || TextUtils.isEmpty(etCantidadProduct.text) || TextUtils.isEmpty(etprecio.text)){
                setResult(Activity.RESULT_CANCELED, resultIntent)
            } else {
                val Producto = etProductoNombre.text.toString()
                val precio= etCantidadProduct.text.toString()
                val Cantidad = etCantidadProduct.text.toString()

                resultIntent.putExtra(NEW_PRODUCTO, Producto)
                resultIntent.putExtra(NEW_PRECIO, precio )
                resultIntent.putExtra(NEW_CANTIDAD, Cantidad )

                setResult(Activity.RESULT_OK, resultIntent)
            }
            finish()
        }
    }


    companion object {
        const val NEW_PRODUCTO = "new_Producto"
        const val NEW_PRECIO = "new_Precio"
        const val NEW_CANTIDAD = "new_Cantidad"
    }

        
    
}