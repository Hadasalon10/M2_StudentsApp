package com.example.m2_studentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.studentsapp.models.Model

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val index = intent.getIntExtra("student_index", -1)
        val student = if (index != -1) Model.shared.students[index] else null

        if (student != null) {
            val nameTextView: TextView = findViewById(R.id.student_details_name_text_view_data)
            val idTextView: TextView = findViewById(R.id.student_details_id_text_view_data)
            val phoneTextView: TextView = findViewById(R.id.student_details_phone_text_view_data)
            val addressTextView: TextView = findViewById(R.id.student_details_address_text_view_data)
            val checkBox: CheckBox = findViewById(R.id.student_details_checkBox)
            val avatarImageView: ImageView = findViewById(R.id.student_details_image_view)

            nameTextView.text = student.name
            idTextView.text = student.id
            phoneTextView.text = student.phone
            addressTextView.text = student.address
            avatarImageView.setImageResource(R.drawable.profile)
            checkBox.isChecked = student.isChecked

            checkBox.setOnCheckedChangeListener { _, isChecked ->
                Model.shared.students[index].isChecked = isChecked
            }

            val button: Button = findViewById(R.id.student_details_edit_button)
            button.setOnClickListener {
                val intent = Intent(this, EditStudentActivity::class.java)
                intent.putExtra("student_index", index)
                startActivity(intent)
            }
        }

        val backButton: ImageButton = findViewById(R.id.student_details_imageButton)
        backButton.setOnClickListener {
            finish()
        }
        
    }
}