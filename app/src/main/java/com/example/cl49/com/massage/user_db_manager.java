package com.example.cl49.com.massage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class user_db_manager  {

    private com.example.cl49.com.massage.db helper;
    private SQLiteDatabase db;

    public user_db_manager(Context context) {
        super();
        helper = new db(context);
        // 因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName, 0, mFactory);
        // 所以要确保context已初始化,我们可以把实例化DBManager的步骤放在Activity的onCreate里
        db = helper.getWritableDatabase();
//		db=helper.getReadableDatabase();
    }


    public void add(List<user> users) {
        db.beginTransaction(); // 开始事务
        try {
            for (user user_u : users) {
                db.execSQL("INSERT INTO student VALUES(?, ?, ?, ?)",
                        new Object[] {user_u._id,user_u.username,user_u.user_pass,user_u.sex });
            }
            db.setTransactionSuccessful(); // 设置事务成功完成
        } finally {
            db.endTransaction(); // 结束事务
        }

    }


    public void del() {

    }


    public void update(user users) {
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",users.username);
        contentValues.put("sex",users.user_pass);
        contentValues.put("user_passs",users.user_pass);
        db.update("user_u",contentValues,"_id=?",new String[]{String.valueOf(users._id)});
    }


    public List<user> query() {
        ArrayList<user> users = new ArrayList<user>();
        Cursor c = queryTheCursor();
        while (c.moveToNext()){
            user user1=new user();


        }
        c.close();

        return users;
    }


    public Cursor queryTheCursor() {
        return null;
    }
}
