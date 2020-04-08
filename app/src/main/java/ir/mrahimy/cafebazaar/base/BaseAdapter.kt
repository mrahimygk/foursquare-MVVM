package ir.mrahimy.cafebazaar.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ir.mrahimy.cafebazaar.BR

abstract class BaseAdapter<T>(diff: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, BaseAdapter<T>.DataBindingViewHolder>(diff) {

    var onClick: ((item: T, view: View) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder {
        return DataBindingViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                viewType,
                parent,
                false
            )
        )
    }

    override fun submitList(list: MutableList<T>?) {
        super.submitList(if (list != null) ArrayList<T>(list).toMutableList() else null)
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder, position: Int) =
        holder.bind(getItem(position))

    abstract override fun getItemViewType(position: Int): Int

    inner class DataBindingViewHolder(
        private val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: T) {
            binding.apply {
                setVariable(BR.item, item)
                executePendingBindings()
                root.apply {
                    setOnClickListener {
                        onClick?.invoke(item, this)
                    }
                }
            }
        }
    }
}