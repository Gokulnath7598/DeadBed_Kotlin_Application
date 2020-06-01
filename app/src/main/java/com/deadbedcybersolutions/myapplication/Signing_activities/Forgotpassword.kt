package com.deadbedcybersolutions.myapplication.Signing_activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deadbedcybersolutions.myapplication.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgotpassword.*

class Forgotpassword : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)

        auth = FirebaseAuth.getInstance()

        Button.setOnClickListener {
            val Mail: String=Email.text.toString()
            if (TextUtils.isEmpty(Mail)) {
                Toast.makeText(this@Forgotpassword, "Enter Your Registered Email", Toast.LENGTH_SHORT).show()
            } else {
                auth.sendPasswordResetEmail(Mail).addOnCompleteListener(this){task ->
                            if (task.isSuccessful())
                            {
                                Toast.makeText(this,"Email sent Successfully!",Toast.LENGTH_SHORT).show();
                                val g: Intent =Intent(this,
                                    MainActivity::class.java);
                                startActivity(g);
                            }
                            else {
                                Toast.makeText(this,"Error Occured!",Toast.LENGTH_SHORT).show();
                            }

                };
            }
            }
        }
    }

