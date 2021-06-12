package com.huypham.studyproject01.ui.room

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.huypham.studyproject01.R
import com.huypham.studyproject01.roomdata.Dummy
import kotlinx.android.synthetic.main.item_recycler_room.view.*

/**
 * @author huypham on 6/12/21
 */
class RecyclerRoomAdapter(private val context: Context, private val dummies: ArrayList<Dummy>)
    : RecyclerView.Adapter<RecyclerRoomAdapter.RoomViewHolder>() {

    internal var onDeleteItem: (Int) -> Unit = {}
    internal var onUpdateItem: (Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        return RoomViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler_room, parent, false))
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.bindData(dummies[position])
    }

    override fun getItemCount(): Int = dummies.size

    inner class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onUpdateItem(absoluteAdapterPosition)
            }

            itemView.imgDelete.setOnClickListener {
                onDeleteItem(absoluteAdapterPosition)
            }
        }

        fun bindData(dummy: Dummy) {
            itemView.tvPersonName.text = dummy.name
        }
    }
}