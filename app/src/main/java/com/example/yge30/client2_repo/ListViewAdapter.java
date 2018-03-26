package com.example.yge30.client2_repo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yge30 on 2018-03-26.
 */

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<WorkerInfo> wInfos = new ArrayList<>();

    @Override
    public int getCount() {
        return wInfos.size();
    }

    @Override
    public WorkerInfo getItem(int position) {
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

        WorkerInfo wInfo=getItem(position);

        tv_company.setText(wInfo.getCompany());
        tv_ID.setText(wInfo.getID());

        String ox="";
        if(wInfo.isIs_safe()) ox="O";
        else ox="X";
        tv_isSafe.setText(ox);

        return convertView;
    }
    public void addItem(String company, String ID, boolean is_safe){
        WorkerInfo wInfo=new WorkerInfo();

        wInfo.setCompany(company);
        wInfo.setID(ID);
        wInfo.setIs_safe(is_safe);

        wInfos.add(wInfo);
    }
}

