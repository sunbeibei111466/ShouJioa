package project01.shoujioa.Adepter_All;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import project01.shoujioa.R;

public class dai_Adepter_fw extends RecyclerView.Adapter<dai_Adepter_fw.MY> {
    private Context context;
    private ArrayList<String> mlist=new ArrayList();


    private int[] img_str= new int[]{R.mipmap.gongwen,R.mipmap.bgh,R.mipmap.gzcx,R.mipmap.wtsq,
    R.mipmap.xfts,R.mipmap.yljg,R.mipmap.txl,R.mipmap.txl};

    public dai_Adepter_fw(Context context, ArrayList mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @Override
    public MY onCreateViewHolder(ViewGroup parent, int viewType) {
        MY My=new MY(LayoutInflater.from(
                context).inflate(R.layout.workarea_fw, parent,
                false));
        return My;
    }

    @Override
    public void onBindViewHolder(MY holder, final  int position) {

        holder.text_id.setText(mlist.get(position).toString());
        Glide.with(context)
                .load(img_str[position])
                .into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnDeleteListener.delete(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class MY extends RecyclerView.ViewHolder {
        TextView text_id;
        ImageView img;
        public MY(View itemView) {
            super(itemView);
            text_id=itemView.findViewById(R.id.text_id);
            img=itemView.findViewById(R.id.img);
        }
    }
    public interface OnDeleteListener{
        void delete(int position);
    }
    //声明接口对象
    private OnDeleteListener mOnDeleteListener;

    //设置监听器,实例化接口
    public void setOnDeleteListener(OnDeleteListener onDeleteListener){
        mOnDeleteListener = onDeleteListener;
    }
}
