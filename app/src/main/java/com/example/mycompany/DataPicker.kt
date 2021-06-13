package com.example.mycompany

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory

class DataPicker {
    var choosenBitmap: Bitmap? =null
    val bitmapFixer = BitmapFixer()
    val images = arrayOf(R.drawable.cemil,R.drawable.berkay,R.drawable.bilal,R.drawable.levent)
    val imagesByteArray: ArrayList<ByteArray> = ArrayList()
    var employees: ArrayList<Employee> = ArrayList()
    var comments: ArrayList<Comment> = ArrayList()
    fun employeeAdder(context: Context): ArrayList<Employee>{
        for(i in images){
            choosenBitmap = BitmapFactory.decodeResource(context.resources,i)
            choosenBitmap = bitmapFixer.fixedTheBitmap(choosenBitmap!!, 300)
            imagesByteArray.add(bitmapFixer.BitmaptoByteArray(choosenBitmap!!))
        }
        employees.add(Employee("Cemil","Uysal","Android Developer", "cemil@gmail.com","cemil",imagesByteArray[0]))
        employees.add(Employee("Berkay","Kirtilli","Web Developer", "berkay@gmail.com","berkay",imagesByteArray[1]))
        employees.add(Employee("Bilal","Karagoz","Java Developer", "bilal@gmail.com","bilal",imagesByteArray[2]))
        employees.add(Employee("Levent","Gumrukcu","Intern", "levent@gmail.com","levent",imagesByteArray[3]))
        return employees
    }
    fun commentsAdder():ArrayList<Comment>{
        comments.add(Comment(1.0,2.0,98.0,90.0,100.0,"He is a really good coder"))
        comments.add(Comment(1.0,3.0,99.0,95.0,100.0,"He is a  good coder"))

        comments.add(Comment(2.0,3.0,85.0,80.0,90.0,"He is a  good coder"))
        comments.add(Comment(3.0,4.0,98.0,95.0,95.0,"He is a really good coder"))
        comments.add(Comment(4.0,1.0,70.0,80.0,85.0,"He is a good coder"))
        return  comments
    }
}