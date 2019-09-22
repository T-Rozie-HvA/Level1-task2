package com.rozie.logicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_logica_app.*

class LogicaAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logica_app)
        btnSubmit.setOnClickListener {
            checkAnswer()
        }
    }

    private fun checkAnswer() {
        var result = false
        var wrongInput = false

        val answerTT = et_Answer_tt.text.toString()
        val answerTF = et_Answer_tf.text.toString()
        val answerFT = et_Answer_ft.text.toString()
        val answerFF = et_Answer_ff.text.toString()

        // check if answers only contain T or F
        val answers = listOf(answerTT, answerTF, answerFT, answerFF)

        for (answer in answers) {
            if (answer != "T" && answer != "F") {
                wrongInput = true
            }
        }

        // check if answer is correct
        if (answerTT == getString(R.string.True)) {
            if (answerTF == getString(R.string.False)) {
                if (answerFT == getString(R.string.False)) {
                    if (answerFF == getString(R.string.False)) {
                        result = true
                    }
                }
            }
        }

        // prints te result in a toaster
        if (wrongInput) {
            Toast.makeText(this, getString(R.string.WrongInput), Toast.LENGTH_LONG).show()
        }
        else if (result) {
            Toast.makeText(this, getString(R.string.Correct), Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(this, getString(R.string.Incorrect), Toast.LENGTH_LONG).show()

        }
    }
}
