package com.Sutabah.JenisJenisHewan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Sutabah.JenisJenisHewan.databinding.ActivityLoginBinding
import com.Sutabah.JenisJenisHewan.databinding.ActivityMainBinding

private lateinit var binding: ActivityLoginBinding
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialisasi binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnlogin.setOnClickListener {
            val dataLogin = ModelLogin(binding.txtuser.text.toString(),binding.txtpass.text.toString())
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("data", dataLogin)
            startActivity(intent)
            finish()
        }
    }
}