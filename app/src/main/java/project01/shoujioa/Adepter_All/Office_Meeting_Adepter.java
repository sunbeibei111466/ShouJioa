package project01.shoujioa.Adepter_All;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import project01.shoujioa.R;
import project01.shoujioa.gson_tool.new_String;

public class Office_Meeting_Adepter extends RecyclerView.Adapter<Office_Meeting_Adepter.MY> {
    private Context context;
    private List<new_String> mlist=new ArrayList<>();

    public Office_Meeting_Adepter(Context context, List<new_String> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public MY onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MY my=new MY(LayoutInflater.from(context)
                .inflate(R.layout.office_meeting_main,viewGroup,false));
        return my;
    }

    @Override
    public void onBindViewHolder(@NonNull MY my,final int i) {
        if(mlist.get(i).getString_name().equals("")){
            my.textView.setText("李白");
        }else{
            my.textView.setText(mlist.get(i).getString_name()+"年第"+mlist.get(i).getFlag()   +"次局长办公会仪材料");
        }
        my.time.setText(mlist.get(i).getString_tiem());
        my.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnDeleteListener.delete(mlist.get(i).getString_id());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class MY extends RecyclerView.ViewHolder {
        private TextView textView,time;
        public MY(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            time=itemView.findViewById(R.id.time);
        }
    }
    public interface OnDeleteListener{
        void delete(String id);
    }
    //声明接口对象
    private agency_recyclerview_adepter.OnDeleteListener mOnDeleteListener;

    //设置监听器,实例化接口
    public void setOnDeleteListener(agency_recyclerview_adepter.OnDeleteListener onDeleteListener){
        mOnDeleteListener = onDeleteListener;
    }
}
