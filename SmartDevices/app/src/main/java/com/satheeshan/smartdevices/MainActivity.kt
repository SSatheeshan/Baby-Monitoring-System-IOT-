package com.satheeshan.smartdevices

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_streaming.*

class MainActivity : AppCompatActivity() {
    lateinit var  btn2:Button
    lateinit var  btn1:Button
    lateinit var  btn3:Button
    lateinit var  btn4:Button
    lateinit var  btn5:Button
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="Baby Monitoring System"
        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)
        btn3=findViewById(R.id.btn3)
        btn4=findViewById(R.id.btn4)
        btn5=findViewById(R.id.btn5)
        database = Firebase.database.reference
        btn1.setOnClickListener {
          val i=packageManager.getLaunchIntentForPackage("com.satheeshan.ipro")
            if(i!=null){
                startActivity(i)
            }else{
                Toast.makeText(
                    this@MainActivity,
                    "Live Streaming is being opened",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        btn2.setOnClickListener {
        val intent=Intent(this@MainActivity,TemperatureActivity::class.java)
            startActivity(intent)
        }
        btn3.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "Gentle Swing is on ",
                Toast.LENGTH_LONG
            ).show()
            fun writeNewUser() {
                database.child("gentleSwing").setValue("1").toString()
            }
            writeNewUser()
        }
        btn4.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "Strong Swing is on ",
                Toast.LENGTH_LONG
            ).show()
            fun writeNewUser() {
                database.child("strongSwing").setValue("1").toString()
            }
            writeNewUser()
        }
        btn5.setOnClickListener {
            database.child("strongSwing").setValue("0").toString()
            database.child("gentleSwing").setValue("0").toString()
            Toast.makeText(this@MainActivity,"Swing is stopped",Toast.LENGTH_LONG).show()
        }


    }


}
