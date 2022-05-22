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
 *         Custom exception for if cart is empty.
 *         
 */

public class CartIsEmpty extends Exception
{
	/**
	 * constructor with args that takes in a string message
	 * 
	 * @param message
	 */
	public CartIsEmpty(String string)
	{
		super(string);
	}

}
