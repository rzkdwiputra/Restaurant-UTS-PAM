package com.example.restaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class OrderDetail : AppCompatActivity() {
    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)

        val selectedMenu = intent.getParcelableExtra<Menues>(menupage.INTENT_PARCELABLE)
        val orderMenuTextView = findViewById<TextView>(R.id.order_menu)
        selectedMenu?.let {
            orderMenuTextView.text = it.descNama + " Sudah dipesan"
        }
    }
    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked
        when (view.getId()) {
            R.id.radio1 -> if (checked) // Same day service
                displayToast(getString(R.string.radio1))


            R.id.radio2 -> if (checked) // Next day delivery
                displayToast(getString(R.string.radio2))



            else -> {}
        }
    }


    private fun displayToast(message: String) {
        Toast.makeText(
            applicationContext, message,
            Toast.LENGTH_SHORT
        ).show()
    }
}
