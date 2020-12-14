package com.obregon.registroventadeproducto

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ProductosViewModel(application: Application) : AndroidViewModel(application) {

    val allProductoss: LiveData<List<Productos>>
    private val productoDao: ProductosDao

    init{
        val productoDb = ProductosRoomDatabase.getDatabase(application)
        productoDao = productoDb!!.ProductoDao()
        allProductoss = productoDao.allProductoss
    }
    fun insert(producto: Productos){
        InsertAsyncTask(productoDao).execute(producto)
    }

    companion object {
        private class InsertAsyncTask(private val productoDao: ProductosDao): AsyncTask<Productos, Void, Void>(){
            override fun doInBackground(vararg p0: Productos): Void? {
                productoDao.Insert(p0[0])
                return null
            }
        }
    }
}