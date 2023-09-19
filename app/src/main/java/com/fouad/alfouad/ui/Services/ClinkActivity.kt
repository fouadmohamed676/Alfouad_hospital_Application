package com.fouad.alfouad.ui.Services

import android.os.Bundle
import com.fouad.alfouad.R
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Adapter.ClinkAdapter
import com.fouad.alfouad.Adapter.HospitalAdapter
import com.fouad.alfouad.Clinck
import com.fouad.alfouad.databinding.ActivityClinksBinding

class ClinkActivity : AppCompatActivity(R.layout.activity_clinks) {
    private lateinit var binding:ActivityClinksBinding
    private lateinit var manager :RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityClinksBinding.inflate(layoutInflater)
        setContentView(binding.root)
        manager=LinearLayoutManager(this)

        val clink= listOf(

            Clinck("1","الخرطوم","الوالدين","0912033322","يعمل"),
            Clinck("3","امدرمان","الضحي","0912033322","يعمل"),
            Clinck("3","بحري","الرحمه الصجي","9123344421","يعمل"),
            Clinck("1","بحري","مجمع البشير الطبي","0912033322","لا يعمل"),
            Clinck("1","امدرمان","عيادة الشفاء","999555214","يعمل"),
            Clinck("1","بحري","الوالدين","0912033322","يعمل"),
            Clinck("1","الخرطوم","عيادة الفؤاد","141252236", "يعمل"),
//            Clinck(1,2,"الوالدين","914452563","1"),
//            Clinck(1,2,"الوالدين","0912033322","1"),
//            Clinck(1,2,"الوالدين","0912033322","1"),
//            Clinck(1,2,"الوالدين","0912033322","1"),
//            Clinck(1,2,"الوالدين","0912033322","1"),
//            Clinck(1,2,"الوالدين","0912033322","1"),
//            Clinck(1,2,"الوالدين","0912033322","1"),
        )

        binding.recycleClinks.apply {
            adapter= ClinkAdapter(clink)
            layoutManager=manager
        }
    }
}