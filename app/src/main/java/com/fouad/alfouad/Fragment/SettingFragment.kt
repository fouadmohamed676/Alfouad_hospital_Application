package com.fouad.alfouad.Fragment

import android.app.AlertDialog
import android.app.Dialog
import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fouad.alfouad.R
import com.fouad.alfouad.ViewModel.UserViewModel
import com.fouad.alfouad.databinding.SettingFragmentBinding
import com.fouad.alfouad.ui.ActivityAbout
import com.fouad.alfouad.ui.Services.AddInterView
import com.fouad.alfouad.ui.Services.Bests.ActivityBestDoctors
import com.fouad.alfouad.ui.Services.Bests.ActivityBestHospitals
import com.fouad.alfouad.ui.Services.Forwars.ActivityProfile
import com.fouad.alfouad.ui.Validate.MainActivity
import com.fouad.alfouad.ui.Validate.UpdateAccountActivity

@Suppress("DEPRECATION", "SpellCheckingInspection")
class SettingFragment : Fragment(R.layout.setting_fragment) {

    private lateinit var binding: SettingFragmentBinding
    lateinit var progressDialog: ProgressDialog

    private lateinit var userViewModel: UserViewModel
    private lateinit var userId: String
    private lateinit var email: String
    private lateinit var name: String
    private lateinit var myphone: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.setting_fragment, container, false)

        userViewModel= ViewModelProvider(this).get(UserViewModel::class.java)
        myphone = arguments?.getString("phone").toString()
        userId = arguments?.getString("user_id").toString()
        email = arguments?.getString("email").toString()
        name = arguments?.getString("name").toString()
        binding.email.text = arguments?.getString("name").toString()
        binding.nameSetting.text = arguments?.getString("phone").toString()
        progressDialog = ProgressDialog(activity)
        login()
        binding.updateAccount.setOnClickListener {

            val update = Intent(activity, UpdateAccountActivity::class.java)
            update.putExtra("name", name).toString()
            update.putExtra("phone", myphone).toString()
            update.putExtra("email", email).toString()
            startActivity(update)
        }
        binding.logOut.setOnClickListener {
            logoutDialog()
        }
        binding.about.setOnClickListener {
            val about = Intent(view?.context, ActivityAbout::class.java)
            startActivity(about)
        }
        binding.tvBestDoctor.setOnClickListener {
            val bestDoctors = Intent(activity, ActivityBestDoctors::class.java)
            startActivity(bestDoctors)
        }
        binding.tvBestHospital.setOnClickListener {
            val bestHospitals = Intent(activity, ActivityBestHospitals::class.java)
            startActivity(bestHospitals)
        }
        binding.addInterView.setOnClickListener {
            val addInterView = Intent(activity, AddInterView::class.java)
            startActivity(addInterView)
        }
        binding.forwards.setOnClickListener {
            val forward = Intent(activity, ActivityProfile::class.java)
            forward.putExtra("user_id",userId)
            startActivity(forward)
        }

        return binding.root
    }


    private fun logoutDialog() {
        val builder = AlertDialog.Builder(view?.context)
        builder.setCancelable(false)
        builder.setTitle("Logout")
        builder.setMessage("هل تريد تسجيل الخروج؟")
        val alertDialog = builder.create()
        alertDialog.setButton(Dialog.BUTTON_POSITIVE, "تسجيل خروج") { _, _ ->
            val mainActivity = Intent(activity, MainActivity::class.java)
            mainActivity.putExtra("logout", "1")
            startActivity(mainActivity)
        }
        alertDialog.setButton(Dialog.BUTTON_NEGATIVE, "إلغاء") { dialog, _ ->
            dialog.dismiss()
        }
        alertDialog.show()
    }



    private  fun login(){
        userViewModel.userData.observe(this, Observer {
                response->
                Log.e(TAG,"response phone :onCreateView ${response.get(0).phone}")
            binding.email.text = response[0].email
            binding.nameSetting.text = response[0].name
            name=response[0].name
            email=response[0].email
            userId= response[0].id.toString()
        })

        userViewModel.getUser(myphone)
    }

}