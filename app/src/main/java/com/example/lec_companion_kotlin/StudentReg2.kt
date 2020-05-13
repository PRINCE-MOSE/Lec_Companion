package com.example.lec_companion_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.*
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_student_reg2.*

class StudentReg2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_reg2)

       arraySpinnerAdapt()
        stuReg2Back.setOnClickListener {

            startActivity(Intent(applicationContext,Student_Login::class.java))
        }

    }

    private fun arraySpinnerAdapt(){

        val schArrayAdpt=ArrayAdapter(this,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.schools))
        val ssteArrayAdpt=ArrayAdapter(this,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.sste_courses))
        val infocomsArrayAdpt=ArrayAdapter(this,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.Infocoms_courses))
        val bsssArrayAdpt=ArrayAdapter(this,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.Business_courses))
        val sanresArrayAdpt=ArrayAdapter(this,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.sanres_courses))
        val eduArrayAdpt=ArrayAdapter(this,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.Education_courses))
        val sasArrayAdpt=ArrayAdapter(this, android.R.layout.simple_spinner_item,resources.getStringArray(R.array.sas_courses))
        val yearOfStudyAdpt=ArrayAdapter(this,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.yearOfStudy))


        spinner_school.adapter= schArrayAdpt

        spinner_school.onItemSelectedListener=object : OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@StudentReg2,"Select School",Toast.LENGTH_LONG).show()
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                if (position==0){

                    spinner_course.adapter=ssteArrayAdpt

                    spinner_course.onItemSelectedListener=object : OnItemSelectedListener{
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            Toast.makeText(this@StudentReg2,"Select One",Toast.LENGTH_SHORT).show()
                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            if (position==5){

                                course_more.visibility= View.VISIBLE

                            }else {

                                course_more.visibility= View.GONE

                            }
                        }
                    }

                }
                else if (position==1){

                    spinner_course.adapter=infocomsArrayAdpt

                    spinner_course.onItemSelectedListener=object : OnItemSelectedListener{
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            Toast.makeText(this@StudentReg2,"Select One",Toast.LENGTH_SHORT).show()
                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            if (position==3){

                                course_more.visibility= View.VISIBLE

                            }else {

                                course_more.visibility= View.GONE

                            }
                        }
                    }
                }
                else if (position==2){

                    spinner_course.adapter=sanresArrayAdpt

                    spinner_course.onItemSelectedListener=object : OnItemSelectedListener{
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            Toast.makeText(this@StudentReg2,"Select One",Toast.LENGTH_SHORT).show()
                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            if (position==3){

                                course_more.visibility= View.VISIBLE

                            }else {

                                course_more.visibility= View.GONE

                            }
                        }
                    }


                }
                else if (position==3){

                    spinner_course.adapter=eduArrayAdpt

                    spinner_course.onItemSelectedListener=object : OnItemSelectedListener{
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            Toast.makeText(this@StudentReg2,"Select One",Toast.LENGTH_SHORT).show()
                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            if (position==3){

                                course_more.visibility= View.VISIBLE

                            }else {

                                course_more.visibility= View.GONE

                            }
                        }
                    }
                }
                else if (position==4){

                    spinner_course.adapter=bsssArrayAdpt

                    spinner_course.onItemSelectedListener=object : OnItemSelectedListener{
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            Toast.makeText(this@StudentReg2,"Select One",Toast.LENGTH_SHORT).show()
                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            if (position==3){

                                course_more.visibility= View.VISIBLE

                            }else {

                                course_more.visibility= View.GONE

                            }
                        }
                    }
                }
                else if (position==5){

                    spinner_course.adapter=sasArrayAdpt
                    spinner_course.onItemSelectedListener=object : OnItemSelectedListener{
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            Toast.makeText(this@StudentReg2,"Select One",Toast.LENGTH_SHORT).show()
                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            if (position==3){

                                course_more.visibility= View.VISIBLE

                            }else {

                                course_more.visibility= View.GONE

                            }
                        }
                    }
                }

            }
        }

        spinner_YearOfStudy.adapter=yearOfStudyAdpt

    }
}
