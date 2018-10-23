package project01.shoujioa.Adepter_All;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import project01.shoujioa.R;
import project01.shoujioa.gson_tool.new_String;

public class lips_adepter_two extends BaseAdapter{
    Context context;
    ArrayList<new_String> mlist=new ArrayList<>();
    viewHodler v;
    public lips_adepter_two(Context context, ArrayList<new_String> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View  view=convertView;
        if(view==null){
            v=new viewHodler();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lips_main_itme, parent, false);
            v.lips_itme_text=view.findViewById(R.id.lips_itme_text);
            v.lips_itme_time=view.findViewById(R.id.lips_itme_time);
            view.setTag(v);
        }else{
            v= (viewHodler) view.getTag();
        }
        v.lips_itme_text.setText(mlist.get(position).getString_name());
        v.lips_itme_time.setText(mlist.get(position).getString_tiem());
        return view;
    }
    class viewHodler{
        TextView lips_itme_text,lips_itme_time;
    }
    public interface OnDeleteListener{
        void delete(String position);
    }
    //声明接口对象
    private adepter.OnDeleteListener mOnDeleteListener;

    //设置监听器,实例化接口
    public void setOnDeleteListener(adepter.OnDeleteListener onDeleteListener){
        mOnDeleteListener = onDeleteListener;
    }
}
