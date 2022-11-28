package com.example.kotlintest

import android.annotation.SuppressLint
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

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onClick(view: View) {
        val imageView = binding.ivAndroid

        when(view) {
            binding.btValidate -> {imageView.setImageDrawable(getDrawable(R.drawable.ic_baseline_flag_24))}
            binding.btCancel -> {imageView.setImageDrawable(getDrawable(R.drawable.ic_baseline_delete_forever_24))}
        }
    }
}