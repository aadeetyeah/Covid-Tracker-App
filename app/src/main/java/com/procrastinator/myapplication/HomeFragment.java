package com.procrastinator.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Spinner spinner;
    List<CasesData> casesData;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public HomeFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_home, container, false);

        //Confirmed
        TextView count = (TextView)v.findViewById(R.id.count);
        TextView todaycnt = (TextView)v.findViewById(R.id.todaycnt);

        //Active
        TextView acount = (TextView)v.findViewById(R.id.actCount);

        //Recovered
        TextView rcount=v.findViewById(R.id.recCount);

        //Death
        TextView dcount=v.findViewById(R.id.deadCount);
        TextView todaydcount=v.findViewById(R.id.todayDeadCnt);

        Bundle bundle=getArguments();
        if(bundle!=null) {

            casesData = bundle.getParcelableArrayList("key");
            ArrayList<CasesData> values1 = new ArrayList<CasesData>();
            ArrayList<String> values = new ArrayList<String>();
            for (CasesData d : casesData) {
                values1.add(d);
                values.add(d.getCountry());
                Log.d("Country Fragment:", d.getCountry());
            }
            spinner=v.findViewById(R.id.spinner);
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this.getActivity(), R.layout.support_simple_spinner_dropdown_item, values);
            spinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner.setAdapter(spinnerAdapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String itemValue = parent.getItemAtPosition(position).toString();
                    count.setText(""+values1.get(position).getCases());
                    todaycnt.setText(" + "+values1.get(position).getTodayCases()+" today");

                    acount.setText(""+values1.get(position).getActive());

                    rcount.setText(""+values1.get(position).getRecovered());

                    dcount.setText(""+values1.get(position).getDeaths());
                    todaydcount.setText(" + "+values1.get(position).getTodayDeaths()+" today");
                    Log.d("Pos: ",values1.get(position).getContinent());
                    Toast.makeText(parent.getContext(), itemValue, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }else{
            Toast.makeText(this.getActivity(),"WAIT for 5 Seconds...",Toast.LENGTH_SHORT).show();
        }
        return v;
    }
}
