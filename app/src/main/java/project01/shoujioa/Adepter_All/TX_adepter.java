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

public class TX_adepter extends RecyclerView.Adapter<TX_adepter.MY> {
    Context context;
    private ArrayList<new_String> arrayList=new ArrayList<>();

    public TX_adepter(Context context, ArrayList<new_String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public TX_adepter.MY onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TX_adepter.MY My=new TX_adepter.MY(LayoutInflater.from(
                context).inflate(R.layout.agency_recyclerview_main, viewGroup,
                false));
        return My;
    }

    @Override
    public void onBindViewHolder(@NonNull TX_adepter.MY my, final  int i) {
        my.textView.setText(arrayList.get(i).getString_name());
        int i1 = arrayList.get(i).getString_tiem().indexOf(" ");
        String time = arrayList.get(i).getString_tiem().substring(0, i1);
        my.textViewone.setText(time+"");
        my.lx.setText("[投诉]");
        my.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnDeleteListener.delete(arrayList.get(i).getString_id());
            }
        });
    }

    @Override
    public int getItemCount() {
        if(arrayList.size()==0){
            return 0;
        }
        return arrayList.size();
    }

    public class MY extends RecyclerView.ViewHolder {
        private TextView textView,lx;
        private TextView textViewone;
        public MY(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            textViewone=itemView.findViewById(R.id.time);
            lx=itemView.findViewById(R.id.lx);
        }
    }
    public interface OnDeleteListener{
        void delete(String id);
    }
    //声明接口对象
    private TX_adepter.OnDeleteListener mOnDeleteListener;

    //设置监听器,实例化接口
    public void setOnDeleteListener(TX_adepter.OnDeleteListener onDeleteListener){
        mOnDeleteListener = onDeleteListener;
    }

}
