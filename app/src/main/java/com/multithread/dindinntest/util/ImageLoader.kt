package com.multithread.dindinntest.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import javax.inject.Inject


interface ImageLoader {

    fun loadImage(view: ImageView,
                  placeHolderId: Int,
                  errorPlaceHolderId: Int,
                  imageUrl: String)
}


class ImageLoaderImpl @Inject constructor(): ImageLoader {
    override fun loadImage(
        view: ImageView,
        placeHolderId: Int,
        errorPlaceHolderId: Int,
        imageUrl: String
    ) {
        try {
            loadImageCareLess(
                view,
                placeHolderId,
                errorPlaceHolderId,
                imageUrl
            )
        } catch (error: Exception) {
            error.printStackTrace()
        }
    }

    private fun loadImageCareLess(
        view: ImageView,
        placeHolderId: Int,
        errorPlaceHolderId: Int,
        imageUrl: String
    ) {
        Glide.with(view.context)
            .load(imageUrl).into(view)
    }
}