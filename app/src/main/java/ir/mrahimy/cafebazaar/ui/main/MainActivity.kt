package ir.mrahimy.cafebazaar.ui.main

import androidx.lifecycle.lifecycleScope
import ir.mrahimy.cafebazaar.R
import ir.mrahimy.cafebazaar.base.BaseActivity
import ir.mrahimy.cafebazaar.databinding.ActivityMainBinding
import ir.mrahimy.cafebazaar.util.PagedRecyclerViewScrollListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val layoutRes = R.layout.activity_main

    override val vm: MainViewModel by viewModel()

    private val venuesAdapter: VenuesAdapter by inject()
    override fun bindObservables() {
    }

    override fun configCreationEvents() {
        venueList?.run {
            adapter = venuesAdapter
            layoutManager?.let {
                addOnScrollListener(object : PagedRecyclerViewScrollListener(it) {
                    override fun onLoadMore(page: Int) {
                        lifecycleScope.launch { vm.initList() }
                    }
                })
            }
        }
    }

    override fun configResumeEvents() {
    }

    override fun initBinding() {
        binding.apply {
            lifecycleOwner = this@MainActivity
            vm = this@MainActivity.vm
            executePendingBindings()
        }
    }
}
