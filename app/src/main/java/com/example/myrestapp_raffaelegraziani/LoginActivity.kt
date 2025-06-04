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

    // Lancia l'intent dal nome per parametro
    private fun intent(nomeActivity: Class<*>){
        val intent = Intent(this, nomeActivity)
        startActivity(intent)
    }

    // Controlla le credenziali di login
    private fun checkLogin(inputUsername: String, inputPassword: String): Boolean{
        // Credenziali corrette per il login
        val credenziali = mapOf( // Array associativo
            "admin" to "21232f297a57a5a743894a0e4a801fc3", // Username e password crittografata
            "user" to "ee11cbb19052e40b07aac0ca060c23ee"
        )
        return credenziali[inputUsername] == inputPassword // True se le credenziali sono state trovate
    }

}