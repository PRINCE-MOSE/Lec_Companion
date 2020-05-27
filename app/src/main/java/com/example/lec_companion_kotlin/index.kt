package com.example.lec_companion_kotlin

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.ncorti.slidetoact.SlideToActView
import kotlinx.android.synthetic.main.activity_index.*
import maes.tech.intentanim.CustomIntent

class index : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)
        CustomIntent.customType(this@index, "left-to-right")

        var StudentSlider=findViewById<SlideToActView>(R.id.slider_student)

        var LecSlider=findViewById<SlideToActView>(R.id.slider_lecturer)

        copyright.setOnClickListener {

            val alert= Dialog(this@index)
            alert.setContentView(R.layout.terms_alert)

             //var close=findViewById<Button>(R.id.close_btn)

            alert.show()

            //close.setOnClickListener { alert.dismiss() }

        }

        StudentSlider.onSlideCompleteListener= object : SlideToActView.OnSlideCompleteListener{

            override fun onSlideComplete(view: SlideToActView) {

                intent= Intent(this@index,Student_Login::class.java)

                Toast.makeText(this@index,"Please SignIn to Proceed", Toast.LENGTH_LONG).show()

                startActivity(intent)



            }


        }

        LecSlider.onSlideCompleteListener=object : SlideToActView.OnSlideCompleteListener{

            override fun onSlideComplete(view: SlideToActView) {

                intent= Intent(this@index,Lecturer_Login::class.java)

                Toast.makeText(this@index,"Please SignIn to Proceed", Toast.LENGTH_LONG).show()

                startActivity(intent)

            }

        }

    }
}
