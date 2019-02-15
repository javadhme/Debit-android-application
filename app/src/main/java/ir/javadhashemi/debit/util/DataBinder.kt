package ir.javadhashemi.debit.util

import androidx.lifecycle.MutableLiveData
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import com.google.android.material.textfield.TextInputLayout
import android.text.Editable
import android.text.TextWatcher
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup

@BindingAdapter(value = ["android:errorMessage"])
fun setErrorMessage(target: TextInputLayout, error: ObservableField<String>?) {
    error?.let {
        target.error = error.get()
    }
}

@BindingAdapter(value = ["android:textChangeListenerObserver"])
fun setEditTextObservable(target: EditText, data: ObservableField<String>?) {

    data?.let {
        target.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                it.set(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }
}

@BindingAdapter(value = ["android:textChangeListenerLiveData"])
fun setEditTextLiveData(target: EditText, data: MutableLiveData<String>?) {

    data?.let {
        target.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                it.value = p0.toString()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }
}

@BindingAdapter(value = ["android:onCheckboxChangeListener"])
fun setCheckBoxChangeListener(target: CheckBox, listener: ObservableField<Boolean>?) {
    target.setOnCheckedChangeListener { _, isChecked -> listener?.set(isChecked) }
}

@BindingAdapter(value = ["android:onRadioGroupChangeListener"])
fun setRadioGroupChangeListener(target: RadioGroup, index: ObservableField<Int>?) {
    target.setOnCheckedChangeListener { _, checkedId ->
        index?.set(checkedId)
    }
}

