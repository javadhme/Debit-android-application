package ir.javadhashemi.debit.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule {


    /**
     * provide default context for any classes need context
     */

    @Provides
    fun provideContext(application: Application) : Context {
        return application.applicationContext
    }

}