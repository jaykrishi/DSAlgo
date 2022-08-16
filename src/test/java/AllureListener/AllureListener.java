package AllureListener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;
import tests.TestBase;

public class AllureListener implements ITestListener{
	
	
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("I am in onTestStart method " + getTestMethodName(result) + " start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("I am in onTestSuccess method " + getTestMethodName(result) + " succeed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("I am in onTestFailure method " + getTestMethodName(result) + " failed");
		Object testClass = result.getInstance();
		WebDriver driver = TestBase.getDriver();
		// Allure ScreenShot and SaveTestLog
		if (driver instanceof WebDriver) {
			System.out.println("Screenshot captured for test case:" + getTestMethodName(result));
			saveFailureScreenShot(driver);
		}
		saveTextLog(getTestMethodName(result) + " failed and screenshot taken!");	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("I am in onTestSkipped method " + getTestMethodName(result) + " skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(result));
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("I am in onStart method " + context.getName());
		context.setAttribute("WebDriver", TestBase.getDriver());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" I am in onFinish method " + context.getName());
		// TODO Auto-generated method stub
		
	}
	

}
