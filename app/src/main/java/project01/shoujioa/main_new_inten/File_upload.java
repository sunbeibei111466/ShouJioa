package project01.shoujioa.main_new_inten;

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

import project01.shoujioa.Adepter_All.File_upload_adepter_two;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.File_unload_tool_two;
import project01.shoujioa.gson_tool.new_String;

public class File_upload extends AppCompatActivity {
    private RecyclerView recyclerView;
    File_upload_adepter_two file_upload_adepter_two;
    private String URL= HttpUtils.URL+"wjcdapp/app_wjcdsclist";
    private RequestQueue requestQueue;
    private SharedPreferences sp;
    private String userid;
    private ArrayList<new_String> newStrings=new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_upload);
        initview();
        initDate();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(100,100);
            }
        });
    }
    private void initDate() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();

                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String message = jsonObject1.getString("message");
                    newStrings.clear();
                    if(!message.equals("success")){

                    }else{
                        File_unload_tool_two file_unload_tool = gson.fromJson(s, File_unload_tool_two.class);
                        List<File_unload_tool_two.DatasBean> datas =file_unload_tool.getDatas();
                        for(int i=0;i<datas.size();i++){
                            new_String new_string=new new_String();
                            new_string.setString_name(datas.get(i).getName());
                            new_string.setString_tiem(datas.get(i).getNameTime());
                            new_string.setString_id(datas.get(i).getId());
                            newStrings.add(new_string);
                        }
                        file_upload_adepter_two=new File_upload_adepter_two(File_upload.this,newStrings);
                        recyclerView.setLayoutManager(new LinearLayoutManager(File_upload.this));
                        recyclerView.setAdapter(file_upload_adepter_two);
                        file_upload_adepter_two.setOnDeleteListener(new File_upload_adepter_two.OnDeleteListener() {
                            @Override
                            public void delete(String id) {
                                Intent intent=new Intent(File_upload.this,Filed_already_two.class);
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
                Toast.makeText(File_upload.this, ""+volleyError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> map=new HashMap<>();
                map.put("createby",userid);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void initview() {
        requestQueue= Volley.newRequestQueue(this);
        recyclerView=findViewById(R.id.two_recyclerview);
        sp = getSharedPreferences("abc", 0);
        userid = sp.getString("id", "");
        swipeRefreshLayout=findViewById(R.id.shr);

        View view=findViewById(R.id.includeone);
        TextView title_text=view.findViewById(R.id.title_text);
        title_text.setText("文件传递");
        Button img_btn=view.findViewById(R.id.img_btn);
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            initDate();
            swipeRefreshLayout.setRefreshing(false);
        }
    };

}
