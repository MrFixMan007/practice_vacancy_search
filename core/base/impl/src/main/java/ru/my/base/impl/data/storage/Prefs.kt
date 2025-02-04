package ru.my.base.impl.data.storage

import android.annotation.SuppressLint
import android.content.SharedPreferences
import javax.inject.Inject

class Prefs @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) {

    @SuppressLint("ApplySharedPref")
    fun clear() {
        sharedPreferences.edit().clear().commit()
    }

    var profileEmail: String by PreferencesDelegate(
        sharedPreferences = sharedPreferences,
        name = ::profileEmail.name,
        defValue = "",
    )
}