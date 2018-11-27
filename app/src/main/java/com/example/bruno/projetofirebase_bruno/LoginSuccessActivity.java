package com.example.bruno.projetofirebase_bruno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bruno.projetofirebase_bruno.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginSuccessActivity extends AppCompatActivity {

    private TextView textEmail;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private EditText editNome, editBDay;
    private Spinner spinnerGraduacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference(firebaseAuth.getUid().toString());
        textEmail = (TextView) findViewById(R.id.texteEmail);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            String sEmail = firebaseUser.getEmail();
            textEmail.setText(sEmail);
        }
        else {
            textEmail.setText("email nulo");
        }

        editNome = findViewById(R.id.editNome);
        editBDay = findViewById(R.id.editBDay);
        spinnerGraduacao = findViewById(R.id.spinnerGraduacao);
    }

    public void Atualizar (View view){
        User user = mapper();
        databaseReference.setValue(user);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Toast.makeText(LoginSuccessActivity.this, "Dados Salvos com sucesso", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(LoginSuccessActivity.this, "Erro ao Salvar dados", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public User mapper(){

        String sNome = editNome.getText().toString();
        String sDate = editBDay.getText().toString();
        String sGraduacao = spinnerGraduacao.getSelectedItem().toString();

        User user = new User(firebaseAuth.getCurrentUser());

        user.setNome(sNome);
        user.setBDay(sDate);
        user.setGraduacao(sGraduacao);

        return user;
    }
}
