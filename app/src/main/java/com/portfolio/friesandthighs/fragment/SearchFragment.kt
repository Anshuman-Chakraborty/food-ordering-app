package com.portfolio.friesandthighs.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView

import androidx.recyclerview.widget.LinearLayoutManager
import com.portfolio.friesandthighs.R
import com.portfolio.friesandthighs.adapter.MenuAdapter
import com.portfolio.friesandthighs.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding:FragmentSearchBinding
    private lateinit var  adapter:MenuAdapter
    private val originalMenuFoodName = listOf("Burger", "sandwitch", "momo", "item", "fries", "sandwitch", "momo", "item")
    private val originalMenuItemPrice = listOf("$5", "$3", "$5", "10", "$4","$3", "$5", "10")
    private val originalMenuImage = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filtereredMenuFoodName = mutableListOf<String>()
    private val filtereredMenuItemPrice = mutableListOf<String>()
    private val filtereredMenuImage = mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filtereredMenuFoodName,filtereredMenuItemPrice,filtereredMenuImage)
        binding.menuRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adapter

        //setup for search view
        setUpSearchView()
        //show all menu items
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filtereredMenuFoodName.clear()
        filtereredMenuItemPrice.clear()
        filtereredMenuImage.clear()
        filtereredMenuFoodName.addAll(originalMenuFoodName)
        filtereredMenuItemPrice.addAll(originalMenuItemPrice)
        filtereredMenuImage.addAll(originalMenuImage)
        adapter.notifyDataSetChanged()
    }

    private fun setUpSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String):Boolean{
                filterMenuItem(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItem(newText)
                return true
            }
        })

    }

    private fun filterMenuItem(query: String) {
        filtereredMenuFoodName.clear()
        filtereredMenuItemPrice.clear()
        filtereredMenuImage.clear()
        originalMenuFoodName.forEachIndexed { index, foodName ->
            if(foodName.contains(query,ignoreCase = true)){
                filtereredMenuFoodName.add(foodName)
                filtereredMenuItemPrice.add(originalMenuItemPrice[index])
                filtereredMenuImage.add(originalMenuImage[index])
            }
            adapter.notifyDataSetChanged()
        }
    }

    companion object {

    }
}