package PageObject_Component;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PageObject_Search {
	
	
	// 2nd Section: @FindBy
	
	@FindBy(id="com.bigbasket.mobileapp:id/homePageSearchBox")
	public WebElement srch_button;
	
	
	@FindBy(id="com.bigbasket.mobileapp:id/searchView")
	public WebElement srch_txtbox;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Invalid_srchmsg;
	
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductCount")
	public WebElement valid_srchmsg;
	
	
	
	
	
	
	//1st Section : Initialize Page factory
	
	public PageObject_Search(AppiumDriver driver)
	{
	   	PageFactory.initElements(driver, this);
	}
	
	
	
	// 3rd Section: Reusable Methods
	
	
	
	
	public void Enter_SrchText(String Search_Item)
	{
	  
		srch_button.click();

        srch_txtbox.sendKeys(Search_Item + "\n");	

	}
	
	
	public String get_InvalidSrchmsg()
	{
		return Invalid_srchmsg.getText();
	}
	
	
	
	public String get_ValidSrchmsg()
	{
		return valid_srchmsg.getText();
	}

}
