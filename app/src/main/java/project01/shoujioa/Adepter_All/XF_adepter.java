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

public class XF_adepter  extends RecyclerView.Adapter<XF_adepter.MY> {
    Context context;
    private ArrayList<new_String> arrayList=new ArrayList<>();

    public XF_adepter(Context context, ArrayList<new_String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public XF_adepter.MY onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        XF_adepter.MY My=new XF_adepter.MY(LayoutInflater.from(
                context).inflate(R.layout.agency_recyclerview_main, viewGroup,
                false));
        return My;
    }

    @Override
    public void onBindViewHolder(@NonNull final XF_adepter.MY my, final  int i) {
        my.textView.setText(arrayList.get(i).getString_name());
        my.textViewone.setText(arrayList.get(i).getString_tiem()+"");
        if(arrayList.get(i).getFlag().equals("1")){
            my.lx.setText("[信访]");
        }else if(arrayList.get(i).getFlag().equals("2")){
            my.lx.setText("[投诉]");
        }
        my.btn_age.setText("马上处理");
        my.btn_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayList.get(i).getFlag().equals("1")){
                    mOnDeleteListener.delete(arrayList.get(i).getString_id(),"1");
                }else if(arrayList.get(i).getFlag().equals("2")) {
                    mOnDeleteListener.delete(arrayList.get(i).getString_id(),"2");
                }

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
        private Button btn_age;
        public MY(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            textViewone=itemView.findViewById(R.id.time);
            btn_age=itemView.findViewById(R.id.btn_age);
            lx=itemView.findViewById(R.id.lx);
        }
    }
    public interface OnDeleteListener{
        void delete(String id,String flag);
    }
    //声明接口对象
    private XF_adepter.OnDeleteListener mOnDeleteListener;

    //设置监听器,实例化接口
    public void setOnDeleteListener(XF_adepter.OnDeleteListener onDeleteListener){
        mOnDeleteListener = onDeleteListener;
    }

}
