package com.example.mycompany

import android.content.Context
import android.content.Context.MODE_PRIVATE

class DatabaseProcess {
    fun creating_tables(context: Context){

        val database = context.openOrCreateDatabase("Company",MODE_PRIVATE,null)
        database.execSQL("CREATE TABLE employee( id INTEGER PRIMARY KEY, name VARCHAR, surname VARCHAR, email VARCHAR, title VARCHAR, password VARCHAR, photo BLOB)")
        database.execSQL("CREATE TABLE performance(id INTEGER PRIMARY KEY, employeeID DOUBLE,commenterId DOUBLE, success DOUBLE, teamWork DOUBLE, coding DOUBLE, comment VARCHAR )")
        database.close()
    }
    fun insertEmployee(context: Context, employee: Employee){
        val database = context.openOrCreateDatabase("Company",MODE_PRIVATE,null)
        val sqlString = "INSERT INTO employee(name, surname,email,title,password,photo) VALUES(?,?,?,?,?,?)"
        val statement = database.compileStatement(sqlString)
        statement.bindString(1,employee.name)
        statement.bindString(2,employee.surname)
        statement.bindString(3,employee.email)
        statement.bindString(4,employee.title)
        statement.bindString(5,employee.password)
        statement.bindBlob(6,employee.photo)
        statement.execute()
        database.close()
    }
    fun insertComments(context: Context, comment: Comment){
        val database = context.openOrCreateDatabase("Company",MODE_PRIVATE,null)
        val sqlString = "INSERT INTO performance(employeeID, commenterId, success, teamWork, coding,comment) VALUES(?,?,?,?,?,?)"
        val statement = database.compileStatement(sqlString)
        statement.bindDouble(1,comment.employeeID)
        statement.bindDouble(2,comment.commenterId)
        statement.bindDouble(3,comment.success)
        statement.bindDouble(4,comment.teamWork)
        statement.bindDouble(5,comment.codding)
        statement.bindString(6,comment.comment)
        statement.execute()

        database.close()
    }
    fun sellectAllEmployees(context: Context):ArrayList<Employee> {
        var employeeList: ArrayList<Employee> = ArrayList()
        employeeList.clear()
       try {
           val database = context.openOrCreateDatabase("Company",MODE_PRIVATE,null)
           val cursor = database.rawQuery("SELECT*FROM employee",null)
           val idIndex = cursor.getColumnIndex("id")
           val nameIndex = cursor.getColumnIndex("name")
           val surnameIndex = cursor.getColumnIndex("surname")
           val emailIndex = cursor.getColumnIndex("email")
           val titleIndex = cursor.getColumnIndex("title")
           val passwordIndex = cursor.getColumnIndex("password")
           val photoIndex = cursor.getColumnIndex("photo")
           while (cursor.moveToNext()){
               var employee = Employee()
               employee.id = cursor.getInt(idIndex)
               employee.name=cursor.getString(nameIndex)
               employee.surname=cursor.getString(surnameIndex)
               employee.email=cursor.getString(emailIndex)
               employee.title=cursor.getString(titleIndex)
               employee.password=cursor.getString(passwordIndex)
               employee.photo = cursor.getBlob(photoIndex)
               employeeList.add(employee)
           }
       }
       catch (e: Exception){
           println(e)
       }
        return employeeList
    }
    fun sellectEmployee(context: Context, empId :Int): Employee{

        var employee = Employee()
        try {
            val database = context.openOrCreateDatabase("Company",MODE_PRIVATE,null)
            val cursor = database.rawQuery("SELECT*FROM employee WHERE id = ?", arrayOf(empId.toString()))
            val idIndex = cursor.getColumnIndex("id")
            val nameIndex = cursor.getColumnIndex("name")
            val surnameIndex = cursor.getColumnIndex("surname")
            val emailIndex = cursor.getColumnIndex("email")
            val titleIndex = cursor.getColumnIndex("title")
            val passwordIndex = cursor.getColumnIndex("password")
            val photoIndex = cursor.getColumnIndex("photo")
            while (cursor.moveToNext()){
                employee.id = cursor.getInt(idIndex)
                employee.name=cursor.getString(nameIndex)
                employee.surname=cursor.getString(surnameIndex)
                employee.email=cursor.getString(emailIndex)
                employee.title=cursor.getString(titleIndex)
                employee.password=cursor.getString(passwordIndex)
                employee.photo = cursor.getBlob(photoIndex)
            }
        }
        catch (e: Exception){
            println(e)
        }
        return employee
    }
    fun sellectAllComments(context: Context):ArrayList<Comment>{
        var commentList: ArrayList<Comment> = ArrayList()
        commentList.clear()
        try {
            val database = context.openOrCreateDatabase("Company",MODE_PRIVATE,null)
            val cursor = database.rawQuery("SELECT*FROM performance",null)
            val idIndex = cursor.getColumnIndex("id")
            val employeeIdIndex = cursor.getColumnIndex("employeeID")
            val commenterIdIndex = cursor.getColumnIndex("commenterId")
            val successIndex = cursor.getColumnIndex("success")
            val teamWorkIndex = cursor.getColumnIndex("teamWork")
            val codingIndex = cursor.getColumnIndex("coding")
            val commentIndex = cursor.getColumnIndex("comment")
            while (cursor.moveToNext()){
                var comment= Comment()
                comment.id = cursor.getInt(idIndex)
                comment.employeeID = cursor.getDouble(employeeIdIndex)
                comment.commenterId = cursor.getDouble(commenterIdIndex)
                comment.success = cursor.getDouble(successIndex)
                comment.teamWork = cursor.getDouble(teamWorkIndex)
                comment.codding = cursor.getDouble(codingIndex)
                comment.comment = cursor.getString(commentIndex)
                commentList.add(comment)
            }

        }
        catch (e: java.lang.Exception){
            println(e)
        }
        return commentList
    }
    fun sellectCommentstoOneEmployee(context: Context,empId: Int): ArrayList<Comment>{
        var commentList: ArrayList<Comment> = ArrayList()
        commentList.clear()
        try {
            val database = context.openOrCreateDatabase("Company",MODE_PRIVATE,null)
            val cursor = database.rawQuery("SELECT*FROM performance WHERE employeeID = ?", arrayOf(empId.toString()))
            val idIndex = cursor.getColumnIndex("id")
            val employeeIdIndex = cursor.getColumnIndex("employeeID")
            val commenterIdIndex = cursor.getColumnIndex("commenterId")
            val successIndex = cursor.getColumnIndex("success")
            val teamWorkIndex = cursor.getColumnIndex("teamWork")
            val codingIndex = cursor.getColumnIndex("coding")
            val commentIndex = cursor.getColumnIndex("comment")
            while (cursor.moveToNext()){
                var comment= Comment()
                comment.id = cursor.getInt(idIndex)
                comment.employeeID = cursor.getDouble(employeeIdIndex)
                comment.commenterId = cursor.getDouble(commenterIdIndex)
                comment.success = cursor.getDouble(successIndex)
                comment.teamWork = cursor.getDouble(teamWorkIndex)
                comment.codding = cursor.getDouble(codingIndex)
                comment.comment = cursor.getString(commentIndex)

                commentList.add(comment)
            }

        }
        catch (e: java.lang.Exception){
            println(e)
        }
        return commentList
    }
    fun sellectCommentsFromOneUser(context: Context, voteId: Int, empId: Int):Comment{
        var comment= Comment()
        try {
            val database = context.openOrCreateDatabase("Company",MODE_PRIVATE,null)
            val cursor = database.rawQuery("SELECT*FROM performance WHERE commenterId = ? AND employeeID = ?", arrayOf(empId.toString(),voteId.toString()))
            val idIndex = cursor.getColumnIndex("id")
            val employeeIdIndex = cursor.getColumnIndex("employeeID")
            val commenterIdIndex = cursor.getColumnIndex("commenterId")
            val successIndex = cursor.getColumnIndex("success")
            val teamWorkIndex = cursor.getColumnIndex("teamWork")
            val codingIndex = cursor.getColumnIndex("coding")
            val commentIndex = cursor.getColumnIndex("comment")
            while (cursor.moveToNext()){

                comment.id = cursor.getInt(idIndex)
                comment.employeeID = cursor.getDouble(employeeIdIndex)
                comment.commenterId = cursor.getDouble(commenterIdIndex)
                comment.success = cursor.getDouble(successIndex)
                comment.teamWork = cursor.getDouble(teamWorkIndex)
                comment.codding = cursor.getDouble(codingIndex)
                comment.comment = cursor.getString(commentIndex)
            }
        }
        catch(e:Exception){
            println(e)
        }
        return comment
    }
    fun updateComment(context: Context,comment: Comment){
        try{
            val database = context.openOrCreateDatabase("Company",MODE_PRIVATE,null)
            database.execSQL("UPDATE performance SET success =?, teamWork = ?, coding = ?, comment = ? WHERE id = ?",
                    arrayOf(comment.success,comment.codding,comment.teamWork,comment.comment,comment.id))

        }
        catch(e: Exception){
            println("update error")
            println(e)
        }
    }
    fun updateEmployee(context: Context, employee: Employee){
        try {
            val database = context.openOrCreateDatabase("Company",MODE_PRIVATE,null)
            database.execSQL("UPDATE employee SET password =?, photo = ? WHERE id = ?",
                    arrayOf(employee.password,employee.photo,employee.id))

        }
        catch (e:Exception){
            println(e)
        }

    }
}