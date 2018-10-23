package project01.shoujioa.Adepter_All;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import project01.shoujioa.R;
import project01.shoujioa.gson_tool.new_String;

public  class new_Adepter extends RecyclerView.Adapter<new_Adepter.MY>{
private Context context;
private ArrayList<new_String> mlist=new ArrayList<>();

    public new_Adepter(Context context, ArrayList<new_String> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @Override
    public MY onCreateViewHolder(ViewGroup parent, int viewType) {
        new_Adepter.MY My=new new_Adepter.MY(LayoutInflater.from(
                context).inflate(R.layout.new_main_rec, parent,
                false));
        return My;
    }

    @Override
    public void onBindViewHolder(MY holder, int position) {
        holder.textView.setText(mlist.get(position).getString_name()+"");
        holder.textViewtwo.setText(mlist.get(position).getString_tiem()+"");
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class MY extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textViewtwo;
        public MY(View inflate) {
            super(inflate);
            textView=itemView.findViewById(R.id.textView4);
            textViewtwo=itemView.findViewById(R.id.textView6);
        }
    }
}
