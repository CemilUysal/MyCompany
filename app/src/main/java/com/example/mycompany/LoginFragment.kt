package com.example.mycompany

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_login.*
import java.sql.DatabaseMetaData


class LoginFragment : Fragment() {
    val dataPicker= DataPicker()
    val databaseProcess = DatabaseProcess()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            context?.let {
                databaseProcess.creating_tables(it)
                for(i in dataPicker.employeeAdder(it)){
                    databaseProcess.insertEmployee(it,i)
                }
                for(i in dataPicker.commentsAdder()){
                    databaseProcess.insertComments(it,i)
                }
            }
        }
        catch (e: Exception){
            println(e)
        }
        Login.setOnClickListener{
            loginController(it)
        }
    }
    fun loginController(view: View){
        val email =editTextemail.text.toString()
        val password = editTextPasswordLogin.text.toString()
        context?.let {
            val employeeList = DatabaseProcess().sellectAllEmployees(it)
            for (i in 0..employeeList.size-1){
                if(email.equals(employeeList[i].email,ignoreCase = true) && password.equals(employeeList[i].password)){
                    val action = LoginFragmentDirections.actionLoginFragmentToProfileFragment(employeeList[i].id)
                    Navigation.findNavController(view).navigate(action)
                }
            }
            Toast.makeText(it,"Invalid access try again",Toast.LENGTH_SHORT).show()
        }
    }


}