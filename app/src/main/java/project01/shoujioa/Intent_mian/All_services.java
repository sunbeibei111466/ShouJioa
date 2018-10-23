package project01.shoujioa.Intent_mian;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import project01.shoujioa.Fragment_main.Complaint_Fragment;
import project01.shoujioa.Fragment_main.Details_of_complaints_Fragment;
import project01.shoujioa.R;

public class All_services extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<Fragment> mlist = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();
    private TextView textView;
    private Button img_btn;
    private String zhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_services);
        zhi = getIntent().getStringExtra("zhi");
        initview();
    }

    private void initview() {
        if (zhi.equals("1")) {
            View view1 = findViewById(R.id.includeone);
            img_btn = view1.findViewById(R.id.img_btn);
            img_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            textView = view1.findViewById(R.id.title_text);
            textView.setText("信访");
            tabLayout = findViewById(R.id.tablayout);
            viewPager = findViewById(R.id.tab_viewpager);

            titles.add("信访列表");
            titles.add("投诉列表");
           // titles.add("待办");

            mlist.add(new Complaint_Fragment());
            mlist.add(new Details_of_complaints_Fragment());
           // mlist.add(new Xf_db_main());
            PagerAdapter pagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
            viewPager.setAdapter(pagerAdapter);
            //将ViewPager和TabLayout绑定
            tabLayout.setupWithViewPager(viewPager);
        }

    }

    final class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mlist.get(position);
        }


        @Override
        public int getCount() {
            return mlist.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);

        }
    }
}
