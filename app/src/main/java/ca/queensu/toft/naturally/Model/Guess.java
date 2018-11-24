package ca.queensu.toft.naturally.Model;

import android.graphics.Bitmap;

import java.io.File;
import java.util.Date;

public class Guess extends Animal {
    private Date timestamp;
    private float certainty;
    private Bitmap image;
    private float latitude;
    private float longitude;

    public Guess(String species, Date timestamp, float certainty, Bitmap image, float lat, float lon) {
        super(species);
        this.timestamp = timestamp;
        this.certainty = certainty;
        this.image = image;
        this.latitude = lat;
        this.longitude = lon;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public float getCertainty() {
        return certainty;
    }

    public Bitmap getImage() {
        return image;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }
}
