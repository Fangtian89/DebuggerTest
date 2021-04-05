package com.example.debuggertest;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Background extends AsyncTask<String,Void,String>{

     AlertDialog dialog;
    Context context;

    public Background(Context context){                                                             //constructor

        this.context=context;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


    @Override
    protected String doInBackground(String... passValues) {
        String result="";
        String user=passValues[0];
        String pass=passValues[1];
        ArrayList<String> list=new ArrayList<>();
        String conn="http://192.168.1.235/androidlottodatabase.php";                                         //地址
        try {
            URL url=new URL(conn);                                                                  //定义地址
            HttpURLConnection http=(HttpURLConnection) url.openConnection();                        //打开连接，产生一个连接object
            http.setRequestMethod("POST");                                                          //设定数据传输方法,collect form data after submitting an HTML form with method="post".
            http.setDoInput(true);
            http.setDoOutput(true);

            //OutputStream ops=http.getOutputStream();
            //BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));

            OutputStreamWriter writer=new OutputStreamWriter(http.getOutputStream());               //getOutputStream() returns an output stream for writing bytes to this socket.
            String data= URLEncoder.encode("users","UTF-8")+"="+URLEncoder.encode(user,"UTF-8")+"&&"+URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");
            writer.write(data);
            writer.flush();
            writer.close();                                                                         //不要关闭 http connection

            //ops.close();

            InputStream ips =http.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));

            String line="";
            while((line=reader.readLine())!=null){
                result= line;
                String[] parts=result.split(" ");
                Log.d("line result: ",result);
                list.add(result);

            }

            reader.close();
            ips.close();
            http.disconnect();                                                                      //关闭 connection
            return result;

        } catch (MalformedURLException e) {
            result=e.getMessage();
        } catch (IOException e){
            result=e.getMessage();

        }
        return result;
    }

    @Override
    protected void onPostExecute(String s){
        dialog.setMessage(s);
        dialog.show();
    }
}
