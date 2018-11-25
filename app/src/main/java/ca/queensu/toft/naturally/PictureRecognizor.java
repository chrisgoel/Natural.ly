package ca.queensu.toft.naturally;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Date;

import ca.queensu.toft.naturally.Model.Guess;
import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import clarifai2.api.request.ClarifaiRequest;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.model.ModelVersion;

public class PictureRecognizor {
    private final String apikey = "95559efe4825454898c3ce979493c9bc";
    private ClarifaiClient clarifai = new ClarifaiBuilder(apikey).buildSync();
    private final String modelID = "animals";
    private final String versionID = "5fe8c52a9dce428aaf533ac7a2661726";
    public Guess guess;
    public static boolean finding = true;


    /*
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
    }*/

    public void guess(final Bitmap bitmap, final float latitude, final float longitude) {
        System.out.println("latitude: " + latitude);
        System.out.println("longitude: " + longitude);
        clarifai.getModelVersionByID(modelID, versionID).executeAsync(new ClarifaiRequest.Callback<ModelVersion>() {
            @Override
            public void onClarifaiResponseSuccess(@NonNull ModelVersion modelVersion) {
                getGuessFromVersion(modelVersion, bitmap, latitude, longitude);
            }

            @Override
            public void onClarifaiResponseUnsuccessful(int errorCode) {
            }

            @Override
            public void onClarifaiResponseNetworkError(IOException e) {
            }
        });
        //return new Guess(species, guesstime, certainty, bitmap, latitude, longitude);
    }

    private void getGuessFromVersion(ModelVersion version, Bitmap bitmap, float latitude, float longitude) {
        File image;
        try {
            image = File.createTempFile("tmpimg", "png");

            System.out.println("Temp file created");
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(image));
                String species = clarifai.predict("animals")
                        .withVersion(version)
                        .withInputs(ClarifaiInput.forImage(image))
                        .executeSync()
                        .get().get(0).data().get(0).asConcept().name();
                System.out.println(species);
                Date guesstime = new Date();
                System.out.println("GUESS TIME: " + guesstime);
                float certainty = clarifai.predict("animals")
                        .withVersion(version)
                        .withInputs(ClarifaiInput.forImage(image))
                        .executeSync()
                        .get().get(0).data().get(0).asConcept().value();
                guess = new Guess(species, guesstime, certainty, bitmap, latitude, longitude);
                finding = false;
            } catch(IOException e) {
                e.printStackTrace();
            }
        } catch(IOException e) {
            System.out.println("Temp file not created");
        }
    }

    public Guess getGuess() {
        return guess;
    }

    /*
    public Guess guess(URL url, float latitude, float longitude) {

    }*/
}