package com.actionbarapp.actionbarapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.nio.charset.Charset;
import java.util.Locale;

/**
 * Created by PRUEBA on 21/06/2016.
 */
public class SectionPagerAdapter extends FragmentPagerAdapter {
    public SectionPagerAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return MainActivityFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence setPageTitle(int position, Context ctx){
        Locale l = Locale.getDefault();

        switch (position){
            case 0: {
                return ctx.getString(R.string.section_1);
            }
            case 1: {
                return ctx.getString(R.string.section_2);
            }
            case 2: {
                return ctx.getString(R.string.section_3);
            }
        }

        return null;
    }
}
