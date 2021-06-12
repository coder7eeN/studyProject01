package com.huypham.studyproject01.roomdata

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author huypham on 6/12/21
 */
@Entity(tableName = "table_person")
data class Person (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "name")
    val name: String
)
