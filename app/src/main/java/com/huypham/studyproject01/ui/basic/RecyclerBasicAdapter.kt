package com.huypham.studyproject01.ui.basic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.huypham.studyproject01.R
import com.huypham.studyproject01.data.Book
import kotlinx.android.synthetic.main.item_recycler_home_basic.view.*

/**
 * @author huypham on 6/12/21
 */
class RecyclerBasicAdapter(private val context: Context, private val books: MutableList<Book>)
    : RecyclerView.Adapter<RecyclerBasicAdapter.BasicViewHolder>() {

    internal var onClickBasicItem: (Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_home_basic, parent,false)
        return BasicViewHolder(view)
    }

    override fun onBindViewHolder(holder: BasicViewHolder, position: Int) {
        holder.bindData(books[position])
    }

    override fun getItemCount(): Int = books.size

    inner class BasicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onClickBasicItem(absoluteAdapterPosition)
            }
        }

        fun bindData(itemBook: Book) {
            itemView.tvBookName.text = itemBook.bookName
            if (itemBook.isRead) itemView.imgRead.visibility = View.VISIBLE
            else itemView.imgRead.visibility = View.GONE
        }
    }
}
