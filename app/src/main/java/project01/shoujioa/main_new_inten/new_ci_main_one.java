package project01.shoujioa.main_new_inten;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
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
import project01.shoujioa.gson_tool.new_ci_main_two_tool;

public class new_ci_main_one extends AppCompatActivity {
    private Button btn_fh,btn_login;
    private String URL= HttpUtils.URL+"xwzxapp/app_form2";
    private String URL_FB= HttpUtils.URL+"xwzxapp/app_xwzxfb";
    private RequestQueue requestQueue;
    private  String id ,lx,ids;
    private RadioButton rbone,rbtwo;
    private TextView tv_bt_id,editText,xzks_text,filename,edid_id;
    private TextView textView;
    private Button img_btn,xzld_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ci_main_one);
        id = getIntent().getStringExtra("id");
        initview();
        initDate();
    }
    private void initDate() {
        final StringRequest stringRequest=new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson=new Gson();
                        try {
                            JSONObject jsonObject1 = new JSONObject(s);
                            String message = jsonObject1.getString("message");
                            if(!message.equals("success")){

                            }else{
                                new_ci_main_two_tool new_ci_main_two_tool = gson.fromJson(s, new_ci_main_two_tool.class);
                                project01.shoujioa.gson_tool.new_ci_main_two_tool.MapBean.WsjGgglBean wsjGggl = new_ci_main_two_tool.getMap().getWsjGggl();
                                Log.e("TAG",wsjGggl.getLx());
                                if(wsjGggl.getLx().equals("新闻期刊")){
                                    rbone.setChecked(true);
                                    rbtwo.setChecked(false);
                                }else if(wsjGggl.getLx().equals("卫生统计")){
                                    rbtwo.setChecked(true);
                                    rbone.setChecked(false);
                                }else if(wsjGggl.getLx().equals("")){
                                    rbone.setChecked(false);
                                    rbtwo.setChecked(false);
                                }
                                tv_bt_id.setText(wsjGggl.getBt());
                                edid_id.setMovementMethod(ScrollingMovementMethod.getInstance());// 设置可滚动
                                edid_id.setMovementMethod(LinkMovementMethod.getInstance());//设置超链接可以打开网页
                                edid_id.setText(Html.fromHtml(wsjGggl.getGgnr(), null, null));
                                if(wsjGggl.getUser()==null){
                                   editText.setText("");
                                }else{
                                    editText.setText(wsjGggl.getUser().getName());
                                }
                                ids=wsjGggl.getId();
                                xzks_text.setText(wsjGggl.getFbr());
                                filename.setText(wsjGggl.getScfile());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(new_ci_main_one.this, ""+volleyError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String> map=new HashMap<>();
                map.put("id",id);
                return map;
            }
        }
                ;
        requestQueue.add(stringRequest);
    }

    private void initview() {
        requestQueue= Volley.newRequestQueue(this);
        btn_fh=findViewById(R.id.btn_fh);
        btn_login=findViewById(R.id.btn_login);
        rbone=findViewById(R.id.rbone);
        rbtwo=findViewById(R.id.rbtwo);
        tv_bt_id=findViewById(R.id.tv_bt_id);
        edid_id=findViewById(R.id.edid_id);
        editText=findViewById(R.id.editText);
        xzks_text=findViewById(R.id.xzks_text);
        filename=findViewById(R.id.filename);
        rbone.setEnabled(false);
        rbtwo.setEnabled(false);

        btn_fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initFB(id);
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
        textView.setText("新闻代办详情");
    }

    private void initFB(final String id) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_FB, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
               finish();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(new_ci_main_one.this, ""+volleyError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String> map=new HashMap<>();
                map.put("id",id);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }
}
