package com.fourall.dxlabs.koinproject.views.activities

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.fourall.dxlabs.koinproject.R
import com.fourall.dxlabs.koinproject.viewmodels.ProductViewModel
import com.fourall.dxlabs.koinproject.views.adapters.ProductAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    // Lazy Inject ViewModel
    private val viewModel: ProductViewModel by viewModel()
    private val productAdapter = ProductAdapter(ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        setupLiveDataObserver()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getProducts(this)
    }

    private fun setupRecyclerView() {
        recyclerProducts.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = productAdapter
        }
    }

    private fun setupLiveDataObserver() {
        viewModel.productsLiveData.observe(this, Observer { products ->
            products?.let {
                productAdapter.updateList(it)
            }
        })
    }
}
