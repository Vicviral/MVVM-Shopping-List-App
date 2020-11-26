package com.els.mvvmshoppinglist.data.repository

import com.els.mvvmshoppinglist.data.database.ShoppingDatabase
import com.els.mvvmshoppinglist.data.database.entity.ShoppingItem

class ShoppingRepository(private val db: ShoppingDatabase) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)
    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)
    fun getAllShoppingItem() = db.getShoppingDao().getAllShoppingItems()
}