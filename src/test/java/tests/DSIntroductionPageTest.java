package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DSIntroductionPage;
import pages.HomePage;
import pages.RegisterPage;
import pages.SignInPage;

import util.XlUtility;

public class DSIntroductionPageTest extends TestBase{
	
	//WebDriver driver;
    DSIntroductionPage dsIntroductionPage;
	HomePage homePage;
	SignInPage signInPage;
	
	String path="src\\test\\resources\\excel\\TestData.xlsx";
	XlUtility xlutil=new XlUtility(path);
	
	@BeforeClass
	public void setUp() throws IOException {

		//driver = init();

		dsIntroductionPage = PageFactory.initElements(driver, DSIntroductionPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		signInPage = PageFactory.initElements(driver, SignInPage.class);
		
		homePage.clickGetStartedButton();
		homePage.clickSigninLink();
		String userName = xlutil.getCellData("LoginInfo", 1, 1);
		String password = xlutil.getCellData("LoginInfo", 1, 2);
		signInPage.insertUserName(userName);
		signInPage.insertPassword(password);
		signInPage.clickSigninButton();
		homePage.clickGetStartedIntroButton();
		
		
	}
	
	@Test(priority=1)
	public void validUserShouldBeAbletoLandInDSIntroductionPage() throws IOException {
		
		
		test = extent.createTest("ValidUserShouldBeAbleToLandinDSIntroductionPage");
		//homePage.clickGetStartedButton();
		//homePage.clickSigninLink();
		
		//String userName = xlutil.getCellData("LoginInfo", 1, 1);
		//String password = xlutil.getCellData("LoginInfo", 1, 2);
		//signInPage.insertUserName(userName);
		//signInPage.insertPassword(password);
		//signInPage.clickSigninButton();
		
		
	//	homePage.clickGetStartedIntroButton();
		String url = dsIntroductionPage.VerifyCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url, "https://dsportalapp.herokuapp.com/data-structures-introduction/","Invalid Page!!");
	}
	@Test(priority=2)
	public void validUserShouldBeRedirectedToTimeCompexityIntroduction() {
		
		test = extent.createTest("ValidUserShouldBeRedirectedToTimeComplexityIntroduction");
		//homePage.clickGetStartedIntroButton();
		dsIntroductionPage.clickTimeComplexityLink();
		String msg = dsIntroductionPage.verifyTimeComplexityPageTitle();
		Assert.assertEquals(msg, "Time Complexity", "Invalid Page!!");
	}
	@Test(priority=3)
	public void validUserShouldBeRedirectedToTryEditorPage() {
		

		test = extent.createTest("ValidUserShouldBeRedirectedToTryEditor");
		//homePage.clickGetStartedIntroButton();
		dsIntroductionPage.clickTimeComplexityLink();
		dsIntroductionPage.clickTryHereLink();
		String msg = dsIntroductionPage.verifyTryEditorPageTitle();
		Assert.assertEquals(msg,"Assessment", "Invalid Page !!");
		boolean runBtn = dsIntroductionPage.verifyRunButton();
		Assert.assertTrue(runBtn,"Run Button is not Displayed!!");
		validateTryEditor();
		//dsIntroductionPage.validateInvalidEntryInTryEditor();
		
		
	}
	@Test(priority=4)
	public void validUserShouldBeRedirectedToPracticeQuestions() {
		//homePage.clickGetStartedIntroButton();
		dsIntroductionPage.clickBackButton();
	
		dsIntroductionPage.clickTimeComplexityLink();
		
		dsIntroductionPage.clickPracticeQuestionsLink();
		String msg = dsIntroductionPage.verifyPracticeQuestionsPageTitle();
		Assert.assertEquals(msg, "Practice Questions","Invalid Page!!");
	}
	
	

	
}
