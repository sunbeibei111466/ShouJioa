package project01.shoujioa.Intent_mian;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
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

import project01.shoujioa.Adepter_All.Entrust_recyclerview_adepter;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.Enreust_mian_tool;
import project01.shoujioa.gson_tool.new_String;

public class Entrust_mian extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Entrust_recyclerview_adepter entrust_recyclerview_adepter;
    private String URL= HttpUtils.URL+"wtsqapp/app_wtsqlist";
    private RequestQueue requestQueue;
    String userid;
    private List<new_String> mlist=new ArrayList<>();
    private Button btn;
    private TextView textView;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrust_mian);
        requestQueue= Volley.newRequestQueue(this);
        initview();
        initdate();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(100,100);
            }
        });
    }

    private void initdate() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String message = jsonObject1.getString("message");
                    mlist.clear();
                    if(!message.equals("success")){
                    }else{
                        Gson gson=new Gson();
                        final Enreust_mian_tool enreust_mian_tool = gson.fromJson(s, Enreust_mian_tool.class);
                        List<Enreust_mian_tool.DatasBean> datas = enreust_mian_tool.getDatas();
                        for(int i=0;i<datas.size();i++){
                            new_String new_string=new new_String();
                            new_string.setString_name("委托授权");
                            new_string.setString_tiem(datas.get(i).getQishisj());
                            new_string.setString_id(datas.get(i).getId());
                            mlist.add(new_string);
                        }
                        entrust_recyclerview_adepter=new Entrust_recyclerview_adepter(Entrust_mian.this,mlist);
                        recyclerView.setLayoutManager(new LinearLayoutManager(Entrust_mian.this));
                        recyclerView.setAdapter(entrust_recyclerview_adepter);
                        entrust_recyclerview_adepter.setOnDeleteListener(new Entrust_recyclerview_adepter.OnDeleteListener() {
                            @Override
                            public void delete(String id) {
                                Intent intent=new Intent(Entrust_mian.this,Entrust_mian_entrust.class);
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

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<>();
                map.put("strId",userid);
                return super.getParams();
            }
        }
        ;
        requestQueue.add(stringRequest);
    }

    private void initview() {
        userid=getIntent().getStringExtra("userid");
        recyclerView=findViewById(R.id.entrust_recycler);
        View view=findViewById(R.id.includeone);
        textView=view.findViewById(R.id.title_text);
        btn=view.findViewById(R.id.img_btn);
        textView.setText("委托授权");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        swipeRefreshLayout=findViewById(R.id.shr);
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
