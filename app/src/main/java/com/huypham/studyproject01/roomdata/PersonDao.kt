package com.huypham.studyproject01.roomdata

import androidx.room.*

/**
 * @author huypham on 6/12/21
 */
@Dao
interface PersonDao {

    @Query("SELECT * FROM table_person ORDER BY name ASC")
    fun getPerson(): List<Person>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(person: Person)

    @Update
    fun updatePerson(person: Person)

    @Delete
    fun deletePerson(person: Person)

}
