package com.example.calcmid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var buttoncal:Button
    lateinit var buttonint:Button
    lateinit var buttonweb:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttoncal=findViewById(R.id.btn_calc)
        buttonint=findViewById(R.id.btn_intn)
        buttonweb=findViewById(R.id.btn_web)

        buttonweb.setOnClickListener {
            var web=Intent(this,WebActivity::class.java)
            startActivity(web)
        }
        buttonint.setOnClickListener {
            var int=Intent(this,IntentActivity::class.java)
            startActivity(int)
        }
        buttoncal.setOnClickListener {
            var calc=Intent(this,CalcActivity::class.java)
            startActivity(calc)
        }
    }
}