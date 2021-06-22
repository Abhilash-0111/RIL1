package com.example.ril1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class InsAdapter extends RecyclerView.Adapter<InsAdapter.ViewHolder>{
    List<InsClass> listdata=new ArrayList<>();
    Context context1 ;
    public InsAdapter(Context context) {
        this.context1 = context;
    }

    // RecyclerView recyclerView;
    public InsAdapter(List<InsClass> listdata, Context context) {
        this.listdata = listdata;
        this.context1 = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.insrv, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final InsClass myListData = listdata.get(position);
        holder.t1.setText("Updated By "+listdata.get(position).getName());
        holder.t2.setText("  "+(listdata.get(position).getDetail()));
        holder.t3.setText((listdata.get(position).getInventory()));
        holder.t4.setText((listdata.get(position).getPicurl()));
        holder.t5.setText((listdata.get(position).getVurl()));


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

        final Context context ;
        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            this.t1 = (TextView) itemView.findViewById(R.id.t1);
            this.t2 = (TextView) itemView.findViewById(R.id.t2);
            this.t3 = (TextView) itemView.findViewById(R.id.t3);
            this.t4 = (TextView) itemView.findViewById(R.id.t4);
            this.t5 = (TextView) itemView.findViewById(R.id.t5);


        }
    }
}
