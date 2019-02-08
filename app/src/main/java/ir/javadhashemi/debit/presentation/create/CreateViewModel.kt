package ir.javadhashemi.debit.presentation.create

import android.databinding.ObservableField
import ir.javadhashemi.debit.domain.model.DebitModel
import ir.javadhashemi.debit.domain.model.UseCaseResponse
import ir.javadhashemi.debit.domain.usecase.AddNewDebitUseCase
import ir.javadhashemi.debit.domain.usecase.AddNewDebitUseCase_Factory
import ir.javadhashemi.debit.domain.usecase.EditDebitUseCase
import ir.javadhashemi.debit.presentation.base.BaseViewModel
import ir.javadhashemi.debit.util.Constants
import ir.javadhashemi.debit.util.DateUtils
import ir.javadhashemi.debit.util.Logger
import java.util.*
import javax.inject.Inject

class CreateViewModel @Inject constructor(private val createDebitUseCase: AddNewDebitUseCase) : BaseViewModel() {

    val type: ObservableField<Int> = ObservableField()
    val fromWho: ObservableField<String> = ObservableField()
    val howMuch: ObservableField<String> = ObservableField()
    val deadline: ObservableField<String> = ObservableField()
    val description: ObservableField<String> = ObservableField()

    val hasDeadline: ObservableField<Boolean> = ObservableField()

    init {
        hasDeadline.set(false)

    }


    fun save() {
        //TODO input checking
        Logger.printLog("Save Click")
        createDebitUseCase.execute(compositeDisposable, DebitModel().apply {
            name = fromWho.get()!!
            cost = howMuch.get()!!.toInt()
            desc = description.get()!!
            hasDeadLine = hasDeadline.get() == true
            startDate = DateUtils.getDefaultDateFormat().format(Date())
            deadline.get()?.let { value ->
                endDate = value
            }
        }, object : UseCaseResponse<Long> {

            override fun onSuccess(value: Long) {
                println("SUCCESS called with value=$value")
            }

            override fun onError(error: Throwable) {
                println("onError called with error=[$error]")
            }

        })
    }

    fun dismiss() {

    }
}