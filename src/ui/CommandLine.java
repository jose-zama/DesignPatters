/*
 * UI for the Bicycle Component App
 * For the sake to show the usage of the design patterns
 */
package ui;

import bicycleproduction.BicycleProduction;
import bicycleproduction.ComponentSet;
import bicycleproduction.Frame;
import bicycleproduction.Order;
import bicycleproduction.enums.BikeType;
import bicycleproduction.enums.Color;
import bicycleproduction.exceptions.BikeContructorException;
import bicycleproduction.exceptions.OrderException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoséArmando
 */
public class CommandLine {

    public static void main(String[] args) {
        //BicycleProduction is the application actually. It manages the orders.
        BicycleProduction bp = new BicycleProduction();
        
        BufferedReader in = new BufferedReader ( 
                    new InputStreamReader (System.in ) );
        while ( true ) {
            
            try {
                System.out.println ( " Select an option: " );
                System.out.println ( "  1) Create new Order" );
                System.out.println ( "  2) Open Order" );
                System.out.println ( "  3) Get Happiness" );
                System.out.println ( "  e) Exit" );
                
                String option = in.readLine();
                option = option.trim().toUpperCase();
                
                if ( option.equals( "1" ) ) {
                    
                    System.out.print("Type the customer name: ");
                    String customer = in.readLine();
                    
                    
                    System.out.println("Select the type of bicycle desired: ");
                    System.out.println ( "  1) Mountain bicycle" );
                    System.out.println ( "  2) Road bicycle" );
                    BikeType bikeType = null;
                    switch(in.readLine()){
                        case "1":
                            bikeType = BikeType.MTB;
                            break;
                        case "2":
                            bikeType = BikeType.ROAD;
                            break;
                    }
                    
                    System.out.println("Select the color : ");
                    System.out.println ( "  1) Black" );
                    System.out.println ( "  2) Blue" );
                    System.out.println ( "  3) Red" );
                    System.out.println ( "  4) White" );
                    Color color = null;
                    switch(in.readLine()){
                        case "1":
                            color = Color.Black;
                            break;
                        case "2":
                            color = Color.Blue;
                            break;
                        case "3":
                            color = Color.Red;
                            break;
                        case "4":
                            color = Color.White;
                            break;
                        default:
                            color = Color.Black;
                            System.out.println("No color selected. Default color Black seleted.");
                            break;
                    }
                    
                    System.out.println("Select the frame : ");
                    
                    int i=1;
                    //The available frames comes from the FrameCatalog and this
                    //is provided by the BicycleProduction object.
                    //We do not want a dependency between the UI and the catalogues
                    for(Frame availableFrame:bp.getFrameCatalog()){
                        System.out.println ( "  "+ i++ +") "+availableFrame.getModel()+ " Price: £"+availableFrame.getPrice());
                    }
                    
                    //Get the selected frame form the catalogue
                    Frame frame = bp.getFrameCatalog().get(Integer.parseInt(in.readLine())-1);
                    
                    System.out.print("Enter size (int): ");
                    int frameSize = Integer.parseInt(in.readLine());
                    
                    System.out.println("Select the component set : ");
                    
                    i=1;
                    //The available component set comes from the ComponentSetCatalog and this
                    //is provided by the BicycleProduction object.
                    //We do not want a dependency between the UI and the catalogues
                    for(ComponentSet availableComp:bp.getComponentSetCatalog()){
                        System.out.println ( "  "+ i++ +") "+availableComp.getModel()+ " Price: £"+availableComp.getPrice());
                    }
                    
                    ComponentSet component = bp.getComponentSetCatalog().get(Integer.parseInt(in.readLine())-1);
                    try{
                        //Try to create the Order. When creating the order, we try to 
                        //construct the bicycle specification.
                        Order order = bp.newOrder(customer,bikeType,color,frame,frameSize,component);
                        System.out.println("Order sucessfully created");
                        System.out.println("Order number = "+order.getOrderNumber());
                        System.out.println("Total price = "+order.getSpec().getTotalPrice());
                        
                    }
                    //An exception is thrown is there is no possible to contruct
                    //the bike specification
                    catch (BikeContructorException ex) {
                        System.out.println(ex.getMessage());
                        System.out.println("Order not created");
                    }
                    
                } else if (option.equals("2")) {// Open order
                    System.out.print("Type the order number (int): ");
                    int orderNumber = Integer.parseInt(in.readLine());
                    
                    Order order = bp.getOrder(orderNumber);
                    if(order==null){
                        System.out.println("Order number not found");
                    }else{
                        orderMenu(order,bp);//Show order menu
                    }
                } else if (option.equals("3")) {// get hapiness
                    System.out.println("three weeks were not enough to code this ");
                }
                else if(option.equals("E")){//finish application
                    return;
                }
            } catch (IOException ex) {
                Logger.getLogger(CommandLine.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }

    /**
     * Shows the order menu and the current state of the order selected
     * Options:
     * 
     * Show full specification
     * Finish current state
     * Update order
     * Cancel order
     * Return to main menu
     * 
     * @param order
     * @param bp
     * @throws IOException 
     */
    private static void orderMenu(Order order, BicycleProduction bp) throws IOException {
        BufferedReader in = new BufferedReader ( 
                    new InputStreamReader (System.in ) );
        
        while ( true ) {
        System.out.println("\nOrder status: ");
        System.out.println("Customer: "+ order.getCustomerName());
        System.out.println("State: "+ order.getCurrentStateName());
            
        System.out.println ( "\n Select an option: " );
        System.out.println ( "  1) Show full specification" );
        System.out.println ( "  2) Finish current state" );
        System.out.println ( "  3) Update order" );
        System.out.println ( "  4) Cancel order" );
        System.out.println ( "  r) Return to main menu" );

        switch(in.readLine()){//Show full specification
            case "1":
                System.out.println ( "\n\n\n\n\n\n\n\n\n\n");
                System.out.println ( "Color: " + order.getSpec().getColor());
                System.out.println ( "Frame: ");
                System.out.println ( "  Model: " + order.getSpec().getFrame().getModel());
                System.out.println ( "  Brand: " + order.getSpec().getFrame().getBrand());
                System.out.println ( "  Material: " + order.getSpec().getFrame().getMaterial());
                System.out.println ( "  Size: " + order.getSpec().getFrame().getSize());
                System.out.println ( "  Price: " + order.getSpec().getFrame().getPrice());
                System.out.println ( "Component Set: ");
                System.out.println ( "  Component Set: " + order.getSpec().getComponentSet().getModel());
                System.out.println ( "  Brand: " + order.getSpec().getComponentSet().getBrand());
                System.out.println ( "  Material: " + order.getSpec().getComponentSet().getMaterial());
                System.out.println ( "  Price: " + order.getSpec().getComponentSet().getPrice());
                System.out.println ( "Service cost: " + order.getSpec().getAssemblyCost());
                System.out.println ( "Total Price: " + order.getSpec().getTotalPrice());
                break;
            case "2": //Finish current state
                try {
                    bp.process(order);
                } catch (OrderException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Order not processed");
                }
            
                break;
            case "3": //Update order
                updateOrderMenu(order,bp);
                break;
            case "4":{
            try {
                //Cancel order
                bp.cancelProduction(order);
                } catch (OrderException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Order not cancelled");
                }
        }
                break;
            case "r":
                return;
            default:
                break;
        }
    }
    }
    
    /**
     * Shows the update order menu with the followin options:
     * change color
     * change frame
     * change component set
     * return to order menu
     * 
     * @param order
     * @param bp
     * @throws IOException 
     */
    private static void updateOrderMenu(Order order, BicycleProduction bp) throws IOException {
        BufferedReader in = new BufferedReader ( 
                    new InputStreamReader (System.in ) );
        
        while ( true ) {
        System.out.println("Order status: ");
        System.out.println("Customer: "+ order.getCustomerName());
        System.out.println("State: "+ order.getCurrentStateName());
            
        System.out.println ( " Select an option: " );
        System.out.println ( "  1) Change color" );
        System.out.println ( "  2) Change frame" );
        System.out.println ( "  3) Change component Set" );
        System.out.println ( "  r) Return to Order menu" );

        switch(in.readLine()){
            case "1":
                System.out.println("Select the color : ");
                System.out.println ( "  1) Black" );
                System.out.println ( "  2) Blue" );
                System.out.println ( "  3) Red" );
                System.out.println ( "  4) White" );
                Color color = null;
                switch(in.readLine()){
                    case "1":
                        color = Color.Black;
                        break;
                    case "2":
                        color = Color.Blue;
                        break;
                    case "3":
                        color = Color.Red;
                        break;
                    case "4":
                        color = Color.White;
                        break;
                    default:
                        color = Color.Black;
                        System.out.println("No color selected. Default color Black seleted.");
                        break;
                }

                try {
                    //try to change the color
                    bp.changeColor(order, color);
                    System.out.println("Order sucessfully changed");
                //if the current order state does not allow to change the color
                //an exception is thrown
                } catch (BikeContructorException | OrderException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Order not changed");
                }
                break;
                
            case "2": //Change frame
                System.out.println("Select the frame : ");
                    
                int i=1;
                for(Frame availableFrame:bp.getFrameCatalog()){
                    System.out.println ( "  "+ i++ +") "+availableFrame.getModel()+ " Price: £"+availableFrame.getPrice());
                }

                Frame frame = bp.getFrameCatalog().get(Integer.parseInt(in.readLine())-1);
                
                try {
                    bp.changeFrame(order, frame);
                    System.out.println("Order sucessfully changed");
                //if the current order state does not allow to change the frame
                //an exception is thrown
                } catch (BikeContructorException | OrderException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Order not changed");
                }
                break;
            case "3"://change component set
                System.out.println("Select the component set : ");
                    
                    i=1;
                    for(ComponentSet availableComp:bp.getComponentSetCatalog()){
                        System.out.println ( "  "+ i++ +") "+availableComp.getModel()+ " Price: £"+availableComp.getPrice());
                    }
                    
                    ComponentSet component = bp.getComponentSetCatalog().get(Integer.parseInt(in.readLine())-1);
                try {
                    bp.changeComponentSet(order, component);
                    System.out.println("Order sucessfully changed");
                //if the current order state does not allow to change the component set
                //an exception is thrown
                } catch (BikeContructorException | OrderException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Order not changed");
                }
                break;
            case "r":
                return;
            default:
                break;
        }
    }
    }

}
