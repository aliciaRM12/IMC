package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imc.databinding.ActivitySecondBinding
import java.text.DecimalFormat

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private var peso: Double = 0.0
    private var altura: Double = 0.0
    private var sexo: String = ""
    private var imc: Double = 0.0
    var imcFormat: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        peso = intent.extras?.getDouble("peso") ?:0.0
        binding.tvPeso.text = peso.toString()

        altura = intent.extras?.getDouble("altura") ?: 0.0
        binding.tvAltura.text = altura.toString()

        sexo = intent.extras?.getString("sexo") ?: ""
        imc = peso/(altura*altura/10000)
        imcFormat = String.format("%.1f",imc)

        binding.button.setOnClickListener{

            binding.tvObtenido.text = "IMC: ${imcFormat.toString()}"
            binding.tvSexo.text = "Sexo: ${sexo.toString()}"

            if(sexo.equals("Masculino")){
                when(imc){
                    in 0.0..18.5->{
                        binding.ivIcono.setImageResource(R.drawable.estado1)
                        binding.tvEstado.text = "Bajo peso"
                    }
                    in 18.6..24.9 ->{
                        binding.ivIcono.setImageResource(R.drawable.estado2)
                        binding.tvEstado.text = "Peso normal"
                    }
                    in 25.0 .. 29.9 ->{
                        binding.ivIcono.setImageResource(R.drawable.estado3)
                        binding.tvEstado.text = "Pre-obesidad o Sobrepeso"
                    }
                    in 30.0 .. 34.9 ->{
                        binding.ivIcono.setImageResource(R.drawable.estado4)
                        binding.tvEstado.text = "Obesidad clase I"
                    }
                    in 35.0 .. 39.9 ->{
                        binding.ivIcono.setImageResource(R.drawable.estado5)
                        binding.tvEstado.text = "Obesidad clase II"
                    }
                    else -> {
                        binding.ivIcono.setImageResource(R.drawable.estado6)
                        binding.tvEstado.text = "Obesidad clase III"
                    }
                }
            }else{
                when(imc){
                    in 0.0..16.5-> {
                        binding.ivIcono.setImageResource(R.drawable.estado1)
                        binding.tvEstado.text = "Bajo peso"
                    }
                    in 16.6..22.9 -> {
                        binding.ivIcono.setImageResource(R.drawable.estado2)
                        binding.tvEstado.text = "Peso normal"
                    }
                    in 23.0 .. 25.9 -> {
                        binding.ivIcono.setImageResource(R.drawable.estado3)
                        binding.tvEstado.text = "Pre-obesidad o Sobrepeso"
                    }
                    in 26.0 .. 30.9 -> {
                        binding.ivIcono.setImageResource(R.drawable.estado4)
                        binding.tvEstado.text = "Obesidad clase I"
                    }
                    in 31.0 .. 33.9 -> {
                        binding.ivIcono.setImageResource(R.drawable.estado5)
                        binding.tvEstado.text = "Obesidad clase II"
                    }
                    else -> {
                        binding.ivIcono.setImageResource(R.drawable.estado6)
                        binding.tvEstado.text = "Obesidad clase III"
                    }
                }
            }
        }
    }
}