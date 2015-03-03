
package bicycleproduction;

import bicycleproduction.enums.BikeType;
import java.io.Serializable;

/**
 * Class representing a component set of a road bicycle
 * This class is the set of components (brakes, chain, deralliurs and else)
 * for an example visit a shimano website.
 *
 * @author JoséArmando
 */
public class RoadComponentSet extends ComponentSet implements Serializable, Cloneable{

    public RoadComponentSet(String model, String material, String brand, double price) {
        super(model, material, brand, price, BikeType.ROAD);
    }
    
}
