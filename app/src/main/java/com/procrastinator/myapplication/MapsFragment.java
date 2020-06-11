package com.procrastinator.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.Layer;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    List<CasesData> casesData;
    ArrayList<CountryInfo> cntyInfo;
    ArrayList<CasesData> caseDat;
    View fragLayout;
    MapView mapView;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MapsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapsFragment newInstance(String param1, String param2) {
        MapsFragment fragment = new MapsFragment();
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
        Mapbox.getInstance(getActivity(),getString(R.string.access_token));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragLayout=inflater.inflate(R.layout.fragment_maps, container, false);
        cntyInfo=new ArrayList<CountryInfo>();
        caseDat=new ArrayList<CasesData>();
        Bundle bundle=getArguments();
        if(bundle!=null) {
            casesData = bundle.getParcelableArrayList("key");
            for (CasesData d:casesData) {
                caseDat.add(d);
                cntyInfo.add(d.getCountryInfo());
                Log.d("Country Map:", d.getCountry());
            }
        }
        return fragLayout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView=(MapView)view.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {
                mapboxMap.setStyle(Style.DARK, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {

                        // Map is set up and the style has loaded. Now you can add data or make other map adjustments
                        for(int i=0;i<cntyInfo.size() ;i++){
                            Log.d("LatLng: ",Double.toString(cntyInfo.get(i).getLat()));
                            Log.d("Country on map: ",caseDat.get(i).getCountry()+": "+Integer.toString(caseDat.get(i).getActive()));
                            //Log.d("Active",Integer.toString(casesData.get(cntyInfo.indexOf(i.getLat())).getActive()));
                            mapboxMap.addMarker(new MarkerOptions()
                                    .position(new LatLng(cntyInfo.get(i).getLat(), cntyInfo.get(i).getLongt()))
                                    .title("Total: "+casesData.get(i).getCases() +"\nActive: "+ casesData.get(i).getActive()+"\nRecovered: "+casesData.get(i).getRecovered()+"\nDeath: "+casesData.get(i).getDeaths()));
                        }

                    }
                });
            }
        });


    }
}
