package ir.javadhashemi.debit.di.module

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import ir.javadhashemi.debit.di.scope.ActivityScope
import ir.javadhashemi.debit.presentation.base.NavigatorController

@Module
class ActivityModule {


    @ActivityScope
    @Provides
    fun provideNavigatorController(activity: AppCompatActivity): NavigatorController {
        return NavigatorController(activity.supportFragmentManager)
    }
}