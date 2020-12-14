package com.obregon.registroventadeproducto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productos")
    class Productos(@PrimaryKey
               val id:String,

               @ColumnInfo(name = "precio")
               val precio: String,

                    @ColumnInfo(name = "cantidad")
                    val cantidad: String,


                    val producto:String) {

    }

