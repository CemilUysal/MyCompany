package com.example.mycompany

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*

class ListRecyclerAdapter(val employeeList: ArrayList<Employee>, val empId:Int,val commingFrom:String): RecyclerView.Adapter<ListRecyclerAdapter.EmployeeHolder>() {
    class  EmployeeHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeHolder {
       val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_row,parent,false)
        return EmployeeHolder(view)
    }

    override fun getItemCount(): Int {
      return employeeList.size
    }

    override fun onBindViewHolder(holder: EmployeeHolder, position: Int) {
       holder.itemView.recyclerRowText.text = employeeList[position].name
        holder.itemView.setOnClickListener{
            if(commingFrom.equals("vote")){
                val action = VoteListFragmentDirections.actionVoteListFragmentToVoteFragment(empId,employeeList[position].id)
                Navigation.findNavController(it).navigate(action)
            }
            else{
                val action = PerformanceFragmentDirections.actionPerformanceFragmentToProfileFragment(empId,employeeList[position].id)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}