package com.gymapp.gymapp.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.gymapp.gymapp.R;
import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExercisesFragment extends Fragment {


    public ExercisesFragment() {
        // Required empty public constructor
    }

    GridView gridViewExercise;
    QuickAdapter<String> adapter;
    ArrayList<String> arrayList;
    void initControl(final View view){
        gridViewExercise = (GridView) view.findViewById(R.id.gridViewExercise);
        arrayList = new ArrayList<>();
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        arrayList.add("asdsada");
        adapter = new QuickAdapter<String>(view.getContext(),R.layout.list_item) {
            @Override
            protected void convert(BaseAdapterHelper helper, String item) {
                helper.setText(R.id.lblListItem,"gia tri tu model");

                helper.setOnClickListener(R.id.lblListItem, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(view.getContext(), "OK", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };// dùng cái helper để inflalàte như ông nói
        adapter.addAll(arrayList);
        gridViewExercise.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_exercises, container, false);
        initControl(view);
        return view;
    }

}
