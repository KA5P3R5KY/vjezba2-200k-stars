package com.example.vjezba2;

import android.widget.ImageView;

public class MyData {
    public ImageView avatar;
    public String repoName;
    public String starCount;

    public MyData(ImageView img1, String str1, String str2){
        this.avatar = img1;
        this.repoName = str1;
        this.starCount = str2;
    }

}
