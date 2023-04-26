package com.example.testventuressoft.login

import android.app.Application
import android.provider.Settings.System.getString
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testventuressoft.R
import kotlinx.coroutines.launch

class LoginViewModel(application: Application): AndroidViewModel(application) {

    // region variables
    private val _messageStatus = MutableLiveData<String>()
    val messageStatus: LiveData<String> get() = _messageStatus
    private val loginRepository = LoginRepository()
    // endregion variables

    fun evaluateParameters(email: String, pass: String){
        if(email.isEmpty() || pass.isEmpty()){
            _messageStatus.value = getApplication<Application>().getString(R.string.fieldsEmpty)
            return
        }
        viewModelScope.launch {
            loginRepository.loginAccess(email, pass)
        }
    }
}