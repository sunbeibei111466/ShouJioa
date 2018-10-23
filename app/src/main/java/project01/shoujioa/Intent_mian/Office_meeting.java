package project01.shoujioa.Intent_mian;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import project01.shoujioa.Adepter_All.Office_Meeting_Adepter;
import project01.shoujioa.Adepter_All.agency_recyclerview_adepter;
import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.Office_Tool;
import project01.shoujioa.gson_tool.new_String;

public class Office_meeting extends AppCompatActivity {
    private RecyclerView office_recycler;
    Office_Meeting_Adepter office_meeting_adepter;
    private List<new_String> mlist=new ArrayList<>();
    String URL=HttpUtils.URL+"ytapapp/app_ytaplist";
    private RequestQueue requestQueue;
    private TextView textView;
    private Button btn;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_meeting);
        requestQueue= Volley.newRequestQueue(this);
        initview();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(100,100);
            }
        });
        initDate();
    }

    private void initDate() {
        StringRequest stringRequest=new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();
                try {
                    JSONObject jsonObject1 = new JSONObject(s);
                    String message = jsonObject1.getString("message");
                    if(!message.equals("success")){
                    }else{
                        Office_Tool office_tool = gson.fromJson(s, Office_Tool.class);
                        List<Office_Tool.DatasBean> datas = office_tool.getDatas();
                        mlist.clear();
                        for(int i=0;i<datas.size();i++){
                            //判断当前时间是否是今日
//                            boolean today = time_pd.isToday(datas.get(i).getHbks());
//                            if(today==false){
//                                //不是
//                            }else{
                                //是
                                new_String new_string=new new_String();
                                new_string.setString_name(datas.get(i).getNian());
                                new_string.setFlag(datas.get(i).getCi());
                                new_string.setString_id(datas.get(i).getId());
                                new_string.setString_tiem(datas.get(i).getCreateDate());
                                mlist.add(new_string);
                          //  }
                        }
                        office_meeting_adepter=new Office_Meeting_Adepter(Office_meeting.this,mlist);
                        office_recycler.setLayoutManager(new LinearLayoutManager(Office_meeting.this));
                        office_recycler.setAdapter(office_meeting_adepter);
                        office_meeting_adepter.setOnDeleteListener(new agency_recyclerview_adepter.OnDeleteListener() {
                            @Override
                            public void delete(String id) {
                                Intent intent=new Intent(Office_meeting.this,Office_meeting_main.class);
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
        });
        requestQueue.add(stringRequest);
    }

    private void initview() {
        swipeRefreshLayout=findViewById(R.id.srh);
        office_recycler=findViewById(R.id.office_recycler);
        View veiw=findViewById(R.id.includeone);
            textView=veiw.findViewById(R.id.title_text);
            textView.setText("办公会");
            btn=veiw.findViewById(R.id.img_btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            initDate();
            swipeRefreshLayout.setRefreshing(false);

        }
    };
}
