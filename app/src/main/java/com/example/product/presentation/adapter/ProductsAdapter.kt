package com.example.product.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.product.presentation.listener.ProductItemClickListener
import com.example.product.databinding.ItemProductBinding


class ProductsAdapter(
    private val productItemClickListener: ProductItemClickListener
) : RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {

    inner class MyViewHolder(
        val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root)

    private var _binding: ItemProductBinding? = null

    val diff = AsyncListDiffer(this, ProductsDiffCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        _binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(_binding!!)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentData = diff.currentList[position]

        holder.binding.productTitle.text = currentData.productTitle
        holder.binding.productDescription.text = currentData.productDescription
        holder.binding.productPrice.text = currentData.productPrice

        holder.binding.productCard.setOnClickListener {
            productItemClickListener.onProductItemClicked(currentData)
        }
    }

    override fun getItemCount(): Int = diff.currentList.size
}