package ir.javadhashemi.debit.di.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ir.javadhashemi.debit.App
import ir.javadhashemi.debit.di.module.ApiModule
import ir.javadhashemi.debit.di.module.AppModule
import ir.javadhashemi.debit.di.module.DatabaseModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class)
    , (AppModule::class)
    , (DatabaseModule::class)
    , (ApiModule::class)
    , (ContributeActivity::class)
])
interface DebitComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()


}