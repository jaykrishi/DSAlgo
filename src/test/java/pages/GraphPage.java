package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GraphPage {
	WebDriver driver;
	@FindBy(how = How.XPATH, using = "//div[7]//a[contains(text(),'Get Started')]")
	WebElement GRAPHGETSTARTED_ELEMENT;
	@FindBy(how = How.XPATH, using = "//ul/a[text()='Graph']")
	WebElement GRAPHBUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Try here>>>')]")
	WebElement TRYHERE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//ul/a[text()='Graph']")
	WebElement GRAPH_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Graph Representations')]")
	WebElement GRAPH_REPRESENTATIONS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Run')]")
	WebElement RUN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Graph Representations')]")
	WebElement GRAPH_REPRESENTATIONS_HEADERELEMENT;
	
public GraphPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String VerifyCurrentUrl() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}

	public void clickGraphButton() {
		// TODO Auto-generated method stub
		GRAPH_ELEMENT.click();
	}

	public void clickTryHereLink() {
		// TODO Auto-generated method stub
		 TRYHERE_ELEMENT.click();
	}

	public String verifyTryEditorPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	public boolean verifyRunButton() {
		// TODO Auto-generated method stub
		return RUN_ELEMENT.isDisplayed();
	}

	public String verifyGraphRepresentationsHeader() {
		// TODO Auto-generated method stub
		return GRAPH_REPRESENTATIONS_HEADERELEMENT.getText();
	}

	public void clickGraphRepresentationButton() {
		// TODO Auto-generated method stub
		GRAPH_REPRESENTATIONS_ELEMENT.click();
	}

	public void clickBackButton() {
		// TODO Auto-generated method stub
		driver.navigate().back();
	}
	

}
