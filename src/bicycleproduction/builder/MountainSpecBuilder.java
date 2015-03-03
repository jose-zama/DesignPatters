
package bicycleproduction.builder;

import bicycleproduction.BicycleSpec;
import bicycleproduction.ComponentSet;
import bicycleproduction.Frame;
import bicycleproduction.MountainBicycleSpec;
import bicycleproduction.enums.BikeType;
import bicycleproduction.enums.Color;
import bicycleproduction.exceptions.BikeContructorException;

/**
 * Contains the logic of how to build a mountain bicycle specification
 * 
 * @author JoséArmando
 */
public class MountainSpecBuilder extends BicycleSpecBuilder{

    private Color color;
    private Frame frame;
    private ComponentSet componentSet;
    double assemblyCost = 110;//The cost of Mountain bike production (to pay to the workers ha)
    
    /**
     * Tries to build the spec.
     * If it is not possible, it throws an exception
     * 
     * @return
     * @throws BikeContructorException 
     */
    @Override
    public BicycleSpec build() throws BikeContructorException{
        if(!componentSet.getForBikeType().equals(BikeType.MTB))
            throw new BikeContructorException("The selected Component set is not adequate for a Mtb bicycle");
        if(!frame.getForBikeType().equals(BikeType.MTB))
            throw new BikeContructorException("The selected Frame is not adequate for a Mtb bicycle");
        return new MountainBicycleSpec(color, frame, componentSet,assemblyCost);
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
