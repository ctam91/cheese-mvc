package org.launchcode.cheesemvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cheese {

    // Create Cheese class properties
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    @NotNull
    @Size(min = 1, message = "Description can not be empty")
    private String description;

    @NotNull
    @Min(1)
    @Max(5)
    private int rating;

    private CheeseType type;

    /**
     * Constructor for Cheese object
     * @param name is the name of the cheese
     * @param description describes the cheese
     * this() refers to the constructor below.
     */
    public Cheese(String name, String description){
        this.name = name;
        this.description = description;
    }

    /**
     * Default constructor for Cheese object
     */
    public Cheese (){
    }

    // Getter for id property
    public int getId() {
        return id;
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

    // Getter and Setter for type property
    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
