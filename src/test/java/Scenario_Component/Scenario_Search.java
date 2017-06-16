package Scenario_Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Search;

public class Scenario_Search extends Base_Class {
	

	public static Logger log=Logger.getLogger(Scenario_Search.class);
	
	//@Test(dataProvider="dp_InvalidSearch" , dataProviderClass=DataProvider_Component.Dataprovider_testdata.class, groups={"smoke"})
	public void testInvalidSearch(Map<String,String> Search) throws IOException, InterruptedException
	{
		
		
		SoftAssert sAssert=new SoftAssert();
		
		String TC_ID = Search.get("TC_ID");
		String Order_Set = Search.get("Order_Set");
		String Search_Item = Search.get("Search_Item");
		String Exp_Result = Search.get("Exp_Result");
		
		// Start_Server();
		
		Launch_App();
		
		
		
		PageObject_Search obj_srch = new PageObject_Search(driver);
		
		obj_srch.Enter_SrchText(Search_Item);
		
		ExplicitWait(obj_srch.Invalid_srchmsg, 35);
		String Actual_result = obj_srch.get_InvalidSrchmsg();
		
		System.out.println("Actual_Result : " +Actual_result);
		
		if(Actual_result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is: " + Actual_result + "and Expected Result is: " + Exp_Result);
		}
		else
		{
			log.info("Failed as Actual Result is: " + Actual_result + "and Expected Result is: " + Exp_Result);
			sAssert.fail("Failed as Actual Result is: " + Actual_result + "and Expected Result is: " + Exp_Result);

		}
		
		// Stop_Server();
		sAssert.assertAll();
		
		
	}
	
	
	
	//@Test(dataProvider="dp_ValidSrch", dataProviderClass=DataProvider_Component.Dataprovider_testdata.class,groups={"smoke"})
	public void testValidSearch(Map<String,String> Search) throws InterruptedException, IOException
	{
		
		SoftAssert sAssert = new SoftAssert();
		
		String TC_ID = Search.get("TC_ID");
		String Order_Set = Search.get("Order_Set");
		String Search_Item = Search.get("Search_Item");
		String Exp_Result = Search.get("Exp_Result");
		
		//Start_Server();
		
		Launch_App();
		
		PageObject_Search obj_srch2= new PageObject_Search(driver);
		
		obj_srch2.Enter_SrchText(Search_Item);
		
		ExplicitWait(obj_srch2.valid_srchmsg, 35);
		String Actual_Result = obj_srch2.get_ValidSrchmsg();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is :  " + Actual_Result + "  and Expected Result is :  " + Exp_Result);
			
		}
		else
		{
			log.info("Failed as Actual Result is :  " + Actual_Result + "  and Expected Result is :  " + Exp_Result);
			sAssert.fail("Failed as Actual Result is :  " + Actual_Result + "  and Expected Result is :  " + Exp_Result);

		}

		// Stop_Server();
		
		sAssert.assertAll();
		
		
		
	}
	
	
	

}
