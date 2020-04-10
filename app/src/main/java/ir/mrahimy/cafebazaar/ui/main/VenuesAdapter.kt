package ir.mrahimy.cafebazaar.ui.main

import androidx.recyclerview.widget.DiffUtil
import ir.mrahimy.cafebazaar.R
import ir.mrahimy.cafebazaar.base.BaseAdapter
import ir.mrahimy.cafebazaar.data.dataclass.Venue

class VenuesAdapter : BaseAdapter<Venue>(DIFF) {

    override fun getItemViewType(position: Int) = R.layout.item_venue


    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<Venue>() {
            override fun areItemsTheSame(oldItem: Venue, newItem: Venue) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Venue, newItem: Venue) =
                oldItem == newItem
        }
    }
}