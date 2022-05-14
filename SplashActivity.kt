package com.rasid.pasarraya

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

import com.rasid.pasarraya.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var ssCl: ConstraintLayout
    private lateinit var ssSr: ProgressBar
    private lateinit var logo: ImageView
    private lateinit var logoAnimation: AnimationDrawable
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()

        ssCl = findViewById(R.id.splash_screen_constraint_layout)
        ssSr = findViewById(R.id.progressBar)
        logo = findViewById(R.id.logo)
        logo.apply {
            setBackgroundResource(R.drawable.logo_animation)
            logoAnimation = background as AnimationDrawable
        }
        logo.visibility = View.GONE

        ssSr.visibility = View.VISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
            ssSr.visibility = View.GONE
        }, 4000)

        Handler(Looper.getMainLooper()).postDelayed({
            logo.visibility = View.VISIBLE
            logoAnimation.start()
        }, 6000)

        Handler(Looper.getMainLooper()).postDelayed({
            ssSr.visibility = View.GONE
            ssCl.setBackgroundColor(
                ContextCompat.getColor(applicationContext,
                    R.color.dark_green))
            logo.setBackgroundColor(Color.TRANSPARENT)
            logo.setImageResource(R.drawable.logo2)
            logoAnimation.stop()
        }, 10000)

        Handler(Looper.getMainLooper()).postDelayed({

            // Check if we're running on Android 5.0 or higher
            val intent = Intent(this, MainActivity::class.java)
            val bundle: Bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent,bundle)
            finish()


        }, 12000)
    }
}