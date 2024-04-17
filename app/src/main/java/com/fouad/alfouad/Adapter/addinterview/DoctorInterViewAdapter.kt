package com.fouad.alfouad.Adapter.addinterview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.fouad.alfouad.Model.SpDoctors.Doctor
import com.fouad.alfouad.R

class DoctorInterViewAdapter(context: Context, val list: List<Doctor>) :
    ArrayAdapter<Doctor>(context, 0, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return myView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return myView(position, convertView, parent)
    }

    private fun myView(position: Int, convertView: View?, parent: ViewGroup): View {

        val list = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(
            R.layout.drop_item, parent, false
        )


        list.let {
            val name = view.findViewById<TextView>(R.id.name_)
            name.text = list?.name!!

        }

        return view
    }

}