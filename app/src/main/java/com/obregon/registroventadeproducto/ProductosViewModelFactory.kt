package com.obregon.registroventadeproducto

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProductosViewModelFactory(private val application: Application):ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductosViewModel::class.java)){
            return ProductosViewModel(application) as T
        }
        throw IllegalArgumentException("class ViewModel desconocida")
    }
}