
package bicycleproduction.factory;

import bicycleproduction.ComponentSet;
import bicycleproduction.Frame;
import bicycleproduction.RoadComponentSet;
import bicycleproduction.RoadFrame;

/**
 * Factory that creates mountain bicycle components
 *
 * @author JoséArmando
 */
public class RoadComponentFactory implements BicycleComponentFactory{
    
    private static RoadComponentFactory singleton;
    
    protected RoadComponentFactory(){}
    
    //For singleton pattern
    public static RoadComponentFactory getInstance(){
        if (singleton == null){
            singleton = new RoadComponentFactory();
        }
        return singleton;
    }

    @Override
    public Frame createFrame(String model, String material, String brand, double price) {
        return new RoadFrame( model,  material,  brand,  price);
    }

    @Override
    public ComponentSet createComponentSet(String model, String material, String brand, double price){
        return new RoadComponentSet( model,  material,  brand,  price);
    }
    
}
