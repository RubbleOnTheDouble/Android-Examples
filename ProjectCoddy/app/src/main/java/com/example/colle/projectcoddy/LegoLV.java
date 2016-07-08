package com.example.colle.projectcoddy;

/**
 * Created by colle on 7/6/2016.
 */
//Store info about the list view LV
public class LegoLV {
    private String make;
    private String age;
    private int iconID;
    private String condition;

    public LegoLV(String make, String age, int iconID, String condition){
        super();
        this.make = make;
        this.age = age;
        this.iconID = iconID;
        this.condition = condition;
    }

    public String getMake(){
        return make;
    }

    public String getAge(){
        return age;
    }

    public int getIconID(){
        return iconID;
    }

    public String getCondition(){
        return condition;
    }

}
