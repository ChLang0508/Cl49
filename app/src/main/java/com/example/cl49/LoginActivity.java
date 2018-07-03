package com.example.cl49;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import org.ksoap2.SoapEnvelope;
//import org.ksoap2.SoapFault;
//import org.ksoap2.serialization.SoapObject;
//import org.ksoap2.serialization.SoapSerializationEnvelope;
//import org.ksoap2.transport.HttpResponseException;
//import org.ksoap2.transport.HttpTransportSE;
//import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;


public class LoginActivity extends Activity{
    String namespace;
    String url;
    String modlename;
   TextView id;
   TextView pass;
   Button sign_in;
//    SoapObject soapObject;
    SQLiteDatabase db;
    int user_id;
    String password = "";

//    public class WSAsyncTask extends AsyncTask {
//
//        SoapObject soapObject;
//
//        @Override
//        protected void onPreExecute() {
//
//            super.onPreExecute();
//        }
//
//
//        @Override
//        protected void onProgressUpdate(Object[] values) {
//            super.onProgressUpdate(values);
//        }
//
//        @Override
//        protected SoapObject doInBackground(Object... params) {
//            try {
//                SoapObject request = new SoapObject(namespace, modlename);
//
//                request.addProperty("id",id.getText());
////                request.addProperty("pass",pass.getText());
//
//                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//                envelope.bodyOut = request;
//                envelope.dotNet = true;
//                HttpTransportSE httpTransportSE = new HttpTransportSE(url);
//
//                httpTransportSE.call(null, envelope);
//
//                soapObject = (SoapObject) envelope.getResponse();
//
//
//            } catch (HttpResponseException e) {
//                e.printStackTrace();
//            } catch (SoapFault soapFault) {
//                soapFault.printStackTrace();
//            } catch (XmlPullParserException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return soapObject;
//        }
//        @Override
//        protected void onPostExecute(Object o) {
//
//            super.onPostExecute(o);
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        url="http://192.168.1.106/WebService2.asmx";
        namespace=" http://tempuri.org/";
        modlename="selectAllCargoInfor";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        id=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        sign_in=findViewById(R.id.email_sign_in_button);

        db = openOrCreateDatabase("mydb.db", Context.MODE_PRIVATE, null);







        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id.length() == 0 || pass.length() == 0)
                    Toast.makeText(LoginActivity.this, "账户或密码不能为空", Toast.LENGTH_LONG).show();
                else {
                    Cursor c = db.rawQuery("select _id,user_pass from user_u where _id=?", new String[]{id.getText().toString()});
                    while (c.moveToNext()) {
                        user_id = c.getInt(c.getColumnIndex("_id"));
                        password = c.getString(c.getColumnIndex("user_pass"));
                    }
                    if (String.valueOf(user_id).equals(id.getText().toString())) {
                        if (password.equals(pass.getText().toString())) {
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent();
                            intent.putExtra("loginstate", 1);
                            intent.putExtra("id", user_id);
                            setResult(RESULT_OK, intent);
                            finish();
                            c.close();
                            db.close();
                        }else {
                            Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }
}

