package ir.javadhashemi.debit.di.module.create

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ir.javadhashemi.debit.di.qualifier.ViewModelKey
import ir.javadhashemi.debit.presentation.create.CreateViewModel

@Module
abstract class CreateViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(CreateViewModel::class)
    abstract fun bindCreateViewModel(viewModel: CreateViewModel): ViewModel

}