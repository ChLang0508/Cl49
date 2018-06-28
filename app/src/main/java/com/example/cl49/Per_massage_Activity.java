package com.example.cl49;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Per_massage_Activity extends AppCompatActivity {

    TextView t1;
    SQLiteDatabase db;
    int loginid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per_massage_);
        t1=findViewById(R.id.perpage_text);
        db = openOrCreateDatabase("mydb.db", Context.MODE_PRIVATE, null);

        Intent intent=getIntent();
        loginid=intent.getIntExtra("id",0);


        Cursor c = db.rawQuery("select _id,username,sex,tel from user_u where _id=?",new String[] {String.valueOf(loginid)});
        while (c.moveToNext()) {
            String result="用户名:"+c.getInt(0)+"\n"+"用户姓名："+c.getString(1)+"\n"
                    +"性别："+c.getString(2)+"\n电话号码："+c.getInt(3);
            t1.setText(result);
        }
    }
}
