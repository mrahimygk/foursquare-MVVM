package ir.mrahimy.cafebazaar.ui.main

import ir.mrahimy.cafebazaar.R
import ir.mrahimy.cafebazaar.base.BaseActivity
import ir.mrahimy.cafebazaar.databinding.ActivityMainBinding
import ir.mrahimy.cafebazaar.helper.EventObserver
import ir.mrahimy.cafebazaar.ui.details.DetailsActivity
import ir.mrahimy.cafebazaar.util.PagedRecyclerViewScrollListener
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val layoutRes = R.layout.activity_main

    override val vm: MainViewModel by viewModel()

    private val perPageLimit = 10
    private val venuesAdapter: VenuesAdapter by inject()
    override fun bindObservables() {
        vm.onStartDetailsActivity.observe(this, EventObserver {
            DetailsActivity.startMe(this, it)
        })
    }

    override fun configCreationEvents() {
        venueList?.run {
            adapter = venuesAdapter
            layoutManager?.let {
                addOnScrollListener(object : PagedRecyclerViewScrollListener(it) {
                    override fun onLoadMore(page: Int) {
                        vm.syncVenueList(perPageLimit, page * perPageLimit)
                    }
                })
            }
            venuesAdapter.onClick = { item, _ ->
                vm.selectVenue(item)
            }
        }
    }

    override fun configResumeEvents() {
        vm.syncVenueList(perPageLimit, 0)
    }

    override fun initBinding() {
        binding.apply {
            lifecycleOwner = this@MainActivity
            vm = this@MainActivity.vm
            executePendingBindings()
        }
    }
}
