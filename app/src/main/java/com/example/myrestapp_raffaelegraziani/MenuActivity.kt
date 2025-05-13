package com.example.myrestapp_raffaelegraziani

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnNetflix = findViewById<ImageButton>(R.id.btnNetflix)
        btnNetflix.setOnClickListener {
            intent(WebViewActivity::class.java)
        }
    }

    private fun intent(nomeActivity: Class<*>){ //Lancia l'intent dal nome per parametro
        val intent = Intent(this, nomeActivity)
        startActivity(intent)
    }
}