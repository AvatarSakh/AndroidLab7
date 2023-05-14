package com.example.lab7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var usernameText: EditText
    private lateinit var passwordText: EditText
    private lateinit var loginButton: Button

    private val accountList = listOf(
        Accounts("admin","1234"),
        Accounts("test1","111"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameText = findViewById(R.id.text_username)
        passwordText = findViewById(R.id.text_password)
        loginButton = findViewById(R.id.button_login)

        loginButton.setOnClickListener{
            val username = usernameText.text.toString()
            val password = passwordText.text.toString()
            var textFail = false

            if (TextUtils.isEmpty(username)) {
                Toast.makeText(this,R.string.empty_login,Toast.LENGTH_SHORT).show()
                textFail = true
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this,R.string.empty_password,Toast.LENGTH_SHORT).show()
                textFail = true
            }

            if (textFail == false){
                val foundAccount = accountList.find{ it.login == username}
                if(foundAccount == null) Toast.makeText(this,R.string.fail_login,Toast.LENGTH_SHORT).show()
                else {
                    if(foundAccount.password != password) Toast.makeText(this,R.string.fail_login,Toast.LENGTH_SHORT).show()
                    else Toast.makeText(this,R.string.success_login,Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}