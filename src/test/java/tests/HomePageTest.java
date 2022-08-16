package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pages.HomePage;


public class HomePageTest extends TestBase {

	//WebDriver driver;

	HomePage homePage;
	
	@BeforeClass
	public void setUp() {

		//driver = init();
		homePage = PageFactory.initElements(driver, HomePage.class);

	}

	@Test(priority = 1,description = "Verify DS Portal Page")
	@Description(" VerifyIf the DS Portal Page Opens")
	@Epic("EP001")
	@Feature("Feature1 : DS Portal")
	@Story("Story: DS Portal page Opens")
	@Step("Verify DS Portal Page")
	@Severity(SeverityLevel.CRITICAL)
	public void UserShouldBeAbleToOpenDSPortalPage() {
		
		test = extent.createTest("UserShouldBeAbleToOpenDSPortalPage");
		Assert.assertEquals(driver.getTitle(), "Numpy Ninja", "Invalid Page!!");
		System.out.println(driver.getTitle());
	}

	@Test(priority = 2)
	public void UserShouldBeAbleToOpenHomePage() {
		test = extent.createTest("UserShouldBeAbleToOpenHomePage");
		homePage.clickGetStartedButton();
		Assert.assertEquals(driver.getCurrentUrl(), "https://dsportalapp.herokuapp.com/home", "Invalid Page!!");
		//homePage.getAllButtons();
	}

	@Test(priority = 3)
	public void UserShouldbeAbleToSeePanesForDataStructures() {
		test = extent.createTest("UserShouldBeAbleToSeePanesForDataStructures");
		//homePage.clickGetStartedButton();
		int numItems = homePage.validatePanesForDataStructures();
		Assert.assertEquals(numItems, 7, "Missing Data Structure from Panes!!");
	}

	@Test(priority = 4)
	public void UserShouldGetAlertWhenClickGetStartedIntroductionButton() {
		test = extent.createTest("UserShouldGetAlertWhenClickGetStartedIntroductionButtonTest");
		//homePage.clickGetStartedButton();
		homePage.clickGetStartedIntroButton();
		String msg = homePage.validateNotLoggedInMessage();
		Assert.assertEquals(msg, "You are not logged in", "Alert message is not Displayed");
	}

	@Test(priority = 5)
	public void UserShouldGetAlertWhenClicksArrayGetStartedButton() {
		
		test = extent.createTest("UserShouldGetAlertWHenClickArrayGetStartedButtonTest");
		homePage.clickArrayGetStartedButton();
		String msg = homePage.validateNotLoggedInMessage();
		Assert.assertEquals(msg, "You are not logged in", "Alert message is not Displayed");

	}
	@Test(priority = 6)
	public void UserShouldGetAlertWhenClicksLinkedListGetStartedButton() {
		
		test = extent.createTest("UserShouldGetAlertWHenClickLinkedListGetStartedButtonTest");
		homePage.clickLinkedListGetStartedButton();
		String msg = homePage.validateNotLoggedInMessage();
		Assert.assertEquals(msg, "You are not logged in", "Alert message is not Displayed");
		
	}
	@Test(priority = 7)
	public void UserShouldGetAlertWhenClicksStackGetStartedButton() {
		
		test = extent.createTest("UserShouldGetAlertWHenClickStackGetStartedButtonTest");
		homePage.clickStackGetStartedButton();
		String msg = homePage.validateNotLoggedInMessage();
		Assert.assertEquals(msg, "You are not loged in", "Alert message is not Displayed");
		
	}
	@Test(priority = 8)
	public void UserShouldGetAlertWhenClicksQueueGetStartedButton() {
		
		test = extent.createTest("UserShouldGetAlertWHenClickQueueGetStartedButtonTest");
		homePage.clickQueueGetStartedButton();
		String msg = homePage.validateNotLoggedInMessage();
		Assert.assertEquals(msg, "You are not logged in", "Alert message is not Displayed");
		
	}
	@Test(priority = 9)
	public void UserShouldGetAlertWhenClicksTreeGetStartedButton() {
		
		test = extent.createTest("UserShouldGetAlertWHenClickTreeGetStartedButtonTest");
		homePage.clickTreeGetStartedButton();
		String msg = homePage.validateNotLoggedInMessage();
		Assert.assertEquals(msg, "You are not logged in", "Alert message is not Displayed");
		
	}
	@Test(priority = 10)
	public void UserShouldGetAlertWhenClicksGraphGetStartedButton() {
		
		test = extent.createTest("UserShouldGetAlertWHenClickGraphGetStartedButtonTest");
		homePage.clickGraphGetStartedButton();
		String msg = homePage.validateNotLoggedInMessage();
		Assert.assertEquals(msg, "You are not logged in", "Alert message is not Displayed");
		
	}

	@Test(priority = 11)
	public void UserShouldBeAbleToClickAndViewDropDownItems() {
		test = extent.createTest("UserShouldBeAbleToClickAndViewDropDownItemTest");
		//homePage.clickGetStartedButton();
		homePage.clickDropDown();
		int items = homePage.validateDropDown();
		Assert.assertEquals(items, 6, "Missing Data Structure from DropDown!!");
	}

	@Test(priority = 12)
	public void UserShouldGetAlertWhenSelectArrayItemFromDropDown() {
		test = extent.createTest("UserShouldGetAlertWhenSelectArrayDropDownItemTest");
		//homePage.clickGetStartedButton();
		//homePage.clickDropDown();
	//	int size = homePage.validateDropDown();
      
			homePage.validateArrayDropDownItem();
			//String msg = homePage.validateNotLoggedInMessage();
			
			String msg = homePage.validateNotLoggedInMessage();
			Assert.assertEquals(msg, "You are not logged in"," Alert message is not Displayed!!");
			homePage.clickDropDown();
		
	}
	public void UserShouldGetAlertWhenSelectLinkedListItemFromDropDown() {
		test = extent.createTest("UserShouldGetAlertWhenSelectArrayDropDownItemTest");
		//homePage.clickGetStartedButton();
		//homePage.clickDropDown();
		//	int size = homePage.validateDropDown();
		
		homePage.validateLinkedListDropDownItem();
		//String msg = homePage.validateNotLoggedInMessage();
		
		String msg = homePage.validateNotLoggedInMessage();
		Assert.assertEquals(msg, "You are not logged in"," Alert message is not Displayed!!");
		homePage.clickDropDown();
		
	}
	public void UserShouldGetAlertWhenSelectStackItemFromDropDown() {
		test = extent.createTest("UserShouldGetAlertWhenSelectArrayDropDownItemTest");
		//homePage.clickGetStartedButton();
		//homePage.clickDropDown();
		//	int size = homePage.validateDropDown();
		
		homePage.validateStackDropDownItem();
		//String msg = homePage.validateNotLoggedInMessage();
		
		String msg = homePage.validateNotLoggedInMessage();
		Assert.assertEquals(msg, "You are not logged in"," Alert message is not Displayed!!");
		homePage.clickDropDown();
		
	}
	public void UserShouldGetAlertWhenSelectQueueItemFromDropDown() {
		test = extent.createTest("UserShouldGetAlertWhenSelectArrayDropDownItemTest");
		//homePage.clickGetStartedButton();
		//homePage.clickDropDown();
		//	int size = homePage.validateDropDown();
		
		homePage.validateQueueDropDownItem();
		//String msg = homePage.validateNotLoggedInMessage();
		
		String msg = homePage.validateNotLoggedInMessage();
		Assert.assertEquals(msg, "You are not logged in"," Alert message is not Displayed!!");
		homePage.clickDropDown();
		
	}
	public void UserShouldGetAlertWhenSelectTreeItemFromDropDown() {
		test = extent.createTest("UserShouldGetAlertWhenSelectArrayDropDownItemTest");
		//homePage.clickGetStartedButton();
		//homePage.clickDropDown();
		//	int size = homePage.validateDropDown();
		
		homePage.validateTreeDropDownItem();
		//String msg = homePage.validateNotLoggedInMessage();
		
		String msg = homePage.validateNotLoggedInMessage();
		Assert.assertEquals(msg, "You are not logged in"," Alert message is not Displayed!!");
		homePage.clickDropDown();
		
	}
	public void UserShouldGetAlertWhenSelectGraphItemFromDropDown() {
		test = extent.createTest("UserShouldGetAlertWhenSelectArrayDropDownItemTest");
		//homePage.clickGetStartedButton();
		//homePage.clickDropDown();
		//	int size = homePage.validateDropDown();
		
		homePage.validateGraphDropDownItem();
		//String msg = homePage.validateNotLoggedInMessage();
		
		String msg = homePage.validateNotLoggedInMessage();
		Assert.assertEquals(msg, "You are not logged in"," Alert message is not Displayed!!");
		homePage.clickDropDown();
		
	}

	@Test(priority = 13)
	public void UserShouldBeAbleToGotoSignInPage() {
		test = extent.createTest("UserShouldBeAbleToGoToSignInPageTest");
	//	homePage.clickGetStartedButton();
		homePage.clickSigninLink();
		Assert.assertEquals(driver.getCurrentUrl(), "https://dsportalapp.herokuapp.com/login", "Invalid Page!!");
	}

	@Test(priority = 14)
	public void UserShouldBeAbleToRegister() {
		test = extent.createTest("UserShouldBeAbleToRegisterTes");
		//homePage.clickGetStartedButton();
		homePage.clickRegisterLink();
		Assert.assertEquals(driver.getCurrentUrl(), "https://dsportalapp.herokuapp.com/register", "Invalid Page!!");
	}


}
