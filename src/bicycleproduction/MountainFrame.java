
package bicycleproduction;

import bicycleproduction.enums.BikeType;
import java.io.Serializable;

/**
 * Class representing a Mountain Frame of a bicycle
 *
 * @author JoséArmando
 */
public class MountainFrame extends Frame implements Serializable, Cloneable{
    
    public MountainFrame(int size, String model, String material, String brand, double price) {
        super(model, material, brand, price, BikeType.MTB);
        super.setSize(size);
    }
    
    public MountainFrame(String model, String material, String brand, double price) {
        super(model, material, brand, price, BikeType.MTB);
    }
    
}
