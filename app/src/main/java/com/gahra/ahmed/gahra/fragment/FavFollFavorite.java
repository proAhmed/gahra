package com.gahra.ahmed.gahra.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gahra.ahmed.gahra.R;

/**
 * Created by ahmed on 1/13/2017.
 */
public class FavFollFavorite extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,container,false);
        FragmentTabHost mTabHost = (FragmentTabHost) view.findViewById(R.id.tabhost);
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.frFollFav);

        mTabHost.addTab(mTabHost.newTabSpec("Following").setIndicator("Following"),
                FollowingFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("Favorite").setIndicator("Favorite"),
                FavoriteFragment.class, null);
        return view;
    }
}
