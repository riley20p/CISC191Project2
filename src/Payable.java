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
 *         A interface that can make something payable
 */
public interface Payable
{
	/**
	 * a method that gets price.
	 * @param itemPrice
	 */
	double getPrice();

	/**
	 * a method that sets price.
	 * @param itemPrice
	 */
	void setPrice(double itemPrice);
}
