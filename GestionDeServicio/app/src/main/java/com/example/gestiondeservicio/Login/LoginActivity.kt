package com.example.gestiondeservicio.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.gestiondeservicio.Activitys.Conditions.ConditionsActivity
import com.example.gestiondeservicio.Fragments.Conditions.ConditionsFragment
import com.example.gestiondeservicio.R
import com.example.gestiondeservicio.databinding.ActivityLoginBinding
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    // region variables
    private lateinit var binding: ActivityLoginBinding
    private lateinit var user: EditText
    private lateinit var btnAccess: MaterialButton
    private lateinit var conditionsText: TextView
    // endregion variables

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    //region functions
    fun initUI(){
        setTitle("Login")
        conditionsText = binding.conditions
        user = binding.etUser
        btnAccess = binding.btnAccess
        listeners()
    }
    
    fun listeners(){
        conditionsText.setOnClickListener{
            val Intent = Intent(this, ConditionsActivity::class.java)
            startActivity(Intent)
            finish()
        }

        btnAccess.setOnClickListener{
            showToast("Usuario y/o contraseña incorrectos")
        }
    }

    fun showToast(msm: String){
        Toast.makeText(this, msm, Toast.LENGTH_LONG).show()
    }
    //endregion functions
}