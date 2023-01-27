package com.example.favcartoons

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class PhotosAdaptor(var cartoonData: Array<CartoonData>, activity: MainActivity) :
    RecyclerView.Adapter<PhotosAdaptor.ViewHolder>() {
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
            layoutInflater.inflate(R.layout.horizontal_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cartoonDataList = cartoonData[position]
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

        init {
            cartoonImage = itemView.findViewById(R.id.imageview)
        }
    }
}