
package bicycleproduction;

import bicycleproduction.orderStates.NewOrder;
import bicycleproduction.orderStates.OrderState;
import bicycleproduction.exceptions.OrderException;
import java.io.Serializable;

/**
 * This Order represents an order being processed by the BicycleProduction
 * It goes to different states until the final state wich is Finished
 *
 * It represents the context in the state pattern
 * 
 * @author JoséArmando
 */
public class Order implements Serializable{
    
    private String customerName;
    private int orderNumber;
    
    private OrderState state;
    private BicycleSpec spec;

    public Order(int orderNumber, String customerName, BicycleSpec spec) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.spec = spec;
        state = new NewOrder();
    }

    /**
     * Process or finish current state
     * This is called when the current stage of the production has been finished
     * 
     * @throws OrderException 
     */
    protected void process() throws OrderException {
        state.process(this);
    }

    //Did not used. Instead coded changeSpec to update the order
    public void updateOrder() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Do not use this one, use changeSpec 
     * 
     * @param spec 
     */
    public void setSpec(BicycleSpec spec) {//Just to be used by OrderState
        this.spec = spec;
    }
    
    /**
     * To change the bicycle specification
     * 
     * @param spec
     * @throws OrderException 
     */
    public void changeSpec(BicycleSpec spec) throws OrderException {
        state.updateSpec(this, spec);
    }

    /**
     * Tries to cancel the order
     * 
     * @throws OrderException 
     */
    public void cancelProduction() throws OrderException {
        state.cancelProduction(this);
    }
    
    public void setState(OrderState state) {
        this.state = state;
    }
    
    public String getCurrentStateName(){
        return state.getStateName();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BicycleSpec getSpec() {
        return spec;
    }


    
}
