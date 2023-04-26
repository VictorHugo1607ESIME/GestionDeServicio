package com.example.retrofitdog

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class MainViewModel(application: Application): AndroidViewModel(application) {
    // region variables
    private val mainRepository = MainRepository()
    private val _dogList = MutableLiveData<MutableList<String>>()
    val dogList: LiveData<MutableList<String>> get() = _dogList

    private val _msmToast = MutableLiveData<String>()
    val msmToast: LiveData<String> get() = _msmToast
    // endregion variables

    // region function
    init {
        initObservables()
    }

    fun getBreed(breed: String){
        viewModelScope.launch {
            try {
                //mainRepository.getDogForBreed(breed)
                mainRepository.apiaryPost()
            }catch (e: UnknownHostException){
                Log.d("MainViewModel", e.toString())
            }
        }
    }

    private fun initObservables() {
        mainRepository.listDogs.observeForever {
            _dogList.value = it
        }

        mainRepository.msmToast.observeForever {
            _msmToast.value = it
        }
    }
    // endregion function
}