package com.example.superlista

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private lateinit var buttonADD: FloatingActionButton
    private lateinit var lvProdutos: ListView
    private lateinit var dao: ProdutoDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        this.lvProdutos = findViewById(R.id.lvProdutos)
        this.dao = ProdutoDAO(this)
        this.buttonADD = findViewById(R.id.buttonADD)

        buttonADD.setOnClickListener {
            outroResult.launch(Intent(this, CadastroActivity::class.java))
            startActivity(intent)
        }

    }

    val outroResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK){
            val produto = it.data?.getSerializableExtra("produto") as Produto
            //Log.i("SUPERLISTA", "Produto: ${produto.nome} - ${produto.quantidade}")
            this.dao.insert(produto)
            //Log.e("SUPERLISTA", this.dao.get().toString())
                }
            }

        }
