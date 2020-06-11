package com.procrastinator.myapplication;

import java.util.List;

public class Covid{
    private List<CasesData> casesData;
    public List<CasesData> getCasesData(){
        return casesData;
    }
    public void setCasesData(List<CasesData> ret){
        casesData=ret;
    }
}