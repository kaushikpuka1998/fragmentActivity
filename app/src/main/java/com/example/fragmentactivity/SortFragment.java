package com.example.fragmentactivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SortFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SortFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SortFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SortFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SortFragment newInstance(String param1, String param2) {
        SortFragment fragment = new SortFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private void  SetFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe2,fragment);
        fragmentTransaction.commit();
    }
    Button save;
    filtertFragment filtertFragment;
    ResultFragment resultFragment;
    RadioGroup radioGroup;
    RadioButton price,rank,date;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sort, container, false);
        save = v.findViewById(R.id.save);
        radioGroup = v.findViewById(R.id.radiogroup);
        filtertFragment = new filtertFragment();
        resultFragment = new ResultFragment();



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(getContext());
                progressDialog.show();
                progressDialog.setMessage("Being Prepared");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        }catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();
                        SetFragment(resultFragment);
                    }
                }).start();
                progressDialog.show();



            }
        });
        return v;
    }
}
