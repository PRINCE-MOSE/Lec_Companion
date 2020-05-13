package com.example.lec_companion_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ncorti.slidetoact.SlideToActView
import maes.tech.intentanim.CustomIntent

class index : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)
        CustomIntent.customType(this@index, "left-to-right")

        var StudentSlider=findViewById<SlideToActView>(R.id.slider_student)

        var LecSlider=findViewById<SlideToActView>(R.id.slider_lecturer)

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
