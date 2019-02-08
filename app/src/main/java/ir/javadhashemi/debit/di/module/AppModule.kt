package ir.javadhashemi.debit.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ir.javadhashemi.debit.di.builder.ViewModelFactoryBuilder

@Module(includes = [
    (ViewModelFactoryBuilder::class),
    DebitRepositoryModule::class,
    MapperModule::class
])
class AppModule {


    /**
     * provide default context for any classes need context
     */
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }
}