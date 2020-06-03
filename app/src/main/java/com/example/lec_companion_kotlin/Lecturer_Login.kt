package com.example.lec_companion_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_lecturer__login.*
import maes.tech.intentanim.CustomIntent

class Lecturer_Login : AppCompatActivity() {

    private var firebaseAuth: FirebaseAuth?=null

    private var dataBase= FirebaseDatabase.getInstance()
    private var myref=dataBase.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecturer__login)
        CustomIntent.customType(this@Lecturer_Login, "fadein-to-fadeout")


        firebaseAuth= FirebaseAuth.getInstance()

        var back_arrow= findViewById<ImageView>(R.id.back_arrow)


        back_arrow.setOnClickListener {

            intent= Intent(this@Lecturer_Login,index::class.java)
            startActivity(intent)

        }


        lecLogin_btn.setOnClickListener{
            loginLecturer()

        }

        lecLoginRegBtn.setOnClickListener {

            intent= Intent(this@Lecturer_Login, Lec_Reg::class.java)
            startActivity(intent)

        }


    }

    private fun loginLecturer(){

        var emailText=lecLoginEmail.text.toString().trim()
        var passwd=lecLogin_pass.text.toString().trim()

        if (TextUtils.isEmpty(emailText) && TextUtils.isEmpty(passwd)){


            Toast.makeText(applicationContext,"All the fields are required", Toast.LENGTH_SHORT).show()


        } else if (TextUtils.isEmpty(emailText)){

            Toast.makeText(applicationContext,"Email is required", Toast.LENGTH_SHORT).show()

        }

        else if (TextUtils.isEmpty(passwd)){

            Toast.makeText(applicationContext,"Password is required", Toast.LENGTH_SHORT).show()

        }

        else{

            firebaseAuth?.signInWithEmailAndPassword(emailText,passwd)?.addOnCompleteListener(object :
                OnCompleteListener<AuthResult> {
                override fun onComplete(task: Task<AuthResult>) {

                    if (task.isSuccessful){


                        //Post the data to the firebase User table
                        var currentUser=firebaseAuth?.currentUser
                        myref.child("Lecturers").child(currentUser!!.uid).setValue(currentUser!!.email)

                        Toast.makeText(applicationContext,"Successful Login", Toast.LENGTH_LONG).show()
                        startActivity(Intent(applicationContext,Lec_Profile::class.java))

                    }
                    else{

                        var error=task.exception?.message

                        Toast.makeText(applicationContext,"Error: "+error, Toast.LENGTH_SHORT).show()

                    }


                }

            })

        }


    }
}
