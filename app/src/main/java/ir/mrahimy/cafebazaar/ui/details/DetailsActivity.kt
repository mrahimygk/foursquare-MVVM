package ir.mrahimy.cafebazaar.ui.details

import android.content.Intent
import androidx.lifecycle.Observer
import ir.mrahimy.cafebazaar.R
import ir.mrahimy.cafebazaar.base.BaseActivity
import ir.mrahimy.cafebazaar.databinding.ActivityDetailsBinding
import ir.mrahimy.cafebazaar.ui.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class DetailsActivity : BaseActivity<DetailsViewModel, ActivityDetailsBinding>() {

    override val layoutRes = R.layout.activity_details

    override val vm: DetailsViewModel by viewModel()

    override fun bindObservables() {
        vm.selectedVenue.observe(this, Observer {
            Timber.d(it.name)
        })
    }

    override fun configCreationEvents() {
        intent?.extras?.getString(SELECTED_VENUE_ID)?.let {
            vm.selectVenue(it)
        }
    }

    override fun configResumeEvents() {
    }

    override fun initBinding() {
        binding.apply {
            lifecycleOwner = this@DetailsActivity
            vm = this@DetailsActivity.vm
            executePendingBindings()
        }
    }

    companion object {
        fun startMe(mainActivity: MainActivity, id: String) {
            mainActivity.startActivity(
                Intent(mainActivity, DetailsActivity::class.java).apply {
                    putExtra(SELECTED_VENUE_ID, id)
                })
        }

        const val SELECTED_VENUE_ID = "selected_id"
    }
}
