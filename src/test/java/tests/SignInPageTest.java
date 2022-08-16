package tests;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.SignInPage;


import util.XlUtility;

public class SignInPageTest extends TestBase{
	//WebDriver driver;
	SignInPage signInPage;
	HomePage homePage;
	
	//get the data from excel
	String path="src\\test\\resources\\excel\\TestData.xlsx";
	XlUtility xlutil=new XlUtility(path);
	
	@BeforeClass
	public void setUp() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		signInPage = PageFactory.initElements(driver, SignInPage.class);
		homePage.clickGetStartedButton();
		homePage.clickSigninLink();
		
	}
	//@BeforeMethod
	//public void setUp() {
		
	//	driver = init();
		
		//homePage = PageFactory.initElements(driver, HomePage.class);
		//signInPage = PageFactory.initElements(driver, SignInPage.class);
		
		//homePage.clickGetStartedButton();
	  // signInPage.clickSigninLink();
	    
	
	//}
	
	
	

	@Test(priority = 2)
	public void validUserShouldBeAbleToLogin() throws IOException {
		test = extent.createTest("validUserShouldBeAbleToLoginTest");
		String flag = xlutil.getCellData("LoginInfo", 1, 0);
		String userName = xlutil.getCellData("LoginInfo", 1, 1);
		String password = xlutil.getCellData("LoginInfo", 1, 2);
		
		
		//signInPage.clickSigninLink();
		signInPage.insertUserName(userName);
		signInPage.insertPassword(password);
		signInPage.clickSigninButton();
		
		boolean SignOutButton = signInPage.validateSigninPage();
		Assert.assertTrue(SignOutButton,"Login not successful");
	    
	
       	}
	
	
	
	@Test(priority = 1,dataProvider="InvalidLoginData")
	public void UserShouldNotBeAbleToLoginWithInvalidLoginCredentials(String flag, String userName, String password) {
			        
		test = extent.createTest("UserShouldNotBeAbleToLoginWithInvalidCredentialsTest");
		
		//signInPage.clickSigninLink();
		signInPage.insertUserName(userName);
		signInPage.insertPassword(password);
		signInPage.clickSigninButton();
		
		//signInPage.clickSigninLink();
			
		 
		
	 if(flag.equalsIgnoreCase("Invalid Username & Password") || flag.equalsIgnoreCase("Invalid Username")
			 
			                      ||flag.equalsIgnoreCase("Invalid Password") ) {
		 
		boolean msgSignin = signInPage.validateInvalidSignIn();
		
		Assert.assertTrue(msgSignin,"Invalid Username and Password");
		
	 }
	
		
	
	 else if(flag.equalsIgnoreCase("Username & Password is Blank") || flag.equalsIgnoreCase("Username is Blank")) {
		 
		 String usrmsg = signInPage.validateTextboxMessage();
		 Assert.assertEquals(usrmsg, "Please fill out this field.","Invalid Sign in!!");
		 
		 
	 }
	 
	 else if(flag.equalsIgnoreCase("Password is Blank")) {
		
		 String pwdmsg = signInPage.validatePasswordTextboxMessage();
			System.out.println(pwdmsg);
		 Assert.assertEquals(pwdmsg, "Please fill out this field.","Invalid Sign in!!");
		
		
	 }
	   
	 
	
	}
	
	@DataProvider(name="InvalidLoginData")
	public String [][] getData() throws IOException
	{
		
		
		int totalrows=xlutil.getRowCount("LoginInfo");
		int totalcols=xlutil.getCellCount("LoginInfo",1);	
				
		String loginData[][]=new String[totalrows-1][totalcols];
		
		
		for(int i=2;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-2][j]=xlutil.getCellData("LoginInfo", i, j);
			}
				
		}
		
		return loginData;
	}
	@Test(priority=3)
	public void UserShouldSignOutSuccessfullyAfterLogin() throws IOException {
		
		test = extent.createTest("ValidUserShouldBeAbleToSignOutSuccessfullyTest");
		String flag = xlutil.getCellData("LoginInfo", 1, 0);
		String userName = xlutil.getCellData("LoginInfo", 1, 1);
		String password = xlutil.getCellData("LoginInfo", 1, 2);
		
		
		/*signInPage.clickSigninLink();
		signInPage.insertUserName(userName);
		signInPage.insertPassword(password);
		signInPage.clickSigninButton();*/
		signInPage.clickSignOutLink();
		String msg = signInPage.validateSignOutMessage();
		Assert.assertEquals(msg, "Logged out successfully", " Sign Out Unsuccessfull!!");
	}
	


}
