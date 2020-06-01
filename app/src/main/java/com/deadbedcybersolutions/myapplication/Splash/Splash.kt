package com.deadbedcybersolutions.myapplication.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.deadbedcybersolutions.myapplication.R
import com.deadbedcybersolutions.myapplication.Signing_activities.MainActivity

class Splash : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler=Handler()
        handler.postDelayed({
            val i: Intent= Intent(this,
                MainActivity::class.java)
            startActivity(i)
            finish()
        },  2000)

    }
}
