package com.example.pegeorangoai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initComponents()
    }

    private fun initComponents(){
        btnLogin.setOnClickListener {
            var tudoOk = true
            val email = tiLoginEmail.editText?.text.toString()
            val senha = tiLoginSenha.editText?.text.toString()

            if(email.isBlank()){
                tiLoginEmail.error = getString(R.string.campo_obrigatorio, getString(R.string.email))
                tudoOk = false
            } else {
                tiLoginEmail.isErrorEnabled = false
                if(!email.contains('@')){
                    tiLoginEmail.error = getString(R.string.email_invalido)
                    tudoOk = false
                } else{
                    tiLoginEmail.isErrorEnabled = false
                }
            }

            if(senha.isBlank()){
                tiLoginSenha.error = getString(R.string.campo_obrigatorio, getString(R.string.password))
                tudoOk = false
            } else {
                tiLoginSenha.isErrorEnabled = false
            }

            if(tudoOk){
                val mainIntent = Intent(this, MainActivity::class.java)
                startActivity(mainIntent)
            }

        }

        btnRegister.setOnClickListener {
            val cadastroIntent = Intent(this, CadastroActivity::class.java)
            startActivity(cadastroIntent)
        }
    }
}