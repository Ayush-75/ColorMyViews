package com.example.colormyviews

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()


    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(
            binding.boxOneText,
            binding.boxTwoText,
            binding.boxThreeText,
            binding.boxFourText,
            binding.boxFiveText,
            binding.constraintLayout,
            binding.redButton,
            binding.greenButton,
            binding.yellowButton
        )

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }


    private fun makeColored(view: View) {

        when (view.id) {

            // Boxes using Color class colors for background
            binding.boxOneText.id -> binding.boxOneText.setBackgroundColor(Color.DKGRAY)
            binding.boxTwoText.id -> binding.boxTwoText.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            binding.boxThreeText.id -> binding.boxThreeText.setBackgroundResource(android.R.color.holo_green_light)
            binding.boxFourText.id -> binding.boxFourText.setBackgroundResource(android.R.color.holo_green_dark)
            binding.boxFiveText.id -> binding.boxFiveText.setBackgroundResource(android.R.color.holo_green_light)


            binding.redButton.id -> apply {
                binding.boxThreeText.setBackgroundResource(R.color.my_red)
                binding.redButton.setBackgroundColor(ContextCompat.getColor(this, R.color.my_red))

            }
            binding.yellowButton.id -> apply {
                binding.boxFourText.setBackgroundResource(R.color.my_yellow)
                binding.yellowButton.setBackgroundColor(ContextCompat.getColor(this,R.color.my_yellow))
            }
            binding.greenButton.id -> apply {
                binding.boxFiveText.setBackgroundResource(R.color.my_green)
                binding.greenButton.setBackgroundColor(ContextCompat.getColor(this,R.color.my_green))
            }

            else -> binding.root.setBackgroundColor(Color.LTGRAY)

        }


    }
}