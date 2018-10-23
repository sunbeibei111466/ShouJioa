package project01.shoujioa.Adepter_All;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import project01.shoujioa.R;
import project01.shoujioa.gson_tool.new_String;

public class Tong_adepter  extends RecyclerView.Adapter<Tong_adepter.MY>{
    private Context context;
    private ArrayList<new_String> mlist=new ArrayList<>();

    public Tong_adepter(Context context, ArrayList<new_String> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public Tong_adepter.MY onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                MY My=new MY(LayoutInflater.from(
                context).inflate(R.layout.tong_adepter_mian, viewGroup,
                false));
        return My;
    }

    @Override
    public void onBindViewHolder(@NonNull final Tong_adepter.MY my, final int i) {
        my.name.setText(mlist.get(i).getString_name());
        my.sjh.setText(mlist.get(i).getPhone());
        my.zjh.setText(mlist.get(i).getZjh());
        my.lin_sjh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mlist.get(i).getPhone().equals("")){
                    mOnDeleteListener.delete("1");
                }
                mOnDeleteListener.delete(mlist.get(i).getPhone());
            }
        });
        my.lin_zjh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mlist.get(i).getZjh().equals("")){
                    mOnDeleteListener.delete("1");
                }
                mOnDeleteListener.delete(mlist.get(i).getZjh());
            }
        });

    }

    @Override
    public int getItemCount() {
        if(mlist.size()!=0){
            return mlist.size();
        }
        return 0;
    }

    public class MY extends RecyclerView.ViewHolder {
        TextView name,sjh,zjh;
        LinearLayout lin_sjh,lin_zjh;
        public MY(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            sjh=itemView.findViewById(R.id.sjh);
            zjh=itemView.findViewById(R.id.zjh);
            lin_sjh=itemView.findViewById(R.id.lin_sjh);
            lin_zjh=itemView.findViewById(R.id.lin_zjh);
        }
    }
    //创建接口
    public interface OnDeleteListener{
        void delete(String position);
    }
    //声明接口对象
    private OnDeleteListener mOnDeleteListener;
    //设置监听器,实例化接口
    public void setOnDeleteListener(OnDeleteListener onDeleteListener){
        mOnDeleteListener = onDeleteListener;
    }
}
