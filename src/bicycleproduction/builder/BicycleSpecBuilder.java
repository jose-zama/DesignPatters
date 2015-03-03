/*
 *
 */
package bicycleproduction.builder;

import bicycleproduction.BicycleSpec;
import bicycleproduction.ComponentSet;
import bicycleproduction.Frame;
import bicycleproduction.enums.Color;
import bicycleproduction.exceptions.BikeContructorException;

/**
 *
 * @author JoséArmando
 */
public abstract class BicycleSpecBuilder {
    
    public abstract void setColor(Color color);
    public abstract void setFrame(Frame frame, int size);
    public abstract void setComponentSet(ComponentSet componentSet);
    public abstract BicycleSpec build() throws BikeContructorException;
    
}
