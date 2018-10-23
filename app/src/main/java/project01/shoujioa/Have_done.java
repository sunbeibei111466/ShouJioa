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

import project01.shoujioa.Adepter_All.adepter_zh_xz;
import project01.shoujioa.Adepter_All.have_recyclerview_adepter;
import project01.shoujioa.Fragment_main.read_toll;
import project01.shoujioa.gson_tool.new_String;
import project01.shoujioa.main_new_inten.Review_details;

public class Have_done extends AppCompatActivity {
    private RecyclerView hava_recyclerview;
    private have_recyclerview_adepter have_recyclerview_adepter;
    private ArrayList<new_String> arrayList=new ArrayList<>();
    private RequestQueue requestQueue;
    private String URL= HttpUtils.URL+"gwglapp/app_gwglyblist";
    private String URLGZ=HttpUtils.URL+"gwglapp/app_gzform";
    private String URLZH_XZ=HttpUtils.URL+"gwglapp/app_zh";
    private String UTLZH_BC=HttpUtils.URL+"gwglapp/app_zhsave";
    private SharedPreferences sp;
    private String ids=null;
    private String  gw_id=null;
    private String zh_xz_id=null;
    private adepter_zh_xz adepter;
    final StringBuilder stringBuilderone = new StringBuilder();
    private Button img_btn;
    private TextView title_text;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_have_done);
        requestQueue= Volley.newRequestQueue(Have_done.this);
        sp = Have_done.this.getSharedPreferences("abc", 0);
        //用户id
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
        hava_recyclerview=findViewById(R.id.hava_recyclerview);
        swipeRefreshLayout=findViewById(R.id.srh);
        View view=findViewById(R.id.includeone);
        title_text=view.findViewById(R.id.title_text);
        title_text.setText("已办");
        img_btn=view.findViewById(R.id.img_btn);
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(arrayList.size()==0){
            initview();
        }else{
            have_recyclerview_adepter.notifyDataSetChanged();
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
                            new_string.setString_bid(datas.get(i).getGuanzhu());
                            new_string.setString_gl(datas.get(i).getGuanlian());
                            arrayList.add(new_string);
                        }
                        have_recyclerview_adepter=new have_recyclerview_adepter(Have_done.this,arrayList);
                        hava_recyclerview.setLayoutManager(new LinearLayoutManager(Have_done.this));
                        hava_recyclerview.setAdapter(have_recyclerview_adepter);
                        have_recyclerview_adepter.setOnDeleteListener(new have_recyclerview_adepter.OnDeleteListener() {
                            @Override
                            public void delete(String id,String gw_ids,String gl) {

                                gw_id=gw_ids;
                                Intent intent=new Intent(Have_done.this,Review_details.class);
                                intent.putExtra("id",gw_id);
                                intent.putExtra("userid",ids);
                                intent.putExtra("zhi","1");
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

    @Override
    public void onBackPressed() {
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

}
