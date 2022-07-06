package com.example.notes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_task_list.*

class TaskListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(task_list){
            layoutManager = LinearLayoutManager(activity)
            adapter = TaskAdapter{
                val bundle = Bundle()
                bundle.putInt("ID", it.id.toInt())
                findNavController().navigate(R.id.action_taskListFragment_to_taskDetailFragment,bundle)
            }
        }

        floatingActionButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("ID",0)
            findNavController().navigate(R.id.action_taskListFragment_to_taskDetailFragment,bundle)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_sort_priority -> {

                item.isChecked = true
                true
            }
            R.id.menu_sort_title -> {

                item.isChecked = true
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }





}

