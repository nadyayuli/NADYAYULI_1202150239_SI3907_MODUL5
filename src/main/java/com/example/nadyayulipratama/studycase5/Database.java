package com.example.nadyayulipratama.studycase5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by nadya yuli pratama on 25/03/2018.
 */

public class Database extends SQLiteOpenHelper {


    Context ctx;
    SQLiteDatabase sqldb;

    public static  final String nama_db = "listNama.db";
    public static  final String nama_tabel = "daftar";
    public static  final String kolom_1 = "Name";
    public static  final String kolom_2 = "Deskripsi";
    public static  final String kolom_3 = "Priority";

    public Database(Context context) {
        super(context, nama_db, null, 1);
        this.ctx = context;
        sqldb  = this.getWritableDatabase();
        sqldb.execSQL("create table if not exists "+nama_tabel+" (Name varchar(20)primary key,Deskripsi varchar(30), Priority varchar(2))");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists  "+nama_tabel+" (Name varchar(20) primary key, Descripsi varchar(30), Priority varchar(2))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int position, int position1){
        sqLiteDatabase.execSQL("drop table if  exists "+nama_tabel);
        onCreate(sqLiteDatabase);
    }
    public boolean input(informasi list){
        ContentValues values = new ContentValues();
        values.put(kolom_1, list.getName());
        values.put(kolom_2, list.getDeskripsi());
        values.put(kolom_3, list.getPriority());
        long hasil = sqldb.insert(nama_tabel, null, values);
        if (hasil==-1){
            return false;

        }else {
            return  true;
        }
    }
    public boolean remove(String Name) {
        return sqldb.delete(nama_tabel, kolom_1+"=\""+Name+"\"", null)>0;
    }

    public void readdata(ArrayList<informasi> daftar){
        Cursor cursor= this.getReadableDatabase().rawQuery("select Name, Descripsi, Priority from "+nama_tabel, null);
        while (cursor.moveToNext()){
            daftar.add(new informasi(cursor.getString(0), cursor.getString(1), cursor.getString(2)));

        }
    }


}
