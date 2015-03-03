package bicycleproduction.factory;

import bicycleproduction.ComponentSet;
import bicycleproduction.Frame;

/**
 * Abstract factory for the road and mountain factories 
 *
 * @author JoséArmando
 */
public interface BicycleComponentFactory {
    
    public Frame createFrame(String model, String material, String brand, double price);
    public ComponentSet createComponentSet(String model, String material, String brand, double price);
}
