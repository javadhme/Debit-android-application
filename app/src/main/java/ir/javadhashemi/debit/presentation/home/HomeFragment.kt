package ir.javadhashemi.debit.presentation.home

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.ProgressBar
import ir.javadhashemi.debit.R
import ir.javadhashemi.debit.databinding.FragmentHomeBinding
import ir.javadhashemi.debit.presentation.base.BaseFragment

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    override var title: String = "Home"

    override var menuId: Int = 0
    override val layoutId: Int = R.layout.fragment_home
    override val toolbar: Toolbar? = null
    override val progressBar: ProgressBar? = null

    override val viewModel: HomeViewModel by getLazyViewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
