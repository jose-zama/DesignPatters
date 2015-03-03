/*
 * Logic to build a bicycle specification
 */
package bicycleproduction.builder;

import bicycleproduction.BicycleSpec;
import bicycleproduction.ComponentSet;
import bicycleproduction.Frame;
import bicycleproduction.enums.Color;
import bicycleproduction.exceptions.BikeContructorException;

/**
 * To build step by step a bicycle specification
 *
 * @author JoséArmando
 */
public class BicycleSpecDirector {
    
    public BicycleSpec build(BicycleSpecBuilder specBuilder, Color color, Frame frame, int size, ComponentSet componentSet) throws BikeContructorException{
        specBuilder.setColor(color);
        specBuilder.setFrame(frame, size);
        specBuilder.setComponentSet(componentSet);
        return specBuilder.build();//build the bicycle specification
    }
}
