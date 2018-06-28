package com.example.cl49;

import android.os.AsyncTask;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.util.ArrayList;

public class WSAsyncTask extends AsyncTask {
    ArrayList<String> result;
    String namespace;
    String url;
    String modlename;
    String a;
    SoapObject soapObject;
    TextView t1;

    public WSAsyncTask(String url,String namespace,String modlename,Object... value){
        this.modlename=modlename;
        this.url=url;
        this.namespace=namespace;
        a=(String) value[0];
        t1=(TextView)value[1];
    }
    public WSAsyncTask(){ }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
    }


    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected SoapObject doInBackground(Object... params) {
        try {
            SoapObject request = new SoapObject(namespace, modlename);

            request.addProperty("_id",a);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.bodyOut = request;
            envelope.dotNet = true;
            HttpTransportSE httpTransportSE = new HttpTransportSE(url);

            httpTransportSE.call(null, envelope);

            soapObject = (SoapObject) envelope.getResponse();


        } catch (HttpResponseException e) {
            e.printStackTrace();
        } catch (SoapFault soapFault) {
            soapFault.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return soapObject;
    }
    @Override
    protected void onPostExecute(Object o) {
        t1.setText(o.toString());
        super.onPostExecute(o);
    }


}
