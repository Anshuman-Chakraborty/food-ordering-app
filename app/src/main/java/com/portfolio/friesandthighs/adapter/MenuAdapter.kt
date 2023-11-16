package com.portfolio.friesandthighs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.portfolio.friesandthighs.databinding.MenuItemBinding

class MenuAdapter(private val menuItemsName:MutableList<String>,private val menuItemPirce:MutableList<String>,private val MenuImage:MutableList<Int>): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MenuAdapter.MenuViewHolder, position: Int) {
        holder.bind(position)
    }


    override fun getItemCount(): Int = menuItemsName.size
    inner class MenuViewHolder(private val binding:MenuItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                menuFoodName.text=menuItemsName[position]
                menuPrice.text=menuItemPirce[position]
                menuImage.setImageResource(MenuImage[position])
            }
        }

    }
}