package com.example.tpp5;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class afficher_livre extends AppCompatActivity {

    Database db =null ;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afficher_list_livre);
        db = new Database(this) ;



    }



/*    public void afficher (View v)
    {
        ListView ls  = (ListView)findViewById(R.id.listview);
        // Database db = new Database(this) ;

        ArrayList<String> listt =  db.getAllrecord() ;
        ls.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1 , listt)) ;


    }

*/


    public void afficherr (View v)
    {
       // ListView ls  = (ListView)findViewById(R.id.listview);
        Database db = new Database(this) ;

     //   ArrayList<String> listt =  db.getAllrecord() ;

        ArrayList<livre>   livres = new ArrayList<livre>();
        ListView  livreList = (ListView) findViewById(R.id.listview);


     // ArrayList<livre> livre = db.getAllrecord3() ;

     livres= db.getAllrecord3()  ;



        livreAdapter adapter = new livreAdapter(afficher_livre.this, livres);
        livreList.setAdapter(adapter);


    }










}




