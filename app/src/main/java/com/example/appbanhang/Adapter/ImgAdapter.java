package com.example.appbanhang.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanhang.Models.AppImg;
import com.example.appbanhang.R;

import java.util.ArrayList;

public class ImgAdapter extends RecyclerView.Adapter<ImgAdapter.ViewHoler>{
    private Context context;
    private ArrayList<AppImg> list;

    public ImgAdapter(Context context, ArrayList<AppImg> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_img,parent,false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        AppImg appImg=list.get(position);
        if(appImg == null){
            return;
        }
        holder.imageView.setImageResource(appImg.getImage());
    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    public class ViewHoler extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_View);
        }
    }
}
