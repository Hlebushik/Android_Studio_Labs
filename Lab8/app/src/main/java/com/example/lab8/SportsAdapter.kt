package com.example.lab8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab8.databinding.RecycleViewBinding


class SportsAdapter (private val items: List<Pair<String, String?>>,
                  private val onItemClick: (position: Int) -> Unit):
    RecyclerView.Adapter<SportsAdapter.SportsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsHolder {
        val binding = RecycleViewBinding.inflate(LayoutInflater.from(parent.context))
        return SportsHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: SportsHolder, position: Int) {
        val sportsName = items[position]
        holder.bind(sportsName.first, sportsName.second)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // Holds the views for adding it to image and text
    class SportsHolder(private val binding: RecycleViewBinding,
                    private val onItemClick: (position: Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.buttonSports.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(sportsName: String, imageUrl: String?) {
            Glide.with(binding.imageView)
                .load(imageUrl)
                .centerCrop()
                .placeholder(binding.imageView.drawable)
                .error(R.drawable.ic_launcher_background)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(binding.imageView)
            binding.buttonSports.text = sportsName
        }
    }
}