package project01.shoujioa.Intent_mian;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
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

import project01.shoujioa.Adepter_All.HomeMobelCheckingExpandAdapter;
import project01.shoujioa.Adepter_All.Reprot_Adaper;
import project01.shoujioa.Adepter_All.adepter;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.XQTOOL_all.ERji_list_tool;
import project01.shoujioa.XQTOOL_all.TS_XQ_tool;
import project01.shoujioa.XQ_adepter.XFXQ_adepter;
import project01.shoujioa.gson_tool.er_String;
import project01.shoujioa.gson_tool.erji_two;
import project01.shoujioa.gson_tool.gw_tool;
import project01.shoujioa.gson_tool.new_String;

public class TS_db_xq extends AppCompatActivity implements View.OnClickListener {
    private String userid, id,keyuan="", append="";
    private String URL = HttpUtils.URL + "xinfangapp/app_tsdbform";
    private String URL_BC = HttpUtils.URL + "xinfangapp/app_dbsave1";
    private RequestQueue requestQueue;
    private Button img_btn, btn_login, xzld_btn, tj, xzry_btn;
    private TextView title_text;
    private TextView xfbh, xfly, bldw;
    private RecyclerView nbyj_recyclerview, ksbl_recyclerview,fj;
    private EditText ksbl_edittext, nbyj_edittext, xzld_text, xzks_text;
    private LinearLayout zgld, xzry;
    private List<new_String> mlistnb = new ArrayList<>();
    private ArrayList<new_String> arrayLister = new ArrayList();
    public ArrayList<String> mlistyi = new ArrayList<>();
    private XFXQ_adepter xfxq_adepter;
    private adepter adepter;
    private String xzString = "", URLstring = "", YJString = "", RYString = "";
    private HomeMobelCheckingExpandAdapter mobelCheckingExpandAdapter;
    private List<erji_two> mer_list = new ArrayList<>();
    private Map<String,String>map=new HashMap<>();
    private Map<String,String>map1=new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ts_db_xq);
        userid = getIntent().getStringExtra("userid");
        id = getIntent().getStringExtra("id");
        initview();
    }

    private void initview() {
        requestQueue = Volley.newRequestQueue(TS_db_xq.this);
        View view = findViewById(R.id.includeone);
        img_btn = view.findViewById(R.id.img_btn);
        title_text = view.findViewById(R.id.title_text);
        btn_login = findViewById(R.id.btn_login);
        title_text.setText("投诉待办详情");
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
        xfbh = findViewById(R.id.xfbh);
        xfly = findViewById(R.id.xfly);
        bldw = findViewById(R.id.bldw);
        fj = findViewById(R.id.fj);
        xzld_text = findViewById(R.id.xzld_text);
        zgld = findViewById(R.id.zgld);
        xzry = findViewById(R.id.xzry);
        xzks_text = findViewById(R.id.xzks_text);
        nbyj_edittext = findViewById(R.id.nbyj_edittext);
        ksbl_edittext = findViewById(R.id.ksbl_edittext);
        ksbl_edittext.setVisibility(View.GONE);
        nbyj_recyclerview = findViewById(R.id.nbyj_recyclerview);
        nbyj_recyclerview.setVisibility(View.GONE);
        ksbl_recyclerview = findViewById(R.id.ksbl_recyclerview);
        ksbl_recyclerview.setVisibility(View.GONE);
        zgld.setVisibility(View.GONE);
        xzry.setVisibility(View.GONE);

        tj = findViewById(R.id.tj);
        xzld_btn = findViewById(R.id.xzld_btn);
        xzld_btn.setOnClickListener(this);
        tj.setOnClickListener(this);
        xzry_btn = findViewById(R.id.xzry_btn);
        xzry_btn.setOnClickListener(this);
        initDate();
    }

    private void two() {

        final ArrayList<new_String> arrayList = new ArrayList();

        Gson gson = new Gson();

        try {
            JSONObject jsonObject1 = new JSONObject(URLstring);
            String message = jsonObject1.getString("message");
            if (!message.equals("success")) {

            } else {
                gw_tool gw_tool = gson.fromJson(URLstring, gw_tool.class);
                List<project01.shoujioa.gson_tool.gw_tool.MapBean.MinladerBean> minlader = gw_tool.getMap().getMinlader();
                for (int i = 0; i < minlader.size(); i++) {
                    new_String new_string = new new_String();
                    new_string.setString_id(minlader.get(i).getId());
                    new_string.setString_name(minlader.get(i).getName());
                    arrayList.add(new_string);
                }
                // 创建一个AlertDialog建造者
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                // 设置标题
                alertDialogBuilder.setTitle("科长");
                View view = View.inflate(this, R.layout.list_view, null);
                alertDialogBuilder.setView(view);
                ListView listView = view.findViewById(R.id.list_item);
                adepter = new adepter(this, arrayList,map1);
                listView.setAdapter(adepter);

                alertDialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        //TODO 业务逻辑代码

                        ArrayList<String>listid=new ArrayList<>();
                        for (String id:map1.keySet()){
                            listid.add(id);
                        }
                        xzString= toStingName(listid);
                        ArrayList<String>name=new ArrayList<>();
                        for (String names:map1.values()){
                            name.add(names);
                        }
                        String namelist = toStingName(name);
                        if(TextUtils.isEmpty(namelist)){
                            xzld_btn.setEnabled(true);
                            xzld_text.setText(namelist);
                        }else {
                            xzld_text.setText(namelist);
                            arrayList.clear();
                            xzry_btn.setEnabled(false);
                        }

                    }
                });
                alertDialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO 业务逻辑代码
                        append="";
                        xzString="";
                        xzld_text.setText(append);
                        xzry_btn.setEnabled(true);
                    }
                });
                alertDialogBuilder.show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    public static String toStingName(List<String>list){
        String s="";
        for (int i = 0; i <list.size(); i++) {
            if (s=="") {
                s=list.get(i);
            }else {
                s=s+","+list.get(i);
            }
        }
        return s;
    }

    private void one() {

        Gson gson = new Gson();
        try {
            JSONObject jsonObject1 = new JSONObject(URLstring);
            String message = jsonObject1.getString("message");
            if (!message.equals("success")) {
            } else {
                mlistyi.clear();
                arrayLister.clear();
                mer_list.clear();
                ERji_list_tool eRji_list_tool = gson.fromJson(URLstring, ERji_list_tool.class);
                //一级列表数据
                List<ERji_list_tool.MapBean.Minlader1Bean> minlader1 = eRji_list_tool.getMap().getMinlader1();
                //二级列表数据
                List<ERji_list_tool.MapBean.Minlader2Bean> minlader2 = eRji_list_tool.getMap().getMinlader2();


                for (int i = 0; i < minlader1.size(); i++) {
                    erji_two erji_two = new erji_two();
                    erji_two.setName(minlader1.get(i).getName());
                    erji_two.setId(minlader1.get(i).getId());
                    List<er_String> er_strings = new ArrayList<>();
                    for (int j = 0; j < minlader2.size(); j++) {
                        if (minlader2.get(j).getGuanlianid().equals(erji_two.getId())) {
                            er_String er_string = new er_String();
                            String name = minlader2.get(j).getName();
                            er_string.setEr_id(minlader2.get(j).getId());
                            er_string.setEr_name(name);
                            er_strings.add(er_string);
                            erji_two.setArrlist(er_strings);
                        }
                    }
                    mer_list.add(erji_two);
                }

                // 创建一个AlertDialog建造者
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                // 设置标题
                alertDialogBuilder.setTitle("人员");
                View view = View.inflate(this, R.layout.erji_list, null);
                alertDialogBuilder.setView(view);
                ExpandableListView expandableListView = view.findViewById(R.id.expand_list);
                mobelCheckingExpandAdapter = new HomeMobelCheckingExpandAdapter(mer_list, TS_db_xq.this, arrayLister,map);
                expandableListView.setAdapter(mobelCheckingExpandAdapter);

                alertDialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        ArrayList<String>listid=new ArrayList<>();
                        for (String id:map.keySet()){
                            listid.add(id);
                        }
                        RYString= toStingName(listid);
                        ArrayList<String>name=new ArrayList<>();
                        for (String names:map.values()){
                            name.add(names);
                        }
                        String namelist = toStingName(name);
                        if(TextUtils.isEmpty(namelist)){
                            xzry_btn.setEnabled(true);
                            xzks_text.setText(namelist);
                        }else{
                            xzks_text.setText(namelist);
                            mlistyi.clear();
                            arrayLister.clear();
                            mer_list.clear();
                            xzld_btn.setEnabled(false);
                        }


                    }
                });
                alertDialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        RYString="";
                        append="";
                        xzld_text.setText(append);
                        xzry_btn.setEnabled(true);
                        // TODO 业务逻辑代码
                    }
                });
                alertDialogBuilder.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void initDate() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                URLstring = s;
                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String statuscode = jsonObject1.getString("statuscode");
                    if (statuscode.equals("200")) {
                        Gson gson = new Gson();
                        TS_XQ_tool ts_xq_tool = gson.fromJson(s, TS_XQ_tool.class);
                        TS_XQ_tool.MapBean.WsjXinfangBean wsjXinfang = ts_xq_tool.getMap().getWsjXinfang();
                        xfbh.setText(wsjXinfang.getBianhao());
                        xfly.setText(wsjXinfang.getLaiyuan());
                        bldw.setText(wsjXinfang.getDanwei());
                        List<String> str = ts_xq_tool.getMap().getStr();
                        if(str.size()!=0){
                            Reprot_Adaper reprot_adaper=new Reprot_Adaper(getApplicationContext(),str);
                            fj.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            fj.setAdapter(reprot_adaper);
                        }
                        if (wsjXinfang.getJindu().equals("4")) {
                            zgld.setVisibility(View.VISIBLE);
                            xzry.setVisibility(View.VISIBLE);
                            ksbl_edittext.setVisibility(View.GONE);
                        } else if (wsjXinfang.getJindu().equals("5")) {
                            ksbl_edittext.setVisibility(View.VISIBLE);
                        }
                        TS_XQ_tool.MapBean.JulingdaoBean julingdao = ts_xq_tool.getMap().getJulingdao();
                        if (julingdao.isIsNewRecord() == false) {
                            if (julingdao.getDaiban().equals("0")) {
                                nbyj_edittext.setVisibility(View.GONE);
                                nbyj_recyclerview.setVisibility(View.VISIBLE);
                            } else {
                                nbyj_edittext.setVisibility(View.VISIBLE);
                                nbyj_recyclerview.setVisibility(View.GONE);
                            }
                            new_String new_string = new new_String();
                            new_string.setString_name(julingdao.getYijian());
                            new_string.setString_tiem(julingdao.getBanliriqi());
                            mlistnb.add(new_string);
                            xfxq_adepter = new XFXQ_adepter(TS_db_xq.this, mlistnb);
                            nbyj_recyclerview.setLayoutManager(new LinearLayoutManager(TS_db_xq.this));
                            nbyj_recyclerview.setAdapter(xfxq_adepter);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        fileList();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xzld_btn:
                two();
                break;
            case R.id.xzry_btn:
                one();
                break;
            case R.id.tj:
                PDinit();
                break;
        }
    }

    private void PDinit() {
        int visibility2 = zgld.getVisibility();
        if (visibility2 == 0) {
            if (!xzld_text.getText().toString().equals("")||xzks_text.getText().toString().equals("")) {
                initcc();
            }
        }
            YJString =nbyj_edittext.getText().toString().trim();
            initcc();

    }

    private void initcc() {
        StringRequest requestss = new StringRequest(Request.Method.POST, URL_BC, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
               TS_db_xq.this.finish();
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
                map.put("yijian", YJString);
                map.put("lingdao", xzString);
                map.put("renyuan", RYString);
                return map;
            }
        };
        requestQueue.add(requestss);
    }
}