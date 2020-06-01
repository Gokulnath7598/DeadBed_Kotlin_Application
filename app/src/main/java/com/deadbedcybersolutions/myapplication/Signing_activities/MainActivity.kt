package com.deadbedcybersolutions.myapplication.Signing_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.deadbedcybersolutions.myapplication.Home
import com.deadbedcybersolutions.myapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        Signup.setOnClickListener {
            val i: Intent= Intent(this,
                com.deadbedcybersolutions.myapplication.Signing_activities.Signup::class.java)
            startActivity(i)
        }
        Forgot.setOnClickListener {
            val l: Intent=Intent(this,
                Forgotpassword::class.java)
            startActivity(l)
        }
        Signin.setOnClickListener {
            if (TextUtils.isEmpty(Mobile.text.toString())) {
                Toast.makeText(this, "Enter your Mobile Number", Toast.LENGTH_SHORT).show()
            } else {
                if (TextUtils.isEmpty(Password.text.toString())) {
                    Toast.makeText(this, "Enter your Password", Toast.LENGTH_SHORT).show()
                } else {
                    val email: String = Mobile.text.toString()
                    val pass: String = Password.text.toString()
                    auth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                val user = auth.currentUser
                                updateUI(user)
                                val j: Intent = Intent(this, Home::class.java)
                                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                                startActivity(j)
                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                                //updateUI(null)
                            }
                        }

                }
            }
        }
    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }
    private fun updateUI(currentUser: FirebaseUser?){
        if (currentUser!=null){
            startActivity(Intent(this,
                Home::class.java))
        }
        else{

        }
    }
}
