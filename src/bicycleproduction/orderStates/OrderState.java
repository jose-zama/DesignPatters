/*
 * This is the interface for the State of the order
 */
package bicycleproduction.orderStates;

import bicycleproduction.BicycleSpec;
import bicycleproduction.Order;
import bicycleproduction.exceptions.OrderException;


/**
 * This is the interface for the State of the order
 *
 * @author JoséArmando
 */
public interface OrderState{

    /**
     * Process or finish the current state
     * It may switch to another state
     * 
     * @param order
     * @throws OrderException 
     */
    public void process (Order order) throws OrderException;
    
    /**
     * Tries to update the bicycle specification
     * It may swith to another state
     * 
     * @param order
     * @param newSpec
     * @throws OrderException 
     */
    public void updateSpec(Order order, BicycleSpec newSpec) throws OrderException;
    
    /**
     * Cancel the order by changin the state to Cancelled
     * 
     * @param order
     * @throws OrderException 
     */
    public void cancelProduction(Order order) throws OrderException;
    
    /**
     * Return the state name
     * 
     * @return state name
     */
    public String getStateName();
    
}
