package com.example.homework5


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CapAdapter(private var images: List<AppCap>, private val onClick: (AppCap) -> Unit)
    : RecyclerView.Adapter<CapAdapter.CapViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CapViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_image_cap, parent, false)
        return CapViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: CapViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int = images.size

    class CapViewHolder(
            view: View,
            private val onClick: (AppCap) -> Unit
    ) : RecyclerView.ViewHolder(view) {
        private var root: View = view.findViewById(R.id.cap_image)

        fun bind(image: AppCap) {
            root.setBackgroundResource(image.image)
            root.setOnClickListener {
                onClick(image)
            }
        }
    }
}