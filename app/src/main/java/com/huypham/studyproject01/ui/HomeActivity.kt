package com.huypham.studyproject01.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.huypham.studyproject01.R
import com.huypham.studyproject01.ui.basic.RecyclerBasicActivity
import com.huypham.studyproject01.ui.room.RecyclerRoomActivity
import kotlinx.android.synthetic.main.activity_home.*

/**
 * @author huypham on 6/12/21
 */
class HomeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigateToNextScreen()
    }

    private fun navigateToNextScreen() {
        btnRecyclerView.setOnClickListener {
           val intentRecyclerBasic = Intent(this, RecyclerBasicActivity::class.java)
           startActivity(intentRecyclerBasic)
        }

        btnRoom.setOnClickListener {
            startActivity(Intent(this, RecyclerRoomActivity::class.java))
        }
    }

}
