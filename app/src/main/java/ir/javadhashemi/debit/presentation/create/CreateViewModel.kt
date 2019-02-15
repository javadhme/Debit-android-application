package ir.javadhashemi.debit.presentation.create

import androidx.lifecycle.MutableLiveData
import androidx.databinding.ObservableField
import ir.javadhashemi.debit.domain.model.DebitModel
import ir.javadhashemi.debit.domain.model.UseCaseResponse
import ir.javadhashemi.debit.domain.usecase.AddNewDebitUseCase
import ir.javadhashemi.debit.presentation.base.BaseViewModel
import ir.javadhashemi.debit.util.DateUtils
import java.util.*
import javax.inject.Inject

class CreateViewModel @Inject constructor(private val createDebitUseCase: AddNewDebitUseCase) : BaseViewModel() {

    val type: ObservableField<Int> = ObservableField()
    val fromWho: ObservableField<String> = ObservableField()
    val howMuch: ObservableField<String> = ObservableField()
    val deadline: ObservableField<String> = ObservableField()
    val description: ObservableField<String> = ObservableField()

    val personError: ObservableField<String> = ObservableField()
    val moneyError: ObservableField<String> = ObservableField()
    val dateError: ObservableField<String> = ObservableField()
    val descError: ObservableField<String> = ObservableField()

    val noDeadline: ObservableField<Boolean> = ObservableField()

    init {
        noDeadline.set(false)

    }


    fun save() {
        //TODO input checking
        println("type is -> ${type.get()}")
        if(type.get() == null){
            commonMessage.value = "نوع آیتم را ابتدا مشخص نمایید"
            return
        }

        if (fromWho.get() == null || fromWho.get() == "") {
            personError.set("نام شخص باید وارد شود")
            return
        } else {
            personError.set("")
        }

        if (howMuch.get() == null || howMuch.get() == "") {
            moneyError.set("مبلغ باید وارد شود")
            return
        } else {
            moneyError.set("")
        }

        if (noDeadline.get() == false && (deadline.get() == null || deadline.get() == "")) {
            dateError.set("تاریخ باید وارد شود. در غیراینصورت معلوم نیست انتخاب گردد")
            return
        } else {
            dateError.set("")
        }

        val debitModel = createDebitModel()

        createDebitUseCase.execute(compositeDisposable, debitModel, object : UseCaseResponse<Long> {

            override fun onSuccess(value: Long) {
                commonMessage.value = "آیتم با موفقیت اضافه شد"
            }

            override fun onError(error: Throwable) {
                println(error)
                commonMessage.value = "خطا در هنگام درج اطلاعات"
            }

        })
    }

    private fun createDebitModel(): DebitModel = DebitModel().apply {
        name = fromWho.get()!!
        cost = howMuch.get()!!.toInt()
        desc = description.get()
        hasDeadLine = noDeadline.get() == true
        startDate = DateUtils.getDefaultDateFormat().format(Date())
        deadline.get()?.let { value ->
            endDate = value
        }
    }

    fun dismiss() {

    }
}