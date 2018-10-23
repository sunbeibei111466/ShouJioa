package project01.shoujioa.Adepter_All;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import project01.shoujioa.gson_tool.new_String;

public class filed_details_Adepter extends RecyclerView.Adapter<filed_details_Adepter.MY> {
    Context context;
    private List<new_String> mlist=new ArrayList<>();

    public filed_details_Adepter(Context context, List<new_String> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public MY onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MY my, int i) {

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class MY extends RecyclerView.ViewHolder {
        public MY(@NonNull View itemView) {
            super(itemView);
        }
    }
}
