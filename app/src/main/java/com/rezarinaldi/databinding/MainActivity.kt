package com.rezarinaldi.databinding

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

import com.rezarinaldi.databinding.models.Mahasiswa;

class MainActivity : AppCompatActivity() {


    private lateinit var editTextDate: EditText
    private lateinit var btnSubmit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextDate.setOnClickListener {
            datePicker()
        }

        btnSubmit.setOnClickListener {

        }
    }

    private fun datePicker() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)


        val dpd = DatePickerDialog(
                this,
                { _, year, monthOfYear, dayOfMonth ->
                    val bulan = monthOfYear + 1
                    editTextDate.setText("$dayOfMonth/$bulan/$year")
                },
                year,
                month,
                day
        )
        dpd.show()
    }
}