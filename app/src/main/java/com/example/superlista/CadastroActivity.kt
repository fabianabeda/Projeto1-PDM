package com.example.superlista

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class CadastroActivity : AppCompatActivity() {
    private lateinit var etNome: EditText
    private lateinit var etQuantidade: EditText
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button
    private lateinit var dao: ProdutoDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        this.etNome = findViewById(R.id.etNome)
        this.etQuantidade = findViewById(R.id.etQuantidade)
        this.btSalvar = findViewById(R.id.btSalvar)
        this.btCancelar = findViewById(R.id.btCancelar)
        this.dao = ProdutoDAO(this)

        this.btSalvar.setOnClickListener(onClickSalvar())
        this.btCancelar.setOnClickListener(onClickCancelar())
    }
    inner class onClickSalvar : View.OnClickListener {
        override fun onClick(v: View?) {
            val nome = this@CadastroActivity.etNome.text.toString()
            val quantidade = this@CadastroActivity.etQuantidade.text.toString().toInt()
            val produto = Produto(nome, quantidade)

            val intent = Intent()
            intent.putExtra("Produto", produto)
            setResult(Activity.RESULT_OK, intent)
            finish()

        }

    }
    //inner class onClickSalvar : View.OnClickListener {
        //override fun onClick(p0: View?) {
            //val nome = this@CadastroActivity.etNome.text.toString()
            //val quantidade = this@CadastroActivity.etQuantidade.text.toString().toInt()
            //val produto = Produto(nome, quantidade)
            //this@CadastroActivity.dao.insert(produto)
            //finish()


    inner class onClickCancelar : View.OnClickListener {
        override fun onClick(p0: View?) {
            finish()
        }
    }
}

