package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;

import util.XlUtility;

public class RegisterPageTest extends TestBase {

	//WebDriver driver;

	RegisterPage registerPage;
	HomePage homePage;
	// get the data from excel
	String path = "src\\test\\resources\\excel\\TestData.xlsx";
	XlUtility xlutil = new XlUtility(path);
   
	@BeforeClass 
	public void setUp() {
		registerPage = PageFactory.initElements(driver, RegisterPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.clickGetStartedButton();
		homePage.clickRegisterLink();
		
	}
	//@BeforeMethod
	//public void setUp() {

		//driver = init();

		//registerPage = PageFactory.initElements(driver, RegisterPage.class);
	//	homePage = PageFactory.initElements(driver, HomePage.class);
		
		//homePage.clickGetStartedButton();
		//homePage.clickRegisterLink();
//	}

	

	@Test(priority = 1, dataProvider = "InvalidRegistrationData")
	public void UserShouldNotBeAbleToRegisterWithInvalidData(String flag, String username, String password1,
			String password2) throws InterruptedException {
		test = extent.createTest("UserShouldNotBeAbleToRegisterWithInvalidData");
		// registerPage.clickRegisterLink();
		if (username != "") {
			registerPage.insertUserName(username);
		}
		registerPage.insertPassword1(password1);
		registerPage.insertPassword2(password2);

		Thread.sleep(2000);
		registerPage.clickRegisterButton();

		if (flag.equalsIgnoreCase("User enters Invalid Username")
				|| flag.equalsIgnoreCase("User enters InvalidPassword(less than 8 characters )")

				|| flag.equalsIgnoreCase("User enters incorrect password while Re-entering password")
				|| flag.equalsIgnoreCase("User enters Invalid Password(Only numerics)")) {

			String actualMsg = registerPage.validateNotRegisteredMessage();

			Assert.assertEquals(actualMsg, "password_mismatch:The two password fields didn’t match.",
					" Invalid Registration!!");
		}

		else if (flag.equalsIgnoreCase("User enters only Username")) {
			String pwd1msg = registerPage.validatePassword1TextboxMessage();

			Assert.assertEquals(pwd1msg, "Please fill out this field.", "Invalid Registration!!");

		} else if (flag.equalsIgnoreCase("User does not re-enter Password")) {
			String pwd2msg = registerPage.validatePassword2TextboxMessage();
			Assert.assertEquals(pwd2msg, "Please fill out this field.", "Invalid Registration!!");

		} else if (flag.equalsIgnoreCase("User does not enter UserName ")
				|| flag.equalsIgnoreCase("User enters All fields Empty")) {
			String usrmsg = registerPage.validateTextboxMessage();
			System.out.println(usrmsg);
			Assert.assertEquals(usrmsg, "Please fill out this field.", "Invalid Registration!!");
		}
	}

	@Test(priority = 2)
	public void UserIsSuccessfullyAbleToRegister() throws IOException, InterruptedException {
		// homePage.clickRegisterLink();
		test = extent.createTest("UserIsSuccessfullyAbleToRegister");
		String userName = xlutil.getCellData("RegisterInfo", 1, 1);
		String password1 = xlutil.getCellData("RegisterInfo", 1, 2);
		String password2 = xlutil.getCellData("RegisterInfo", 1, 3);

		String insertedUsername = registerPage.insertUserName(userName);
		Thread.sleep(3000);
		registerPage.insertPassword1(password1);
		registerPage.insertPassword2(password2);

		registerPage.clickRegisterButton();
		String actualmsg = registerPage.validateRegisteredMessage();
		String expectedmsg = "New Account Created. You are logged in as " + insertedUsername;
		Assert.assertEquals(actualmsg, expectedmsg, "Registration failed!!");

	}

	@DataProvider(name = "InvalidRegistrationData")
	public String[][] getData() throws IOException {

		int totalrows = xlutil.getRowCount("RegisterInfo");
		int totalcols = xlutil.getCellCount("RegisterInfo", 1);

		String registerData[][] = new String[totalrows - 1][totalcols];

		for (int i = 2; i <= totalrows; i++) // 1
		{
			for (int j = 0; j < totalcols; j++) // 0
			{
				registerData[i - 2][j] = xlutil.getCellData("RegisterInfo", i, j);
			}

		}

		return registerData;
	}

	

}

