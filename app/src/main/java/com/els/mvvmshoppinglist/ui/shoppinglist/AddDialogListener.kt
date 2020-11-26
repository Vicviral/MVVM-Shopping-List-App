package com.els.mvvmshoppinglist.ui.shoppinglist

import com.els.mvvmshoppinglist.data.database.entity.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}