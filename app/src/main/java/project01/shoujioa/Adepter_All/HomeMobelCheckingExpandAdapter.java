package project01.shoujioa.Adepter_All;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project01.shoujioa.R;
import project01.shoujioa.gson_tool.er_String;
import project01.shoujioa.gson_tool.erji_two;
import project01.shoujioa.gson_tool.new_String;

public  class HomeMobelCheckingExpandAdapter extends BaseExpandableListAdapter {
      private   Map<String, String> map;
    private List<erji_two> mlistyi=new ArrayList<>();
    private Context context;
    public  List<new_String> arrayLister = new ArrayList();

    public HomeMobelCheckingExpandAdapter(List<erji_two> mlistyi, Context context, List<new_String> arrayLister, Map<String, String> map) {
        this.mlistyi = mlistyi;
        this.context = context;
        this.arrayLister = arrayLister;
        this.map=map;
    }

    //一级
    @Override
    public int getGroupCount() {
        return mlistyi.size();
    }
    //二级
    @Override
    public int getChildrenCount(int groupPosition) {
        return mlistyi.get(groupPosition).getArrlist().size();
    }
    //一级
    @Override
    public Object getGroup(int groupPosition) {
        return mlistyi.get(groupPosition);
    }
    //二级
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mlistyi.get(groupPosition).getArrlist().get(childPosition);
    }
    //一级
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
    //二级
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
    // 分组和子选项是否持有稳定的ID, 就是说底层数据的改变会不会影响到它们。
    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.erji_list_mian_yi, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.tvTitle =convertView.findViewById(R.id.textView);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.tvTitle.setText(mlistyi.get(groupPosition).getName());
        return convertView;
    }

    @Override
    public View getChildView(final  int groupPosition, final int childPosition,final boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.itme, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.checkBox =convertView.findViewById(R.id.id_checkbox);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.checkBox.setText(mlistyi.get(groupPosition).getArrlist().
                get(childPosition).getEr_name());
        childViewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    map.put(mlistyi.get(groupPosition).getArrlist().get(childPosition).getEr_id(),mlistyi.get(groupPosition).getArrlist().get(childPosition).getEr_name());
                }else{
                    map.remove(mlistyi.get(groupPosition).getArrlist().get(childPosition).getEr_id());
                }
            }
        });

        if(map!=null){
            childViewHolder.checkBox.setChecked(map.containsKey(mlistyi.get(groupPosition).getArrlist().get(childPosition).getEr_id()));

        }

        return convertView;

    }
    //        指定位置上的子元素是否可选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    class GroupViewHolder {
        TextView tvTitle;
    }
    class ChildViewHolder {
        CheckBox checkBox;
    }
    public interface setDeleteListener{
        void delete(String position,String id_xq,String pos);
    }
    //声明接口对象
    private setDeleteListener msetDeleteListener;

    //设置监听器,实例化接口
    public void setOnDeleteListener(setDeleteListener setDeleteListener){
        msetDeleteListener = setDeleteListener;
    }
}

