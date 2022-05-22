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
 * Holds information about a person
 */


public abstract class Person
{
	// Fields for a person - Sarena 
	
	//First name variable - Sarena 
	private String firstName;
	// Last name variable - Sarena 
	private String lastName;
	
	/**
	 * Constructor for the person object that takes in two string args, firstName and lastName - Saren
	 * @param firstName
	 * @param lastName
	 */
	Person(String firstName, String lastName) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 *  Getter method to get first name - Sarena 
	 * @param firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 *  Setter method to set first name - Sarena 
	 * @param firstName
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	/**
	 * Getter method to get last name - Sarena 
	 * 
	 * @return lastName
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 *  Setter method to set last name - Sarena 
	 * @param lastName
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	

	
	
	
}
