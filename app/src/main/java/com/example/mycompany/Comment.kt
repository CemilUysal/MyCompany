package com.example.mycompany

class Comment {
    var id : Int = 0
    var employeeID: Double=0.0
    var commenterId: Double=0.0
    var success: Double=0.0
    var teamWork:Double=0.0
    var codding: Double=0.0
    var comment: String=""

    constructor()
    constructor(
        employeeID: Double,
        commenterId: Double,
        success: Double,
        teamWork: Double,
        codding: Double,
        comment: String
    ) {
        this.employeeID = employeeID
        this.commenterId = commenterId
        this.success = success
        this.teamWork = teamWork
        this.codding = codding
        this.comment = comment
    }


}