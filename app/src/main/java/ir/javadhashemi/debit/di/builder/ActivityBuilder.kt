package ir.javadhashemi.debit.di.builder

import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import ir.javadhashemi.debit.di.scope.ActivityScope
import ir.javadhashemi.debit.presentation.base.NavigatorController
import ir.javadhashemi.debit.presentation.main.MainActivity
import javax.inject.Inject


@Module
abstract class ActivityBuilder {

    @ActivityScope
    @Binds
    abstract fun provideMainActivityView(activity: MainActivity) : AppCompatActivity

}