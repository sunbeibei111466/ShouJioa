package project01.shoujioa;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
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

import project01.shoujioa.Adepter_All.CarAdapter;
import project01.shoujioa.Adepter_All.Reprot_Adaper;
import project01.shoujioa.Adepter_All.adepter;
import project01.shoujioa.Adepter_All.lips_Adepter;
import project01.shoujioa.gson_tool.Spinner_tool;
import project01.shoujioa.gson_tool.gw_tool;
import project01.shoujioa.gson_tool.new_String;

public class gw_shengpi extends AppCompatActivity implements View.OnClickListener {
    private String url = HttpUtils.URL + "gwglapp/app_gwgldbbl";
    private String urlbc = HttpUtils.URL + "gwglapp/app_gwgldbbc";
    private RequestQueue requestQueue;
    private String id, userid, eeee;
    private EditText xbyj_edit, db_edit, lips_edit, ksyj_edit;
    private TextView  db_text, xzld_text, xzks_text, xzky_text;
    private lips_Adepter lips_adepter;
    private RecyclerView lips_list, ksyj_list, RecyclerView_filename,xbyj_text;
    private Button border_line_while, xzks_btn, xzld_btn, xzky_btn, img_btn, btn_back;
    private String gw_id;
    private TextView wenhao, laiwendanwei, name;
    private TextView remarks;
    private adepter adepter;
    private LinearLayout zgks, zgld, ky;
    private String URL = HttpUtils.URL + "cyyapp/app_cyylist";
    private Spinner spinner_1;
    private ArrayList<String> mlist = new ArrayList<>();
    String lingdao = "";
    String kezhang = "";
    String keyuan = "";
    String keshi = "";
    String xbyj_String = "";
    String append = "";
    ArrayList<new_String> arrayList = new ArrayList();
    private Map<String, String> map = new HashMap<>();
    private Map<String, String> map1 = new HashMap<>();
    private Map<String, String> map2 = new HashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gw_shenpi);
        requestQueue = Volley.newRequestQueue(this);
        id = getIntent().getStringExtra("id");
        userid = getIntent().getStringExtra("userid");
        initdate();
        initview();
        border_line_while.setOnClickListener(this);
    }

    @SuppressLint("WrongViewCast")
    private void initdate() {
        View view = findViewById(R.id.includeone);
        img_btn = view.findViewById(R.id.img_btn);
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //spinner
        spinner_1 = findViewById(R.id.spinner_1);
        initspinner(userid);
        //协办意见
        xbyj_edit = findViewById(R.id.xbyj_edit);
        xbyj_text = findViewById(R.id.xbyj_text);
        //督办
        db_edit = findViewById(R.id.db_edit);
        db_text = findViewById(R.id.db_text);
        //主管 科室
        zgks = findViewById(R.id.zgkz);
        zgld = findViewById(R.id.zgld);
        ky = findViewById(R.id.zgky);

        zgld.setVisibility(View.GONE);
        zgks.setVisibility(View.GONE);
        //科员

        ky.setVisibility(View.GONE);
        //领导批示
        lips_edit = findViewById(R.id.lips_edit);
        lips_list = findViewById(R.id.lips_list);
        //科室
        ksyj_edit = findViewById(R.id.ksyj_edit);
        ksyj_list = findViewById(R.id.ksyj_list);
        //选择
        xzks_text = findViewById(R.id.xzks_text);
        xzld_text = findViewById(R.id.xzld_text);
        xzks_btn = findViewById(R.id.xzks_btn);
        xzld_btn = findViewById(R.id.xzld_btn);

        //选择科员
        xzky_text = findViewById(R.id.xzky_text);
        xzky_btn = findViewById(R.id.xzky_btn);
        xzky_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogs(3);
            }
        });


        xzld_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogs(1);
            }
        });
        xzks_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogs(2);
            }
        });

        wenhao = findViewById(R.id.wenhao);
        laiwendanwei = findViewById(R.id.laiwendanwei);
        name = findViewById(R.id.name);
        RecyclerView_filename = findViewById(R.id.RecyclerView_filename);
        RecyclerView_filename.setLayoutManager(new LinearLayoutManager(this));
        remarks = findViewById(R.id.remarks);
        border_line_while = findViewById(R.id.btn_login);
        lips_list.setVisibility(View.GONE);
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
    }

    private void initspinner(final String userid) {
        final CarAdapter adapter = new CarAdapter(this, mlist);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String message = jsonObject1.getString("message");
                    if (!message.equals("success")) {

                    } else {
                        Gson gson = new Gson();
                        Spinner_tool spinner_tool = gson.fromJson(s, Spinner_tool.class);
                        final List<Spinner_tool.DatasBean> datas = spinner_tool.getDatas();
                        if (mlist.size() == 0) {
                            mlist.add("常用语");
                            for (int i = 0; i < datas.size(); i++) {
                                mlist.add(datas.get(i).getCyy());
                            }
                            spinner_1.setAdapter(adapter);
                            spinner_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if (mlist.get(position).toString().equals("常用语")) {

                                    } else {
                                        if (xbyj_edit.getVisibility() == View.VISIBLE) {
                                            xbyj_edit.setText(mlist.get(position).toString());
                                            spinner_1.setSelection(0);
                                        } else if (lips_edit.getVisibility() == View.VISIBLE) {
                                            lips_edit.setText(mlist.get(position).toString());
                                            spinner_1.setSelection(0);
                                        } else if (db_edit.getVisibility() == View.VISIBLE) {
                                            db_edit.setText(mlist.get(position).toString());
                                            spinner_1.setSelection(0);
                                        } else if (ksyj_edit.getVisibility() == View.VISIBLE) {
                                            ksyj_edit.setText(mlist.get(position).toString());
                                            spinner_1.setSelection(0);
                                        }
                                        xbyj_String = mlist.get(position).toString();
                                        spinner_1.setSelection(0);
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                        } else {
                            mlist.clear();
                            initspinner(userid);
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
                Map map = new HashMap();
                map.put("userid", userid);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void dialogs(int i) {
        switch (i) {
            case 1:
                one();
                break;
            case 2:
                two();
                break;
            case 3:
                three();
                break;

        }
    }

    //科员
    private void three() {
        final ArrayList<new_String> arrayList = new ArrayList();
        keyuan = "";
        Gson gson = new Gson();
        try {
            JSONObject jsonObject1 = new JSONObject(eeee);
            String message = jsonObject1.getString("message");
            if (!message.equals("success")) {

            } else {
                gw_tool gw_tool = gson.fromJson(eeee, gw_tool.class);
                List<project01.shoujioa.gson_tool.gw_tool.MapBean.FindListBean> findList = gw_tool.getMap().getFindList();
                for (int i = 0; i < findList.size(); i++) {
                    new_String new_string = new new_String();
                    new_string.setString_id(findList.get(i).getId());
                    new_string.setString_name(findList.get(i).getName());
                    arrayList.add(new_string);
                }

                // 创建一个AlertDialog建造者
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                // 设置标题
                alertDialogBuilder.setTitle("科员");
                View view = View.inflate(this, R.layout.list_view, null);
                alertDialogBuilder.setView(view);
                ListView listView = view.findViewById(R.id.list_item);
                adepter = new adepter(this, arrayList, map2);
                listView.setAdapter(adepter);
                alertDialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        ArrayList<String> listid = new ArrayList<>();
                        for (String id : map2.keySet()) {
                            listid.add(id);
                            Log.e("id+++++", id);
                        }
                        keyuan = toStingName(listid);
                        ArrayList<String> listname3 = new ArrayList<>();
                        for (String name : map2.values()) {
                            listname3.add(name);
                            Log.e("name+++++", name);

                        }
                        String name = toStingName(listname3);
                        xzky_text.setText(name);
                    }
                });
                alertDialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        int visibility4 = zgks.getVisibility();//科室
                        int visibility5 = zgld.getVisibility();//领导
                        // TODO 业务逻辑代码
                        if (visibility4 == 8 && visibility5 == 8) {
                            zgks.setVisibility(View.GONE);
                            zgld.setVisibility(View.GONE);
                        } else {
                            append = "";
                            keyuan = "";
                        }

                    }
                });
                alertDialogBuilder.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //领导
    private void one() {

        final ArrayList<new_String> arrayList = new ArrayList();
        Gson gson = new Gson();
        try {
            JSONObject jsonObject1 = new JSONObject(eeee);
            String message = jsonObject1.getString("message");
            if (!message.equals("success")) {

            } else {
                gw_tool gw_tool = gson.fromJson(eeee, gw_tool.class);
                final List<project01.shoujioa.gson_tool.gw_tool.MapBean.LaderBean> lader = gw_tool.getMap().getLader();
                for (int i = 0; i < lader.size(); i++) {
                    new_String new_string = new new_String();
                    new_string.setString_id(lader.get(i).getId());
                    new_string.setString_name(lader.get(i).getName());
                    arrayList.add(new_string);
                }
                // 创建一个AlertDialog建造者
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                // 设置标题
                alertDialogBuilder.setTitle("主管领导");
                View view = View.inflate(this, R.layout.list_view, null);
                alertDialogBuilder.setView(view);
                ListView listView = view.findViewById(R.id.list_item);
                adepter = new adepter(this, arrayList, map);
                listView.setAdapter(adepter);
                alertDialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        ArrayList<String> listid = new ArrayList<>();
                        for (String id : map.keySet()) {
                            listid.add(id);
                            Log.e("id+++++", id);
                        }
                        lingdao = toStingName(listid);

                        ArrayList<String> listname = new ArrayList<>();
                        for (String name : map.values()) {
                            listname.add(name);
                            Log.e("name+++++", name);

                        }
                        String name = toStingName(listname);
                        if (TextUtils.isEmpty(name)) {
                            xzks_btn.setEnabled(true);
                            xzld_text.setText(name);
                        } else {
                            xzks_btn.setEnabled(false);
                            xzld_text.setText(name);
                        }
                    }
                });
                alertDialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO 业务逻辑代码
                        int visibility4 = zgks.getVisibility();//科室
                        if (visibility4 == 8) {
                            zgks.setVisibility(View.GONE);
                        } else {
                            lingdao = "";
                            append = "";
                            xzld_text.setText(append);
                            xzks_btn.setEnabled(true);
                        }
                    }
                });
                alertDialogBuilder.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public static String toStingName(List<String> list) {
        String s = "";
        for (int i = 0; i < list.size(); i++) {
            if (s == "") {
                s = list.get(i);
            } else {
                s = s + "," + list.get(i);
            }
        }
        return s;
    }

    //科室
    private void two() {

        Gson gson = new Gson();
        try {
            JSONObject jsonObject1 = new JSONObject(eeee);
            String message = jsonObject1.getString("message");
            if (!message.equals("success")) {

            } else {
                gw_tool gw_tool = gson.fromJson(eeee, gw_tool.class);
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
                adepter = new adepter(this, arrayList, map1);
                listView.setAdapter(adepter);

                alertDialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        ArrayList<String> listid2 = new ArrayList<>();
                        for (String id : map1.keySet()) {
                            listid2.add(id);
                            Log.e("id+++++", id);
                        }
                        kezhang = toStingName(listid2);

                        ArrayList<String> listname = new ArrayList<>();
                        for (String name : map1.values()) {
                            listname.add(name);
                            Log.e("name+++++", name);

                        }
                        String name = toStingName(listname);
                        if (TextUtils.isEmpty(name)) {
                            xzld_btn.setEnabled(true);
                            xzks_text.setText(name);
                        } else {
                            xzld_btn.setEnabled(false);
                            xzks_text.setText(name);
                        }


                    }
                });
                alertDialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        // TODO 业务逻辑代码
                        int visibility5 = zgld.getVisibility();//领导
                        if (visibility5 == 8) {
                            zgld.setVisibility(View.GONE);
                        } else {
                            append = "";
                            kezhang = "";
                            xzks_text.setText(append);
                            xzld_btn.setEnabled(true);
                        }

                    }
                });
                alertDialogBuilder.show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void initview() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                eeee = s;
                Gson gson = new Gson();
                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String message = jsonObject1.getString("message");
                    if (!message.equals("success")) {
                    } else {
                        gw_tool gw_tool = gson.fromJson(s, gw_tool.class);
                        project01.shoujioa.gson_tool.gw_tool.MapBean.WsjGongwenBean wsjGongwen = gw_tool.getMap().getWsjGongwen();
                        if (wsjGongwen.isIsNewRecord() == true) {

                        } else {
                            laiwendanwei.setText(wsjGongwen.getLaiwendanwei());
                            wenhao.setText(wsjGongwen.getWenhao());
                            name.setText(wsjGongwen.getName());
                            List<String> str = gw_tool.getMap().getStr();
                            if (str.size() != 0) {
                                Reprot_Adaper adaper = new Reprot_Adaper(gw_shengpi.this, str);
                                RecyclerView_filename.setAdapter(adaper);
                            }
                            remarks.setText(wsjGongwen.getRemarks());
                            gw_id = wsjGongwen.getId();
                            //协办意见
                            project01.shoujioa.gson_tool.gw_tool.MapBean.JulingdaoBean julingdao = gw_tool.getMap().getJulingdao();
                            //领导批示
                            List<project01.shoujioa.gson_tool.gw_tool.MapBean.ZhuguanlistBean> zhuguanlist = gw_tool.getMap().getZhuguanlist();
                            //督办
                            project01.shoujioa.gson_tool.gw_tool.MapBean.WenBean wen = gw_tool.getMap().getWen();
                            //科室办理
                            List<project01.shoujioa.gson_tool.gw_tool.MapBean.KeshilistBean> keshilist = gw_tool.getMap().getKeshilist();
                            //job
                            String job = gw_tool.getMap().getJob();
                            Log.i("TAG", wsjGongwen.getJindu().toString());
                            Log.i("TAG", julingdao.toString());
                            if (wsjGongwen.getJindu().equals("2")) {// 协办意见
                                xbyj_edit.setVisibility(View.VISIBLE);//协办意见 输入
                                xbyj_text.setVisibility(View.GONE);//协办 展示
                                lips_list.setVisibility(View.VISIBLE);//领导批示 展示
                                lips_edit.setVisibility(View.GONE);//领导批示 输入
                                ksyj_list.setVisibility(View.VISIBLE);//科室 展示
                                ksyj_edit.setVisibility(View.GONE);//科室 输入
                                db_text.setVisibility(View.VISIBLE);//督办 展示
                                db_edit.setVisibility(View.GONE);//督办 输入

                                zgld.setVisibility(View.VISIBLE);
                                zgks.setVisibility(View.GONE);
                                ky.setVisibility(View.GONE);
                                if (zhuguanlist.size() == 0) {//领导

                                } else {
                                    ArrayList<new_String> list = new ArrayList<>();
                                    for (int i = 0; i < zhuguanlist.size(); i++) {
                                        new_String new_string = new new_String();
                                        new_string.setString_name(zhuguanlist.get(i).getYijian());
                                        new_string.setString_tiem(zhuguanlist.get(i).getBanliriqi());
                                        new_string.setString_id(zhuguanlist.get(i).getId());
                                        new_string.setString_bid(zhuguanlist.get(i).getName());
                                        list.add(new_string);
                                    }
                                    lips_adepter = new lips_Adepter(gw_shengpi.this, list);
                                    lips_list.setLayoutManager(new LinearLayoutManager(gw_shengpi.this));
                                    lips_list.setAdapter(lips_adepter);
                                }
                                if (wen.isIsNewRecord() == true) {//督办
                                    db_text.setText("");
                                } else {
                                    db_text.setText(wen.getYijian());
                                }

                                if (keshilist.size() == 0) { //科室
                                } else {
                                    ArrayList<new_String> list = new ArrayList<>();
                                    for (int i = 0; i < keshilist.size(); i++) {
                                        new_String new_string = new new_String();
                                        new_string.setString_name(keshilist.get(i).getYijian());
                                        new_string.setString_tiem(keshilist.get(i).getBanliriqi());
                                        new_string.setString_id(keshilist.get(i).getId());
                                        new_string.setString_bid(keshilist.get(i).getName());
                                        list.add(new_string);
                                    }
                                    lips_adepter = new lips_Adepter(gw_shengpi.this, list);
                                    ksyj_list.setLayoutManager(new LinearLayoutManager(gw_shengpi.this));
                                    ksyj_list.setAdapter(lips_adepter);
                                }

                            } else if (wsjGongwen.getJindu().equals("3")) {//领导
                                zgks.setVisibility(View.GONE);
                                zgld.setVisibility(View.GONE);
                                ky.setVisibility(View.GONE);

                                xbyj_edit.setVisibility(View.GONE);//协办意见 输入
                                xbyj_text.setVisibility(View.VISIBLE);//协办 展示

                                lips_edit.setVisibility(View.VISIBLE);//领导批示 输入
                                lips_list.setVisibility(View.VISIBLE);//领导批示 展示

                                ksyj_list.setVisibility(View.VISIBLE);//科室 展示
                                ksyj_edit.setVisibility(View.GONE);//科室 输入

                                db_text.setVisibility(View.VISIBLE);//督办 展示
                                db_edit.setVisibility(View.GONE);//督办 输入
                                if (zhuguanlist.size() == 0) {//领导

                                } else {
                                    ArrayList<new_String> list = new ArrayList<>();
                                    for (int i = 0; i < zhuguanlist.size(); i++) {
                                        new_String new_string = new new_String();
                                        new_string.setString_name(zhuguanlist.get(i).getYijian());
                                        new_string.setString_tiem(zhuguanlist.get(i).getBanliriqi());
                                        new_string.setString_id(zhuguanlist.get(i).getId());
                                        new_string.setString_bid(zhuguanlist.get(i).getName());
                                        list.add(new_string);
                                    }
                                    lips_adepter = new lips_Adepter(gw_shengpi.this, list);
                                    lips_list.setLayoutManager(new LinearLayoutManager(gw_shengpi.this));
                                    lips_list.setAdapter(lips_adepter);
                                }
                                if(julingdao.equals("")){//协办

                                }else{
                                    ArrayList<new_String> listxb = new ArrayList<>();
                                    new_String new_stringxb = new new_String();
                                    new_stringxb.setString_name(julingdao.getYijian());
                                    new_stringxb.setString_tiem(julingdao.getBanliriqi());
                                    new_stringxb.setString_id(julingdao.getId());
                                    new_stringxb.setString_bid(julingdao.getName());
                                    listxb.add(new_stringxb);
                                    lips_adepter = new lips_Adepter(gw_shengpi.this, listxb);
                                    xbyj_text.setLayoutManager(new LinearLayoutManager(gw_shengpi.this));
                                    xbyj_text.setAdapter(lips_adepter);
                                }

                                if (wen.isIsNewRecord() == true) {//督办
                                    db_text.setText("");
                                } else {
                                    db_text.setText(wen.getYijian());
                                }

                                if (keshilist.size() == 0) { //科室
                                } else {
                                    ArrayList<new_String> list = new ArrayList<>();
                                    for (int i = 0; i < keshilist.size(); i++) {
                                        new_String new_string = new new_String();
                                        new_string.setString_name(keshilist.get(i).getYijian());
                                        new_string.setString_tiem(keshilist.get(i).getBanliriqi());
                                        new_string.setString_id(keshilist.get(i).getId());
                                        new_string.setString_bid(keshilist.get(i).getName());
                                        list.add(new_string);
                                    }
                                    lips_adepter = new lips_Adepter(gw_shengpi.this, list);
                                    ksyj_list.setLayoutManager(new LinearLayoutManager(gw_shengpi.this));
                                    ksyj_list.setAdapter(lips_adepter);
                                }


                            } else if (wsjGongwen.getJindu().equals("4")) {//督办
                                zgks.setVisibility(View.VISIBLE);
                                zgld.setVisibility(View.VISIBLE);
                                ky.setVisibility(View.GONE);
                                xbyj_edit.setVisibility(View.GONE);//协办意见 输入
                                xbyj_text.setVisibility(View.VISIBLE);//协办 展示
                                lips_list.setVisibility(View.VISIBLE);//领导批示 展示
                                lips_edit.setVisibility(View.GONE);//领导批示 输入
                                ksyj_list.setVisibility(View.VISIBLE);//科室 展示
                                ksyj_edit.setVisibility(View.GONE);//科室 输入
                                db_text.setVisibility(View.GONE);//督办 展示
                                db_edit.setVisibility(View.GONE);//督办 输入
                                if (wen.isIsNewRecord() == true) {//督办
                                    db_text.setText("");
                                } else {
                                    db_text.setText(wen.getYijian());
                                }
                                if (zhuguanlist.size() == 0) {//领导

                                } else {
                                    ArrayList<new_String> list = new ArrayList<>();
                                    for (int i = 0; i < zhuguanlist.size(); i++) {
                                        new_String new_string = new new_String();
                                        new_string.setString_name(zhuguanlist.get(i).getYijian());
                                        new_string.setString_tiem(zhuguanlist.get(i).getBanliriqi());
                                        new_string.setString_id(zhuguanlist.get(i).getId());
                                        new_string.setString_bid(zhuguanlist.get(i).getName());
                                        list.add(new_string);
                                    }
                                    lips_adepter = new lips_Adepter(gw_shengpi.this, list);
                                    lips_list.setLayoutManager(new LinearLayoutManager(gw_shengpi.this));
                                    lips_list.setAdapter(lips_adepter);
                                }
                                if(julingdao.equals("")){//协办

                                }else{
                                    ArrayList<new_String> listxb = new ArrayList<>();
                                    new_String new_stringxb = new new_String();
                                    new_stringxb.setString_name(julingdao.getYijian());
                                    new_stringxb.setString_tiem(julingdao.getBanliriqi());
                                    new_stringxb.setString_id(julingdao.getId());
                                    new_stringxb.setString_bid(julingdao.getName());
                                    listxb.add(new_stringxb);
                                    lips_adepter = new lips_Adepter(gw_shengpi.this, listxb);
                                    xbyj_text.setLayoutManager(new LinearLayoutManager(gw_shengpi.this));
                                    xbyj_text.setAdapter(lips_adepter);
                                }
                                if (keshilist.size() == 0) { //科室
                                } else {
                                    ArrayList<new_String> list = new ArrayList<>();
                                    for (int i = 0; i < keshilist.size(); i++) {
                                        new_String new_string = new new_String();
                                        new_string.setString_name(keshilist.get(i).getYijian());
                                        new_string.setString_tiem(keshilist.get(i).getBanliriqi());
                                        new_string.setString_id(keshilist.get(i).getId());
                                        new_string.setString_bid(keshilist.get(i).getName());
                                        list.add(new_string);
                                    }
                                    lips_adepter = new lips_Adepter(gw_shengpi.this, list);
                                    ksyj_list.setLayoutManager(new LinearLayoutManager(gw_shengpi.this));
                                    ksyj_list.setAdapter(lips_adepter);
                                }


                            } else if (wsjGongwen.getJindu().equals("5")) {//科室
                                xbyj_edit.setVisibility(View.GONE);//协办意见 输入
                                xbyj_text.setVisibility(View.VISIBLE);//协办 展示

                                lips_list.setVisibility(View.VISIBLE);//领导批示 展示
                                lips_edit.setVisibility(View.GONE);//领导批示 输入

                                ksyj_list.setVisibility(View.VISIBLE);//科室 展示
                                ksyj_edit.setVisibility(View.VISIBLE);//科室 输入
                                if (job.equals("1")) {
                                    zgks.setVisibility(View.VISIBLE);
                                    zgld.setVisibility(View.GONE);
                                    ky.setVisibility(View.VISIBLE);
                                } else if (job.equals("0")) {
                                    zgks.setVisibility(View.GONE);
                                    zgld.setVisibility(View.GONE);
                                    ky.setVisibility(View.GONE);
                                }
                                db_text.setVisibility(View.VISIBLE);//督办 展示
                                db_edit.setVisibility(View.GONE);//督办 输入
                                if(julingdao.equals("")){//协办
                                }else{
                                    ArrayList<new_String> listxb = new ArrayList<>();
                                    new_String new_stringxb = new new_String();
                                    new_stringxb.setString_name(julingdao.getYijian());
                                    new_stringxb.setString_tiem(julingdao.getBanliriqi());
                                    new_stringxb.setString_id(julingdao.getId());
                                    new_stringxb.setString_bid(julingdao.getName());
                                    listxb.add(new_stringxb);
                                    lips_adepter = new lips_Adepter(gw_shengpi.this, listxb);
                                    xbyj_text.setLayoutManager(new LinearLayoutManager(gw_shengpi.this));
                                    xbyj_text.setAdapter(lips_adepter);
                                }
                                if (keshilist.size() == 0) { //科室
                                } else {
                                    ArrayList<new_String> list = new ArrayList<>();
                                    for (int i = 0; i < keshilist.size(); i++) {
                                        new_String new_string = new new_String();
                                        new_string.setString_name(keshilist.get(i).getYijian());
                                        new_string.setString_tiem(keshilist.get(i).getBanliriqi());
                                        new_string.setString_id(keshilist.get(i).getId());
                                        new_string.setString_bid(keshilist.get(i).getName());
                                        list.add(new_string);
                                    }
                                    lips_adepter = new lips_Adepter(gw_shengpi.this, list);
                                    ksyj_list.setLayoutManager(new LinearLayoutManager(gw_shengpi.this));
                                    ksyj_list.setAdapter(lips_adepter);
                                }

                                if (zhuguanlist.size() == 0) {//领导

                                } else {
                                    ArrayList<new_String> list = new ArrayList<>();
                                    for (int i = 0; i < zhuguanlist.size(); i++) {

                                        new_String new_string = new new_String();
                                        new_string.setString_name(zhuguanlist.get(i).getYijian());
                                        new_string.setString_tiem(zhuguanlist.get(i).getBanliriqi());
                                        new_string.setString_id(zhuguanlist.get(i).getId());
                                        new_string.setString_bid(zhuguanlist.get(i).getName());
                                        list.add(new_string);
                                    }
                                    lips_adepter = new lips_Adepter(gw_shengpi.this, list);
                                    lips_list.setLayoutManager(new LinearLayoutManager(gw_shengpi.this));
                                    lips_list.setAdapter(lips_adepter);
                                }

                                if (wen.isIsNewRecord() == true) {//督办
                                    db_text.setText("");
                                } else {
                                    db_text.setText(wen.getYijian());
                                }
                            }
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                initPD();
                break;
            case R.id.btn_back:
                finish();
                break;
        }

    }

    private void initPD() {
        int visibility4 = zgks.getVisibility();//科室
        int visibility5 = zgld.getVisibility();//领导
        int visibility6 = ky.getVisibility();//科员  0 显示  8 隐藏
        if (visibility4 == 0 && visibility5 == 0 && visibility6 == 8) {
            if (xzks_text.getText().toString().equals("") && xzld_text.getText().toString().equals("")) {
                initcc();
            } else if (!xzks_text.getText().toString().equals("") && xzld_text.getText().toString().equals("")) {
                initcc();
            } else if (xzks_text.getText().toString().equals("") && !xzld_text.getText().toString().equals("")) {
                initcc();
            }
        } else if (visibility4 == 0 && visibility6 == 0 && visibility5 == 8) {
            if (xzks_text.getText().toString().equals("") && xzky_text.getText().toString().equals("")) {
                initcc();
            } else if (!xzks_text.getText().toString().equals("") && xzky_text.getText().toString().equals("")) {
                initcc();
            } else if (xzks_text.getText().toString().equals("") && !xzky_text.getText().toString().equals("")) {
                initcc();
            }else{
                initcc();
            }
        } else if (visibility5 == 0 && visibility4 == 8 && visibility6 == 8) {
            if (xzld_text.getText().equals("")) {
            } else {
                initcc();
            }
        } else if (visibility4 == 0 && visibility5 == 8 && visibility6 == 8) {
            if (xzks_text.getText().equals("")) {
            } else {
                initcc();
            }
        } else if (visibility6 == 0 && visibility4 == 8 && visibility5 == 8) {
            if (xzky_text.getText().equals("")) {
            } else {
                initcc();
            }
        } else if (visibility4 == 8 && visibility5 == 8 && visibility6 == 8) {
            initcc();
        }

    }

    private void initcc() {
        int visibility = xbyj_edit.getVisibility();
        int visibility1 = db_edit.getVisibility();
        int visibility2 = lips_edit.getVisibility();
        int visibility3 = ksyj_edit.getVisibility();
        if (visibility == 0) {
            xbyj_String = xbyj_edit.getText().toString().trim();
        } else if (visibility1 == 0) {
            xbyj_String = db_edit.getText().toString().trim();
        } else if (visibility2 == 0) {
            xbyj_String = lips_edit.getText().toString().trim();
        } else if (visibility3 == 0) {
            xbyj_String = ksyj_edit.getText().toString().trim();
        }
        keshi = keyuan +","+kezhang;
        Log.i("TAG", "拼接id+++++++" + keshi);
        StringRequest request = new StringRequest(Request.Method.POST, urlbc, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(gw_shengpi.this,volleyError.toString(),Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> map = new HashMap<>();
                map.put("userid", userid);
                map.put("id", gw_id);
                map.put("yijian", xbyj_String);
                map.put("lingdao", lingdao);
                map.put("kezhang", keshi);
                return map;
            }
        };
        requestQueue.add(request);
    }
}
