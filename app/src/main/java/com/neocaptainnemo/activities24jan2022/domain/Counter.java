package com.neocaptainnemo.activities24jan2022.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Counter implements Parcelable {

    public static final Creator<Counter> CREATOR = new Creator<Counter>() {
        @Override
        public Counter createFromParcel(Parcel in) {
            return new Counter(in);
        }

        @Override
        public Counter[] newArray(int size) {
            return new Counter[size];
        }
    };
    private int value;
    private double doubleValue;

    public Counter(int value) {
        this.value = value;
    }

    protected Counter(Parcel in) {
        value = in.readInt();
        doubleValue = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(value);
        dest.writeDouble(doubleValue);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void increase() {
        value++;
    }

    public int getValue() {
        return value;
    }
}
