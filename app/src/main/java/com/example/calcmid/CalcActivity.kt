package com.example.calcmid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalcActivity : AppCompatActivity() {
    lateinit var Tv_answer:TextView
    lateinit var add:Button
    lateinit var min:Button
    lateinit var div:Button
    lateinit var mult:Button
    lateinit var frstNo:EditText
    lateinit var scndNo:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
        Tv_answer=findViewById(R.id.txt_answer)
        add=findViewById(R.id.btn_add)
        min=findViewById(R.id.btn_mns)
        div=findViewById(R.id.btn_dvd)
        mult=findViewById(R.id.btn_mult)
        frstNo=findViewById(R.id.Edt_nmbr)
        scndNo=findViewById(R.id.Edt_nmbr2)

        add.setOnClickListener {
            var myfrstNo=frstNo.text.toString()
            var mysecNo=scndNo.text.toString()
            if(myfrstNo.isEmpty()&&myfrstNo.isEmpty()){
                Tv_answer.text="please Input a Number"
            }else{
                var answer=myfrstNo.toDouble() + mysecNo.toDouble()
                Tv_answer.text=answer.toString()
            }
        min.setOnClickListener {
            var myfrstNo=frstNo.text.toString()
            var mysecNo=scndNo.text.toString()
            if(myfrstNo.isEmpty()&&myfrstNo.isEmpty()){
                Tv_answer.text="please Input a Number"
            }else{
                var answer=myfrstNo.toDouble() - mysecNo.toDouble()
                Tv_answer.text=answer.toString()
            }
        }
            mult.setOnClickListener {
                var myfrstNo=frstNo.text.toString()
                var mysecNo=scndNo.text.toString()
                if(myfrstNo.isEmpty()&&myfrstNo.isEmpty()){
                    Tv_answer.text="please Input a Number"
                }else{
                    var answer=myfrstNo.toDouble() * mysecNo.toDouble()
                    Tv_answer.text=answer.toString()
                }
            }
            div.setOnClickListener {
                var myfrstNo=frstNo.text.toString()
                var mysecNo=scndNo.text.toString()
                if(myfrstNo.isEmpty()&&myfrstNo.isEmpty()){
                    Tv_answer.text="please Input a Number"
                }else{
                    var answer=myfrstNo.toDouble() / mysecNo.toDouble()
                    Tv_answer.text=answer.toString()
                }
            }
        }
    }
}