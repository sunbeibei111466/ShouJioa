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

public class review_recyclerview_adepter extends RecyclerView.Adapter<review_recyclerview_adepter.MY> {
    Context context;
    private ArrayList<new_String> arrayList=new ArrayList<>();

    public review_recyclerview_adepter(Context context, ArrayList<new_String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MY onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        review_recyclerview_adepter.MY My=new review_recyclerview_adepter.MY(LayoutInflater.from(
                context).inflate(R.layout.review_recyclerview_main, viewGroup,
                false));
        return My;
    }

    @Override
    public void onBindViewHolder(@NonNull MY my,final int i) {
        my.textView.setText(arrayList.get(i).getString_name());
        int i1 = arrayList.get(i).getString_tiem().indexOf(" ");
//        .substring(0, i1);
        String time = arrayList.get(i).getString_tiem();
        my.textViewone.setText(time+"");
        my.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnDeleteListener.delete(arrayList.get(i).getString_id());
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

        public MY(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            textViewone=itemView.findViewById(R.id.time);

        }
    }
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
