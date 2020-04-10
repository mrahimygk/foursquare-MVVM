package ir.mrahimy.cafebazaar.util

import android.os.Handler
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

abstract class PagedRecyclerViewScrollListener(
    layoutManager: RecyclerView.LayoutManager,
    private val startingPage: Int = STARTING_PAGE_INDEX,
    visibleThreshold: Int = 2
) : RecyclerView.OnScrollListener() {

    private var visibleThreshold = 2

    private var currentPage = startingPage

    private var previousTotalItemCount = 0

    private var isLoading = true

    private var alreadyDecreasedPageForFailure = false

    abstract fun onLoadMore(page: Int)

    private var mLayoutManager: RecyclerView.LayoutManager = layoutManager

    init {
        when (layoutManager) {
            is LinearLayoutManager ->
                this.visibleThreshold = visibleThreshold
            is GridLayoutManager ->
                this.visibleThreshold = visibleThreshold * layoutManager.spanCount
            is StaggeredGridLayoutManager ->
                this.visibleThreshold = visibleThreshold * layoutManager.spanCount
        }
    }

    private fun getLastVisibleItem(lastVisibleItemPositions: IntArray): Int {
        var maxSize = 0
        for (i in lastVisibleItemPositions.indices) {
            if (i == 0) {
                maxSize = lastVisibleItemPositions[i]
            } else if (lastVisibleItemPositions[i] > maxSize) {
                maxSize = lastVisibleItemPositions[i]
            }
        }
        return maxSize
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        var lastVisibleItemPosition = 0
        val totalItemCount = mLayoutManager.itemCount

        when (mLayoutManager) {
            is StaggeredGridLayoutManager -> {
                val lastVisibleItemPositions =
                    (mLayoutManager as StaggeredGridLayoutManager).findLastVisibleItemPositions(null)
                lastVisibleItemPosition = getLastVisibleItem(lastVisibleItemPositions)
            }
            is GridLayoutManager -> lastVisibleItemPosition =
                (mLayoutManager as GridLayoutManager).findLastVisibleItemPosition()
            is LinearLayoutManager -> lastVisibleItemPosition =
                (mLayoutManager as LinearLayoutManager).findLastVisibleItemPosition()
        }



        if (isLoading && totalItemCount > previousTotalItemCount) {
            isLoading = false
            previousTotalItemCount = totalItemCount
        }

        if (!isLoading && lastVisibleItemPosition + visibleThreshold > totalItemCount) {
            onLoadMore(++currentPage)
            alreadyDecreasedPageForFailure = false
            isLoading = true
        }
    }

    @Suppress("unused")
    fun resetState() {
        currentPage = startingPage
        previousTotalItemCount = 0
        isLoading = true
        scrollToTop()
    }

    fun failed() {
        Handler().postDelayed({
            isLoading = false
        }, 1000)
        if (!alreadyDecreasedPageForFailure) {
            currentPage--
            alreadyDecreasedPageForFailure = true
        }
    }

    private fun scrollToTop() {
        when (mLayoutManager) {
            is LinearLayoutManager ->
                (mLayoutManager as LinearLayoutManager).scrollToPositionWithOffset(0, 0)
            is GridLayoutManager ->
                (mLayoutManager as GridLayoutManager).scrollToPositionWithOffset(0, 0)
            is StaggeredGridLayoutManager ->
                (mLayoutManager as StaggeredGridLayoutManager).scrollToPositionWithOffset(0, 0)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
}