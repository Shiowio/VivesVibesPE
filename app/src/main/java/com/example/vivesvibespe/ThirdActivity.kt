package com.example.vivesvibespe

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vivesvibespe.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private  lateinit var binding : ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val student = intent.getSerializableExtra("EXTRA_STUDENT") as Student

        binding.tvNaam.text = student.Naam
        binding.tvEmail.text = student.Email
        binding.tvNummer.text = student.Studentnummer
        binding.btnVibe.setOnClickListener {
            val link = Intent(Intent.ACTION_VIEW)
            link.data = Uri.parse("https://www.youtube.com/watch?v=eBGIQ7ZuuiU")
            startActivity(link)
        }
    }
}