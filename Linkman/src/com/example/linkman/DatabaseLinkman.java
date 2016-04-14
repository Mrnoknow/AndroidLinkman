package com.example.linkman;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by lenovo on 2015/10/23.
 */
public class DatabaseLinkman extends SQLiteOpenHelper {
    final String Creat_Table="create table telephone(number varchar(11) primary key,name varchar(20))";
    public DatabaseLinkman(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(Creat_Table);
       db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void Insert(Man man,SQLiteDatabase db){
        String sql="insert into telephone(number,name) values(?,?)";
        db.execSQL(sql,new String[]{man.getNumber(),man.getName()});
        db.close();

}
    public ArrayList View(SQLiteDatabase db){
       // db.execSQL("insert into telephone(number,name) values(444,444)");
        String sql="select * from telephone order by name asc";
        ArrayList<Man> result=new ArrayList<Man>();
        Cursor cursor=db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            Man man=new Man();
            man.setNumber(cursor.getString(0));
            man.setName(cursor.getString(1));
            result.add(man);
        }
        db.close();
        return result;
    }
    public ArrayList funView(SQLiteDatabase db,String name){
    	
        String sql="select * from telephone where name like ? or name like ? or name like ?";
        ArrayList<Man> result=new ArrayList<Man>();
        Cursor cursor=db.rawQuery(sql,new String[]{name+"%","%"+name,"%"+name+"%"});
        while(cursor.moveToNext()){
            Man man=new Man();
            man.setNumber(cursor.getString(0));
            man.setName(cursor.getString(1));
            result.add(man);
        }
        db.close();
        return result;
    }
    public int Count(SQLiteDatabase db){
        String sql="select count(*) from telephone";
        Cursor cursor=db.rawQuery(sql,null);
        cursor.moveToNext();
        db.close();
        return cursor.getInt(0);
    }
    public void Delete(SQLiteDatabase db,String name){
    	String sql="delete from telephone where name=?";
    	db.execSQL(sql,new String[]{name});
    	db.close();
    }
    public void Update(SQLiteDatabase db,String name,Man man){
    	String sql="update telephone set name=? , number=? where name=?";
    	db.execSQL(sql,new String []{man.getName(),man.getNumber(),name});
    	db.close();
    }
    
}
