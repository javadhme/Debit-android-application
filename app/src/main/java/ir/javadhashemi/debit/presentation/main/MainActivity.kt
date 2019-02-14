package ir.javadhashemi.debit.presentation.main

import android.os.Bundle
import dagger.android.AndroidInjection
import ir.javadhashemi.debit.App
import ir.javadhashemi.debit.R
import ir.javadhashemi.debit.databinding.ActivityMainBinding
import ir.javadhashemi.debit.presentation.base.BaseActivity
import ir.javadhashemi.debit.presentation.base.NavigatorController
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val viewModel: MainViewModel by getLazyViewModel()
    override val layoutId: Int = R.layout.activity_main

    @Inject
    lateinit var navigator: NavigatorController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigator.gotoCreatePage()
    }

    override fun onStart() {
        super.onStart()

    }

}
