
package bicycleproduction;

import bicycleproduction.enums.Brand;
import bicycleproduction.enums.FrameModel;
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
public class FrameCatalog {
    
    private static final List<Frame> frameCatalog = new ArrayList(){
    {
        //The RoadComponentFactory creates the road frames
        BicycleComponentFactory roadFactory = RoadComponentFactory.getInstance();
        
        add(roadFactory.createFrame(FrameModel.Addict.name(), Material.Aluminum.name(), Brand.Scott.name(),  1000));
        add(roadFactory.createFrame(FrameModel.Tarmac.name(), Material.Carbon.name(), Brand.Specialized.name(),  1200));
        
        //The MountainComponentFactory creates the mountain frames
        BicycleComponentFactory mtbFactory = MountainComponentFactory.getInstance();
        
        add(mtbFactory.createFrame(FrameModel.Enduro.name(), Material.Aluminum.name(), Brand.Scott.name(),  700));
        add(mtbFactory.createFrame(FrameModel.Spark.name(), Material.Carbon.name(), Brand.Specialized.name(),  900));
    }};

    
    public static List<Frame> getFrameCatalog(){
        return frameCatalog;
    }

}
