package ir.javadhashemi.debit.presentation.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.*
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import ir.javadhashemi.debit.presentation.CommonToast
import java.lang.reflect.ParameterizedType
import javax.inject.Inject


abstract class BaseFragment<V : BaseViewModel, B : ViewDataBinding>
    : Fragment(),
        BaseViewGroup<V, B>,
        ToolbarManager,
        ProgressBarManager {

    override lateinit var binding: B

    @Inject
    override lateinit var viewModelFactory: ViewModelProvider.Factory

    override val viewModel: V by lazy {
        @Suppress("UNCHECKED_CAST")
        ViewModelProviders.of(this, viewModelFactory).get((javaClass
                .genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<V>)
    }

//    inline fun <reified T : BaseViewModel> getLazyViewModel(): Lazy<T> =
//            lazy { ViewModelProviders.of(this, viewModelFactory)[T::class.java] }

    abstract val title: String
    abstract var menuId: Int
    var backCallback: MutableLiveData<OnBackPressedListener?>? = null

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        if (menuId > 0) {
            setHasOptionsMenu(true)
        }
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (toolbar != null) {
            (activity as AppCompatActivity).setSupportActionBar(toolbar)
            toolbar?.title = title
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel.progressBar = progressBar
        viewModel.hideProgressBar()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        if (menuId == 0) {
            return super.onCreateOptionsMenu(menu, inflater)
        }
        menu?.clear()
        inflater?.inflate(menuId, menu)
    }

    override fun onDestroy() {
        if (backCallback != null && backCallback?.value != null) {
            backCallback?.value = null
        }
        super.onDestroy()
    }


    fun showMessage(message: String, duration: Int = CommonToast.LENGTH_LONG) {
        context?.let {
            CommonToast.makeToast(it, message, duration).show()
        }
    }


}