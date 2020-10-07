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
    private var timeWhenStopped = 0L
    //private val KEY_TIME_ELAPSED = "elapsed time"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate has been called")
        setContentView(R.layout.activity_main)

        //?. builds an if not null
        //?: is the elvis operator. what comes after is the default value is what comes before is null
        //timeElapsed = savedInstanceState?.getLong(KEY_TIME_ELAPSED) ?: 0L

        button_main_start.setOnClickListener {
            if (!wasRunning)
            {
                chronometer_main_time.base = SystemClock.elapsedRealtime()
            }
            else
            {
                chronometer_main_time.base = SystemClock.elapsedRealtime() - timeWhenStopped
            }
            chronometer_main_time.start()
            timeWhenStopped = 0
            wasRunning = true
            button_main_start.isEnabled = false
        }
        button_main_stop.setOnClickListener {
            timeWhenStopped = SystemClock.elapsedRealtime() - chronometer_main_time.base
            chronometer_main_time.stop()
            wasRunning = true
            button_main_start.isEnabled = true
        }
        button_main_reset.setOnClickListener {
            chronometer_main_time.base = SystemClock.elapsedRealtime()
            chronometer_main_time.stop()
            wasRunning = false
            timeWhenStopped = 0
            button_main_start.isEnabled = true
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart has been called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume had been called")
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