package project01.shoujioa.main_new_inten;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import project01.shoujioa.gson_tool.noti_ci_main_tool;

public class noti_ci_main extends AppCompatActivity{
    private Button btn_login,img_btn;
    private String URL= HttpUtils.URL+"tzggapp/app_formlook";
    private String id,userid;
    private RequestQueue requestQueue;

    private RadioButton rbone,rbtwo,rbthree;
    private TextView tv_bt_id,editText,xzks_text,filename,edid_id,title_text,cs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noti_ci_fragmenttwo_list);
        id=getIntent().getStringExtra("id");
        userid=getIntent().getStringExtra("userid");
        requestQueue= Volley.newRequestQueue(noti_ci_main.this);
        initview();
        initDate();
    }
    private void initview() {
        View view=findViewById(R.id.title_texts);
        img_btn=view.findViewById(R.id.img_btn);
        title_text=view.findViewById(R.id.title_text);
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        title_text.setText("通知列表详情");
        btn_login=findViewById(R.id.btn_login);
//        rbone=findViewById(R.id.rbone);
//        rbtwo=findViewById(R.id.rbtwo);
//        rbthree=findViewById(R.id.rbthree);
        tv_bt_id=findViewById(R.id.tv_bt_id);
        edid_id=findViewById(R.id.edid_id);
        editText=findViewById(R.id.editText);
        xzks_text=findViewById(R.id.xzks_text);
        filename=findViewById(R.id.filename);
        cs=findViewById(R.id.cs);
//        rbone.setEnabled(false);
//        rbtwo.setEnabled(false);
//        rbthree.setEnabled(false);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void initDate() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();
                try {
                    Log.e("TAG",s);
                    JSONObject jsonObject1 = new JSONObject(s);
                    String message = jsonObject1.getString("message");
                    if(!message.equals("success")){
                    }else{
                        noti_ci_main_tool noti_ci_main_tool = gson.fromJson(s, noti_ci_main_tool.class);
                        project01.shoujioa.gson_tool.noti_ci_main_tool.MapBean.WsjGgglBean wsjGggl = noti_ci_main_tool.getMap().getWsjGggl();
//                        if(wsjGggl.getLx().equals("值班安排")){
//                            rbthree.setChecked(true);
//                            rbone.setChecked(false);
//                            rbtwo.setChecked(false);
//                        }else if(wsjGggl.getLx().equals("委内通知")){
//                            rbone.setChecked(true);
//                            rbthree.setChecked(false);
//                            rbtwo.setChecked(false);
//                        }else if(wsjGggl.getLx().equals("外部通知")){
//                            rbtwo.setChecked(true);
//                            rbone.setChecked(false);
//                            rbthree.setChecked(false);
//                        }
                        tv_bt_id.setText(wsjGggl.getBt());
                        edid_id.setMovementMethod(ScrollingMovementMethod.getInstance());// 设置可滚动
                        edid_id.setMovementMethod(LinkMovementMethod.getInstance());//设置超链接可以打开网页
                        edid_id.setText(Html.fromHtml(wsjGggl.getGgnr(), null, null));
//                        editText.setText(wsjGggl.getUser().getName());
                        xzks_text.setText(wsjGggl.getGsbm());
                        editText.setText(wsjGggl.getFbr());
                        filename.setText(wsjGggl.getScfile());
                        cs.setText(wsjGggl.getBack2());

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(noti_ci_main.this, ""+volleyError.getMessage(), Toast.LENGTH_SHORT).show();

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