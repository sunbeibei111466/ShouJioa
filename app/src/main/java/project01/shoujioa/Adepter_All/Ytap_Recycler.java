package project01.shoujioa.Adepter_All;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.Ytap_tool;
import project01.shoujioa.gson_tool.new_String;

public class Ytap_Recycler extends RecyclerView.Adapter<Ytap_Recycler.My> {
    private List<new_String> mlist=new ArrayList<>();
    private Context context;
    private RequestQueue requestQueue;
    private String URL= HttpUtils.URL+"ytapapp/app_ytformlook";
    public Ytap_Recycler(List<new_String> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @NonNull
    @Override
    public My onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        My my=new My(LayoutInflater.from(context).inflate(R.layout.ytap_list
                ,null,false));
        return my;
    }

    @Override
    public void onBindViewHolder(@NonNull final My my, final int i) {
        requestQueue= Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();
                Ytap_tool ytap_tool = gson.fromJson(s, Ytap_tool.class);
                String ytmc = ytap_tool.getMap().getWsjHyyt().getYtmc();
                my.yt.setText(i+1+"、"+ytmc);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> map=new HashMap<>();
                map.put("id",mlist.get(i).getFlag());
                return map;
            }
        };
        requestQueue.add(stringRequest);

        my.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnDeleteListener.delete(mlist.get(i).getFlag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class My extends RecyclerView.ViewHolder {
        TextView yt;

        public My(@NonNull View itemView) {
            super(itemView);
            yt=itemView.findViewById(R.id.yt);

        }

    }

    public interface OnDeleteListener{
        void delete(String id);
    }
    //声明接口对象
    private OnDeleteListener mOnDeleteListener;

    //设置监听器,实例化接口
    public void setOnDeleteListener(OnDeleteListener onDeleteListener){
        mOnDeleteListener = onDeleteListener;
    }
}
