package com.example.product.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.product.domain.model.ProductModel

object ProductsDiffCallBack : DiffUtil.ItemCallback<ProductModel>() {
    override fun areItemsTheSame(
        oldItem: ProductModel,
        newItem: ProductModel
    ): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(
        oldItem: ProductModel,
        newItem: ProductModel
    ): Boolean {
        return oldItem == newItem
    }
}