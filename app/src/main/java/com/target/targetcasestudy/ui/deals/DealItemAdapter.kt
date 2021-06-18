package com.target.targetcasestudy.ui.deals

import android.view.LayoutInflater
import android.view.ViewGroup
import com.target.targetcasestudy.data.models.Product
import com.target.targetcasestudy.databinding.ItemDealBinding
import com.target.targetcasestudy.ui.base.BaseRecyclerViewAdapter
import com.target.targetcasestudy.ui.utils.loadImage

class DealItemAdapter : BaseRecyclerViewAdapter<Product, ItemDealBinding>() {
    override fun getItemLayout(parent: ViewGroup) = ItemDealBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )

    override fun onBindViewHolder(
        holder: Companion.BaseViewHolder<ItemDealBinding>,
        position: Int
    ) {
        val product = items[position]
        with(holder.binding) {
            imageView.loadImage(product.image_url)
            textViewTitle.text = product.title
            textViewOption.text = product.aisle
            textViewPrice.text =
                product.sale_price?.display_string ?: product.regular_price.display_string
            root.setOnClickListener {
                itemClickListener?.invoke(root, product, position)
            }
        }
    }
}