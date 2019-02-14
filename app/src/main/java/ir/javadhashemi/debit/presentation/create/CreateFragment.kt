package ir.javadhashemi.debit.presentation.create

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ProgressBar
import ir.javadhashemi.debit.R
import ir.javadhashemi.debit.databinding.FragmentCreateBinding
import ir.javadhashemi.debit.presentation.base.BaseFragment
import ir.javadhashemi.debit.presentation.base.NavigatorController
import kotlinx.android.synthetic.main.fragment_create.*
import javax.inject.Inject

class CreateFragment : BaseFragment<CreateViewModel, FragmentCreateBinding>() {

    //    override val viewModel: CreateViewModel by getLazyViewModel()
    override val layoutId: Int = R.layout.fragment_create
    override var menuId: Int = 0
    override val toolbar: Toolbar? by lazy { create_tool_bar }
    override val title: String by lazy {
        context?.resources?.getString(R.string.create_title) ?: ""
    }
    override val progressBar: ProgressBar? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.createViewModel = viewModel
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.commonMessage.observe(viewLifecycleOwner, Observer {
            it?.let { message ->
                showMessage(message)
            }
        })
    }


}