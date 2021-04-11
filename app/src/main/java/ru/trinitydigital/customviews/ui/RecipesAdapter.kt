package ru.trinitydigital.customviews.ui

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import ru.trinitydigital.customviews.databinding.*
import ru.trinitydigital.customviews.model.Recipe

class RecipesAdapter : RecyclerView.Adapter<RecipesVH>() {

    private val list = arrayListOf<Recipe>()

    fun update(list: List<Recipe>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesVH {
        return RecipesVH.create(parent)
    }

    override fun onBindViewHolder(holder: RecipesVH, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

}


class RecipesVH(private val binding: ItemRecipeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(recipe: Recipe) {
        binding.title.text = recipe.name
        Glide.with(binding.root.context).load(recipe.image.url)
            .listener(object : RequestListener<Drawable>{
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.d("dadadad", "adasdasd")
                   return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.d("dadadad", "adasdasd")
                    return false
                }

            })
            .into(binding.image)
    }

    companion object {
        fun create(parent: ViewGroup): RecipesVH {
            val binding =
                ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return RecipesVH(binding)
        }
    }
}