package com.technifutur.neopixl.eval22

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technifutur.neopixl.eval22.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    private val listProduits = listOf<Product>(
        Product("Coca","5",R.drawable.drink),
        Product("Chips", "4", R.drawable.food),
        Product("Gel hydroalcoolique", "5",R.drawable.health),
        Product("Home","1",R.drawable.home)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun setupRecyclerView(){
        val adapter = ProductAdapter()
        val layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        binding.productsRecyclerView.adapter = adapter
        binding.productsRecyclerView.layoutManager = layoutManager
        adapter.refreshProducts(listProduits)
    }


}