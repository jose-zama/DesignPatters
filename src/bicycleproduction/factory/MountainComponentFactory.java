
package bicycleproduction.factory;

import bicycleproduction.ComponentSet;
import bicycleproduction.Frame;
import bicycleproduction.MountainComponentSet;
import bicycleproduction.MountainFrame;

/**
 * Factory that creates mountain bicycle components
 *
 * @author JoséArmando
 */
public class MountainComponentFactory implements BicycleComponentFactory{

    private static MountainComponentFactory singleton;
    
    protected MountainComponentFactory(){}
    
    //For singleton pattern
    public static MountainComponentFactory getInstance(){
        if (singleton == null){
            singleton = new MountainComponentFactory();
        }
        return singleton;
    }
    
    @Override
    public Frame createFrame(String model, String material, String brand, double price) {
        return new MountainFrame( model,  material,  brand,  price);
    }

    @Override
    public ComponentSet createComponentSet(String model, String material, String brand, double price){
        return new MountainComponentSet( model,  material,  brand,  price);
    }
    
}
