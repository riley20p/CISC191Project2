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
 *         Holds information about creating and describing a drink.
 */


public class Drink extends Item implements Sizeable
{
	// fields

	// Drink class needs a drink size
	private int drinkSize = 0;

	/**
	 * a constructor that takes in a args for itemName, itemPrice, quantity and
	 * drinkSize
	 * 
	 * @param itemName
	 * @param itemPrice
	 * @param quantity
	 * @param drinkSize
	 */
	Drink(String itemName, double itemPrice, int quantity, int drinkSize)
	{
		super(itemName, itemPrice, quantity);
		this.drinkSize = drinkSize;
	}

	/**
	 * a constructor that takes in a args for itemName, itemPrice, and drinkSize
	 * 
	 * @param itemName
	 * @param itemPrice
	 * @param drinkSize
	 */
	Drink(String itemName, double itemPrice, int drinkSize)
	{
		super(itemName, itemPrice);
		this.drinkSize = drinkSize;
	}

	/**
	 * getter method that returns drink name and size.
	 * 
	 * @return string that has drink's name and drink size.
	 */
	public String getItemName()
	{
		return super.getItemName() + " " + getSize() + "oz";
	}

	/**
	 * setter method that sets drink size.
	 * 
	 * @param drinkSize
	 */
	public void setSize(int drinkSize)
	{
		this.drinkSize = drinkSize;
	}

	/**
	 * getter method that returns drink size
	 * 
	 * @return drink size
	 */
	public int getSize()
	{
		return drinkSize;
	}

	/**
	 * a getter method to return drink's price depending on drink size
	 * 
	 * @return drink price plus custom tax on drink depending on drink size
	 */
	public double getPrice()
	{
		if (drinkSize <= 5)
		{
			return 1.00;
		}
		else
		{
			return 2.00;
		}
	}

	/**
	 * Override method of toString
	 * 
	 * @Override
	 */
	public String toString()
	{
		return this.getItemName() + ", " + this.getSize();
	}
}
