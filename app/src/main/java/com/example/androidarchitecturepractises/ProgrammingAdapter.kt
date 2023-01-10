package com.example.androidarchitecturepractises

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/// we generally extends RecyclerViewAdapter here, but here we will use
/// ListAdapter, to calculate the difference in between lists
class ProgrammingAdapter: ListAdapter<ProgrammingItem, ProgrammingAdapter.ProgrammingViewHolder>(DiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ProgrammingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ProgrammingViewHolder(view: View): RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.name)
        val initial = view.findViewById<TextView>(R.id.initial)

        fun bind(item: ProgrammingItem){
            name.text = item.name
            initial.text = item.initial
        }

    }

    class DiffUtil: androidx.recyclerview.widget.DiffUtil.ItemCallback<ProgrammingItem>() {

        /// use of areItemsTheSame and areContentsTheSame
        /// https://stackoverflow.com/a/72178459/15166812

        /// this function will be used to check if two items are same or not
        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            return oldItem.id == newItem.id
        }

        /// this function will be used to check if the content of two items are same or not
        override fun areContentsTheSame(
            oldItem: ProgrammingItem,
            newItem: ProgrammingItem
        ): Boolean {
            /// as data classes internally have comparison operator (==) overriden, so we don't need to do that manually
            return oldItem == newItem
        }

    }

}