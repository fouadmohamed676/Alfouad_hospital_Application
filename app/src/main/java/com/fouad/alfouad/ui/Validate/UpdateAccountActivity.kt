package com.fouad.alfouad.ui.Validate

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActivityUpdateAccountBinding

@Suppress("DEPRECATION")
class UpdateAccountActivity : AppCompatActivity(R.layout.activity_update_account) {

    private lateinit var binding: ActivityUpdateAccountBinding
    private lateinit var name: String
    private lateinit var email: String
    private lateinit var phone: String
    private lateinit var progress: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        name = intent.getStringExtra("name").toString()
        email = intent.getStringExtra("email").toString()
        phone = intent.getStringExtra("phone").toString()

        progress = ProgressDialog(this)
        binding.regEmail.setText(email).toString()
        binding.regName.setText(name).toString()
        binding.regPhone.setText(phone).toString()

        binding.register.setOnClickListener {
            setup()
            Toast.makeText(this, "تم تعديل الحساب بنجاح..", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setup() {
        progress.show()
        progress.setMessage("الرجاء الانتظار..")
        progress.setCancelable(true)
    }


}