package com.example.m2_studentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val newStudentButton: Button = findViewById(R.id.new_student_save_button)
        val cancelButton: Button = findViewById(R.id.new_student_cancel_button)

        val studentNameEditText: EditText = findViewById(R.id.new_student_edit_name_text_view)
        val studentIdEditText: EditText = findViewById(R.id.new_student_edit_id_text_view)
        val studentPhoneEditText: EditText = findViewById(R.id.new_student_edit_phone_text_view)
        val studentAddressEditText: EditText = findViewById(R.id.new_student_edit_address_text_view)

        val saveStatusTextView: TextView = findViewById(R.id.new_student_save_status_text_view)

        cancelButton.setOnClickListener {
            finish()
        }

        newStudentButton.setOnClickListener {
            val studentName = studentNameEditText.text.toString()
            val studentId = studentIdEditText.text.toString()
            val studentPhone = studentPhoneEditText.text.toString()
            val studentAddress = studentAddressEditText.text.toString()

            saveStatusTextView.text = "Student Saved: Name = $studentName, ID: $studentId"
            studentNameEditText.text.clear()
            studentIdEditText.text.clear()
            studentPhoneEditText.text.clear()
            studentAddressEditText.text.clear()
        }
    }
}