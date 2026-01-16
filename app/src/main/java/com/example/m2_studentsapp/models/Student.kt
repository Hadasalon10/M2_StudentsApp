package com.example.studentsapp.models

data class Student(
    var name: String,
    var id: String,
    var avatarUrlString: String,
    var phone: String,
    var address: String,
    var isChecked: Boolean
)
