package com.codemave.mobilecomputing.data.entity

import java.util.*

data class Payment(
    val paymentId: Long,
    val paymentTitle: String,
    val paymentDate: Date?,
    val paymentCategory: String
)
