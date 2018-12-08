package ir.javadhashemi.debit.di.module

import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import ir.javadhashemi.debit.presentation.base.NavigatorController
import javax.inject.Singleton

@Module
abstract class NavigatorModule {


    @Singleton
    @Provides
    fun provideNavigator(fragmentManager: FragmentManager, rootView: Int): NavigatorController {
        return NavigatorController(fragmentManager, rootView)
    }

}
