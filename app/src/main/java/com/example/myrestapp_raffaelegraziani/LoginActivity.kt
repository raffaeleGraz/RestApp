package com.example.myrestapp_raffaelegraziani

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            intent(MenuActivity::class.java)
        }
    }

    private fun intent(nomeActivity: Class<*>){ //Lancia l'intent dal nome per parametro
        val intent = Intent(this, nomeActivity)
        startActivity(intent)
    }
}