package com.example.gestiondeservicio.Activitys.Conditions

import android.R
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.gestiondeservicio.databinding.ActivityConditionsBinding

class ConditionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConditionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConditionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle("Terminos y condiciones")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                onBackPressed()  // method deprecated
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}