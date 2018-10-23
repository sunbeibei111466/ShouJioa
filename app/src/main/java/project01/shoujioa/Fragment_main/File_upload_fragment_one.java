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

import com.android.volley.AuthFailureError;
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

import project01.shoujioa.Adepter_All.File_upload_adepter;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.Interface.Filed_details;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.File_unload_tool;
import project01.shoujioa.gson_tool.new_String;

public class File_upload_fragment_one extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private String URL= HttpUtils.URL+"wjcdapp/app_wjcdxzlist";
    private SharedPreferences sp;
    private String userid;
    private SwipeRefreshLayout swipeRefreshLayout;
    private File_upload_adepter file_upload_adepter;
    private ArrayList<new_String> newStrings=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=View.inflate(getContext(), R.layout.file_upload_fragment_one,null);
        initview();
        initDate();
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
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                Gson gson=new Gson();
                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String message = jsonObject1.getString("message");
                    newStrings.clear();
                    if(!message.equals("success")){

                    }else{
                        File_unload_tool file_unload_tool = gson.fromJson(s, File_unload_tool.class);
                        List<File_unload_tool.DatasBean> datas =file_unload_tool.getDatas();
                        for(int i=0;i<datas.size();i++){
                            new_String new_string=new new_String();
                            new_string.setString_name(datas.get(i).getName());
                            new_string.setString_tiem(datas.get(i).getNameTime());
                            new_string.setString_id(datas.get(i).getId());
                            newStrings.add(new_string);
                         }
                         file_upload_adepter=new File_upload_adepter(getActivity(),newStrings);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(file_upload_adepter);
                        file_upload_adepter.setOnDeleteListener(new File_upload_adepter.OnDeleteListener() {
                            @Override
                            public void delete(String id) {
                                Intent intent=new Intent(getContext(),Filed_details.class);
                                intent.putExtra("id",id);
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
                Toast.makeText(getContext(), ""+volleyError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<>();
                map.put("userid",userid);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void initview() {
        requestQueue= Volley.newRequestQueue(getContext());
        recyclerView=view.findViewById(R.id.filename);
        sp = getContext().getSharedPreferences("abc", 0);
        userid = sp.getString("id", "");
        swipeRefreshLayout=view.findViewById(R.id.shr);
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            initDate();
            swipeRefreshLayout.setRefreshing(false);
        }
    };
}
