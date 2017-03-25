package com.gahra.ahmed.gahra.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gahra.ahmed.gahra.R;
import com.gahra.ahmed.gahra.adapter.FeaturedAdapter;
import com.gahra.ahmed.gahra.api.GetHomeFeatured;
import com.gahra.ahmed.gahra.controller.OnRecycleClick;
import com.gahra.ahmed.gahra.controller.Utility;
import com.gahra.ahmed.gahra.interfaces.OnLoadingComplete;
import com.gahra.ahmed.gahra.model.FeaturedMain;
import com.gahra.ahmed.gahra.model.FeaturedModel;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

/**
 * Created by ahmed on 1/12/2017.
 */
public class FeaturedDetails extends Fragment implements OnRecycleClick{

    RecyclerView reFeatured;
    ImageView imgCall,imgShare,imgView;
    Button btnFollowing;
    TextView tvFeaturedTitle,tvFeaturedFollowers;
    CircularImageView busniessImage;
    ArrayList<FeaturedModel>arrayList;
    OnLoadingComplete onLoadingComplete;
    OnRecycleClick onRecycleClick;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.featured,container,false);
        init(view);
        onRecycleClick = this;
        return view;
    }

    private void init(View view){
        arrayList = new ArrayList<>();
        imgCall = (ImageView) view.findViewById(R.id.imgCall);
        imgShare = (ImageView) view.findViewById(R.id.imgShare);
        imgView = (ImageView) view.findViewById(R.id.imgView);
        btnFollowing = (Button) view.findViewById(R.id.btnFollowing);
        tvFeaturedTitle = (TextView) view.findViewById(R.id.tvFeaturedTitle);
        tvFeaturedFollowers = (TextView) view.findViewById(R.id.tvFeaturedFollowers);
        busniessImage = (CircularImageView) view.findViewById(R.id.busniessImage);

        reFeatured = (RecyclerView) view.findViewById(R.id.reFeatured);
        reFeatured.setLayoutManager(new LinearLayoutManager(getActivity()));
        addData();
    }

    private void addData(){
        if (Utility.isNetworkConnected(getActivity())) {

            onLoadingComplete = new OnLoadingComplete() {
                @Override
                public void onSuccess(Object object) {
                    FeaturedMain featuredMain = (FeaturedMain) object;
                    arrayList = featuredMain.getData();
                    reFeatured.setAdapter(new FeaturedAdapter(getActivity(),arrayList,onRecycleClick));
                }

                @Override
                public void onFailure() {

                }

            };

            GetHomeFeatured task= new  GetHomeFeatured(getActivity(), onLoadingComplete);
            task.execute();

        }else{
            Utility.showValidateDialog(
                    getResources().getString(R.string.failure_ws),
                    getActivity());
        }
        }

    @Override
    public void onRecycleClick(int pos) {

    }
}
