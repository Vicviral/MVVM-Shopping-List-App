package com.els.mvvmshoppinglist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.els.mvvmshoppinglist.R
import com.els.mvvmshoppinglist.adapter.ShoppingItemAdapter
import com.els.mvvmshoppinglist.data.database.ShoppingDatabase
import com.els.mvvmshoppinglist.data.database.entity.ShoppingItem
import com.els.mvvmshoppinglist.data.repository.ShoppingRepository
import com.els.mvvmshoppinglist.ui.shoppinglist.AddDialogListener
import com.els.mvvmshoppinglist.ui.shoppinglist.AddItemDialog
import com.els.mvvmshoppinglist.ui.shoppinglist.ShoppingViewModel
import com.els.mvvmshoppinglist.ui.shoppinglist.ShoppingViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //DI will be implemented in the future
        //really don't need that here for a small project like this
        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel =  ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getAllSHoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()

        })

//        fab.setOnClickListener {
//            AddItemDialog(this, object : AddDialogListener{
//                override fun onAddButtonClicked(item: ShoppingItem) {
//                    viewModel.upsert(item)
//                }
//            }).show()
//        }

        fab.setOnClickListener {
            AddItemDialog(this, object : AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}