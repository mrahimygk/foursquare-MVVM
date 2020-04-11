package ir.mrahimy.cafebazaar.ktx

import android.graphics.drawable.Drawable
import android.widget.ImageView
import ir.mrahimy.cafebazaar.application.GlideApp

fun ImageView.loadUrl(
    url: String?,
    placeholder: Drawable? = null
) {
    GlideApp
        .with(this.context)
        .load(url)
        .into(this)
}