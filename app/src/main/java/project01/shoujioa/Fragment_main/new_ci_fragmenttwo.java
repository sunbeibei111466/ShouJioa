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

import project01.shoujioa.Adepter_All.noti_ci_two_adepter;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.new_String;
import project01.shoujioa.gson_tool.noti_Fragment_list_tool;
import project01.shoujioa.new_ci_main_two;

public class new_ci_fragmenttwo extends Fragment {
    private View view;
    private String URL= HttpUtils.URL+"xwzxapp/app_xwzxlist";
    private RequestQueue requestQueue;
    private RecyclerView recyclerView;
    private SharedPreferences sp;
    private String ids;
    private List<new_String> arraylist=new ArrayList<>();
    private noti_ci_two_adepter noti_ci_two_adepter;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=View.inflate(getContext(), R.layout.new_ci_maintwo,null);
        initview();
        handler.sendEmptyMessageDelayed(100,100);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(100,100);
            }
        });
        return view;
    }
    private void initDate() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();
                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String message = jsonObject1.getString("message");
                    arraylist.clear();
                    if(!message.equals("success")){

                    }else{
                        noti_Fragment_list_tool noti_fragment_list_tool = gson.fromJson(s, noti_Fragment_list_tool.class);
                        List<noti_Fragment_list_tool.DatasBean> datas = noti_fragment_list_tool.getDatas();
                        for(int i=0;i<datas.size();i++){
                            new_String new_string=new new_String();
                            new_string.setString_name(datas.get(i).getBt());
                            new_string.setString_id(datas.get(i).getId());
                            new_string.setZjh("2");
                            new_string.setString_tiem(datas.get(i).getCreateDate());

                            arraylist.add(new_string);
                        }
                        noti_ci_two_adepter=new noti_ci_two_adepter(getContext(),arraylist,"2");
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(noti_ci_two_adepter);
                        noti_ci_two_adepter.setOnDeleteListener(new noti_ci_two_adepter.OnDeleteListener() {
                            @Override
                            public void delete(String id) {
                                Intent intent=new Intent(getContext(),new_ci_main_two.class);
                                intent.putExtra("id",id);
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
                Toast.makeText(getContext(),""+volleyError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> map=new HashMap<>();
                map.put("userid",ids);
                return map;
            }
        }
                ;
        requestQueue.add(stringRequest);
    }

    private void initview() {
        requestQueue= Volley.newRequestQueue(getContext());
        recyclerView=view.findViewById(R.id.read_recyclerview);
        sp = getContext().getSharedPreferences("abc", 0);
        ids = sp.getString("id", "");
        swipeRefreshLayout=view.findViewById(R.id.shr);
        if(arraylist.size()==0){
            initDate();
        }else{
            arraylist.clear();
            initDate();
        }
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            initview();
            swipeRefreshLayout.setRefreshing(false);
        }
    };
}
