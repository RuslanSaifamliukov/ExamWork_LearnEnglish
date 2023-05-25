package com.example.saifapp5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ListenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listen)
        val alpabet_res:RecyclerView=findViewById((R.id.rec_view))
        alpabet_res.adapter = AlphabetAdapter(this, AlpabetList().list)
    }

    fun GoListen(view: View) {
        val intent = Intent(this@ListenActivity, ListenTestActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun ForwardRegistration(view: View) {
        val intent = Intent(this@ListenActivity, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }
}