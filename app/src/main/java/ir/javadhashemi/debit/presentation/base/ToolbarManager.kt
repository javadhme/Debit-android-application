package ir.javadhashemi.debit.presentation.base

import com.google.android.material.appbar.AppBarLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jun/12 14:39

 */
interface ToolbarManager {
    val toolbar: Toolbar?
    var toolbarTitle: String
        get() = toolbar?.title.toString()
        set(value) {
            toolbar?.title = value
        }

    fun attachToScroll(recyclerView: androidx.recyclerview.widget.RecyclerView) {
        recyclerView.addOnScrollListener(object : androidx.recyclerview.widget.RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: androidx.recyclerview.widget.RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val appBar = toolbar?.parent
                val scrollItem = if (appBar != null && appBar is AppBarLayout) appBar else toolbar

            }
        })
    }

    fun attatchMenu(menuId: Int) {
        if (menuId == 0) {
            return
        }
        toolbar?.inflateMenu(menuId)
    }

    fun changeMenuItemVisibility(menuId: Int, visibility: Boolean) {
        toolbar?.menu?.findItem(menuId)?.isVisible = visibility
    }

    fun registerOnMenuClickListener(callback: (menuItem: MenuItem) -> Boolean) {
        toolbar?.setOnMenuItemClickListener {
            callback(it)
        }
    }

}