package com.portfolio.friesandthighs

import  android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.portfolio.friesandthighs.adapter.MenuAdapter
import com.portfolio.friesandthighs.databinding.FragmentMenuBottomSheetBinding

class menuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)
        binding.backbtn.setOnClickListener {
            dismiss()
        }
        val menuFoodName =
            listOf("Burger", "sandwitch", "momo", "item", "fries", "sandwitch", "momo", "item")
        val menuItemPrice = listOf("$5", "$3", "$5", "10", "$4","$3", "$5", "10")
        val menuImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4
        )
        val adapter = MenuAdapter(
            ArrayList(menuFoodName),
            ArrayList(menuItemPrice),
            ArrayList(menuImage)
        )
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}