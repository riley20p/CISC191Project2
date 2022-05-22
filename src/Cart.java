import java.util.LinkedList;

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
 *         A functional shopping cart, able to add,remove and clear items from cart and then calulcate subtotal
 *         and then checkout.
 */

public class Cart
{
	// Cart has a Item
	// Array that stores Item objects
//	private Item[] shoppingCart = new Item[100];
	
	private LinkedList<Item> shoppingCart = new LinkedList<Item>();

	// Subtotal of items in cart
	private double subtotalOfCart = 0.00;

	// quantity of items in cart
	private int quantityOfItems = 0;

	// Counter variable to indicate index of each item
	private int positionOfItems = 0;

	/**
	 * no args constructor
	 */
	Cart()
	{
	}

	/**
	 * copy constructor that takes in a cart object
	 * 
	 * @param cart
	 */
	Cart(Cart passedCart)
	{
		shoppingCart = new LinkedList<Item>();
		this.positionOfItems = passedCart.positionOfItems;

		for (int i = 0; i < passedCart.shoppingCart.size(); i++)
		{
			this.shoppingCart.add(passedCart.shoppingCart.get(i)
					);
		}
	}

	/**
	 * returns the number of items in the cart
	 * 
	 * @return positionOfItems
	 */
	public int getNumberOfItemsInCart()
	{
		return positionOfItems;
	}

	/**
	 * a method that takes in a item object and a number to change the quantity
	 * and then add to the cart.
	 * 
	 * @param item
	 * @param quantity
	 * @throws CartIsFull
	 */
	public void addToCart(Item item, int quantity)
	{
		shoppingCart.add(item);

		shoppingCart.get(positionOfItems).setItemQuantity(quantity);

		// increase quantity of items in cart by 1 after adding something to
		// cart
		positionOfItems++;
	}

	/**
	 * Remove a element from a passed arrayPosition integer as the index
	 * 
	 * @param arrayPosition
	 */
	public void removeFromCart(int arrayPosition)
	{
		// If element is null at the given index, do nothing.
		if (shoppingCart.get(arrayPosition - 1) != null)
		{
			// decrease counter for how many indexs in the array which elements
			// are not null
			positionOfItems--;
			// Set the item to null.
			shoppingCart.set(arrayPosition - 1, null);

			int arrayShifter = arrayPosition - 1;

			// essentially a for loop converted to a do-while loop
			// Remove the item and shift each item object one index to the left.
			do
			{
				// no need to shift any thing because the item is at the end of
				// the array
				if (arrayShifter == 100)
				{
					arrayShifter = 1000;
				}
				// Checks to make sure not to copy a null element so we end the
				// do-while loop
				else if (shoppingCart.get(arrayShifter+1) == null)
				{
					arrayShifter = 1000;
				}

				// if the next index of your given position index is not null,
				// keep shifting each element to the left in the array
				else
				{
					Item tempItem = shoppingCart.get(arrayShifter+1);
					shoppingCart.set(arrayShifter, tempItem);
					arrayShifter++;
				}
			} while (arrayShifter < shoppingCart.size());
		}
		else
		{

			throw new NullPointerException(
					"You cannot remove \"nothing\" from cart");
		}

	}

	/**
	 * return the cart array that contains all of the item objects
	 * 
	 * @return itemsInCart
	 */
	public LinkedList<Item> getCart()
	{
		return shoppingCart;
	}

	/**
	 * calculate the quantity of items all together in the cart.
	 */
	public void calculateQuantity()
	{
		// a counter variable
		quantityOfItems = 0;

		for (int i = 0; i < positionOfItems; i++)
		{
			quantityOfItems = shoppingCart.get(i).getItemQuantity()
					+ quantityOfItems;
		}
	}

	/**
	 * getter method to return item quantity
	 * 
	 * @return the quantity of items.
	 */
	public int getQuantity()
	{
		calculateQuantity();
		return this.quantityOfItems;
	}

	/**
	 * clears cart by setting the current array to a new array with 100 slots
	 * and reseting other variables
	 */
	public void clearCart()
	{
		shoppingCart = new LinkedList<Item>();
		quantityOfItems = 0;
		positionOfItems = 0;
	}

	/**
	 * a method that calculates subtotal and updates subtotalOfCart variable
	 */
	public void calculateSubtotal()
	{
		subtotalOfCart = 0;
		
		if (positionOfItems != 0)
		{
			for (int i = 0; i < positionOfItems; i++)
			{

				subtotalOfCart = subtotalOfCart
						+ (shoppingCart.get(i).getPrice()
								* shoppingCart.get(i).getItemQuantity());
			}
		}
	}

	/**
	 * getter method to return subtotal
	 * 
	 * @return subtotalOfCart
	 */
	public double displaySubtotal()
	{
		// use method to recalculate subtotal if user adds new items to cart
		calculateSubtotal();

		return subtotalOfCart;
	}
	

	/**
	 * Matches item object with item in cart and removes it.
	 * @param item
	 * @return
	 */
	public void removeFromCart(Item item)
	{
		shoppingCart.remove(item);
		positionOfItems--;
	}

	/**
	 * Override toString method and return a string that contains all the items
	 * in cart.
	 */
	@Override
	public String toString()
	{
		String cartInfo = "================== \n" + "ITEMS IN CART \n"
				+ "================== \n";

		for (int i = 0; i < positionOfItems; i++)
		{
			cartInfo += (i + 1) + ". " + shoppingCart.get(i).getItemName()
					+ " || Price: $"
					+ (shoppingCart.get(i).getPrice()
							* shoppingCart.get(i).getItemQuantity())
					+ " || (" + shoppingCart.get(i).getItemQuantity() + " items)"
					+ "\n";

		}
		cartInfo += ("Subtotal (" + getQuantity() + " items)" + ": $"
				+ displaySubtotal() + "\n");

		return cartInfo;
	}

}
