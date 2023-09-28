package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TemperatureActivity extends AppCompatActivity {

    Button buttonConvertir,buttonrenitialiser;
    TextView temperature ,textViewresultatT;

    RadioButton radioButtonF,radioButtonC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        temperature = findViewById(R.id.editTextTextPersonName);
        textViewresultatT = findViewById(R.id.textView2);
        radioButtonF = findViewById(R.id.radioButton);
        radioButtonC = findViewById(R.id.radioButton2);
        buttonConvertir = findViewById(R.id.button);
        buttonrenitialiser = findViewById(R.id.buttonrenitialiser);

        buttonConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( (TextUtils.isEmpty(temperature.getText()))  ){

                    temperature.setError( "Champ vide!" );

                }else{
                    if (radioButtonF.isChecked()){
                        float tTemperature = Float.valueOf(Float.parseFloat(temperature.getText().toString()));
                        float resultat = (float) ((tTemperature-32)/(9/5));
                        textViewresultatT.setText("Température: "+resultat + " °C");
                    }
                    if (radioButtonC.isChecked()){
                        float tTemperature = Float.valueOf(Float.parseFloat(temperature.getText().toString()));
                        float resultat = (float) ((tTemperature*(9/5))+32);
                        textViewresultatT.setText("Température: "+resultat + "°F");
                    }
                }
            }
        });

        buttonrenitialiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temperature.setText("");
                textViewresultatT.setText("");
                radioButtonF.setChecked(false);
                radioButtonC.setChecked(false);
            }
        });

        radioButtonC.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                view.showContextMenu();
                return true;
            }
        });
        radioButtonC.setOnCreateContextMenuListener(this);

    }

    public void onCreateContextMenu(ContextMenu menu, View v , ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.add(0,1,0,"conversion euro -> Dinar");
        menu.add(0,2,0,"conversion C -> F");
        menu.add(0,3,0,"Quitter");

    }

    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case 1:
                Intent i = new Intent(TemperatureActivity.this, MoneyActivity.class);
                startActivity(i);
                break;
            case 2:
                Toast.makeText(this, "conversion C/F", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                this.finish();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public boolean onCreateOptionsMenu (Menu menu){
        menu.add(0,1,0,"Conversion Euro <-> Dinar");
        menu.add(0,2,0,"Quitter");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch(item.getItemId()){
            case 1 :
                Intent i = new Intent(TemperatureActivity.this, MoneyActivity.class);
                startActivity(i);
                break;
            case 2:
                this.finish();
                break;
        }
        return  super.onOptionsItemSelected(item);
    }
}