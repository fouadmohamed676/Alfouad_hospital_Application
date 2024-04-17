package com.fouad.alfouad.ui.Services

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Adapter.ClinkAdapter
import com.fouad.alfouad.R
import com.fouad.alfouad.ResponseClink
import com.fouad.alfouad.ViewModel.ClinkViewModel
import com.fouad.alfouad.databinding.ActivityClinksBinding

class ClinkActivity : AppCompatActivity(R.layout.activity_clinks) {
    private lateinit var binding: ActivityClinksBinding
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: ClinkAdapter
    private lateinit var viewModel: ClinkViewModel
    private val blogClink = mutableListOf<ResponseClink>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClinksBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(ClinkViewModel::class.java)
        setup()
        response()
    }


    private fun response() {

        viewModel.clinks.observe(this, Observer { clinks_ ->
            Log.e(" viewModel.clinks.", clinks_.toString())
            blogClink.addAll(clinks_)
            adapter = ClinkAdapter(this, blogClink)
            binding.recycleClinks.adapter = adapter
        })

        viewModel.getClink()
    }

    private fun setup() {
        manager = LinearLayoutManager(this)
        layoutManager = LinearLayoutManager(this)
        binding.recycleClinks.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recycleClinks.layoutManager = layoutManager
        binding.recycleClinks.setHasFixedSize(true)
    }


}