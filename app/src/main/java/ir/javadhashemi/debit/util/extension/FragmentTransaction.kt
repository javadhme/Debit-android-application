package ir.javadhashemi.debit.util.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import ir.javadhashemi.debit.R
import org.jetbrains.anko.bundleOf

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jun/20 12:19
 */
enum class TransitionAnimation {
    FADE, SLIDE_UP, SLIDE_IN, NO_ANIMATION
}


fun androidx.fragment.app.FragmentTransaction.setCustomAnimation(type: TransitionAnimation) {
    when (type) {
        TransitionAnimation.SLIDE_IN -> setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)
        TransitionAnimation.SLIDE_UP -> setCustomAnimations(R.anim.enter_from_bottom, R.anim.exit_to_bottom, R.anim.enter_from_bottom, R.anim.exit_to_bottom)
        TransitionAnimation.FADE -> setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
        TransitionAnimation.NO_ANIMATION -> return
    }
}

inline fun <reified T : androidx.fragment.app.Fragment> newFragmentInstance(vararg params: Pair<String, Any>): T =
        T::class.java.newInstance().apply {
            arguments = bundleOf(*params)
        }

fun androidx.recyclerview.widget.RecyclerView.addItemSlideUpAnimation() {
//    val animationController : LayoutAnimationController = AnimationUtils.loadLayoutAnimation(context, R.anim.item_animation_slide_up)
//    layoutAnimation = animationController
//    scheduleLayoutAnimation()
}

