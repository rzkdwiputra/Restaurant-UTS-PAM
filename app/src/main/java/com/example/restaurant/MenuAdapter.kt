package com.example.restaurant

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private val context: Context, private val menu: List<Menues>, private val listener: (Menues) -> Unit) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imgMenu: ImageView = view.findViewById(R.id.iv_menu)
        private val namaMenu: TextView = view.findViewById(R.id.tv_menu)
        private val detailMenu: TextView = view.findViewById(R.id.tv_detail)


        fun bindView(menu: Menues, listener: (Menues) -> Unit) {
            imgMenu.setImageResource(menu.imgMenu)
            namaMenu.text = menu.namaMenu
            detailMenu.text = menu.detailMenu
            itemView.setOnClickListener { listener(menu) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menu.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindView(menu[position], listener)
    }

}
