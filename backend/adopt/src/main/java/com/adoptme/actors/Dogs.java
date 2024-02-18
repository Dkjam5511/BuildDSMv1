package com.adoptme.actors;
import java.util.List;

public class Dogs{

    private String name;
    private String breed;
    private String age;
    private String description;
    private String[] traits;


    public Dogs(String name, String breed, String age, String description, String[] traits){
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.description = description;
        this.traits = traits;
    }

    public String getName(){
        return name;
    }

    public String getBreed(){
        return breed;
    }

    public String getAge(){
        return age;
    }

    public String getDescription(){
        return description;
    }

    public String[] getTraits(){
        return traits;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public void setAge(String age){
        this.age = age;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setTraits(String[] traits){
        this.traits = traits;
    }
}