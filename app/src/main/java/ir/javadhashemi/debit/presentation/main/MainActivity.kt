package ir.javadhashemi.debit.presentation.main

import android.os.Bundle
import ir.javadhashemi.debit.R
import ir.javadhashemi.debit.databinding.ActivityMainBinding
import ir.javadhashemi.debit.presentation.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val viewModel: MainViewModel by getLazyViewModel()
    override val layoutId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
