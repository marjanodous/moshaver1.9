package com.example.hoquqi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoquqi.R;
import com.example.hoquqi.model.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    List<Item>itemList;
    Context mContext;

    public ItemAdapter(List<Item>itemList, Context mContext){
        this.itemList = itemList;
        this.mContext = mContext;
    }

    /*1.how to show xml*/
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View aView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(aView);
    }

    /*2.how to set data to items*/
    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {

        /*set data to objects items*/
        Item aItem = itemList.get(position);
        holder.aMessage.setText(aItem.getuMessage());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    /*3.create and linked object with xml file*/
    public class MyViewHolder extends RecyclerView.ViewHolder {

        /*create object for xml*/
        public TextView aMessage;


        public MyViewHolder(View itemView) {
            super(itemView);

            /* Get object from xml file*/
            aMessage = itemView.findViewById(R.id.aya_midanid);
        }
    }

}