package com.example.wecall.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wecall.databinding.ActivityPhoneAuthBinding;
import com.google.firebase.auth.FirebaseAuth;

public class phone_auth extends AppCompatActivity {
    ActivityPhoneAuthBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth=FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!=null){
            Intent i=new Intent(phone_auth.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        getSupportActionBar().hide();

        //setting binding
        binding=ActivityPhoneAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.phoneBox.requestFocus();
        binding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(phone_auth.this,otp_activity.class);
                i.putExtra("PhoneNumber",binding.phoneBox.getText().toString());
                startActivity(i);
            }
        });

    }
}