package project01.shoujioa.main_new_inten;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import java.util.List;
import java.util.Map;

import project01.shoujioa.Adepter_All.Reprot_Adaper;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.Filed_main_tool;

public class Filed_already_two extends AppCompatActivity {
    private String URL= HttpUtils.URL+"wjcdapp/app_toView";
    private TextView cjzdr_id,bt_id,lb_id,cc_id,fj_id;
    private String ids,userid;
    private SharedPreferences sp;
    private RequestQueue requestQueue;
    private TextView textView;
    private Button img_btn;
    private TextView department;
    private RecyclerView report_recylcer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filed_already_two);
        ids=getIntent().getStringExtra("id");
        sp = this.getSharedPreferences("abc", 0);
        userid= sp.getString("id", "");
        requestQueue= Volley.newRequestQueue(Filed_already_two.this);
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
                        List<String> str = filed_main_tool.getMap().getStr();

                        if (str.size()!=0){
                            Reprot_Adaper adaper =new Reprot_Adaper(Filed_already_two.this,str);
                            report_recylcer.setAdapter(adaper);
                        }
                        Filed_main_tool.MapBean.WsjNewfileBean wsjNewfile = filed_main_tool.getMap().getWsjNewfile();

                        cjzdr_id.setText(wsjNewfile.getName());
                      //  bt_id.setText(wsjNewfile.getHeadline());
                        lb_id.setText(wsjNewfile.getCreateDate());
                       // cc_id.setText(wsjNewfile.getChuchu());
                       // fj_id.setText(wsjNewfile.getUploadFiles());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(Filed_already_two.this, ""+volleyError.getMessage(), Toast.LENGTH_SHORT).show();
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
        bt_id=findViewById(R.id.bt_id);//接收人
        lb_id=findViewById(R.id.lb_id);
        cc_id=findViewById(R.id.cc_id);
        fj_id=findViewById(R.id.fj_id);
        department = findViewById(R.id.department);//所在部门
        View view1=findViewById(R.id.includeone);
        img_btn=view1.findViewById(R.id.img_btn);
        report_recylcer = findViewById(R.id.report_recylcer);//传递文件列表
        report_recylcer.setLayoutManager(new LinearLayoutManager(this));
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
