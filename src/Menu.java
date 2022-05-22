import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/** 
 * Lead Author(s): 
 * @author Riley Phan; 5550006344
 * @author Sarena P
 * 
 * References: 
 * Morelli, R., & Walde, R. (2016).  
 * Java, Java, Java: Object-Oriented Problem Solving 
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-
java-object-oriented-problem-solving 
 * 
 * Version: 2021-12 (4.22.0)
 * Responsibilities of class:
 * Methods that use objects and args, storing variables, constructing objects. 
 * Holds information about the store's menu. Upload menu from a text file.
 */

public class Menu
{
	/**
	 * No-args constructor
	 */
	Menu()
	{
		try
		{
			uploadMenu();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Menu has a Item
	// Menu stores items in a array for customers to chose from and add to their
	// item array cart.
	private Item[] menuCatalog = new Item[100];

	// A multidimensional String array where first part contains item name and
	// second part has the price of the item
	private String[][] menuList = new String[100][2];

	// Indicator of how many items are on the menu, mostly for indexing purposes
	private int positionOfItems = 0;

	/**
	 * Purpose: Take input from a text file, read lines from text file and turn
	 * them into item objects and put them on the menuCatalog array.
	 * 
	 * @throws FileNotFoundException
	 */
	public void uploadMenu() throws FileNotFoundException
	{

		positionOfItems = 0;

		// declare a file object and pass our FoodMenu text document
		// The text document is split by name and price and seperated by a ","
		File textFile = new File("FoodMenu.txt");

		// create a scanner object to read our "FoodMenu" file
		Scanner fileFoodInput = new Scanner(textFile);

		// A while loop read each line and stops reading after there are no more
		// lines to read
		while (fileFoodInput.hasNextLine())
		{
			// Set the current line to a string variable
			String currentLine = fileFoodInput.nextLine();
			// Call the split method from String class and put them into a
			// String array
			String[] splitStrings = currentLine.split(",");

			// the first part of the word is the item name
			String itemName = splitStrings[0];
			// the second part is the price
			double itemPrice = Double.parseDouble(splitStrings[1]);

			//if the menu exdeeds 100 items, we will stop adding items to the arrays.
			if (positionOfItems < 100)
			{
				// create a Food object using those names by passing the
				// itemName and itemPrice into our Food constructor
				menuCatalog[positionOfItems] = new Food(itemName, itemPrice);

				// set the first part of the multidimensional to be the item
				// name
				menuList[positionOfItems][0] = menuCatalog[positionOfItems]
						.getItemName();
				// set the second part of the multidimensional to be the item
				// price
				menuList[positionOfItems][1] = String
						.valueOf(menuCatalog[positionOfItems].getPrice());

				// increase our counter for how many items are on the menu
				positionOfItems++;
			}

		}

		// close the scanner object
		fileFoodInput.close();

		// delcare a file object and pass our DrinkMenu text document
		// The text document is split by name and drink size and price and
		// seperated by a ","
		textFile = new File("DrinkMenu.txt");

		// create a scanner object to read our "DrinkMenu" file
		Scanner fileDrinkInput = new Scanner(textFile);

		// A while loop read each line and stops reading after there are no more
		// lines to read
		while (fileDrinkInput.hasNextLine())
		{
			// Set the current line to a string variable
			String currentLine = fileDrinkInput.nextLine();
			// Call the split method from String class and put them into a
			// String array
			String[] splitStrings = currentLine.split(",");
			// the first part of the word is the item name
			String itemName = splitStrings[0];
			// the second part is the drink size
			int drinkSize = Integer.parseInt(splitStrings[1]);
			// the third part is the price
			double itemPrice = Double.parseDouble(splitStrings[2]);

			if (positionOfItems < 100)
			{
				// create a Drink object using those variables by passing the
				// itemName, drinkSize and itemPrice into our Drink constructor
				menuCatalog[positionOfItems] = new Drink(itemName, itemPrice,
						drinkSize);

				// set the first part of the multidimensional to be the item
				// name which will also contain the drinkSize thanks to
				// polymorphism
				menuList[positionOfItems][0] = menuCatalog[positionOfItems]
						.getItemName();
				// set the second part of the multidimensional to be the item
				// price
				menuList[positionOfItems][1] = String
						.valueOf(menuCatalog[positionOfItems].getPrice());

				// increase our counter for how many items are on the menu
				positionOfItems++;
			}

		}
		// close the scanner object
		fileDrinkInput.close();

	}

	/**
	 * Purpose: Pass in a string that contains the name and a double that
	 * contains the price which will write and add on the FoodMenu
	 * 
	 * @param itemName
	 * @param itemPrice
	 * @throws IOException
	 */
	public void addFoodItemToMenu(String itemName, double itemPrice)
			throws IOException
	{

		File textFile = new File("FoodMenu.txt");
		FileWriter fWriter = new FileWriter(textFile, true);
		PrintWriter pWriter = new PrintWriter(fWriter);

		pWriter.println(itemName + ", " + itemPrice);
		fWriter.close();
		pWriter.close();
	}

	/**
	 * Purpose: Pass in a string that contains the name, a integer that will
	 * contain the drinkSize and a double that contains the price which will
	 * write and add on the FoodMenu
	 * 
	 * @param itemName
	 * @param drinkSize
	 * @param itemPrice
	 * @throws IOException
	 */
	public void addDrinkItemToMenu(String itemName, int drinkSize,
			double itemPrice) throws IOException
	{

		File textFile = new File("DrinkMenu.txt");
		FileWriter fWriter = new FileWriter(textFile, true);
		PrintWriter pWriter = new PrintWriter(fWriter);
		pWriter.println(itemName + "," + drinkSize + "," + itemPrice);
		fWriter.close();
		pWriter.close();
	}

	/**
	 * Change a price of a certain item on the menu. Pass in the number on the
	 * menu of where that item is.
	 * 
	 * @param menuPosition
	 * @param newPrice
	 */
	public void setItemPrice(int arrayPosition, double newPrice)
	{
		// if there is a item there, change the price
		if (menuCatalog[arrayPosition - 1] != null)
		{
			menuCatalog[arrayPosition - 1].setPrice(newPrice);
		}
		// if there is no item there
		else
		{
			throw new NullPointerException(
					"There is no item at that menu number");
		}

	}

	/**
	 * Remove a item from the menu. Pass in arrayPosition or number of where
	 * it's listed on the menu.
	 * 
	 * @param arrayPosition
	 */
	public void removeItemFromMenu(int arrayPosition)
	{
		// If element is null at the given index, do nothing.
		if (menuCatalog[arrayPosition - 1] != null)
		{
			// Set the current index of that item to remove to null.
			menuCatalog[arrayPosition - 1] = null;
			// decrease counter for how many indexs in the array which elements
			// are not null
			positionOfItems--;

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
				else if (menuCatalog[arrayShifter + 1] == null)
				{
					arrayShifter = 1000;
				}

				// if the next index of your given position index is not null,
				// keep shifting each element to the left in the array
				else
				{
					Item tempItem = menuCatalog[arrayShifter + 1];
					menuCatalog[arrayShifter] = tempItem;
					arrayShifter++;
				}
			} while (arrayShifter < menuCatalog.length);
		}
		else
		{

			throw new NullPointerException(
					"You cannot remove \"nothing\" from menu");
		}

	}

	/**
	 * Purpose: Return the menuCatalog array
	 * 
	 * @return menuCatalog array
	 */
	public Item[] returnMenu()
	{
		return menuCatalog;
	}

	/**
	 * Purpose: return the number of items on the menu
	 * 
	 * @return
	 */
	public int getNumberOfItemsInMenu()
	{
		return this.positionOfItems;
	}

	/**
	 * Purpose: the overrided toString method will print out the entire menu and
	 * return as a string.
	 * 
	 * @Override
	 */
	public String toString()
	{
		String menuInfo = "================== \n" + "	MENU \n"
				+ "================== \n";

		if (menuList[0][0] == null)
		{
			menuInfo += "Nothing on menu";
			return menuInfo;
		}
		else
		{

			for (int i = 0; i < positionOfItems; i++)
			{

				menuInfo += i + 1 + ". " + menuList[i][0] + ", $"
						+ menuList[i][1] + "\n";

			}
		}

		return menuInfo;
	}
}
