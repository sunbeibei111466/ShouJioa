package project01.shoujioa.Adepter_All;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.Utils.FileDisplayActivity;
import project01.shoujioa.gson_tool.YL_tool;
import pub.devrel.easypermissions.EasyPermissions;

public class Reprot_Adaper extends RecyclerView.Adapter<Reprot_Adaper.MyReport_ViewHolder> {
    private Context context;
    private List<String> str;
    public Reprot_Adaper(Context context,List<String>str) {
        this.context=context;
        this.str=str;
    }

    @NonNull
    @Override
    public MyReport_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.str_item,viewGroup,false);
        MyReport_ViewHolder viewHolder =new MyReport_ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyReport_ViewHolder myReport_viewHolder, int i) {
        myReport_viewHolder.file_str.setText(str.get(i).toString());
        myReport_viewHolder.preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String URL= HttpUtils.URL+"gwglapp/app_showWord";
                RequestQueue requestQueue = Volley.newRequestQueue(context);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson =new Gson();
                        YL_tool yl_tool = gson.fromJson(s, YL_tool.class);
                        String ctxPath = yl_tool.getMap().getCtxPath();
                        Log.e("TAG",ctxPath);
                        String[] perms = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE};

                        if (!EasyPermissions.hasPermissions(context, perms)) {
                            EasyPermissions.requestPermissions((Activity) context, "需要访问手机存储权限！", 10086, perms);
                        } else {

//                            FileDisplayActivity.show(context, "http://zxcp.chinadqh.com:8010/UploadFile/20180913/095903-TestPPT.ppt");
                            FileDisplayActivity.show(context, HttpUtils.URL_fj+ctxPath);
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(context, "" + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> map = new HashMap<>();
                        map.put("fullFileName", str.get(i));
                        return map;
                    }
                };
                requestQueue.add(stringRequest);
            }

        });


    }

    @Override
    public int getItemCount() {
        return str.size();
    }
    public class MyReport_ViewHolder extends RecyclerView.ViewHolder{
        public  TextView file_str;
        public Button preview;

        public MyReport_ViewHolder(@NonNull View itemView) {
            super(itemView);
            file_str=itemView.findViewById(R.id.file_str);//文件名字
            preview =itemView.findViewById(R.id.preview);//预览
        }
    }

}