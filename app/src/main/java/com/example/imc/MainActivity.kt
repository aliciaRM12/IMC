package com.example.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.view.isNotEmpty
import com.example.imc.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private var sexo: String = ""
    var idSexo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if(binding.etPeso.text.isNullOrEmpty() || binding.etAltura.text.isNullOrEmpty()){
                Snackbar.make(binding.root,"Rellene todos los campos",Snackbar.LENGTH_SHORT).show()
            }else{
                var peso = binding.etPeso.text.toString().toDouble()
                var altura = binding.etAltura.text.toString().toDouble()
                val intent = Intent(applicationContext,SecondActivity::class.java)
                intent.putExtra("peso", peso)
                intent.putExtra("altura", altura)

                if(binding.radioGroup.checkedRadioButtonId == binding.rbMas.id){
                    idSexo = binding.rbMas.id
                    sexo = "Masculino"
                }else{
                    sexo = "Femenino"
                    idSexo = binding.rbFem.id
                }
                intent.putExtra("sexo", sexo)
                startActivity(intent)
            }
        }
    }
}