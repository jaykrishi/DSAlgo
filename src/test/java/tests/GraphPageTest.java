package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DSIntroductionPage;
import pages.GraphPage;
import pages.HomePage;
import pages.SignInPage;
import pages.TreePage;
import util.XlUtility;

public class GraphPageTest extends TestBase {

	//WebDriver driver;
	HomePage homePage;
	SignInPage signInPage;
	GraphPage graphPage;

	String path = "src\\test\\resources\\excel\\TestData.xlsx";
	XlUtility xlutil = new XlUtility(path);

	@BeforeClass
	public void setUp() throws IOException {

		//driver = init();

		graphPage = PageFactory.initElements(driver, GraphPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		signInPage = PageFactory.initElements(driver, SignInPage.class);

		homePage.clickGetStartedButton();
		homePage.clickSigninLink();

		String userName = xlutil.getCellData("LoginInfo", 1, 1);
		String password = xlutil.getCellData("LoginInfo", 1, 2);
		signInPage.insertUserName(userName);
		signInPage.insertPassword(password);
		signInPage.clickSigninButton();
		homePage.clickGraphGetStartedButton();

	}

	@Test(priority = 1)
	public void validUserShouldBeAbletoLandInGraphPage() {
		test = extent.createTest("validUserShouldBeAbleToLandInGraphPageTest");

		String url;

		url = graphPage.VerifyCurrentUrl();
		Assert.assertEquals(url, "https://dsportalapp.herokuapp.com/graph/", "Invalid Page!!");

	}

	@Test(priority = 2)
	public void validUserShouldBeRedirectedToGraphTryEditorPage() {

		test = extent.createTest("validUserShouldBeRedirectedToGraphTryEditorPageTest");

		graphPage.clickGraphButton();
		System.out.println("hrere");
		openTryEditorPage();
		validateTryEditor();
	}
	@Test(priority = 3)
	public void validUserShouldBeAbletoLandInGraphRepresentationPage() {
		test = extent.createTest("validUserShouldBeAbleToLandInGraphRepresentationPageTest");
        graphPage.clickBackButton();
		graphPage.clickGraphRepresentationButton();
		String headerMsg = graphPage.verifyGraphRepresentationsHeader();
		Assert.assertEquals(headerMsg, "Graph Representations","Invalid Page!!");

	}
	
	@Test(priority = 4)
	public void validUserShouldBeRedirectedToGraphRepresentationsTryEditorPage() {

		test = extent.createTest("validUserShouldBeRedirectedToGraphRepresentationTryEditorPageTest");

		//graphPage.clickGraphRepresentationButton();
		openTryEditorPage();
		validateTryEditor();
	}

	public void openTryEditorPage() {

		graphPage.clickTryHereLink();
		String msg = graphPage.verifyTryEditorPageTitle();
		Assert.assertEquals(msg, "Assessment", "Invalid Page !!");
		boolean runBtn = graphPage.verifyRunButton();
		Assert.assertTrue(runBtn, "Run Button is not Displayed!!");
		validateTryEditor();
	}

}
