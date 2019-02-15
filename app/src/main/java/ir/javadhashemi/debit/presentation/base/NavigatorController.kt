package ir.javadhashemi.debit.presentation.base

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import ir.javadhashemi.debit.R.id.root_view
import ir.javadhashemi.debit.presentation.create.CreateFragment
import ir.javadhashemi.debit.util.extension.TransitionAnimation
import ir.javadhashemi.debit.util.extension.newFragmentInstance
import ir.javadhashemi.debit.util.extension.setCustomAnimation
import javax.inject.Inject

class NavigatorController @Inject constructor(
        private val manager: androidx.fragment.app.FragmentManager
) {

    private var isRunning = false

    private fun <V : BaseViewModel, B : ViewDataBinding> changeFragment(
            fragment: BaseFragment<V, B>,
            animationType: TransitionAnimation,
            backStackTag: String
    ) {
        if (isRunning) return

        isRunning = true

        val existing = manager.findFragmentByTag(backStackTag)

        manager.beginTransaction().apply {
            setCustomAnimation(animationType)
            add(root_view, fragment)
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