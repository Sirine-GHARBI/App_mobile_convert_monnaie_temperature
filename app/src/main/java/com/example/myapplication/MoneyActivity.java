package com.example.myapplication;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

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

import com.google.android.material.navigation.NavigationView;

public class MoneyActivity extends AppCompatActivity {

    Button buttonConvertir,buttonrenitialiser;
    TextView somme ,textViewresultatsomme;

    RadioButton radioButtonEuro,radioButtonDinar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (drawerToggle.onOptionsItemSelected(item)){
//            switch(item.getItemId()){
//                case R.id.money:
//                {
//                    Toast.makeText(getApplicationContext(),"Convertiseeur monnaie est sélectionné",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(MoneyActivity.this, MoneyActivity.class);
//                    startActivity(intent);
//                    break;
//                }
//                case R.id.temperature:
//                {
//                    Toast.makeText(getApplicationContext(),"Convertiseeur température est sélectionné",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(MoneyActivity.this, TemperatureActivity.class);
//                    startActivity(intent);
//                    break;
//                }
//                case R.id.deconnexion:
//                {
//                    Toast.makeText(MoneyActivity.this, "Vous etes déconnecté", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(MoneyActivity.this, MainActivity.class);
//                    startActivity(intent);
//
//                }
//            }
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);

        somme = findViewById(R.id.editTextTextPersonName);
        textViewresultatsomme = findViewById(R.id.textView2);
        radioButtonDinar = findViewById(R.id.radioButton);
        radioButtonEuro = findViewById(R.id.radioButton2);
        buttonConvertir = findViewById(R.id.button);
        buttonrenitialiser = findViewById(R.id.buttonrenitialiser);
        drawerLayout = findViewById(R.id.drawer_Layout);
//        navigationView = findViewById(R.id.nav_view);
//        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open , R.string.close);
//        drawerLayout.addDrawerListener(drawerToggle);
//        drawerToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected( MenuItem item) {
//                switch(item.getItemId()){
//                    case R.id.money:
//                    {
//                        Toast.makeText(getApplicationContext(),"Convertiseeur monnaie est sélectionné",Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(MoneyActivity.this, MoneyActivity.class);
//                        startActivity(intent);
//                        break;
//                    }
//                    case R.id.temperature:
//                    {
//                        Toast.makeText(getApplicationContext(),"Convertiseeur température est sélectionné",Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(MoneyActivity.this, TemperatureActivity.class);
//                        startActivity(intent);
//                        break;
//                    }
//                    case R.id.deconnexion:
//                    {
//                        Toast.makeText(MoneyActivity.this, "Vous etes déconnecté", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(MoneyActivity.this, MainActivity.class);
//                        startActivity(intent);
//
//                    }
//                }
//
//                return false;
//            }
//        });



        buttonConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( (TextUtils.isEmpty(somme.getText()))  ){

                    somme.setError( "Champ vide!" );

                }else{
                    if (radioButtonEuro.isChecked()){
                        float tsomme = Float.valueOf(Float.parseFloat(somme.getText().toString()));
                        float resultat = (float) (tsomme*3.38);
                        textViewresultatsomme.setText("Vous avez: "+resultat + " DT");
                    }
                    if (radioButtonDinar.isChecked()){
                        float tsomme = Float.valueOf(Float.parseFloat(somme.getText().toString()));
                        float resultat = (float) (tsomme*0.3);
                        textViewresultatsomme.setText("Vous avez: "+resultat + "$");
                    }
                }
            }
        });

        buttonrenitialiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                somme.setText("");
                textViewresultatsomme.setText("");
                radioButtonDinar.setChecked(false);
                radioButtonEuro.setChecked(false);

            }
        });

        radioButtonEuro.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                view.showContextMenu();
                return true;
            }
        });
        radioButtonEuro.setOnCreateContextMenuListener(this);

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
                Toast.makeText(this, "conversion euro/Dinar", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Intent i = new Intent(MoneyActivity.this, TemperatureActivity.class);
                startActivity(i);;
                break;
            case 3:
                this.finish();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public boolean onCreateOptionsMenu (Menu menu){
        menu.add(0,1,0,"Conversion C <-> F");
        menu.add(0,2,0,"Quitter");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch(item.getItemId()){
            case 1 :
                Intent i = new Intent(MoneyActivity.this, TemperatureActivity.class);
                startActivity(i);
                break;
            case 2:
                this.finish();
                break;
        }
        return  super.onOptionsItemSelected(item);
    }

//    @Override
//    public void onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
//            drawerLayout.closeDrawer(GravityCompat.START);
//        }else {
//            super.onBackPressed();
//        }
//    }
}