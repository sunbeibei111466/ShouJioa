package project01.shoujioa.XQ_adepter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import project01.shoujioa.R;
import project01.shoujioa.gson_tool.new_String;

public class TSXQ_adepter_main extends RecyclerView.Adapter<TSXQ_adepter_main.MY> {
    private Context context;
    private List<new_String> mlist=new ArrayList<>();

    public TSXQ_adepter_main(Context context, List<new_String> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public MY onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MY my=new MY(LayoutInflater.from(context)
                .inflate(R.layout.lips_main_itme,viewGroup,false));
        return my;
    }

    @Override
    public void onBindViewHolder(@NonNull MY my, int i) {
        my.lips_itme_text.setText(mlist.get(i).getString_name());
        my.lips_itme_time.setText(mlist.get(i).getString_tiem());
    }

    @Override
    public int getItemCount() {
       if(mlist.size()!=0){
           return mlist.size();
       }
        return 0;
    }

    public class MY extends RecyclerView.ViewHolder {
        private TextView lips_itme_text,lips_itme_time;
        public MY(@NonNull View itemView) {
            super(itemView);
            lips_itme_text=itemView.findViewById(R.id.lips_itme_text);
            lips_itme_time=itemView.findViewById(R.id.lips_itme_time);
        }
    }
}
