package com.els.mvvmshoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.els.mvvmshoppinglist.data.database.entity.ShoppingItem
import com.els.mvvmshoppinglist.data.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private var repository: ShoppingRepository): ViewModel() {
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllSHoppingItems() = repository.getAllShoppingItem()

}