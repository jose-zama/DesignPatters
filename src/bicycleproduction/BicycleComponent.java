/*
 * Class representing a bicycle component
 */
package bicycleproduction;

import bicycleproduction.enums.BikeType;
import java.io.Serializable;

/**
 *
 * @author JoséArmando
 */
public abstract class BicycleComponent implements Serializable {
    private String model;
    private String material;
    private String brand;
    private double price;
    private BikeType forBikeType;

    BicycleComponent(String model, String material, String brand, double price, BikeType forBikeType) {
        this.model = model;
        this.material = material;
        this.brand = brand;
        this.price = price;
        this.forBikeType = forBikeType;
    }
    
    

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BikeType getForBikeType() {
        return forBikeType;
    }

    public void setForBikeType(BikeType forBikeType) {
        this.forBikeType = forBikeType;
    }

    
}
