package com.els.mvvmshoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.els.mvvmshoppinglist.data.repository.ShoppingRepository

@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(private var repository: ShoppingRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}