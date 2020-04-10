package ir.mrahimy.cafebazaar.ba

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ir.mrahimy.cafebazaar.base.BaseAdapter

@BindingAdapter("data")
fun <T> RecyclerView.setData(data: MutableList<T>?) {
    if (adapter is BaseAdapter<*>) {
        (adapter as BaseAdapter<T>).submitList(data)
    }
}