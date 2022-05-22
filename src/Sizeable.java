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
 *         Make a class or something sizeable
 */
public interface Sizeable
{
	/**
	 * Set size of item
	 * @param item's size
	 */
	public void setSize(int itemSize);
	
	/**
	 * get size of item
	 * @return size of item
	 */
	public int getSize();
}
