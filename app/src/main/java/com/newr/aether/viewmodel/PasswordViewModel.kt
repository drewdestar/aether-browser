package com.newr.aether.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newr.aether.data.local.PasswordDao
import com.newr.aether.model.Password
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PasswordViewModel @Inject constructor(
    private val passwordDao: PasswordDao
) : ViewModel() {
    val passwords: Flow<List<Password>> = passwordDao.getAllPasswords()

    fun deletePassword(id: Long) {
        viewModelScope.launch {
            passwordDao.deleteById(id)
        }
    }

    fun addPassword(domain: String, username: String, password: String) {
        viewModelScope.launch {
            val passwordEntry = Password(
                domain = domain,
                username = username,
                password = password
            )
            passwordDao.insert(passwordEntry)
        }
    }
}
