package com.codemave.mobilecomputing.ui.home.categoryPayment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codemave.mobilecomputing.data.entity.Payment
import java.util.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryPaymentViewModel : ViewModel() {
    private val _state = MutableStateFlow(CategoryPaymentViewState())

    val state: StateFlow<CategoryPaymentViewState>
        get() = _state

    init {
        val list = mutableListOf<Payment>()
        for (x in 1..20) {
            list.add(
                Payment(
                    paymentId = x.toLong(),
                    paymentTitle = "$x payment",
                    paymentCategoryId = 1,
                    paymentDate = 123
                )
            )
        }

        viewModelScope.launch {
            _state.value = CategoryPaymentViewState(
                payments = list
            )
        }
    }
}

data class CategoryPaymentViewState(
    val payments: List<Payment> = emptyList()
)