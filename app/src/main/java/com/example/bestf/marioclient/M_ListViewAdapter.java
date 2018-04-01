package com.example.bestf.marioclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yge30 on 2018-04-01.
 */

public class M_ListViewAdapter extends BaseAdapter {
    private ArrayList<M_WorkerInfo> wInfos = new ArrayList<>();

    @Override
    public int getCount() {
        return wInfos.size();
    }

    @Override
    public M_WorkerInfo getItem(int position) {
        return wInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context=parent.getContext();
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.listview_worker,parent,false);
        }

        TextView tv_company=(TextView)convertView.findViewById(R.id.tv_company);
        TextView tv_ID=(TextView)convertView.findViewById(R.id.tv_ID);
        TextView tv_isSafe=(TextView)convertView.findViewById(R.id.tv_isSafe);

        M_WorkerInfo wInfo=getItem(position);

        tv_company.setText(wInfo.getCompany());
        tv_ID.setText(wInfo.getID());

        String ox="";
        if(wInfo.isIs_safe()) ox="O";
        else ox="X";
        tv_isSafe.setText(ox);

        return convertView;
    }
    public void addItem(String company, String ID, boolean is_safe){
        M_WorkerInfo wInfo=new M_WorkerInfo();

        wInfo.setCompany(company);
        wInfo.setID(ID);
        wInfo.setIs_safe(is_safe);

        wInfos.add(wInfo);
    }
}
