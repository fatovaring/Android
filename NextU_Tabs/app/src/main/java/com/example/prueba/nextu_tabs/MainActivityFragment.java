package com.example.prueba.nextu_tabs;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "numero_seccion";

    public MainActivityFragment() {
    }

    public static MainActivityFragment newInstance(int sectionNumber) {
        MainActivityFragment fragment = new MainActivityFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        if(args != null) {
            TextView textView = (TextView) rootView.findViewById(R.id.section);
            textView.setText("Section Content: " + Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
        }

        return rootView;
    }
}
