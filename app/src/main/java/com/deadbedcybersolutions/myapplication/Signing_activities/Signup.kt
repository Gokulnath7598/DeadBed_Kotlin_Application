package com.deadbedcybersolutions.myapplication.Signing_activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deadbedcybersolutions.myapplication.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class Signup : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        auth = FirebaseAuth.getInstance()

        signin.setOnClickListener {
            val i: Intent = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        signup.setOnClickListener {
            if (TextUtils.isEmpty(mobile.text.toString())) {
                Toast.makeText(this, "Enter your Email", Toast.LENGTH_SHORT).show() }
            else {
                val email: String = mobile.text.toString()
                val emailPattern = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
                if (!email.matches(emailPattern.toRegex())) {
                    Toast.makeText(this, "Please Enter a Valid Email Address!", Toast.LENGTH_SHORT).show() }
                else {
                    if (TextUtils.isEmpty(password.text.toString())) {
                        Toast.makeText(this, "Enter a Password", Toast.LENGTH_SHORT).show() }
                    else {
                        if (TextUtils.isEmpty(confirmpassword.text.toString())) {
                            Toast.makeText(this, "Enter a Password", Toast.LENGTH_SHORT).show() }
                        else {
                            val pass: String = password.text.toString()
                            val passPattern =
                                "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
                            if (!pass.matches(passPattern.toRegex())) {
                                Toast.makeText(
                                    this,
                                    "Please Enter a Valid Password!",
                                    Toast.LENGTH_SHORT
                                ).show() }
                            else {
                                val cpass: String = confirmpassword.text.toString()
                                val pass1: String = password.text.toString()
                                if (!cpass.equals(pass1)) { Toast.makeText(this, "Password Mismatch", Toast.LENGTH_SHORT).show() }
                                else {
                                    val emailf: String = mobile.text.toString()
                                    val passf: String = password.text.toString()
                                    auth.createUserWithEmailAndPassword(emailf, passf).addOnCompleteListener(this) { task ->
                                            if (task.isSuccessful) {
                                                // Sign in success, update UI with the signed-in user's information

                                                Toast.makeText(this, "Account created Successfully!Login now", Toast.LENGTH_SHORT).show()
                                                val j: Intent = Intent(this, MainActivity::class.java)
                                                startActivity(j)
                                                FirebaseAuth.getInstance().signOut()
                                            }
                                            else {
                                                // If sign in fails, display a message to the user.
                                                Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                                            }

                                        }

                                }
                            }
                        }
                    }
                    /* public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }*/
                }
            }
        }
    }
}

