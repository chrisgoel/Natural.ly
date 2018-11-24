package ca.queensu.toft.naturally;

import java.io.File;
import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import clarifai2.api.request.model.Action;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.prediction.Concept;

/* Runs on my computer (not on phone) to generate and train machine for picture interpretation
 */
public class PictureRecognizorTrainer {
    private static final String apikey = "2129bdd3491348e49083aaa76b9322c7";
    private static final String[] animals = {"squirrel_grey", "cardinal_male", "cardinal_female"};
    private static ClarifaiClient clarifai = new ClarifaiBuilder(apikey).buildSync();
    private static final String modelID = "animodel";

    public static void main(String[] args) {
        clarifai.createModel(modelID).executeSync();

        for (String animal : animals) {
            addConcept(animal);
            for(final File image : new File("/home/bennet/IdeaProjects/naturallybuilder/src/main/resources/" + animal).listFiles()) {
                clarifai.addInputs()
                        .plus(ClarifaiInput.forImage(image)
                                .withConcepts(Concept.forID(animal))).executeSync();
            }
        }

        clarifai.trainModel(modelID).executeSync();
    }

    private static void addConcept(String concept) {
        clarifai.modifyModel(modelID).withConcepts(Action.MERGE, Concept.forID(concept));
    }
}