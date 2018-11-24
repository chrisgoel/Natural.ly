package ca.queensu.toft.naturally;

import android.graphics.Bitmap;

public class Marker {
    Float latitude;
    Float longitude;
    String animal;
    Bitmap img;

    public Marker(Float latitude, Float longitude, String animal, Bitmap img){
        this.latitude=latitude;
        this.longitude=longitude;
        this.animal=animal;
        this.img = img;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImageURL(Bitmap img) {
        this.img = img;
    }
}
