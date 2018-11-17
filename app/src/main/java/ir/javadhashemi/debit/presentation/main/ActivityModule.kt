package ir.javadhashemi.debit.presentation.main

import android.app.Activity
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ir.javadhashemi.debit.di.qualifier.ViewModelKey
import ir.javadhashemi.debit.presentation.base.ViewModelProviderFactory

/*
@Module
abstract class ActivityModule {

    @Binds
    abstract fun activity(activity: MainActivity): Activity

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun mainViewModel(mainViewModel: MainViewModel)
}*/
