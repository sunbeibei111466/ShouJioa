package project01.shoujioa.Adepter_All;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import project01.shoujioa.R;

public class CarAdapter extends BaseAdapter {
    private Context ctx;

    private ArrayList<String> dataList;

    public CarAdapter(Context ctx,ArrayList<String> dataList) {
        this.ctx = ctx;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(ctx, R.layout.item_car, null);
            new ViewHolder(convertView);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();

        holder.car_brand.setText(dataList.get(position).toString());
        return convertView;
    }

    class ViewHolder {
        TextView car_brand;
        public ViewHolder(View convertView){
            car_brand =convertView.findViewById(R.id.tv_car_brand);
            convertView.setTag(this);
        }
    }
}
