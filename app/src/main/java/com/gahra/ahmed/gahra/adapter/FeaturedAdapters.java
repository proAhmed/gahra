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
import com.gahra.ahmed.gahra.model.FeaturedModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by ahmed on 7/19/2016.
 */
public class FeaturedAdapters extends RecyclerView
        .Adapter<FeaturedAdapters
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
     private ArrayList<FeaturedModel> mDataset;
     Activity context;
    OnRecycleClick onCategoryClick;
     public static class DataObjectHolder extends RecyclerView.ViewHolder
    {
        ImageView imgFavorite,imgFeatured;
        TextView tvStart,tvEnd;
        public DataObjectHolder(View itemView) {
            super(itemView);
            imgFeatured = (ImageView) itemView.findViewById(R.id.imgFeatured);
            imgFavorite = (ImageView) itemView.findViewById(R.id.imgFavorite);
            tvStart  = (TextView) itemView.findViewById(R.id.tvStart);
            tvEnd  = (TextView) itemView.findViewById(R.id.tvEnd);
            Log.i(LOG_TAG, "Adding Listener");
        }
    }

    public FeaturedAdapters(Activity context, ArrayList<FeaturedModel> myDataset, OnRecycleClick onCategoryClick) {
        this.mDataset = myDataset;
        this.context = context;
        this.onCategoryClick = onCategoryClick;

    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.featured_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(final DataObjectHolder holder, final int position) {

            Picasso.with(context).load("http://aljahrashop.com/API/ar/general/thumb?url=" + mDataset.get(position).getPicture() + "&width=160&height=120").into(holder.imgFeatured);


            holder.imgFeatured.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCategoryClick.onRecycleClick(position);
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
