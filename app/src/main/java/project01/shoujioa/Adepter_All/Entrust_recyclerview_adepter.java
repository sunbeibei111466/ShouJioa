package project01.shoujioa.Adepter_All;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project01.shoujioa.HttpUtils;
import project01.shoujioa.R;
import project01.shoujioa.gson_tool.entrust_tool_entrust;
import project01.shoujioa.gson_tool.new_String;

public class Entrust_recyclerview_adepter extends RecyclerView.Adapter<Entrust_recyclerview_adepter.MY> {
    Context context;
    private List<new_String> arrayList;
    private RequestQueue requestQueue;
    private String URL= HttpUtils.URL+"wtsqapp/app_form";
    public Entrust_recyclerview_adepter(Context context, List<new_String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MY onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Entrust_recyclerview_adepter.MY My=new Entrust_recyclerview_adepter.MY(LayoutInflater.from(
                context).inflate(R.layout.entrust_mian_entrut, viewGroup,
                false));
        return My;
    }

    @Override
    public void onBindViewHolder(@NonNull final MY my, final  int i) {
        requestQueue= Volley.newRequestQueue(context);
        int i1 = arrayList.get(i).getString_tiem().indexOf(" ");
        String time = arrayList.get(i).getString_tiem().substring(0, i1);
        my.textViewone.setText(time+"");
        my.lx.setText("[委托]");
        my.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnDeleteListener.delete(arrayList.get(i).getString_id());
            }
        });
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
                        my.textView.setText(user.getName());
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
                map.put("id",arrayList.get(i).getString_id());
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MY extends RecyclerView.ViewHolder {
        private TextView textView,lx;
        private TextView textViewone;
        private Button btn;
        public MY(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            textViewone=itemView.findViewById(R.id.time);
            btn=itemView.findViewById(R.id.zk_btn);
            lx=itemView.findViewById(R.id.lx);
        }
    }
    public interface OnDeleteListener{
        void delete(String id);
    }
    //声明接口对象
    private OnDeleteListener mOnDeleteListener;

    //设置监听器,实例化接口
    public void setOnDeleteListener(OnDeleteListener onDeleteListener){
        mOnDeleteListener = onDeleteListener;
    }
}
