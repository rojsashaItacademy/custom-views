package ru.trinitydigital.customviews.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.trinitydigital.customviews.databinding.*
import ru.trinitydigital.customviews.model.Response
import ru.trinitydigital.customviews.ui.RecyclerTypes.*

class MultipleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = arrayListOf<Response>()

    fun update(list: List<Response>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            MARKETING.type -> CardsViewHolder.create(parent)
            MENU.type -> TextViewHolder.create(parent)
            SHOPPING.type -> ShoppingViewHolder.create(parent)
            TAGS.type -> TagsViewHolder.create(parent)
            RECIPES.type -> RecipesViewHolder.create(parent)
            else -> TextViewHolder.create(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            MARKETING.type -> (holder as CardsViewHolder).bind(list[position])
            MENU.type -> (holder as TextViewHolder).bind(list[position])
            SHOPPING.type -> (holder as ShoppingViewHolder).bind(list[position])
            TAGS.type -> (holder as TagsViewHolder).bind(list[position])
            RECIPES.type -> (holder as RecipesViewHolder).bind(list[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position].type) {
            MARKETING.typeName -> MARKETING.type
            MENU.typeName -> MENU.type
            SHOPPING.typeName -> SHOPPING.type
            TAGS.typeName -> TAGS.type
            RECIPES.typeName -> RECIPES.type
            else -> MARKETING.type
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

class ShoppingViewHolder(private val binding: ItemShoppingBinding) :
    RecyclerView.ViewHolder(binding.root) {
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

class RecipesViewHolder(private val binding: ItemRecipesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val adapter by lazy { RecipesAdapter() }

    init {
        binding.favoritesRv.adapter = adapter
    }

    fun bind(response: Response) {
        binding.favoritesTitle.text = response.name
        adapter.update(response.recipes)
        response.recipes
    }

    companion object {
        fun create(parent: ViewGroup): RecipesViewHolder {
            val binding =
                ItemRecipesBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return RecipesViewHolder(binding)
        }
    }
}