package com.app.users_redimed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdapterRequestSent extends BaseAdapter {

    public Context context;
    public int layout;
    public List<ItemRequestSent> listItems;

    public AdapterRequestSent(Context context, int layout, List<ItemRequestSent> listItems) {
        this.context = context;
        this.layout = layout;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        TextView txtName =(TextView) convertView.findViewById(R.id.txtName);
        LinearLayout lnItem =(LinearLayout) convertView.findViewById(R.id.lnItem);
        TextView txtSTT =(TextView) convertView.findViewById(R.id.txtSTT);
        ItemRequestSent item = listItems.get(position);
        txtName.setText(item.Name);
        txtSTT.setText(item.STT);
        if(item.FB==1){
            lnItem.setBackgroundResource(R.drawable.shapebutton);
        }else{
            lnItem.setBackgroundResource(R.drawable.shapebuttonlur);
        }
        return convertView;
    }

}
