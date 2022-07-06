package com.example.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import java.util.zip.Inflater

class TaskAdapter(private val listener : (Task) -> Unit): androidx.recyclerview.widget.ListAdapter<Task,TaskAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        init {
            itemView.setOnClickListener {
                listener.invoke(getItem(absoluteAdapterPosition))
            }
        }

        val task_priority = containerView.findViewById<View>(R.id.task_priority)
        val task_title = containerView.findViewById<TextView>(R.id.task_title)
        val task_detail = containerView.findViewById<TextView>(R.id.task_detail)
        fun bind(task: Task) {
            with(task) {
                when (task.priority) {
                    PriorityLevel.High.ordinal -> {
                        task_priority.setBackgroundColor(
                            ContextCompat.getColor(containerView.context, R.color.colorPriorityHigh)
                        )
                    }
                    PriorityLevel.Medium.ordinal -> {
                        task_priority.setBackgroundColor(
                            ContextCompat.getColor(
                                containerView.context,
                                R.color.colorPriorityMedium
                            )
                        )
                    }
                    else -> task_priority.setBackgroundColor(
                        ContextCompat.getColor(containerView.context, R.color.colorPriorityLow)
                    )
                }
                task_title.text = task.title
                task_detail.text = task.details
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
    }
}