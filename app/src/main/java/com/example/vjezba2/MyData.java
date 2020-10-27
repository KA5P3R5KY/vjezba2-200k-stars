package com.example.vjezba2;

import android.widget.ImageView;

public class MyData {
    public String avatar;
    public String repoName;
    public Integer starCount;

    public MyData(String str1, String str2, Integer int1){
        this.avatar = str1;
        this.repoName = str2;
        this.starCount = int1;
    }

}
