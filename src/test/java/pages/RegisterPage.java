package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage extends BasePage {
	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Get Started')]")
	WebElement GETSTARTED_ELEMENT;

	@FindBy(how = How.NAME, using = "username")
	WebElement USERNAME_ELEMENT;
	@FindBy(how = How.NAME, using = "password1")
	WebElement PASSWORD1_ELEMENT;
	@FindBy(how = How.NAME, using = "password2")
	WebElement PASSWORD2_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@value = 'Register']")
	WebElement REGISTERBUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//body/div[2]")
	WebElement MESSAGE_ELEMENT;
	@FindBy(how = How.LINK_TEXT, using = "Register")
	WebElement REGISTER_LINK_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-primary']")
	WebElement NOTREGISTERED_MESSAGE_ELEMENT;
	
	
	 public RegisterPage(WebDriver driver) {
			this.driver = driver;
			System.out.println(driver);

		}
	public String validateTextboxMessage() {
		String usernameTextBox = USERNAME_ELEMENT.getAttribute("validationMessage");  
		
		return usernameTextBox;  
	}
	
	public String validatePassword1TextboxMessage() {
		String passwordTextBox = PASSWORD1_ELEMENT.getAttribute("validationMessage");
		
		return passwordTextBox;
		
	}
	public String validatePassword2TextboxMessage() {
		String passwordTextBox = PASSWORD2_ELEMENT.getAttribute("validationMessage");
		
		return passwordTextBox;
		
	}
	public void clickRegisterLink() {
		
		REGISTER_LINK_ELEMENT.click();
		
	}
	public void clickRegisterButton() {
		REGISTERBUTTON_ELEMENT.click();
		
	}
	
	public String validateRegisteredMessage() {
		
		return MESSAGE_ELEMENT.getText();
	}
	
	public  String insertUserName(String userName) {
		// TODO Auto-generated method stub
		USERNAME_ELEMENT.clear();
		String insertedUserName = userName + generateRandom(999);
		USERNAME_ELEMENT.sendKeys(insertedUserName);
		return insertedUserName;
	}
	public void insertPassword1(String password1) {
		// TODO Auto-generated method stub
		PASSWORD1_ELEMENT.clear();
		PASSWORD1_ELEMENT.sendKeys(password1);
		
	}
	public void insertPassword2(String password2) {
		// TODO Auto-generated method stub
		PASSWORD2_ELEMENT.clear();
		PASSWORD2_ELEMENT.sendKeys(password2);
	}
	public String validateNotRegisteredMessage() {
		// TODO Auto-generated method stub
		return NOTREGISTERED_MESSAGE_ELEMENT.getText();
	}

}
