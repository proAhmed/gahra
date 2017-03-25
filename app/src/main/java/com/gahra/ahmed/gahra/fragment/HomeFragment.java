package com.gahra.ahmed.gahra.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gahra.ahmed.gahra.R;
import com.gahra.ahmed.gahra.adapter.FeaturedAdapter;
import com.gahra.ahmed.gahra.adapter.HomeAdapter;
import com.gahra.ahmed.gahra.api.GetHomeFeatured;
import com.gahra.ahmed.gahra.controller.OnRecycleClick;
import com.gahra.ahmed.gahra.controller.Utility;
import com.gahra.ahmed.gahra.interfaces.OnLoadingComplete;
import com.gahra.ahmed.gahra.model.BusniessModel;
import com.gahra.ahmed.gahra.model.FeaturedMain;
import com.gahra.ahmed.gahra.model.FeaturedModel;

import java.util.ArrayList;

/**
 * Created by ahmed on 1/12/2017.
 */
public class HomeFragment extends Fragment implements OnRecycleClick{

    RecyclerView reHome;
    ArrayList<FeaturedModel> arrayList;
    OnLoadingComplete onLoadingComplete;
    OnRecycleClick onRecycleClick;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment,container,false);
        init(view);
        onRecycleClick = this;
        return view;
    }

    private void init(View view){
        arrayList = new ArrayList<>();
        reHome = (RecyclerView) view.findViewById(R.id.reHome);
        reHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        addData();
        reHome.setAdapter(new HomeAdapter(getActivity(),arrayList,this));
    }



    private void addData(){
        if (Utility.isNetworkConnected(getActivity())) {

            onLoadingComplete = new OnLoadingComplete() {
                @Override
                public void onSuccess(Object object) {
                    FeaturedMain featuredMain = (FeaturedMain) object;
                    arrayList = featuredMain.getData();
                    reHome.setAdapter(new HomeAdapter(getActivity(),arrayList,onRecycleClick));
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
