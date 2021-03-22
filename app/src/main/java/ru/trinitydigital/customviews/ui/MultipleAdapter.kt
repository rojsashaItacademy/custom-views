package ru.trinitydigital.customviews.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.trinitydigital.customviews.databinding.*
import ru.trinitydigital.customviews.model.Response

class MultipleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = arrayListOf<Response>()

    fun update(list: List<Response>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            RecyclerTypes.MARKETING.type -> CardsViewHolder.create(parent)
            RecyclerTypes.MENU.type -> TextViewHolder.create(parent)
            RecyclerTypes.SHOPPING.type -> ShoppingViewHolder.create(parent)
            RecyclerTypes.TAGS.type -> TagsViewHolder.create(parent)
            RecyclerTypes.RECIPES.type -> RecipesViewHolder.create(parent)
            else -> TextViewHolder.create(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            RecyclerTypes.MARKETING.type -> (holder as CardsViewHolder).bind(list[position])
            RecyclerTypes.MENU.type -> (holder as TextViewHolder).bind(list[position])
            RecyclerTypes.SHOPPING.type -> (holder as ShoppingViewHolder).bind(list[position])
            RecyclerTypes.TAGS.type -> (holder as TagsViewHolder).bind(list[position])
            RecyclerTypes.RECIPES.type -> (holder as RecipesViewHolder).bind(list[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position].type) {
            RecyclerTypes.MARKETING.typeName -> RecyclerTypes.MARKETING.type
            RecyclerTypes.MENU.typeName -> RecyclerTypes.MENU.type
            RecyclerTypes.SHOPPING.typeName -> RecyclerTypes.SHOPPING.type
            RecyclerTypes.TAGS.typeName -> RecyclerTypes.TAGS.type
            RecyclerTypes.RECIPES.typeName -> RecyclerTypes.RECIPES.type
            else -> RecyclerTypes.MARKETING.type
        }
    }

    override fun getItemCount() = list.size

}


class CardsViewHolder(binding: ItemCardsBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(response: Response) {
    }

    companion object {
        fun create(parent: ViewGroup): CardsViewHolder {
            val binding =
                ItemCardsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return CardsViewHolder(binding)
        }
    }
}

class TextViewHolder(private val binding: ItemTextBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(response: Response) {
        binding.tvTitle.text = response.name
    }

    companion object {
        fun create(parent: ViewGroup): TextViewHolder {
            val binding =
                ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return TextViewHolder(binding)
        }
    }
}

class ShoppingViewHolder(private val binding: ItemShoppingBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(response: Response) {
        binding.tvTitle.text = response.name
    }

    companion object {
        fun create(parent: ViewGroup): ShoppingViewHolder {
            val binding =
                ItemShoppingBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return ShoppingViewHolder(binding)
        }
    }
}


class TagsViewHolder(private val binding: ItemTagsBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(response: Response) {
        binding.tvTitle.text = response.name
    }

    companion object {
        fun create(parent: ViewGroup): TagsViewHolder {
            val binding =
                ItemTagsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return TagsViewHolder(binding)
        }
    }
}

class RecipesViewHolder(private val binding: ItemRecipesBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(response: Response) {
        binding.tvTitle.text = response.name
    }

    companion object {
        fun create(parent: ViewGroup): RecipesViewHolder {
            val binding =
                ItemRecipesBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return RecipesViewHolder(binding)
        }
    }
}