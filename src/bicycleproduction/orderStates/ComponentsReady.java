package bicycleproduction.orderStates;

import bicycleproduction.BicycleSpec;
import bicycleproduction.Order;
import bicycleproduction.exceptions.OrderException;
import java.io.Serializable;

/**
 *
 * @author JoséArmando
 */
public class ComponentsReady implements OrderState, Serializable {

    @Override
    public void process(Order order) {
        order.setState(new BikePainted());
    }

    @Override
    public void cancelProduction(Order order) {
        System.out.println("Charge £" + (order.getSpec().getTotalPrice()-order.getSpec().getAssemblyCost())/4 ); 
        //Charge quarter of the components total cost due cancelling(company policies haha)
        order.setState(new Cancelled());
    }
    
    @Override
    public String getStateName() {
        return "Components ready";
    }

    @Override
    public void updateSpec(Order order, BicycleSpec newSpec) throws OrderException{
        if(!order.getSpec().getFrame().equals(newSpec.getFrame())){//if frame was changed
            throw new OrderException("Frame already ordered, cancel order instead and create another one");
        }else if(!order.getSpec().getComponentSet().equals(newSpec.getComponentSet())){//ifcomponents were changed
            order.setState(new NewOrder());//returns to new order state, to get the components again
            System.out.println("Charge(late change) £" + 20); //company policies for late change
        }
        order.setSpec(newSpec);
    }
}
