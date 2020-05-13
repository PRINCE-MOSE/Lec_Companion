package com.example.lec_companion_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import maes.tech.intentanim.CustomIntent

class Student_Login : AppCompatActivity() {

    private var user_email_view: TextView?=null
    private var user_pass: TextView?=null
    private var login_btn:Button?=null
    private var firebaseAuth: FirebaseAuth?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student__login)
        CustomIntent.customType(this@Student_Login, "fadein-to-fadeout")


        val back_arrow= findViewById<ImageView>(R.id.back_arrow)
        val btn_signup=findViewById<Button>(R.id.stuLoginRegBtn)
        val resetPass=findViewById<TextView>(R.id.forgot_pass)


        back_arrow.setOnClickListener {

            intent= Intent(this@Student_Login,index::class.java)
            startActivity(intent)

        }

        btn_signup.setOnClickListener {

            intent= Intent(this@Student_Login,Student_Reg::class.java)
            startActivity(intent)

        }

        resetPass.setOnClickListener {

            intent= Intent(this@Student_Login,PasswordReset::class.java)
            startActivity(intent)

        }

        user_email_view=findViewById(R.id.stuLoginEmail)
        user_pass=findViewById(R.id.stuLoginPass)
        firebaseAuth= FirebaseAuth.getInstance()
        login_btn=findViewById(R.id.stuLoginBtn)

        login_btn?.setOnClickListener {

            loginStudent()
        }



    }

    private fun loginStudent(){

        var emailText=user_email_view?.text.toString().trim()
        var passwd=user_pass?.text.toString().trim()

        if (TextUtils.isEmpty(emailText) && TextUtils.isEmpty(passwd)){


            Toast.makeText(applicationContext,"All the fields are required", Toast.LENGTH_SHORT).show()


        } else if (TextUtils.isEmpty(emailText)){

            Toast.makeText(applicationContext,"Email is required",Toast.LENGTH_SHORT).show()

        }

        else if (TextUtils.isEmpty(passwd)){

            Toast.makeText(applicationContext,"Password is required",Toast.LENGTH_SHORT).show()

        }

        else{

            firebaseAuth?.signInWithEmailAndPassword(emailText,passwd)?.addOnCompleteListener(object :OnCompleteListener<AuthResult>{
                override fun onComplete(task: Task<AuthResult>) {

               if (task.isSuccessful){

                   Toast.makeText(applicationContext,"Successful Login",Toast.LENGTH_SHORT).show()

               }
                    else{

                   var error=task.exception?.message

                   Toast.makeText(applicationContext,"Error: "+error,Toast.LENGTH_SHORT).show()

               }


                }

            })

        }


    }


}
