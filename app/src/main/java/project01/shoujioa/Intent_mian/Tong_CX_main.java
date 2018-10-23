package project01.shoujioa.Intent_mian;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

import project01.shoujioa.Adepter_All.Tong_CX_adepter;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.new_String;
import project01.shoujioa.gson_tool.tong_tool;

public class Tong_CX_main extends AppCompatActivity {
    private String string;
    private String URL= HttpUtils.URL+"login/app_txllist";
    private RequestQueue requestQueue;
    private RecyclerView recyclerView;
    private Tong_CX_adepter tongCxAdepter;
    private List<new_String> mlist=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tong__cx_main);
        string=getIntent().getStringExtra("name");
        requestQueue= Volley.newRequestQueue(Tong_CX_main.this);
        initview();
        initdate();
    }

    private void initview() {
        recyclerView=findViewById(R.id.id_recyclerview);
        View view=findViewById(R.id.list_item);
        TextView textView=view.findViewById(R.id.title_text);
        Button button=view.findViewById(R.id.img_btn);
        textView.setText("搜索详情");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }



    private void initdate() {

        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();
                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String statuscode = jsonObject1.getString("statuscode");
                    if(!statuscode.equals("200")){


                    }else{
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
                        tongCxAdepter=new Tong_CX_adepter(Tong_CX_main.this,mlist);
                        recyclerView.setLayoutManager(new LinearLayoutManager(Tong_CX_main.this));
                        recyclerView.setAdapter(tongCxAdepter);
                        tongCxAdepter.setOnDeleteListener(new Tong_CX_adepter.OnDeleteListener() {
                            @Override
                            public void delete(String position) {
                                if(position.equals("1")){
                                    Toast.makeText(Tong_CX_main.this, "null", Toast.LENGTH_SHORT).show();
                                }else{
                                    Intent intent = new Intent(Intent.ACTION_DIAL);
                                    Uri data = Uri.parse("tel:" + position);
                                    intent.setData(data);
                                    startActivity(intent);
                                }
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
            protected Map<String, String> getParams() {
                Map<String,String> map=new HashMap<>();
                map.put("name",string);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
