package project01.shoujioa.Fragment_main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project01.shoujioa.Adepter_All.agency_recyclerview_adepter;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.agency_toll;
import project01.shoujioa.gson_tool.new_String;
import project01.shoujioa.gw_shengpi;

public class Agency_fragment extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private agency_recyclerview_adepter agency_recyclerview_adepter;
    private ArrayList<new_String> arrayList = new ArrayList<>();
    private RequestQueue requestQueue;
    private String URL = HttpUtils.URL+"gwglapp/app_gwgldblist";
    private SharedPreferences sp;
    private String ids;
    private SwipeRefreshLayout swipeRefreshLayout;
    private boolean aBoolean=true;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(),R.layout.agency_main, null);
        requestQueue = Volley.newRequestQueue(getContext());
        sp = getContext().getSharedPreferences("abc", 0);
        ids = sp.getString("id", "");

        initsx();
        if(aBoolean){
            handler.sendEmptyMessageDelayed(1000,1000);
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(100,100);
            }
        });
        return view;
    }

    private void initsx() {
        swipeRefreshLayout=view.findViewById(R.id.srh);
        recyclerView=view.findViewById(R.id.agency_recyclerview);
        if(arrayList.size()==0){
            initview();
        }else{
            arrayList.clear();
            agency_recyclerview_adepter.notifyDataSetChanged();
            initview();
        }
    }

    private void initview() {
        Log.e("代办地址   ",URL);
        StringRequest jsonObjectRequest=new StringRequest (Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String jsonObject) {
                Log.e("代办json++++",jsonObject);
                Gson gson=new Gson();
                try {
                    JSONObject   jsonObject1 = new JSONObject(jsonObject);
                    String message = jsonObject1.getString("message");
                    if(!message.equals("success")){

                    }else{
                        agency_toll agency_toll = gson.fromJson(jsonObject, agency_toll.class);
                        List<project01.shoujioa.gson_tool.agency_toll.DatasBean> datas = agency_toll.getDatas();
                        arrayList.clear();
                        for(int i=0;i<datas.size();i++){
                            new_String new_string=new new_String();
                            new_string.setString_name(datas.get(i).getName());
                            new_string.setString_tiem(datas.get(i).getCreateDate());
                            new_string.setString_id(datas.get(i).getId());
                            arrayList.add(new_string);
                        }
                        agency_recyclerview_adepter=new agency_recyclerview_adepter(getContext(),arrayList);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(agency_recyclerview_adepter);
                        agency_recyclerview_adepter.setOnDeleteListener(new agency_recyclerview_adepter.OnDeleteListener() {
                            @Override
                            public void delete(String id) {
                                Intent intent=new Intent(getContext(),gw_shengpi.class);
                                intent.putExtra("id",id);
                                intent.putExtra("userid",ids);
                                startActivity(intent);
                            }
                        });
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getContext(), ""+volleyError.toString(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            public Map<String, String> getParams(){
                Map<String,String> map =new HashMap<>();
                map.put("userid",ids);
                map.put("name","");
                return map;
            }
        }
        ;
        requestQueue.add(jsonObjectRequest);
    }
    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            initsx();
            swipeRefreshLayout.setRefreshing(false);
            aBoolean=false;
        }
    };

    @Override
    public void onStart() {
        super.onStart();
        handler.sendEmptyMessageDelayed(100,100);
    }
}
