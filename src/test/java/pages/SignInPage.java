package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;

	// First find all the webelements
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Get Started')]")
	WebElement GETSTARTED_ELEMENT;
	@FindBy(how = How.LINK_TEXT, using = "Sign in")
	WebElement SIGNIN_LINK_ELEMENT;

	@FindBy(how = How.NAME, using = "username")
	WebElement USERNAME_ELEMENT;
	@FindBy(how = How.NAME, using = "password")
	WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	WebElement SIGNIN_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign out')]")
	WebElement SIGNOUT_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//ul/a[2]")
	WebElement USERSIGNED_IN_ELEMENT;
    @FindBy(how = How.XPATH, using = "//div[3][contains(text(),'Invalid Username and Password')]")
    WebElement INVALIDSIGN_IN_ELEMENT;
  
    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-primary']")
	WebElement MESSAGE_ELEMENT;
	
    public SignInPage(WebDriver driver) {
		this.driver = driver;
		System.out.println(driver);

	}

	// Write all methods/actions
	public void clickSigninLink() {
        
		//GETSTARTED_ELEMENT.click();
		//System.out.println("Hello");
		SIGNIN_LINK_ELEMENT.click();
	}

	public void insertUserName(String userName) {
		USERNAME_ELEMENT.clear();
		USERNAME_ELEMENT.sendKeys(userName);
	}

	public void insertPassword(String password) {
		PASSWORD_ELEMENT.clear();
		PASSWORD_ELEMENT.sendKeys(password);
	}

	public void clickSigninButton() {

		SIGNIN_BUTTON_ELEMENT.click();
		

	}
	
	public boolean validateSigninPage() {
		
		return SIGNOUT_BUTTON_ELEMENT.isDisplayed();
		
		
	}
	
	public boolean validateUserSignedIn() {
		
		return USERSIGNED_IN_ELEMENT.isDisplayed();
		
	}
	
	public boolean validateInvalidSignIn() {
		
		return INVALIDSIGN_IN_ELEMENT.isDisplayed();
		
	}

	

	public String validateSignIn() {
		// TODO Auto-generated method stub
		return MESSAGE_ELEMENT.getText();
	}

	
	
	public String validateTextboxMessage() {
		String usernameTextBox = USERNAME_ELEMENT.getAttribute("validationMessage");  
		
		return usernameTextBox;  
	}
	
	public String validatePasswordTextboxMessage() {
		String passwordTextBox = PASSWORD_ELEMENT.getAttribute("validationMessage");
		
		return passwordTextBox;
		
	}
	
	public void clickSignOutLink() {
		SIGNOUT_BUTTON_ELEMENT.click();
	}

	public String validateSignOutMessage() {
		// TODO Auto-generated method stub
		return MESSAGE_ELEMENT.getText();
		
	}

}
