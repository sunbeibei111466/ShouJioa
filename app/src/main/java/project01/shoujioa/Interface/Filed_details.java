package project01.shoujioa.Interface;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.Filed_main_tool;

public class Filed_details extends AppCompatActivity {
    private String URL= HttpUtils.URL+"wjcdapp/app_toView";
    private TextView cjzdr_id,bt_id,lb_id,cc_id,fj_id;
    private Button btn_fh;
    private String ids,userid;
    private SharedPreferences sp;
    private RequestQueue requestQueue;
    private TextView textView;
    private Button img_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filed_details);
        ids=getIntent().getStringExtra("id");
        sp = this.getSharedPreferences("abc", 0);
        userid= sp.getString("id", "");
        requestQueue= Volley.newRequestQueue(Filed_details.this);
        initview();
        initDate();
    }

    private void initDate() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();
                try {
                    JSONObject jsonObject1=new JSONObject(s);
                    String message = jsonObject1.getString("message");
                    if(!message.equals("success")){
                    }else{
                        Filed_main_tool filed_main_tool = gson.fromJson(s, Filed_main_tool.class);
                        Filed_main_tool.MapBean.WsjNewfileBean wsjNewfile = filed_main_tool.getMap().getWsjNewfile();
                        cjzdr_id.setText(wsjNewfile.getName());
                        bt_id.setText(wsjNewfile.getHeadline());
                        lb_id.setText(wsjNewfile.getCreateDate());
                        cc_id.setText("");
                        fj_id.setText(wsjNewfile.getUploadFiles());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(Filed_details.this, ""+volleyError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> map=new HashMap<>();
                map.put("id",ids);
                map.put("userid",userid);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void initview() {

        cjzdr_id=findViewById(R.id.cjzdr_id);
        bt_id=findViewById(R.id.bt_id);
        lb_id=findViewById(R.id.lb_id);
        cc_id=findViewById(R.id.cc_id);
        fj_id=findViewById(R.id.fj_id);
        btn_fh=findViewById(R.id.btn_fh);
        btn_fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        View view1=findViewById(R.id.includeone);
        img_btn=view1.findViewById(R.id.img_btn);
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        textView=view1.findViewById(R.id.title_text);
        textView.setText("详情");
    }
}
