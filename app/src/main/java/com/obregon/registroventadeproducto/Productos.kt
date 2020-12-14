package com.android.registroventadeproducto

<<<<<<< HEAD
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
=======
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.obregon.registroventadeproducto.R
>>>>>>> 4389a9fab35b2a71912eab9a712554b164b4e64a

    }

