package com.example.lec_companion_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import maes.tech.intentanim.CustomIntent.customType
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : AppCompatActivity() {

    private var mFirebaseAnalytics: FirebaseAnalytics? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customType(this@MainActivity,"fadein-to-fadeout")


        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)

        var skip_btn= findViewById<Button>(R.id.skip_btn)
        var start_btn=findViewById<Button>(R.id.start_btn)
        start_btn.visibility= View.VISIBLE


        skip_btn.setOnClickListener(){

            var intent= Intent(this@MainActivity,Stu_Home::class.java)

            startActivity(intent)

        }

        start_btn.setOnClickListener(){

          ChangeText1()

        }

        next_btn.setOnClickListener {

            ChangeText2()
        }

        finish_btn.setOnClickListener {

            ChangeText3()

            var intent= Intent(this@MainActivity,index::class.java)

            startActivity(intent)

        }

    }

fun ChangeText1(){

    var launcher_text=findViewById<TextView>(R.id.launcher_text)

    var textToShow = "2.\n Increase Your Performance in Studies"
    launcher_text.text=textToShow

    start_btn.visibility= View.GONE
    next_btn.visibility=View.VISIBLE


}
    fun ChangeText2(){

    var launcher_text=findViewById<TextView>(R.id.launcher_text)

    var textToShow = "3.\n Eliminate the Captivity of Negativity"
    launcher_text.text=textToShow

    next_btn.visibility= View.GONE
    finish_btn.visibility=View.VISIBLE

}
    fun ChangeText3(){

    var launcher_text=findViewById<TextView>(R.id.launcher_text)

    var textToShow = "4.\n Have the best Companion for your Study..Lets Go"
    launcher_text.text=textToShow

    finish_btn.visibility= View.GONE

}

    override fun onResume() {
        super.onResume()

        start_btn.visibility=View.VISIBLE
    }

    }


