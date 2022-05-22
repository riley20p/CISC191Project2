import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class RemoveFromCartListener implements ActionListener
{
	// RemoveFromCartListener has a ResturantViewModel
	private ResturantViewModel viewModel;
	// RemoveFromCartListener has a RemoveFromCart
	private RemoveFromCart button;

	/**
	 * args-constructor to create a AddToCartButton that takes in a
	 * 
	 * @param view
	 * @param button
	 */
	public RemoveFromCartListener(ResturantViewModel viewModel,
			RemoveFromCart button)
	{
		this.viewModel = viewModel;
		this.button = button;
	}

	/**
	 * Listens for the user to click button
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//Removes item from cart and then updates UI with items still in cart
		viewModel.removeItem(button.getItem());
		//updates new subtotal with the removed item
		viewModel.updateSubtotal();

		//refreshes UI and updates for user
		viewModel.refresh();
	}
}
