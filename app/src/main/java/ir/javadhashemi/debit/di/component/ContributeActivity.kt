package ir.javadhashemi.debit.di.component

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.javadhashemi.debit.di.builder.ActivityBuilder
import ir.javadhashemi.debit.di.module.ActivityModule
import ir.javadhashemi.debit.di.module.create.CreateFragmentProvider
import ir.javadhashemi.debit.di.scope.ActivityScope
import ir.javadhashemi.debit.presentation.main.MainActivity

@Module
abstract class ContributeActivity {

    @ActivityScope
    @ContributesAndroidInjector(
            modules = [
                ActivityBuilder::class,
                ActivityModule::class,
                CreateFragmentProvider::class
            ]
    )
    abstract fun contributeMainActivity(): MainActivity


}