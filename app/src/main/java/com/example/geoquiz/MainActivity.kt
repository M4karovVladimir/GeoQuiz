package com.example.geoquiz

import android.app.AppComponentFactory
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.geoquiz.ui.theme.GeoQuizTheme

class MainActivity : ComponentActivity() {
    private lateinit var questionTextView: TextView
    private lateinit var resultTextView: TextView
    private lateinit var buttonTrue: Button
    private lateinit var buttonFalse: Button
    private lateinit var buttonNext: Button
    private var currentIndex = 0
    private var result = 0

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))

    private fun initElements() {
        questionTextView = findViewById(R.id.question_tv)
        resultTextView = findViewById(R.id.result_tv)
        buttonTrue = findViewById(R.id.true_btn)
        buttonFalse = findViewById(R.id.false_btn)
        buttonNext = findViewById(R.id.next_btn)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linearlayout)

        initElements()

        buttonTrue.setOnClickListener {
            if (questionBank[currentIndex].answer) {
                result++
                resultTextView.setText(result)
                currentIndex = (currentIndex + 1) % questionBank.size
                val questionResId = questionBank[currentIndex].question

                questionTextView.setText(questionResId)
            } else {
                result = 0
                resultTextView.text = "$result"
                currentIndex = (currentIndex + 1) % questionBank.size
                val questionResId = questionBank[currentIndex].question

                questionTextView.setText(questionResId)
            }
        }

        buttonFalse.setOnClickListener {
            if (!questionBank[currentIndex].answer) {
                result++
                resultTextView.text = "$result"
                currentIndex = (currentIndex + 1) % questionBank.size
                val questionResId = questionBank[currentIndex].question

                questionTextView.setText(questionResId)
            } else {
                result = 0
                resultTextView.text = "$result"
                currentIndex = (currentIndex + 1) % questionBank.size
                val questionResId = questionBank[currentIndex].question

                questionTextView.setText(questionResId)
            }
        }

        buttonNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            val questionResId = questionBank[currentIndex].question

            questionTextView.setText(questionResId)
        }
    }
}