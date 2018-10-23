package project01.shoujioa.Intent_mian;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import project01.shoujioa.Adepter_All.Reprot_Adaper;
import project01.shoujioa.Adepter_All.adepter;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.XQTOOL_all.XFXQ_Tool;
import project01.shoujioa.XQ_adepter.XFXQ_adepter;
import project01.shoujioa.gson_tool.gw_tool;
import project01.shoujioa.gson_tool.new_String;

public class XF_db_xq extends AppCompatActivity implements View.OnClickListener {
    private RequestQueue requestQueue;
    private String userid, id,keyuan="", append="";
    private String URL = HttpUtils.URL + "xinfangapp/app_dbform";
    private String URL_BC=HttpUtils.URL+"xinfangapp/app_dbsave";
    private TextView name, xz, zbr, lxfs, fysj, nrzy, bz;
    private Button btn_login, img_btn,xzks_btn,xzky_btn,xzld_btn,bc;
    private TextView title_text,nbyj_TextView;
    private LinearLayout zgld, zgks, zgky;
    private EditText nbyj_edittext,ldps_edittext,ksblyi_edittext,xzks_text,xzky_text,xzld_text;
    private RecyclerView ksbl_recyclerview,ldps_recyclerview,nbnr_recyclerview,fj;
    private List<new_String> mlistld=new ArrayList<>();
    private List<new_String> mlistks=new ArrayList<>();
    private List<new_String> mlistnb=new ArrayList<>();
    private XFXQ_adepter xfxq_adepter;
    private adepter adepter;
    private   String xzString="",xzStringkz="",URLstring="",YJString="";
    private HashMap<String,String>map=new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xf_db_xq);
        requestQueue = Volley.newRequestQueue(XF_db_xq.this);
        userid = getIntent().getStringExtra("userid");
        id = getIntent().getStringExtra("id");

        initview();
        initdate();
    }

    private void initview() {
        name = findViewById(R.id.name);
        xz = findViewById(R.id.xz);
        zbr = findViewById(R.id.zbr);
        lxfs = findViewById(R.id.lxfs);
        fysj = findViewById(R.id.fysj);
        nrzy = findViewById(R.id.nrzy);
        bz = findViewById(R.id.bz);
        fj = findViewById(R.id.fj);
        zgld = findViewById(R.id.zgld);
        zgks = findViewById(R.id.zgkz);
        zgky = findViewById(R.id.zgky);
        zgld.setVisibility(View.GONE);
        zgks.setVisibility(View.GONE);
        zgky.setVisibility(View.GONE);

        nbyj_edittext=findViewById(R.id.nbyj_edittext);
        ldps_edittext=findViewById(R.id.ldps_edittext);
        ksblyi_edittext=findViewById(R.id.ksblyi_edittext);
        nbyj_edittext.setVisibility(View.GONE);
        ldps_edittext.setVisibility(View.GONE);
        ksblyi_edittext.setVisibility(View.GONE);
//        nbyj_TextView=findViewById(R.id.nbyj_TextView);
        ldps_recyclerview=findViewById(R.id.ldps_recyclerview);
        ksbl_recyclerview=findViewById(R.id.ksbl_recyclerview);
        nbnr_recyclerview=findViewById(R.id.nbnr_recyclerview);
        xzks_text=findViewById(R.id.xzks_text);
        xzks_btn=findViewById(R.id.xzks_btn);

        xzky_text = findViewById(R.id.xzky_text);
        xzky_btn = findViewById(R.id.xzky_btn);

        xzld_btn = findViewById(R.id.xzld_btn);
        xzld_text = findViewById(R.id.xzld_text);
        bc=findViewById(R.id.bc);

        xzks_btn.setOnClickListener(this);
        xzld_btn.setOnClickListener(this);
        xzky_btn.setOnClickListener(this);
        bc.setOnClickListener(this);

        View view = findViewById(R.id.includeone);
        img_btn = view.findViewById(R.id.img_btn);
        title_text = view.findViewById(R.id.title_text);
        title_text.setText("信访待办详情");
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initdate() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                URLstring=s;
                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String statuscode = jsonObject1.getString("statuscode");
                    if (statuscode.equals("200")) {
                        Gson gson = new Gson();
                        XFXQ_Tool xfxq_tool = gson.fromJson(s, XFXQ_Tool.class);
                        XFXQ_Tool.MapBean.WsjXinfangBean wsjXinfang = xfxq_tool.getMap().getWsjXinfang();
                        name.setText(wsjXinfang.getName());
                        xz.setText(wsjXinfang.getXingzhi());
                        zbr.setText(wsjXinfang.getZhuanbr());
                        lxfs.setText(wsjXinfang.getLxfsjidz());
                        fysj.setText(wsjXinfang.getFysjjifs());
                        nrzy.setText(wsjXinfang.getNeirong());
                        bz.setText(wsjXinfang.getBeizu());
                        List<String> str = xfxq_tool.getMap().getStr();
                        if(str.size()!=0){
                            Reprot_Adaper reprot_adaper=new Reprot_Adaper(getApplicationContext(),str);
                            fj.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            fj.setAdapter(reprot_adaper);
                        }
                        if (wsjXinfang.getJindu().equals("2")) {
                            zgld.setVisibility(View.VISIBLE);
                            zgks.setVisibility(View.GONE);
                            zgky.setVisibility(View.GONE);//转给主管领导
                        }else if(wsjXinfang.getJindu().equals("3")){
                            zgld.setVisibility(View.GONE);
                            zgks.setVisibility(View.GONE);
                            zgky.setVisibility(View.GONE);
                        }
                        else if (wsjXinfang.getJindu().equals("4")) {
                            zgld.setVisibility(View.GONE);
                            zgks.setVisibility(View.VISIBLE);
                            zgky.setVisibility(View.GONE);
                        } else if (wsjXinfang.getJindu().equals("5")) {
                            zgld.setVisibility(View.GONE);
                            zgks.setVisibility(View.GONE);
                            zgky.setVisibility(View.VISIBLE);
                        }
                        //拟办意见
                        XFXQ_Tool.MapBean.JulingdaoBean julingdao = xfxq_tool.getMap().getJulingdao();
                        if(julingdao.isIsNewRecord()==false){
                            if(julingdao.getDaiban().equals("0")){
                                nbyj_edittext.setVisibility(View.GONE);
                                nbnr_recyclerview.setVisibility(View.VISIBLE);

                            }else{
                                nbyj_edittext.setVisibility(View.VISIBLE);
                                nbnr_recyclerview.setVisibility(View.GONE);
                            }
                                new_String new_string=new new_String();
                                new_string.setString_name(julingdao.getYijian());
                                new_string.setString_tiem(julingdao.getBanliriqi());
                                mlistnb.add(new_string);
                            xfxq_adepter=new XFXQ_adepter(XF_db_xq.this,mlistnb);
                            nbnr_recyclerview.setLayoutManager(new LinearLayoutManager(XF_db_xq.this));
                            nbnr_recyclerview.setAdapter(xfxq_adepter);
                        }else{}
                        //领导批示
                        List<XFXQ_Tool.MapBean.ZhuguanlistBean> zhuguanlist = xfxq_tool.getMap().getZhuguanlist();
                        if(zhuguanlist.size()!=0){
                            for(int i=0;i<zhuguanlist.size();i++){
                                if(zhuguanlist.get(i).getDaiban().equals("0")){
                                    ldps_recyclerview.setVisibility(View.VISIBLE);
                                    ldps_edittext.setVisibility(View.GONE);
                                }else if(zhuguanlist.get(i).getDaiban().equals("1")){
                                    ldps_recyclerview.setVisibility(View.GONE);
                                    ldps_edittext.setVisibility(View.VISIBLE);
                                }
                                    new_String new_string=new new_String();
                                    new_string.setString_name(zhuguanlist.get(i).getYijian());
                                    new_string.setString_tiem(zhuguanlist.get(i).getBanliriqi());
                                    mlistld.add(new_string);
                            }
                            xfxq_adepter=new XFXQ_adepter(XF_db_xq.this,mlistld);
                            ldps_recyclerview.setLayoutManager(new LinearLayoutManager(XF_db_xq.this));
                            ldps_recyclerview.setAdapter(xfxq_adepter);
                        }else{}
                        //科室办理意见
                        List<XFXQ_Tool.MapBean.KeshilistBean> keshilist = xfxq_tool.getMap().getKeshilist();
                        if(keshilist.size()!=0){
                            for(int i=0;i<keshilist.size();i++){
                                if(keshilist.get(i).getDaiban().equals("0")){
                                    ksbl_recyclerview.setVisibility(View.VISIBLE);
                                    ksblyi_edittext.setVisibility(View.GONE);
                                }else if(keshilist.get(i).getDaiban().equals("1")){
                                    ksbl_recyclerview.setVisibility(View.GONE);
                                    ksblyi_edittext.setVisibility(View.VISIBLE);
                                }
                                new_String new_string=new new_String();
                                new_string.setString_name(keshilist.get(i).getYijian());
                                new_string.setString_tiem(keshilist.get(i).getQibanriqi());
                                mlistks.add(new_string);
                            }
                            xfxq_adepter=new XFXQ_adepter(XF_db_xq.this,mlistks);
                            ksbl_recyclerview.setLayoutManager(new LinearLayoutManager(XF_db_xq.this));
                            ksbl_recyclerview.setAdapter(xfxq_adepter);
                        }
                    } else {
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
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.xzld_btn:
                one();
                break;
            case R.id.xzks_btn:
                two();
                break;
            case R.id.xzky_btn:
                three();
                break;
            case R.id.bc:
                PDinit();
                break;
        }
    }

    private void PDinit() {
        int visibility = zgld.getVisibility();
        int visibility1 = zgky.getVisibility();
        int visibility2 = zgks.getVisibility();
        if(visibility==0){
            if(!xzld_text.getText().toString().equals("")){
                xzString=xzld_text.getText().toString().trim();
                initcc();
            }
        }else if(visibility1==0){
            if(!xzky_text.getText().toString().equals("")){
                xzString=xzky_text.getText().toString().trim();
                initcc();
            }

        }else if(visibility2==0){
            if(!xzks_text.getText().toString().equals("")){
                xzString=xzks_text.getText().toString().trim();
                initcc();
            }
        }
    }

    private void one() {

        final ArrayList<new_String> arrayList = new ArrayList();
        xzString = "";
        Gson gson = new Gson();
        try {
            JSONObject jsonObject1 = new JSONObject(URLstring);
            String statuscode = jsonObject1.getString("statuscode");
            if (!statuscode.equals("200")) {

            } else {
                gw_tool gw_tool = gson.fromJson(URLstring, gw_tool.class);
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
                adepter = new adepter(this, arrayList,map);
                listView.setAdapter(adepter);

                alertDialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        ArrayList<String>listid=new ArrayList<>();
                        for (String id:map.keySet()){
                            listid.add(id);
                            Log.e("id+++++",id);
                        }
                        xzString = toStingName(listid);
                        ArrayList<String>listname=new ArrayList<>();
                        for (String name:map.values()){
                            listname.add(name);
                            Log.e("name+++++",name);

                        }
                        String name = toStingName(listname);
                        if (TextUtils.isEmpty(name)){
                            xzld_text.setText(name);
                        }else{
                            xzld_text.setText(name);
                        }

                    }
                });
                alertDialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO 业务逻辑代码
                        xzString="";
                        append="";
                        xzld_text.setText(append);

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
                adepter = new adepter(this, arrayList,map);
                listView.setAdapter(adepter);
                alertDialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        ArrayList<String>listid=new ArrayList<>();
                        for (String id:map.keySet()){
                            listid.add(id);
                        }
                        xzString = toStingName(listid);
                        ArrayList<String>listname=new ArrayList<>();
                        for (String name:map.values()){
                            listname.add(name);

                        }
                        String name = toStingName(listname);
                        if (TextUtils.isEmpty(name)){
                            xzks_text.setText(name);
                        }else{
                            xzks_text.setText(name);
                        }
                    }
                });
                alertDialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO 业务逻辑代码
                        append="";
                        xzString="";
                        xzks_text.setText(append);

                    }
                });
                alertDialogBuilder.show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    private void three() {
        final ArrayList<new_String> arrayList = new ArrayList();
        xzString = "";
        Gson gson = new Gson();
        try {
            JSONObject jsonObject1 = new JSONObject(URLstring);
            String message = jsonObject1.getString("message");
            if (!message.equals("success")) {

            } else {
                gw_tool gw_tool = gson.fromJson(URLstring, gw_tool.class);
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
                adepter = new adepter(this, arrayList,map);
                listView.setAdapter(adepter);


                alertDialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        ArrayList<String>listid=new ArrayList<>();
                        for (String id:map.keySet()){
                            listid.add(id);
                        }
                        xzString = toStingName(listid);
                        ArrayList<String>listname=new ArrayList<>();
                        for (String name:map.values()){
                            listname.add(name);

                        }
                        String name = toStingName(listname);
                        if (TextUtils.isEmpty(name)){
                            xzky_text.setText(name);
                        }else{
                            xzky_text.setText(name);
                        }
                    }
                });
                alertDialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO 业务逻辑代码
                        append="";
                        xzString="";
                        xzky_text.setText(append);
                    }
                });
                alertDialogBuilder.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void initcc() {
        StringRequest request = new StringRequest(Request.Method.POST, URL_BC, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> map = new HashMap<>();
                map.put("id", id);
                map.put("userid", userid);
                map.put("yijian", YJString);
                map.put("kezhang", xzString);
                return map;
            }
        };
        requestQueue.add(request);
    }
}
