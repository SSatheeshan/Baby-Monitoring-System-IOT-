package com.satheeshan.smartdevices

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    val validUsername="Team11"
    val validPassword="bms"
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        title = "Login"
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)


        btnLogin.setOnClickListener {
            val username= etUsername.text.toString()
            val password=etPassword.text.toString()
            if ((username==validUsername)&&(password==validPassword)){
                val intent = Intent(this@LoginActivity,MainActivity::class.java)
                startActivity(intent)
            }
            else{
            Toast.makeText(
                this@LoginActivity,
                "Invalid Credentials",
                Toast.LENGTH_LONG
            ).show()
            }

        }
    }

}