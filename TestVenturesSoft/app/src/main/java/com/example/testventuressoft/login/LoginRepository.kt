package com.example.testventuressoft.login

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class LoginRepository() {
    //region variables
    //endregion variables

    //region functions
    suspend fun loginAccess(email: String, pass: String){
        withContext(Dispatchers.IO){
            try {
                val loginService = service.loginAccess(Params(email, pass))
                if (loginService.isSuccessful){
                    Log.d("LoginRepository", "Is Successful")
                }else{
                    Log.d("LoginRepository", "Is dont Successful")
                }
            }catch (e: UnknownHostException){
                Log.d("LoginRepository", e.toString())
            }

        }
    }
    //endregion functions
}