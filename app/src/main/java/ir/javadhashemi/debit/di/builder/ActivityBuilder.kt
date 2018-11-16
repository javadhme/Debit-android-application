package ir.javadhashemi.debit.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.javadhashemi.debit.presentation.main.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector()
    abstract fun bindMainActivity() : MainActivity
}