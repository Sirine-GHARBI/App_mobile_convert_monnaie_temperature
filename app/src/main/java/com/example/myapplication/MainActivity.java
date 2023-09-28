package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView prenom,mdp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prenom=findViewById(R.id.edprenom);
        mdp=findViewById(R.id.edpwd);
        btn = findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( (TextUtils.isEmpty(prenom.getText())) && (TextUtils.isEmpty(mdp.getText())) ){

                    prenom.setError( "Il faut remplir tous les champs!" );
                    mdp.setError( "Il faut remplir tous les champs!" );


                }else{
                    if ((prenom.getText().toString().equals("Admin")) && (mdp.getText().toString().equals("1234"))){
                        Toast.makeText(getApplicationContext(),"Bienvenue",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, MoneyActivity.class);
                        intent.putExtra("prenom", prenom.getText().toString());
                        startActivity(intent);
                    }
                    else {
                        prenom.setError( "Informations d'identification incorrectes!" );
                        mdp.setError( "Informations d'identification incorrectes!" );
                    }
                }

            }
        });

    }
}