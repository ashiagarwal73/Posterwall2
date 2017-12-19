package com.example.ashi.posterwall;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int tabCount;
    public PagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                EventsFragment eventsFragment = new EventsFragment();
                return eventsFragment;
            case 1:
                SocietyFragment societyFragment = new SocietyFragment();
                return societyFragment;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabText[position];
    }
    String[] tabText = new String[]{"EVENTS","SOCIETY"};
}
