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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by ahmed on 7/19/2016.
 */
public class CategoryAdapter extends RecyclerView
        .Adapter<CategoryAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
     private ArrayList<BusniessModel> mDataset;
     Activity context;
    OnRecycleClick onCategoryClick;
     public static class DataObjectHolder extends RecyclerView.ViewHolder
    {
        CircularImageView imgCategory;
        TextView tvCategory;
        public DataObjectHolder(View itemView) {
            super(itemView);
            imgCategory = (CircularImageView) itemView.findViewById(R.id.imgCategory);
            tvCategory  = (TextView) itemView.findViewById(R.id.tvCategory);
            Log.i(LOG_TAG, "Adding Listener");
        }
    }

    public CategoryAdapter(ArrayList<BusniessModel> myDataset, Activity context, OnRecycleClick onCategoryClick) {
        this.mDataset = myDataset;
        this.context = context;
        this.onCategoryClick = onCategoryClick;

    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_items, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(final DataObjectHolder holder, final int position) {

          //   Picasso.with(context).load("http://vente1paris.com/API/fr/general/thumb?url=" + mDataset.get(position).getPicture() + "&width=160&height=120").into(holder.imgCategory);


            holder.imgCategory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCategoryClick.onRecycleClick(position);
                }
            });

            holder.tvCategory.setText(mDataset.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
