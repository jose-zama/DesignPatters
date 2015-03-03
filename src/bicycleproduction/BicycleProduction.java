/*
 * Pattern-based software development mini-project
 * This application shows an implementation of the following three patterns:
 * 1. State
 * 2. Abstract Factory
 * 3. Builder
 */
package bicycleproduction;

import bicycleproduction.builder.BicycleSpecBuilder;
import bicycleproduction.builder.BicycleSpecDirector;
import bicycleproduction.builder.MountainSpecBuilder;
import bicycleproduction.builder.RoadSpecBuilder;
import bicycleproduction.enums.BikeType;
import bicycleproduction.enums.Color;
import bicycleproduction.exceptions.BikeContructorException;
import bicycleproduction.exceptions.OrderException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the principal class, which control the production by managing
 * the orders.
 * @author JoséArmando
 */
public class BicycleProduction {
    private List<Order> orders;//list of orders registered in the system
    public  BicycleProduction(){
        orders = new ArrayList<>();
        loadOrders();//load the orders from filesystem
    }
    
    /**
     * Creates and saves a new Order
     * It builds a bicycle specification.
     * 
     * @param customerName
     * @param bikeType
     * @param color
     * @param frame
     * @param frameSize
     * @param componentSet
     * @return
     * @throws BikeContructorException 
     */
    public Order newOrder(String customerName,BikeType bikeType,Color color, Frame frame,int frameSize, ComponentSet componentSet ) throws BikeContructorException{
        //build bicycle specification
        //Note the use of clone(). As we retreive those objects from a catalog
        //we have to clone them before send it to the builder. 
        //Prototype pattern.
        BicycleSpec spec = buildBicycleSpec(bikeType, color, frame.clone(), frameSize, componentSet.clone());
        //create order
        Order order = new Order(getNextOrderNumber(),customerName,spec); 
        //add and save it
        orders.add(order);
        saveOrders();
        return order;
    }
    
    /**
     * Load orders form filesystem
     */
    public void loadOrders(){
        ObjectInputStream inputStream = null;
        try {            
            inputStream = new ObjectInputStream(new FileInputStream("orders"));
            orders = (List<Order>)inputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(BicycleProduction.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(BicycleProduction.class.getName()).log(Level.SEVERE, null, ex);
            }catch (Exception ex) {
                Logger.getLogger(BicycleProduction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Save orders to filesystem
     */
    public void saveOrders(){
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("orders"));
            outputStream.writeObject(orders);
        } catch (IOException ex) {
            Logger.getLogger(BicycleProduction.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(BicycleProduction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * It sends the values chosen by the customer to the related builder
     * depending of bikeType
     * 
     * @param bikeType
     * @param color
     * @param frame
     * @param frameSize
     * @param componentSet
     * @return
     * @throws BikeContructorException 
     */
    private BicycleSpec buildBicycleSpec(BikeType bikeType,Color color,Frame frame,int frameSize,ComponentSet componentSet) throws BikeContructorException{
        BicycleSpecBuilder builder=null;
        switch(bikeType){
            case ROAD:
                builder=new RoadSpecBuilder();
                break;
            case MTB:
                builder=new MountainSpecBuilder();
                break;
            default:
                //todo handle error;
                
        }
        //the director build step by step the bicycle specification according
        //to the builder
        BicycleSpecDirector director = new BicycleSpecDirector();
        return director.build(builder, color, frame, frameSize, componentSet);
    }
    
    /**
     * Process the current state order and save it
     * 
     * @param order
     * @throws OrderException 
     */
    public void process(Order order) throws OrderException {
            order.process();
            saveOrders();
    }

    /**
     * Tries to update the color of a bicycle specification
     * 
     * @param order
     * @param color
     * @throws BikeContructorException
     * @throws OrderException 
     */
    public void changeColor(Order order, Color color) throws BikeContructorException, OrderException {
        BicycleSpec spec = buildBicycleSpec(order.getSpec().getFrame().getForBikeType(), color, order.getSpec().getFrame(), order.getSpec().getFrame().getSize(), order.getSpec().getComponentSet());
        //the last statement tries to build a new spec with the change required(new color)
        //If is not possible to build the bicycle, an exception will be thrown
        //i think this is an advantage of having a Builder.
        order.changeSpec(spec);
        saveOrders();
    }
    
    /**
     *  Tries to update the frame of a bicycle specification
     * 
     * @param order
     * @param frame
     * @throws BikeContructorException
     * @throws OrderException 
     */
    public void changeFrame(Order order, Frame frame) throws BikeContructorException, OrderException {
        BicycleSpec spec = buildBicycleSpec(order.getSpec().getFrame().getForBikeType(), order.getSpec().getColor(), frame.clone(), order.getSpec().getFrame().getSize(), order.getSpec().getComponentSet());
        order.changeSpec(spec);
        saveOrders();
    }
    
    /**
     * Tries to update the component set of a bicycle specification
     * 
     * @param order
     * @param componentSet
     * @throws BikeContructorException
     * @throws OrderException 
     */
    public void changeComponentSet(Order order, ComponentSet componentSet) throws BikeContructorException, OrderException {
        BicycleSpec spec = buildBicycleSpec(order.getSpec().getFrame().getForBikeType(), order.getSpec().getColor(), order.getSpec().getFrame(), order.getSpec().getFrame().getSize(), componentSet.clone());
        order.changeSpec(spec);
        saveOrders();
    }

    /**
     * Tries to cancel an order.
     * Depens of the current state
     * 
     * @param order
     * @throws OrderException 
     */
    public void cancelProduction(Order order) throws OrderException {
        order.cancelProduction();
        saveOrders();
    }
    
    /**
     * Get an order form the list of orders by its order number
     * 
     * @param orderNumber
     * @return 
     */
    public Order getOrder(int orderNumber){
        for(Order order:orders){
            if (order.getOrderNumber() == orderNumber) return order;
        }
        return null;
    }

    /**
     * Returns the frame catalog
     * 
     * @return 
     */
    public List<Frame> getFrameCatalog(){
        return FrameCatalog.getFrameCatalog();
    }
    
    /**
     * Returns the component set catalog
     * 
     * @return 
     */
    public List<ComponentSet> getComponentSetCatalog(){
        return ComponentSetCatalog.getComponentSetCatalog();
    }

    /**
     * Returns the next order number
     * 
     * @return 
     */
    private int getNextOrderNumber() {
        if(orders.isEmpty()) return 1;
        else return orders.get(orders.size()-1).getOrderNumber()+1;
    }
}
