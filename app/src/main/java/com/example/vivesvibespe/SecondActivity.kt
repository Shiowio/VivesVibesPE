package com.example.vivesvibespe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vivesvibespe.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent = getIntent()
        val student = intent.getSerializableExtra("EXTRA_STUDENT") as Student
        val naam = binding.tvNaam
        val studentnr = binding.tvNummer
        val email = binding.tvEmail

        val back = binding.btnBack
        val confirm = binding.btnConfirm

        naam.text = student.Naam
        studentnr.text = student.Studentnummer
        email.text = student.Email

        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        confirm.setOnClickListener {
            Intent(this, ThirdActivity::class.java).also {
                it.putExtra("EXTRA_STUDENT", student)
                startActivity(it)
            }
        }
    }
}