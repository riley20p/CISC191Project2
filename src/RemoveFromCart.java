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
 *         Contains methods and fields for an custom button.
 */
public class RemoveFromCart extends JButton
{
	//RemoveFromCart has a Item
	private Item storedItem;
	
	/**
	 * args-constructor to create a RemoveFromCart
	 * @param item
	 */
	public RemoveFromCart(Item item)
	{
		storedItem = item;
	}
	
	/**
	 * Getter method that retrieves stored item object
	 * @return storedItem
	 */
	public Item getItem()
	{
		return storedItem;
		
	}
	
	
}