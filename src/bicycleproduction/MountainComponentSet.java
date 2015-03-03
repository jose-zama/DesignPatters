
package bicycleproduction;

import bicycleproduction.enums.BikeType;
import java.io.Serializable;

/**
 * Class representing a component set of a mountain bicycle
 * 
 * @author JoséArmando
 */
public class MountainComponentSet extends ComponentSet implements Serializable, Cloneable{

    public MountainComponentSet(String model, String material, String brand, double price) {
        super(model, material, brand, price, BikeType.MTB);
    }
    
}
