package com.example.lec_companion_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_password_reset.*

class PasswordReset : AppCompatActivity() {

    private  var userEmail: EditText? =null
    private  var resetBtn: Button?=null
    private  var firebase:FirebaseAuth?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset)

        var back_arrow=findViewById<ImageView>(R.id.back_arrow)
        userEmail=findViewById(R.id.resetEmail)
        resetBtn=findViewById(R.id.reset_btn)
        firebase= FirebaseAuth.getInstance()

        back_arrow.setOnClickListener {

            intent= Intent(this@PasswordReset,Student_Login::class.java)
            startActivity(intent)

        }

        resetBtn?.setOnClickListener {

            passwordReset()

        }

    }

    private fun passwordReset(){

        var emailText=userEmail?.text.toString().trim()

        if (TextUtils.isEmpty(emailText)){

            Toast.makeText(this@PasswordReset,"A valid Email Is required!",Toast.LENGTH_SHORT).show()
        }

        else{

            firebase?.sendPasswordResetEmail(emailText)?.addOnCompleteListener (object :OnCompleteListener<Void>{
                override fun onComplete(task: Task<Void>) {

                    if (task.isSuccessful){

                        Toast.makeText(applicationContext,"Check Out Your Email",Toast.LENGTH_SHORT).show()

                    }
                    else{

                        var error=task.exception

                        Toast.makeText(applicationContext,"Error: \n"+error,Toast.LENGTH_SHORT).show()

                    }

                }
            })

        }

    }
}
