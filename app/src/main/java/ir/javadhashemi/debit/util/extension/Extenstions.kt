package com.yaramobile.wicalory.util.extension

import android.content.Context
import android.os.Handler
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import android.view.View
import com.yaramobile.wicalory.data.local.pref.PreferenceManager
import ir.javadhashemi.debit.R

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jun/11 11:46
 */

fun Context.getAppPrefs(): PreferenceManager = PreferenceManager.getInstance(this)

fun androidx.fragment.app.DialogFragment.replaceFragmentWithAnimation(container: View, fragment: androidx.fragment.app.Fragment, backstackTag: String) {
    Handler().post {
        val transaction = childFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)
        transaction.replace(container.id, fragment)
        transaction.addToBackStack(backstackTag)
        transaction.commitAllowingStateLoss()
    }

}