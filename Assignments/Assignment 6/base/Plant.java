package base;

public class Plant {
    //Private Variables
    private boolean needsWatering;
    private String plantFamily;
    private String Name;
    //Constructor
    public Plant(boolean needsWatering, String plantFamily, String Name){
        this.needsWatering = needsWatering;
        this.plantFamily = plantFamily;
        this.Name = Name;
    }

    public void wateringInstructions(){
        System.out.println("The watering instructions for " + this.Name);
    }

    public void sunlightRequirements(){
        System.out.println("The sunlight requirements for " + this.Name);
    }




}
