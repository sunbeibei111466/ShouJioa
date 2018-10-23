package project01.shoujioa.Adepter_All;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import project01.shoujioa.R;
import project01.shoujioa.gson_tool.new_String;

public class lips_Adepter extends RecyclerView.Adapter<lips_Adepter.MY> {
    private Context context;
    private ArrayList<new_String> mlist;
    public lips_Adepter(Context context, ArrayList<new_String> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public MY onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MY My=new MY(LayoutInflater.from(context).inflate(R.layout.lips_main_itme,viewGroup,false));
        return My;
    }

    @Override
    public void onBindViewHolder(@NonNull MY my, int i) {
        my.lips_itme_text.setText(mlist.get(i).getString_name());
        my.lips_itme_time.setText(mlist.get(i).getString_tiem());
        my.name.setText(mlist.get(i).getString_bid());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }


    public interface OnDeleteListener{
        void delete(String position);
    }
    //声明接口对象
    private adepter.OnDeleteListener mOnDeleteListener;

    //设置监听器,实例化接口
    public void setOnDeleteListener(adepter.OnDeleteListener onDeleteListener){
        mOnDeleteListener = onDeleteListener;
    }

    public class MY extends RecyclerView.ViewHolder {
        TextView lips_itme_text,lips_itme_time,name;
        public MY(@NonNull View itemView) {
            super(itemView);
            lips_itme_text=itemView.findViewById(R.id.lips_itme_text);
            lips_itme_time=itemView.findViewById(R.id.lips_itme_time);
            name=itemView.findViewById(R.id.name);
        }
    }
}
