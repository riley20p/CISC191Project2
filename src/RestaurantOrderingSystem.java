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
 *         The main class of the program where user's can launch and naviagate and shop for food.
 */

public class RestaurantOrderingSystem
{
	public static void main(String[] args)
	{
		//create and initialize a menu object
		Menu menu = new Menu();
		
		//create a customer object and then pass default values
		Customer user = new Customer("John", "Smith", 1000);
		
		//create a ResturantViewModel that will display the program
		ResturantViewModel theView = new ResturantViewModel(menu, user);
	}
}
