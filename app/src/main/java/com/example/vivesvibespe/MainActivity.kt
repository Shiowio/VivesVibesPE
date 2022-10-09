package com.example.vivesvibespe

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vivesvibespe.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnapply = binding.btnApply

        btnapply.setOnClickListener {
            val naam = binding.etNaam.text.toString()
            val email = binding.etEmail.text.toString()
            val nummer = binding.etNummer.text.toString()

            val student = Student(naam, email, nummer)
            if (naam.isEmpty() || email.isEmpty() || nummer.isEmpty()) {
                val alertDialog = AlertDialog.Builder(this@MainActivity).create()
                alertDialog.setTitle("NEEN")
                alertDialog.setMessage("Vul alle velden in!")
                alertDialog.setButton(
                    AlertDialog.BUTTON_NEUTRAL, "OK"
                ) { dialog, which -> dialog.dismiss() }
                alertDialog.show()
                }
            else{
            Intent(this, SecondActivity::class.java).also {
                it.putExtra("EXTRA_STUDENT", student)
                startActivity(it)
            }
        }
    }
}}