package com.example.product.core

import android.content.Context
import android.content.SharedPreferences

object UserSession {

    private val IS_LOGIN = "isLogin"

    const val PREF_NAME = "com.ameen.productlist.PREFERENCE_FILE_KEY"

    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    fun init(context: Context) {
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = pref.edit()
    }

    fun saveUserLogin() {
        editor.putBoolean(IS_LOGIN, true)
        editor.apply()
    }

    fun getUserIsLogin() = pref.getBoolean(IS_LOGIN, false)


    fun removeUserSession() {

        clearSharedPreferences()
        editor.putBoolean(IS_LOGIN, false)
        editor.apply()
    }

    private fun clearSharedPreferences() {
        editor.clear()
        editor.apply()
    }

}