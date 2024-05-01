package com.example.expensetracker.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.expensetracker.R
import com.example.expensetracker.data.ExpenseDataBase
import com.example.expensetracker.data.dao.ExpenseDao
import com.example.expensetracker.data.model.ExpenseEntity

class HomeViewModel(dao: ExpenseDao):ViewModel()
{
    val expense = dao.getAllExpenses()

    fun getBalance(list: List<ExpenseEntity>):String{
         var total = 0.0
        list.forEach {
            if (it.type == "Income"){
                total +=it.amount
            } else {
                total -= it.amount
            }
        }
        return " $ ${total}"
    }

    fun getTotalExpense(list: List<ExpenseEntity>):String{
          var total = 0.0
        list.forEach {
            if (it.type=="Expenese"){
                total +=it.amount
            }else {
                total -= it.amount
            }
        }
        return "$ ${total}"
    }

    fun getTotalIncome(list: List<ExpenseEntity>):String{
        var total = 0.0
        list.forEach {
            if (it.type=="Income"){
                total +=it.amount
            }else {
                total -= it.amount
            }
        }
        return "$ ${total}"
    }
    fun getItemIcon(item:ExpenseEntity): Int {
        if (item.category == "Paypal"){
             return R.drawable.ic_paypal
        } else if (item.category == "Netflix") {
            return R.drawable.ic_netflix
        }
        else if (item.category == "Starbucks"){
            return R.drawable.ic_starbucgs
        }
        return  R.drawable.ic_upwork
    }
}
class HomeViewModelFactory(private val context:Context):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)){
            val dao = ExpenseDataBase.getDatabase(context).expenseDao()
            return HomeViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown class")

    }
}