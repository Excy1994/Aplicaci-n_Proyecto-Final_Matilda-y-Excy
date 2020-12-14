package com.obregon.registroventadeproducto

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Productos::class], version = 1)
abstract class ProductosRoomDatabase: RoomDatabase() {
    abstract fun ProductoDao(): ProductosDao
    companion object {
        private var productoRoomInstance: ProductosRoomDatabase? = null

        fun getDatabase (context: Context): ProductosRoomDatabase? {
            if (productoRoomInstance == null){
                synchronized(ProductosRoomDatabase::class.java){
                    if (productoRoomInstance == null){
                        productoRoomInstance = Room.databaseBuilder<ProductosRoomDatabase>(context.applicationContext,
                            ProductosRoomDatabase::class.java, "Productos_database")
                            .build()
                    }
                }
            }
            return productoRoomInstance
        }
    }
}