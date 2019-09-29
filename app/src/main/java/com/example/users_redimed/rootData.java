package com.example.users_redimed;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class rootData extends ViewModel {
    private MutableLiveData<String> users;
    public String getUsers() {

        return "Nghĩa yêu thiên văn học";
    }



}
