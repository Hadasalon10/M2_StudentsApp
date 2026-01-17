package com.example.studentsapp.models

class Model private constructor(){

    val students = mutableListOf<Student>()

    init {
        for (i in 1..20){
            val student = Student(
                name = "Student $i",
                id = "${1000 + i}",
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

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun updateStudent(index: Int, updatedStudent: Student) {
        if (index in students.indices) {
            students[index] = updatedStudent
        }
    }

    fun deleteStudent(index: Int) {
        if (index in students.indices) {
            students.removeAt(index)
        }
    }

    fun toggleCheck(index: Int) {
        if (index in students.indices) {
            students[index].isChecked = !students[index].isChecked
        }
    }
}