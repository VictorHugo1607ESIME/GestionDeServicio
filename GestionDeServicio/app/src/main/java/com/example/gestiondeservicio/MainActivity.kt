package com.example.gestiondeservicio

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.gestiondeservicio.Login.LoginActivity

class MainActivity : AppCompatActivity() {

    private val duration_splash = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("")
        Handler(Looper.getMainLooper()).postDelayed({
            val Intent = Intent(this, LoginActivity::class.java)
            startActivity(Intent)
            finish()
        }, duration_splash.toLong())
    }
}