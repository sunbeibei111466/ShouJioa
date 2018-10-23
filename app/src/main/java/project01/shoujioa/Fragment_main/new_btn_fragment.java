package project01.shoujioa.Fragment_main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

import project01.shoujioa.Adepter_All.noti_ci_two_adepter;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.new_String;
import project01.shoujioa.gson_tool.new_btn_sign_in;
import project01.shoujioa.new_ci_main_two;

public class new_btn_fragment extends Fragment{
    private View  view;
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private ArrayList<new_String> mlists=new ArrayList<>();
    private String URL= HttpUtils.URL+"xwzxapp/app_xwqk?lx=新闻期刊";
    private noti_ci_two_adepter noti_ci_two_adepter;
    private SharedPreferences sp;
    private String ids;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=View.inflate(getContext(), R.layout.new_btn_main,null);
        requestQueue= Volley.newRequestQueue(getContext());
         initview();
         handler.sendEmptyMessageDelayed(100,100);
        return view;
    }

    private void initview() {
        sp = getContext().getSharedPreferences("abc", 0);
        ids = sp.getString("id", "");
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
                        mlists.clear();
                        new_btn_sign_in new_btn_sign_in = gson.fromJson(str, new_btn_sign_in.class);
                        if(new_btn_sign_in.getStatuscode().equals("200")){
                            List<project01.shoujioa.gson_tool.new_btn_sign_in.DatasBean> datas = new_btn_sign_in.getDatas();
                            for(int i=0;i<datas.size();i++){
                                new_String new_string=new new_String();
                                new_string.setString_name(new_btn_sign_in.getDatas().get(i).getBt());
                                new_string.setString_tiem(new_btn_sign_in.getDatas().get(i).getCreateDate());
                                new_string.setString_id(datas.get(i).getId());
                                new_string.setFlag(datas.get(i).getLx());
                                new_string.setZjh("1");
                                mlists.add(new_string);

                            }
                            noti_ci_two_adepter=new noti_ci_two_adepter(getContext(),mlists,"2");
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

                        }else{
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
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
}
