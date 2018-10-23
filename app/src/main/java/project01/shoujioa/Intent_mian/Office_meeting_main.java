
package project01.shoujioa.Intent_mian;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project01.shoujioa.Adepter_All.Ytap_Recycler;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.Interface.Ytap_XQ;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.Office_mian_Tool;
import project01.shoujioa.gson_tool.new_String;

public class Office_meeting_main extends AppCompatActivity {
    private TextView titlename;
    private Button btn;
    private String id;
    private RequestQueue requestQueue;
    private String URL= HttpUtils.URL+"ytapapp/app_formlook";
    private RecyclerView recyclerView;
    private List<new_String> mlist=new ArrayList<>();
    private Ytap_Recycler ytap_recycler;
    private TextView title;
    private TextView prepare_start;
    private TextView time;
    private TextView member_recycler;
    private TextView meeting_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_meeting_main);
        requestQueue= Volley.newRequestQueue(this);
        id=getIntent().getStringExtra("id");
        initview();
        initdate();
    }

    private void initdate() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();
                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String message = jsonObject1.getString("message");
                    if(!message.equals("success")){

                    }else{
                        Office_mian_Tool office_mian_tool = gson.fromJson(s, Office_mian_Tool.class);
                        Office_mian_Tool.MapBean.WsjYtapBean wsjYtap = office_mian_tool.getMap().getWsjYtap();
                        List<Office_mian_Tool.MapBean.WsjYtapBean.YtapListBean> ytapList = wsjYtap.getYtapList();
                        time.setText(office_mian_tool.getMap().getWsjYtap().getCreateDate());
                        title.setText(office_mian_tool.getMap().getWsjYtap().getYt());
                        meeting_num.setText("|第"+office_mian_tool.getMap().getWsjYtap().getCi()+"会议");
                        member_recycler.setText(office_mian_tool.getMap().getWsjYtap().getUser().getName());
                        for(int i=0;i<ytapList.size();i++){
                            new_String new_string=new new_String();
                            new_string.setString_name(i+1+"");
                            new_string.setFlag(ytapList.get(i).getYt());
                            new_string.setZjh(ytapList.get(i).getHbr());
                            new_string.setPhone(ytapList.get(i).getClbh());
                            mlist.add(new_string);
                        }
                        ytap_recycler=new Ytap_Recycler(mlist,getApplicationContext());
                        recyclerView.setAdapter(ytap_recycler);
                        ytap_recycler.setOnDeleteListener(new Ytap_Recycler.OnDeleteListener() {
                            @Override
                            public void delete(String id) {
                                Intent intent=new Intent(getApplicationContext(),Ytap_XQ.class);
                                intent.putExtra("id",id);
                                startActivity(intent);
                            }
                        });
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
            protected Map<String, String> getParams() {
                Map<String,String> map=new HashMap<>();
                map.put("id",id);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void initview() {
        View veiw=findViewById(R.id.includeone);
        titlename=veiw.findViewById(R.id.title_text);
        titlename.setText("办公会详情");
        btn=veiw.findViewById(R.id.img_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        title = findViewById(R.id.textView);//会议标题
        prepare_start = findViewById(R.id.prepare_start);//代开始
        time = findViewById(R.id.time);//会议时间
        member_recycler = findViewById(R.id.member_recycler);//参会人员列表
        meeting_num = findViewById(R.id.meeting_num);//会议次数

        recyclerView=findViewById(R.id.ytap);//会议议题列表
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
