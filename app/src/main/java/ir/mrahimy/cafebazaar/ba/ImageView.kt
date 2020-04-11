package ir.mrahimy.cafebazaar.ba

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import ir.mrahimy.cafebazaar.ktx.loadUrl

@BindingAdapter("image")
fun ImageView.setImageUrl(url: String?) {
    loadUrl(url)
}