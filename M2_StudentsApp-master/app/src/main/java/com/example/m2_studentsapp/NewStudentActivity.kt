package com.example.m2_studentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.studentsapp.models.Model
import com.example.studentsapp.models.Student

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

        val newStudentButton: Button = findViewById(R.id.student_details_edit_button)
        val cancelButton: Button = findViewById(R.id.new_student_cancel_button)

        val studentNameEditText: EditText = findViewById(R.id.new_student_edit_name_text_view)
        val studentIdEditText: EditText = findViewById(R.id.new_student_edit_id_text_view)
        val studentPhoneEditText: EditText = findViewById(R.id.new_student_edit_phone_text_view)
        val studentAddressEditText: EditText = findViewById(R.id.new_student_edit_address_text_view)
        val studentCheckBox: CheckBox = findViewById(R.id.new_student_checkBox)


        val saveStatusTextView: TextView = findViewById(R.id.new_student_save_status_text_view)

        cancelButton.setOnClickListener {
            navigateToStudentList()
        }

        newStudentButton.setOnClickListener {
            val studentName = studentNameEditText.text.toString()
            val studentId = studentIdEditText.text.toString()
            val studentPhone = studentPhoneEditText.text.toString()
            val studentAddress = studentAddressEditText.text.toString()
            val isChecked = studentCheckBox.isChecked

            // val
            if (studentName.isBlank() || studentId.isBlank()) {
                saveStatusTextView.text = "Name and ID are required"
                return@setOnClickListener
            }

            val newStudent = Student(
                name = studentName,
                id = studentId,
                phone = studentPhone,
                address = studentAddress,
                avatarUrlString = "static_profile", //
                isChecked = isChecked
            )

            Model.shared.addStudent(newStudent)

            navigateToStudentList()
        }

        val backButton: ImageButton = findViewById(R.id.new_student_imageButton)
        backButton.setOnClickListener {
            finish()
        }

    }

    private fun navigateToStudentList() {
        val intent = Intent(this, StudentsListActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}