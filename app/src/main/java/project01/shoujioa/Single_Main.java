package project01.shoujioa;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

public class Single_Main {
    //声明私有化
    private static RequestQueue requestQueue;

    private static  String string,message ;

    private static RequestQueue getinfo(Context context){
            if(requestQueue==null){
                requestQueue= Volley.newRequestQueue(context);
            }
        return requestQueue;
    }
    private String getvolley(String url){
        StringRequest stringRequest=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                string=s;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                message = volleyError.getMessage();
            }
        });
        requestQueue.add(stringRequest);
        if(string.equals("")){
            return message;
        }else{
            return string;
        }
    }

    private String getPost(String url, final Map<String,String> map){
        StringRequest stringRequest=new StringRequest(1, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
            string=s;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                message=volleyError.getMessage();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        requestQueue.add(stringRequest);
        if(string.equals("")){
            return message;
        }else{
            return string;
        }
    }
}
