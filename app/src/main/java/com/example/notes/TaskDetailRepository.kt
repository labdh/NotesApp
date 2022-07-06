package com.example.notes

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData

class TaskDetailRepository(context: Application) {
    val taskDetailDao : TaskDetailDao = TaskDatabase.getDatabase(context).taskDetailDao()
    fun getTask(id: Long): LiveData<Task> {
        return taskDetailDao.getTask(id.toInt())
    }

    suspend fun insertTask(task: Task): Long{
        return taskDetailDao.insertTask(task)
    }

    suspend fun updateTask(task: Task){
        taskDetailDao.updateTask(task)
    }

    suspend fun deleteTask(task: Task){
        taskDetailDao.deleteTask(task)
    }
}