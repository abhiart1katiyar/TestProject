package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Cart;
import PageObject_Component.PageObject_Search;

public class Scenario_Cart extends Base_Class{
	
	public static Logger log = Logger.getLogger(Scenario_Cart.class);
	
	
	@Test(dataProvider="dp_AddCart", dataProviderClass=DataProvider_Component.Dataprovider_testdata.class,groups={"smoke"})
	public void testAddCart(Map<String,String> cart) throws IOException, InterruptedException
	{
		SoftAssert sAssert = new SoftAssert();
		
		String TC_ID = cart.get("TC_ID");
		String Order_Set = cart.get("Order_Set");
		String Search_Item = cart.get("Search_Item");
		String Exp_Result = cart.get("Exp_Result");

		// Start_Server();
		
		Launch_App();
		
		PageObject_Search obj_srch = new PageObject_Search(driver);
		obj_srch.Enter_SrchText(Search_Item);
		
		ExplicitWait(obj_srch.valid_srchmsg, 35);
		obj_srch.get_ValidSrchmsg();
		
		
		PageObject_Cart obj_cart = new PageObject_Cart(driver);
		obj_cart.Click_AddCart();
		
		ExplicitWait(obj_cart.AddCart_img, 35);
		obj_cart.Click_Cart_Img();
		
		
		ExplicitWait(obj_cart.AddCart_msg, 35);
		String Actual_Result = obj_cart.get_AddCart_msg();
		
		if(Actual_Result.equals(Exp_Result))
		{
			
			log.info("TC Passed as Actual result is: " + Actual_Result + " and Expected result is  : " + Exp_Result);
			Capture_Screenshot1(TC_ID, Order_Set);
		}
		
		else
		{
			log.info("TC Failed as Actual result is: " + Actual_Result + " and Expected result is  : " + Exp_Result);
			sAssert.fail("TC Failed as Actual result is: " + Actual_Result + " and Expected result is  : " + Exp_Result);
			Capture_Screenshot1(TC_ID, Order_Set);

		}
		
	// 	Stop_Server();
		
		
		sAssert.assertAll();
		
	 }
	

}
