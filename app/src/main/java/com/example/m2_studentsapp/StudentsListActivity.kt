package com.example.m2_studentsapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsapp.models.Model
import com.example.studentsapp.models.Student

class StudentsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // RecyclerView position
        val recyclerView: RecyclerView = findViewById(R.id.studentsRecyclerView)

        val students = Model.shared.students

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StudentAdapter(students = students)

    }
    // Activity in the adapter

    class StudentAdapter(
        private val students: List<Student>
    ) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

        // ViewHolder
        class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nameTextView: TextView = itemView.findViewById(R.id.students_row_name_text_view)
            val idTextView: TextView = itemView.findViewById(R.id.students_row_id_text_view)
            val avatarImageView: ImageView = itemView.findViewById(R.id.students_row_avatar_image_view)
            val checkBox: CheckBox = itemView.findViewById(R.id.students_row_checkBox)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.student_row_layout, parent, false)
            return StudentViewHolder(view)
        }

        override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
            val student = students[position]

            // cancel the previous listener
            holder.checkBox.setOnCheckedChangeListener(null)

            holder.nameTextView.text = student.name
            holder.idTextView.text = student.id
            holder.checkBox.isChecked = student.isChecked

            holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
                student.isChecked = isChecked
            }

            holder.avatarImageView.setImageResource(R.drawable.profile)
        }


        override fun getItemCount(): Int = students.size
    }
}