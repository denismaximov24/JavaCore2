package HW11;

public class MotherBlock {
    private String brand;
    private String model;

    public MotherBlock(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    public MotherBlock (){};

    public void printInfo (){
        System.out.println("MotherBlock brand: " + brand + "\nMotherBlock model: " + model);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }
}