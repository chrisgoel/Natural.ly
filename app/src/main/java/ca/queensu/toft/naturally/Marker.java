package ca.queensu.toft.naturally;

import android.graphics.Bitmap;

public class Marker {
    String id;
    Float latitude;
    Float longitude;
    String animal;
    Bitmap img;

    public Marker(String id, Float latitude, Float longitude, String animal, Bitmap img){
        this.id = id;
        this.latitude=latitude;
        this.longitude=longitude;
        this.animal=animal;
        this.img = img;
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


    public Bitmap getImg() {
        return img;
    }
}
