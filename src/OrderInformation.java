/** 
 * Lead Author(s): 
 * @author Riley Phan; 5550006344
 * @author Sarena P
 * 
 * References: 
 * Morelli, R., & Walde, R. (2016).  
 * Java, Java, Java: Object-Oriented Problem Solving 
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-
java-object-oriented-problem-solving 
 * 
 * Version: 2021-12 (4.22.0)
 * Responsibilities of class:
 * Methods that use objects and args, storing variables, constructing objects. 
 * Holds information about a receipt on a bank account balance charge.
 */

public class OrderInformation
{
	
	//fields needed for the Order class
	
	//Order has a Cart - Riley
	private Cart placedCartOrder;
	
	//incrementer variable - Riley 
	private static int orderIdIncreaser = 1;
	
	//unique order ID - Riley
	private int orderId = 0;

	// boolean statement telling us if the order has been refunded/canceled or not 
	private boolean orderStatus = false;
	
	//order total - Riley
	private double orderAmount = 0;
	
	/**
	 * a constructor that takes in a customerOrder cart and creates a unique order information. 
	 * @param customerOrder
	 */
	OrderInformation(Cart customerOrder){
		//stores cart information with that order
		placedCartOrder = new Cart(customerOrder);
		
		//create unique order number
		orderId += orderIdIncreaser;
		
		//increase static number to make each order number unique
		orderIdIncreaser++;
		
		//set the order Status to be true indicating it has been placed
		orderStatus = true;
		
		//Call a method called setOrderAmout to set the orderAmount for that order.
		setOrderAmount();
	}
	/**
	 * a constructor that takes in a amount cart and creates a unique order information. 
	 * @param amount
	 */
	OrderInformation(double amount){
		//stores cart information with that order
		
		//create unique order number
		orderId += orderIdIncreaser;
		
		//increase static number to make each order number unique
		orderIdIncreaser++;
		
		//set the order Status to be true indicating it has been placed
		orderStatus = true;
		
		//Call a method called setOrderAmout to set the orderAmount for that order.
		orderAmount = amount;
	}
	
	/**
	 * sets the order that was placed's cart to the cart for the OrderInformation object.
	 * @param cart
	 */
	public void orderPlaced(Cart cart) 
	{
		placedCartOrder = new Cart(cart);
	}
	
	/**
	 * return a boolean to determine if the order was confirmed or was refunded 
	 * @return a boolean
	 */
	public boolean getOrderStatus() {
		return orderStatus;
	}
	
	/**
	 * setter method to set the order status to any condition
	 * @param condition
	 */
	public void setOrderStatus(boolean condition) {
		orderStatus = condition;
	}
	
	/**
	 * setter method to set the order total for that order 
	 */
	public void setOrderAmount() {
		this.orderAmount = placedCartOrder.displaySubtotal();
	}
	
	/**
	 * getter method to set the order total for that order 
	 * @return subtotal of the order
	 */
	public double getOrderAmount()
	{
		return orderAmount;
	}
	
	/**
	 * method that returns the cart array of a particular order
	 * @return the cart of the placed order
	 */
	public Cart returnCartOfOrder()
	{
		return placedCartOrder;
	}

	/**
	 * toString method overriden that gives information about order number, status and subtotal a order. 
	 */
	@Override
	public String toString() {
		return "Order #" + orderId + " || Order Confirmed: " + orderStatus + " || Subtotal: $" + orderAmount;
	}
	
	
}
