package ir.mrahimy.cafebazaar.ui.main

import ir.mrahimy.cafebazaar.R
import ir.mrahimy.cafebazaar.base.BaseActivity
import ir.mrahimy.cafebazaar.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val layoutRes = R.layout.activity_main

    override val vm: MainViewModel
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun bindObservables() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configCreationEvents() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun configResumeEvents() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initBinding() {
        binding.apply {
            lifecycleOwner = this@MainActivity
            vm = this@MainActivity.vm
            executePendingBindings()
        }
    }
}
