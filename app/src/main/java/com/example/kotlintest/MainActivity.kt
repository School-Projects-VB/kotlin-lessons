package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlintest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btValidate.setOnClickListener(this)
        binding.btCancel.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val editText = binding.etName
        val radioButtons = arrayOf(binding.rbLike, binding.rbDislike)
        var text: CharSequence = editText.text

        for (rb in radioButtons) {
            if (rb.isChecked) {
                text = rb.text
            }
        }

        when(view) {
            binding.btValidate -> editText.hint = text
            binding.btCancel -> {
                editText.hint = getString(R.string.saisir_nom_ici)
                binding.rgAdvice.clearCheck()
            }
        }
    }
}