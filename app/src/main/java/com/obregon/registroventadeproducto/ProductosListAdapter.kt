package com.obregon.registroventadeproducto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*


class ProductosListAdapter(private val context: Context) : RecyclerView.Adapter<ProductosListAdapter.ProductosViewHolder>() {

    private var productoList: List<Productos> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductosListAdapter.ProductosViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item,parent, false)
        return ProductosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductosListAdapter.ProductosViewHolder, position: Int) {
        val producto = productoList[position]
        holder.setData(producto.producto, producto.precio, producto.cantidad, position)
    }

    override fun getItemCount(): Int = productoList.size

    fun setProductoss(productos: List<Productos>) {
        productoList = productos
        notifyDataSetChanged()
    }

    inner class ProductosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var pos: Int = 0

        fun setData( producto: String, precio: String, Cantidad: String, position: Int){
            itemView.tvproducto.text = producto
            itemView.tvprecio.text = precio
            itemView.tvcantidad.text = Cantidad
            this.pos = position
        }
    }
}