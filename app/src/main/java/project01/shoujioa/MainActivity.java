package project01.shoujioa;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Fragment_dai fragment_dai;
    private Fragment_zhu fragment_zhu;
    private Fragment_tong fragment_tong;
    private RadioButton dai,zhu,tong;
    private FragmentManager fm;
    private long clickTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();

    }

    private void initview() {
        fm = getSupportFragmentManager();

        dai=findViewById(R.id.dai);
         zhu=findViewById(R.id.zhu);
        tong=findViewById(R.id.tong);

        dai.setOnClickListener(this);
        zhu.setOnClickListener(this);
        tong.setOnClickListener(this);

        zhu.setChecked(true);
        fragment_zhu=new Fragment_zhu();
        fm.beginTransaction().add(R.id.ll,fragment_zhu).commit();
    }
    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.dai:
            fragment_dai=new Fragment_dai();
            fm.beginTransaction().replace(R.id.ll,fragment_dai).commit();
            break;
        case R.id.zhu:
            fragment_zhu=new Fragment_zhu();
            fm.beginTransaction().replace(R.id.ll,fragment_zhu).commit();
            break;
        case R.id.tong:
            fragment_tong=new Fragment_tong();
            fm.beginTransaction().replace(R.id.ll,fragment_tong).commit();
            break;
    }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (SystemClock.uptimeMillis() - clickTime <= 1500) {
                //如果两次的时间差＜1s，就不执行操作

            } else {
                //当前系统时间的毫秒值
                clickTime = SystemClock.uptimeMillis();
                Toast.makeText(this, "再次点击退出", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences settings=getSharedPreferences("abc",0);
        SharedPreferences.Editor editor = settings.edit();
        editor .clear();
        editor .commit();
    }
}
