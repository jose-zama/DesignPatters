
package bicycleproduction.builder;

import bicycleproduction.BicycleSpec;
import bicycleproduction.ComponentSet;
import bicycleproduction.Frame;
import bicycleproduction.RoadBicycleSpec;
import bicycleproduction.enums.BikeType;
import bicycleproduction.enums.Color;
import bicycleproduction.exceptions.BikeContructorException;

/**
 * Contains the logic of how to build a road bicycle specification
 *
 * @author JoséArmando
 */
public class RoadSpecBuilder extends BicycleSpecBuilder{
    private Color color;
    private Frame frame;
    private ComponentSet componentSet;
    double assemblyCost = 150;//The cost of road bike production (to pay to the workers ha)
    
    /**
     * Tries to build the spec.
     * If it is not possible, it throws an exception
     * 
     * @return
     * @throws BikeContructorException 
     */
    @Override
    public BicycleSpec build() throws BikeContructorException{
        if(!componentSet.getForBikeType().equals(BikeType.ROAD))
            throw new BikeContructorException("The selected Component set is not adequate for a Road bicycle");
        if(!frame.getForBikeType().equals(BikeType.ROAD))
            throw new BikeContructorException("The selected Frame is not adequate for a Road bicycle");
        return new RoadBicycleSpec(color, frame, componentSet,assemblyCost);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setFrame(Frame frame, int size) {
        this.frame = frame;
        frame.setSize(size);
    }

    @Override
    public void setComponentSet(ComponentSet componentSet) {
        this.componentSet = componentSet;
    }
    
    
    
}
