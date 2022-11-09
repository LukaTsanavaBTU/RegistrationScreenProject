package com.example.registrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etSurname: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var cbAgree: CheckBox
    private lateinit var btRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        etSurname = findViewById(R.id.etSurname)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        cbAgree = findViewById(R.id.cbAgree)
        btRegister = findViewById(R.id.btRegister)

        btRegister.setOnClickListener {

            if (etName.text.toString().length < 3 || etName.text.toString().isEmpty() || etSurname.text.toString().length < 5 || etSurname.text.toString()
                    .isEmpty() || !etName.text.toString().all { it.isLetter() } || !etSurname.text.toString().all { it.isLetter() } ) {
                Toast.makeText(applicationContext, "გთხოვთ, სწორად შეიყვანეთ თქვენი სახელი და გვარი.", Toast.LENGTH_LONG).show()
            }
            else if (!etEmail.text.toString().isValidEmail()) {
                Toast.makeText(applicationContext, "გთხოვთ, სწორად შეიყვანეთ თქვენი მეილი.", Toast.LENGTH_LONG).show()
            }
            else if (etPassword.text.toString().isEmpty() || !etPassword.text.toString().any { it.isDigit() } || etPassword.text.toString().length < 8) {
                Toast.makeText(applicationContext, "გთხოვთ, სწორად შეიყვანეთ თქვენი პაროლი.", Toast.LENGTH_LONG).show()
            }
            else if (!cbAgree.isChecked) {
                Toast.makeText(applicationContext, "თქვენ არ დათანხმებულხართ წესებსა და პირობებს.", Toast.LENGTH_LONG).show()
            }
            else { Toast.makeText(applicationContext, "წარმატებით გაიარეთ რეგისტრაცია!", Toast.LENGTH_LONG).show() }

        }

    }

    fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}