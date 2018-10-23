package project01.shoujioa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import project01.shoujioa.Adepter_All.dai_Adepter;
import project01.shoujioa.Adepter_All.dai_Adepter_fw;
import project01.shoujioa.Fragment_main.day_btn_fragment;
import project01.shoujioa.Fragment_main.new_btn_fragment;
import project01.shoujioa.Intent_mian.All_services;
import project01.shoujioa.Intent_mian.Document_main;
import project01.shoujioa.Intent_mian.Entrust_mian;
import project01.shoujioa.Intent_mian.Office_meeting;
import project01.shoujioa.main_new_inten.File_upload;
import project01.shoujioa.main_new_inten.Rules_system_main;
import project01.shoujioa.main_new_inten.new_noti_activity;

public class Fragment_zhu extends Fragment implements View.OnClickListener {
    private View view;
    private RecyclerView recyclerView_work,recyclerView_work_fu;
    private ArrayList<String> mlst=new ArrayList();
    private ArrayList<String> mlist=new ArrayList();
    private dai_Adepter dai_adepter;
    private dai_Adepter_fw dai_adepter_fw;
    private String[] strs=new String[]{"待办","知会","关注","已办"};
    private String[] str=new String[]{"公文管理","通知报告","文件传递","办公会","新闻期刊","委托授权","规章制度","所有服务"};
    private RadioButton new_btn,day_btn;
    private new_btn_fragment new_btn_fragment;
    private day_btn_fragment day_btn_fragment;
    private FragmentManager fm;
    private TextView text_name,title_text;
    private SharedPreferences sp;
    private String userid;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragmet_main_zhu,null);
        sp = getContext().getSharedPreferences("abc", 0);
        userid = sp.getString("id", "");
        initview();
        return view;
    }

    private void initview() {
        fm=getActivity().getSupportFragmentManager();
        text_name=view.findViewById(R.id.text_name);
        text_name.setText(""+sp.getString("name","" ));
        recyclerView_work=view.findViewById(R.id.recyclerView_work);
        recyclerView_work_fu=view.findViewById(R.id.recyclerView_work_fu);
        new_btn=view.findViewById(R.id.new_btn);
        day_btn=view.findViewById(R.id.day_btn);
        new_btn.setOnClickListener(this);
        day_btn.setOnClickListener(this);
        new_btn.setChecked(true);
        day_btn.setChecked(false);
        for(int i=0;i<strs.length;i++){
            mlst.add(strs[i]+"");
        }
        dai_adepter=new dai_Adepter(getContext(),mlst);
        recyclerView_work.setLayoutManager(new GridLayoutManager (getContext(),4));
//        recyclerView_work.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView_work.setAdapter(dai_adepter);
        dai_adepter.setOnDeleteListener(new dai_Adepter_fw.OnDeleteListener() {
            @Override
            public void delete(int position) {
               switch (position){
                    case 0:
                        //代办
                        Intent intent=new Intent(getContext(),Agency_main.class);
                        startActivity(intent);
                       break;
                   case 1:
                       //知会
                       Intent intentun=new Intent(getContext(),Understanding.class);
                       startActivity(intentun);
                       break;
                   case 2:
                       //关注
                       Intent intentfollow=new Intent(getContext(),Follow.class);
                       startActivity(intentfollow);
                       break;
                   case 3:
                       //已办
                       Intent intenthave=new Intent(getContext(),Have_done.class);
                       startActivity(intenthave);
                       break;
                   case 4://预警
                      // Intent intentwarning=new Intent(getContext(),warning.class);
                      // startActivity(intentwarning);
                       break;
               }
            }
        });

        for(int i=0;i<str.length;i++){
            mlist.add(str[i]+"");
        }
        dai_adepter_fw=new dai_Adepter_fw(getContext(),mlist);
        recyclerView_work_fu.setLayoutManager(new GridLayoutManager(getContext(),4));
        recyclerView_work_fu.setAdapter(dai_adepter_fw);
        dai_adepter_fw.setOnDeleteListener(new dai_Adepter_fw.OnDeleteListener() {
            @Override
            public void delete(int position) {
                switch (position){
                    case 0:
                        //公文管理
                        Intent intentgwgl=new Intent(getContext(), Document_main.class);
                        startActivity(intentgwgl);
                    break;
                    case 1:
                    //通知公告
                        Intent intent=new Intent(getActivity(),new_noti_activity.class);
                        intent.putExtra("pos","1");
                        startActivity(intent);
                        break;
                    case 2:
                    //文件传递
                        Intent intentwj=new Intent(getContext(),File_upload.class);
                        intentwj.putExtra("userid",userid);
                        startActivity(intentwj);
                        break;
                    case 3:
                        //办公会
                        Intent intentOffice=new Intent(getContext(), Office_meeting.class);
                        startActivity(intentOffice);
                        break;
                    case 4:
                        //新闻期刊
                        Intent intentnew=new Intent(getActivity(),new_noti_activity.class);
                        intentnew.putExtra("pos","2");
                        startActivity(intentnew);
                        break;
                    case 5:
                    //委托授权
                    Intent intentwtsq=new Intent(getContext(), Entrust_mian.class);
                    intentwtsq.putExtra("userid",userid);
                    startActivity(intentwtsq);
                        break;
                    case 6:
                    //规章制度
                        Intent intentrulse=new Intent(getContext(),Rules_system_main.class);
                        startActivity(intentrulse);
                        break;
                    case 7:
                    //所有服务
                        Intent intentAll=new Intent(getContext(),All_services.class);
                        intentAll.putExtra("zhi","1");
                        startActivity(intentAll);
                        break;
                }
            }
        });
        new_btn_fragment=new new_btn_fragment();
        fm.beginTransaction().add(R.id.ll_newday,new_btn_fragment).commit();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.new_btn:
                new_btn.setChecked(true);
                day_btn.setChecked(false);
                new_btn_fragment=new new_btn_fragment();
                fm.beginTransaction().replace(R.id.ll_newday,new_btn_fragment).commit();
                break;
            case R.id.day_btn:
                day_btn.setChecked(true);
                new_btn.setChecked(false);
                day_btn_fragment=new day_btn_fragment();
                fm.beginTransaction().replace(R.id.ll_newday,day_btn_fragment).commit();
                break;
        }
    }

}
