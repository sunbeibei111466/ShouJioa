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

import project01.shoujioa.Adepter_All.TX_adepter;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.Interface.TSXQ_mian;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.TS;
import project01.shoujioa.gson_tool.new_String;

public class Details_of_complaints_Fragment extends Fragment{
    private View view;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private TX_adepter xf_adepter;
    private ArrayList<new_String> arrayList = new ArrayList<>();
    private RequestQueue requestQueue;
    private String URL = HttpUtils.URL+"xinfangapp/app_tslist";
    private SharedPreferences sp;
    private String userid;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //letter_interview_return
        view=inflater.inflate(R.layout.noti_ci_one,null);
        requestQueue = Volley.newRequestQueue(getContext());
        sp = getContext().getSharedPreferences("abc", 0);
        userid = sp.getString("id", "");
        initview();
        handler.sendEmptyMessageDelayed(100,100);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(100,100);
            }
        });
        return view;
    }
    private void initview() {
        recyclerView=view.findViewById(R.id.noti_ci_recyclerview);
        swipeRefreshLayout=view.findViewById(R.id.srh);
        initDate();
    }

    private void initDate() {
        StringRequest jsonObjectRequest=new StringRequest (Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String jsonObject) {
                Gson gson=new Gson();
                try {
                    JSONObject jsonObject1 = new JSONObject(jsonObject);
                    String message = jsonObject1.getString("message");
                    if(!message.equals("success")){

                    }else{
                        TS ts = gson.fromJson(jsonObject, TS.class);
                        List<TS.DatasBean> datas = ts.getDatas();
                        arrayList.clear();
                        for(int i=0;i<datas.size();i++){
                            new_String new_string=new new_String();
                            new_string.setString_name(datas.get(i).getBianhao());
                            new_string.setString_tiem(datas.get(i).getCreateDate());
                            new_string.setString_id(datas.get(i).getId());
                            arrayList.add(new_string);
                        }
                        xf_adepter=new TX_adepter(getContext(),arrayList);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(xf_adepter);
                        xf_adepter.setOnDeleteListener(new TX_adepter.OnDeleteListener() {
                            @Override
                            public void delete(String id) {
                                Intent intent=new Intent(getContext(),TSXQ_mian.class);
                                intent.putExtra("id",id);
                                intent.putExtra("userid",userid);
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

            }
        })
        {
            @Override
            public Map<String, String> getParams(){
                Map<String,String> map =new HashMap<>();
                map.put("userid",userid);
                map.put("name","");
                return map;
            }
        }
                ;
        requestQueue.add(jsonObjectRequest);
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            initview();
            swipeRefreshLayout.setRefreshing(false);

        }
    };
}
