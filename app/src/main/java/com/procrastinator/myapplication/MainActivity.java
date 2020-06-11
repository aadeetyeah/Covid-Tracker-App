package com.procrastinator.myapplication;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    ChipNavigationBar navBar;
    FragmentManager fragmentManager;
    List<CasesData> casesData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        Api api=retrofit.create(Api.class);

        Call<List<CasesData>> call2=api.getCasesData();
        call2.enqueue(new Callback<List<CasesData>>() {
            @Override
            public void onResponse(Call<List<CasesData>> call, Response<List<CasesData>> response) {
                if(!response.isSuccessful()){
                    Log.d("Code:", String.valueOf(response.code()));
                    return;
                }
                casesData=response.body();

                for (CasesData d:casesData){
                    Log.d("Country:",d.getCountry());
                    }
                }

            @Override
            public void onFailure(Call<List<CasesData>> call, Throwable t) {
                Log.e("Error",t.getMessage());
            }
        });

         navBar=findViewById(R.id.bottom_nav);

        if(savedInstanceState==null) {
            navBar.setItemSelected(R.id.home,true);
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container
                            , new HomeFragment())
                    .commit();
        }


        navBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment frag=null;
                switch (id){
                    case R.id.home:
                        frag=new HomeFragment();
                       Bundle bundle1 =new Bundle();
                       bundle1.putParcelableArrayList("key", (ArrayList<? extends Parcelable>) casesData);
                       frag.setArguments(bundle1);
                        setTitle("Coronavirus Stat");
                        break;
                    case R.id.discover:
                        frag=new MapsFragment();
                        Bundle bundle2 =new Bundle();
                        bundle2.putParcelableArrayList("key", (ArrayList<? extends Parcelable>) casesData);
                        frag.setArguments(bundle2);
                        setTitle("Coronavirus Stat");
                        break;
                    case R.id.about:
                        frag=new AboutFragment();
                        setTitle("Contact me");
                        break;
                    /*default:
                        frag=new HomeFragment();
                        break; */

                }
                if(frag!=null){
                    fragmentManager=getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container,frag).commit();
                }else{
                    Log.e(TAG,"Error in creating fragment");
                }
            }
        });



    }
}
