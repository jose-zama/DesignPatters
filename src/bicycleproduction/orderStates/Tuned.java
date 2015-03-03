package bicycleproduction.orderStates;

import bicycleproduction.BicycleSpec;
import bicycleproduction.Order;
import bicycleproduction.exceptions.OrderException;
import java.io.Serializable;

/**
 *
 * @author JoséArmando
 */
public class Tuned implements OrderState, Serializable {

    @Override
    public void process(Order order) {
        order.setState(new Finished());  
    }

    @Override
    public void cancelProduction(Order order) {
        System.out.println("Charge " + (order.getSpec().getTotalPrice())/2 ); 
        //Charge quarter of the components total cost due cancelling(company policies haha)
        order.setState(new Cancelled());    
    }
    
    @Override
    public String getStateName() {
        return "Tuned";
    }

    @Override
    public void updateSpec(Order order, BicycleSpec newSpec) throws OrderException {
        if(!order.getSpec().getColor().equals(newSpec.getColor())){
            System.out.println("Charge(repaint and dissassemle) £" + 50); //company policies for repaint
            order.setState(new ComponentsReady());//returns to before bike painted state, to repaint
        }else if(!order.getSpec().getFrame().equals(newSpec.getFrame()) ){//if frame was changed
            throw new OrderException("Frame already ordered, cancel order instead and create another one");
        }else if(!order.getSpec().getComponentSet().equals(newSpec.getComponentSet())){
            order.setState(new NewOrder());//returns to new order state, to get the components again
            System.out.println("Charge(late change and dissassemle) £" + 60); //company policies for late change
        }
        order.setSpec(newSpec);
    }
    
}
