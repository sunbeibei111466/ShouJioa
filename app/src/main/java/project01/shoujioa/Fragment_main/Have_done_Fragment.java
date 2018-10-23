package project01.shoujioa.Fragment_main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

import project01.shoujioa.Adepter_All.adepter_zh_xz;
import project01.shoujioa.Adepter_All.have_recyclerview_adepter;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.new_String;
import project01.shoujioa.main_new_inten.Review_details;

public class Have_done_Fragment extends Fragment {
    private View view;
    private RecyclerView hava_recyclerview;
    private have_recyclerview_adepter have_recyclerview_adepter;
    private ArrayList<new_String> arrayList=new ArrayList<>();
    private RequestQueue requestQueue;
    private String URL= HttpUtils.URL+"gwglapp/app_gwglyblist";
    private String URLGZ=HttpUtils.URL+"gwglapp/app_gzform";
    private String URLZH_XZ=HttpUtils.URL+"gwglapp/app_zh";
    private String UTLZH_BC=HttpUtils.URL+"gwglapp/app_zhsave";
    private SharedPreferences sp;
    private String ids=null;
    private String  gw_id=null;
    private String zh_xz_id=null;
    private adepter_zh_xz adepter;
    final StringBuilder stringBuilderone = new StringBuilder();
    private SwipeRefreshLayout swipeRefreshLayout;
    private boolean aBoolean=true;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=View.inflate(getContext(), R.layout.have_done_fragment_main,null);
        requestQueue= Volley.newRequestQueue(getContext());
        sp = getContext().getSharedPreferences("abc", 0);
        //用户id
        ids = sp.getString("id", "");
        initlist();
        handler.sendEmptyMessageDelayed(100,100);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(100,100);
            }
        });
        return view;
    }

    private void initlist() {
        hava_recyclerview=view.findViewById(R.id.hava_recyclerview);
        swipeRefreshLayout=view.findViewById(R.id.srh);
        if(arrayList.size()==0){
            initview();
        }else{
            arrayList.clear();
            have_recyclerview_adepter.notifyDataSetChanged();
            initview();
        }
    }

    private void initview() {

        StringRequest jsonObjectRequest=new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String jsonObject) {
                Gson gson=new Gson();
                try {
                    JSONObject jsonObject1 = new JSONObject(jsonObject);
                    String message = jsonObject1.getString("message");
                    if(!message.equals("success")){

                    }else{
                        read_toll agency_toll = gson.fromJson(jsonObject,read_toll.class);
                        List<read_toll.DatasBean> datas = agency_toll.getDatas();
                        arrayList.clear();
                        for(int i=0;i<datas.size();i++){
                            new_String new_string=new new_String();
                            new_string.setString_name(datas.get(i).getName());
                            new_string.setString_tiem(datas.get(i).getCreateDate());
                            new_string.setString_id(datas.get(i).getId());
                            new_string.setString_bid(datas.get(i).getGuanzhu());
                            new_string.setString_gl(datas.get(i).getGuanlian());
                            arrayList.add(new_string);
                        }
                        have_recyclerview_adepter=new have_recyclerview_adepter(getContext(),arrayList);
                        hava_recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
                        hava_recyclerview.setAdapter(have_recyclerview_adepter);
                        have_recyclerview_adepter.setOnDeleteListener(new have_recyclerview_adepter.OnDeleteListener() {
                            @Override
                            public void delete(String id,String gw_ids,String gl) {
//                                if(id.equals("2")){
//                                    gw_id=gw_ids;
//                                    initzh_xz();
//                                }else if(id.equals("1")){
//                                    gw_id=gw_ids;
//                                    initgz(gw_ids,gl);
//                                    }
                                    //     initlist();
                                gw_id=gw_ids;
                                Intent intent=new Intent(getContext(),Review_details.class);
                                intent.putExtra("id",gw_id);
                                intent.putExtra("userid",ids);
                                intent.putExtra("zhi","2");
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
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String ,String> map=new HashMap<>();
                map.put("userid",ids);
                map.put("name","");
                return map;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }

//    private void initzh_xz() {
//    StringRequest stringRequest=new StringRequest(Request.Method.POST,URLZH_XZ, new Response.Listener<String>() {
//        @Override
//        public void onResponse(String s) {
//            ArrayList<new_String> arrayList = new ArrayList();
//            final Gson gson = new Gson();
//            zh_xz_tool zh_xz_tool = gson.fromJson(s, zh_xz_tool.class);
//            List<project01.shoujioa.gson_tool.zh_xz_tool.MapBean.MinladerBean> minlader = zh_xz_tool.getMap().getMinlader();
//            for(int i=0;i<minlader.size();i++){
//                new_String new_string = new new_String();
//                new_string.setString_id(minlader.get(i).getId());
//                new_string.setString_name(minlader.get(i).getUser().getName());
//                new_string.setString_id(minlader.get(i).getId());
//                arrayList.add(new_string);
//            }
//            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
//            alertDialogBuilder.setTitle("主管领导");
//            View view = View.inflate(getContext(), R.layout.list_view, null);
//            alertDialogBuilder.setView(view);
//            ListView listView = view.findViewById(R.id.list_item);
//            adepter = new adepter_zh_xz(getContext(), arrayList);
//            listView.setAdapter(adepter);
//            adepter.setOnDeleteListener(new adepter_zh_xz.OnDeleteListener() {
//                @Override
//                public void delete(String position) {
//                    stringBuilderone.append(position+",");
//                    zh_xz_id=stringBuilderone.toString();
//                }
//            });
//            alertDialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//
//                @Override
//                public void onClick(DialogInterface arg0, int arg1) {
//                    //TODO 业务逻辑代码
//                    initzh_bc(gw_id,zh_xz_id);
//                }
//            });
//            alertDialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//
//                @Override
//                public void onClick(DialogInterface arg0, int arg1) {
//                    // TODO 业务逻辑代码
//                }
//            });
//            alertDialogBuilder.show();
//        }
//    }, new Response.ErrorListener() {
//        @Override
//        public void onErrorResponse(VolleyError volleyError) {
//
//        }
//    }){
//        @Override
//            protected Map<String, String> getParams(){
//                Map<String ,String> map=new HashMap<>();
//                map.put("userid",ids);
//                map.put("id",gw_id);
//                return map;
//        }
//    };
//        requestQueue.add(stringRequest);
//    }

//    private void initzh_bc(final String gw_id,final String zh_xz_id) {
//        StringRequest stringRequest=new StringRequest(Request.Method.POST, UTLZH_BC, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String s) {
//                initlist();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                Toast.makeText(getContext(), ""+volleyError.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        })
//        {
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String,String> map=new HashMap<>();
//                map.put("zhihui",zh_xz_id);
//                map.put("id",gw_id);
//                return map;
//            }
//        }
//        ;
//        requestQueue.add(stringRequest);
//    }
//
//    private void initgz(final String gw_ids,final String gl) {
//        StringRequest stringRequest=new StringRequest(Request.Method.POST, URLGZ, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String s) {
//                handler.sendEmptyMessageDelayed(10,10);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                Toast.makeText(getContext(), ""+volleyError.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        })
//        {
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String,String> map=new HashMap<>();
//                map.put("id",gw_ids);
//                map.put("userid",ids);
//                map.put("guanlian",gl);
//                return map;
//            }
//
//        }
//        ;
//        requestQueue.add(stringRequest);
//    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            initlist();
            swipeRefreshLayout.setRefreshing(false);
            aBoolean=false;
        }
    };
}
