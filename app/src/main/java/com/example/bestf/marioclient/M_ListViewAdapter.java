package com.example.bestf.marioclient;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.renderscript.Sampler;
import android.support.annotation.ColorInt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    public View getView(int position, View convertView, final ViewGroup parent) {
        Context context=parent.getContext();
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.listview_worker,parent,false);
        }

        TextView tv_company=(TextView)convertView.findViewById(R.id.tv_company);
        TextView tv_ID=(TextView)convertView.findViewById(R.id.tv_ID);
        //TextView tv_isSafe=(TextView)convertView.findViewById(R.id.tv_isSafe);
        Button btn_is_safe=(Button)convertView.findViewById(R.id.btn_warning);
        btn_is_safe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //worker에게 경고 보내기
                Toast.makeText(parent.getContext(),"경고다!!!",Toast.LENGTH_SHORT).show();
            }
        });


        M_WorkerInfo wInfo=getItem(position);

        tv_company.setText(wInfo.getCompany());
        tv_ID.setText(wInfo.getID());
        if(wInfo.isIs_safe()){
            btn_is_safe.setClickable(false);
            btn_is_safe.setBackgroundColor(Color.parseColor("#646464"));
            btn_is_safe.setTextColor(Color.parseColor("#979797"));
            btn_is_safe.setText("안전");
        }
        else{
            btn_is_safe.setClickable(true);
            btn_is_safe.setBackgroundColor(Color.parseColor("#ff3333"));
            btn_is_safe.setTextColor(Color.parseColor("#000000"));
            btn_is_safe.setText("경고");
        }
        //tv_isSafe.setText(ox);

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
