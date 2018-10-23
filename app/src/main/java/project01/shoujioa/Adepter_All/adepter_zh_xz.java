package project01.shoujioa.Adepter_All;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project01.shoujioa.R;
import project01.shoujioa.gson_tool.new_String;

public class adepter_zh_xz extends BaseAdapter {
    Context context;
    List<new_String> mlist=new ArrayList<>();
    private Map<Integer,Boolean> map=new HashMap<>();
    public adepter_zh_xz(Context context, List<new_String> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    as a=null;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if(view==null){
            a=new as();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.itme, parent, false);
            a.checkBox = view.findViewById(R.id.id_checkbox);
            view.setTag(a);
        }else{
           a= (as) view.getTag();
        }


        a.checkBox.setText(mlist.get(position).getString_name());
        a.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    map.put(position,true);
                    mOnDeleteListener.delete(mlist.get(position).getString_id());
                }else{
                    map.remove(position);
                }
            }
        });
        if(map!=null&&map.containsKey(position)){
            a.checkBox.setChecked(true);
        }else {
            a.checkBox.setChecked(false);
        }
        return view;
    }
    class as{
        CheckBox checkBox;

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
