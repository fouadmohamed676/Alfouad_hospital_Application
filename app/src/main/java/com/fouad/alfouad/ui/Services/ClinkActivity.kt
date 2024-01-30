package com.fouad.alfouad.ui.Services

import android.os.Bundle
import com.fouad.alfouad.R
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Adapter.ClinkAdapter
import com.fouad.alfouad.Model.clink.Clink
import com.fouad.alfouad.ViewModel.ClinkViewModel
import com.fouad.alfouad.databinding.ActivityClinksBinding
class ClinkActivity : AppCompatActivity(R.layout.activity_clinks) {
    private lateinit var binding:ActivityClinksBinding
    private lateinit var manager :RecyclerView.LayoutManager
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: ClinkAdapter
    private lateinit var viewModel: ClinkViewModel
    private val blogClink = mutableListOf<Clink>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityClinksBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
        viewModel = ViewModelProvider(this).get(ClinkViewModel::class.java)
        response()
    }
    private fun setup(){
        manager=LinearLayoutManager(this)
        layoutManager=LinearLayoutManager(this)
        binding.recycleClinks.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recycleClinks.layoutManager = layoutManager
        binding.recycleClinks.setHasFixedSize(true)
    }
    private fun response (){
        viewModel.clinks.observe(this, Observer {
//                clinks_->
//            blogClink.addAll(clinks_)
//            adapter = ClinkAdapter(blogClink)
//            binding.recycleClinks.adapter = adapter
        })

        viewModel.getClink()
    }



}