package com.example.tpp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     Database db =null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    db = new Database(this) ;

    }

    public void click(View v)
    {
        EditText name = (EditText)findViewById(R.id.editText) ;
        EditText titre = (EditText)findViewById(R.id.editText2) ;
        EditText motcle = (EditText)findViewById(R.id.editText3) ;
        EditText resume = (EditText)findViewById(R.id.editText4) ;

        db.InsertRowAdmin(name.getText().toString(),titre.getText().toString(),motcle.getText().toString(),resume.getText().toString());




        Intent afficher = new Intent(this,afficher_livre.class) ;

        startActivity(afficher);


    }


    public void rechercherlivre(View v)
    {

             Intent go_to_chercher = new Intent(this,chercherlivre.class) ;
                startActivity(go_to_chercher);




    }




}
