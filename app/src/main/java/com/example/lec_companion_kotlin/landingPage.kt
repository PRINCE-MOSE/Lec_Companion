package com.example.lec_companion_kotlin

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_index.view.*
import kotlinx.android.synthetic.main.terms_alert.*
import maes.tech.intentanim.CustomIntent



class landingPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)
        CustomIntent.customType(this@landingPage, "fadein-to-fadeout")


        var GetStarted_btn= findViewById<Button>(R.id.getStarted_btn)

        var Terms=findViewById<TextView>(R.id.terms)





        GetStarted_btn.setOnClickListener(){

            intent= Intent(this@landingPage,index::class.java)
            startActivity(intent)
        }





        Terms.setOnClickListener {

            val alert= Dialog(this@landingPage)
            alert.setContentView(R.layout.terms_alert)
            // var close=findViewById<Button>(R.id.close_btn)



            alert.show()

           /* close.setOnClickListener {

                alert.dismiss()

            }*/
        }


    }
}
