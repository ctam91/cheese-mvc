package org.launchcode.cheesemvc.models;

public class Cheese {

    // Create Cheese class properties
    private String mName;
    private String mDescription;

    // default constructor
    public Cheese(){
        mName = "Cheese";
        mDescription = "Cheese Description";
    }
    /**
     * Constructor for cheese object
     * @param name is the name of the cheese
     * @param description describes the cheese
     */
    public Cheese(String name, String description){
        mName = name;
        mDescription = description;
    }

    // Getter and Setter for name property
    public String getName(){
        return mName;
    }

    public void setName(String aName){
        mName = aName;
    }

    // Getter and Setter for description property
    public String getDescription(){
        return mDescription;
    }

    public void setDescription(String aDescription){
        mDescription = aDescription;
    }
}
