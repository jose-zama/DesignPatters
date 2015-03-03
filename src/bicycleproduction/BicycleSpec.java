/*
 * This interface defines the structure of a bcycle specification.
 * this is part of and order.
 */
package bicycleproduction;

import bicycleproduction.enums.Color;
import java.io.Serializable;

/**
 * This interface defines the structure of a bcycle specification.
 * this is part of and order.
 *
 * @author JoséArmando
 */
public abstract class BicycleSpec implements Serializable {
    
    private Color color;
    private Frame frame;
    private ComponentSet componentSet;
    private double assemblyCost;

    BicycleSpec(Color color, Frame frame, ComponentSet componentSet, double assemblyCost) {
        this.color = color;
        this.frame = frame;
        this.componentSet = componentSet;
        this.assemblyCost = assemblyCost;
    }        
    
    public double getTotalPrice(){
        return componentSet.getPrice() + frame.getPrice() + assemblyCost;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public ComponentSet getComponentSet() {
        return componentSet;
    }

    public void setComponentSet(ComponentSet componentSet) {
        this.componentSet = componentSet;
    }

    public double getAssemblyCost() {
        return assemblyCost;
    }

    public void setAssemblyCost(double assemblyCost) {
        this.assemblyCost = assemblyCost;
    }
    
    
    
}
