package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlintest.databinding.ActivityCreateGameBinding
import java.util.*

class CreateGameActivity : AppCompatActivity() {
    private val binding by lazy { ActivityCreateGameBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvAdd.setOnClickListener {
            val match = MatchBean(null, binding.etTeam1.text.toString(), binding.etTeam2.text.toString(), null, 0, 0, Date().time)

            MatchFirebaseRepo.create(match)
                .addOnSuccessListener {
                    Toast.makeText(this, "Matche ajouté id=${it.id}", Toast.LENGTH_LONG).show()
                    finish()
                }
                .addOnFailureListener {
                    binding.tvError.text = "Erreur lors de la création du matche : ${it.message}"
                    it.printStackTrace()
                }
        }
    }
}