package project01.shoujioa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import project01.shoujioa.gson_tool.tool_login_sign_in;

public class login_Sign_in extends AppCompatActivity {
    private EditText edit_name,edit_pass;
    private Button btn_login;
    private RequestQueue requestQueue;
    private String urlname=HttpUtils.URL+"login/app_login?loginName=";
    private String urlpass="&password=";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_sig_in_main);
        requestQueue= Volley.newRequestQueue(this);
        initview();
    }
    private void initview() {
        edit_name=findViewById(R.id.edit_name);
        edit_pass=findViewById(R.id.edit_pass);
        btn_login=findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                final String name=edit_name.getText().toString();
                final String pass=edit_pass.getText().toString();
                if(name.equals("")|pass.equals("")){
                    Toast.makeText(login_Sign_in.this, "账号或密码为空", Toast.LENGTH_SHORT).show();
                }else{
                    String url=urlname+name+urlpass+pass;
                    JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            String sing=jsonObject.toString();
                            Gson gson=new Gson();
                            tool_login_sign_in tool_login_sign_in = gson.fromJson(sing, tool_login_sign_in.class);
                            if(tool_login_sign_in.getStatuscode().equals("200")){
                                SharedPreferences sp=getSharedPreferences("abc",0);
                                SharedPreferences.Editor edit = sp.edit();
                                edit.putString("id",tool_login_sign_in.getUser().getId());
                                edit.putString("name",tool_login_sign_in.getUser().getName());
                                edit.putString("yh",name);
                                edit.putString("pass",pass);
                                //提交edit
                                edit.commit();
                                Intent intent=new Intent(login_Sign_in.this,MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(login_Sign_in.this, ""+tool_login_sign_in.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            Toast.makeText(login_Sign_in.this, ""+volleyError.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    requestQueue.add(jsonObjectRequest);


                }
            }
        });
    }
}
