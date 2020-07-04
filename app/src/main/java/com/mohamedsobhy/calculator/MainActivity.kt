package com.mohamedsobhy.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var isNewOperation = true
    private var oldNumber: String = ""
    private var newNumber: String = ""
    private var chooseNumber: String = ""
    private var tvNumber: String = ""
    private var operation:String = "+"
    private var finalNumber:Double ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        bu0.setOnClickListener(this)
        bu1.setOnClickListener(this)
        bu2.setOnClickListener(this)
        bu3.setOnClickListener(this)
        bu4.setOnClickListener(this)
        bu5.setOnClickListener(this)
        bu6.setOnClickListener(this)
        bu7.setOnClickListener(this)
        bu8.setOnClickListener(this)
        bu9.setOnClickListener(this)

        buDiv.setOnClickListener(this)
        buMul.setOnClickListener(this)
        buSub.setOnClickListener(this)
        buSum.setOnClickListener(this)
        buEqual.setOnClickListener(this)

        butAC.setOnClickListener(this)
        buPlusOrMin.setOnClickListener(this)
        buPercentage.setOnClickListener(this)

        buDot.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (isNewOperation) {
            result.text = ""
        }
        isNewOperation = false

        tvNumber = result.text.toString()
        val buSelect = v as Button

        chooseNumber = result.text.toString()

        when (buSelect.id) {
            bu0.id -> {
                tvNumber += "0"
                result.text = tvNumber
            }

            bu1.id -> {
                tvNumber += "1"
                result.text = tvNumber
            }

            bu2.id -> {
                tvNumber += "2"
                result.text = tvNumber
            }

            bu3.id -> {
                tvNumber += "3"
                result.text = tvNumber
            }

            bu4.id -> {
                tvNumber += "4"
                result.text = tvNumber
            }

            bu5.id -> {
                tvNumber += "5"
                result.text = tvNumber
            }

            bu6.id -> {
                tvNumber += "6"
                result.text = tvNumber
            }

            bu7.id -> {
                tvNumber += "7"
                result.text = tvNumber
            }

            bu8.id -> {
                tvNumber += "8"
                result.text = tvNumber
            }

            bu9.id -> {
                tvNumber += "9"
                result.text = tvNumber
            }

            buPlusOrMin.id -> {
                tvNumber = "-$tvNumber"
                result.text = tvNumber
            }

            buDot.id -> {
                tvNumber += "."
                result.text = tvNumber
            }

            butAC.id -> {
                isNewOperation = true
                tvNumber = "0"
                result.text = tvNumber
            }

            buDiv.id->{
                isNewOperation = true
                operation="/"
                oldNumber = chooseNumber
            }

            buMul.id->{
                isNewOperation = true
                operation="*"
                oldNumber = chooseNumber
            }

            buSub.id->{
                isNewOperation = true
                operation="-"
                oldNumber = chooseNumber
            }

            buSum.id->{
                isNewOperation = true
                operation="+"
                oldNumber = chooseNumber
            }

            buPercentage.id->{
                isNewOperation = true
                operation="%"
                oldNumber = chooseNumber
            }

            buEqual.id->{
                calculationMethod(operation,oldNumber)
            }
        }

    }

    private fun calculationMethod(operation:String , oldNumber:String){
        newNumber = result.text.toString()

        when(operation){
            "/"->{
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }

            "*"->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }

            "-"->{
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }

            "+"->{
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }

            "%"->{
                finalNumber = oldNumber.toDouble() % newNumber.toDouble()
            }
        }

        result.text = finalNumber.toString()
        isNewOperation=true

    }
}