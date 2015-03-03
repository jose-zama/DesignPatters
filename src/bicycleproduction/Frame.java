
package bicycleproduction;

import bicycleproduction.enums.BikeType;
import java.io.Serializable;

/**
 * Class representing a Frame of a bicycle
 *
 * @author JoséArmando
 */
public abstract class Frame extends BicycleComponent implements Serializable, Cloneable{
    
    private int size;

    public Frame(int size, String model, String material, String brand, double price, BikeType forBikeType) {
        super(model, material, brand, price, forBikeType);
        this.size = size;
    }
    
    public Frame(String model, String material, String brand, double price, BikeType forBikeType) {
        super(model, material, brand, price, forBikeType);
    }
    
    @Override
    public Frame clone(){
        Frame obj=null;
        try{
            obj=(Frame)super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" Cant be duplicated ");
        }
        return obj;
    }
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}
