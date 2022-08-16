package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	WebDriver driver;

	@FindBy(how = How.LINK_TEXT, using = "Sign in")
	WebElement SIGNIN_LINK_ELEMENT;
	@FindBy(how = How.NAME, using = "username")
	WebElement USERNAME_ELEMENT;
	@FindBy(how = How.NAME, using = "password")
	WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Get Started')]")
	WebElement GETSTARTED_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Data Structures')]")
	WebElement DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Get Started')]")
	WebElement GETSTARTED_INTROBUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-primary']")
	WebElement MESSAGE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[2]//a[contains(text(),'Get Started')]")
	WebElement ARRAYGETSTARTED_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[3]//div[3]//a[contains(text(),'Get Started')]")
	WebElement LINKEDLISTGETSTARTED_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[4]//a[contains(text(),'Get Started')]")
	WebElement STACKGETSTARTED_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[5]//a[contains(text(),'Get Started')]")
	WebElement QUEUEGETSTARTED_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[6]//a[contains(text(),'Get Started')]")
	WebElement TREEGETSTARTED_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[7]//a[contains(text(),'Get Started')]")
	WebElement GRAPHGETSTARTED_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[@class='dropdown-menu show']")
	WebElement DROPDOWNITEMS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[@class='col']/descendant::a")
	List<WebElement> ALLBUTTONS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[@class='col']/descendant::h5")
	List<WebElement> ALLHEADERS_ELEMENT;
	@FindBy(how = How.LINK_TEXT, using = "Register")
	WebElement REGISTER_LINK_ELEMENT;

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	public void clickSigninLink() {
		// TODO Auto-generated method stub
		SIGNIN_LINK_ELEMENT.click();
	}

	public void insertUserName(String userName) {
		USERNAME_ELEMENT.sendKeys(userName);
	}

	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}

	public void clickGetStartedButton() {

		GETSTARTED_ELEMENT.click();
	}

	public void clickDropDown() {
		DROPDOWN_ELEMENT.click();

	}

	public int validateDropDown() {

		int items = DROPDOWNITEMS_ELEMENT.findElements(By.tagName("a")).size();
		return items;

	}

	public void clickGetStartedIntroButton() {
		GETSTARTED_INTROBUTTON_ELEMENT.click();
		
	}

	public String validateNotLoggedInMessage() {
		
		return MESSAGE_ELEMENT.getText();
	}

	public void clickArrayGetStartedButton() {

		ARRAYGETSTARTED_ELEMENT.click();
	}

	public void clickLinkedListGetStartedButton() {

		LINKEDLISTGETSTARTED_ELEMENT.click();
	}

	public void clickStackGetStartedButton() {

		STACKGETSTARTED_ELEMENT.click();
	}

	public void clickQueueGetStartedButton() {

		QUEUEGETSTARTED_ELEMENT.click();
	}

	public void clickTreeGetStartedButton() {

		TREEGETSTARTED_ELEMENT.click();
	}

	public void clickGraphGetStartedButton() {

		GRAPHGETSTARTED_ELEMENT.click();
	}

	public void clickAnyButton(int i) {
		// TODO Auto-generated method stub

	}

	public int getAllButtons() {

		return ALLBUTTONS_ELEMENT.size();

	}

	public void validateAllButtons(int i) {

	//	System.out.println(ALLBUTTONS_ELEMENT.size());
	//	WebElement ListItem = ALLBUTTONS_ELEMENT.get(i);
		WebElement ListItem = ALLBUTTONS_ELEMENT.get(i);
		ListItem.click();
		

	}

	public void validateDropDownNotLoggedInMessage(int i) {
		// TODO Auto-generated method stub
       
		List<WebElement> allOptions = DROPDOWNITEMS_ELEMENT.findElements(By.tagName("a"));

		allOptions.get(i).click();

	}
	public void validateArrayDropDownItem() {
		// TODO Auto-generated method stub
		
		List<WebElement> allOptions = DROPDOWNITEMS_ELEMENT.findElements(By.tagName("a"));
		
		allOptions.get(0).click();
		
	}
	public void validateLinkedListDropDownItem() {
		// TODO Auto-generated method stub
		
		List<WebElement> allOptions = DROPDOWNITEMS_ELEMENT.findElements(By.tagName("a"));
		
		allOptions.get(1).click();
		
	}
	public void validateStackDropDownItem() {
		// TODO Auto-generated method stub
		
		List<WebElement> allOptions = DROPDOWNITEMS_ELEMENT.findElements(By.tagName("a"));
		
		allOptions.get(2).click();
		
	}
	public void validateQueueDropDownItem() {
		// TODO Auto-generated method stub
		
		List<WebElement> allOptions = DROPDOWNITEMS_ELEMENT.findElements(By.tagName("a"));
		
		allOptions.get(3).click();
		
	}
	public void validateTreeDropDownItem() {
		// TODO Auto-generated method stub
		
		List<WebElement> allOptions = DROPDOWNITEMS_ELEMENT.findElements(By.tagName("a"));
		
		allOptions.get(4).click();
		
	}
	public void validateGraphDropDownItem() {
		// TODO Auto-generated method stub
		
		List<WebElement> allOptions = DROPDOWNITEMS_ELEMENT.findElements(By.tagName("a"));
		
		allOptions.get(5).click();
		
	}

	public void clickRegisterLink() {
		// TODO Auto-generated method stub
		REGISTER_LINK_ELEMENT.click();
	}

	public int validatePanesForDataStructures() {
		// TODO Auto-generated method stub
		return ALLHEADERS_ELEMENT.size();
		
	}
}
