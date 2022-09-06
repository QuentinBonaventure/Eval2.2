package com.technifutur.neopixl.eval22

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.technifutur.neopixl.eval22.databinding.CustomRowBinding

class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    var products: List<Product> = listOf()

    fun refreshProducts(products: List<Product>){
        this.products = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val binding = CustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ProductHolder(val binding: CustomRowBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(product: Product){
        binding.cellulTitle.text = product.name
        binding.cellulQuantit.text = product.quantité
        val drawable = ResourcesCompat.getDrawable(
            binding.root.context.resources, product.image, null
        )
        binding.logoImageView.setImageDrawable(drawable)
    }
    }
}