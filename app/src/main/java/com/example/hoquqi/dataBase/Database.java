package com.example.hoquqi.dataBase;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hoquqi.model.Moshaver;

import java.io.IOException;
import java.util.ArrayList;


public class Database {

    private static DatabaseHelper databaseHelper;

    public static final String m_id = "id";
    public static final String m_name = "m_name";
    private static final String tbl_moshaver = "tbl_moshaver";
    public static boolean flagSabt;

    public Database() {
    }

    public static SQLiteDatabase getInstance(Context context) {
        if (databaseHelper == null) {
            try {
                databaseHelper = new DatabaseHelper(context);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return databaseHelper.getWritableDatabase();
    }

    public static SQLiteDatabase getInstance2(Context context) {
        if (databaseHelper == null) {
            try {
                databaseHelper = new DatabaseHelper(context);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return databaseHelper.getReadableDatabase();
    }

    public static void addMoshaver(String mName, String mPass, String mMail, String mPhone,
                                   String mSabegheh, String mMadrak, String mRotbeh, String mAdress,
                                   String mRezomeh, String pic, Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_name", mName);
        contentValues.put("m_pass", mPass);
        contentValues.put("m_mail", mMail);
        contentValues.put("m_phone", mPhone);
        contentValues.put("m_sabegheh", mSabegheh);
        contentValues.put("m_madrak", mMadrak);
        contentValues.put("m_rotbeh", mRotbeh);
        contentValues.put("m_adress", mAdress);
        contentValues.put("m_rezomeh", mRezomeh);
        contentValues.put("m_img", pic);
// Inserting Row
        Long value = getInstance(context).insert(tbl_moshaver, null, contentValues);
        if (String.valueOf(value).equals("-1")) {
            flagSabt = false;
            getInstance(context).close(); // Closing database connection
        } else if (!(String.valueOf(value).equals("-1"))) {
            flagSabt = true;
        }
        getInstance(context).close(); // Closing database connection

    }

    //int mid, String mName, String mPass, String mMail, String mPhone,
    //                    String mSabegheh, String mMadrak, String mrotbeh, String mAdress,
    //                    String mRezomeh, byte[] mImage
    public static ArrayList getdataMoshaver(Context context) {
        String selectQuery = "SELECT  * FROM " + tbl_moshaver;
        ArrayList<Moshaver> list = new ArrayList<Moshaver>();
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        while (cursor.moveToNext()) {
            list.add(new Moshaver(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("m_name")),
                    cursor.getString(cursor.getColumnIndex("m_pass")),
                    cursor.getString(cursor.getColumnIndex("m_mail")),
                    cursor.getString(cursor.getColumnIndex("m_phone")),
                    cursor.getString(cursor.getColumnIndex("m_sabegheh")),
                    cursor.getString(cursor.getColumnIndex("m_madrak")),
                    cursor.getString(cursor.getColumnIndex("m_rotbeh")),
                    cursor.getString(cursor.getColumnIndex("m_adress")),
                    cursor.getString(cursor.getColumnIndex("m_rezomeh")),
                    cursor.getString(cursor.getColumnIndex("m_img"))
            ));

        }
        cursor.close();
        getInstance2(context).close();
        return list;
    }

    public static Moshaver getdataMoshaverSearch(Context context,String title) {
        String selectQuery = "SELECT  * FROM " + tbl_moshaver+ " WHERE " + m_name + " LIKE '%" + title + "%' ";
        Moshaver moshaver = new Moshaver();
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        while (cursor.moveToNext()) {
            moshaver= new Moshaver(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("m_name")),
                    cursor.getString(cursor.getColumnIndex("m_pass")),
                    cursor.getString(cursor.getColumnIndex("m_mail")),
                    cursor.getString(cursor.getColumnIndex("m_phone")),
                    cursor.getString(cursor.getColumnIndex("m_sabegheh")),
                    cursor.getString(cursor.getColumnIndex("m_madrak")),
                    cursor.getString(cursor.getColumnIndex("m_rotbeh")),
                    cursor.getString(cursor.getColumnIndex("m_adress")),
                    cursor.getString(cursor.getColumnIndex("m_rezomeh")),
                    cursor.getString(cursor.getColumnIndex("m_img")));
        }
        cursor.close();
        getInstance2(context).close();
        return moshaver;
    }

//        public static Moshaver getDataPic(int id, Context context) {
//        String selectQuery = "SELECT * FROM " + tbl_moshaver + " WHERE " + m_id +" = "+id;
//        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
//        Moshaver moshaver = new Moshaver();
//        while (cursor.moveToNext()) {
//            moshaver = (new Moshaver(cursor.getBlob(cursor.getColumnIndex("m_img"))));
//        }
//        cursor.close();
//        getInstance2(context).close();
//        return moshaver;
//    }
//    public static Moshaver getDataPic(int id, Context context) {
//        String selectQuery = "SELECT * FROM " + tbl_moshaver + " WHERE " + m_id + " = " + id;
//        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
//        Moshaver moshaver = new Moshaver();
//        while (cursor.moveToNext()) {
//            moshaver = (new Moshaver(cursor.getString(cursor.getColumnIndex("m_name"))));
//        }
//        cursor.close();
//        getInstance2(context).close();
//        return moshaver;
//    }
}