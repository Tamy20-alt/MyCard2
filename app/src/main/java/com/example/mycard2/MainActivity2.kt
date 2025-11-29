package com.example.mycard2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val questionField = findViewById<EditText>(R.id.add_question)
        val answerField = findViewById<EditText>(R.id.add_answer)
        val saveBtn = findViewById<ImageView>(R.id.image2)
        val cancelBtn = findViewById<ImageView>(R.id.image1)

        cancelBtn.setOnClickListener { setResult(RESULT_CANCELED)
        finish()
        }

        saveBtn.setOnClickListener {
            val userQuestion = questionField.text.toString()
            val userAnswer = answerField.text.toString()

            val data = Intent()

            data.putExtra(
                "Question",
                userQuestion
            )

            data.putExtra(
                "Answer",
                userAnswer
            )

            setResult(RESULT_OK, data)
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}