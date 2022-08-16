package pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public int generateRandom(int bounderyNum) {
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(bounderyNum);
		return generatedNum;
	}
	
	
}
