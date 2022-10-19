package com.example.superlista

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHelper(context: Context?) : SQLiteOpenHelper(context, "produtos.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table if not exists produtos(" +
                "id integer primary key autoincrement," +
                "none text," +
                "quantidade integer" +
                ")"

        db?.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}