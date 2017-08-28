package org.launchcode.cheesemvc.models;

public class Cheese {

    // Create Cheese class properties
    private String name;
    private String description;

    /**
     * Constructor for cheese object
     * @param name is the name of the cheese
     * @param description describes the cheese
     */
    public Cheese(String name, String description){
        this.name = name;
        this.description = description;
    }

    // Getter and Setter for name property
    public String getName(){
        return name;
    }

    public void setName(String aName){
        this.name = aName;
    }

    // Getter and Setter for description property
    public String getDescription(){
        return description;
    }

    public void setDescription(String aDescription){
        this.description = aDescription;
    }
}
