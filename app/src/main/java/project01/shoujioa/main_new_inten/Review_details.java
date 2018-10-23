package project01.shoujioa.main_new_inten;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import project01.shoujioa.Adepter_All.lips_Adepter;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.gw_tool;
import project01.shoujioa.gson_tool.new_String;

public class Review_details extends AppCompatActivity {
    private String id,userid;
    private String URL= HttpUtils.URL+"gwglapp/app_showform1";
    private RequestQueue requestQueue;
    private Button btn_login;
    private EditText xbyj_edit,db_edit,lips_edit,ksyj_edit;
    private TextView xbyj_text,db_text,xzks_text,xzky_text,xzld_text;
    private RecyclerView lips_list,ksyj_list,filename;
    private lips_Adepter lips_adepter;
    private lips_Adepter mlips_adepter;
    private String gw_id,zhi;
    private Button xzks_btn,xzld_btn,xzky_btn,img_btn;
    private TextView  wenhao, laiwendanwei, name;
    private TextView  remarks;
   private ArrayList<new_String> list=new ArrayList<>();
    private ArrayList<new_String> mlist=new ArrayList<>();
    private LinearLayout zgks, zgld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_details);
        id=getIntent().getStringExtra("id");
        userid=getIntent().getStringExtra("userid");
        zhi=getIntent().getStringExtra("zhi");
        requestQueue= Volley.newRequestQueue(this);
        initview();
        initDate();
    }

    private void initDate() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String message = jsonObject1.getString("message");
                    if (!message.equals("success")) {

                    } else {

                        Gson gson = new Gson();
                        gw_tool gw_tool = gson.fromJson(s, gw_tool.class);
                        project01.shoujioa.gson_tool.gw_tool.MapBean.WsjGongwenBean wsjGongwen = gw_tool.getMap().getWsjGongwen();
                        if (wsjGongwen.equals("")) {

                        } else {
                            laiwendanwei.setText(wsjGongwen.getLaiwendanwei());
                            wenhao.setText(wsjGongwen.getWenhao());
                            name.setText(wsjGongwen.getName());
                            List<String> str = gw_tool.getMap().getStr();
                            if(str.size()!=0){
                                Reprot_Adaper reprot_adaper=new Reprot_Adaper(getApplicationContext(),str);
                                filename.setAdapter(reprot_adaper);
                            }
                            remarks.setText(wsjGongwen.getRemarks());
                            gw_id = wsjGongwen.getId();
                            if (wsjGongwen.getJindu().equals("2")) {
                                zgld.setVisibility(View.VISIBLE);
                                zgks.setVisibility(View.GONE);
                            } else if (wsjGongwen.getJindu().equals("4")) {
                                zgks.setVisibility(View.VISIBLE);
                                zgld.setVisibility(View.VISIBLE);
                            }
                        }
                        //协办意见
                        project01.shoujioa.gson_tool.gw_tool.MapBean.JulingdaoBean julingdao = gw_tool.getMap().getJulingdao();
                        if (julingdao.isIsNewRecord()==true) {
                        } else {
                            if (julingdao.getDaiban().equals("1")) {
                                xbyj_edit.setVisibility(View.GONE);
                                xbyj_text.setVisibility(View.GONE);
                            } else if (julingdao.getDaiban().equals("0")) {
                                xbyj_text.setText(julingdao.getYijian());
                                xbyj_text.setVisibility(View.VISIBLE);
                                xbyj_edit.setVisibility(View.GONE);
                            }
                        }
                        //督办
                        project01.shoujioa.gson_tool.gw_tool.MapBean.WenBean wen = gw_tool.getMap().getWen();
                        if (wen.isIsNewRecord()==true) {

                        } else {
                            if (wen.getDaiban().equals("1")) {
                                db_edit.setVisibility(View.GONE);
                                db_text.setVisibility(View.GONE);
                            } else if (wen.getDaiban().equals("0")) {
                                db_text.setText(wen.getYijian());
                                db_edit.setVisibility(View.GONE);
                                db_text.setVisibility(View.VISIBLE);
                            }
                        }
                        //领导批示
                        List<project01.shoujioa.gson_tool.gw_tool.MapBean.ZhuguanlistBean> zhuguanlist = gw_tool.getMap().getZhuguanlist();
                        if (zhuguanlist.size()==0) {
                        } else {
                            for (int i = 0; i < zhuguanlist.size(); i++) {
                                new_String new_string=new new_String();
                                new_string.setString_name(zhuguanlist.get(i).getYijian());
                                new_string.setString_tiem(zhuguanlist.get(i).getBanliriqi());
                                new_string.setString_id(zhuguanlist.get(i).getId());
                                new_string.setString_bid(zhuguanlist.get(i).getName());
                                list.add(new_string);
                            }
                            mlips_adepter=new lips_Adepter(Review_details.this,list);
                            lips_list.setLayoutManager(new LinearLayoutManager(Review_details.this));
                            lips_list.setAdapter(mlips_adepter);
                        }
                        //科室办理
                        List<project01.shoujioa.gson_tool.gw_tool.MapBean.KeshilistBean> keshilist = gw_tool.getMap().getKeshilist();
                        if (keshilist.size()==0) {
                        } else {
                            for (int i = 0; i < keshilist.size(); i++) {
                                new_String new_string=new new_String();
                                new_string.setString_name(keshilist.get(i).getYijian());
                                new_string.setString_tiem(keshilist.get(i).getBanliriqi());
                                new_string.setString_id(keshilist.get(i).getId());
                                new_string.setString_bid(keshilist.get(i).getName());
                                mlist.add(new_string);
                            }
                            lips_adepter=new lips_Adepter(Review_details.this,mlist);
                            ksyj_list.setLayoutManager(new LinearLayoutManager(Review_details.this));
                            ksyj_list.setAdapter(lips_adepter);
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
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> map = new HashMap<>();
                map.put("userid", userid);
                map.put("id", id);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }


    private void initview() {
        View view=findViewById(R.id.layout_id);
        TextView textView=view.findViewById(R.id.title_text);
        if(zhi.equals("1")){
            textView.setText("已办详情");
        }else if (zhi.equals("2")){
            textView.setText("知会详情");
        }else if (zhi.equals("3")){
            textView.setText("关注详情");
        }
        btn_login=findViewById(R.id.btn_login);
        //协办意见
        xbyj_edit = findViewById(R.id.xbyj_edit);
        xbyj_text = findViewById(R.id.xbyj_text);
        //督办
        db_edit=findViewById(R.id.db_edit);
        db_text=findViewById(R.id.db_text);
        //主管 科室
        zgks = findViewById(R.id.zgkz);
        zgld = findViewById(R.id.zgld);
        zgld.setVisibility(View.GONE);
        zgks.setVisibility(View.GONE);

        //领导批示
        lips_edit=findViewById(R.id.lips_edit);

        lips_list=findViewById(R.id.lips_list);
        //科室
        ksyj_edit=findViewById(R.id.ksyj_edit);

        ksyj_list=findViewById(R.id.ksyj_list);
        //选择
        xzks_text=findViewById(R.id.xzks_text);
        xzld_text=findViewById(R.id.xzld_text);
        xzky_text=findViewById(R.id.xzky_text);

        xzks_btn=findViewById(R.id.xzks_btn);
        xzld_btn=findViewById(R.id.xzld_btn);
        xzky_btn=findViewById(R.id.xzky_btn);

        xzld_btn.setEnabled(false);
        xzks_btn.setEnabled(false);
        xzky_btn.setEnabled(false);
        xzky_text.setFocusable(false);
        xzky_text.setFocusableInTouchMode(false);
        xzky_text.setClickable(false);

        xzks_text.setFocusable(false);
        xzks_text.setFocusableInTouchMode(false);
        xzks_text.setClickable(false);

        xzld_text.setFocusable(false);
        xzld_text.setFocusableInTouchMode(false);
        xzld_text.setClickable(false);

        lips_edit.setVisibility(View.GONE);
        lips_list.setVisibility(View.VISIBLE);

        ksyj_edit.setVisibility(View.GONE);
        ksyj_list.setVisibility(View.VISIBLE);

        db_edit.setVisibility(View.GONE);

        wenhao = findViewById(R.id.wenhao);
        laiwendanwei = findViewById(R.id.laiwendanwei);
        name = findViewById(R.id.name);
        filename = findViewById(R.id.filename);
        remarks = findViewById(R.id.remarks);
        img_btn=view.findViewById(R.id.img_btn);
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
        filename.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
