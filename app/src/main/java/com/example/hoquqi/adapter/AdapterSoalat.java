package com.example.hoquqi.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoquqi.ActivityJoziat;
import com.example.hoquqi.ActivityRezomeh;
import com.example.hoquqi.R;
import com.example.hoquqi.model.Moshaver;
import com.example.hoquqi.model.Soal;

import java.util.ArrayList;

public class AdapterSoalat extends RecyclerView.Adapter<AdapterSoalat.MyViewHolder> {

    private Context context;
    private ArrayList<Soal> arrayList;
//    public static Boolean flag_moshaver = false;

    public AdapterSoalat(Context context, ArrayList<Soal> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    /*1.how to show xml*/
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_soalat, viewGroup, false);
        return new MyViewHolder(view);
    }

    /*2.how to set data to items*/
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        /*set data to objects items*/
        holder.txtSoal.setText(arrayList.get(position).getText());

        /*4.click on item recycler*/
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*intent item datas to ActivityJoziat */
                int pos=position;
                Intent intent = new Intent(context, ActivityJoziat.class);
                intent.putExtra("soaltext", arrayList.get(position).getText());
                intent.putExtra("pos", pos);

                Toast.makeText(view.getContext(),Integer.toString(pos),Toast.LENGTH_LONG).show();

//                if(pos==0){
//                    intent.putExtra("pos",0);
//                }
//                else if(pos==1){
//                    intent.putExtra("pos",1);
//                }
//                else if(pos==2){
//                    intent.putExtra("pos",2);
//                }
//                else if(pos==3){
//                    intent.putExtra("pos",3);
//                }
//                else if(pos==4){
//                    intent.putExtra("pos",4);
//                }
//                else if(pos==5){
//                    intent.putExtra("pos",5);
//                }
//                else if(pos==6){
//                    intent.putExtra("pos",6);
//                }
//                else if(pos==7){
//                    intent.putExtra("pos",7);
//                }
//                else if(pos==8){
//                    intent.putExtra("pos",8);
//                }
                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    /*5.create and linked object with xml file*/
    public class MyViewHolder extends RecyclerView.ViewHolder {

        /*create object for xml*/
        TextView txtSoal;
        RelativeLayout layout;

        public MyViewHolder(View itemView) {
            super(itemView);

            /* Get object from xml file*/
            txtSoal = itemView.findViewById(R.id.txt_soal);
            layout = itemView.findViewById(R.id.item_layout_soal);
        }
    }
}
