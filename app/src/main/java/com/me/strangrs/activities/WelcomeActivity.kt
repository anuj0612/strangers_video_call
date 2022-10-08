package com.me.strangrs.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.me.strangrs.R
import com.me.strangrs.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        if(auth.currentUser !=null){
            goToNext()
        }

        findViewById<Button>(R.id.BTN_welcome).setOnClickListener {
           goToNext()
        }
    }
    private fun goToNext(){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}