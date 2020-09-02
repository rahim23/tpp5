package com.example.tpp5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class chercherlivre extends AppCompatActivity {

    Database db =null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chercherlivre);
        db = new Database(this) ;
    }



    public void afficher2 (View v)
    {

        EditText cherche = (EditText)findViewById(R.id.editText7) ;


        int test = db.recherche(cherche.getText().toString()) ;

        if(test ==1 ){
            //   Toast.makeText(this,"livre existe",Toast.LENGTH_LONG).show();
        //    Intent go_to_chercher = new Intent(this,chercherlivre.class) ;
          //  startActivity(go_to_chercher);
            ListView ls2  = (ListView)findViewById(R.id.listview2);
            Database db = new Database(this) ;

            ArrayList<String> list =  db.getAllrecord2(cherche.getText().toString()) ;
            ls2.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1 , list)) ;



        }
        else{  Toast.makeText(this,"livre n'existe pas",Toast.LENGTH_LONG).show();   }



    }



}
