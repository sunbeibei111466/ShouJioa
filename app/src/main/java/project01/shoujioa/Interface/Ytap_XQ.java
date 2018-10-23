package project01.shoujioa.Interface;

import android.content.Intent;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project01.shoujioa.Adepter_All.Reprot_Adaper;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.Ytap_tool;

public class Ytap_XQ extends AppCompatActivity implements View.OnClickListener {
    private RequestQueue requestQueue;
    private String URL= HttpUtils.URL+"ytapapp/app_ytformlook";
    private Button btn_login;
    private TextView laiwendanwei,wenhao,fenshu,name,xbyj_text;
    private String id;
    private RecyclerView filename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ytap__xq);
        requestQueue= Volley.newRequestQueue(getApplicationContext());
        Intent intent = getIntent();
        id=intent.getStringExtra("id");
        initview();
        initDate();
    }

    private void initDate() {

        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();
                    Ytap_tool ytap_tool = gson.fromJson(s, Ytap_tool.class);
                    Ytap_tool.MapBean.WsjHyytBean wsjHyyt = ytap_tool.getMap().getWsjHyyt();
                    laiwendanwei.setText(wsjHyyt.getYtmc());
                    wenhao.setText(wsjHyyt.getSbks());
                    fenshu.setText(wsjHyyt.getHbsj());
                    name.setText(wsjHyyt.getUser2().getName());
                    xbyj_text.setText(wsjHyyt.getHbsj());
                    List<String> str = ytap_tool.getMap().getStr();
                    if(str.size()!=0){
                        Reprot_Adaper reprot_adaper=new Reprot_Adaper(getApplicationContext(),str);
                        filename.setAdapter(reprot_adaper);
                    }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> map=new HashMap<>();
                map.put("id",id);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void initview() {
        View view=findViewById(R.id.includeone);
        Button button=view.findViewById(R.id.img_btn);
        TextView textView=view.findViewById(R.id.title_text);
        textView.setText("办公会议题申报单");
        button.setOnClickListener(this);
        btn_login=findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        laiwendanwei=findViewById(R.id.laiwendanwei);
        wenhao=findViewById(R.id.wenhao);
        fenshu=findViewById(R.id.fenshu);
        name=findViewById(R.id.name);
        xbyj_text=findViewById(R.id.xbyj_text);
        filename=findViewById(R.id.filename);
        filename.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_btn:
                finish();
                break;
            case R.id.btn_login:
                finish();
                break;
        }

    }
}
