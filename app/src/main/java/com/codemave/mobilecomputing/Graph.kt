package com.codemave.mobilecomputing

import android.content.Context
import androidx.room.Room
import com.codemave.mobilecomputing.data.repository.CategoryRepository
import com.codemave.mobilecomputing.data.repository.PaymentRepository
import com.codemave.mobilecomputing.data.room.MobileComputingDatabase

/**
 * A simple singleton dependency graph
 *
 * For a real app, please use something like Koin/Dagger/Hilt instead
 */
object Graph {
    lateinit var database: MobileComputingDatabase

    val categoryRepository by lazy {
        CategoryRepository(
            categoryDao = database.categoryDao()
        )
    }

    val paymentRepository by lazy {
        PaymentRepository(
            paymentDao = database.paymentDao()
        )
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, MobileComputingDatabase::class.java, "mcData.db")
            .fallbackToDestructiveMigration() // don't use this in production app
            .build()
    }
}