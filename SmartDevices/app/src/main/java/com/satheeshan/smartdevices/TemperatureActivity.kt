package com.satheeshan.smartdevices


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class TemperatureActivity : AppCompatActivity() {
    lateinit var txtValTemp: TextView
    lateinit var txtValHum: TextView
    private lateinit var txtValSound:TextView
    lateinit var btnCheck:Button
    private lateinit var database: DatabaseReference
    private val CHANNEL_ID="channel_id_example_01"
    private val notificationId=101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature)
        database = Firebase.database.reference
        txtValHum = findViewById(R.id.txtValHum)
        txtValSound=findViewById(R.id.txtValSound)
        txtValTemp = findViewById(R.id.txtValTemp)
        btnCheck=findViewById(R.id.btnCheck)
        sendNotification()
        val url = "https://iot-6f673-default-rtdb.firebaseio.com/"
        btnCheck.setOnClickListener {
            database.child("temp").get().addOnSuccessListener {
                txtValTemp.text = it.value.toString()
            }
            database.child("sound").get().addOnSuccessListener {
                txtValSound.text = it.value.toString()
            }
            database.child("humidity").get().addOnSuccessListener {
                txtValHum.text = it.value.toString()
            }
        }
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name ="Notification title"
            val descriptionText ="description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
    private  fun sendNotification() {
        database.child("temp").get().addOnSuccessListener {
            txtValTemp.text = it.value.toString()
            database.child("sound").get().addOnSuccessListener {
                txtValSound.text = it.value.toString()
                database.child("humidity").get().addOnSuccessListener {
                    txtValHum.text = it.value.toString()

                    var temp=(txtValTemp.text as String)
                    var hum=txtValHum.text
                    var sound=txtValSound.text
                    when(temp> 25.toString()){

                    }

                        val intent = Intent(this, TemperatureActivity::class.java).apply {
                            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        }
                        val pendingIntent: PendingIntent =
                            PendingIntent.getActivity(this, 0, intent, 0)

                        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.loginlogo)
                            .setContentTitle("Temperature and Humidity")
                            .setContentText(temp.toString())
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            .setContentIntent(pendingIntent)
                            .setAutoCancel(true)
                        with(NotificationManagerCompat.from(this)) {
                            notify(notificationId, builder.build())
                        }
                }
            }
        }
    }
}