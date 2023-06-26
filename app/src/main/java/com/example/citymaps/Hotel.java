package com.example.citymaps;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.yandex.mapkit.geometry.Point;

public class Hotel implements Parcelable {
    private String Name;
    private int Price;
    private Point Coordinates;

    public static final Creator<Hotel> CREATOR = new Creator<Hotel>() {
        @Override
        public Hotel createFromParcel(Parcel in) {
            return new Hotel(in);
        }

        @Override
        public Hotel[] newArray(int size) {
            return new Hotel[size];
        }
    };

    protected Hotel(Parcel in){
        this.Name = in.readString();
        this.Price = in.readInt();
        this.Coordinates = new Point(in.readDouble(), in.readDouble());
    }
    public Hotel(String Name, int Price, Point point) {
        this.Name = Name;
        this.Price = Price;
        this.Coordinates = point;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getPrice() {
        return Price;
    }

    public Point getCoordinates() {
        return Coordinates;
    }

    public void setCoordinates(Point coordinates) {
        Coordinates = coordinates;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeInt(Price);
        dest.writeDouble(Coordinates.getLatitude());
        dest.writeDouble(Coordinates.getLongitude());
    }
}
