package com.example.obbliapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.obbliapp.data.entities.ContentEntity
import com.example.obbliapp.databinding.ItemHomeRecyclerviewBinding



class HomeAdapter (): ListAdapter<ContentEntity,RecyclerView.ViewHolder>(MyDiffCallback()) {
//    private val contentEntity: MutableList<ContentEntity>, private val itemClick: (ContentEntity) -> Unit
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            ItemHomeRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if(holder is ViewHolder) holder.bind(getItem(position))
        val item = getItem(position)
        (holder as ViewHolder).bind(item)
    }


    inner class ViewHolder(private val binding: ItemHomeRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener {
                binding.contentData?.let { item->
                    Toast.makeText(binding.root.context,  "${item.title} 입니다", Toast.LENGTH_SHORT).show()
                }
            }
        }
//        fun bind(contentEntity: ContentEntity) = with(binding) {
//
//            titleText.text = contentEntity.title
//            addressText.text = contentEntity.address
//            distanceText.text = contentEntity.distance
//            needPeopleNumber.text = contentEntity.needPeopleNumber
//
//            itemView.setOnClickListener { itemClick(contentEntity) }
//        }

        fun bind(item: ContentEntity) {
            binding.apply {
                contentData = item
                executePendingBindings()
            }
        }
    }

    private class MyDiffCallback : DiffUtil.ItemCallback<ContentEntity>() {

        override fun areItemsTheSame(oldItem: ContentEntity, newItem: ContentEntity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ContentEntity, newItem: ContentEntity): Boolean {
            return oldItem == newItem
        }
    }
}


