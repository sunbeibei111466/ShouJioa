package project01.shoujioa.main_new_inten;

import android.os.Bundle;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project01.shoujioa.Adepter_All.Reprot_Adaper;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.system_main_tool;

public class system_mian_Raed extends AppCompatActivity {
private String URL= HttpUtils.URL+"gzzdapp/app_bianji";
private TextView editText,tv_bt_id,edid_id,xzks_text;
private Button btn_login;
private String ids;
    private TextView textView;
    private Button img_btn;
private RequestQueue requestQueue;
private RecyclerView RecyclerView_filename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_mian__raed);
        ids=getIntent().getStringExtra("id");
        requestQueue= Volley.newRequestQueue(system_mian_Raed.this);
        initview();
        initDate();
    }

    private void initDate() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();
                try {
                    JSONObject jsonObject1=new JSONObject(s);
                    String message = jsonObject1.getString("message");
                    if(!message.equals("success")){

                    }else{
                        system_main_tool system_mian_tool = gson.fromJson(s, system_main_tool.class);
                        system_main_tool.MapBean.WsjSystemBean wsjSystem = system_mian_tool.getMap().getWsjSystem();
                        editText.setText(wsjSystem.getName());
                        tv_bt_id.setText(wsjSystem.getHeTitle());
                        edid_id.setText(wsjSystem.getType());
                        xzks_text.setText(wsjSystem.getChuchu());
                        List<String> str = system_mian_tool.getMap().getStr();
                        if(str.size()!=0){
                            Reprot_Adaper reprot_adaper=new Reprot_Adaper(getApplicationContext(),str);
                            RecyclerView_filename.setAdapter(reprot_adaper);
                        }
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
                map.put("id",ids);
                return map;
            }
        };
        requestQueue.add(stringRequest);
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
        textView.setText("规章详情");
        xzks_text=findViewById(R.id.xzks_text);
        editText=findViewById(R.id.editText);
        tv_bt_id=findViewById(R.id.tv_bt_id);
        edid_id=findViewById(R.id.edid_id);
        RecyclerView_filename=findViewById(R.id.RecyclerView_filename);
        RecyclerView_filename.setLayoutManager(new LinearLayoutManager(this));
        btn_login=findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}