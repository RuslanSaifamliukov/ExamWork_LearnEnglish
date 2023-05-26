package com.example.saifapp5

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.saifapp5.databinding.ActivityFinishTestBinding

class FinishTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinishTestBinding
    lateinit var preff: SharedPreferences
    lateinit var name: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        name = findViewById(R.id.FinishName)
        binding.TextFinishScore.setText("Ваш результат:\n ${intent.getIntExtra("Результат", 0)}")
        preff = getSharedPreferences("TABLEE", MODE_PRIVATE)
        name.setText(preff?.getString("key1", ""))
    }

    fun FinishGoBack(view: View) {
        val intent = Intent(this@FinishTestActivity, ListenActivity::class.java)
        startActivity(intent)
        finish()
    }
}