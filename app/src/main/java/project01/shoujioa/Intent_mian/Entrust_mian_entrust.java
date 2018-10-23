package project01.shoujioa.Intent_mian;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

import java.util.HashMap;
import java.util.Map;

import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.entrust_tool_entrust;

public class Entrust_mian_entrust extends AppCompatActivity {
    private String URL= HttpUtils.URL+"wtsqapp/app_form";
    private Button btn;
    private TextView textView;
    private RequestQueue requestQueue;
    private SharedPreferences sp;
    private String userid,id;
    private TextView wtr,bwtr,kssj,jssj;
    private RecyclerView report_recylcer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrust_mian_entrust);
        requestQueue= Volley.newRequestQueue(this);
        sp=this.getSharedPreferences("abc",0);
        userid=sp.getString("id","");
        id=getIntent().getStringExtra("id");
        initview();
        initdate();
    }

    private void initdate() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String message = jsonObject1.getString("message");
                    if(!message.equals("success")){
                    }else{
                        Gson gson=new Gson();
                        entrust_tool_entrust entrust_tool_entrust = gson.fromJson(s, entrust_tool_entrust.class);
                        project01.shoujioa.gson_tool.entrust_tool_entrust.MapBean.WsjWtsqBean wsjWtsq = entrust_tool_entrust.getMap().getWsjWtsq();
                        project01.shoujioa.gson_tool.entrust_tool_entrust.MapBean.WsjWtsqBean.UserBean user = wsjWtsq.getUser();
                        project01.shoujioa.gson_tool.entrust_tool_entrust.MapBean.WsjWtsqBean.User1Bean user1 = wsjWtsq.getUser1();
                        wtr.setText(user.getName());
                        bwtr.setText(user1.getName());
                        int i1 = wsjWtsq.getQishisj().indexOf(" ");
                        String time = wsjWtsq.getQishisj().substring(0, i1);
                        kssj.setText(time);
                        int i2 = wsjWtsq.getJieshusj().indexOf(" ");
                        String time2 = wsjWtsq.getJieshusj().substring(0, i2);
                        jssj.setText(time2);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<>();
                map.put("id",id);
                map.put("userid",userid);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void initview() {
        View view=findViewById(R.id.includeone);
        textView=view.findViewById(R.id.title_text);
        btn=view.findViewById(R.id.img_btn);
        textView.setText("委托详情");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        wtr=findViewById(R.id.wtr);
        bwtr=findViewById(R.id.bwtr);
        kssj=findViewById(R.id.kssj);
        jssj=findViewById(R.id.jssj);
        report_recylcer=findViewById(R.id.report_recylcer);
        report_recylcer.setLayoutManager(new LinearLayoutManager(this));
    }
}
