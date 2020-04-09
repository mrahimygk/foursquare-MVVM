package ir.mrahimy.cafebazaar.ui.main

import ir.mrahimy.cafebazaar.R
import ir.mrahimy.cafebazaar.base.BaseActivity
import ir.mrahimy.cafebazaar.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val layoutRes = R.layout.activity_main

    override val vm: MainViewModel by viewModel()

    override fun bindObservables() {
    }

    override fun configCreationEvents() {
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
