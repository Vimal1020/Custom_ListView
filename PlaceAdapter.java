package com.example.proj;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class PlaceAdapter extends ArrayAdapter<players> {
    Context mc;
    int lay;
    players mData[]=null;


    public PlaceAdapter(@NonNull Context context, int resource, @NonNull players[] data) {
        super(context,resource,data);
        this.mc=context;
        this.lay=resource;
        this.mData=data;
    }

    @Override
    public players getItem(int position) {
        return super.getItem(position);
    }
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        View row = convertView;
        playerholder holder = null;
        if (row == null){
        LayoutInflater inflater = LayoutInflater.from(mc);
        row = inflater.inflate(lay, parent, false);
        holder=new playerholder();
        holder.n = (TextView) row.findViewById(R.id.n);
        holder.h = (TextView) row.findViewById(R.id.h);
        holder.im = (ImageView) row.findViewById(R.id.image);
        holder.a= (TextView) row.findViewById(R.id.a);
        holder.s = (TextView) row.findViewById(R.id.s);
        holder.na = (TextView) row.findViewById(R.id.na);
        row.setTag(holder);
        }
        else{
            holder=(playerholder) row.getTag();
            }
        players players = mData[position];
        holder.im.setOnClickListener(PopupListener);
        Integer rowp=position;
        holder.im.setTag(rowp);
        holder.n.setText(players.name);
        holder.h.setText(String.valueOf(players.height));
        holder.a.setText(String.valueOf(players.age));
        holder.s.setText(String.valueOf(players.salary));
        holder.na.setText(players.nationality);
        int resId=mc.getResources().getIdentifier(players.img,"drawable",mc.getOpPackageName());
        holder.im.setImageResource(resId);
        return row;
        }
        private View.OnClickListener PopupListener=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Integer pos=(Integer) v.getTag();
                players p=mData[pos];
                Toast.makeText(getContext(),p.name,Toast.LENGTH_SHORT).show();
            }
        };

private static  class playerholder{
        TextView n;
        TextView h;
        TextView a;
        TextView s;
        TextView na;
        ImageView im;
}
}
