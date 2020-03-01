package com.example.hoquqi.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hoquqi.model.ChosoeTabs;

import java.util.ArrayList;
import java.util.List;

public class viewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> frgList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();
    ChosoeTabs chosoeTabs = new ChosoeTabs();

    public viewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return frgList.get(position);
    }

    @Override
    public int getCount() {
        return titleList.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);

    }

    public void addFrg(Fragment frg, String title) {
        frgList.add(frg);
        titleList.add(title);
    }

}
