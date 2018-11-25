package ca.queensu.toft.naturally;

import android.graphics.Bitmap;

import java.util.Date;

public class Marker {

    public double latitude;
    public double longitude;
    public String animal;
    public Date time;
    public String id;

    public Marker(){

    }

    public Marker(String id, double latitude, double longitude, String animal, Date time){
        this.id = id;
        this.latitude=latitude;
        this.longitude=longitude;
        this.animal=animal;
        this.time = time;
    }

    public String getId(){return id;}

    public double getLatitude() {
        return latitude;
    }


    public double getLongitude() {
        return longitude;
    }


    public String getAnimal() {
        return animal;
    }

    public Date getTime(){
        return time;
    }
}
