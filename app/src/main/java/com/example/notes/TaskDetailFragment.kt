package com.example.notes

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_task_detail.*


class TaskDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_detail, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        val priorities = mutableListOf<String>();
        PriorityLevel.values().forEach { priorities.add(it.name) }
        val arrayAdapter =ArrayAdapter(requireActivity(),android.R.layout.simple_spinner_item,priorities)
         task_priority.adapter = arrayAdapter

        task_priority?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                updateTaskPriorityView(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    private fun updateTaskPriorityView(priority: Int) {
        when(priority){
            PriorityLevel.High.ordinal ->{
                task_priority_view.setBackgroundColor(
                    ContextCompat.getColor(requireActivity(), R.color.colorPriorityHigh))
            }
            PriorityLevel.Medium.ordinal ->{
                task_priority_view.setBackgroundColor(
                    ContextCompat.getColor(requireActivity(), R.color.colorPriorityMedium))
            }
            else ->  task_priority_view.setBackgroundColor(
                ContextCompat.getColor(requireActivity(), R.color.colorPriorityLow))
        }
    }


}