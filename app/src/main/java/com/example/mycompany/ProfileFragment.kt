package com.example.mycompany

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {
    var empId = -1
    var controller = -1
    private lateinit var listeAdapter: ProfileCommentsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            empId = ProfileFragmentArgs.fromBundle(it).editId
            controller = ProfileFragmentArgs.fromBundle(it).commingFrom
        }
        Vote.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToVoteListFragment(empId)
            Navigation.findNavController(it).navigate(action)
        }
        Performance.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToPerformanceFragment(empId)
            Navigation.findNavController(it).navigate(action)
        }
        Edit.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToEditProfileFragment(empId)
            Navigation.findNavController(it).navigate(action)
        }
        if (empId != -1 && controller == -1) {
            context?.let {
                val employee = DatabaseProcess().sellectEmployee(it, empId)
                val comments = DatabaseProcess().sellectCommentstoOneEmployee(it, empId)
                var success = 0
                var coding = 0
                var teamwork = 0
                name.text = employee.name + " " + employee.surname
                title.text = employee.title
                val byteArray = employee.photo
                val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
                userphoto.setImageBitmap(bitmap)
                for (i in 0..comments.size - 1) {
                    success += comments[i].success.toInt()
                    coding += comments[i].codding.toInt()
                    teamwork += comments[i].teamWork.toInt()
                }
                successRate.text = (success / comments.size).toString() + " %"
                coddingRate.text = (coding / comments.size).toString() + " %"
                teamworkRate.text = (teamwork / comments.size).toString() + " %"

                listeAdapter = ProfileCommentsRecyclerAdapter(empId, comments)
                recyclerViewProfile.layoutManager = LinearLayoutManager(it)
                recyclerViewProfile.adapter = listeAdapter
                listeAdapter.notifyDataSetChanged()
                Edit.visibility = View.VISIBLE
            }
        } else {
            Edit.visibility = View.INVISIBLE
            context?.let {
                val employee = DatabaseProcess().sellectEmployee(it, controller)
                val comments = DatabaseProcess().sellectCommentstoOneEmployee(it, controller)
                var success = 0
                var coding = 0
                var teamwork = 0
                name.text = employee.name + " " + employee.surname
                title.text = employee.title
                val byteArray = employee.photo
                val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
                userphoto.setImageBitmap(bitmap)
                for (i in 0..comments.size - 1) {
                    success += comments[i].success.toInt()
                    coding += comments[i].codding.toInt()
                    teamwork += comments[i].teamWork.toInt()
                }
                successRate.text = (success.toDouble() / comments.size).toString() + " %"
                coddingRate.text = (coding.toDouble() / comments.size).toString() + " %"
                teamworkRate.text = (teamwork.toDouble() / comments.size).toString() + " %"

                listeAdapter = ProfileCommentsRecyclerAdapter(controller, comments)
                recyclerViewProfile.layoutManager = LinearLayoutManager(it)
                recyclerViewProfile.adapter = listeAdapter
                listeAdapter.notifyDataSetChanged()
            }
        }
    }
}