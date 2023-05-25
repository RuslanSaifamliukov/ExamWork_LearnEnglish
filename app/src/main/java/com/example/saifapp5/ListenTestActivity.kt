package com.example.saifapp5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.saifapp5.databinding.ActivityListenTestBinding

class ListenTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListenTestBinding
    private lateinit var list: ArrayList<QuestionModel>
    private var count: Int = 0
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListenTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = ArrayList<QuestionModel>()
        list.add(QuestionModel("A", "А","Ай","Эй", "Эй"))
        list.add(QuestionModel("B", "Бэ","Би","Б", "Би"))
        list.add(QuestionModel("C", "Си","С","Сэ", "Си"))
        list.add(QuestionModel("F", "Ф","Эф","Фи", "Эф"))
        list.add(QuestionModel("Q", "Кью","Ку","Кю", "Кью"))
        list.add(QuestionModel("X", "Икс","Ихс","Экс", "Экс"))
        list.add(QuestionModel("Y", "Игрек","Уай","У", "Уай"))
        list.add(QuestionModel("Z", "Зед","З","Зз", "Зед"))
        binding.Question.setText(list.get(0).Question)
        binding.btnAnsverA.setText(list.get(0).btnAnsverA)
        binding.btnAnsverB.setText(list.get(0).btnAnsverB)
        binding.btnAnsverC.setText(list.get(0).btnAnsverC)

        binding.btnAnsverA.setOnClickListener{
            nextData(binding.btnAnsverA.text.toString())
        }
        binding.btnAnsverB.setOnClickListener{
            nextData(binding.btnAnsverB.text.toString())
        }
        binding.btnAnsverC.setOnClickListener{
            nextData(binding.btnAnsverC.text.toString())
        }
    }

    private fun nextData(i: String) {
        if (count<list.size){

            if (list.get(count).RigthAnsver.equals(i)) {
                score++
            }
        }

        count++
        if (count>=list.size)
        {
            val intent = Intent(this@ListenTestActivity, FinishTest::class.java)
            intent.putExtra("Результат", score)
            startActivity(intent)
            finish()
        }
        else
        {
        binding.Question.setText(list.get(count).Question)
        binding.btnAnsverA.setText(list.get(count).btnAnsverA)
        binding.btnAnsverB.setText(list.get(count).btnAnsverB)
        binding.btnAnsverC.setText(list.get(count).btnAnsverC)
        }
    }

    fun BacktoLayoutSignIn(view: View) {
        val intent = Intent(this@ListenTestActivity, SignInActivity::class.java)
        startActivity(intent)
        finish()}
}