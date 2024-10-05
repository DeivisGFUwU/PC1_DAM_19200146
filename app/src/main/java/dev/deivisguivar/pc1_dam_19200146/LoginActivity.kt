package dev.deivisguivar.pc1_dam_19200146

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        title = "SIGN IN"
        val emailSuccess: String = "invitado@android.com"
        val passwordSuccess: String = "invitado123"

        val etUsuario: EditText = findViewById(R.id.etUsuario)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener{
            val usuario: String = etUsuario.text.trim().toString()
            val password: String = etPassword.text.trim().toString()

            if(usuario == emailSuccess && password == passwordSuccess){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                val rootView: View = findViewById(android.R.id.content)
                Snackbar.make(rootView, "Credenciales Inválidas", Snackbar.LENGTH_LONG).show()
            }
        }


    }
}