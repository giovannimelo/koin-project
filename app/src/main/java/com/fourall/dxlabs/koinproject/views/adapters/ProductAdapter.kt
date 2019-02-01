package com.fourall.dxlabs.koinproject.views.adapters

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fourall.dxlabs.koinproject.R
import com.fourall.dxlabs.koinproject.extensions.loadImage
import com.fourall.dxlabs.koinproject.models.Product
import kotlinx.android.synthetic.main.item_activity_main.view.*

class ProductAdapter(private var products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_activity_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemView = holder.itemView
        val context = holder.itemView.context
        val product = products[position]

        itemView.tvPurchaseDate.text = product.timestamp
        itemView.tvItemProductPrice.text = product.price
        itemView.tvItemProductTitle.text = product.title
        itemView.tvItemProductQuantity.text = product.quantity

        itemView.ivItemProductThumb.loadImage(
            product.thumb,
            ContextCompat.getDrawable(context, R.drawable.shape_image_radius)!!
        )
    }

    override fun getItemCount() = products.size

    fun updateList(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}