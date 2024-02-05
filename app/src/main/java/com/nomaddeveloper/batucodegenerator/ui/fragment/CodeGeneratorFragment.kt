package com.nomaddeveloper.batucodegenerator.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.nomaddeveloper.batucodegenerator.adapter.ProductFirebaseUiRecyclerAdapter
import com.nomaddeveloper.batucodegenerator.databinding.FragmentCodeGeneratorBinding
import com.nomaddeveloper.batucodegenerator.model.ProductModel

class CodeGeneratorFragment : Fragment() {
    private lateinit var binding: FragmentCodeGeneratorBinding
    private lateinit var productRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCodeGeneratorBinding.inflate(layoutInflater)

        productRecyclerView = binding.recyclerProducts
        val layoutManager = LinearLayoutManager(this.context)
        productRecyclerView.layoutManager = layoutManager

        val database = Firebase.database
        val databaseReference = database.getReference("items").orderByChild("productId")
        val options = FirebaseRecyclerOptions.Builder<ProductModel>()
            .setQuery(databaseReference, ProductModel::class.java)
            .build()
        val adapter = ProductFirebaseUiRecyclerAdapter(options)
        productRecyclerView.adapter = adapter
        adapter.startListening()

        return binding.root
    }
}


