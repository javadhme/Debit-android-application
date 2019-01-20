package ir.javadhashemi.debit.di.component

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.javadhashemi.debit.di.scope.FragmentScope
import ir.javadhashemi.debit.presentation.create.CreateFragment

@Module
abstract class ContributeFragment {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeCreateFragment() : CreateFragment

}