package com.gymapp.gymapp.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gymapp.gymapp.Fragment.ExercisesFragment;
import com.gymapp.gymapp.Fragment.NewFeedFragment;
import com.gymapp.gymapp.Fragment.NotificationFragment;
import com.gymapp.gymapp.Fragment.NutritiousFoodFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> listFragment = new ArrayList<Fragment>();
    List<String> titleFragment = new ArrayList<String>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        listFragment.add(new ExercisesFragment());
        listFragment.add(new NewFeedFragment());
        listFragment.add(new NotificationFragment());
        listFragment.add(new NutritiousFoodFragment());

        titleFragment.add("Exercises");
        titleFragment.add("NewFeedFragment");
        titleFragment.add("Notification");
        titleFragment.add("NutritiousFood");

    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleFragment.get(position);
    }
}
