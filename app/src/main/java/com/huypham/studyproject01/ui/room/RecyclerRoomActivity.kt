package com.huypham.studyproject01.ui.room

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.huypham.studyproject01.R
import com.huypham.studyproject01.roomdata.Dummy
import kotlinx.android.synthetic.main.activity_recycler_room.*

/**
 * @author huypham on 6/12/21
 */
class RecyclerRoomActivity : AppCompatActivity() {

    private lateinit var roomAdapter: RecyclerRoomAdapter
    private var dummies = arrayListOf<Dummy>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_room)

        initRoomAdapter()
        initRecyclerRoom()
        insertData()
    }

    private fun initRoomAdapter() {
        roomAdapter = RecyclerRoomAdapter(this, dummies)

        roomAdapter.onDeleteItem = {
            deleteData(it)
        }

        roomAdapter.onUpdateItem = {
            updateData(it)
        }
    }

    private fun initRecyclerRoom() {
        rvRoom.layoutManager = LinearLayoutManager(this)
        rvRoom.setHasFixedSize(true)
        rvRoom.adapter = roomAdapter
    }

    private fun insertData() {
        btnInsert.setOnClickListener {
            dummies.add(Dummy(edtInputPerson.text.toString().trim()))
            roomAdapter.notifyDataSetChanged()

            edtInputPerson.setText("")
        }
    }

    private fun deleteData(position: Int) {
        dummies.removeAt(position)
        roomAdapter.notifyItemRemoved(position)
    }

    private fun updateData(position: Int) {
        edtInputPerson.setText(dummies[position].name)
        edtInputPerson.setSelection(edtInputPerson.length())


        btnUpdate.setOnClickListener {
            dummies[position].name = edtInputPerson.text.toString().trim()
            roomAdapter.notifyItemChanged(position)

            edtInputPerson.setText("")
        }
    }
}
