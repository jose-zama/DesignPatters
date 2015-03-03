
package bicycleproduction;

import bicycleproduction.enums.Color;

/**
 * Class representing the specification of a road bike
 *
 * @author JoséArmando
 */
public class RoadBicycleSpec extends BicycleSpec{
    
    public RoadBicycleSpec(Color color, Frame frame, ComponentSet componentSet, double assemblyCost)  {
        super(color, frame, componentSet, assemblyCost);
    }
    
}
