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
import pages.SignInPage;

import pages.TreePage;
import util.XlUtility;

public class TreePageTest extends TestBase {
	
	//WebDriver driver;
	TreePage treePage;
    DSIntroductionPage dsIntroductionPage;
	HomePage homePage;
	SignInPage signInPage;
	
	String path="src\\test\\resources\\excel\\TestData.xlsx";
	XlUtility xlutil=new XlUtility(path);
	
	@BeforeClass
	public void setUp() throws IOException {

		//driver = init();

		treePage = PageFactory.initElements(driver, TreePage.class);
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
		
		
		
	}
	
	@Test(priority=1)
	public void validUserShouldBeAbletoLandInTreePage() {
		test = extent.createTest("validUserShouldBeAbleToLandInTreePageTest");
		
		String url;
		
		
		
		homePage.clickDropDown();
		treePage.clickTreeFromDropDown();
        url = treePage.VerifyCurrentUrl();
		Assert.assertEquals(url, "https://dsportalapp.herokuapp.com/tree/","Invalid Page!!");
		
		
		treePage.clickBackButton();
		
		treePage.clickGetStartedTreeButton();
		url = treePage.VerifyCurrentUrl();
		Assert.assertEquals(url, "https://dsportalapp.herokuapp.com/tree/","Invalid Page!!");
		
			
		
	}
	@Test(priority=2)
	public void validUserShouldBeAbletoLandInOverviewPage() throws InterruptedException {
		
		test = extent.createTest("validUserShouldBeAbleToLandInOverviewPageTest");
		//treePage.clickGetStartedTreeButton();
		treePage.clickOverviewTreeButton();
		String headerMsg = treePage.verifyOverviewOfTreesHeader();
		Assert.assertEquals(headerMsg, "Overview of Trees","Invalid Page!!");
	}
	
	@Test(priority=3)
	public void validUserShouldBeRedirectedToOverviewOfTreesTryEditorPage() {
		
		test = extent.createTest("validUserShouldBeRedirectedToTreesTryEditorPageTest");
		//treePage.clickGetStartedTreeButton();
	//	treePage.clickOverviewTreeButton();
		openTryEditorPage();
	}
	
	@Test(priority=4)
	public void validUserShouldBeAbletoLandInTerminologiesPage() throws InterruptedException {
		
		test = extent.createTest("validUserShouldBeAbleToLandInTerminologiesPageTest");
		treePage.clickBackButton();
	//	treePage.clickGetStartedTreeButton();
		treePage.clickTerminologiesButton();
		String headerMsg = treePage.verifyTerminologiesTreesHeader();
		Assert.assertEquals(headerMsg, "Terminologies","Invalid Page!!");
	}
	
	@Test(priority=5)
	public void validUserShouldBeRedirectedToTerminologiesOfTreesTryEditorPage() {
		test = extent.createTest("validUserShouldBeRedirectedToTerminologiesTryEditorTest");
		//treePage.clickGetStartedTreeButton();
		//treePage.clickTerminologiesButton();
		openTryEditorPage();
		validateTryEditor();
	}
	@Test(priority=6)
	public void validUserShouldBeAbletoLandInTypesOfTreesPage() throws InterruptedException {
		
		test = extent.createTest("validUserShouldBeAbleToLandInTypesOfTreesTest");
		treePage.clickBackButton();
	//	treePage.clickGetStartedTreeButton();
		
		treePage.clickTypesofTreesButton();
		String headerMsg = treePage.verifyTypesOfTreesHeader();
		Assert.assertEquals(headerMsg, "Types of Trees","Invalid Page!!");
	}
	
	@Test(priority=7)
	public void validUserShouldBeRedirectedToTypesOfTreesTryEditorPage() {
		test = extent.createTest("validUserShouldBeRedirectedToTypesOfTryEditorPageTest");
//treePage.clickGetStartedTreeButton();
		
	//	treePage.clickTypesofTreesButton();
		openTryEditorPage();
		validateTryEditor();
	}
	
	@Test(priority=8)
	public void validUserShouldBeAbletoLandInTreeTraversalsPage() throws InterruptedException {
		
		test = extent.createTest("validUserShouldBeAbleToLandInTreeTraversalPageTest");
		treePage.clickBackButton();
//treePage.clickGetStartedTreeButton();
		
	
		treePage.clickTreeTraversalsButton();
		String headerMsg = treePage.verifyTreeTraversalsHeader();
		Assert.assertEquals(headerMsg, "Tree Traversals","Invalid Page!!");
	}
	
	@Test(priority=9)
	public void validUserShouldBeRedirectedToTreeTraversalTryEditorPage() {
		test = extent.createTest("validUserShouldBeRedirectedToTreeTraversalTryEditorTest");
		//treePage.clickGetStartedTreeButton();
		
		
	//	treePage.clickTreeTraversalsButton();
		openTryEditorPage();
		validateTryEditor();
	}
	@Test(priority=10)
	public void validUserShouldBeAbletoLandTraversalIllustrationPage() throws InterruptedException {
		
		test = extent.createTest("validUserShouldBeAbleToLandTraversalIllustrationTest");
		treePage.clickBackButton();
	//	treePage.clickGetStartedTreeButton();
		
		
		treePage.clickTraversalIllustrationButton();
		String headerMsg = treePage.verifyTraversalIllustrationHeader();
		Assert.assertEquals(headerMsg, "Traversals-Illustration","Invalid Page!!");
	}
	
	@Test(priority=11)
	public void validUserShouldBeRedirectedToTraversalIllustrationTryEditorPage() {
		test = extent.createTest("validUserShouldBeRedirectedToTraversalIllustrationTryEditorTest");
		//treePage.clickGetStartedTreeButton();
		
		
		//treePage.clickTraversalIllustrationButton();
		openTryEditorPage();
		validateTryEditor();
	}
	@Test(priority=12)
	public void validUserShouldBeAbletoLandBinaryTreesPage() throws InterruptedException {
		
		test = extent.createTest("validUserShouldBeAbleTolandBinaryTreesTest");
		treePage.clickBackButton();
	//	treePage.clickGetStartedTreeButton();
		treePage.clickBinaryTreesButton();
		String headerMsg = treePage.verifyBinaryTreesHeader();
		Assert.assertEquals(headerMsg, "Binary Trees","Invalid Page!!");
	}
	
	@Test(priority=13)
	public void validUserShouldBeRedirectedToBinaryTreesTryEditorPage() {
		test = extent.createTest("validUserShouldBeRedirectedToBinaryTreesTryEditorTest");
	//	treePage.clickGetStartedTreeButton();
	//	treePage.clickBinaryTreesButton();
		openTryEditorPage();
		validateTryEditor();
	}
	
	@Test(priority=14)
	public void validUserShouldBeAbletoLandTypesOfBinaryTreesPage() throws InterruptedException {
		
		test = extent.createTest("validUserShouldBeAbleToLandTypesOfBinaryTreesTest");
		treePage.clickBackButton();
	//	treePage.clickGetStartedTreeButton();
		treePage.clickTypesOfBinaryTreesButton();
		String headerMsg = treePage.verifyTypesOfBinaryTreesHeader();
		Assert.assertEquals(headerMsg, "Types of Binary Trees","Invalid Page!!");
	}
	
	@Test(priority=15)
	public void validUserShouldBeRedirectedToTypesOfBinaryTreesTryEditorPage() {
		test = extent.createTest("validUserShouldBeRedirectedToTypesOfBinaryTreesTryEditorTest");
		//treePage.clickGetStartedTreeButton();
	//	treePage.clickTypesOfBinaryTreesButton();
		openTryEditorPage();
		validateTryEditor();
	}
	@Test(priority=16)
	public void validUserShouldBeAbletoLandImplementationInPythonPage() throws InterruptedException {
		
		test = extent.createTest("validUserShouldBeAbleToLandImplementationInPythonTest");
		treePage.clickBackButton();
	//	treePage.clickGetStartedTreeButton();
		treePage.clickImplementationInPythonButton();
		String headerMsg = treePage.verifyImplementationPythonHeader();
		Assert.assertEquals(headerMsg, "Implementation in Python","Invalid Page!!");
	}
	
	@Test(priority=17)
	public void validUserShouldBeRedirectedToImplementationInpythonTryEditorPage() {
		
		test = extent.createTest("validUserShouldBeRedirectedToImplementationInPythontryEditorTest");
		//treePage.clickGetStartedTreeButton();
	//	treePage.clickImplementationInPythonButton();
		openTryEditorPage();
		validateTryEditor();
	}
	
	@Test(priority=18)
	public void validUserShouldBeAbletoLandBinaryTreeTraversalsPage() throws InterruptedException {
		
		test = extent.createTest("validUserShouldBeAbleToLandBinaryTreeTraversalsTest");
		treePage.clickBackButton();
	//	treePage.clickGetStartedTreeButton();
		treePage.clickBinaryTreeTraversalsButton();
		String headerMsg = treePage.verifyBinaryTreeTraversalsHeader();
		Assert.assertEquals(headerMsg, "Binary Tree Traversals","Invalid Page!!");
	}
	
	@Test(priority=19)
	public void validUserShouldBeRedirectedToBinaryTreeTraversalsTryEditorPage() {
		test = extent.createTest("validUserShouldBeRedirectedToBinaryTreeTraversalTryEditorTest");
	//	treePage.clickGetStartedTreeButton();
	//	treePage.clickBinaryTreeTraversalsButton();
		openTryEditorPage();
		validateTryEditor();
	}
	@Test(priority=20)
	public void validUserShouldBeAbletoLandImplementationOfBinaryTreesPage() throws InterruptedException {
		
		test = extent.createTest("validUserShouldBeAbleToLandImplementationOfBinaryTreesTest");
		treePage.clickBackButton();
	//	treePage.clickGetStartedTreeButton();
		
		treePage.clickImplementationOfBinaryTreesButton();
		String headerMsg = treePage.verifyImplementationOfBinaryTreesHeader();
		Assert.assertEquals(headerMsg, "Implementation of Binary Trees","Invalid Page!!");
	}
	
	@Test(priority=21)
	public void validUserShouldBeRedirectedToImplementationOfBinaryTreesTryEditorPage() {
		test = extent.createTest("validUserShouldBeRedirectedToImplementationOfBinaryTreesTryEditorTest");
//treePage.clickGetStartedTreeButton();
		
		//treePage.clickImplementationOfBinaryTreesButton();
		openTryEditorPage();
		validateTryEditor();
	}
	@Test(priority=22)
	public void validUserShouldBeAbletoLandApplicationsOfBinaryTreesPage() throws InterruptedException {
		
		test = extent.createTest("validUserShouldBeAbleToLandApplicationOfBinaryTreesTest");
		treePage.clickBackButton();
	//	treePage.clickGetStartedTreeButton();
		treePage.clickApplicationsOfBinaryTreesButton();
		String headerMsg = treePage.verifyApplicationsOfBinaryTreesHeader();
		Assert.assertEquals(headerMsg, "Applications of Binary trees","Invalid Page!!");
	}
	
	@Test(priority=23)
	public void validUserShouldBeRedirectedToApplicationsOfBinaryTreesTryEditorPage() {
		test = extent.createTest("validUserShouldBeRedirectedToApplicationOfBinaryTreesTryEditorTest");
		//treePage.clickGetStartedTreeButton();
		//treePage.clickApplicationsOfBinaryTreesButton();
		openTryEditorPage();
		validateTryEditor();
	}
	@Test(priority=24)
	public void validUserShouldBeAbletoLandBinarySearchTreesPage() throws InterruptedException {
		
		test = extent.createTest("validUserShouldBeAbleToLandBinarySearchTreesTest");
		treePage.clickBackButton();
	//	treePage.clickGetStartedTreeButton();
		treePage.clickBinarySearchTreesButton();
		String headerMsg = treePage.verifyBinarySearchTreesHeader();
		Assert.assertEquals(headerMsg, "Binary Search Trees","Invalid Page!!");
	}
	
	@Test(priority=25)
	public void validUserShouldBeRedirectedToBinarySearchTreesTryEditorPage() {
		test = extent.createTest("validUserShouldBeRedirectedToBinarySearchTreesTryEditorTest");
	//	treePage.clickGetStartedTreeButton();
	//	treePage.clickBinarySearchTreesButton();
		openTryEditorPage();
		validateTryEditor();
	}
	
	@Test(priority=26)
	public void validUserShouldBeAbletoLandImplementationOfBSTPage() throws InterruptedException {
		
		test = extent.createTest("validUserShouldBeAbleToLandImplementationOfBSTTest");
		treePage.clickBackButton();
		
		treePage.clickImplementationOfBSTButton();
		String headerMsg = treePage.verifyImplementationBSTHeader();
		Assert.assertEquals(headerMsg, "Implementation Of BST","Invalid Page!!");
	}
	
	@Test(priority=27)
	public void validUserShouldBeRedirectedToImplementationOfBSTTryEditorPage() {
		test = extent.createTest("validUserShouldBeRedirectedToImplementationOfBSTTryEditorTest");
//treePage.clickGetStartedTreeButton();
		
	//	treePage.clickImplementationOfBSTButton();
		
		openTryEditorPage();
		validateTryEditor();
	}
	@Test(priority=28)
	public void validUserShouldBeRedirectedToPracticeQuestions() {
		test = extent.createTest("validUserShouldBeRedirectedToPracticeQuestionsTest");
		treePage.clickBackButton();
//treePage.clickGetStartedTreeButton();
		
		treePage.clickOverviewTreeButton();
		treePage.clickPracticeQuestionsLink();
		try {
		String msg = treePage.verifyPageTitle();
		Assert.assertEquals(msg, "Practicee Questions","Invalid Page!!");
		} catch(Exception e) {
			System.out.println("Report Error" + e);
		}
	}
	
		
	public void openTryEditorPage() {
		
		
		treePage.clickTryHereLink();
		String msg = treePage.verifyTryEditorPageTitle();
		Assert.assertEquals(msg,"Assessment", "Invalid Page !!");
		boolean runBtn = treePage.verifyRunButton();
		Assert.assertTrue(runBtn,"Run Button is not Displayed!!");
		validateTryEditor();
	}
	

}
