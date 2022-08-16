package com.example.product.presentation.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.example.product.R

import com.example.product.domain.model.ProductModel
import com.example.product.presentation.extentions.loadImage


class ShowProductDialog(private val context: Context, private val product: ProductModel) {

    fun showDialog() {

        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.description_dialog)

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val productTitle = dialog.findViewById<TextView>(R.id.product_title)
        productTitle.text = product.productTitle

        val productDescription = dialog.findViewById<TextView>(R.id.product_description)
        productDescription.text = product.productDescription

        val productPrice = dialog.findViewById<TextView>(R.id.product_price)
        productPrice.text = product.productPrice

        val productImage = dialog.findViewById<ImageView>(R.id.product_image)
        productImage.loadImage(product.productImages.first())

        dialog.show()
    }
}