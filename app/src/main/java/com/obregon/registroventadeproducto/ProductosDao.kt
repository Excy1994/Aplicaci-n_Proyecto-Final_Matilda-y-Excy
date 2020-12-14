package com.obregon.registroventadeproducto

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductosDao {

    @Insert
    fun Insert(producto: Productos)

    @get:Query("SELECT * FROM productos")
    val allProductoss: LiveData<List<Productos>>

}