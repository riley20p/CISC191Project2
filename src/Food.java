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
 *         Holds information about a food object like description, price and quantity.
 */

public class Food extends Item
{
	/**
	 * basic copy constructor that takes in a item
	 * @param item
	 */
	Food(Item item)
	{
		super(item);
	}
	
	/**
	 *  a constructor that takes in a args for itemName, itemPrice, quantity
	 * @param itemName
	 * @param itemPrice
	 * @param quantity
	 */
	Food(String itemName, double itemPrice, int quantity)
	{
		super(itemName, itemPrice, quantity);
	}
	
	
	/**
	 *  a constructor that takes in a args for itemName, itemPrice,
	 * @param itemName
	 * @param itemPrice
	 */
	Food(String itemName, double itemPrice) 
	{
		super(itemName, itemPrice);
	}
	
	/**
	 * Override of the toString method and returns the item's name
	 * @return item's name
	 * @Override
	 */
	public String toString()
	{
		return this.getItemName();
	}
}
