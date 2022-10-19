package com.example.superlista

import java.util.*
import java.io.Serializable

class Produto : Serializable{
    var id: Int
    var nome: String
    var quantidade: Int

    constructor(nome: String, quantidade: Int){
        this.id = -1
        this.nome = nome
        this.quantidade = quantidade

    }

    constructor(id: Int, nome: String, quantidade: Int){
        this.id = id
        this.nome = nome
        this.quantidade = quantidade
    }

    override fun toString(): String {
        return "${nome} - ${quantidade}"
    }

}