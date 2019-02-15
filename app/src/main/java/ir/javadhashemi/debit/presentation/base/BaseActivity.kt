package ir.javadhashemi.debit.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jun/12 16:08
 */
abstract class BaseActivity<V : BaseViewModel, B : ViewDataBinding>
    : DaggerAppCompatActivity(), BaseViewGroup<V, B> {

    final override lateinit var binding: B

    override lateinit var viewModelFactory: ViewModelProvider.Factory

    val backCallback: MutableLiveData<OnBackPressedListener?> = MutableLiveData()

    /*@Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>*/

    inline fun <reified T : BaseViewModel> getLazyViewModel(): Lazy<T> =
            lazy { ViewModelProviders.of(this, viewModelFactory)[T::class.java] }

//    override val viewModel: V by lazy {
//        @Suppress("UNCHECKED_CAST")
//        ViewModelProviders.of(this, viewModelFactory).get((javaClass
//                .genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<V>)
//    }

   // override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.setLifecycleOwner(this)
    }

    override fun onBackPressed() {
        if (backCallback.value == null) {
            super.onBackPressed()
        } else {
            if (backCallback.value?.onBackPressed(this) == false) super.onBackPressed()
        }
    }

    override fun onDestroy() {
        if (backCallback.value != null) {
            backCallback.value = null
        }
        super.onDestroy()
    }

}