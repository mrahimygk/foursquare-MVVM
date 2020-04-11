package ir.mrahimy.cafebazaar.ktx

import android.widget.ImageView
import ir.mrahimy.cafebazaar.application.GlideApp

fun ImageView.loadUrl(
    url: String?
) {
    GlideApp
        .with(this)
        .load(url)
        .into(this)
}