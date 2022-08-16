package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DSIntroductionPage  {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-primary']")
	WebElement GETSTARTED_INTROBUTTON_ELEMENT;
	@FindBy(how = How.LINK_TEXT, using = "Time Complexity")
	WebElement TIME_COMPLeXITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Try here>>>')]")
	WebElement TRYHERE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Run')]")
	WebElement RUN_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Practice Questions')]")
	WebElement PRACTICEQUESTIONS_ELEMENT;
	
	public DSIntroductionPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
   public String VerifyCurrentUrl() {
	   
	   System.out.println(driver.getCurrentUrl());
	   return driver.getCurrentUrl();
   }
   
   public String verifyTimeComplexityPageTitle() {
	   
	   return driver.getTitle();
   }
   
   public void clickTimeComplexityLink() {
	   TIME_COMPLeXITY_ELEMENT.click();
	   
   }
   public void clickPracticeQuestionsLink() {
	   PRACTICEQUESTIONS_ELEMENT.click();
   }
   
   public String verifyPracticeQuestionsPageTitle() {
	   return driver.getTitle();
   }
   
   public void clickTryHereLink() {
	   TRYHERE_ELEMENT.click();
   }
   
   public boolean verifyRunButton() {
	   return RUN_ELEMENT.isDisplayed();
   }
   public String verifyTryEditorPageTitle() {
	   return driver.getTitle();
   }
   public void clickRunButton() {
	   RUN_ELEMENT.click();
   }

public void clickBackButton() {
	// TODO Auto-generated method stub
	driver.navigate().back();
	
}
public void validateInvalidEntryInTryEditor(){
	   
	   WebElement codeMirror = driver.findElement(By.className("CodeMirror"));

		/* getting the first line of code inside codemirror and clicking it to bring it in focus */
		WebElement codeLine = codeMirror.findElements(By.className("CodeMirror-line")).get(0);
		codeLine.click();

		/* sending keystokes to textarea once codemirror is in focus */
		WebElement txtbx = codeMirror.findElement(By.cssSelector("textarea"));
		
		txtbx.sendKeys("Hello World");
		try {
		    RUN_ELEMENT.click();;
		} catch (UnhandledAlertException f) {
		    
			   JavascriptExecutor js = (JavascriptExecutor)driver;
			   String titleText =  js.executeScript("return document.title;").toString();
		        System.out.println("Page Title is: "+ titleText);
		        Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        System.out.println("Alert data: " + alertText);
		        alert.accept();
		     
		        f.printStackTrace();
		    }
		}
		
			
		}



