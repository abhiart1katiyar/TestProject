package PageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PageObject_Cart {
	
	
	
	// 2nd Section @findBy
	
	@FindBy(id="com.bigbasket.mobileapp:id/btnAddToBasket")
	public WebElement AddCart_button;
	
	@FindBy(id="com.bigbasket.mobileapp:id/basketimageview")
	public WebElement AddCart_img;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductDesc")
	public WebElement AddCart_msg;
	
	
	@FindBy(id="com.bigbasket.mobileapp:id/imgRemove")
	public WebElement DeleteCart_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement DeleteCart_img;
	
	
	
	
	
	
	
	// 1st section : Initialize Page factory
	
	public PageObject_Cart(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	// 3rd Section: Reusable Methods
	
	
	public void Click_AddCart()
	{
	  
		AddCart_button.click();
	}
	
	public void Click_Cart_Img()
	{
	  
		AddCart_img.click();
	}
	
	public String get_AddCart_msg()
	{
	  
		return AddCart_msg.getText();
	}
	
	public void Click_DeleteCart()
	{
	  
		DeleteCart_btn.click();
	}
	
	public String get_DeleteCart_msg()
	{
	  
		return DeleteCart_img.getText();
	}
	

}
