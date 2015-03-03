
package bicycleproduction;

import bicycleproduction.enums.Brand;
import bicycleproduction.enums.ComponentSetModel;
import bicycleproduction.enums.Material;
import bicycleproduction.factory.BicycleComponentFactory;
import bicycleproduction.factory.MountainComponentFactory;
import bicycleproduction.factory.RoadComponentFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Initialize and stores the component set items available to be chosen
 * by the customer
 * 
 * @author JoséArmando
 */
public class ComponentSetCatalog {
    
    private static final List<ComponentSet> componentSetCatalog = new ArrayList(){
    {
        //The RoadComponentFactory creates the road component sets
        BicycleComponentFactory roadFactory = RoadComponentFactory.getInstance();
        
        add(roadFactory.createComponentSet(ComponentSetModel.Apex.name(), Material.Aluminum.name(), Brand.SRAM.name(),  300));
        add(roadFactory.createComponentSet(ComponentSetModel.DuraACE.name(), Material.Carbon.name(), Brand.Shimano.name(),  800));
        
        //The MountainComponentFactory creates the mountain component sets
        BicycleComponentFactory mtbFactory = MountainComponentFactory.getInstance();
        
        add(mtbFactory.createComponentSet(ComponentSetModel.ApexMountain.name(), Material.Aluminum.name(), Brand.SRAM.name(),  200));
        add(mtbFactory.createComponentSet(ComponentSetModel.Deore.name(), Material.Carbon.name(), Brand.Shimano.name(),  600));
        
    }};

    public static List<ComponentSet> getComponentSetCatalog(){
        return componentSetCatalog;
    }

}
