package project01.shoujioa.Fragment_main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import project01.shoujioa.Adepter_All.WSTJ_Adepter;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.day_btn_sign_in;
import project01.shoujioa.gson_tool.new_String;
import project01.shoujioa.new_ci_main_two;

public class day_btn_fragment extends Fragment{
    private View view;
    private RecyclerView recyclerView;
    private ArrayList<new_String> mlists=new ArrayList<>();
    private RequestQueue requestQueue;
    private String URL= HttpUtils.URL+"xwzxapp/app_xwqk?lx=卫生统计";
    private WSTJ_Adepter wstj_adepterextends;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=View.inflate(getContext(), R.layout.day_btn_main,null);
        requestQueue= Volley.newRequestQueue(getContext());
        initview();

        return view;
    }
    private void initview() {

        recyclerView=view.findViewById(R.id.new_recyclerview);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                String str=jsonObject.toString();
                Gson gson=new Gson();
                try {
                    JSONObject jsonObject1 = new JSONObject(str);
                    String message = jsonObject1.getString("message");
                    if(!message.equals("success")){

                    }else{
                        day_btn_sign_in day_btn_sign_in = gson.fromJson(str, day_btn_sign_in.class);
                        List<project01.shoujioa.gson_tool.day_btn_sign_in.DatasBean> datas = day_btn_sign_in.getDatas();
                        mlists.clear();
                        if(day_btn_sign_in.getStatuscode().equals("200")){
                            for(int i=0;i<datas.size();i++){
                                new_String new_string=new new_String();
                                new_string.setString_name(datas.get(i).getBt());
                                new_string.setString_tiem(datas.get(i).getCreateDate());
                                new_string.setString_id(datas.get(i).getId());
                                new_string.setZjh(datas.get(i).getLx());
                                mlists.add(new_string);
                            }
                            wstj_adepterextends=new WSTJ_Adepter(getContext(),mlists,"1");
                            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                            recyclerView.setAdapter(wstj_adepterextends);
                            wstj_adepterextends.setOnDeleteListener(new WSTJ_Adepter.OnDeleteListener() {
                                @Override
                                public void delete(String id) {
                                    Intent intent=new Intent(getContext(),new_ci_main_two.class);
                                    intent.putExtra("id",id);
                                    intent.putExtra("userid","");
                                    intent.putExtra("zhi","1");
                                    startActivity(intent);
                                }
                            });
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
        });
        requestQueue.add(jsonObjectRequest);
    }

}
