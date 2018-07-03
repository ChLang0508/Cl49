package com.example.cl49;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Sign_in_Activity extends AppCompatActivity {
    EditText edittext1, edittext2, edittext3, edittext4, edittext5;
    RadioButton radio1, radio2;
    SQLiteDatabase db;
    Button button1,button2;
    Intent intent;
    String id = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_);

        button1 = (Button) findViewById(R.id.button6);
        button2 = (Button) findViewById(R.id.button7);
        edittext1 = (EditText) findViewById(R.id.editText3);
        edittext2 = (EditText) findViewById(R.id.editText4);
        edittext3 = (EditText) findViewById(R.id.editText5);
        edittext4 = (EditText) findViewById(R.id.editText7);
        radio1 = (RadioButton) findViewById(R.id.radioButton1);
        radio2 = (RadioButton) findViewById(R.id.radioButton2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = openOrCreateDatabase("mydb.db", Context.MODE_PRIVATE, null);

                Cursor c = db.rawQuery("select _id from user_u where _id=? ",new String[] { String.valueOf(edittext1.getText()) });
                if (c.moveToNext()) {
                    id = c.getString(c.getColumnIndex("_id"));
                } else {
                    id = null;
                }
                c.close();
                if (id != null) {
                    Toast.makeText(Sign_in_Activity.this, "该账号已被使用", Toast.LENGTH_SHORT).show();
                } else {
                    String sex = null;
                    if (radio1.isChecked() == true) {
                        sex = "男";
                    } else if (radio2.isChecked() == true) {
                        sex = "女";
                    }
                    db.execSQL("insert into user_u(_id,user_pass,username,tel,sex) values(?,?,?,?,?)",
                            new Object[] { edittext1.getText(), edittext2.getText(), edittext3.getText(),
                                    edittext4.getText(), sex });
                    Toast.makeText(Sign_in_Activity.this, "注册成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edittext1.setText("");
                edittext2.setText("");
                edittext3.setText("");
                edittext4.setText("");
            }
        });
    }
}
