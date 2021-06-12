package com.huypham.studyproject01.ui.basic

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.huypham.studyproject01.R
import com.huypham.studyproject01.data.Book
import kotlinx.android.synthetic.main.activiy_recycler_basic.*

/**
 * @author huypham on 6/12/21
 */
class RecyclerBasicActivity: AppCompatActivity() {

    private lateinit var basicAdapter: RecyclerBasicAdapter
    private var books = mutableListOf<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activiy_recycler_basic)

        initBasicAdapter()
        initRecyclerBasic()
    }

    private fun initBasicAdapter() {
        basicAdapter = RecyclerBasicAdapter(this, books)
        basicAdapter.onClickBasicItem = {
            Toast.makeText(this, "Item position $it", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRecyclerBasic() {
        rvBasic.layoutManager = LinearLayoutManager(this)
        rvBasic.setHasFixedSize(true)
        rvBasic.adapter = basicAdapter
        createData()
        basicAdapter.notifyDataSetChanged()
    }

    private fun createData(): MutableList<Book> {
        for (index in 0..10) {
            var isRead = false
            if (index % 2 == 0) {
                isRead = true
            }
            books.add(index, Book(getString(R.string.text_item_book_name_dummy), isRead))
        }
        return books
    }
}
