package com.example.tpp5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class Database  extends SQLiteOpenHelper {
  public static String DbName="bibleotheque.db" ;
    public static final int version = 1 ;
    private SQLiteDatabase db ;

    public Database (Context context)
    {
        super(context , DbName , null, version) ;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS book (name TEXT primary Key ,titre TEXT ,motcle TEXT ,resume TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("Drop table if EXISTS book");
      onCreate(db);

    }

public void InsertRowAdmin(String nam , String titr , String motcl , String resum)
{
  SQLiteDatabase db = this.getWritableDatabase() ;
    ContentValues contentValues = new ContentValues() ;
    contentValues.put("name",nam);
    contentValues.put("titre",titr);
    contentValues.put("motcle",motcl);
    contentValues.put("resume",resum);

 db.insert("book",null,contentValues) ;
}

public int recherche(String mot)
{
 SQLiteDatabase db = this.getWritableDatabase() ;
    Cursor res =db.rawQuery("select * from book where motcle= '"+mot+"' ", null) ;
    int n=-1 ;
    if(res.moveToFirst())
        n=1 ;


    return n ;
}


public int deletee(String nam)
{

    SQLiteDatabase db =this.getWritableDatabase() ;
   //db.execSQL("delete from book where name="+nam) ;

    Cursor res =db.rawQuery("delete from book where name== '"+nam+"' ",null) ;

    int n=-1 ;
    if(res.moveToFirst())
        n=1 ;


    return n ;

}



public ArrayList getAllrecord()
{
    ArrayList array_List = new ArrayList() ;


    SQLiteDatabase db =this.getReadableDatabase() ;
    Cursor res = db.rawQuery("select * from book",null) ;
    res.moveToFirst() ;
    while(res.isAfterLast() == false)
    { array_List.add(res.getString(res.getColumnIndex("name") ) ) ;
      /*  array_List.add(res.getString(res.getColumnIndex("titre")) );
        array_List.add(res.getString(res.getColumnIndex("resume")   )) ;
            */
    res.moveToNext() ;



    }

    return array_List ;
}


    public ArrayList <livre> getAllrecord3 () {
        ArrayList<livre>array_list=new ArrayList <livre>();
        SQLiteDatabase db =this.getReadableDatabase() ;

        Cursor res=db.rawQuery("select * from book",null);
        res.moveToFirst();
        livre l ;


        while(res.isAfterLast() == false)
        {
            l = new livre() ;

            l.setName(res.getString(0));
            array_list.add(l) ;

            res.moveToNext() ;



        }

        return array_list ;

    }





    public ArrayList getAllrecord2(String mot)
    {
        ArrayList array_List = new ArrayList() ;
        SQLiteDatabase db =this.getReadableDatabase() ;


  //       Cursor res = db.rawQuery("select * from book",null) ;
        Cursor res =db.rawQuery("select * from book where motcle like '"+mot+"' ", null) ;
        res.moveToFirst() ;
        while(res.isAfterLast() == false)
        {
            array_List.add(("livre :" )  ) ;

          array_List.add( ("name : " )+ res.getString(  res.getColumnIndex("name") )+"  titre : "+  res.getString(res.getColumnIndex("titre")      )+"  resume : "+ res.getString(res.getColumnIndex("resume")      )  ) ;

     /*  array_List.add( ("titre :" )+ res.getString(res.getColumnIndex("titre")) );
        array_List.add(("resume :" )+ res.getString(res.getColumnIndex("resume")   )) ;
                                                                                           */
            array_List.add(("" )  ) ;

            res.moveToNext() ;



        }

        return array_List ;
    }





}
