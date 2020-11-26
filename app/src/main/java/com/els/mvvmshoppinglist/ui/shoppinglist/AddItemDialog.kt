package com.els.mvvmshoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import com.els.mvvmshoppinglist.R
import com.els.mvvmshoppinglist.data.database.entity.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add.*

class AddItemDialog(context: Context, var addDialogListener: AddDialogListener): AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add)

        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        tvCancel.setOnClickListener {
            cancel()
        }
    }
}