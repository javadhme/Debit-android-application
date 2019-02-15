package ir.javadhashemi.debit.di.builder

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ir.javadhashemi.debit.di.common.DebitViewModelFactory
import ir.javadhashemi.debit.di.module.create.CreateViewModelBuilder

//TODO add each ViewModel as class in include section
@Module(includes = [
    (CreateViewModelBuilder::class)
])
abstract class ViewModelFactoryBuilder {

    @Binds
    abstract fun bindViewModelFactory(factory: DebitViewModelFactory): ViewModelProvider.Factory

}