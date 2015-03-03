package bicycleproduction.orderStates;

import bicycleproduction.BicycleSpec;
import bicycleproduction.Order;
import java.io.Serializable;

/**
 *
 * @author JoséArmando
 */
public class NewOrder implements OrderState, Serializable {
    
    

    @Override
    public void process(Order order) {
        order.setState(new ComponentsReady());
    }


    @Override
    public void cancelProduction(Order order) {
        System.out.println("No charge for cancel");
        order.setState(new Cancelled());
    }

    @Override
    public String getStateName() {
        return "New order";
    }

    @Override
    public void updateSpec(Order order, BicycleSpec newSpec) {
        order.setSpec(newSpec);
    }
    
}
