package ir.javadhashemi.debit.presentation.base

import androidx.lifecycle.ViewModelProvider
import androidx.databinding.ViewDataBinding

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jun/12 16:14
 */
interface BaseViewGroup<V : BaseViewModel, B : ViewDataBinding> {

    var viewModelFactory: ViewModelProvider.Factory

    val viewModel: V

    val layoutId : Int

    var binding : B

}
