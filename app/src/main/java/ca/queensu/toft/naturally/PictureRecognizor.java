package ca.queensu.toft.naturally;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Date;

import ca.queensu.toft.naturally.Model.Guess;
import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.model.ModelVersion;

public class PictureRecognizor {
    private final String apikey = "95559efe4825454898c3ce979493c9bc";
    private ClarifaiClient clarifai = new ClarifaiBuilder(apikey).buildSync();
    private final String modelID = "animals";
    private final String versionID = "39e96022b0a84ea08957c8eaea82e90f";


    public Guess guess(File image, float latitude, float longitude) {
        ModelVersion modelVersion = clarifai.getModelVersionByID(modelID, versionID).executeSync().get();

        String species = clarifai.predict("animals")
                .withVersion(modelVersion)
                .withInputs(ClarifaiInput.forImage(image))
                .executeSync()
                .get().get(0).data().get(0).asConcept().name();
        Date guesstime = new Date();
        float certainty = clarifai.predict("animals")
                .withVersion(modelVersion)
                .withInputs(ClarifaiInput.forImage(image))
                .executeSync()
                .get().get(0).data().get(0).asConcept().value();

        Bitmap bitmap = BitmapFactory.decodeFile(image.getPath());

        return new Guess(species, guesstime, certainty, bitmap, latitude, longitude);
    }

    public Guess guess(Bitmap bitmap, float latitude, float longitude) {
        System.out.println("latitude: " + latitude);
        System.out.println("longitude: " + longitude);
        ModelVersion modelVersion = clarifai.getModelVersionByID("animals", "39e96022b0a84ea08957c8eaea82e90f").executeSync().get();

        File image = new File("./tempimg.png");

        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(image));
        } catch(IOException e) {
            e.printStackTrace();
        }

        String species = clarifai.predict("animals")
                .withVersion(modelVersion)
                .withInputs(ClarifaiInput.forImage(image))
                .executeSync()
                .get().get(0).data().get(0).asConcept().name();
        Date guesstime = new Date();
        float certainty = clarifai.predict("animals")
                .withVersion(modelVersion)
                .withInputs(ClarifaiInput.forImage(image))
                .executeSync()
                .get().get(0).data().get(0).asConcept().value();

        image.delete();

        return new Guess(species, guesstime, certainty, bitmap, latitude, longitude);
    }

    /*
    public Guess guess(URL url, float latitude, float longitude) {

    }*/
}