package ca.queensu.toft.naturally;

import android.graphics.Bitmap;

import java.util.Date;

public class Marker {

    Float latitude;
    Float longitude;
    String animal;
    Date time;
    public Marker(){

    }

    public Marker(Float latitude, Float longitude, String animal, Date time){

        this.latitude=latitude;
        this.longitude=longitude;
        this.animal=animal;
        this.time = time;
       // this.img = img;
    }

    public Float getLatitude() {
        return latitude;
    }


    public Float getLongitude() {
        return longitude;
    }


    public String getAnimal() {
        return animal;
    }

    public Date getTime(){
        return time;
    }
}
