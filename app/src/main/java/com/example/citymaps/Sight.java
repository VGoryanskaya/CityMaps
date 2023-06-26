package com.example.citymaps;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.yandex.mapkit.geometry.Point;

public class Sight implements Parcelable{

    private String Name;
    private String Description;
    private String OpenTime;
    private int Picture;
    private Point Coordinates;

    public Sight(String Name, String Description, Point coordinates){
        this.Name = Name;
        this.Description = Description;
        this.Picture = R.drawable.nopicture;
        this.Coordinates = coordinates;
    }

    public Sight(String Name, String Description, int Picture, Point coordinates){
        this.Name = Name;
        this.Description = Description;
        this.OpenTime = "";
        this.Picture = Picture;
        this.Coordinates = coordinates;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDescription() {
        return Description;
    }

    public void setOpenTime(String openTime) {
        OpenTime = openTime;
    }

    public String getOpenTime() {
        return OpenTime;
    }

    public void setPicture(int picture) {
        Picture = picture;
    }

    public int getPicture() {
        return Picture;
    }

    public void setCoordinates(Point coordinates) {
        Coordinates = coordinates;
    }

    public Point getCoordinates() {
        return Coordinates;
    }

    protected Sight(Parcel in) {
        this.Name = in.readString();
        this.Description = in.readString();
        this.Picture = in.readInt();
        this.Coordinates = new Point(in.readDouble(), in.readDouble());
    }

    public static final Creator<Sight> CREATOR = new Creator<Sight>() {
        @Override
        public Sight createFromParcel(Parcel in) {
            return new Sight(in);
        }

        @Override
        public Sight[] newArray(int size) {
            return new Sight[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Description);
        dest.writeInt(Picture);
        dest.writeDouble(Coordinates.getLatitude());
        dest.writeDouble(Coordinates.getLongitude());
    }

    @Override
    public String toString (){
        return getName();
    }
}
