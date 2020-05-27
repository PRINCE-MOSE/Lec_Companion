package com.example.lec_companion_kotlin


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

import kotlinx.android.synthetic.main.activity_lec__home.*

class Lec_Home : AppCompatActivity() {

    var firebaseAuth: FirebaseAuth?=null
    var firebaseDatabase:DatabaseReference?=null
    var firebaseDatabase2:DatabaseReference?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec__home)



        firebaseAuth= FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseAuth?.currentUser!!.uid)
        firebaseDatabase2 = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseAuth?.currentUser!!.uid)


        save_classBtn.setOnClickListener{

    saveclass()

}
        viewLectureBtn.setOnClickListener{

            viewClass()

        }



    }

    private fun saveclass(){

        val lectureTitle = class_name.text.toString().trim()
        val lectureVenue = class_venue.text.toString().trim()
        val lectureTime = class_time.text.toString().trim()


        if (TextUtils.isEmpty(lectureTitle)){

            Toast.makeText(applicationContext,"Please Enter Title of Lecture", Toast.LENGTH_SHORT).show()
        }
        else if (TextUtils.isEmpty(lectureVenue)){

            Toast.makeText(applicationContext,"Please Enter Venue of Lecture", Toast.LENGTH_SHORT).show()
        }
        else if (TextUtils.isEmpty(lectureTime)){

            Toast.makeText(applicationContext,"Please Select Time of Lecture", Toast.LENGTH_SHORT).show()
        }
        else if (TextUtils.isEmpty(lectureTitle) and TextUtils.isEmpty(lectureVenue) and TextUtils.isEmpty(lectureTime)){

            Toast.makeText(applicationContext,"All fields are required", Toast.LENGTH_SHORT).show()
        }
        else{

            val lectureInfo = HashMap<String,Any>()

            lectureInfo.put("Lect_Title", lectureTitle)
            lectureInfo.put("Lect_Venue", lectureVenue)
            lectureInfo.put("Lect_Time", lectureTime)

            firebaseDatabase?.updateChildren(lectureInfo)?.addOnCompleteListener(object : OnCompleteListener<Void>{
                override fun onComplete(task: Task<Void>) {

                    if (task.isSuccessful){

                        Toast.makeText(applicationContext,"Lecture Saved Successfully", Toast.LENGTH_SHORT).show()
                    }
                    else{


                        val error = task?.exception
                        Toast.makeText(applicationContext,"Erorr Occured: $error", Toast.LENGTH_SHORT).show()

                    }
                }


            })

        }

    }

    private fun viewClass(){

        firebaseDatabase?.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {


            }

            override fun onDataChange(task: DataSnapshot) {

                if (task.exists()){

                    val lectureNameStrng = task.child("Lect_Title").value as String
                    val lectureVenueStrng = task.child("Lect_Venue").value as String
                    val lectureTimeStrng = task.child("Lect_Time").value as String


                    lectureName?.text=lectureNameStrng
                    lectureVenue?.text=lectureVenueStrng
                    lectureTime?.text=lectureTimeStrng


                }

            }


        })

    }
}
