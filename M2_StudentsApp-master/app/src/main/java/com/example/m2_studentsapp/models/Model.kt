package com.example.studentsapp.models

class Model private constructor(){

    val students = mutableListOf<Student>()

    init {
        for (i in 1..20){
            val student = Student(
                name = "Student $i",
                id = "ID: ${1000 + i}",
                avatarUrlString = "https://i.pravatar.cc/150?img=$i",
                phone = "052000000$i",
                address = "Student $i home",
                isChecked = false
            )
            students.add(student)
        }
    }
    companion object{
        val shared = Model()
    }
}