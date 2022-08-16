package com.example.product.presentation.fragment.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.product.core.UserSession
import com.example.product.core.wrapper.ResultWrapper
import com.example.product.databinding.FragmentHomeBinding

import com.example.product.domain.model.ProductModel
import com.example.product.presentation.adapter.ProductsAdapter
import com.example.product.presentation.dialog.ShowProductDialog
import com.example.product.presentation.extentions.hide
import com.example.product.presentation.extentions.show
import com.example.product.presentation.listener.ProductItemClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeFragment : Fragment(), ProductItemClickListener {

    private val TAG = "HomeFragment"

    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var productsAdapter: ProductsAdapter

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        initObservers()
        initRecycler()
        initClicks()

        return binding.root
    }

    private fun initRecycler() {
        productsAdapter = ProductsAdapter(this)

        binding.homeProductRecycler.apply {
            adapter = productsAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun initObservers() {
        lifecycleScope.launchWhenStarted {
            homeViewModel.productsData.collectLatest {

                when (it) {

                    is ResultWrapper.Loading -> {
                        binding.progressBar.show()
                    }

                    is ResultWrapper.Success -> {
                        Log.e(TAG, "Success: $it")
                        binding.progressBar.hide()
                        productsAdapter.diff.submitList(it.value)
                    }

                    is ResultWrapper.Error -> {
                        binding.progressBar.hide()
                        Log.e(TAG, "Error: ${it.error}")
                    }
                }
            }
        }
    }

    override fun onProductItemClicked(selectedProduct: ProductModel) {
        ShowProductDialog(requireContext(), selectedProduct).showDialog()
    }

    private fun initClicks() {
        binding.logOutButton.setOnClickListener {
            UserSession.removeUserSession()

            val action = HomeFragmentDirections.actionHomeFragmentToLoginFragment()
            findNavController().navigate(action)
        }
    }

}