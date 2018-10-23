package project01.shoujioa.Interface;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project01.shoujioa.Adepter_All.Reprot_Adaper;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.XQTOOL_all.TSXQ_toll;
import project01.shoujioa.XQ_adepter.TSXQ_adepter_main;
import project01.shoujioa.gson_tool.new_String;

public class TSXQ_mian extends AppCompatActivity {
    private String  userid,id;
    private Button btn_login;
    private String URL= HttpUtils.URL+"xinfangapp/app_lookform";
    private RequestQueue requestQueue;
    private TextView xfbh,xfly,bldw;
    private TSXQ_adepter_main tsxq_adepter_main;
    private RecyclerView ksbl_recyclerview,nbyj,fj;
    private List<new_String> mlist=new ArrayList<>();
    private List<new_String> mlistnb=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tsxq_mian);
        userid=getIntent().getStringExtra("userid");
        id=getIntent().getStringExtra("id");
        initview();
    }

    private void initview() {
        requestQueue= Volley.newRequestQueue(TSXQ_mian.this);
        btn_login=findViewById(R.id.btn_login);
        View view=findViewById(R.id.includeone);
        TextView textView=view.findViewById(R.id.title_text);
        Button img_btn=view.findViewById(R.id.img_btn);
        textView.setText("投诉详情");
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        xfbh=findViewById(R.id.xfbh);
        xfly=findViewById(R.id.xfly);
        bldw=findViewById(R.id.bldw);
        fj=findViewById(R.id.fj);
        nbyj=findViewById(R.id.nbyj);
        ksbl_recyclerview=findViewById(R.id.ksbl_recyclerview);

        initdate();
    }

    private void initdate() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();
                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String statuscode = jsonObject1.getString("statuscode");
                    if(statuscode.equals("200")){
                        TSXQ_toll tsxq_toll = gson.fromJson(s, TSXQ_toll.class);
                        TSXQ_toll.MapBean.WsjXinfangBean wsjXinfang = tsxq_toll.getMap().getWsjXinfang();
                        xfbh.setText(wsjXinfang.getBianhao());
                        xfly.setText(wsjXinfang.getLaiyuan());
                        bldw.setText(wsjXinfang.getDanwei());
                        List<String> str = tsxq_toll.getMap().getStr();
                        if(str.size()!=0){
                            Reprot_Adaper reprot_adaper=new Reprot_Adaper(getApplicationContext(),str);
                            fj.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            fj.setAdapter(reprot_adaper);
                        }
                        TSXQ_toll.MapBean.JulingdaoBean julingdao = tsxq_toll.getMap().getJulingdao();
                        if(julingdao.isIsNewRecord()==false){
                            new_String new_string=new new_String();
                            new_string.setString_name(julingdao.getYijian());
                            new_string.setString_tiem(julingdao.getQibanriqi());
                            mlistnb.add(new_string);
                            tsxq_adepter_main=new TSXQ_adepter_main(TSXQ_mian.this,mlistnb);
                            nbyj.setLayoutManager(new LinearLayoutManager(TSXQ_mian.this));
                            nbyj.setAdapter(tsxq_adepter_main);
                        }
                        List<TSXQ_toll.MapBean.KeshilistBean> keshilist = tsxq_toll.getMap().getKeshilist();
                        for(int i=0;i<keshilist.size();i++){
                            new_String new_string=new new_String();
                            new_string.setString_name(keshilist.get(i).getYijian());
                            new_string.setString_tiem(keshilist.get(i).getQibanriqi());
                            mlist.add(new_string);
                        }
                        tsxq_adepter_main=new TSXQ_adepter_main(TSXQ_mian.this,mlist);
                        ksbl_recyclerview.setLayoutManager(new LinearLayoutManager(TSXQ_mian.this));
                        ksbl_recyclerview.setAdapter(tsxq_adepter_main);
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
            protected Map<String, String> getParams()  {
                Map<String,String> map=new HashMap<>();
                map.put("userid",userid);
                map.put("id",id);
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
