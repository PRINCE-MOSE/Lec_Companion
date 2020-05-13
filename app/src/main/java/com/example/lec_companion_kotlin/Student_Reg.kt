package com.example.lec_companion_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_student__reg.*
import maes.tech.intentanim.CustomIntent


class Student_Reg : AppCompatActivity() {


    private var user_email_view:EditText?=null
    private var user_pass1:EditText?=null
    private var user_pass2:EditText?=null
    private var regBtn:Button?=null
    private var firebaseAuth: FirebaseAuth?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student__reg)
        CustomIntent.customType(this@Student_Reg, "fadein-to-fadeout")




        user_email_view=stuReg1Email
        user_pass1=stuReg1Pass
        user_pass2=confirm_password
        regBtn=stuReg1SubmitBtn
        firebaseAuth=FirebaseAuth.getInstance()


        regBtn?.setOnClickListener {

           userReg()

        }

        back_arrow.setOnClickListener {

            intent= Intent(this@Student_Reg,Student_Login::class.java)
            startActivity(intent)

        }


        stuReg1SignInBtn.setOnClickListener {

            intent= Intent(this@Student_Reg, StudentReg2::class.java)
            startActivity(intent)


        }


    }


    private fun userReg(){

        //Check Fields

        var emailText= user_email_view?.text.toString().trim()
        var pass1= user_pass1?.text.toString().trim()
        var pass2= user_pass2?.text.toString().trim()


        if (TextUtils.isEmpty(emailText) && TextUtils.isEmpty(pass1) && TextUtils.isEmpty(pass2)){

        Toast.makeText(applicationContext,"All the fields are required",Toast.LENGTH_SHORT).show()


        }

        else if (TextUtils.isEmpty(emailText)){

            Toast.makeText(applicationContext,"An Email is required",Toast.LENGTH_SHORT).show()
        }


        else if (TextUtils.isEmpty(pass1)){

            Toast.makeText(applicationContext,"A Password is required",Toast.LENGTH_SHORT).show()
        }

        else if ((pass1) != (pass2)){

            Toast.makeText(applicationContext,"Passwords do not match!",Toast.LENGTH_SHORT).show()
        }

        else{


            firebaseAuth?.createUserWithEmailAndPassword(emailText,pass1)?.addOnCompleteListener(object: OnCompleteListener<AuthResult>{
                override fun onComplete(task: Task<AuthResult>) {

                    if (task.isSuccessful){


                        Toast.makeText(applicationContext,"Account Created Successfully...",Toast.LENGTH_SHORT).show()

                        intent = Intent(this@Student_Reg,StudentReg2::class.java)
                        startActivity(intent)



                    }

                    else{

                        var error=task.exception?.message

                       Toast.makeText(applicationContext,"Error"+ error,Toast.LENGTH_SHORT).show()



                    }

                }


            })

        }



    }


}
