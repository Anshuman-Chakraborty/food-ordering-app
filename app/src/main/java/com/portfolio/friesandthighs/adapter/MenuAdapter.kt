package com.portfolio.friesandthighs.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.portfolio.friesandthighs.DetailsActivity
import com.portfolio.friesandthighs.databinding.MenuItemBinding



class MenuAdapter(private val menuItemsName: List<String>, private val menuItemPirce:MutableList<String>, private val MenuImage:MutableList<Int>, private val requireContext: Context): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

private val itemClickListener:OnClickListener?=null
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
        init{
            binding.root.setOnClickListener {
                val position = adapterPosition
                if(position!=RecyclerView.NO_POSITION){
                    itemClickListener?.onItemClick(position)
                }
                val intent = Intent(requireContext,DetailsActivity::class.java)
                intent.putExtra("MenuItemName",menuItemsName.get(position))
                intent.putExtra("MenuItemImage",MenuImage.get(position))
                requireContext.startActivity(intent)
            }
        }



    }
    interface OnClickListener{
        fun onItemClick(position: Int)
    }
}