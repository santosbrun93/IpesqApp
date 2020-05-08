package com.fadergs.projeto.ipesq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fadergs.projeto.ipesq.R;

public class SignUp extends AppCompatActivity {

    EditText editTextName, editTextEmail, editTextPass, cod_nivel;
    Button buttonRegister;
    TextView txtLoginPage;
    DATABASE_SOURCE DBSOURCE;
    String s1;
    String s2;
    String s3;
    int s4;
    String s5;
    String s6 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPass = findViewById(R.id.editTextPass);
        cod_nivel = findViewById(R.id.editNumberCodNivel);
        buttonRegister = findViewById(R.id.buttonRegister);
        txtLoginPage = findViewById(R.id.txtLoginPage);

        // TextView
        txtLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Initialization value of Constructor ...
        DBSOURCE = new DATABASE_SOURCE(getApplicationContext());
        DBSOURCE.openDB();

        // SignUp button...
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s1 = editTextName.getText().toString();
                s2 = editTextEmail.getText().toString();
                s3 = editTextPass.getText().toString();
                s4 = Integer.parseInt(cod_nivel.getText().toString());

                if ((s1).equals(s6) | (s2).equals(s6) | (s3).equals(s6)){
                    Toast.makeText(SignUp.this, R.string.warningAllCamps,
                            Toast.LENGTH_SHORT).show();

                } else if ((s1.length() < 4)) {
                    Toast.makeText(SignUp.this,
                            R.string.mininumUser, Toast.LENGTH_SHORT).show();

                } else if ((s3.length() < 4)) {
                    Toast.makeText(SignUp.this, R.string.passwordMinimun,
                            Toast.LENGTH_SHORT).show();

                } else if ((s4 == 0)) {
                    Toast.makeText(SignUp.this,
                            R.string.codNivelEmpty, Toast.LENGTH_SHORT).show();

                } else {
                    DBSOURCE.InsertAccountDetails(s1, s2, s3, s4);
                    editTextName.setText("");
                    editTextEmail.setText("");
                    editTextPass.setText("");
                    cod_nivel.setText("");

                    Toast.makeText(SignUp.this, R.string.registerMessage,
                            Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(in);
                }
            }
        });


    }
}