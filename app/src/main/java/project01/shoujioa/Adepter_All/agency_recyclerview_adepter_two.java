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

public class agency_recyclerview_adepter_two extends RecyclerView.Adapter<agency_recyclerview_adepter_two.MY> {
    Context context;
    private ArrayList<new_String> arrayList=new ArrayList<>();

    public agency_recyclerview_adepter_two(Context context, ArrayList<new_String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MY onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
     MY My=new MY(LayoutInflater.from(
                context).inflate(R.layout.agency_recyclerview_main_two, viewGroup,
                false));
        return My;
    }

    @Override
    public void onBindViewHolder(@NonNull MY my, final  int i) {
        my.textView.setText(arrayList.get(i).getString_name());
        my.textViewone.setText(arrayList.get(i).getString_tiem()+"");
        if(arrayList.get(i).getFlag().equals("1")){
            my.lx.setText("[公文]");
        }else if(arrayList.get(i).getFlag().equals("2")){
            my.lx.setText("[通知]");
        }else if(arrayList.get(i).getFlag().equals("3")){
            my.lx.setText("[新闻]");
        }else if(arrayList.get(i).getFlag().equals("4")){
            my.lx.setText("[信访]");
        }else if(arrayList.get(i).getFlag().equals("5")){
            my.lx.setText("[投诉]");
        }
        my.btn_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnDeleteListener.delete(arrayList.get(i).getString_id(),arrayList.get(i).getFlag());
            }
        });
    }

    @Override
    public int getItemCount() {
        if(arrayList.size()==0){
            return  0;
        }
        return arrayList.size();
    }

    public class MY extends RecyclerView.ViewHolder {
        private TextView textView,lx;
        private TextView textViewone;
        private Button btn_age;
        public MY(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            textViewone=itemView.findViewById(R.id.time);
            lx=itemView.findViewById(R.id.lx);
            btn_age=itemView.findViewById(R.id.btn_age);
        }
    }
    public interface OnDeleteListener{
        void delete(String id,String flag);
    }
    //声明接口对象
    private OnDeleteListener mOnDeleteListener;

    //设置监听器,实例化接口
    public void setOnDeleteListener(OnDeleteListener onDeleteListener){
        mOnDeleteListener = onDeleteListener;
    }

}
