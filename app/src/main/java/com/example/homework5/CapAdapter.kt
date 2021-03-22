package com.example.homework5


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CapAdapter(private var images: List<Int>, private val context: Context)
    : RecyclerView.Adapter<CapAdapter.CapViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CapViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_image_cap, parent, false)
        return CapViewHolder(view)
    }

    override fun onBindViewHolder(holder: CapViewHolder, position: Int) {
        holder.bind(images[position], context)
    }

    override fun getItemCount(): Int = images.size

    class CapViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var root: View = view.findViewById(R.id.cap_image)

        fun bind(image:Int, context: Context) {
            root.setBackgroundResource(image)
            root.setOnClickListener {
                val i = Intent(context, ChosenPhotoActivity::class.java).apply {
                    putExtra("photo", image)
                }
                context.startActivity(i)
            }
        }
    }
}