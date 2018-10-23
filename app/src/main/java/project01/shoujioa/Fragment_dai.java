package project01.shoujioa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project01.shoujioa.Adepter_All.agency_recyclerview_adepter_two;
import project01.shoujioa.Intent_mian.Search_mian;
import project01.shoujioa.Intent_mian.TS_db_xq;
import project01.shoujioa.Intent_mian.XF_db_xq;
import project01.shoujioa.gson_tool.new_String;
import project01.shoujioa.gson_tool.new_all_DB;
import project01.shoujioa.main_new_inten.new_ci_main_one;
import project01.shoujioa.main_new_inten.noti_ci_main_one;

public class Fragment_dai extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private agency_recyclerview_adepter_two agency_recyclerview_adepter_two;
    private ArrayList<new_String> arrayList = new ArrayList<>();
    private RequestQueue requestQueue;
    private String URL = HttpUtils.URL + "login/app_sydblist";
    private SharedPreferences sp;
    private String userid;
    private EditText editText;
    private Button button;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmet_main_dai, null);
        requestQueue = Volley.newRequestQueue(getContext());
        sp = getContext().getSharedPreferences("abc", 0);
        userid = sp.getString("id", "");
        initfind();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (arrayList.size()!=0){
                    arrayList.clear();
                    initview();
                }


            }
        });
        return view;
    }

    private void initfind() {
        recyclerView = view.findViewById(R.id.agency_recyclerview);
        swipeRefreshLayout = view.findViewById(R.id.srh);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        editText = view.findViewById(R.id.edit_query);
        button = view.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Search_mian.class);
                intent.putExtra("search", editText.getText().toString().trim());
                if (editText.getText().toString().trim().equals("")) {
                    Toast.makeText(getContext(), "搜索为空", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(intent);
                    editText.setText("");
                }

            }
        });
    }



    private void initview() {
        StringRequest jsonObjectRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String jsonObject) {
                Log.e("代办结果列表", jsonObject);
                swipeRefreshLayout.setRefreshing(false);
                Gson gson = new Gson();

                try {
                    JSONObject jsonObject1 = new JSONObject(jsonObject);
                    String message = jsonObject1.getString("message");
                    if (!message.equals("success")) {

                    } else {
                        new_all_DB new_all_db = gson.fromJson(jsonObject, new_all_DB.class);
                        List<new_all_DB.MapBean.WsjdbBean> wsjdb = new_all_db.getMap().getWsjdb();
                        for (int i = 0; i < wsjdb.size(); i++) {
                            new_String new_string = new new_String();
                            new_string.setString_name(wsjdb.get(i).getName());
                            new_string.setString_tiem(wsjdb.get(i).getTime());
                            new_string.setString_id(wsjdb.get(i).getId());
                            new_string.setFlag(wsjdb.get(i).getFlag());
                            arrayList.add(new_string);
                        }

                        agency_recyclerview_adepter_two = new agency_recyclerview_adepter_two(getContext(), arrayList);

                        recyclerView.setAdapter(agency_recyclerview_adepter_two);
                        agency_recyclerview_adepter_two.notifyDataSetChanged();
                        agency_recyclerview_adepter_two.setOnDeleteListener(new agency_recyclerview_adepter_two.OnDeleteListener() {
                            @Override
                            public void delete(String id, String flag) {
                                if (flag.equals("1")) {
                                    Intent intent = new Intent(getContext(), gw_shengpi.class);
                                    intent.putExtra("id", id);
                                    intent.putExtra("userid", userid);
                                    startActivity(intent);
                                } else if (flag.equals("2")) {
                                    Intent intent = new Intent(getContext(), new_ci_main_two.class);
                                    intent.putExtra("id", id);
                                    intent.putExtra("userid", userid);
                                    intent.putExtra("zhi", "2");
                                    startActivity(intent);
                                } else if (flag.equals("3")) {
                                    Intent intent = new Intent(getContext(), new_ci_main_two.class);
                                    intent.putExtra("id", id);
                                    intent.putExtra("userid", userid);
                                    intent.putExtra("zhi", "3");
                                    startActivity(intent);
                                } else if (flag.equals("4")) {
                                    Intent intent = new Intent(getContext(), XF_db_xq.class);
                                    intent.putExtra("id", id);
                                    intent.putExtra("userid", userid);
                                    startActivity(intent);
                                } else if (flag.equals("5")) {
                                    Intent intent = new Intent(getContext(), TS_db_xq.class);
                                    intent.putExtra("id", id);
                                    intent.putExtra("userid", userid);
                                    startActivity(intent);
                                }

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
                swipeRefreshLayout.setRefreshing(false);

            }
        }) {
            @Override
            public Map<String, String> getParams() {
                Map<String, String> map = new HashMap<>();
                map.put("userid", userid);
                map.put("name", "");
                return map;
            }
        };

        requestQueue.add(jsonObjectRequest);
    }


    @Override
    public void onResume() {
        super.onResume();
        if (arrayList.size()!=0){
            arrayList.clear();
            initview();
        }else{
            initview();
        }


    }
}
