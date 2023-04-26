package com.example.retrofitdog

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitdog.apiary.apiaryRequestDTO
import com.example.retrofitdog.apiary.apiaryResponceDTO
import com.example.retrofitdog.apiary.apiaryResponceGetDTO
import com.example.retrofitdog.apiary.serviceApiary
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import java.net.UnknownHostException

class MainRepository() {
    // region variables
    private val _listDogs = MutableLiveData<MutableList<String>>()
    val listDogs: LiveData<MutableList<String>> get() = _listDogs

    private val _msmToast = MutableLiveData<String>()
    val msmToast: LiveData<String> get() = _msmToast
    // endregion variables
    suspend fun getDogForBreed(breed: String){
        withContext(Dispatchers.IO){
            try {
                val responseDog: Response<DogModel> = service.getDogList(breed)
                if(responseDog.isSuccessful){
                    val dogList: DogModel? = responseDog.body()
                    Log.d("MR", dogList.toString())
                    _listDogs.postValue(dogList!!.message)
                    _msmToast.postValue(breed)
                } else {
                    Log.d("MR", "The breed was not found")
                    _msmToast.postValue("The breed was not found")
                }

            }catch (e: UnknownHostException){
                Log.d("MR", e.toString())
            }
        }
    }

    suspend fun apiaryGet(){
        withContext(Dispatchers.IO){
            try {
                val responceApiary: Response<List<apiaryResponceGetDTO>> = serviceApiary.getDataApiaryGet()
                val a = 0
            }catch (e: UnknownHostException){
                Log.d("MR", e.toString())
            }
        }
    }

    suspend fun apiaryPost(){
        withContext(Dispatchers.IO){
            try {
                val responceApiary: Response<List<apiaryResponceDTO>> = serviceApiary.getDataApiaryPost(apiaryRequestDTO("Favourite programming language?", "kotlin"))
                val a = 0
            }catch (e: UnknownHostException){
                Log.d("MR", e.toString())
            }
        }
    }
}