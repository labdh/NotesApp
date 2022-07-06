package com.example.notes

import android.app.Application
import androidx.lifecycle.LiveData

class TaskListRepository(context: Application) {
    private val tasklistDao : TaskListDao = TaskDatabase.getDatabase(context).taskListDao()

    fun getTask(sort : SortColumn = SortColumn.Priority) : LiveData<List<Task>>{
        return if(sort == SortColumn.Priority)
        {
            tasklistDao.getTaskByPriority(TaskStatus.Open.ordinal)
        }
        else{
            tasklistDao.getTaskByTitle(TaskStatus.Open.ordinal)
        }
    }

}