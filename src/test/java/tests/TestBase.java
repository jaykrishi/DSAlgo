package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class TestBase {
	
	static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	static String browser;
	static String url;
	public ExtentSparkReporter spark;
	 public static ExtentReports extent;
	 public ExtentTest test;
	
	 @BeforeSuite
	 public void setExtent() {
	  // specify location of the report
	 spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/Extent.html");

	  spark.config().setDocumentTitle("Automation Report"); // Tile of report
	  spark.config().setReportName("Functional Testing"); // Name of the report
	  spark.config().setTheme(Theme.DARK);
	  
	 extent = new ExtentReports();
	 extent.attachReporter(spark);
	  
	  // Passing General information
	  extent.setSystemInfo("Host name", "localhost");
	  extent.setSystemInfo("Environemnt", "QA");
	  extent.setSystemInfo("user", "jay");
	 }
	
	 @AfterClass
	 public void endReport() {
	  extent.flush();
	  driver.quit();
	 
	 }
	 
	
	 @Parameters("browser") 
	 @AfterMethod
	 public void tearDown(ITestResult result, String browser) throws IOException {
		 System.out.println(result.getStatus());
	  if (result.getStatus() == ITestResult.FAILURE) {
		  test.log(Status.PASS,"Browser used is " + browser);
	   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
	   System.out.println(result.getName());
	   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
	   String screenshotPath = getScreenshot(driver, result.getName());
	   test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
	  } else if (result.getStatus() == ITestResult.SKIP) {
		  test.log(Status.PASS,"Browser used is " + browser);
	   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
	  }
	  else if (result.getStatus() == ITestResult.SUCCESS) {
		  test.log(Status.PASS,"Browser used is " + browser);
	   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
	  }
	//  driver.quit();
	 }
	 
	 public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
	  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	  TakesScreenshot ts = (TakesScreenshot) driver;
	  File source = ts.getScreenshotAs(OutputType.FILE);
	  
	  // after execution, you could see a folder "FailedTestsScreenshots" under src folder
	  String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
	  File finalDestination = new File(destination);
	  FileUtils.copyFile(source, finalDestination);
	  return destination;
	 }
	
	
	public static void readConfig() {
		// FileReader //Scanner //InputStream //BufferedReader

		try {
			InputStream input = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			Properties prop = new Properties();
			prop.load(input);
			//browser = prop.getProperty("browser");
			//System.out.println("Browser Used = " + browser);
			url = prop.getProperty("url");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
/*	public static WebDriver init() {
		
		readConfig();
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}*/
	
	
	@Parameters("browser")
	@BeforeTest
	public void setBrowser(String browser)
	{
		readConfig();
	   if (browser.equalsIgnoreCase("Firefox")) {
		   System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
	      driver = new FirefoxDriver();
	      
	   }
	   else if (browser.equalsIgnoreCase("Chrome")) {
		   System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	      driver = new ChromeDriver();
	      driver.manage().window().maximize();
			tdriver.set(driver);
			tdriver.get();
	   }
	   else {
	      throw new IllegalArgumentException("Invalid browser value!!");
	   }
	   driver.get(url);
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	  
	   
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
	
	
	public void validateTryEditor() {
		/* getting codemirror element */
		WebElement codeMirror = driver.findElement(By.className("CodeMirror"));

		/* getting the first line of code inside codemirror and clicking it to bring it in focus */
		WebElement codeLine = codeMirror.findElements(By.className("CodeMirror-line")).get(0);
		codeLine.click();

		/* sending keystokes to textarea once codemirror is in focus */
		WebElement txtbx = codeMirror.findElement(By.cssSelector("textarea"));
		txtbx.sendKeys("print('Hello World')");
		
	}
	
	
}
	

