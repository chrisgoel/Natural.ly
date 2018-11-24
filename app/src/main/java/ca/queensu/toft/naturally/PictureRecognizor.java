package ca.queensu.toft.naturally;

import java.io.File;
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

        return new Guess(species, guesstime, certainty, image, latitude, longitude);
    }
}