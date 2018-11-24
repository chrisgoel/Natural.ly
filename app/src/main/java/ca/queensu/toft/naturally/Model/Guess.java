package ca.queensu.toft.naturally.Model;

import java.io.File;
import java.util.Date;

public class Guess extends Animal {
    private Date timestamp;
    private float certainty;
    private File image;

    public Guess(String species, Date timestamp, float certainty, File image) {
        super(species);
        this.timestamp = timestamp;
        this.certainty = certainty;
        this.image = image;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public float getCertainty() {
        return certainty;
    }

    public File getImage() {
        return image;
    }
}
