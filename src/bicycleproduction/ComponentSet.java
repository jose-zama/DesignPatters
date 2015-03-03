/*
 * Class representing a component set of a bicycle
 * This class is the set of components (brakes, chain, deralliurs and else)
 * for an example visit a shimano website.
 */
package bicycleproduction;

import bicycleproduction.enums.BikeType;
import java.io.Serializable;

/**
 * Class representing a component set of a bicycle
 * This class is the set of components (brakes, chain, deralliurs and else)
 * for an example visit a shimano website.
 * 
 * @author JoséArmando
 */
public abstract class ComponentSet extends BicycleComponent implements Serializable, Cloneable{

    public ComponentSet(String model, String material, String brand, double price, BikeType forBikeType) {
        super(model, material, brand, price, forBikeType);
    }
    
    @Override
    public ComponentSet clone(){
        ComponentSet obj=null;
        try{
            obj=(ComponentSet)super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" Cant be duplicated ");
        }
        return obj;
    }

}
