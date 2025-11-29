package com.example.mycard2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val data: Intent? = result.data
        if (data != null) { // Check that we have data returned
            val question = data.getStringExtra("Question") // 'string1' needs to match the key we used when we put the string in the Intent
            val answer = data.getStringExtra("Answer")

            // Log the value of the strings for easier debugging
            Log.i("MainActivity", "Question: $question")
            Log.i("MainActivity", "Answer: $answer")

            findViewById<TextView>(R.id.Card_question).text=question
            findViewById<TextView>(R.id.Card_answer).text=answer
        } else {
            Log.i("MainActivity", "Returned null data from MainActivity2")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val mycard_question =findViewById<TextView>(R.id.Card_question)
        val mycard_answer =findViewById<TextView>(R.id.Card_answer)

        mycard_question.setOnClickListener {
            mycard_question.visibility = View.INVISIBLE
            mycard_answer.visibility = View.VISIBLE
        }

        findViewById<View>(R.id.myButton).setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            resultLauncher.launch(intent)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}