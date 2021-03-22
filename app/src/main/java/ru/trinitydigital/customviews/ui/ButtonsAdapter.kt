package ru.trinitydigital.customviews.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.trinitydigital.customviews.databinding.ItemButtonsBinding

class ButtonsAdapter(private val listener: (selected: Int, lastSelected: Int) -> Unit) :
    RecyclerView.Adapter<ButtonsVH>() {
    private val list = arrayListOf<ButtonsData>()
    private var lastSelected = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonsVH {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemPersonBinding = ItemButtonsBinding.inflate(layoutInflater, parent, false)
        return ButtonsVH(itemPersonBinding)
    }

    fun update(list: ArrayList<ButtonsData>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ButtonsVH, position: Int) {
        holder.bind(list[position])
        holder.binding.tvTitle.setOnClickListener {
            if (lastSelected != position) {
                listener.invoke(position, lastSelected)
                lastSelected = position
            }
        }
    }

    override fun getItemCount() = list.size
}


class ButtonsVH(val binding: ItemButtonsBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(buttonsData: ButtonsData) {
        binding.tvTitle.text = buttonsData.title
        binding.tvTitle.isSelected = buttonsData.selected

    }
}