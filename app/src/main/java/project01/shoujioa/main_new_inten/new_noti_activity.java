package project01.shoujioa.main_new_inten;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import project01.shoujioa.Adepter_All.noti_ci_two_adepter;
import project01.shoujioa.Fragment_main.noti_Fragmenttwo;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.new_String;
import project01.shoujioa.gson_tool.noti_Fragment_list_tool;
import project01.shoujioa.new_ci_main_two;

public class new_noti_activity extends AppCompatActivity {
    ArrayList<Fragment> mfragments=new ArrayList<>();
    private String URL_tz= HttpUtils.URL+"tzggapp/app_tzgglist";
    private String URL_xw= HttpUtils.URL+"xwzxapp/app_xwzxlist";
    private TextView textView;
    private Button img_btn;
    private List<new_String> arraylist=new ArrayList<>();
    private noti_ci_two_adepter noti_ci_two_adepter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RequestQueue requestQueue;
    private String userid;
    private SharedPreferences sp;
    String pos;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos= getIntent().getStringExtra("pos");
        setContentView(R.layout.noti_new_main);
        requestQueue= Volley.newRequestQueue(getApplicationContext());
        sp =getSharedPreferences("abc", 0);
        userid = sp.getString("id", "");
        recyclerView=findViewById(R.id.read_recyclerview);
        swipeRefreshLayout=findViewById(R.id.shr);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(100,100);
            }
        });
        if(pos.equals("1")){
            initdate();
        }else if(pos.equals("2")){
            initview();
        }
    }

    private void initview() {
        View view1=findViewById(R.id.includeone);
        img_btn=view1.findViewById(R.id.img_btn);
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        textView=view1.findViewById(R.id.title_text);
        textView.setText("新闻期刊");
        initDate(URL_xw,"2");
    }



    private void initdate() {
        mfragments.add(new noti_Fragmenttwo());
        View view1=findViewById(R.id.includeone);
        img_btn=view1.findViewById(R.id.img_btn);
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        textView=view1.findViewById(R.id.title_text);
        textView.setText("通知公告");
        initDate(URL_tz,"3");
    }
    @SuppressLint("HandlerLeak")
    Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(arraylist.size()==0){
            }else{
                noti_ci_two_adepter.notifyDataSetChanged();
            }
            swipeRefreshLayout.setRefreshing(false);
        }
    };

    private void initDate(String URL,final String zhi) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();

                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String message = jsonObject1.getString("message");
                    arraylist.clear();
                    if(!message.equals("success")){

                    }else{
                        noti_Fragment_list_tool noti_fragment_list_tool = gson.fromJson(s, noti_Fragment_list_tool.class);
                        List<noti_Fragment_list_tool.DatasBean> datas = noti_fragment_list_tool.getDatas();
                        for(int i=0;i<datas.size();i++){
                            new_String new_string=new new_String();
                            new_string.setString_name(datas.get(i).getBt());
                            new_string.setString_id(datas.get(i).getId());
                            new_string.setZjh(zhi);
                            new_string.setFlag(datas.get(i).getLx());
                            new_string.setString_tiem(datas.get(i).getCreateDate());
                            arraylist.add(new_string);
                        }
                        noti_ci_two_adepter=new noti_ci_two_adepter(getApplicationContext(),arraylist,zhi);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        recyclerView.setAdapter(noti_ci_two_adepter);
                        noti_ci_two_adepter.setOnDeleteListener(new noti_ci_two_adepter.OnDeleteListener() {
                            @Override
                            public void delete(String id) {
                                Intent intent=new Intent(getApplicationContext(),new_ci_main_two.class);
                                intent.putExtra("id",id);
                                intent.putExtra("userid",userid);
                                intent.putExtra("zhi",zhi);
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
            protected Map<String, String> getParams() {
                Map<String,String> map=new HashMap<>();
                map.put("userid",userid);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }
}