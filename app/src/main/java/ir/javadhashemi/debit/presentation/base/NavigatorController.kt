package ir.javadhashemi.debit.presentation.base

import android.databinding.ViewDataBinding
import android.support.v4.app.FragmentManager
import ir.javadhashemi.debit.presentation.create.CreateFragment
import ir.javadhashemi.debit.util.extension.TransitionAnimation
import ir.javadhashemi.debit.util.extension.newFragmentInstance
import ir.javadhashemi.debit.util.extension.setCustomAnimation
import javax.inject.Inject

class NavigatorController @Inject constructor(
        private val manager: FragmentManager,
        private val rootView: Int
) {

    private var isRunning = false


    fun <V : BaseViewModel, B : ViewDataBinding> changeFragment(
            fragment: BaseFragment<V, B>,
            animationType: TransitionAnimation,
            backStackTag: String
    ) {
        if (isRunning) return

        isRunning = true

        manager.beginTransaction().apply {
            setCustomAnimation(animationType)
            add(rootView, fragment)
            addToBackStack(backStackTag)
            commitAllowingStateLoss()
        }

        isRunning = false
    }

    fun gotoCreatePage() {
        changeFragment(
                newFragmentInstance<CreateFragment>(),
                TransitionAnimation.SLIDE_IN,
                "Create"
        )
    }


}