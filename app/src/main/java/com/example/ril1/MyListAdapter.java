package com.example.ril1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    List<LogRecord> listdata=new ArrayList<>();
    Context context1 ;
    public MyListAdapter(Context context) {
        this.context1 = context;
    }

    // RecyclerView recyclerView;
    public MyListAdapter(List<LogRecord> listdata,Context context) {
        this.listdata = listdata;
        this.context1 = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final LogRecord myListData = listdata.get(position);
        holder.t1.setText("Updated time "+listdata.get(position).time+" "+listdata.get(position).updatername+" "+listdata.get(position).updateremail);
        holder.t2.setText("Dry flue gas loss is "+Double.toString(listdata.get(position).DFGLP));
        holder.t3.setText("Wet flue gas loss is "+Double.toString(listdata.get(position).WFGLP));
        holder.t4.setText("Sensible heat in water vapour loss is "+Double.toString(listdata.get(position).SHWVLP));
        holder.t5.setText("Unburnt gas loss is "+Double.toString(listdata.get(position).UGLP));
        holder.t6.setText("Combstiable in ash is "+Double.toString(listdata.get(position).CAP));
        holder.t7.setText("Moisture in comustion air is"+Double.toString(listdata.get(position).MCAP));
        holder.t8.setText("Radiation loss is "+Double.toString(listdata.get(position).RLP));
        holder.t10.setText("Boiler efficiency is"+Double.toString(listdata.get(position).Efficiency));
        holder.t9.setText("Total loss is "+Double.toString(listdata.get(position).totalloss));


        holder.t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item:1 ",Toast.LENGTH_LONG).show();
             //   Uri uri = Uri.parse(myListData.getLink()); // missing 'http://' will cause crashed

            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView t1;
        public TextView t2;
        public TextView t3;
        public TextView t4;
        public TextView t5;
        public TextView t6;
        public TextView t7;
        public TextView t8;
        public TextView t9;
        public TextView t10;
        final Context context ;
        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            this.t1 = (TextView) itemView.findViewById(R.id.t1);
            this.t2 = (TextView) itemView.findViewById(R.id.t2);
            this.t3 = (TextView) itemView.findViewById(R.id.t3);
            this.t4 = (TextView) itemView.findViewById(R.id.t4);
            this.t5 = (TextView) itemView.findViewById(R.id.t5);
            this.t6 = (TextView) itemView.findViewById(R.id.t6);
            this.t7 = (TextView) itemView.findViewById(R.id.t7);
            this.t8 = (TextView) itemView.findViewById(R.id.t8);
            this.t9 = (TextView) itemView.findViewById(R.id.t9);
            this.t10 = (TextView) itemView.findViewById(R.id.t10);

        }
    }
}
