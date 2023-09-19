package com.fouad.alfouad.ui.Validate;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fouad.alfouad.Network.Data;
import com.fouad.alfouad.databinding.ActivityLoginBinding;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    binding=ActivityLoginBinding.inflate(getLayoutInflater());
        View view;
        view=binding.getRoot();
        setContentView(view);
        get_user();
    }


    private void get_user() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Data.login
                ,
                new Response.Listener<String>() {

                    final ProgressDialog mProgressDialog = ProgressDialog.show(LoginActivity.this,
                            "جاري ...", "البحث عن مستخدم", false, true);

                    @Override
                    public void onResponse(String operation) {
                        Log.e("response",operation.toString());
//                        Log.e("response",operation);

                        mProgressDialog.dismiss();
                        onBackPressed() ;
                        if (operation.equals("true")) {
                            mProgressDialog.dismiss();
                            onBackPressed() ;
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e("error response",error.toString());
                    }


                })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
//                String user_name_ = binding.updName.getText().toString();
//                String user_contact_ = binding.updContact.getText().toString();
//                String user_id_ = my_id;
//                params.put("name", user_name_);
//                params.put("contact", user_contact_);
                params.put("password", "12345678");
                params.put("email", "fouad@gmail.com");
                return params;

            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(LoginActivity.this);

        requestQueue.cancelAll(LoginActivity.this);
        requestQueue.add(stringRequest);

    }
}
