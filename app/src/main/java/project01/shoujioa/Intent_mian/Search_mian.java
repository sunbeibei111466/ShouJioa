package project01.shoujioa.Intent_mian;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

import project01.shoujioa.Adepter_All.agency_recyclerview_adepter;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.agency_toll;
import project01.shoujioa.gson_tool.new_String;
import project01.shoujioa.gw_shengpi;

public class Search_mian extends AppCompatActivity {
private RecyclerView recyclerView;
private String seaarch;
    private agency_recyclerview_adepter agency_recyclerview_adepter;
    private ArrayList<new_String> arrayList = new ArrayList<>();
    private RequestQueue requestQueue;
    private String URL = HttpUtils.URL+"gwglapp/app_gwgldblist";
    private SharedPreferences sp;
    private String ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_mian);
        initview();
        initdate();
    }

    private void initdate() {
        StringRequest jsonObjectRequest=new StringRequest (Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String jsonObject) {
                Gson gson=new Gson();
                try {
                    JSONObject jsonObject1 = new JSONObject(jsonObject);
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
                        agency_recyclerview_adepter=new agency_recyclerview_adepter(Search_mian.this,arrayList);
                        recyclerView.setLayoutManager(new LinearLayoutManager(Search_mian.this));
                        recyclerView.setAdapter(agency_recyclerview_adepter);
                        agency_recyclerview_adepter.setOnDeleteListener(new agency_recyclerview_adepter.OnDeleteListener() {
                            @Override
                            public void delete(String id) {
                                Intent intent=new Intent(Search_mian.this,gw_shengpi.class);
                                intent.putExtra("id",id);
                                intent.putExtra("userid",ids);
                                startActivity(intent);
                                agency_recyclerview_adepter.notifyDataSetChanged();
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
                Toast.makeText(Search_mian.this, ""+volleyError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        })
        {
            @Override
            public Map<String, String> getParams(){
                Map<String,String> map =new HashMap<>();

                map.put("name",seaarch);
                return map;
            }
        }
                ;
        requestQueue.add(jsonObjectRequest);
    }

    private void initview() {
        requestQueue = Volley.newRequestQueue(this);
        sp =this.getSharedPreferences("abc", 0);
        ids = sp.getString("id", "");
        seaarch = getIntent().getStringExtra("search");
        recyclerView=findViewById(R.id.search_recycler);
        View view=findViewById(R.id.includeone);
        TextView title_text=view.findViewById(R.id.title_text);
        title_text.setText("搜索详情");
        Button img_btn=view.findViewById(R.id.img_btn);
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        arrayList.clear();
    }
}

