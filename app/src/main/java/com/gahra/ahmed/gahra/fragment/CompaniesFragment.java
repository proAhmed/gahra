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
import com.gahra.ahmed.gahra.adapter.CompanyAdapter;
import com.gahra.ahmed.gahra.adapter.FeaturedAdapter;
import com.gahra.ahmed.gahra.api.GetCompanies;
import com.gahra.ahmed.gahra.api.GetHomeFeatured;
import com.gahra.ahmed.gahra.controller.OnRecycleClick;
import com.gahra.ahmed.gahra.controller.Utility;
import com.gahra.ahmed.gahra.interfaces.OnLoadingComplete;
import com.gahra.ahmed.gahra.model.CompaniesMain;
import com.gahra.ahmed.gahra.model.CompaniesModel;
import com.gahra.ahmed.gahra.model.FeaturedMain;

import java.util.ArrayList;

/**
 * Created by ahmed on 1/12/2017.
 */
public class CompaniesFragment extends Fragment implements OnRecycleClick {

    RecyclerView reCompanies;
    OnLoadingComplete onLoadingComplete;
    ArrayList<CompaniesModel> arrayList;
    OnRecycleClick onRecycleClick;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.companies_fragment,container,false);
        init(view);

        addData();
        return view;
    }

    private void init(View view){
        reCompanies = (RecyclerView) view.findViewById(R.id.reFeatured);
        reCompanies.setLayoutManager(new LinearLayoutManager(getActivity()));
        arrayList = new ArrayList<>();
        onRecycleClick = this;
    }

    private void addData(){
        if (Utility.isNetworkConnected(getActivity())) {
            onLoadingComplete = new OnLoadingComplete() {
                @Override
                public void onSuccess(Object object) {
                    CompaniesMain featuredMain = (CompaniesMain) object;
                    arrayList = featuredMain.getData();
                    reCompanies.setAdapter(new CompanyAdapter(getActivity(),arrayList,onRecycleClick));
                }

                @Override
                public void onFailure() {

                }
            };

            GetCompanies task= new  GetCompanies(getActivity(), onLoadingComplete);
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
