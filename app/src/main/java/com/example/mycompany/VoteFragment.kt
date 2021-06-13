package com.example.mycompany

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_vote.*

class VoteFragment : Fragment() {

    var empId=-1
    var voteId = -1
    var onecomment = Comment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vote, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            empId = VoteFragmentArgs.fromBundle(it).editId
            voteId = VoteFragmentArgs.fromBundle(it).voteId
        }
        VoteVote.setOnClickListener{
            val action = VoteFragmentDirections.actionVoteFragmentToVoteListFragment(empId)
            Navigation.findNavController(it).navigate(action)
        }
        ProfileVote.setOnClickListener{
            val action = VoteFragmentDirections.actionVoteFragmentToProfileFragment(empId)
            Navigation.findNavController(it).navigate(action)
        }
        PerformanceVote.setOnClickListener {
            val action = VoteFragmentDirections.actionVoteFragmentToPerformanceFragment(empId)
            Navigation.findNavController(it).navigate(action)
        }
        context?.let{
            val employee = DatabaseProcess().sellectEmployee(it,voteId)
            onecomment = DatabaseProcess().sellectCommentsFromOneUser(it,voteId,empId)
            val byteArray = employee.photo
            val bitmap = BitmapFactory.decodeByteArray(byteArray,0,byteArray.size)
            photoVote.setImageBitmap(bitmap)
            textViewName.text=employee.name + " " + employee.surname
            textViewTitle.text = employee.title
        }

        if(onecomment.comment != ""){
            editTextComment.setText(onecomment.comment)
            editTextsuccess.setText(onecomment.success.toString())
            editTextcodding.setText(onecomment.codding.toString())
            editTextteamWork.setText( onecomment.teamWork.toString())
        }
        saveVote.setOnClickListener {
            if(onecomment.comment == ""){
                saveComment(it)
            }
            else{
                updateComment(it,onecomment)
            }

        }
    }
    fun saveComment(view: View){
        if (editTextsuccess.text.toString() != "" && editTextcodding.text.toString()!=""&&
                editTextComment.text.toString()!="" ){
            var comment = Comment()
            comment.commenterId = empId.toDouble()
            comment.employeeID=voteId.toDouble()
            var success = editTextsuccess.text.toString()
            var coding = editTextcodding.text.toString()
            var teamwork = editTextteamWork.text.toString()
            comment.codding = coding.toDouble()
            comment.teamWork = teamwork.toDouble()
            comment.success = success.toDouble()
            comment.comment = editTextComment.text.toString()
            context?.let {
                DatabaseProcess().insertComments(it,comment)
            }
        }
        else{
            Toast.makeText(context,"Please fill the all blanks",Toast.LENGTH_SHORT).show()
        }
    }
    fun updateComment(view: View,comment:Comment){
        if (editTextsuccess.text.toString() != "" && editTextcodding.text.toString()!=""&&
                editTextComment.text.toString()!="" ){
            var success = editTextsuccess.text.toString()
            var coding = editTextcodding.text.toString()
            var teamwork = editTextteamWork.text.toString()
            comment.codding = coding.toDouble()
            comment.teamWork = teamwork.toDouble()
            comment.success = success.toDouble()
            comment.comment = editTextComment.text.toString()
            context?.let {
                DatabaseProcess().updateComment(it,comment)
                println("updating")
            }
        }
        else{
            Toast.makeText(context,"Please fill the all blanks",Toast.LENGTH_SHORT).show()
        }
    }
}