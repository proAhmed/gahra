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

/**
 * Created by ahmed on 1/12/2017.
 */
public class FollowingFragment extends Fragment {

    RecyclerView reFollowing;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.following_fragment,container,false);
        init(view);
        return view;
    }

    private void init(View view){
        reFollowing = (RecyclerView) view.findViewById(R.id.reFollowing);
        reFollowing.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
