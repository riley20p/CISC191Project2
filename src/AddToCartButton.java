import javax.swing.JButton;
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
 *         Contains methods and fields for an custom button
 */
public class AddToCartButton extends JButton
{
	//AddToCartButton has a Item
	private Item storedItem;
	//AddToCartButton has a stored integer value
	private int storedQuantity;
	
	/**
	 * args-constructor to create a AddToCartButton that takes in a item and quantity
	 * @param item
	 * @param quantity
	 */
	public AddToCartButton(Item item, int quantity)
	{
		storedItem = item;
		storedQuantity = quantity;
	}
	
	/**
	 * Returns item that was stored with button
	 * @return storedItem
	 */
	public Item getItem()
	{
		return storedItem;
		
	}
	
	/**
	 * Returns quantity that was stored with button
	 * @return storedQuantity
	 */
	public int getQuantity()
	{
		return storedQuantity;
		
	}
	
}
	