package com.nomaddeveloper.batucodegenerator.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nomaddeveloper.batucodegenerator.R

class ProductFirebaseUiRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textViewId: TextView = itemView.findViewById(R.id.textViewItem_id)
    val textViewName: TextView = itemView.findViewById(R.id.textViewItem_name)
    val textViewPrice: TextView = itemView.findViewById(R.id.textViewItem_price)
    val imageViewProductCode: ImageView = itemView.findViewById(R.id.image_view_code)
    val textViewCode: TextView = itemView.findViewById(R.id.textViewItem_code)
    val textViewDecode: TextView = itemView.findViewById(R.id.textViewItem_decode)
    val imageViewProduct: ImageView = itemView.findViewById(R.id.image_view_product_image)
}