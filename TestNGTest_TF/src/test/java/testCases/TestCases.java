package testCases;



import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;
import testPages.TestPages;

public class TestCases extends TestBase {
	
	TestPages testpages;

	@BeforeTest
	public void setUp() {

		startBrowser(); // Arrived at page
		testpages = new TestPages(); // Create object of TestPages

}
	
	@Test
	public void validateCategory() {
		/*1. Arrived at page 
		2. Add a category
		3. Click on add category
		4. Verify category displays
		Result: When a category is added The category is displayed*/
		
		int min = 0;    // Creating a random number script 
		int max = 10000000; // Random number from 0 to 10000000
		int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min); // Formula for random numbers
		String random = String.valueOf(random_int); // Value of random number
		
		testpages.addCategory(random); // Adding a Category
		boolean verify = testpages.verifyHelloMoon(random); // Verifying Category - Returns a true or false value
		Assert.assertTrue(verify);	// Expect the Category is displayed so we expect True

	}
	
	@Test
	public void validateDuplicatedCategory() {
	/*  1. Arrived at page
		2. Add a duplicate Category
		3. Duplicate Category msg should display 
		Result: When a duplicate Category is added msg displays 
		"The category you want to add already exist:
		   <dupicated category name>"  */
		testpages.addDupCategory(); // Adding Duplicate Category
		//testpages.addCatBtn(); // Click on Add Category button
		boolean verify = testpages.addDupCategory();
		Assert.assertTrue(verify);
		
}
	@Test
	public void validatemonths() {
		/*1. Arrived at page
		2. Click on months button
		3. Validate all the months are in the months drop down section
		Results: All the months are displayed on drop down section */
		//testpages.verifyMonths();
		//Assert.assertTrue(testpages.verifyMonths());
		boolean x = testpages.verifyMonths();
		Assert.assertTrue(x);
	}
	
	@AfterTest
	public void breakDown() {
		 //driver.quit();
	}
}