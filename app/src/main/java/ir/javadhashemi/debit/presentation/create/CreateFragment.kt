package ir.javadhashemi.debit.presentation.create

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.ProgressBar
import ir.javadhashemi.debit.R
import ir.javadhashemi.debit.databinding.FragmentCreateBinding
import ir.javadhashemi.debit.presentation.base.BaseFragment
import ir.javadhashemi.debit.presentation.base.NavigatorController
import kotlinx.android.synthetic.main.fragment_create.*
import javax.inject.Inject

class CreateFragment : BaseFragment<CreateViewModel, FragmentCreateBinding>() {

    override val viewModel: CreateViewModel by getLazyViewModel()
    override val layoutId: Int = R.layout.fragment_create
    override var menuId: Int = 0
    override val toolbar: Toolbar? by lazy { create_tool_bar }
    override var title: String = resources.getString(R.string.create_title)
    override val progressBar: ProgressBar? = null

    @Inject
    private lateinit var navigator: NavigatorController

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}