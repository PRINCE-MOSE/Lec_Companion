package com.example.lec_companion_kotlin

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.*
import kotlinx.android.synthetic.main.activity_index.view.*
import kotlinx.android.synthetic.main.activity_student_reg2.*

class StudentReg2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_reg2)

        arraySpinnerAdapt()

        stuReg2Back.setOnClickListener {

            startActivity(Intent(applicationContext, Student_Login::class.java))
        }




        stuReg2SubmitBtn.setOnClickListener {


            InsertData()

        }


        browse_pic.setOnClickListener{

            //check runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE)
                }
                else{
                    //permission already granted
                    pickImageFromGallery()
                }
            }
            else{
                //system OS is < Marshmallow
                pickImageFromGallery()
            }
        }



    }




    fun InsertData() {

        val DB = SQhelper(applicationContext)

        val fnameStrng = fname.text.toString().trim()
        val mnameStrng = mname.text.toString().trim()
        val lnameStrng = lname.text.toString().trim()
        val regNoStrng = regNo.text.toString().trim()
        val schoolStrng = spinner_school.selectedItem.toString().trim()
        val courseStrng = spinner_course.selectedItem.toString().trim()
        val yearstrng = spinner_YearOfStudy.selectedItem.toString().trim()
        val phoneStrng = phone.text.toString().trim()


        //DB.ADD_DATA(fnameStrng,mnameStrng,lnameStrng,regNoStrng,schoolStrng,courseStrng,yearstrng,phoneStrng,courseMoreStrng)
        DB.ADD_DATA(
            fnameStrng,
            mnameStrng,
            lnameStrng,
            regNoStrng,
            schoolStrng,
            courseStrng,
            yearstrng,
            phoneStrng
        )

        Toast.makeText(this@StudentReg2, "Completed Successfully...", Toast.LENGTH_SHORT).show()

        startActivity(Intent(this@StudentReg2, Stu_Home::class.java))

    }

    private fun arraySpinnerAdapt() {

        val schArrayAdpt = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.schools)
        )
        val ssteArrayAdpt = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.sste_courses)
        )
        val infocomsArrayAdpt = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.Infocoms_courses)
        )
        val bsssArrayAdpt = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.Business_courses)
        )
        val sanresArrayAdpt = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.sanres_courses)
        )
        val eduArrayAdpt = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.Education_courses)
        )
        val sasArrayAdpt = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.sas_courses)
        )
        val yearOfStudyAdpt = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.yearOfStudy)
        )


        spinner_school.adapter = schArrayAdpt

        spinner_school.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@StudentReg2, "Select School", Toast.LENGTH_LONG).show()
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {


                var selectedSchool = spinner_school.selectedItem as String

                checkSchoolbtn.setOnClickListener {

                    Toast.makeText(
                        applicationContext,
                        "Your School Is $selectedSchool",
                        Toast.LENGTH_SHORT
                    ).show()

                }


                if (position == 0) {

                    spinner_course.adapter = ssteArrayAdpt

                    spinner_course.onItemSelectedListener = object : OnItemSelectedListener {
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            Toast.makeText(this@StudentReg2, "Select One", Toast.LENGTH_SHORT)
                                .show()
                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            if (position == 5) {

                                course_more.visibility = View.VISIBLE

                            } else {

                                course_more.visibility = View.GONE

                            }
                        }
                    }

                } else if (position == 1) {

                    spinner_course.adapter = infocomsArrayAdpt

                    spinner_course.onItemSelectedListener = object : OnItemSelectedListener {
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            Toast.makeText(this@StudentReg2, "Select One", Toast.LENGTH_SHORT)
                                .show()
                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            if (position == 3) {

                                course_more.visibility = View.VISIBLE

                            } else {

                                course_more.visibility = View.GONE

                            }
                        }
                    }
                } else if (position == 2) {

                    spinner_course.adapter = sanresArrayAdpt

                    spinner_course.onItemSelectedListener = object : OnItemSelectedListener {
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            Toast.makeText(this@StudentReg2, "Select One", Toast.LENGTH_SHORT)
                                .show()
                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            if (position == 3) {

                                course_more.visibility = View.VISIBLE

                            } else {

                                course_more.visibility = View.GONE

                            }
                        }
                    }


                } else if (position == 3) {

                    spinner_course.adapter = eduArrayAdpt

                    spinner_course.onItemSelectedListener = object : OnItemSelectedListener {
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            Toast.makeText(this@StudentReg2, "Select One", Toast.LENGTH_SHORT)
                                .show()
                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            if (position == 3) {

                                course_more.visibility = View.VISIBLE

                            } else {

                                course_more.visibility = View.GONE

                            }
                        }
                    }
                } else if (position == 4) {

                    spinner_course.adapter = bsssArrayAdpt

                    spinner_course.onItemSelectedListener = object : OnItemSelectedListener {
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            Toast.makeText(this@StudentReg2, "Select One", Toast.LENGTH_SHORT)
                                .show()
                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            if (position == 3) {

                                course_more.visibility = View.VISIBLE

                            } else {

                                course_more.visibility = View.GONE

                            }
                        }
                    }
                } else if (position == 5) {

                    spinner_course.adapter = sasArrayAdpt
                    spinner_course.onItemSelectedListener = object : OnItemSelectedListener {
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            Toast.makeText(this@StudentReg2, "Select One", Toast.LENGTH_SHORT)
                                .show()
                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            if (position == 3) {

                                course_more.visibility = View.VISIBLE

                            } else {

                                course_more.visibility = View.GONE

                            }
                        }
                    }
                }

            }
        }

        spinner_YearOfStudy.adapter = yearOfStudyAdpt

    }


    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;
        //Permission code
        private val PERMISSION_CODE = 1001;
    }

    //handle requested permission result
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    //permission from popup granted
                    pickImageFromGallery()
                } else {
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            profile_pic.setImageURI(data?.data)
        }

    }

}
