package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDetailDao {

    @Query("SELECT * FROM task WHERE id= :id")
    fun getTask(id :Int) : LiveData<Task>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task : Task) : Long

    @Delete
    suspend fun deleteTask(task : Task)

    @Update
    suspend fun updateTask(task: Task)
}