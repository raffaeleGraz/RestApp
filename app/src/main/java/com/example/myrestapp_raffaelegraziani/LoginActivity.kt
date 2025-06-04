package com.example.myrestapp_raffaelegraziani

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.security.MessageDigest

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val inputUsername = findViewById<EditText>(R.id.inputUsername)
        val inputPassword = findViewById<EditText>(R.id.inputPassword)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener { // Click del bottone
            // Recupera l'input dell'utente sotto forma di stringa
            val username = inputUsername.text.toString()
            val password = md5(inputPassword.text.toString()) // Codifica la password per non averla in chiaro

            // Verifica la correttezza delle credenziali
            if(checkLogin(username, password)) {
                val mioToast = Toast.makeText(this, "Accesso eseguito!", Toast.LENGTH_SHORT)
                mioToast.show()

                // Passaggio al menù
                intent(MenuActivity::class.java)
            } else{
                val mioToast = Toast.makeText(this, "Credenziali errate!", Toast.LENGTH_SHORT)
                mioToast.show()
            }
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

    // Funzione per crittografare in md5
    private fun md5(input: String): String {
        val bytes = MessageDigest.getInstance("MD5").digest(input.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

}