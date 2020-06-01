package com.deadbedcybersolutions.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.deadbedcybersolutions.myapplication.Signing_activities.MainActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_option.*


class Home : AppCompatActivity() {

   lateinit var homeFragment: HomeFragment
    lateinit var courseFragment: CourseFragment
    lateinit var optionFragment: OptionFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


       homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

        val navView: BottomNavigationView = findViewById(R.id.btm_nav)

        navView.setOnNavigationItemSelectedListener {item ->
            when(item.itemId) {
                R.id.Home -> {

                    homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
                R.id.Courses -> {

                    courseFragment = CourseFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, courseFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
                R.id.Options -> {

                    optionFragment = OptionFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, optionFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }

            };true

        }


    }

}
