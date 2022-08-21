package com.example.sayac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.core.view.marginEnd
import androidx.core.view.marginRight
import com.example.sayac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var value: Int = 0
    private var runnable: Runnable = Runnable {}
    private var handler = Handler(Looper.myLooper()!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        init()
    }

    private fun init() {
        binding.textView.text = "Sayaç: ${value}"
        binding.startButton.setOnClickListener {
            startCounter()
            binding.startButton.visibility = View.GONE
        }
        binding.stopButton.setOnClickListener {
            stopCounter()
            binding.startButton.visibility = View.VISIBLE
        }
    }

    private fun startCounter() {
        // value = 0

        runnable = Runnable {
            value++
            binding.textView.text = "Sayaç: ${value}"
            handler.postDelayed(runnable, 1000)
        }
        handler.post(runnable)
    }

    private fun stopCounter() {
        value = 0
        binding.textView.text = "Sayaç: ${value}"
        handler.removeCallbacks(runnable)
    }
}