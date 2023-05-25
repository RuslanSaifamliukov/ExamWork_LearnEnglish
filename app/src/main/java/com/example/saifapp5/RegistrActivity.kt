package com.example.saifapp5

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Pattern

class RegistrActivity : AppCompatActivity()
{
    var preff: SharedPreferences? = null
    val pattern2 = ("[a-zA-Z]{1,34}")
    val pattern = ("[a-z0-9A-Z]{1,34}" + "@" + "[a-z]{1,6}" + "\\." + "[a-z]{1,5}")
    val pattern3 = ("[a-z0-9A-Z]{1,34}")

    lateinit var name: TextInputEditText
    lateinit var mail: TextInputEditText
    lateinit var pass: TextInputEditText
    lateinit var repass: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registr)
        name = findViewById(R.id.etName)
        mail = findViewById(R.id.etMail)
        pass = findViewById(R.id.etPassword)
        repass = findViewById(R.id.etConfirmPassword)
        preff = getSharedPreferences("TABLEE", MODE_PRIVATE)
        name.setText(preff?.getString("key1", ""))
        mail.setText(preff?.getString("key2", ""))
        pass.setText(preff?.getString("key3", ""))
    }

    fun emailVaild(text: String): Boolean {
        return Pattern.compile(pattern).matcher(text).matches()
    }
    fun nameVaild(text: String): Boolean {
        return Pattern.compile(pattern2).matcher(text).matches()
    }
    fun passVaild(text: String): Boolean {
        return Pattern.compile(pattern3).matcher(text).matches()
    }
    fun saveData(name: String, mail: String, pass: String) {
        val editor = preff?.edit()
        editor?.putString("key1", name)
        editor?.putString("key2", mail)
        editor?.putString("key3", pass)
        editor?.apply()
    }

    fun ButRegistr(view: View)
    {
        if (name.text.toString().isNotEmpty() &&
            mail.text.toString().isNotEmpty() &&
            pass.text.toString().isNotEmpty() &&
            repass.text.toString().isNotEmpty())
        {
            if (nameVaild(name.text.toString()))
            {
                if (emailVaild(mail.text.toString()))
                {
                    if (passVaild(pass.text.toString())&&passVaild(repass.text.toString()))
                    {
                        val value: String = name.text.toString()
                        val value2: String = mail.text.toString()
                        val value3: String = pass.text.toString()
                        if(pass.text.toString()==repass.text.toString())
                        {
                            saveData(value, value2, value3)
                            val intent = Intent(this@RegistrActivity, SignInActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(this, "Регистрация прошла успешно!", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                        else
                        {
                            Toast.makeText(this, "Пароли не совпадают!", Toast.LENGTH_SHORT).show()
                        }
                    }
                    else
                    {
                        Toast.makeText(this, "Пароль содержит не допустимые символы!", Toast.LENGTH_SHORT).show()
                    }
                }
                else
                {
                    Toast.makeText(this, "E-mail введён не корректно!", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(this, "Имя или Фамилия содержит не допустимые символы!", Toast.LENGTH_SHORT).show()
            }
        }
        else
        {
            Toast.makeText(this, "Заполните пустые поля!", Toast.LENGTH_SHORT).show()
        }
    }

    fun BackToSignIn(view: View) {
        val intent = Intent(this@RegistrActivity, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }
}