package com.gahra.ahmed.gahra.start;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gahra.ahmed.gahra.R;
import com.gahra.ahmed.gahra.fragment.CompaniesFragment;
import com.gahra.ahmed.gahra.fragment.FeaturedFragment;
import com.gahra.ahmed.gahra.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    LinearLayout linHome,linFeatured,linCategories,linFavorite,linCompanies;
    ImageView imgFavorite,imgCategories,imgFeatured,imgHome,imgCompanies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.mains,new HomeFragment()).addToBackStack("").commit();
        declare();
        action();
    }
    private void declare(){
        linHome = (LinearLayout) findViewById(R.id.linHome);
        linFeatured = (LinearLayout) findViewById(R.id.linFeatured);
        linCategories = (LinearLayout) findViewById(R.id.linCategories);
        linCompanies = (LinearLayout) findViewById(R.id.linCompanies);
        linFavorite = (LinearLayout) findViewById(R.id.linFavorite);
        imgFavorite = (ImageView) findViewById(R.id.imgFavorite);
        imgCategories = (ImageView) findViewById(R.id.imgCategories);
        imgCompanies = (ImageView) findViewById(R.id.imgCompanies);
        imgFeatured = (ImageView) findViewById(R.id.imgFeatured);
        imgHome = (ImageView) findViewById(R.id.imgHome);
        imgHome.setImageResource(R.drawable.home_icon_1);

    }
    private void action(){
        linHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgHome.setImageResource(R.drawable.home_icon_1);
                imgFavorite.setImageResource(R.drawable.favorite_icon_2);
                imgFeatured.setImageResource(R.drawable.featured_icon_2);
                imgCategories.setImageResource(R.drawable.categories_icon_2);
                imgCompanies.setImageResource(R.drawable.companies_icon_2);
                getSupportFragmentManager().beginTransaction().add(R.id.mains,new HomeFragment()).addToBackStack("").commit();
            }
        });

        linFeatured.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgHome.setImageResource(R.drawable.home_icon_2);
                imgFavorite.setImageResource(R.drawable.favorite_icon_2);
                imgFeatured.setImageResource(R.drawable.featured_icon_1);
                imgCategories.setImageResource(R.drawable.categories_icon_2);
                imgCompanies.setImageResource(R.drawable.companies_icon_2);
                getSupportFragmentManager().beginTransaction().add(R.id.mains,new HomeFragment()).addToBackStack("").commit();
            }
        });

        linCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgHome.setImageResource(R.drawable.home_icon_2);
                imgFavorite.setImageResource(R.drawable.favorite_icon_2);
                imgFeatured.setImageResource(R.drawable.featured_icon_2);
                imgCategories.setImageResource(R.drawable.categories_icon_1);
                imgCompanies.setImageResource(R.drawable.companies_icon_2);
                getSupportFragmentManager().beginTransaction().add(R.id.mains,new HomeFragment()).addToBackStack("").commit();
            }
        });
        linCompanies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgHome.setImageResource(R.drawable.home_icon_2);
                imgFavorite.setImageResource(R.drawable.favorite_icon_2);
                imgFeatured.setImageResource(R.drawable.featured_icon_2);
                imgCategories.setImageResource(R.drawable.categories_icon_2);
                imgCompanies.setImageResource(R.drawable.companies_icon_1);
                getSupportFragmentManager().beginTransaction().add(R.id.mains,new CompaniesFragment()).addToBackStack("").commit();
            }
        });
        linFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgHome.setImageResource(R.drawable.home_icon_2);
                imgFavorite.setImageResource(R.drawable.favorite_icon_1);
                imgFeatured.setImageResource(R.drawable.featured_icon_2);
                imgCategories.setImageResource(R.drawable.categories_icon_2);
                imgCompanies.setImageResource(R.drawable.companies_icon_2);
            }
        });
    }
}
