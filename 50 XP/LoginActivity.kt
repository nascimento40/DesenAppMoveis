package com.example.provapratica1 // se seu pacote tiver outro nome, altere esta linha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.provapratica1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding // lembre-se de ativar o view binding no gradle!
    private lateinit var dadosLogin: DadosLogin // aqui é a classe do shared preferences. substitua pela sua, se necessário

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        dadosLogin = DadosLogin(this)

        binding.btnEntrar.setOnClickListener {
            validarCampos()
        }


    }

    private fun validarCampos() {

        if (binding.edtEmail.text.isEmpty() ||
            binding.edtSenha.text.isEmpty()) {

            exibirToast("Preencha todos os campos!")
            return
        }

        var email = binding.edtEmail.text.toString()
        var senha = binding.edtSenha.text.toString()

        var sharedEmail = dadosLogin.getEmail()
        var sharedSenha = dadosLogin.getSenha()

        var valoresDiferentes = email != sharedEmail || senha != sharedSenha

        if (valoresDiferentes) {

            exibirToast("E-mail ou Senha inválidos!")
            binding.edtEmail.text.clear()
            binding.edtSenha.text.clear()
            return
        }

        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }

    private fun exibirToast(mensagem : String){
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }
}
