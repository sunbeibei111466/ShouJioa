package project01.shoujioa.Fragment_main;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

import project01.shoujioa.Adepter_All.read_recyclerview_adepter;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.Interface.gw_shengpi_read;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.new_String;

public class Read_fragment  extends Fragment{
    private View view;
    private RecyclerView recyclerView;
    private read_recyclerview_adepter read_recyclerview_adepter;
    private ArrayList<new_String> arrayList=new ArrayList<>();
    private RequestQueue requestQueue;
    private String URL= HttpUtils.URL+"gwglapp/app_gwglyjlist";
    private SharedPreferences sp;
    private String ids;
    private SwipeRefreshLayout swipeRefreshLayout;
    private boolean aBoolean=true;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=View.inflate(getContext(), R.layout.read_fragent_main,null);
        requestQueue= Volley.newRequestQueue(getContext());
        sp = getContext().getSharedPreferences("abc", 0);
        ids = sp.getString("id", "");
        initlist();
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

    private void initlist() {
        recyclerView=view.findViewById(R.id.read_recyclerview);
        swipeRefreshLayout=view.findViewById(R.id.srh);
        if(arrayList.size()==0){
            initview();
        }else{
            arrayList.clear();
            read_recyclerview_adepter.notifyDataSetChanged();
            initview();
        }
    }

    private void initview() {


        StringRequest jsonObjectRequest=new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String jsonObject) {

                Gson gson=new Gson();
                try {
                    JSONObject jsonObject1 = new JSONObject(jsonObject);
                    String message = jsonObject1.getString("message");
                    if(!message.equals("success")){

                    }else{
                        read_toll agency_toll = gson.fromJson(jsonObject,read_toll.class);
                        List<read_toll.DatasBean> datas = agency_toll.getDatas();
                        arrayList.clear();
                        for(int i=0;i<datas.size();i++){
                            new_String new_string=new new_String();
                            new_string.setString_name(datas.get(i).getName());
                            new_string.setString_tiem(datas.get(i).getCreateDate());
                            new_string.setString_id(datas.get(i).getId());
                            arrayList.add(new_string);
                        }
                        read_recyclerview_adepter=new read_recyclerview_adepter(getContext(),arrayList);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(read_recyclerview_adepter);
                        read_recyclerview_adepter.setOnDeleteListener(new read_recyclerview_adepter.OnDeleteListener() {
                            @Override
                            public void delete(String position, String id) {
                                Intent intent=new Intent(getContext(),gw_shengpi_read.class);
                                intent.putExtra("userid",ids);
                                intent.putExtra("id",id);
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
 ;
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String ,String> map=new HashMap<>();
                map.put("userid",ids);
                map.put("name","");
                return map;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            initlist();
            swipeRefreshLayout.setRefreshing(false);
            aBoolean=false;
        }
    };
}
