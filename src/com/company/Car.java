package com.company;

public class Car {
    private String model;
    private String type;

    Car(String model, String type)
    {
     this.model=model;
     this.type=type;
    }

    //region
    public String getModel(){
        return model;
    }
    public String getType(){
        return type;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setType(String type){
        this.type = type;
    }
    //endregion

    public void showCar()
    {
     System.out.println("Car: "+model+" "+type);
    }
}
