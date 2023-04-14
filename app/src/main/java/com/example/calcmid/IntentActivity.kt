package com.example.calcmid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class IntentActivity : AppCompatActivity() {
    //sms,call,dial,share,camera,stk(mpesa)
    lateinit var smsbtn:Button
    lateinit var dail:Button
    lateinit var call:Button
    lateinit var share:Button
    lateinit var camera:Button
    lateinit var mpesa:Button
    lateinit var email:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        smsbtn=findViewById(R.id.btn_sms)
        share=findViewById(R.id.btn_Share)
        call=findViewById(R.id.btn_call)
        mpesa=findViewById(R.id.btn_mpesa)
        dail=findViewById(R.id.btn_dial)
        camera=findViewById(R.id.btn_camera)
        email=findViewById(R.id.btn_email)

        smsbtn.setOnClickListener {
            val uri=Uri.parse("smsto:07456789")

            val intent = Intent(Intent.ACTION_SENDTO, uri)

            intent.putExtra("Hello", "How is todays weather")

            startActivity(intent)
        }
        camera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)

        }
        call.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"))

            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }
        share.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

            startActivity(shareIntent)

        }
        mpesa.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitLaunchIntent?.let { startActivity(it) }

        }
        dail.setOnClickListener {
            val phone = "+34666777888"

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

            startActivity(intent)

        }
        email.setOnClickListener {

            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }
    }
}