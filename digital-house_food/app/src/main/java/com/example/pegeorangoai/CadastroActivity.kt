package com.example.pegeorangoai

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*


class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        replaceActionBar()
        initComponents()
    }

    fun replaceActionBar(){
        val actionbar = supportActionBar
        //set actionbar title
        actionbar?.title = "Register"
        //set back button
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initComponents(){

        btnConcluirRegister.setOnClickListener {

            var tudoOk = true
            val nome = tiRegisterName.editText?.text.toString()
            val email = tiRegisterEmail.editText?.text.toString()
            val senha = tiRegisterSenha.editText?.text.toString()
            val confirmarSenha = tiRegisterConfirmarSenha.editText?.text.toString()


            if(nome.isBlank()){
                tiRegisterName.error = getString(R.string.campo_obrigatorio, getString(R.string.nome_cadastro))
                tudoOk = false
            } else {
                tiRegisterName.isErrorEnabled = false
            }

            if(email.isBlank()){
                tiRegisterEmail.error = getString(R.string.campo_obrigatorio, getString(R.string.email_cadastro))
                tudoOk = false
            } else {
                tiRegisterEmail.isErrorEnabled = false
                if(!email.contains('@')){
                    tiRegisterEmail.error = getString(R.string.email_invalido)
                    tudoOk = false
                } else{
                    tiRegisterEmail.isErrorEnabled = false
                }
            }

            if(senha.isBlank()){
                tiRegisterSenha.error = getString(R.string.campo_obrigatorio, getString(R.string.password_cadastro))
                tudoOk = false
            } else {
                tiRegisterSenha.isErrorEnabled = false
            }

            if(confirmarSenha.isBlank()){
                tiRegisterConfirmarSenha.error = getString(R.string.campo_obrigatorio, getString(R.string.confirm_password))
                tudoOk = false
            } else {
                tiRegisterConfirmarSenha.isErrorEnabled = false
                if (senha != confirmarSenha){
                    tiRegisterConfirmarSenha.error = getString(R.string.senhas_diferentes)
                    tudoOk = false
                } else {
                    tiRegisterConfirmarSenha.isErrorEnabled = false
                }
            }

            if(tudoOk){
                val mainIntent = Intent(this, MainActivity::class.java)
                startActivity(mainIntent)
            }
        }
    }
}