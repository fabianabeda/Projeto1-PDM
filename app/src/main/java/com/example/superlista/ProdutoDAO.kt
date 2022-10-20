package com.example.superlista


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import androidx.core.content.contentValuesOf

class ProdutoDAO {
    var banco: BancoHelper

    constructor(context: Context){
        this.banco = BancoHelper(context)
    }

    fun insert(produto: Produto){
        val cv = ContentValues()
        cv.put("nome", produto.nome )
        cv.put("quantidade", produto.quantidade)
        this.banco.writableDatabase.insert("produto", null, cv)
    }

    fun get(id: Int): Produto?{
        return null
    }

    fun get(): ArrayList<Produto>{
        val lista = arrayListOf<Produto>()
        val colunas = arrayOf("id", "nome", "quantidade")
        val c = this.banco.readableDatabase.query("produtos", colunas, null, null, null, null, null)
        c.moveToFirst()
        for (i in 1 .. c.count){
            val id = c.getInt(0)
            val nome = c.getString(1)
            val quantidade = c.getInt(2)
            val produto = Produto(id, nome, quantidade)
            lista.add(produto)
            c.moveToNext()
        }

        return lista
    }

    fun update(id: Int, produto: Produto){

    }
    fun delete(id: Int){

    }

}
