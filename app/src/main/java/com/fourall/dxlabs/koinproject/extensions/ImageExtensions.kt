package com.fourall.dxlabs.koinproject.extensions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(url: String?, error: Drawable) {
    Glide.with(this.context)
        .load(url)
        .apply(RequestOptions.centerCropTransform().error(error).diskCacheStrategy(DiskCacheStrategy.ALL))
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}