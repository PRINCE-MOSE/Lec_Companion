package com.example.lec_companion_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_lecturer__login.*
import maes.tech.intentanim.CustomIntent

class Lecturer_Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecturer__login)
        CustomIntent.customType(this@Lecturer_Login, "fadein-to-fadeout")

        var back_arrow= findViewById<ImageView>(R.id.back_arrow)


        back_arrow.setOnClickListener {

            intent= Intent(this@Lecturer_Login,index::class.java)
            startActivity(intent)

        }



        lecLoginRegBtn.setOnClickListener {

            intent= Intent(this@Lecturer_Login, Lec_Reg::class.java)
            startActivity(intent)

        }


    }
}
