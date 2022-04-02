package testPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class TestPages extends TestBase {

	@FindBy(name = "categorydata")
	WebElement inputCategory;

	@FindBy(xpath = "//input[@value='Add category']")
	WebElement addCatBtn;

	@FindBy(name = "due_month")
	WebElement verifyMonths;

	public TestPages() {
		PageFactory.initElements(driver, this);

	}

	public void addCategory(String random) {
		inputCategory.sendKeys(random);
		addCatBtn.click();

	}

	public boolean verifyHelloMoon(String random) {
		WebElement category = driver.findElement(By.xpath("//span[contains(text(),'" + random + "')]"));

		return category.isDisplayed();

		/*
		 * if(driver.getPageSource().contains("Hello Moon!"))
		 * System.out.println("Category is displayed"); else {
		 * System.out.println("Category is not displayed"); }
		 */

	}

	public boolean addDupCategory() {
		inputCategory.sendKeys("Hello Moon!");

		if (driver.getPageSource().contains("Hello Moon"))
			System.out.println("Category already exists:");
		else {
			System.out.println("Category does not exist:");
		}
		return true;

	}

	public boolean verifyMonths() {
		verifyMonths.click();
		
	      Select s = new Select(driver.findElement(By.name("due_month"))); // Select helps you to interact with a drop menu and your passing the webelement that is a dropdown
	      // getting the list of options in the dropdown with getOptions()
	      List <WebElement> op = s.getOptions(); // List being an empty container and s being a drop down with be filled on whats inside the element.
	      int size = op.size();  //save count into the integer
	      
	      for(int i =0; i<size ; i++){
	         String options = op.get(i).getText();
	         System.out.println(options);
	         
	      }
		if(size==13) { // Expecting  12 months + the none option.
			return true;
		}
		else {
			return false;
		}

	}
}