package com.example.kktvdemo.com.example.kktvdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kktvdemo.com.example.kktvdemo.entity.Artist
import com.example.kktvdemo.databinding.ArtisItemBinding

class ArtistAdapter :
    PagingDataAdapter<Artist, RecyclerView.ViewHolder>(ArtistDataComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ArtistViewHolder(
            ArtisItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        val view = holder as ArtistViewHolder
        item?.let {
            view.bind(it)
        }
    }

    private inner class ArtistViewHolder(private val binding: ArtisItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Artist) = with(binding) {
            Glide.with(root.context).load(item.artistImageUrl).centerCrop().into(ivArtis)
            tvSinger.text = item.name
        }
    }

    object ArtistDataComparator : DiffUtil.ItemCallback<Artist>() {
        override fun areItemsTheSame(oldItem: Artist, newItem: Artist): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Artist, newItem: Artist): Boolean {
            return oldItem == newItem
        }
    }
}
