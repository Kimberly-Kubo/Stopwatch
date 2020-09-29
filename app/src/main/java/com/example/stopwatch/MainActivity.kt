package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private var wasRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate has been called")
        setContentView(R.layout.activity_main)
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart has been called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume had been called")

        button_main_start.setOnClickListener {
            if (!wasRunning)
            {
                chronometer_main_time.base = SystemClock.elapsedRealtime()
            }
            chronometer_main_time.start()
            wasRunning = true
        }
        button_main_stop.setOnClickListener {
            chronometer_main_time.stop()
            wasRunning = true
        }
        button_main_reset.setOnClickListener {
            chronometer_main_time.base = SystemClock.elapsedRealtime()
            chronometer_main_time.stop()
            wasRunning = false
        }
    }
    override fun onPause()
    {
        super.onPause()
        Log.d(TAG, "onPause has been called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop has been called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart has been called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy has been called")
    }
}