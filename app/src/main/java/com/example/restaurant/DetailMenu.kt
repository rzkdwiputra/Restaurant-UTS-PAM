package com.example.restaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.restaurant.Menues
import com.example.restaurant.menupage.Companion.INTENT_PARCELABLE

class DetailMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_menu)

        val ivFoto = findViewById<ImageView>(R.id.iv_foto)
        val tvNamaMenu = findViewById<TextView>(R.id.tv_nama_menu)
        val tvHarga = findViewById<TextView>(R.id.tv_harga)
        val tvDetailFull = findViewById<TextView>(R.id.tv_detail_full)

        val selectedMenu = intent?.getParcelableExtra<Menues>(INTENT_PARCELABLE)

        selectedMenu?.let {
            ivFoto.setImageResource(it.imgDesc)
            tvNamaMenu.text = it.descNama
            tvHarga.text = it.descHarga
            tvDetailFull.text = it.descDetail
        } ?: run {

        }
        val backButton = findViewById<Button>(R.id.button_back)
        backButton.setOnClickListener {
            val intent = Intent(this, menupage::class.java)
            startActivity(intent)
        }
        val buttonOrder = findViewById<Button>(R.id.button_order)
        buttonOrder.setOnClickListener {
            val intent = Intent(this, OrderDetail::class.java)
            intent.putExtra(INTENT_PARCELABLE, selectedMenu)
            startActivity(intent)
        }
    }

}


