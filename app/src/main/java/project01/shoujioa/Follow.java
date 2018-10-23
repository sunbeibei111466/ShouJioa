package project01.shoujioa;

import android.content.Intent;
import android.content.SharedPreferences;
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

import project01.shoujioa.Adepter_All.follow_recyclerview_adepter;
import project01.shoujioa.gson_tool.new_String;
import project01.shoujioa.gson_tool.review_tool;
import project01.shoujioa.main_new_inten.Review_details;

public class Follow extends AppCompatActivity {
    private RecyclerView recyclerView;
    private follow_recyclerview_adepter follow_recyclerview_adepter;
    private ArrayList<new_String> arrayList=new ArrayList<>();
    private RequestQueue requestQueue;
    private String URL= HttpUtils.URL+"gwglapp/app_gwglgzlist";
    private String URLCX=HttpUtils.URL+"gwglapp/app_cxgzform";
    private SharedPreferences sp;
    private String ids;
    private TextView title_text;
    private Button img_btns;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        requestQueue= Volley.newRequestQueue(Follow.this);
        sp = Follow.this.getSharedPreferences("abc", 0);
        ids = sp.getString("id", "");
        initlist();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(100,100);
            }
        });

    }

    private void initlist() {
        recyclerView=findViewById(R.id.recyclerView_follow);
        swipeRefreshLayout=findViewById(R.id.srh);
        title_text=findViewById(R.id.title_text);
        title_text.setText("关注");
        View view=findViewById(R.id.includeone);
        img_btns=view.findViewById(R.id.img_btn);
        img_btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(arrayList.size()==0){
            initview();
        }else{
            follow_recyclerview_adepter.notifyDataSetChanged();
        }
    }

    private void initview() {

        StringRequest jsonObjectRequest=new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String jsonObject) {
                final Gson gson=new Gson();
                try {
                    JSONObject jsonObject1 = new JSONObject(jsonObject);
                    String message = jsonObject1.getString("message");
                    if(!message.equals("success")){

                    }else{
                        arrayList.clear();
                        review_tool review_toll = gson.fromJson(jsonObject, review_tool.class);
                        List<review_tool.DatasBean> datas = review_toll.getDatas();
                        for (int i = 0; i < datas.size(); i++) {
                            new_String new_string = new new_String();
                            new_string.setString_name(datas.get(i).getName());
                            new_string.setString_tiem(datas.get(i).getCreateDate());
                            new_string.setString_id(datas.get(i).getId());
                            new_string.setString_bid(datas.get(i).getBid());
                            arrayList.add(new_string);
                        }
                        follow_recyclerview_adepter=new follow_recyclerview_adepter(Follow.this,arrayList);
                        recyclerView.setLayoutManager(new LinearLayoutManager(Follow.this));
                        recyclerView.setAdapter(follow_recyclerview_adepter);
                        follow_recyclerview_adepter.setOnDeleteListener(new follow_recyclerview_adepter.OnDeleteListener() {
                            @Override
                            public void deletes(String id, String bid,String str) {
                                if(str.equals("1")){
                                    Intent intent=new Intent(Follow.this,Review_details.class);
                                    intent.putExtra("id",id);
                                    intent.putExtra("userid",ids);
                                    intent.putExtra("zhi","2");
                                    startActivity(intent);
                                }else if(str.equals("2")){
                                    initqxgz(id,bid);
                                    handler.sendEmptyMessageDelayed(100,100);
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

    private void initqxgz(final String id, final  String bid) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URLCX, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                handler.sendEmptyMessageDelayed(100,100);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(Follow.this, ""+volleyError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String ,String> map=new HashMap<>();
                map.put("bid",bid);
                return map;
            }
        }
                ;
        requestQueue.add(stringRequest);

    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            initlist();
            swipeRefreshLayout.setRefreshing(false);

        }
    };
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
