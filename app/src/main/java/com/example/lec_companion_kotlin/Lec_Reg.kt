package com.example.lec_companion_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import maes.tech.intentanim.CustomIntent

class Lec_Reg : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec__reg)
        CustomIntent.customType(this@Lec_Reg, "fadein-to-fadeout")

        var back_arrow= findViewById<ImageView>(R.id.back_arrow)

        var btn_signIn=findViewById<Button>(R.id.signIn_btn)


        back_arrow.setOnClickListener {

            intent= Intent(this@Lec_Reg,Lecturer_Login::class.java)
            startActivity(intent)

        }


        btn_signIn.setOnClickListener {

            intent= Intent(this@Lec_Reg, Lecturer_Login::class.java)
            startActivity(intent)

        }

    }
}
