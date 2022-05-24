import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

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
 *         Contains methods and fields for a GUI and displaying a restaurant
 *         ordering system app.
 */

public class ResturantViewModel extends JFrame
{
	// ResturantViewModel has a Menu
	private Menu menu;
	// ResturantViewModel has a Customer
	private Customer user;

	// ResturantView GUI is divided into 3 panels, left, middle and right

	// All the stuff below is the left panel
	//// ResturantViewModel has a left panel.
	private JPanel leftPanel;
	// ResturantViewModel has a title label for the left panel
	private JLabel menuLabel;
	// ResturantViewModelhas a panel for menu items
	private JPanel menuItemsPanel;
	// ResturantView has a label for all the menu items
	private JLabel menuItemsLabel;

	// All the stuff below is the middle panel
	// ResturantViewModel has a middle panel.
	private JPanel middlePanel;
	//// ResturantViewModelhas a bank balance label
	private JLabel bankBalanceLabel;
	// ResturantViewModel has a add 20 dollars button
	private JButton add20DollarsButton;
	// ResturantViewModel has a view recent orders button
	private JButton viewRecentOrder;
	// ResturantViewModel has a second panel within itself to put to the top
	private JPanel middlePanel2;
	// ResturantViewModel has a reorder button .
	private JButton reOrder;
	// ResturantViewModel has a refund recent order button
	private JButton refundRecentOrder;

	// All the stuff below is for the right panel
	// ResturantViewModel has a right panel
	private JPanel rightPanel;
	// ResturantViewModel has a cart label
	private JLabel cartTitle;
	// ResturantViewModel has a label for the items
	private JLabel itemsLabel;
	// ResturantViewModel has a button to remove item from cart
	private RemoveFromCart removeFromCartButton;
	// ResturantViewModel has a panel for the items
	private JPanel cartItemsPanel;
	// ResturantViewModel has a subtotal label
	private JLabel subtotal;
	// ResturantViewModel has a checkout button
	private JButton checkout;
	// ResturantViewModel has a panel to put label for subtotal and checkout
	// button
	private JPanel rightPanelEnd;
	// ResturantViewModel has a border for its panels
	private Border lineBorder;

	public ResturantViewModel(Menu passedMenu, Customer passedUser)
	{
		menu = passedMenu;
		user = passedUser;

		// stuff for the left panel

		// initiates the left panel
		leftPanel = new JPanel();
		// left panel has a border layout
		leftPanel.setLayout(new BorderLayout());

		// set border color
		lineBorder = BorderFactory.createLineBorder(Color.DARK_GRAY);

		// sets left panel's border
		leftPanel.setBorder(lineBorder);

		// creates label with the text "Menu"
		menuLabel = new JLabel("Menu");
		// set the font size to 30
		menuLabel.setFont(new Font("Arial", Font.BOLD, 30));

		// centers label to middle of this panel.
		menuLabel.setHorizontalAlignment(JLabel.CENTER);

		// adds the menu label to the left panel and puts it on top
		leftPanel.add(menuLabel, BorderLayout.NORTH);

		// create a panel for the menu items
		menuItemsPanel = new JPanel();
		// set the layout to be a grid layout where it will stack to be the menu
		// name and a button.
		menuItemsPanel.setLayout(new GridLayout(0, 2));

		// a for loop that cycles through the menu txt file and adds them to the
		// menuItemsPanel panel
		for (int i = 0; i < menu.getNumberOfItemsInMenu(); i++)
		{

			// creates a label with the item name and price
			menuItemsLabel = new JLabel(menu.returnMenu()[i].getItemName()
					+ " $" + menu.returnMenu()[i].getPrice());
			// centers the text
			menuItemsLabel.setHorizontalAlignment(JLabel.CENTER);
			// creates a button for each item and passes in the item to the
			// button. This will give a
			// association with item with the button
			AddToCartButton button = new AddToCartButton(menu.returnMenu()[i],
					1);
			// adds a action listener to each button
			button.addActionListener(new AddToCartButtonListener(this, button));

			// add the button and label to the panel.
			menuItemsPanel.add(menuItemsLabel);
			menuItemsPanel.add(button);
			// set text of the button to say add to cart
			button.setText("Add To Cart");

		}
		// add the menu items panel to the left panel
		leftPanel.add(menuItemsPanel, BorderLayout.CENTER);

		// initiates the left panel
		middlePanel = new JPanel();
		// set a border for the panel
		middlePanel.setBorder(lineBorder);
		// create a panel for the middle part of the program
		middlePanel2 = new JPanel();
		// set the layout for the middle panel to be gridbaglayout
		middlePanel2.setLayout(new GridBagLayout());

		// create a label to display bank balance of the user
		bankBalanceLabel = new JLabel("Current Balance: $" + user.getBalance());
		// set the font to 30 and to be bold
		bankBalanceLabel.setFont(new Font("Arial", Font.BOLD, 30));
		// center the text
		bankBalanceLabel.setHorizontalAlignment(JLabel.CENTER);
		// creates a button to add 20 dollars
		add20DollarsButton = new JButton("Add $20");
		// creates a button to refund recent order
		refundRecentOrder = new JButton("Refund Recent Order");
		// creates a button to refund recent order
		reOrder = new JButton("Reorder Recent Order");
		// creates a button to view recent orders
		viewRecentOrder = new JButton("View Recent Orders");

		// adds a action listener to the add20Dollars button
		add20DollarsButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// updates the user's bank account balance
				user.add20Dollars();
				// refresh balance label to reflect on screen
				updateBalance();
			}
		});

		// adds a action listener to the refundRecentOrder button
		refundRecentOrder.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// refunds recent order and updates balance
				JOptionPane.showMessageDialog(null, user.cancelOrder());
				updateBalance();
			}
		});

		// reorder recent order
		reOrder.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{

				// trys to reorder
				JOptionPane.showMessageDialog(null, user.reOrder());

				// update balance displayed on screen
				updateBalance();
			}
		});

		viewRecentOrder.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, user.displayOrderHistory());
				updateBalance();
			}
		});
		// create a GridBagConstraint object to specifies constraints for
		// components that are laid out using the GridBagLayout class.
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		// sets spacing for each button
		gridBagConstraints.insets = new Insets(4, 4, 4, 4);

		// below adds each widget to the panel and then stacks them vertically
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		middlePanel2.add(bankBalanceLabel, gridBagConstraints);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		middlePanel2.add(add20DollarsButton, gridBagConstraints);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		middlePanel2.add(refundRecentOrder, gridBagConstraints);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		middlePanel2.add(reOrder, gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 8;
		middlePanel2.add(viewRecentOrder, gridBagConstraints);

		// adds the panel to the actual middle panel and puts that panel to the
		// top.
		middlePanel.add(middlePanel2, BorderLayout.NORTH);

		// creates the right panel
		rightPanel = new JPanel();
		// sets right panel as a border layout
		rightPanel.setLayout(new BorderLayout());
		// adds a border for the right panel
		rightPanel.setBorder(lineBorder);

		// creates a cart title for the right panel
		cartTitle = new JLabel("Cart");
		// set font, size and style for the cart label
		cartTitle.setFont(new Font("Arial", Font.BOLD, 30));
		// centers text
		cartTitle.setHorizontalAlignment(JLabel.CENTER);

		// add the label to the right panel
		rightPanel.add(cartTitle, BorderLayout.NORTH);

		// create a panel for items added to the cart
		cartItemsPanel = new JPanel();
		// set layout to be a grid layout where its name of item and button to
		// remove it
		cartItemsPanel.setLayout(new GridLayout(0, 2));

		// add panel where the items will be displayed in the center
		rightPanel.add(cartItemsPanel, BorderLayout.CENTER);

		// create a separate panel for subtotal and button to checkout
		rightPanelEnd = new JPanel();

		// set the layout to be gridlayout
		rightPanelEnd.setLayout(new GridLayout(1, 1));

		// create a label that display subtotal of the user
		subtotal = new JLabel("subtotal: $" + user.showCartSubtotal());
		// set label's font and size and style
		subtotal.setFont(new Font("Arial", Font.BOLD, 22));
		// centers label
		subtotal.setHorizontalAlignment(JLabel.CENTER);
		// add the label to the right panel
		rightPanelEnd.add(subtotal);

		// create a button for checking out
		checkout = new JButton("Checkout");
		// add the button to the right panel at the end
		rightPanelEnd.add(checkout);

		// adds a action lisnter to the checkout button
		checkout.addActionListener(new ActionListener()
		{
			// anonymous inner class for the action listener
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					// user object will place order and withdraw money
					user.placeOrder();
					// clear the cart for a new order
					clearCart();
					// update and refresh balance and subtotal to zero
					updateBalance();
					updateSubtotal();
					// popout saying the order has been placed
					JOptionPane.showMessageDialog(null, "Order Placed!");
				}
				// catch custom exception if user does not have enough moeny
				catch (NotEnoughMoney e1)
				{
					JOptionPane.showMessageDialog(null,
							"You do not have enought money");
				}
				// catch custom exception if user has a empty cart
				catch (CartIsEmpty e1)
				{
					JOptionPane.showMessageDialog(null,
							"You have nothing in your cart, please add stuff.");
				}
			}
		});

		// add the panel with checkout button and subtotal label to the right
		// panel
		rightPanel.add(rightPanelEnd, BorderLayout.SOUTH);

		// set the layout of the frame to be a grid layout where there will be 3
		// sections
		this.setLayout(new GridLayout(1, 3));
		// add the left, middle and right panel to the frame
		this.add(leftPanel);
		this.add(middlePanel);
		this.add(rightPanel);
		// shutdown on close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set title of the program
		this.setTitle("Resturant App");
		// set size of program
		this.setSize(1500, 1000);
		// set visibility to true
		this.setVisible(true);

	}

	/**
	 * Pass a item object with a quantity and display it to the user when the
	 * press add to cart button.
	 * 
	 * @param item
	 * @param quantityOfItems
	 */
	public void updateCart(Item item, int quantityOfItems)
	{
		// create a temp item object to store the passed item
		Item tempItem = new Item(item);
		// Pass a item object with a quantity and add to cart.
		user.addToCart(tempItem, quantityOfItems);
		// create a label where it displays the item name.
		itemsLabel = new JLabel(user.returnCartArray()
				.get(user.getNumberOfItemsInCart() - 1).getItemName());
		// center the text
		itemsLabel.setHorizontalAlignment(JLabel.CENTER);
		// add the label to the cart panel
		cartItemsPanel.add(itemsLabel);
		// create a button that takes in a item object
		removeFromCartButton = new RemoveFromCart(tempItem);
		// set text of button
		removeFromCartButton.setText("Click to remove");
		// adds a action listener to the button
		removeFromCartButton.addActionListener(
				new RemoveFromCartListener(this, removeFromCartButton));

		// add the button to the cart panel
		cartItemsPanel.add(removeFromCartButton);

		// update subtotal after adding item to cart
		updateSubtotal();

		// tell with a popup user they have added a item to cart
		JOptionPane.showMessageDialog(null,
				"You have added " + item.getItemName() + " to your cart");

	}

	/**
	 * Remove item from cart and updates cart UI display for the user
	 * 
	 * @param item
	 */
	public void removeItem(Item item)
	{
		// Removes the first occurrence of the specified element from this list
		user.removeFromCart(item);

		// remove the cart panel
		rightPanel.remove(cartItemsPanel);
		// create a *new* cart panel
		cartItemsPanel = new JPanel();
		// reset the layout
		cartItemsPanel.setLayout(new GridLayout(0, 2));

		// for loop that checks for all items in the cart and creates a button
		// and label for each item
		for (int i = 0; i < user.returnCartArray().size(); i++)
		{
			itemsLabel = new JLabel(user.returnCartArray()
					.get(user.getNumberOfItemsInCart() - 1).getItemName());
			itemsLabel.setHorizontalAlignment(JLabel.CENTER);
			cartItemsPanel.add(itemsLabel);

			// create a button and adds a action listener to the button
			RemoveFromCart button = new RemoveFromCart(
					user.returnCartArray().get(i));
			button.setText("Click to remove");
			button.addActionListener(new RemoveFromCartListener(this, button));

			cartItemsPanel.add(button);

		}
		// readds cart panel back to the right panel
		rightPanel.add(cartItemsPanel);
		// update subtotal after remvoing item.
		updateSubtotal();
	}

	/**
	 * removes all items from cart and redisplays a empty cart to the user
	 */
	public void clearCart()
	{
		// remove the cart panel
		rightPanel.remove(cartItemsPanel);
		// create a *new* cart panel
		cartItemsPanel = new JPanel();
		// reset the layout
		cartItemsPanel.setLayout(new GridLayout(0, 2));
		// readds cart panel back to the right panel
		rightPanel.add(cartItemsPanel);
		// refresh UI for the user .
		refresh();
	}

	/**
	 * reloads JPanel and updates for the user
	 */
	public void refresh()
	{
		this.getContentPane().invalidate();
		this.getContentPane().validate();
	}

	/**
	 * update text of user's balance
	 */
	public void updateBalance()
	{
		bankBalanceLabel.setText("Current Balance: $" + user.getBalance());

	}

	/**
	 * update text of user's subtotal
	 */
	public void updateSubtotal()
	{
		subtotal.setText("subtotal: $" + user.showCartSubtotal());
	}

}
