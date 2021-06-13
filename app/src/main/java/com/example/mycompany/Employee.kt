package com.example.mycompany

class Employee {
    var id : Int = 0
    var name: String=""
    var surname: String=""
    var title: String=""
    var email:String=""
    var password: String=""
    var photo: ByteArray = ByteArray(750)

    constructor()
    constructor(
        name: String,
        surname: String,
        title: String,
        email: String,
        password: String,
        photo: ByteArray
    ) {
        this.name = name
        this.surname = surname
        this.title = title
        this.email = email
        this.password = password
        this.photo = photo
    }

    constructor(
        id: Int,
        name: String,
        surname: String,
        title: String,
        email: String,
        password: String,
        photo: ByteArray
    ) {
        this.id = id
        this.name = name
        this.surname = surname
        this.title = title
        this.email = email
        this.password = password
        this.photo = photo
    }


}