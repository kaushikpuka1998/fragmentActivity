package com.example.fragmentactivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link filtertFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class filtertFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public filtertFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment filtertFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static filtertFragment newInstance(String param1, String param2) {
        filtertFragment fragment = new filtertFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    int date,month,year;
    Calendar calender;
    DatePickerDialog datePickerDialog;
    TextView Start,end,arrow;
    Spinner spinner;
    RadioGroup rbg;
    Button filter1,filter2;
    ResultFragment resultFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_filtert, container, false);

        Start = v.findViewById(R.id.startDate);
        end = v.findViewById(R.id.Enddate);
        spinner = v.findViewById(R.id.spinner);
        arrow = v.findViewById(R.id.arrow);
        rbg = v.findViewById(R.id.rbg);
        filter1 = v.findViewById(R.id.filter);
        filter2 = v.findViewById(R.id.filter2);
        resultFragment = new ResultFragment();




        filter1.setOnClickListener(new View.OnClickListener() {
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

        filter2.setOnClickListener(new View.OnClickListener() {
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

      spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              if(parent.getItemAtPosition(position).equals("Price"))
              {
                  Start.setVisibility(View.INVISIBLE);
                  arrow.setVisibility(View.INVISIBLE);
                  end.setVisibility(View.INVISIBLE);
                  rbg.setVisibility(View.VISIBLE);
                  filter2.setVisibility(View.INVISIBLE);
              }else
              {
                  Start.setVisibility(View.VISIBLE);
                  arrow.setVisibility(View.VISIBLE);
                  end.setVisibility(View.VISIBLE);
                  rbg.setVisibility(View.INVISIBLE);
                  filter2.setVisibility(View.VISIBLE);
              }
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
      });

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calender = Calendar.getInstance();
                year = calender.get(Calendar.YEAR);
                month = calender.get(Calendar.MONTH);
                date = calender.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Start.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                    }
                },date,month,year);
                datePickerDialog.show();
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calender = Calendar.getInstance();
                year = calender.get(Calendar.YEAR);
                month = calender.get(Calendar.MONTH);
                date = calender.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        end.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                    }
                },date,month,year);
                datePickerDialog.show();
            }
        });
        return v;
    }
    private void  SetFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe2,fragment);
        fragmentTransaction.commit();
    }

}
