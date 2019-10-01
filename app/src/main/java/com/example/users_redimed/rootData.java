package com.example.users_redimed;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class rootData extends ViewModel {
    private MutableLiveData<String> users;
    private int ci = 0;

    public int getCi() {
        return ci;
    }
    public void tCi() {
        this.ci = this.ci+1;
    }



    public String getUsers() {

        return "Nghĩa yêu thiên văn học";
    }



}
