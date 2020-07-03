package com.example.navdemo.fragmentC

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.navdemo.R
import com.example.navdemo.databinding.ItemDummyBinding

typealias OnItemClickListener = () -> Unit

class DummyAdapter : RecyclerView.Adapter<DummyAdapter.DummyViewHolder>() {

    private var dummies = listOf<Dummy>()
    var onItemClickListener: OnItemClickListener? = null

    fun setDummies(newDummies: List<Dummy>) {
        dummies = newDummies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DummyViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_dummy,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = dummies.size

    override fun onBindViewHolder(holder: DummyViewHolder, position: Int) {
        onItemClickListener?.let {
            holder.bind(dummies[position], it)
        }
    }

    class DummyViewHolder(private val binding: ItemDummyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dummyItem: Dummy, onItemClickListener: OnItemClickListener) {
            binding.dummy = dummyItem
            binding.root.setOnClickListener { onItemClickListener.invoke() }
        }
    }
}