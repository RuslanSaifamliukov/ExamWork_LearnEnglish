package com.example.saifapp5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.saifapp5.databinding.ActivityFinishTestBinding

class FinishTest : AppCompatActivity() {
    private lateinit var binding: ActivityFinishTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.TextFinishScore.setText("Ваш результат:\n ${intent.getIntExtra("Результат", 0)}")
    }
}