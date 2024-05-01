package com.example.expensetracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.expensetracker.data.model.ExpenseEntity
import java.util.concurrent.Flow

@Dao
interface ExpenseDao {

   @Query("SELECT * FROM expense_table")
   fun getAllExpenses():kotlinx.coroutines.flow.Flow<List<ExpenseEntity>>

   @Insert
   suspend fun insertExpenses(expenseEntity: ExpenseEntity)

   @Delete
   suspend fun deleteExpenses(expenseEntity: ExpenseEntity)

   @Update
   suspend fun updateExpenses(expenseEntity: ExpenseEntity)
}