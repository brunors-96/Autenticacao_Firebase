package com.example.bruno.projetofirebase_bruno;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity{

    private EditText editLogin;
    private EditText editSenha;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLogin = findViewById(R.id.editLogin);
        editSenha = findViewById(R.id.editSenha);


        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void Logar(View view) {
        String sLogin = editLogin.getText().toString();
        String sSenha = editSenha.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(sLogin,sSenha).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Logado com Sucesso",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this,
                                    LoginSuccessActivity.class);
                            startActivity(intent);
                    }
                    else{
                            Toast.makeText(MainActivity.this, "Erro ao Logar",
                                    Toast.LENGTH_SHORT).show();
                        }
                }
        });
    }

    public void vaiRegisteActivity( View view){
        Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
