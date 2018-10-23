package project01.shoujioa.Adepter_All;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import project01.shoujioa.R;
import project01.shoujioa.gson_tool.new_String;

public class WSTJ_Adepter  extends RecyclerView.Adapter<WSTJ_Adepter.MY> {
    private Context context;
    private List<new_String> arrayList;
    private String sz;
    public WSTJ_Adepter(Context context, List<new_String> arrayList,String sz) {
        this.context = context;
        this.arrayList = arrayList;
        this.sz=sz;
    }

    @NonNull
    @Override
    public MY onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        WSTJ_Adepter.MY My=new WSTJ_Adepter.MY(LayoutInflater.from(
                context).inflate(R.layout.agency_recyclerview_main, viewGroup,
                false));
        return My;
    }

    @Override
    public void onBindViewHolder(@NonNull MY my, final  int i) {
        my.textView.setText(arrayList.get(i).getString_name());
        int i1 = arrayList.get(i).getString_tiem().indexOf(" ");
        String time = arrayList.get(i).getString_tiem().substring(0, i1);
        my.textViewone.setText(time+"");
        if(sz.equals("1")){
            my.lx.setText("[卫生统计]");
        }
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
    private OnDeleteListener mOnDeleteListener;

    //设置监听器,实例化接口
    public void setOnDeleteListener(OnDeleteListener onDeleteListener){
        mOnDeleteListener = onDeleteListener;
    }
}
