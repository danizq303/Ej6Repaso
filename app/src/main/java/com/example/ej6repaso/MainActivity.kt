package com.example.ej6repaso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.ej6repaso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (binding.button.text == "Comenzar") {
                binding.button.setText("Finalizar")
                binding.editTextTextPersonName.visibility = View.VISIBLE
            } else {
                binding.button.setText("Comenzar")
                binding.editTextTextPersonName.visibility = View.INVISIBLE
            }
        }

        binding.editTextTextPersonName.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.editTextTextPersonName.setText("")
            } else
                binding.editTextTextPersonName.setText("Introduce tu nombre")
        }

        binding.editTextTextPersonName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.editTextTextPersonName.text.toString() == "Wayne") {
                    binding.imageView2.visibility = View.VISIBLE
                } else if (binding.editTextTextPersonName.text.toString() == "Joker") {
                    binding.root.setBackgroundColor(resources.getColor(R.color.purple_200))
                    binding.editTextTextPersonName.setTextColor(resources.getColor(R.color.white))
                    binding.editTextTextPersonName2.setTextColor(resources.getColor(R.color.white))
                } else {
                    binding.imageView2.visibility = View.INVISIBLE
                    binding.editTextTextPersonName.setTextColor(resources.getColor(R.color.black))
                    binding.editTextTextPersonName2.setTextColor(resources.getColor(R.color.black))
                    binding.root.setBackgroundColor(resources.getColor(R.color.white))
                }
            }
        })

    }
}