package com.example.mycompany

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import kotlinx.android.synthetic.main.fragment_profile.*


class EditProfileFragment : Fragment() {
    var empId=-1
    var choosenImage: Uri? = null
    var choosenBitmap: Bitmap? = null
    val bitmapFixer: BitmapFixer = BitmapFixer()
    var myprofile : Employee =Employee()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            empId = EditProfileFragmentArgs.fromBundle(it).editId
        }
        VoteEdit.setOnClickListener {
            val action = EditProfileFragmentDirections.actionEditProfileFragmentToVoteListFragment(empId)
            Navigation.findNavController(it).navigate(action)
        }
        PerformanceEdit.setOnClickListener {
            val action = EditProfileFragmentDirections.actionEditProfileFragmentToPerformanceFragment(empId)
            Navigation.findNavController(it).navigate(action)
        }
        ProfileEdit.setOnClickListener{
            val action = EditProfileFragmentDirections.actionEditProfileFragmentToProfileFragment(empId)
            Navigation.findNavController(it).navigate(action)
        }
        context?.let {
            myprofile = DatabaseProcess().sellectEmployee(it, empId)
            val byteArray = myprofile.photo
            val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
            photoEdit.setImageBitmap(bitmap)
            textViewNameEdit.text = myprofile.name + " " + myprofile.surname
            textViewTitleEdit.text = myprofile.title
        }
        photoEdit.setOnClickListener{
            changePhoto(it)
        }
        buttonEdit.setOnClickListener {
            updateEmployee(view,myprofile)
        }
    }
    fun updateEmployee(view: View,employee: Employee){
        if (editTextPassword.text.toString().equals(editTextPassword2.text.toString())&&editTextPassword.text.toString() != ""){
            employee.photo = bitmapFixer.BitmaptoByteArray(choosenBitmap!!)
            employee.password = editTextPassword.text.toString()
            context?.let {
                DatabaseProcess().updateEmployee(it,employee)
            }
            Toast.makeText(context,"You Profile was updated",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context,"Enter passwords are not equal",Toast.LENGTH_SHORT).show()
        }

    }
    fun changePhoto(view: View){
        activity?.let{
            if(ContextCompat.checkSelfPermission(it.applicationContext,android.Manifest.permission.READ_EXTERNAL_STORAGE ) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)
            }
            else{
                val mediaS = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(mediaS, 2)
            }
        }
    }
    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 1) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val mediaS = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(mediaS, 2)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 2 && resultCode == Activity.RESULT_OK && data != null){
            choosenImage = data.data
            try {
                context?.let{
                    if(choosenImage != null){
                        if (Build.VERSION.SDK_INT >= 28){
                            val source = ImageDecoder.createSource(it.contentResolver, choosenImage!!)
                            choosenBitmap = ImageDecoder.decodeBitmap(source)
                            choosenBitmap = bitmapFixer.fixedTheBitmap(choosenBitmap!!,300)
                            myprofile.photo = bitmapFixer.BitmaptoByteArray(choosenBitmap!!)
                            photoEdit.setImageBitmap(choosenBitmap)
                        }
                        else{
                            choosenBitmap = MediaStore.Images.Media.getBitmap(it.contentResolver, choosenImage!!)
                            choosenBitmap = bitmapFixer.fixedTheBitmap(choosenBitmap!!,300)
                            myprofile.photo = bitmapFixer.BitmaptoByteArray(choosenBitmap!!)
                            photoEdit.setImageBitmap(choosenBitmap)

                        }
                    }
                }
            }
            catch (e: Exception){
                e.printStackTrace()
            }
        }

    }

}