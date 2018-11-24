package ca.queensu.toft.naturally.Model;

public abstract class Animal {
    private String species;

    public Animal(String s) {
        species = s;
    }

    public String getSpecies() {
        return species;
    }
}
