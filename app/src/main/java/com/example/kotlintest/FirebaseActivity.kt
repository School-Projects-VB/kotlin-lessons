package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.kotlintest.databinding.ActivityFirebaseBinding
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.google.firebase.auth.FirebaseAuth


class FirebaseActivity : AppCompatActivity() {

    private val binding by lazy { ActivityFirebaseBinding.inflate(layoutInflater) }

    private val signInLauncher = registerForActivityResult(FirebaseAuthUIActivityResultContract()) {
        it.idpResponse?.error?.printStackTrace()
        refreshScreen()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvConnexion.setOnClickListener {
            val providers = arrayListOf(
                AuthUI.IdpConfig.EmailBuilder().build(),
                AuthUI.IdpConfig.PhoneBuilder().build(),
                AuthUI.IdpConfig.GoogleBuilder().build()
            )

            val signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setLogo(R.mipmap.ic_launcher)
                .build()

            signInLauncher.launch(signInIntent)
        }

        binding.tvDeconnexion.setOnClickListener {
            AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener { refreshScreen() }
        }
    }

    override fun onStart() {
        super.onStart()
        refreshScreen()
    }


    private fun refreshScreen() {
        val user = FirebaseAuth.getInstance().currentUser
        binding.tvName.text = user?.displayName ?: "---"
        binding.fab.isVisible = user != null

        if (user != null) {
            binding.tvConnexion.isVisible = false
            binding.tvDeconnexion.isVisible = true
        } else {
            binding.tvConnexion.isVisible = true
            binding.tvDeconnexion.isVisible = false
        }
    }
}