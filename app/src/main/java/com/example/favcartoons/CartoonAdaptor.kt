package com.example.favcartoons

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import android.widget.TextView

class CartoonAdaptor(var cartoonData: Array<CartoonData>, activity: MainActivity) :
    RecyclerView.Adapter<CartoonAdaptor.ViewHolder>() {
    var context: Context

    init {
        context = activity
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =
            layoutInflater.inflate(R.layout.cartoon_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cartoonDataList = cartoonData[position]
        holder.cartoonName.text = cartoonDataList.cartoonName
        holder.cartoonDiscription.text = cartoonDataList.cartoonDescription
        holder.cartoonImage.setImageResource(cartoonDataList.cartoonImage)
        holder.itemView.setOnClickListener {
            Toast.makeText(
                context,
                cartoonDataList.cartoonName,
                Toast.LENGTH_SHORT
            )?.show()
        }
    }

    override fun getItemCount(): Int {
        return cartoonData.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cartoonImage: ImageView
        var cartoonName: TextView
        var cartoonDiscription: TextView

        init {
            cartoonImage = itemView.findViewById(R.id.imageview)
            cartoonName = itemView.findViewById(R.id.name)
            cartoonDiscription = itemView.findViewById(R.id.discription)
        }
    }
}