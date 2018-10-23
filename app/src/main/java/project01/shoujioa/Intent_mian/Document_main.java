package project01.shoujioa.Intent_mian;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import project01.shoujioa.Fragment_main.Agency_fragment;
import project01.shoujioa.Fragment_main.Follow_fragment;
import project01.shoujioa.Fragment_main.Have_done_Fragment;
import project01.shoujioa.Fragment_main.Read_fragment;
import project01.shoujioa.Fragment_main.Review_fragment;
import project01.shoujioa.R;
/**
 * 公文管理类*
 * */
public class Document_main extends AppCompatActivity {
    private TextView textView;
    private Button btn;
    ArrayList<Fragment> mfragments=new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();
    private TabLayout tabLayout;

    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_main);
        initview();
    }

    private void initview() {
        View view=findViewById(R.id.includeone);
        textView=view.findViewById(R.id.title_text);
        textView.setText("公文管理");
        btn=findViewById(R.id.img_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.tab_viewpager);
        titles.add("待办");
        titles.add("知会");
        titles.add("关注");
        titles.add("已办");
        //titles.add("预警");
        mfragments.add(new Agency_fragment());
        mfragments.add(new Review_fragment());
        mfragments.add(new Follow_fragment());
        mfragments.add(new Have_done_Fragment());
       // mfragments.add(new Read_fragment());
        PagerAdapter pagerAdapter = new MyViewPagerAdapter(this.getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        //将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);
    }
    final class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mfragments.get(position);
        }


        @Override
        public int getCount() {
            return mfragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);

        }
    }
}
