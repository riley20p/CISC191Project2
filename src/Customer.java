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
 *         Holds information about a receipt on a credit card charge.
 */

public class Customer extends Person
{

	// fields needed for a customer

	// Customer has a Cart;
	private Cart cart = new Cart();

	// Customer has a array of OrderInformation objects with a max storage of
	// 100 orders objects
	// keeps track of all placed orders.
	private OrderInformation[] orderHistory = new OrderInformation[100];

	// Counter for the number of order placed to keep track for indexing
	private int numberOfOrdersPlaced = 0;

	// Customer has a BankAccount
	private BankAccount bankAccount;

	// args-constructor to create a customer object
	/**
	 * Purpose: args-constructor to create a customer object
	 * 
	 * @param firstName
	 * @param lastName
	 * @param startingBalance
	 */
	Customer(String firstName, String lastName, double startingBalance)
	{
		super(firstName, lastName);
		this.bankAccount = new BankAccount(startingBalance);
	}

	/**
	 * Replaces the previous order by calling placeOrder() method by setting the
	 * customer's cart to the previous cart
	 * 
	 * @throws NotEnoughMoney
	 * @throws CartIsEmpty
	 */
	public String reOrder() 
	{
		// If there is no order, throw CartIsEmpty exception
		if (numberOfOrdersPlaced == 0)
		{
			return "You have not placed any orders";
		}

		// Sets previous cart from the previous order to the cart to reorder
		// from.

		// if customer does not have enough money, throw exception
		if (orderHistory[numberOfOrdersPlaced-1].getOrderAmount() > this.bankAccount.getBalance())
		{
			return "You do not have enough money!";
		}

		// withdraw x amount of money from balance
		bankAccount.withdrawMoney(orderHistory[numberOfOrdersPlaced-1].getOrderAmount());

		// if number of orders reaches 100 orders, set numberOfOrdersPlaced
		// variable to 0
		if (numberOfOrdersPlaced == 100)
		{
			numberOfOrdersPlaced = 0;
		}
		
		// creates a new OrderInformation object which passes in current
		// customer's cart to store that information about customer's order.
		orderHistory[numberOfOrdersPlaced] = new OrderInformation(orderHistory[numberOfOrdersPlaced-1].getOrderAmount());
		numberOfOrdersPlaced++;
		// increase the counter to tell us how many orders have been placed.
		
		return "Order has be reordered";

	}

	/**
	 * Purpose: If the customer has enough money in his/her bank account or has
	 * items in cart, customer can place order.
	 * 
	 * @throws NotEnoughMoney
	 * @throws CartIsEmpty
	 */
	public void placeOrder() throws NotEnoughMoney, CartIsEmpty
	{
		// if cart is empty, throw custom exception indicating cart is empty
		if (cart.getNumberOfItemsInCart() == 0)
		{
			throw new CartIsEmpty("You have nothing in your cart!");
		}

		// if customer does not have enough money, throw exception
		if (cart.displaySubtotal() > this.bankAccount.getBalance())
		{
			throw new NotEnoughMoney("You dont have enough funds!");
		}

		// withdraw x amount of money from balance
		bankAccount.withdrawMoney(cart.displaySubtotal());

		// if number of orders reaches 100 orders, set numberOfOrdersPlaced
		// variable to 0
		if (numberOfOrdersPlaced == 100)
		{
			numberOfOrdersPlaced = 0;
		}

		// creates a new OrderInformation object which passes in current
		// customer's cart to store that information about customer's order.
		orderHistory[numberOfOrdersPlaced] = new OrderInformation(cart);

		// increase the counter to tell us how many orders have been placed.
		numberOfOrdersPlaced++;

		// clears cart after confirming order
		cart.clearCart();

	}
	
	

	/**
	 * Purpose: Cancel recent order and refunds money - Riley
	 */
	public String cancelOrder()
	{
		// Checks if there is a recent order
		if (numberOfOrdersPlaced == 0)
		{
			return ("You have no recent order to cancel!");
		}

		// Checks if order has already been canceled or not
		else if (orderHistory[numberOfOrdersPlaced - 1]
				.getOrderStatus() == true)
		{
			// use method from CreditCard to deposit money back into account
			bankAccount.depositMoney(
					orderHistory[numberOfOrdersPlaced - 1].getOrderAmount());
			// set order status of that order to false indicated it has been
			// refunded or canceled
			orderHistory[numberOfOrdersPlaced - 1].setOrderStatus(false);
			return "Order has been refunded";
		}

		// If the if statements above have not run, the order has been canceled
		else
		{
			return ("Recent order was already cancel!");
		}
	}

	/**
	 * Purpose: Display to console all orders placed by the customer
	 * 
	 */
	public String displayOrderHistory()
	{
		// a do-while to print all of the orders
		String orderHistoryInfo = "";
		int intialValue = 0;
		do
		{
			// if first element in orderHistory is null means there are no
			// orders so end the loop
			if (orderHistory[0] == null)
			{
				return "You have placed no orders";
			}
			// if the current element during the iteration is null (meaning
			// there is no more orders to display), end the do-while loop
			else if (orderHistory[intialValue] == null)
			{
				intialValue = 999;
			}
			// print the element of the index of the current iteration, this
			// will display to console customer's order information of that
			// order
			else
			{
				orderHistoryInfo += (orderHistory[intialValue]) + "\n";
				intialValue++;
			}
		} while (intialValue < orderHistory.length);
		return orderHistoryInfo;

	}

	/**
	 * Purpose: Add items to your cart and choose the quantity of those items.
	 * 
	 * @param item
	 * @param quantity
	 */
	public void addToCart(Item item, int quantity)
	{
		// call a method from the cart object that can pass in a item object and
		// a quantity number
		cart.addToCart(item, quantity);
	}

	/**
	 * Removes object at given index of a array
	 * @param arrayPosition
	 */
	public void removeFromCart(int arrayPosition)
	{
		cart.removeFromCart(arrayPosition);
	}

	/**
	 * If customers wants to remove all items from cart, clear the cart.
	 * 
	 * @throws CartIsEmpty
	 */
	public void clearCart() throws CartIsEmpty
	{
			cart.clearCart();
	}

	/**
	 * Purpose: Method that changes the quantity of item in the cart. - Riley
	 * 
	 * @param positionInCart
	 * @param quantity
	 */
	public void setCartItemQuantity(int positionInCart, int quantity)
	{
		cart.getCart().get(positionInCart - 1).setItemQuantity(quantity);
	}

	/**
	 * Purpose: Displays to the console whatever you have in your cart. - Riley
	 */
	public void viewCart()
	{
		System.out.print(cart);
	}
	
	/**
	 * Purpose: Displays to the console whatever you have in your cart subtotal. - Riley
	 */
	public double showCartSubtotal()
	{
		return cart.displaySubtotal();
	}

	/**
	 * Purpose: Displays customer's current card balance to the console
	 * @return 
	 */
	public double getBalance()
	{
		return bankAccount.getBalance();
	}

	/**
	 * Purpose: Add 20 dollars to the customer's bank account just in case they
	 * don't have money
	 */
	public void add20Dollars()
	{
		bankAccount.depositMoney(20);
	}

	/**
	 * Purpose: Return a integer that tells us how many items in their cart.
	 */
	public int getNumberOfItemsInCart()
	{
		return cart.getNumberOfItemsInCart();
	}

	/**
	 * Purpose: Return the actual cart array itself.
	 */
	public LinkedList<Item> returnCartArray()
	{
		return cart.getCart();
	}
	
	/**
	 * Purpose: Removes the first occurrence of the specified element from this list
	 */
	public void removeFromCart(Item item)
	{
		cart.removeFromCart(item);
	}
	
	

}
