package com.example.laksnrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.laksnrestaurant.Model.Foodmodel;
import com.example.laksnrestaurant.Model.Ordermodel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    final static String DBName = "fooddatabase.db";
    final static int DBVersion = 2;
    public DBHelper(@Nullable Context context) {
        super(context, DBName, null,DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table orders"+
                  "(id integer primary key autoincrement," +
                "name text,"+
                "tableno integer,"+
                "foodname text,"+
                "price integer)"

        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE if exists orders");
       onCreate(db);
    }

    public Boolean insertorder(String name,String tableno,String foodname,String price){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues value = new ContentValues();
        value.put("name",name);
        value.put("tableno",tableno);
        value.put("foodname",foodname);
        value.put("price",price);
        long id = database.insert("orders",null,value);
        if(id<=0){
            return false;
        }else {
            return true;
        }
    }
       public ArrayList<Ordermodel> getorders(){
          ArrayList<Ordermodel> myorders = new ArrayList<>();
          SQLiteDatabase database = this.getWritableDatabase();
          Cursor cursor = database.rawQuery("select * from orders ",null);

              while (cursor.moveToNext()){
                  Ordermodel model = new Ordermodel(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
                  myorders.add(model);
              }

          cursor.close();
          database.close();
          return myorders;
       }
       public Cursor gettotalptice(){
        SQLiteDatabase database1 = this.getWritableDatabase();
        Cursor cursor = database1.rawQuery("select * from orders",null);
        return cursor;
       }

}
