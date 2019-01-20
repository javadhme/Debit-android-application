package ir.javadhashemi.debit.di.builder

import dagger.Module

@Module
abstract class FragmentBuilder {


    abstract fun provideCreateFragment()

}