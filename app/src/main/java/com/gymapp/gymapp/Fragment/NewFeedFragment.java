package com.gymapp.gymapp.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gymapp.gymapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewFeedFragment extends Fragment {


    public NewFeedFragment() {
        // Required empty public constructor
        super();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_feed, container, false);
    }

}
