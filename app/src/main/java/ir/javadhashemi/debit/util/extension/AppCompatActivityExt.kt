package com.yaramobile.wicalory.util.extension

import android.os.Handler
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import ir.javadhashemi.debit.R

/**
 * Created by javaDroid on 3/4/18.
 */

/**
 * Runs a FragmentTransaction, then calls commit().
 */
fun AppCompatActivity.replaceFragmentWithAnimation(container: View, fragment: androidx.fragment.app.Fragment, backstackTag: String) {
    Handler().post {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)
        transaction.replace(container.id, fragment)
        transaction.addToBackStack(backstackTag)
        transaction.commitAllowingStateLoss()
    }

}

fun AppCompatActivity.replaceFragmentSlidingUp(container: View, fragment: androidx.fragment.app.Fragment, backstackTag: String) {
    Handler().post {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.enter_from_bottom, R.anim.exit_to_bottom, R.anim.enter_from_bottom, R.anim.exit_to_bottom)
        transaction.replace(container.id, fragment)
        transaction.addToBackStack(backstackTag)
        transaction.commitAllowingStateLoss()
    }

}

