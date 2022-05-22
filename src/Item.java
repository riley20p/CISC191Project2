/**
 * Lead Author(s):
 * 
 * @author Riley Phan; 5550006344
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016).
 *         Java, Java, Java: Object-Oriented Problem Solving
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-
 *         java-object-oriented-problem-solving
 * 
 *         Version: 2021-12 (4.22.0)
 *         Responsibilities of class:
 *         Methods that use objects and args, storing variables, constructing
 *         objects.
 *         Holds information about what is a item like description, price and quantity.
 */


public class Item implements Payable, Quantifiable
{
	// fields for the items for sale - Riley
	
	// Item needs a name - Riley
	private String itemName;
	// Item needs a price - Riley
	private double itemPrice;
	// item needs a quantity
	private int itemQuantity = 1;
	
	// default constructor - Riley
	Item(String itemName, double itemPrice, int quantity)
	{
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = quantity;
	}
	
	// constructor with args - Riley
	Item(String itemName, double itemPrice) 
	{
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	// copy constructor - Riley
	Item(Item item)
	{
		this.itemName = item.getItemName();
		this.itemPrice = item.getPrice();
		this.itemQuantity = item.getItemQuantity();
	}

	
	/**
	 * Override method of toString
	 */
	@Override
	public String toString()
	{
		return itemName + " || Price: $" + (itemPrice*itemQuantity) + " || (" + itemQuantity + " items)";
	}
	
	// mutators and accessors below this

	/**
	 * method to get name of item - Riley
	 * @return name of item
	 */
	public String getItemName()
	{
		return this.itemName;
	}
		
	/**
	 * Method to set the name of the item - Riley 
	 * @param itemName
	 */
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}
	
	@Override
	/**
	 * Method to get the price of the item - Riley 
	 * @return price
	 */
	public double getPrice()
	{
		return this.itemPrice;
	}

	/**
	 * Method to set the price of the item - Riley 
	 */
	@Override
	public void setPrice(double itemPrice)
	{
		this.itemPrice = itemPrice;
		
	}
	
	/**
	 * Method to get the quantity of the item - Riley 
	 * @return quantity of the item
	 */
	public int getItemQuantity()
	{
		return this.itemQuantity;
	}

	/**
	 * Method to set the quantity of the item - Riley
	 * @param itemQuantity
	 */
	public void setItemQuantity(int itemQuantity)
	{
		this.itemQuantity = itemQuantity;
	}



}
