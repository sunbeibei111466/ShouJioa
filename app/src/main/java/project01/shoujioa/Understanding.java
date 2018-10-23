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

import project01.shoujioa.Adepter_All.review_recyclerview_adepter;
import project01.shoujioa.gson_tool.new_String;
import project01.shoujioa.gson_tool.review_toll;
import project01.shoujioa.main_new_inten.Review_details;

public class Understanding extends AppCompatActivity {
    private RecyclerView recyclerView;
    private review_recyclerview_adepter review_recyclerview_adepter;
    private RequestQueue requestQueue;
    private String URL= HttpUtils.URL+"gwglapp/app_gwgldylist";
    private SharedPreferences sp;
    private String ids;
    private TextView title_text;
    private Button img_btn;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<new_String> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_understanding);
        requestQueue= Volley.newRequestQueue(Understanding.this);
        sp = Understanding.this.getSharedPreferences("abc", 0);
        ids = sp.getString("id", "");
        initlist();
            handler.sendEmptyMessageDelayed(100,100);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(100,100);
            }
        });
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initlist() {
        View view=findViewById(R.id.includeone);
        img_btn=view.findViewById(R.id.img_btn);
        title_text=findViewById(R.id.title_text);
        title_text.setText("知会");
        recyclerView=findViewById(R.id.recyclerView_review);
        swipeRefreshLayout=findViewById(R.id.srh);
        if(arrayList.size()==0){
            initview();
        }else {
            review_recyclerview_adepter.notifyDataSetChanged();
        }


    }

    private void initview() {

        StringRequest jsonObjectRequest=new StringRequest (Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String jsonObject) {
                Gson gson=new Gson();
                try {
                    JSONObject jsonObject1=new JSONObject(jsonObject);
                    String message = jsonObject1.getString("message");
                    if(!message.equals("success")){

                    }else{
                        review_toll review_toll = gson.fromJson(jsonObject, review_toll.class);
                        List<project01.shoujioa.gson_tool.review_toll.DatasBean> datas = review_toll.getDatas();
                       arrayList.clear();
                        for(int i=0;i<datas.size();i++){
                            new_String new_string=new new_String();
                            new_string.setString_name(datas.get(i).getName());
                            new_string.setString_tiem(datas.get(i).getCreateDate());
                            new_string.setString_id(datas.get(i).getId());
                            arrayList.add(new_string);
                        }
                        review_recyclerview_adepter=new review_recyclerview_adepter(Understanding.this,arrayList);
                        recyclerView.setLayoutManager(new LinearLayoutManager(Understanding.this));
                        recyclerView.setAdapter(review_recyclerview_adepter);
                        review_recyclerview_adepter.setOnDeleteListener(new review_recyclerview_adepter.OnDeleteListener() {
                            @Override
                            public void delete(String position) {
                                Intent intent=new Intent(Understanding.this,Review_details.class);
                                intent.putExtra("id",position);
                                intent.putExtra("userid",ids);
                                intent.putExtra("zhi","2");
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
                Toast.makeText(Understanding.this, ""+volleyError.toString(), Toast.LENGTH_SHORT).show();
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
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
    protected void onRestart() {
        super.onRestart();
        handler.sendEmptyMessageDelayed(100,100);
    }
}
