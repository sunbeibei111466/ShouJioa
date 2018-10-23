package project01.shoujioa.Intent_mian;

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
import project01.shoujioa.XQ_adepter.XFXQ_adepter;
import project01.shoujioa.gson_tool.Xf_list_xq_tool;
import project01.shoujioa.gson_tool.new_String;

public class XF_intent_Main extends AppCompatActivity {
    private String id,userid;
    private Button btn_login;
    private String URL= HttpUtils.URL+"xinfangapp/app_showform";
    private RequestQueue requestQueue;
    private TextView name,xz,zbr,lxfs,fysj,nrzy,bz;
    private RecyclerView ldps_recyclerview,ksbl_recyclerview,nbyj,fj;
    private List<new_String> mlist=new ArrayList<>();
    private List<new_String> mlists=new ArrayList<>();
    private List<new_String> mlistnb=new ArrayList<>();
    private XFXQ_adepter xfxq_adepter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xf_intent__main);
        id=getIntent().getStringExtra("id");
        userid=getIntent().getStringExtra("userid");
        initview();
    }

    private void initview() {
        requestQueue= Volley.newRequestQueue(this);
        btn_login=findViewById(R.id.btn_login);
        View view=findViewById(R.id.includeone);
        TextView textView=view.findViewById(R.id.title_text);
        Button img_btn=view.findViewById(R.id.img_btn);
        textView.setText("信访详情");
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

        name=findViewById(R.id.name);
        xz=findViewById(R.id.xz);
        zbr=findViewById(R.id.zbr);
        lxfs=findViewById(R.id.lxfs);
        fysj=findViewById(R.id.fysj);
        nrzy=findViewById(R.id.nrzy);
        bz=findViewById(R.id.bz);
        fj=findViewById(R.id.fj);
        nbyj=findViewById(R.id.nbyj);
        ldps_recyclerview=findViewById(R.id.ldps_recyclerview);
        ksbl_recyclerview=findViewById(R.id.ksbl_recyclerview);
        initDate();
    }

    private void initDate() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String statuscode = jsonObject1.getString("statuscode");
                    if(statuscode.equals("200")){
                        Gson gson=new Gson();
                        Xf_list_xq_tool xf_list_xq_tool = gson.fromJson(s, Xf_list_xq_tool.class);
                        Xf_list_xq_tool.MapBean.WsjXinfangBean wsjXinfang = xf_list_xq_tool.getMap().getWsjXinfang();
                        name.setText(wsjXinfang.getName());
                        xz.setText(wsjXinfang.getXingzhi());
                        zbr.setText(wsjXinfang.getZhuanbr());
                        lxfs.setText(wsjXinfang.getLxfsjidz());
                        fysj.setText(wsjXinfang.getFysjjifs());
                        nrzy.setText(wsjXinfang.getNeirong());
                        bz.setText(wsjXinfang.getBeizu());
                        List<String> str = xf_list_xq_tool.getMap().getStr();
                        if(str.size()!=0){
                            Reprot_Adaper reprot_adaper=new Reprot_Adaper(getApplicationContext(),str);
                            fj.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            fj.setAdapter(reprot_adaper);
                        }
                        Xf_list_xq_tool.MapBean.JulingdaoBean julingdao = xf_list_xq_tool.getMap().getJulingdao();
                        if(julingdao.isIsNewRecord()==false){
                            new_String new_string=new new_String();
                            new_string.setString_name(julingdao.getYijian());
                            new_string.setString_tiem(julingdao.getBanliriqi());
                            mlistnb.add(new_string);
                        }
                        xfxq_adepter=new XFXQ_adepter(XF_intent_Main.this,mlistnb);
                        nbyj.setLayoutManager(new LinearLayoutManager(XF_intent_Main.this));
                        nbyj.setAdapter(xfxq_adepter);
                        List<Xf_list_xq_tool.MapBean.ZhuguanlistBean> zhuguanlist = xf_list_xq_tool.getMap().getZhuguanlist();
                        for(int i=0;i<zhuguanlist.size();i++){
                            new_String new_string=new new_String();
                            new_string.setString_name(zhuguanlist.get(i).getYijian());
                            new_string.setString_tiem(zhuguanlist.get(i).getBanliriqi());
                            mlists.add(new_string);
                        }
                        xfxq_adepter=new XFXQ_adepter(XF_intent_Main.this,mlists);
                        ldps_recyclerview.setLayoutManager(new LinearLayoutManager(XF_intent_Main.this));
                        ldps_recyclerview.setAdapter(xfxq_adepter);
                        //科室办理
                        List<Xf_list_xq_tool.MapBean.KeshilistBean> keshilist = xf_list_xq_tool.getMap().getKeshilist();
                        for(int i=0;i<keshilist.size();i++){
                            new_String new_string=new new_String();
                            new_string.setString_name(keshilist.get(i).getYijian());
                            new_string.setString_tiem(keshilist.get(i).getQibanriqi());
                            mlist.add(new_string);
                        }
                        xfxq_adepter=new XFXQ_adepter(XF_intent_Main.this,mlist);
                        ksbl_recyclerview.setLayoutManager(new LinearLayoutManager(XF_intent_Main.this));
                        ksbl_recyclerview.setAdapter(xfxq_adepter);
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
        finish();
    }
}
