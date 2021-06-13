package com.example.mycompany

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*


class ProfileCommentsRecyclerAdapter(val empId: Int,val commentList: ArrayList<Comment>):  RecyclerView.Adapter<ProfileCommentsRecyclerAdapter.CommentsHolder>() {
    class CommentsHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_row,parent,false)
        return CommentsHolder(view)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    override fun onBindViewHolder(holder: CommentsHolder, position: Int) {
        holder.itemView.recyclerRowText.text = "Comment "+(position+1).toString()+"\n"+ commentList[position].comment

    }


}