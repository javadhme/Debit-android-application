package ir.javadhashemi.debit.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import ir.javadhashemi.debit.App
import ir.javadhashemi.debit.di.builder.ActivityBuilder
import ir.javadhashemi.debit.di.module.ApiModule
import ir.javadhashemi.debit.di.module.AppModule
import ir.javadhashemi.debit.di.module.DatabaseModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidInjectionModule::class),
    (AppModule::class),
    (DatabaseModule::class),
    (ApiModule::class),
    (ActivityBuilder::class)]
)
interface DebitComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): DebitComponent

    }

    fun inject(app: App)


}