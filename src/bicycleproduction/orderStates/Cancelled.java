package bicycleproduction.orderStates;

import bicycleproduction.BicycleSpec;
import bicycleproduction.Order;
import bicycleproduction.exceptions.OrderException;
import java.io.Serializable;

/**
 *
 * @author JoséArmando
 */
public class Cancelled implements OrderState, Serializable {
    
    

    @Override
    public void process(Order order) throws OrderException {
        throw new OrderException("Order is cancelled");
    }


    @Override
    public void cancelProduction(Order order) throws OrderException {
        throw new OrderException("Order is cancelled");
    }

    @Override
    public String getStateName() {
        return "Order cancelled";
    }

    @Override
    public void updateSpec(Order order, BicycleSpec newSpec) throws OrderException {
        throw new OrderException("Order is cancelled");
    }
    
}
