package project01.shoujioa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
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
import project01.shoujioa.gson_tool.XW_tool;
import project01.shoujioa.gson_tool.new_ci_main_two_tool;

public class new_ci_main_two extends AppCompatActivity {
    private String URL_xw=HttpUtils.URL+"xwzxapp/app_formlook";
    private String URL_tz=HttpUtils.URL+"tzggapp/app_formlook";
    private String id,userid;
    private RequestQueue requestQueue;
    private Button btn_login;
    private TextView textView;
    private Button img_btn;
    private TextView tv_bt_id,editText,xzks_text,edid_id,cs;
    private String zhi;
    private RecyclerView RecyclerView_filename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ci_main_two);
        zhi=getIntent().getStringExtra("zhi");
        initview();
    }

    private void initview() {
        id=getIntent().getStringExtra("id");
        userid=getIntent().getStringExtra("userid");
        requestQueue= Volley.newRequestQueue(new_ci_main_two.this);
        btn_login=findViewById(R.id.btn_login);
        tv_bt_id=findViewById(R.id.tv_bt_id);
        edid_id=findViewById(R.id.edid_id);
        editText=findViewById(R.id.editText);
        xzks_text=findViewById(R.id.xzks_text);
        RecyclerView_filename=findViewById(R.id.RecyclerView_filename);
        RecyclerView_filename.setLayoutManager(new LinearLayoutManager(this));
        btn_login.setOnClickListener(new View.OnClickListener() {
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
        cs=findViewById(R.id.cs);
        if(zhi.equals("1")){
            textView.setText("卫生详情");
        }else if(zhi.equals("2")){
            textView.setText("新闻详情");
            initDate(URL_xw,"1");
        }else if(zhi.equals("3")){
            textView.setText("通知公告详情");
            initDate(URL_tz,"2");
        }
    }
    private void initDate(String URL,final String fg) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();
                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String message = jsonObject1.getString("message");
                    if(!message.equals("success")){
                    }else{
                        if(fg.equals("1")){
                            XW_tool xw_tool = gson.fromJson(s, XW_tool.class);
                            XW_tool.MapBean.WsjXwzxBean wsjXwzx = xw_tool.getMap().getWsjXwzx();
                            tv_bt_id.setText(wsjXwzx.getBt());
                            edid_id.setMovementMethod(ScrollingMovementMethod.getInstance());// 设置可滚动
                            edid_id.setMovementMethod(LinkMovementMethod.getInstance());//设置超链接可以打开网页
                            edid_id.setText(Html.fromHtml(wsjXwzx.getXwnr(), null, null));
                            editText.setText(wsjXwzx.getFbr());
                            xzks_text.setText(wsjXwzx.getBack4());
                            List<String> str = xw_tool.getMap().getStr();
                            if(str.size()!=0){
                                Reprot_Adaper adaper =new Reprot_Adaper(getApplicationContext(),str);
                                RecyclerView_filename.setAdapter(adaper);
                            }
                        }else if(fg.equals("2")){
                            new_ci_main_two_tool new_ci_main_two_tool = gson.fromJson(s, new_ci_main_two_tool.class);
                            project01.shoujioa.gson_tool.new_ci_main_two_tool.MapBean.WsjGgglBean wsjGggl = new_ci_main_two_tool.getMap().getWsjGggl();
                            tv_bt_id.setText(wsjGggl.getBt());
                            edid_id.setMovementMethod(ScrollingMovementMethod.getInstance());// 设置可滚动
                            edid_id.setMovementMethod(LinkMovementMethod.getInstance());//设置超链接可以打开网页
                            edid_id.setText(Html.fromHtml(wsjGggl.getGgnr(), null, null));
                            editText.setText(wsjGggl.getFbr());
                            xzks_text.setText(wsjGggl.getGsbm());
                            List<String> str = new_ci_main_two_tool.getMap().getStr();
                            if(str.size()!=0){
                                Reprot_Adaper adaper =new Reprot_Adaper(getApplicationContext(),str);
                                RecyclerView_filename.setAdapter(adaper);
                            }
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(new_ci_main_two.this, ""+volleyError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String ,String> map=new HashMap<>();

                map.put("id",id);
                return map;
            }
        }
        ;
        requestQueue.add(stringRequest);
    }

}
