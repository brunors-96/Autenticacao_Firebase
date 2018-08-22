package com.example.bruno.projetofirebase_bruno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginSuccessActivity extends AppCompatActivity {

    private TextView textEmail;
    //private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        //firebaseAuth = FirebaseAuth.getInstance();

        textEmail = (TextView) findViewById(R.id.texteEmail);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            String sEmail = firebaseUser.getEmail();
            textEmail.setText(sEmail);
        }
        else {
            textEmail.setText("email nulo");
        }
    }
}
