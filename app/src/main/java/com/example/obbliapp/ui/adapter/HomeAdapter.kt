package com.example.obbliapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.obbliapp.data.entities.ContentEntity
import com.example.obbliapp.databinding.ItemHomeRecyclerviewBinding
import com.example.obbliapp.ui.viewModel.ContentViewModel


class HomeAdapter(private val viewModel : ContentViewModel) : ListAdapter<ContentEntity,RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            ItemHomeRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as ViewHolder).bind(item)

        holder.itemView.setOnLongClickListener {
            viewModel.deleteContent(item.id)
            viewModel.getContent()
            true
        }
    }

    inner class ViewHolder(private val binding: ItemHomeRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener {
                binding.contentData?.let { item->
                    Toast.makeText(binding.root.context,  "${item.title} 입니다", Toast.LENGTH_SHORT).show()
                }
            }
        }
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


