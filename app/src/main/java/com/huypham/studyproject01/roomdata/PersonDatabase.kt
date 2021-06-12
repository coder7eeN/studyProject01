package com.huypham.studyproject01.roomdata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * @author huypham on 6/12/21
 */
@Database(entities = [Person::class], version = 1)
abstract class PersonDatabase: RoomDatabase(){
    abstract fun personDao(): PersonDao

    companion object{
        private var INSTANCE: PersonDatabase? = null

        fun getBookDatabase(context: Context): PersonDatabase? {
            if (INSTANCE == null) {
                synchronized(PersonDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, PersonDatabase::class.java, "myDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDatabase() {
            INSTANCE = null
        }
    }
}
