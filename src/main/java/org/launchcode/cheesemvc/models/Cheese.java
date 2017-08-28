package org.launchcode.cheesemvc.models;

public class Cheese {

    // Create Cheese class properties
    private String name;
    private String description;
    private int cheeseId;
    private static int nextId =1;

    /**
     * Constructor for Cheese object
     * @param name is the name of the cheese
     * @param description describes the cheese
     * this() refers to the constructor below.
     */
    public Cheese(String name, String description){
        this();
        this.name = name;
        this.description = description;
    }

    /**
     * Default constructor for Cheese object
     */
    public Cheese (){
        cheeseId = nextId;
        nextId++;
    }

    // Getter and Setter for Id property
    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
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
