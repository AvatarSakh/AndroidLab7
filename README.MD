<h2 align="center">  МИНИСТЕРСТВО НАУКИ И ВЫСШЕГО ОБРАЗОВАНИЯ РОССИЙСКОЙ ФЕДЕРАЦИИ ФЕДЕРАЛЬНОЕ ГОСУДАРСТВЕННОЕ БЮДЖЕТНОЕ ОБРАЗОВАТЕЛЬНОЕ УЧРЕЖДЕНИЕ ВЫСШЕГО ОБРАЗОВАНИЯ «САХАЛИНСКИЙ ГОСУДАРСТВЕННЫЙ УНИВЕРСИТЕТ» </h2>
<div align="center">
<h3>Институт естественных наук и техносферной безопасности
<br>
Кафедра информатики
<br>
Половников Владислав Олегович</h3>

<br>
<h3>Лабораторная работа №7
<br>
“Макет”
<br>
01.03.02 Прикладная математика и информатика</h3>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<h3 align="right">Научный руководитель
<br>
Соболев Евгений Игоревич
</h3>

<h3 align="center">Южно-Сахалинск
<br>
2023г.
</h3>
<hr>
</div>
<p>
Kotlin - это высокоэффективный современный язык программирования, разработанный компанией JetBrains. Он имеет очень чёткий и лаконичный синтаксис, что делает ваш код лёгким для чтения. Kotlin широко используется во всём мире, и его популярность среди разработчиков постоянно растёт. Многие разработчики, использующие Kotlin, отмечают, что это делает их работу быстрее и увлекательнее.
</p>

<h3 align="center">Задание</h3>

Упражнение. Сделать функциональный макет
Необходимо реализовать макет по изображению использую материалы из архива lab7.zip, соблюдая отступы согласно рисунку 1. 

Реализовать простую авторизацию по логину паролю, при удачной попытке вывести пользователю сообщение об авторизации, если пароль логин неверный, то сообщение об ошибке. 



<h1 align="center">Решение</h2>
<h2 align="center">MainActivity</h2>

```kotlin
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

```

<h2 align="center">Accounts</h2>

```kotlin
package com.example.lab7


data class Accounts(val login: String, val password: String)

```

<h2 align="center">activity_main</h2>

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/background"
    android:orientation="vertical">

    <TextView
        android:id="@+id/sign_in"
        android:layout_width="351dp"
        android:layout_height="50dp"
        android:layout_marginStart="32dp"
        android:layout_marginTop="50dp"
        android:layout_marginEnd="32dp"
        android:layout_marginBottom="35dp"
        android:text="@string/sign_in"
        android:textAlignment="center"
        android:textColor="@color/white"
        android:textSize="35dp"
        tools:layout_editor_absoluteY="49dp" />

    <LinearLayout
        android:id="@+id/layout_username"
        android:layout_below="@+id/sign_in"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:layout_marginLeft="10dp"
        android:layout_marginRight="10dp"
        android:orientation="horizontal"
        tools:layout_editor_absoluteX="40dp"
        android:background="#35ffffff">

        <ImageView
            android:id="@+id/imageView2"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:padding="10dp"
            app:srcCompat="@mipmap/ic_human" />

        <EditText
            android:id="@+id/text_username"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textColor="@color/white"
            android:paddingLeft="10dp"
            android:background="@android:color/transparent"
            android:textColorHint="@color/white"
            android:hint="@string/login_username" />
    </LinearLayout>

    <LinearLayout
        android:id="@+id/layout_password"
        android:layout_below="@id/layout_username"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:layout_marginLeft="10dp"
        android:layout_marginRight="10dp"
        android:orientation="horizontal"
        android:background="#35ffffff">

        <ImageView
            android:id="@+id/imageView3"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:padding="10dp"
            app:srcCompat="@android:drawable/ic_dialog_info" />

        <EditText
            android:id="@+id/text_password"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textColor="@color/white"
            android:paddingLeft="10dp"
            android:background="@android:color/transparent"
            android:textColorHint="@color/white"
            android:hint="@string/login_password"/>

    </LinearLayout>

    <Button
        android:id="@+id/button_login"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/layout_password"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="20dp"
        android:layout_marginEnd="317dp"
        android:textColor="@color/white"
        android:backgroundTint="@color/green"
        android:text="@string/button_login" />

    <TextView
        android:id="@+id/textView_forgot"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_below="@id/button_login"
        android:layout_marginTop="20dp"
        android:textColor="@color/white"
        android:text="@string/textview_forgot" />


    <TextView
        android:id="@+id/sign_with"
        android:layout_above="@id/layout_sites"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:text="@string/sign_with" />

    <LinearLayout
        android:id="@+id/layout_sites"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:layout_alignParentBottom="true"
        android:gravity="center"
        android:orientation="horizontal">

        <ImageView
            android:id="@+id/imageGoogle"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:layout_margin="20dp"
            app:srcCompat="@drawable/google" />

        <ImageView
            android:id="@+id/imageFaceBook"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:layout_margin="20dp"
            app:srcCompat="@drawable/fb" />

        <ImageView
            android:id="@+id/imageTwitter"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:layout_margin="20dp"
            app:srcCompat="@drawable/twitter" />
    </LinearLayout>


</RelativeLayout>

```


<h2 align="center">strings</h2>

```kotlin
<resources>
    <string name="app_name">lab7</string>
    <string name="sign_in">Sign in</string>
    <string name="login_username">Username</string>
    <string name="login_password">Password</string>
    <string name="button_login">Login</string>
    <string name="textview_forgot">Forgot password?</string>
    <string name="sign_with">or sign in with</string>
    <string name="success_login">Success login</string>
    <string name="fail_login">Incorrect login or password</string>
    <string name="empty_login">Write your username</string>
    <string name="empty_password">Write your password</string>
</resources>

```
<h2 align="center">Вывод</h2>
Я научился создавать макеты и простую авторизацию
