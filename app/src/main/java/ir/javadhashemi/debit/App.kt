package ir.javadhashemi.debit

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ir.javadhashemi.debit.di.component.DaggerDebitComponent

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Oct/29 10:51
 */
class App : DaggerApplication() {

    private val appComponent: AndroidInjector<App> by lazy {
        DaggerDebitComponent.builder().create(this)
    }

    override fun onCreate() {
        super.onCreate()

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = appComponent


}
