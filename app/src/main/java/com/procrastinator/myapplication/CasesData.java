package com.procrastinator.myapplication;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

class CountryInfo implements Parcelable
{
    private int _id;
    private String iso2;
    private String iso3;
    private double lat;
    @SerializedName("long")
    private double longt;
    private String flag;

    public CountryInfo(int _id, String iso2, String iso3, double lat, double longt, String flag) {
        this._id = _id;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.lat = lat;
        this.longt = longt;
        this.flag = flag;
    }

    protected CountryInfo(Parcel in) {
        _id = in.readInt();
        iso2 = in.readString();
        iso3 = in.readString();
        lat = in.readDouble();
        longt = in.readDouble();
        flag = in.readString();
    }


    public static final Creator<CountryInfo> CREATOR = new Creator<CountryInfo>() {
        @Override
        public CountryInfo createFromParcel(Parcel in) {
            return new CountryInfo(in);
        }

        @Override
        public CountryInfo[] newArray(int size) {
            return new CountryInfo[size];
        }
    };

    public int get_id() {
        return _id;
    }

    public String getIso2() {
        return iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public double getLat() {
        return lat;
    }

    public double getLongt() {
        return longt;
    }

    public String getFlag() {
        return flag;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_id);
        dest.writeString(iso2);
        dest.writeString(iso3);
        dest.writeDouble(lat);
        dest.writeDouble(longt);
        dest.writeString(flag);
    }
}

public class CasesData implements Parcelable
{


    private Object updated;
    private String country;
    public CountryInfo countryInfo;
    private int cases;
    private int todayCases;
    private int deaths;
    private int todayDeaths;
    private int recovered;
    private int active;
    private int critical;
    private double casesPerOneMillion;
    private double deathsPerOneMillion;
    private int tests;
    private int testsPerOneMillion;
    private int population;
    private String continent;
    private double activePerOneMillion;
    private double recoveredPerOneMillion;
    private double criticalPerOneMillion;
    public CasesData(Object updated, String country, CountryInfo countryInfo, int cases, int todayCases, int deaths, int todayDeaths, int recovered, int active, int critical, double casesPerOneMillion, double deathsPerOneMillion, int tests, int testsPerOneMillion, int population, String continent, double activePerOneMillion, double recoveredPerOneMillion, double criticalPerOneMillion) {
        this.updated = updated;
        this.country = country;
        this.countryInfo = countryInfo;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
        this.casesPerOneMillion = casesPerOneMillion;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.tests = tests;
        this.testsPerOneMillion = testsPerOneMillion;
        this.population = population;
        this.continent = continent;
        this.activePerOneMillion = activePerOneMillion;
        this.recoveredPerOneMillion = recoveredPerOneMillion;
        this.criticalPerOneMillion = criticalPerOneMillion;
    }

    protected CasesData(Parcel in) {
        country = in.readString();
        cases = in.readInt();
        todayCases = in.readInt();
        deaths = in.readInt();
        todayDeaths = in.readInt();
        recovered = in.readInt();
        active = in.readInt();
        critical = in.readInt();
        casesPerOneMillion = in.readDouble();
        deathsPerOneMillion = in.readDouble();
        tests = in.readInt();
        testsPerOneMillion = in.readInt();
        population = in.readInt();
        continent = in.readString();
        activePerOneMillion = in.readDouble();
        recoveredPerOneMillion = in.readDouble();
        criticalPerOneMillion = in.readDouble();
    }


    public static final Creator<CasesData> CREATOR = new Creator<CasesData>() {
        @Override
        public CasesData createFromParcel(Parcel in) {
            return new CasesData(in);
        }

        @Override
        public CasesData[] newArray(int size) {
            return new CasesData[size];
        }
    };

    public Object getUpdated() {
        return updated;
    }

    public String getCountry() {
        return country;
    }

    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    public int getCases() {
        return cases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public int getActive() {
        return active;
    }

    public int getCritical() {
        return critical;
    }

    public double getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public double getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public int getTests() {
        return tests;
    }

    public int getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public int getPopulation() {
        return population;
    }

    public String getContinent() {
        return continent;
    }

    public double getActivePerOneMillion() {
        return activePerOneMillion;
    }

    public double getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    public double getCriticalPerOneMillion() {
        return criticalPerOneMillion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(country);
        dest.writeInt(cases);
        dest.writeInt(todayCases);
        dest.writeInt(deaths);
        dest.writeInt(todayDeaths);
        dest.writeInt(recovered);
        dest.writeInt(active);
        dest.writeInt(critical);
        dest.writeDouble(casesPerOneMillion);
        dest.writeDouble(deathsPerOneMillion);
        dest.writeInt(tests);
        dest.writeInt(testsPerOneMillion);
        dest.writeInt(population);
        dest.writeString(continent);
        dest.writeDouble(activePerOneMillion);
        dest.writeDouble(recoveredPerOneMillion);
        dest.writeDouble(criticalPerOneMillion);
    }
}
