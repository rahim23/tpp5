package com.example.tpp5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class livreAdapter extends ArrayAdapter<livre> {
    Database db =null ;


    public livreAdapter(Context context , ArrayList<livre> livres){

        super(context,0 ,livres) ;


    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
   final     livre livree=getItem(position) ;


        if(convertView == null ) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_livre ,parent, false);
        }

    final    TextView name ;
        Button supp ;

        name=convertView.findViewById(R.id.id_titre);
        supp =convertView.findViewById(R.id.id_supp);


        name.setText( "name : "+ livree.getName()   );


        supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                EditText deletelivree = (EditText)findViewById(R.id.editText6) ;

               Database db = new Database(getContext()) ;
                // db.deletee(deletelivree.getText().toString()) ;


           db.deletee(livree.getName()) ;




            }
        });



        return convertView ;


    }



}
























