package com.gahra.ahmed.gahra.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gahra.ahmed.gahra.R;
import com.gahra.ahmed.gahra.controller.OnRecycleClick;
import com.gahra.ahmed.gahra.model.BusniessModel;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;


/**
 * Created by ahmed on 7/19/2016.
 */
public class SubCategoryAdapter extends RecyclerView
        .Adapter<SubCategoryAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
     private ArrayList<BusniessModel> mDataset;
     Activity context;
    OnRecycleClick onCategoryClick;
     public static class DataObjectHolder extends RecyclerView.ViewHolder
    {
        CircularImageView imgLogo;
        ImageView imgProduct,imgFeatured,imgFav;
        TextView tvCategory;
        public DataObjectHolder(View itemView) {
            super(itemView);
            imgLogo = (CircularImageView) itemView.findViewById(R.id.imgLogo);
            tvCategory  = (TextView) itemView.findViewById(R.id.tvCategory);
            imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);
            imgFeatured = (ImageView) itemView.findViewById(R.id.imgFeatured);
            imgFav = (ImageView) itemView.findViewById(R.id.imgFav);
        }
    }

    public SubCategoryAdapter(ArrayList<BusniessModel> myDataset, Activity context, OnRecycleClick onCategoryClick) {
        this.mDataset = myDataset;
        this.context = context;
        this.onCategoryClick = onCategoryClick;

    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(final DataObjectHolder holder, final int position) {

          //   Picasso.with(context).load("http://vente1paris.com/API/fr/general/thumb?url=" + mDataset.get(position).getPicture() + "&width=160&height=120").into(holder.imgCategory);


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
        holder.imgFeatured.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imgFeatured.setImageResource(R.drawable.featured);
            }
        });
            holder.tvCategory.setText(mDataset.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
