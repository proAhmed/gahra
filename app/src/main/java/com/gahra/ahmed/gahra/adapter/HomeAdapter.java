package com.gahra.ahmed.gahra.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gahra.ahmed.gahra.R;
import com.gahra.ahmed.gahra.controller.OnRecycleClick;
import com.gahra.ahmed.gahra.model.BusniessModel;
import com.gahra.ahmed.gahra.model.FeaturedModel;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by ahmed on 7/19/2016.
 */
public class HomeAdapter extends RecyclerView
        .Adapter<HomeAdapter
        .DataObjectHolder> {
     private ArrayList<FeaturedModel> mDataset;
     Activity context;
    OnRecycleClick onCategoryClick;
     public static class DataObjectHolder extends RecyclerView.ViewHolder
    {
        CircularImageView imgLogo;
        ImageView imgProduct,imgFav;
        TextView tvCategory,tvStart,tvEnd;
        public DataObjectHolder(View itemView) {
            super(itemView);
            imgLogo = (CircularImageView) itemView.findViewById(R.id.imgLogo);
            tvCategory  = (TextView) itemView.findViewById(R.id.tvCategory);
            tvStart  = (TextView) itemView.findViewById(R.id.tvStart);
            tvEnd  = (TextView) itemView.findViewById(R.id.tvEnd);
            imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);
            imgFav = (ImageView) itemView.findViewById(R.id.imgFav);
        }
    }

    public HomeAdapter(Activity context, ArrayList<FeaturedModel> myDataset, OnRecycleClick onCategoryClick) {
        this.mDataset = myDataset;
        this.context = context;
        this.onCategoryClick = onCategoryClick;

    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_items, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(final DataObjectHolder holder, final int position) {

           Picasso.with(context).load("http://aljahrashop.com/API/ar/general/thumb?url=" + mDataset.get(position).getPicture() + "&width=400&height=500").into(holder.imgProduct);


            holder.imgProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCategoryClick.onRecycleClick(position);
                }
            });
        holder.imgFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imgFav.setImageResource(R.drawable.favorite_icon_1);
            }
        });

            holder.tvStart.setText(mDataset.get(position).getCreatedDate());
            holder.tvEnd.setText(mDataset.get(position).getFinishedDate());


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
