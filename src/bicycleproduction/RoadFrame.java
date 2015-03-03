
package bicycleproduction;

import bicycleproduction.enums.BikeType;
import java.io.Serializable;

/**
 * Class representing a road Frame of a bicycle
 *
 * @author JoséArmando
 */
public class RoadFrame extends Frame implements Serializable, Cloneable{
    
    public RoadFrame(int size, String model, String material, String brand, double price) {
        super(model, material, brand, price, BikeType.ROAD);
        super.setSize(size);
    }
    
    public RoadFrame(String model, String material, String brand, double price) {
        super(model, material, brand, price, BikeType.ROAD);
    }
    
}
