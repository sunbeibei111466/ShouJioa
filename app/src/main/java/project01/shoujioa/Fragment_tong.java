package project01.shoujioa;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.Button;
import android.widget.EditText;
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
import java.util.List;

import project01.shoujioa.Adepter_All.Tong_adepter;
import project01.shoujioa.Intent_mian.Tong_CX_main;

import project01.shoujioa.gson_tool.new_String;
import project01.shoujioa.gson_tool.tong_tool;

public class Fragment_tong extends Fragment {
    private View view;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String URL=HttpUtils.URL+"login/app_txllist";
    private RequestQueue requestQueue;
    private RecyclerView recyclerView;
    private ArrayList<new_String> mlist=new ArrayList<>();
    private Tong_adepter tong_adepter;
    private EditText edit_query;
    private Button btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragmet_main_tong,null);//activity_xf_intent__main
        requestQueue= Volley.newRequestQueue(getContext());
        initview();

        initdate();
        handler.sendEmptyMessageDelayed(100,100);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(100,100);
            }
        });
        return view;
    }


    private void initdate() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.e("通讯录——————",s);
                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String statuscode = jsonObject1.getString("statuscode");
                    if(statuscode.equals("200")){
                        Gson gson=new Gson();
                        tong_tool tong_tool = gson.fromJson(s, tong_tool.class);
                        List<project01.shoujioa.gson_tool.tong_tool.DatasBean> datas = tong_tool.getDatas();
                       mlist.clear();
                        for(int i=0;i<datas.size();i++){
                            new_String new_string=new new_String();
                            new_string.setString_name(datas.get(i).getName());
                            new_string.setPhone(datas.get(i).getMobile());
                            new_string.setZjh(datas.get(i).getPhone());
                            mlist.add(new_string);
                        }
                        tong_adepter=new Tong_adepter(getContext(),mlist);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(tong_adepter);
                        tong_adepter.setOnDeleteListener(new Tong_adepter.OnDeleteListener() {
                            @Override
                            public void delete(String position) {
                                if(position.equals("1")){
                                    Toast.makeText(getContext(), "null", Toast.LENGTH_SHORT).show();
                                }else{
                                    Intent intent = new Intent(Intent.ACTION_DIAL);
                                    Uri data = Uri.parse("tel:" + position);
                                    intent.setData(data);
                                    startActivity(intent);
                                }

                            }
                        });
                    }else{}
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        requestQueue.add(stringRequest);
    }

    private void initview() {
        swipeRefreshLayout=view.findViewById(R.id.srh);
        recyclerView=view.findViewById(R.id.id_recyclerview);
        edit_query=view.findViewById(R.id.edit_query);
        btn=view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Tong_CX_main.class);
                intent.putExtra("name",edit_query.getText().toString().trim());
                startActivity(intent);
            }
        });
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            initview();
            initdate();
            swipeRefreshLayout.setRefreshing(false);
        }
    };


}
