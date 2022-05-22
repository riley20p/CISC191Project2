import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
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
 *         Contains methods and fields for an custom action listener for when users click on a button
 */
public class AddToCartButtonListener implements ActionListener
{
	//AddToCartButtonListener has a ResturantViewModel
	private ResturantViewModel viewModel;
	//AddToCartButtonListener has a AddToCartButton
	private AddToCartButton button;
	
	/**
	 * args-constructor for AddToCartButtonListener that takes in a ResturantViewModel and AddToCartButton
	 * @param viewModel
	 * @param button
	 */
	public AddToCartButtonListener(ResturantViewModel viewModel, AddToCartButton button)
	{
		this.viewModel = viewModel;
		this.button = button;
	}

	/**
	 * Listens for the user to click button and displays items being added to cart
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//Pressing the add to cart will add the item stored with that AddToCartButton to the cart panel.
		viewModel.updateCart(button.getItem(), button.getQuantity());
		viewModel.refresh();
	}
	
	
}
