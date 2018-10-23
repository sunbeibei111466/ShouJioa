package project01.shoujioa.Interface;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
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

import project01.shoujioa.Adepter_All.lips_adepter_two;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.gw_tool;
import project01.shoujioa.gson_tool.new_String;

public class gw_shengpi_read extends AppCompatActivity {
    private String url = HttpUtils.URL + "gwglapp/app_gwgldbbl";
    private RequestQueue requestQueue;
    private String id, userid, eeee;

    private String gw_id;

    private EditText xbyj_edit,db_edit,lips_edit,ksyj_edit,xzks_text,xzld_text;
    private TextView xbyj_text,db_text;
    private ListView lips_list,ksyj_list;
    private lips_adepter_two lips_adepter;

    private Button xzks_btn,xzld_btn,btn_login,xzky_btn;
    private TextView jinjichengdu, chuangjianriqi, hao, wenhao, fenshu, laiwendanwei, name;
    private TextView filename, remarks;

    private LinearLayout zgks, zgld;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gw_shenpi_head);
        requestQueue = Volley.newRequestQueue(this);
        //用户id
        userid = getIntent().getStringExtra("userid");
        //公文id
        id = getIntent().getStringExtra("id");
        initdate();
        initview();
    }

    @SuppressLint("WrongViewCast")
    private void initdate() {
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
        xzks_btn=findViewById(R.id.xzks_btn);
        xzld_btn=findViewById(R.id.xzld_btn);
        btn_login=findViewById(R.id.btn_login);
        xzky_btn=findViewById(R.id.xzky_btn);
        xzks_btn.setEnabled(false);
        xzld_btn.setEnabled(false);
        xzky_btn.setEnabled(false);
        View view=findViewById(R.id.layout_id);
        TextView textView=view.findViewById(R.id.title_text);
        textView.setText("预警详情");
        Button img_btn=view.findViewById(R.id.img_btn);
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        xzld_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        xzks_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        jinjichengdu = findViewById(R.id.jinjichengdu);
        chuangjianriqi = findViewById(R.id.chuangjianriqi);
        hao = findViewById(R.id.hao);
        wenhao = findViewById(R.id.wenhao);
        fenshu = findViewById(R.id.fenshu);
        laiwendanwei = findViewById(R.id.laiwendanwei);
        name = findViewById(R.id.name);
        filename = findViewById(R.id.filename);
        remarks = findViewById(R.id.remarks);
    }

    private void initview() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
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
                            jinjichengdu.setText(wsjGongwen.getJinjichengdu());
                            chuangjianriqi.setText(wsjGongwen.getChuangjianriqi());
                            hao.setText("第" + wsjGongwen.getHao() + "号");
                            laiwendanwei.setText(wsjGongwen.getLaiwendanwei());
                            wenhao.setText(wsjGongwen.getWenhao());
                            fenshu.setText(wsjGongwen.getFenshu());
                            name.setText(wsjGongwen.getName());
                            filename.setText(wsjGongwen.getFilename());
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
                                db_edit.setVisibility(View.GONE);
                                db_text.setVisibility(View.VISIBLE);
                            }
                        }
                        //领导批示
                        List<project01.shoujioa.gson_tool.gw_tool.MapBean.ZhuguanlistBean> zhuguanlist = gw_tool.getMap().getZhuguanlist();
                        if (zhuguanlist.size() == 0) {
                        } else {
                            ArrayList<new_String> list=new ArrayList<>();
                            for (int i = 0; i < zhuguanlist.size(); i++) {
                                if (zhuguanlist.get(i).getDaiban().equals("1")) {
                                    lips_edit.setVisibility(View.GONE);
                                    lips_list.setVisibility(View.GONE);
                                } else if (zhuguanlist.get(i).getDaiban().equals("0")) {
                                    lips_edit.setVisibility(View.GONE);
                                    lips_list.setVisibility(View.VISIBLE);
                                }
                                new_String new_string=new new_String();
                                new_string.setString_name(zhuguanlist.get(i).getYijian());
                                new_string.setString_tiem(zhuguanlist.get(i).getCreateDate());
                                new_string.setString_id(zhuguanlist.get(i).getId());
                                list.add(new_string);
                            }
                            lips_adepter=new lips_adepter_two(gw_shengpi_read.this,list);
                            lips_list.setAdapter(lips_adepter);
                        }
                        //科室办理
                        List<project01.shoujioa.gson_tool.gw_tool.MapBean.KeshilistBean> keshilist = gw_tool.getMap().getKeshilist();
                        if (keshilist.size() == 0) {
                        } else {
                            ArrayList<new_String> list=new ArrayList<>();
                            for (int i = 0; i < keshilist.size(); i++) {
                                if (keshilist.get(i).getDaiban().equals("1")) {
                                    ksyj_edit.setVisibility(View.GONE);
                                    ksyj_list.setVisibility(View.GONE);
                                } else if (keshilist.get(i).getDaiban().equals("0")) {
                                    ksyj_edit.setVisibility(View.GONE);
                                    ksyj_list.setVisibility(View.VISIBLE);
                                }
                                new_String new_string=new new_String();
                                new_string.setString_name(zhuguanlist.get(i).getYijian());
                                new_string.setString_tiem(zhuguanlist.get(i).getCreateDate());
                                new_string.setString_id(zhuguanlist.get(i).getId());
                                list.add(new_string);
                            }
                            lips_adepter=new lips_adepter_two(gw_shengpi_read.this,list);
                            lips_list.setAdapter(lips_adepter);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Toast.makeText(gw_shengpi_read.this, "" + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
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
}
