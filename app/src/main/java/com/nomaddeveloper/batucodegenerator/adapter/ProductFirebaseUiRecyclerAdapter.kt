package com.nomaddeveloper.batucodegenerator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.nomaddeveloper.batucodegenerator.R
import com.nomaddeveloper.batucodegenerator.canvas.CanvasToBatuCode
import com.nomaddeveloper.batucodegenerator.model.ProductModel

class ProductFirebaseUiRecyclerAdapter(options: FirebaseRecyclerOptions<ProductModel>) :
    FirebaseRecyclerAdapter<ProductModel, ProductFirebaseUiRecyclerViewHolder>(options) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductFirebaseUiRecyclerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false)
        return ProductFirebaseUiRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ProductFirebaseUiRecyclerViewHolder,
        position: Int,
        model: ProductModel
    ) {
        val canvasToBatuCode = CanvasToBatuCode(model.getProductCode())
        holder.textViewId.text = model.getProductId().toString()
        holder.textViewName.text = model.getProductName()
        holder.textViewPrice.text = model.getProductPrice().toString()
        holder.textViewCode.text = model.getProductCode()
        holder.textViewDecode.text = model.getProductDecode()
        holder.imageViewProductCode.setImageDrawable(canvasToBatuCode)
        Glide.with(holder.itemView)
            .load(model.getProductImage())
            .fitCenter()
            .placeholder(R.drawable.qrcode_placeholder)
            .into(holder.imageViewProduct)
    }
}