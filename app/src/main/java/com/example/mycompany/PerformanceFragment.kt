package com.example.mycompany

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_performance.*
import kotlinx.android.synthetic.main.fragment_vote_list.*


class PerformanceFragment : Fragment() {
    var empId=-1
    private lateinit var listeAdapter: ListRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_performance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            empId = PerformanceFragmentArgs.fromBundle(it).editId
        }
        context?.let {
            listeAdapter = ListRecyclerAdapter(DatabaseProcess().sellectAllEmployees(it),empId,"performance")
            recylerViewPerformance.layoutManager = LinearLayoutManager(context)
            recylerViewPerformance.adapter = listeAdapter
            listeAdapter.notifyDataSetChanged()
        }
        VotePerformance.setOnClickListener{
            val action = PerformanceFragmentDirections.actionPerformanceFragmentToVoteListFragment(empId)
            Navigation.findNavController(it).navigate(action)
        }
        ProfilePerformance.setOnClickListener {
            val action = PerformanceFragmentDirections.actionPerformanceFragmentToProfileFragment(empId)
            Navigation.findNavController(it).navigate(action)
        }
    }
}