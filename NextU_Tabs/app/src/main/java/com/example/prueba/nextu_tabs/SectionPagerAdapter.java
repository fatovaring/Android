package com.example.prueba.nextu_tabs;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

/**
 * Created by PRUEBA on 24/06/2016.
 */
public class SectionPagerAdapter extends FragmentPagerAdapter {
    private Context mainContext;

    public SectionPagerAdapter(FragmentManager supportFragmentManager, Context context) {
        super(supportFragmentManager);
        mainContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return MainActivityFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position){
        Locale l = Locale.getDefault();
        if(mainContext != null) {
            switch (position) {
                case 0: {
                    return mainContext.getString(R.string.section_1);
                }
                case 1: {
                    return mainContext.getString(R.string.section_2);
                }
                case 2: {
                    return mainContext.getString(R.string.section_3);
                }
            }
        }

        return null;
    }
}
