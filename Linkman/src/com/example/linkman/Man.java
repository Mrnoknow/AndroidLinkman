package com.example.linkman;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lenovo on 2015/10/23.
 */
public class Man implements Parcelable {
    private String name;
    private String number;
    public Man(String name,String number){
        this.name=name;
        this.number=number;
    }
    public Man(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(number);
    }
    public static final Parcelable.Creator<Man> CREATOR = new Parcelable.Creator<Man>() {
        public Man createFromParcel(Parcel source) {
            Man man = new Man();
            man.name = source.readString();
            man.number = source.readString();

            return man;
        }
        public Man[] newArray(int size) {
            return new Man[size];
        }
    };

}
