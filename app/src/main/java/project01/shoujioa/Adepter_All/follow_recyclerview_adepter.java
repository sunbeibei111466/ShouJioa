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

import project01.shoujioa.R;
import project01.shoujioa.gson_tool.new_String;

public class follow_recyclerview_adepter extends RecyclerView.Adapter<follow_recyclerview_adepter.MY> {
    Context context;
    private ArrayList<new_String> arrayList=new ArrayList<>();

    public follow_recyclerview_adepter(Context context, ArrayList<new_String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MY onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            follow_recyclerview_adepter.MY My=new follow_recyclerview_adepter.MY(LayoutInflater.from(
                    context).inflate(R.layout.follow_recyclerview_main, viewGroup,
                    false));
            return My;
    }

    @Override
    public void onBindViewHolder(@NonNull final MY my, final int i) {
            my.textView.setText(arrayList.get(i).getString_name());
        int i1 = arrayList.get(i).getString_tiem().indexOf(" ");
        String time = arrayList.get(i).getString_tiem().substring(0, i1);
        my.textViewone.setText(time+"");
            my.ckxq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnDeleteListener.deletes(arrayList.get(i).getString_id(),arrayList.get(i).getString_bid(),"1");
                }
            });
        my.qx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnDeleteListener.deletes(arrayList.get(i).getString_id(),arrayList.get(i).getString_bid(),"2");
            }
        });

    }

    @Override
    public int getItemCount() {
            return arrayList.size();
    }

    public class MY extends RecyclerView.ViewHolder {
        private TextView textView;
        private TextView textViewone;
        private Button ckxq,qx;
        public MY(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            textViewone=itemView.findViewById(R.id.time);
            ckxq=itemView.findViewById(R.id.id_btn_ckxq);
            qx=itemView.findViewById(R.id.id_btn_qx);
        }
    }
    public interface OnDeleteListener{
        void deletes(String id ,String bid,String str);
    }
    //声明接口对象
    private OnDeleteListener mOnDeleteListener;

    //设置监听器,实例化接口
    public void setOnDeleteListener(OnDeleteListener onDeleteListener){
        mOnDeleteListener = onDeleteListener;
    }

}
