package ca.queensu.toft.naturally;

public class Marker {
    Float latitude;
    Float longitude;
    String animal;
    String imageURL;

    public Marker(Float latitude, Float longitude, String animal, String imageURL){
        this.latitude=latitude;
        this.longitude=longitude;
        this.animal=animal;
        this.imageURL = imageURL;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
