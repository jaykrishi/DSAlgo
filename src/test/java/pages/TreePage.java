package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TreePage {
	
	WebDriver driver;
	@FindBy(how = How.XPATH, using = "//div[6]/div[1]/div[1]/a[contains(text(),'Get Started')]")
	WebElement TREE_GETSTARTED_BUTTON_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Tree')]")
	WebElement TREE_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Overview of Trees')]")
	WebElement OVERVIEW_TREE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Overview of Trees')]")
	WebElement OVERVIEW_TREE_HEADERELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Try here>>>')]")
	WebElement TRYHERE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Run')]")
	WebElement RUN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Terminologies')]")
	WebElement TERMINOLOGIES_TREE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Types of Trees')]")
	WebElement TYPESOF_TREE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Tree Traversals')]")
	WebElement TREE_TRAVERSAL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Traversals-Illustration')]")
	WebElement TRAVERSAL_ILLUSTRATION_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Binary Trees')]")
	WebElement BINARYTREES_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Types of Binary Trees')]")
	WebElement TYPESOF_BINARYTREES_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Implementation in Python')]")
	WebElement IMPLEMENTATION_PYTHON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Implementation of Binary Trees')]")
	WebElement IMPLEMENTATION_BINARYTREES_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Implementation Of BST')]")
	WebElement IMPLEMENTATION_BST_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Applications of Binary trees')]")
	WebElement APPLICATIONS_BINARYTREES_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Binary Tree Traversals')]")
	WebElement BINARYTREE_TRAVERSALS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Binary Search Trees')]")
	WebElement BINARY_SEARCHTREES_ELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Terminologies')]")
	WebElement TERMINOLOGIES_TREE_HEADERELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Types of Trees')]")
	WebElement TYPESOF_TREE_HEADERELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Tree Traversals')]")
	WebElement TREE_TRAVERSAL_HEADERELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Traversals-Illustration')]")
	WebElement TRAVERSAL_ILLUSTRATION_HEADERELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Binary Trees')]")
	WebElement BINARYTREES_HEADERELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Binary Search Trees')]")
	WebElement BINARY_SEARCHTREE_HEADERELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Types of Binary Trees')]")
	WebElement TYPESOFBINARYTREES_HEADERELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Implementation in Python')]")
	WebElement IMPLEMENTATIONPYTHON_HEADERELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Implementation Of BST')]")
	WebElement IMPLEMENTATION_BST_HEADERELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Implementation of Binary Trees')]")
	WebElement IMPLEMENTATION_BINARYTREES_HEADERELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Applications of Binary trees')]")
	WebElement APPLICATIONS_BINARYTREES_HEADERELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Binary Tree Traversals')]")
	WebElement BINARYTREE_TRAVERSALS_HEADERELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Practice Questions')]")
	WebElement PRACTICEQUESTIONS_ELEMENT;
	
	
	
public TreePage(WebDriver driver) {
		
		this.driver = driver;
	}

public void clickGetStartedTreeButton() {
	// TODO Auto-generated method stub
	TREE_GETSTARTED_BUTTON_ELEMENT.click();
}

public String VerifyCurrentUrl() {
	// TODO Auto-generated method stub
	return driver.getCurrentUrl();
}

public void clickBackButton() {
	// TODO Auto-generated method stub
	driver.navigate().back();
	
}

public void clickTreeFromDropDown() {
	// TODO Auto-generated method stub
	TREE_DROPDOWN_ELEMENT.click();
	
}

public void clickOverviewTreeButton() {
	OVERVIEW_TREE_ELEMENT.click();
}
	
public String verifyOverviewOfTreesHeader() {
	
	return OVERVIEW_TREE_HEADERELEMENT.getText();
}
public String verifyTerminologiesTreesHeader() {
	
	return TERMINOLOGIES_TREE_HEADERELEMENT.getText();
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

public void clickTerminologiesButton() {
	// TODO Auto-generated method stub
	TERMINOLOGIES_TREE_ELEMENT.click();
}

public void clickTypesofTreesButton() {
	TYPESOF_TREE_ELEMENT.click();
}

public String verifyTypesOfTreesHeader() {
	// TODO Auto-generated method stub
	return TYPESOF_TREE_HEADERELEMENT.getText();
}
public void clickTreeTraversalsButton() {
	TREE_TRAVERSAL_ELEMENT.click();
}

public String verifyTreeTraversalsHeader() {
	// TODO Auto-generated method stub
	return TREE_TRAVERSAL_HEADERELEMENT.getText();
	
}
public void clickTraversalIllustrationButton() {
	TRAVERSAL_ILLUSTRATION_ELEMENT.click();
}
public String verifyTraversalIllustrationHeader() {
	// TODO Auto-generated method stub
	return TRAVERSAL_ILLUSTRATION_HEADERELEMENT.getText();
}
public void clickBinaryTreesButton() {
	BINARYTREES_ELEMENT.click();
}
public String verifyBinaryTreesHeader() {
	// TODO Auto-generated method stub
	return BINARYTREES_HEADERELEMENT.getText();
}
public void clickTypesOfBinaryTreesButton() {
	TYPESOF_BINARYTREES_ELEMENT.click();
}
public String verifyTypesOfBinaryTreesHeader() {
	// TODO Auto-generated method stub
	return TYPESOFBINARYTREES_HEADERELEMENT.getText();
}
public void clickImplementationInPythonButton() {
	IMPLEMENTATION_PYTHON_ELEMENT.click();
}
public String verifyImplementationPythonHeader() {
	// TODO Auto-generated method stub
	return IMPLEMENTATIONPYTHON_HEADERELEMENT.getText();
}
public void clickBinaryTreeTraversalsButton() {
	BINARYTREE_TRAVERSALS_ELEMENT.click();
}
public String verifyBinaryTreeTraversalsHeader() {
	// TODO Auto-generated method stub
	return BINARYTREE_TRAVERSALS_HEADERELEMENT.getText();
}
public void clickImplementationOfBinaryTreesButton() {
	IMPLEMENTATION_BINARYTREES_ELEMENT.click();
}
public String verifyImplementationOfBinaryTreesHeader() {
	// TODO Auto-generated method stub
	return IMPLEMENTATION_BINARYTREES_HEADERELEMENT.getText();
}
public void clickApplicationsOfBinaryTreesButton() {
	APPLICATIONS_BINARYTREES_ELEMENT.click();
}
public String verifyApplicationsOfBinaryTreesHeader() {
	// TODO Auto-generated method stub
	return APPLICATIONS_BINARYTREES_HEADERELEMENT.getText();
}
public void clickBinarySearchTreesButton() {
	BINARY_SEARCHTREES_ELEMENT.click();
}
public String verifyBinarySearchTreesHeader() {
	// TODO Auto-generated method stub
	return BINARY_SEARCHTREE_HEADERELEMENT.getText();
}
public void clickImplementationOfBSTButton() {
	IMPLEMENTATION_BST_ELEMENT.click();
}
public String verifyImplementationBSTHeader() {
	// TODO Auto-generated method stub
	return IMPLEMENTATION_BST_HEADERELEMENT.getText();
}
public void clickPracticeQuestionsLink() {
	   PRACTICEQUESTIONS_ELEMENT.click();
}

public String verifyPageTitle() {
	   return driver.getTitle();
}


}
