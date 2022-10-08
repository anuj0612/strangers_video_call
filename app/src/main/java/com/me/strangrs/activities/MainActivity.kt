package com.me.strangrs.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.me.strangrs.databinding.ActivityMainBinding
import com.me.strangrs.model.User
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var currentUser: FirebaseUser
    private lateinit var user: User
    private var coins: Long = 500

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        currentUser = auth.currentUser!!

        binding.coins.text = "You have: 500"

        Glide.with(this)
            .load(currentUser.photoUrl)
            .into(binding.profilePicture)

        binding.findButton.setOnClickListener {
            if (coins > 5) {
                startActivity(Intent(this, ConnectingActivity::class.java))
            } else {
                Toast.makeText(this, "Insufficient balance", Toast.LENGTH_SHORT).show()

            }
        }
    }
}