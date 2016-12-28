package com.components.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.collections.Lists;

import sun.net.dns.ResolverConfiguration.Options;

import com.components.repository.SiteRepository;
import com.iwaf.framework.TestProperties;
import com.iwaf.framework.components.SoftAssertion;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;



public class Esysco_IFG_Page extends SitePage{
	
	public static final Target btnEsysco = new Target("btnEsysco","//*[@id='esysco']",Target.XPATH);
	public static final Target txt_opco=new Target("txt_opco","html/body/table/tbody/tr[3]/td/form/input[2]",Target.XPATH) ;
			
	public static final Target btn_submit=new Target("btn_submit","html/body/table/tbody/tr[3]/td/form/input[3]",Target.XPATH) ;
			//"submit",Target.NAME) ;
	public static final Target active_cust=new Target("active_cust","//*[contains(text(),'Active Customers')]",Target.XPATH);
	public static final Target selectactive_cust=new Target("selectActive_cust","//*[contains(text(),'<#>')]",Target.XPATH);
			//"//*[contains(text(),'A&M SERVICES LIMITED')]",Target.XPATH);
	////*[contains(text(),'A&M SERVICES LIMITED')]
	public static final Target lnk_newUser=new Target("lnk_newUser","//*[contains(text(),'Create New User')]",Target.XPATH);
	public static final Target userID=new Target("userID","USERID",Target.NAME);
	public static final Target contactName=new Target("contactName","ContactName",Target.NAME);
	public static final Target contactPhone=new Target("contactPhone","ContactPhone",Target.NAME);
	public static final Target chk_containerEnabled=new Target("chk_containerEnabled","containerEnabled",Target.NAME);
	public static final Target check_sysco=new Target("check_sysco","orderMgmtOpt",Target.NAME);
	public static final Target btn_Save=new Target("btn_Save","SUBMIT",Target.NAME);
	
	public static final Target lnk_logOut=new Target("lnk_logOut","//a[contains(text(),'Log Out')]",Target.XPATH);
	public static final Target txt_IsrUserName = new Target("txt_IsrUserName","//*[@id='USERID']",Target.XPATH);
	public static final Target txt_IsrPassword = new Target("txt_IsrPassword","//*[@id='currentPassword']",Target.XPATH);
	public static final Target btn_IsrSignIn = new Target("btn_IsrSignIn","//*[@id='img_login']",Target.XPATH);
	public static final Target new_Password1 = new Target("btn_IsrSignIn","newPassword1",Target.ID);
	public static final Target new_Password2 = new Target("btn_IsrSignIn","newPassword2",Target.ID);
	public static final Target btn_submit1 = new Target("btn_submit1","submit",Target.NAME);
	public static final Target lst_SecurityQuestionOne = new Target("lst_SecurityQuestionOne","SecurityQuestionOne",Target.NAME);
	public static final Target lst_SecurityQuestionTwo = new Target("lst_SecurityQuestionTwo","SecurityQuestionTwo",Target.NAME);
	public static final Target lst_SecurityQuestionThree = new Target("lst_SecurityQuestionThree","SecurityQuestionThree",Target.NAME);
	public static final Target txt_SecurityAnswer1 = new Target("txt_SecurityAnswer1","SecurityAnswer1",Target.NAME);
	public static final Target txt_SecurityAnswer2 = new Target("txt_SecurityAnswer2","SecurityAnswer2",Target.NAME);
	public static final Target txt_SecurityAnswer3 = new Target("txt_SecurityAnswer3","SecurityAnswer3",Target.NAME);
	public static final Target submit_SecurityQA = new Target("submit_SecurityQA","input[type='submit']",Target.CSS);
	public static final Target lst_usertype = new Target("lst_usertype","usertype",Target.NAME);
	public static final Target btn_Express = new Target("btn_Express","//*[@id='syscoMarketExpress']",Target.XPATH);
	public static final Target lnk_Orders = new Target("lnk_Orders","//a[contains(text(),'Orders')]",Target.XPATH);
	public static final Target lnk_Lists = new Target("lnk_Lists","//a[contains(text(),'Lists')]",Target.XPATH);
	public static final Target lnk_OrderGuide = new Target("lnk_OrderGuide","//a[contains(text(),'Order Guide')]",Target.XPATH);
	public static final Target lnk_Products = new Target("lnk_Products","//a[contains(text(),'Products')]",Target.XPATH);
	public static final Target lnk_Reports = new Target("lnk_Reports","//a[contains(text(),'Reports')]",Target.XPATH);
	public static final Target link_MenuAnalysis = new Target("btn_Express","//a[contains(text(),'Menu Analysis')]",Target.XPATH);
	public static final Target btn_CreateNewOrder = new Target("btn_CreateNewOrder","//*[@id='createNewOrderButton']",Target.XPATH);
	public static final Target div_createNewOrderDiv = new Target("div_createNewOrderDiv","//*[@id='createNewOrderDiv']",Target.XPATH);
	public static final Target list_shipmentType = new Target("list_shipmentType","//*[@id='shipmentType']",Target.XPATH);
	public static final Target list_containerSize = new Target("list_containerSize","//*[@id='containerSize']",Target.XPATH);
	public static final Target list_containerType = new Target("list_containerType","//*[@id='containerType']",Target.XPATH);
	public static final Target btn_Order = new Target("btn_Order","//*[@id='createNewOrder']",Target.XPATH);
	public static final Target lnk_activeOrder = new Target("lnk_activeOrder","//*[@id='docnamelink']/b",Target.XPATH);
	public static final Target lnk_Customer = new Target("lnk_Customer","//*[contains(@href,'<#>')]",Target.XPATH);
	public static final Target txt_SearchCust = new Target("txt_SearchCust","//input[@name='SEARCHCUSTOMER']",Target.XPATH);
	public static final Target btn_SearchCust = new Target("btn_SearchCust","//input[@value='Search Customer']",Target.XPATH);
	public static final Target chk_SMX = new Target("chk_SMX","//input[@type='checkbox']/parent::td",Target.XPATH);
	public static final Target lnk_ActiveCustomer = new Target("lnk_ActiveCustomer","//*[text()='Active Customers']/parent::font/parent::a",Target.XPATH);
	public static final Target alert_div=new Target("alert_div","//*[@id='alertTestDiv']",Target.XPATH);
	public static final Target alert_div_chkAccept=new Target("alert_div_chkAccept","//*[@id='alertTestDiv'][@title='Confirm Container Type']/div[2]/div/input[1]",Target.XPATH);
	public static final Target add_Item_List=new Target("add_Item_List","//*[@id='addItemToOrder']",Target.XPATH);
	public static final Target alert_Product=new Target("alert_Product","//*[@id='alertProductFlagDialog']",Target.XPATH);
	public static final Target alert_ContainerType=new Target("alert_ContainerType","//*[@id='updateContainerTypeDialog']",Target.XPATH);
	public static final Target update_ContainerType=new Target("update_ContainerType","//*[@id='createNewOrderForUpdate']",Target.XPATH);
	public static final Target close_ContainerType=new Target("close_ContainerType","//*[@id='alertCloseChangeContainerTypeDialog']",Target.XPATH);
	public static final Target change_ContainerType=new Target("change_ContainerType","//*[@id='containerTypeUpdate']",Target.XPATH);
	public static final Target get_ContainerType=new Target("get_ContainerType","//*[@id='containerEnabledDisplay_containerTypeValue']",Target.XPATH);
	public static final Target get_shipmentType=new Target("get_shipmentType","//*[@id='containerEnabledDisplay_shipmentType']/span[2]",Target.XPATH);
	public static final Target get_totalCube=new Target("get_totalCube","//*[@id='totalOrderCube']",Target.XPATH);
	public static final Target get_totalWeight=new Target("get_totalWeight","//*[@id='totalOrderWeight']",Target.XPATH);
	public static final Target chk_standardUnits=new Target("chk_standardUnits","//*[@id='standardUnits']",Target.XPATH);
	public static final Target tihi_label=new Target("tihi_label","//*[@id='jqgh_grid1_tihi']",Target.XPATH);
	public static final Target shelLife_label=new Target("shelLife_label","//*[@id='jqgh_grid1_ifgshelfLife']",Target.XPATH);
	public static final Target label_ColmnSettings=new Target("label_ColmnSettings","//*[contains(text(),'Column Settings')]",Target.XPATH);
	public static final Target div_ColmnSettings=new Target("div_ColmnSettings","html/body//*[contains(text(),'Select columns')]",Target.XPATH);
	public static final Target TiHi_ColmnSettings=new Target("TiHi_ColmnSettings","//*[@id='colchooser_grid1']//*[contains(@title,'Ti/Hi')]/a",Target.XPATH);
	public static final Target lnk_removeAll=new Target("lnk_removeAll","//*[@id='colchooser_grid1']//*[contains(text(),'Remove all')]",Target.XPATH);
	public static final Target lnk_close=new Target("lnk_close","html/body/div[56]/div[1]/a//*[contains(text(),'close')]",Target.XPATH);
	public static final Target lnk_Ok=new Target("lnk_Ok","html/body/div[56]/div[11]/div/button[1]",Target.XPATH);
	public static final Target tab_Shipment=new Target("tab_Shipment","//*[@id='shipmentTab']",Target.XPATH);
	public static final Target plusMinus_bttn = new Target("plusMinus_bttn","<#>",Target.XPATH);
	public static final Target weight_Label = new Target("weight_Label","<#>",Target.XPATH);
	public static final Target cube_Label = new Target("cube_Label","<#>",Target.XPATH);
	public static final Target txt_itemQty = new Target("txt_itemQty","<#>",Target.XPATH);
	public static final Target chek_Price = new Target("chek_Price","<#>",Target.XPATH);
	public static final Target txt_Search=new Target("txt_Search","//*[@id='txtSearch']",Target.XPATH);
	public static final Target txt_Quantity=new Target("txt_Quantity","//*[@id='<#>-CS_syscoGridColumnEditableQuantityFormatter']",Target.XPATH);
	public static final Target btn_search=new Target("btn_search","//*[@id='btnSearch']",Target.XPATH);
	public static final Target alertclose = new Target("alertclose","html/body/div[43]/div[1]/a/span",Target.XPATH);
	public static final Target add_con = new Target("add_con","//*[@id='alertProductFlagDialog']/div[2]/div/input[1]",Target.XPATH);
	public static final Target MT_accpt = new Target("MT_accpt","//*[@id='alertTestDiv']/div[2]/div/input[1]",Target.XPATH);
	public static final Target btn_ViewOrder=new Target("btn_ViewOrder","//*[@id='viewActiveOrderBtn']", Target.XPATH);
	public static final Target delete_order=new Target("delete_order","//*[@id='deleteOrderLink']", Target.XPATH);
	public static final Target delete_order1=new Target("delete_order1","//*[@id='deleteOrderLink1']", Target.XPATH);
	public static final Target delete_orderpopup=new Target("delete_orderpopup","//*[@id='deleteOrderDiv']", Target.XPATH);
	public static final Target delete_orderyes=new Target("delete_orderyes","//*[@id='deleteOrder']", Target.XPATH);
	public static final Target txt_OrderName = new Target("txt_OrderName","//*[@id='orderName']",Target.XPATH);
	public static final Target cnt_under_cap = new Target("txt_OrderName","//*[@id='popupForSubmitOrderStandardDiv']",Target.XPATH);
	public static final Target cnt_under_ca_accept = new Target("txt_OrderName","//*[@id='acceptToSubmit1']",Target.XPATH);
	
	public Esysco_IFG_Page(SiteRepository repository) {
		
	super(repository);
		
	}
	public Esysco_IFG_Page ClikonEsysco()
	{
		getCommand().waitFor(3);
		getCommand().getDriver().switchTo().frame("botFrame");
		getCommand().isTargetVisible(btnEsysco);
		//getCommand().waitForTargetPresent(btnEsysco, 2);
	    if(getCommand().isTargetPresent(btnEsysco)){
		log("Click on eSysco " ,LogType.STEP);	
		getCommand().click(btnEsysco);
	    }
	return this;
	 }
	public Esysco_IFG_Page Enter_Opco(String opco)
	{
		getCommand().waitFor(3);
		getCommand().getDriver().switchTo().frame("botFrame");
		getCommand().getDriver().switchTo().frame("leftFrame");
		//getCommand().waitForTargetPresent(txt_opco, 2);
	    if(getCommand().isTargetPresent(txt_opco)){
		log("Enetr opco : " + opco,LogType.STEP);
		getCommand().click(txt_opco);
		getCommand().sendKeys(txt_opco, opco);
		}
	    getCommand().waitFor(3);
	    if(getCommand().isTargetPresent(btn_submit)){
			log("Click on Go button " ,LogType.STEP);	
			getCommand().click(btn_submit);
		}
	    
	return this;
	 }
	
	public Esysco_IFG_Page clickOnActiveCustomer()
	{
		getCommand().waitFor(5);
		
		getCommand().getDriver().switchTo().frame("botFrame");
		getCommand().getDriver().switchTo().frame("leftFrame");
		getCommand().waitForTargetVisible(lnk_ActiveCustomer);
		if(getCommand().isTargetPresent(lnk_ActiveCustomer)){
			log("Click on Active Customer " ,LogType.STEP);	
			getCommand().click(lnk_ActiveCustomer);
		}
		return this;
		
	}
	
	public Esysco_IFG_Page selectIFGCustomer()
	{
		getCommand().waitFor(3);
		getCommand().getDriver().switchTo().frame("botFrame");
		String selectCust="A&M SERVICES LIMITED";
		if(getCommand().isTargetVisible(selectactive_cust.replace("<#>",selectCust)))
		{
		log("Select Active Customer " ,LogType.STEP);	
		getCommand().click(selectactive_cust.replace("<#>",selectCust));
		}
		return this;
	}
	public Esysco_IFG_Page createNewIFGUser(String type)
	{
		getCommand().waitFor(3);
		getCommand().getDriver().switchTo().frame("botFrame");
		
		if(getCommand().isTargetVisible(lnk_newUser))
		{
		log("Create New IFG User " ,LogType.STEP);	
		getCommand().click(lnk_newUser);
		}
		getCommand().waitFor(2);
		getCommand().getDriver().switchTo().frame("botFrame");
		String UserName = RandomStringUtils.randomAlphabetic(10);
		getCommand().isTargetVisible(userID);
		if(getCommand().isTargetPresent(userID))
		{
		getCommand().storeValue("storeuserID", UserName);
		log("Enter the UserID " ,LogType.STEP);	
		getCommand().click(userID);
		getCommand().sendKeys(userID, UserName);
		}
		if(getCommand().isTargetPresent(contactName))
		{
		log("Enter the Contact Name " ,LogType.STEP);	
		getCommand().click(contactName);
		getCommand().sendKeys(contactName, "IFG AUtomation");
		}
		if(getCommand().isTargetPresent(contactPhone))
		{  
			log("Enter the Contact PhoneNo " ,LogType.STEP);	
			getCommand().click(contactPhone);
			getCommand().sendKeys(contactPhone, "9456248678");
			getCommand().getDriver().findElement(By.name("emailAddress")).clear();
		}
		
		
		if(type.compareTo("MULTIBUYER")==0)
		{
			if(getCommand().isTargetPresent(lst_usertype))
			{   getCommand().click(lst_usertype);
				Select st=new Select(getCommand().getDriver().findElement(By.name("usertype")));
				st.selectByValue("11");
				if (Arrays.asList("*firefox","*iexplore").contains(TestProperties.getProperties("test.browser")))
				{
				WebElement wedateWidget = getCommand().getDriver().findElement(By.name("usertype"));  
				wedateWidget.sendKeys(Keys.ENTER);
				}
				
				//getCommand().waitFor(2);
				//getCommand().selectDropDown(lst_usertype, "Multi-Buyer");	
			}
		}
		
		if(getCommand().isTargetPresent(chk_containerEnabled))
		{
			log("Check the Container enabled " ,LogType.STEP);
			getCommand().click(chk_containerEnabled);
		}
		if(getCommand().isTargetPresent(btn_Save))
		{
			getCommand().click(btn_Save);
			
		}
		return this;
	}
	
	public Esysco_IFG_Page createNewUser(String type)
	{
		getCommand().waitFor(3);
		getCommand().getDriver().switchTo().frame("botFrame");
		
		if(getCommand().isTargetVisible(lnk_newUser))
		{
		log("Create New IFG User " ,LogType.STEP);	
		getCommand().click(lnk_newUser);
		}
		getCommand().waitFor(2);
		getCommand().getDriver().switchTo().frame("botFrame");
		String UserName = RandomStringUtils.randomAlphabetic(10);
		getCommand().isTargetVisible(userID);
		if(getCommand().isTargetPresent(userID))
		{
		getCommand().storeValue("storeuserID", UserName);
		log("Enter the UserID " ,LogType.STEP);	
		getCommand().click(userID);
		getCommand().sendKeys(userID, UserName);
		}
		if(getCommand().isTargetPresent(contactName))
		{
		log("Enter the Contact Name " ,LogType.STEP);	
		getCommand().click(contactName);
		getCommand().sendKeys(contactName, "SME AUtomation");
		}
		if(getCommand().isTargetPresent(contactPhone))
		{  
			log("Enter the Contact PhoneNo " ,LogType.STEP);	
			getCommand().click(contactPhone);
			getCommand().sendKeys(contactPhone, "9456248678");
		}
		
		
		if(type.compareTo("MULTIBUYER")==0)
		{
			if(getCommand().isTargetPresent(lst_usertype))
			{
				getCommand().click(lst_usertype);
				Select st=new Select(getCommand().getDriver().findElement(By.name("usertype")));
				st.selectByValue("11");
				if (Arrays.asList("*firefox","*iexplore").contains(TestProperties.getProperties("test.browser")))
				{
				WebElement wedateWidget = getCommand().getDriver().findElement(By.name("usertype"));  
				wedateWidget.sendKeys(Keys.ENTER);
				}
			}
		}
		
		if(type.compareTo("MULTIAPPROVER")==0)
		{
			if(getCommand().isTargetPresent(lst_usertype))
			{
				getCommand().click(lst_usertype);
				Select st=new Select(getCommand().getDriver().findElement(By.name("usertype")));
				st.selectByValue("12");
				if (Arrays.asList("*firefox","*iexplore").contains(TestProperties.getProperties("test.browser")))
				{
				WebElement wedateWidget = getCommand().getDriver().findElement(By.name("usertype"));  
				wedateWidget.sendKeys(Keys.ENTER);
				}
				
			}
		}
		if(getCommand().isTargetPresent(chk_containerEnabled))
		{
			log("Check the Container enabled " ,LogType.STEP);
			getCommand().click(chk_containerEnabled);
		}
		
		if(getCommand().isTargetPresent(check_sysco))
		{
			log("Select Sysco market Express ",LogType.STEP);
			getCommand().click(check_sysco);
		}
		
		if(getCommand().isTargetPresent(btn_Save))
		{
			getCommand().click(btn_Save);
			
		}
		return this;
	}
	public Esysco_IFG_Page clickLogOut()
	{   getCommand().waitFor(5);
		getCommand().getDriver().switchTo().frame("topFrame");
		getCommand().waitForTargetPresent(lnk_logOut);
		log("Log out the user ",LogType.STEP);
		if(getCommand().isTargetPresent(lnk_logOut))
		{
			getCommand().click(lnk_logOut);
			getCommand().waitFor(5);
			Alert alert =getCommand().getDriver().switchTo().alert();
			alert.accept();
		}
		return this;
			
	}
	public Esysco_IFG_Page firstloginNewISRUser() {
		getCommand().waitForTargetPresent(txt_IsrUserName);
		if (getCommand().isTargetPresent(txt_IsrUserName)){
			String UserName=(String) getCommand().retrieveValue("storeuserID");
			log("Enter User Name " + UserName,LogType.STEP);
			getCommand().sendKeys(txt_IsrUserName, UserName);
		}
		if (getCommand().isTargetPresent(txt_IsrPassword)){
			log("Enter Password",LogType.STEP);	
			getCommand().sendKeys(txt_IsrPassword, "password");
		}		
		if (getCommand().isTargetPresent(btn_IsrSignIn)){
			log("Click on Submit Button",LogType.STEP);	
			getCommand().click(btn_IsrSignIn);
			//log("Login Successful",LogType.STEP);	

		}
		return this;
		}
	public Esysco_IFG_Page change_password(String newPassword)
	{
		getCommand().waitFor(3);
		getCommand().getDriver().switchTo().frame("botFrame");
		getCommand().waitForTargetPresent(txt_IsrPassword);
		log("Enter first password",LogType.STEP);	
		if(getCommand().isTargetPresent(txt_IsrPassword));
		{
			getCommand().sendKeys(txt_IsrPassword,"password");
			
		}
		getCommand().waitForTargetPresent(new_Password1);
		log("Enter new password",LogType.STEP);	
		if(getCommand().isTargetPresent(new_Password1));
		{
			getCommand().sendKeys(new_Password1,newPassword);
			
		}
		getCommand().waitForTargetPresent(new_Password2);
		log("Confirm password",LogType.STEP);	
		if(getCommand().isTargetPresent(new_Password2));
		{
			getCommand().sendKeys(new_Password2,newPassword);
			
		}
		getCommand().waitFor(2);
		if (getCommand().isTargetPresent(btn_submit1)){
			log("Click on Submit Button",LogType.STEP);	
			getCommand().click(btn_submit1);
			//log("Login Successful",LogType.STEP);	

		}
		
		return this;
		
	}
	public Esysco_IFG_Page selectSecurityQuestions()
	{
		getCommand().waitForTargetPresent(lst_SecurityQuestionOne);
		log("Select security Questions",LogType.STEP);	
		if(getCommand().isTargetPresent(lst_SecurityQuestionOne))
		{
			Select stQt1=new Select(getCommand().getDriver().findElement(By.name("SecurityQuestionOne")));
			stQt1.selectByValue("What is your childhood nick name?");	
			Select stQt2=new Select(getCommand().getDriver().findElement(By.name("SecurityQuestionTwo")));
			stQt2.selectByValue("What is the name of your favorite childhood friend?");	
			Select stQt3=new Select(getCommand().getDriver().findElement(By.name("SecurityQuestionThree")));
			stQt3.selectByValue("What is the name of your elementary/primary school?");	
			
		}
		return this;
		
	}
	public Esysco_IFG_Page selectSecurityQuestionsAnswers(String answers)
	{
		
		log("Enter  security answers",LogType.STEP);	
		getCommand().click(txt_SecurityAnswer1);
		getCommand().sendKeys(txt_SecurityAnswer1,answers);
		getCommand().click(txt_SecurityAnswer2);
		getCommand().sendKeys(txt_SecurityAnswer2,answers);
		getCommand().click(txt_SecurityAnswer3);
		getCommand().sendKeys(txt_SecurityAnswer3,answers);
		
		return this;
		
	}
	public Esysco_IFG_Page click_submit()
	{
		getCommand().waitFor(2);
		if (getCommand().isTargetPresent(submit_SecurityQA)){
			log("Click on Submit Button",LogType.STEP);	
			getCommand().click(submit_SecurityQA);
			//log("Login Successful",LogType.STEP);	

		}
		return this;
		
	}
	public Esysco_IFG_Page checkSuccess_001() {
		getCommand().waitFor(3);
		log("New user is able to access the application",LogType.STEP);
		getCommand().getDriver().switchTo().frame("botFrame");
		getCommand().waitForTargetVisible(btn_Express);
		if(getCommand().isTargetPresent(btn_Express))
		{
			log("Only Sysco Market Express is enabled for ISR user ",LogType.STEP);
		}
		return this;
	}
	public Esysco_IFG_Page homePageLinkValidation()
	{
		getCommand().waitFor(3);
		if(getCommand().isTargetPresent(lnk_Orders));
		{
			
			log("Order Lik present in Homepage",LogType.STEP);
		}
		if(getCommand().isTargetPresent(lnk_Lists));
		{
			
			log("Lists Lik present in Homepage",LogType.STEP);
		}
		if(getCommand().isTargetPresent(lnk_OrderGuide));
		{
			
			log("Order Guide  Lik present in Homepage",LogType.STEP);
		}
		if(getCommand().isTargetPresent(lnk_Products));
		{
			
			log("Products Lik present in Homepage",LogType.STEP);
		}
		if(!getCommand().isTargetPresent(lnk_Reports));
		{
			
			log("Report Link not present in Homepage",LogType.STEP);
		}
		if(!getCommand().isTargetPresent(link_MenuAnalysis));
		{
			
			log("Menu Analysis  Lik not  present in Homepage",LogType.STEP);
		}
		return this;
		
	}
	
	public Esysco_IFG_Page CreateNewOrder()
	{
		getCommand().waitFor(3);
		getCommand().waitForTargetPresent(btn_CreateNewOrder);
		if(getCommand().isTargetPresent(btn_CreateNewOrder))
		{
			log("Click on Start new order/shipment  in the home page ",LogType.STEP);
			getCommand().click(btn_CreateNewOrder);
		}
		getCommand().waitForTargetPresent(div_createNewOrderDiv);
		if(getCommand().isTargetPresent(div_createNewOrderDiv))
		{
		log("Start new shipment pop up should be displayed",LogType.STEP);	
		}
		
		return this;	
	}
	public Esysco_IFG_Page selectShipment(String shipmentType,String value)
	{
		if(getCommand().isTargetPresent(list_shipmentType))
		{
			log("Select shippment type::"+shipmentType,LogType.STEP);	
			getCommand().click(list_shipmentType);
			Select st=new Select(getCommand().getDriver().findElement(By.id("shipmentType")));
			st.selectByValue(value);
			if (Arrays.asList("*firefox","*iexplore").contains(TestProperties.getProperties("test.browser")))
			{
			st.selectByVisibleText(shipmentType);
			WebElement wedateWidget = getCommand().getDriver().findElement(By.id("shipmentType"));  
			
			wedateWidget.sendKeys(Keys.ENTER);
			}

			getCommand().waitFor(5);
		}
		return this;
	}
	public Esysco_IFG_Page selectContainersizeOrType(String size,String type)
	{
		getCommand().waitForTargetPresent(div_createNewOrderDiv);
		if(getCommand().isTargetPresent(div_createNewOrderDiv))
		{
		if(getCommand().isTargetPresent(list_containerSize)){
			log("Select Container Size",LogType.STEP);	
			getCommand().click(list_containerSize);
			Select st=new Select(getCommand().getDriver().findElement(By.id("containerSize")));
			st.selectByValue(size);
			if (Arrays.asList("*firefox","*iexplore").contains(TestProperties.getProperties("test.browser")))
			{
			//	st.selectByVisibleText(size);
			WebElement wedateWidget = getCommand().getDriver().findElement(By.id("containerSize"));  
			wedateWidget.sendKeys(Keys.ENTER);
			}
			
			
		}
		if(getCommand().isTargetPresent(list_containerType)){
			log("Select Container Type",LogType.STEP);	
			getCommand().click(list_containerType);
			
			Select st=new Select(getCommand().getDriver().findElement(By.id("containerType")));
			st.selectByValue(type);
			if (Arrays.asList("*firefox","*iexplore").contains(TestProperties.getProperties("test.browser")))
			{
			//	st.selectByVisibleText(type);
			WebElement wedateWidget = getCommand().getDriver().findElement(By.id("containerType"));  
			wedateWidget.sendKeys(Keys.ENTER);
			}
			
		}
		}
		else
		{
			SoftAssertion.fail("Div is not Occur");
		}
		return this;
	}
	public Esysco_IFG_Page createOrder()
	{
		if(getCommand().isTargetPresent(btn_Order))
		{
			log("Create Order ",LogType.STEP);	
			getCommand().click(btn_Order);
		}
		getCommand().waitFor(10);
		//(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='crtordbtndiv']/div"));
		return this;
	}
	public Esysco_IFG_Page clickonActiveOrder()
	{
		getCommand().waitFor(3);
		getCommand().waitForTargetPresent(lnk_activeOrder);
		if(getCommand().isTargetPresent(lnk_activeOrder))
		{
			log("Select Active Order ",LogType.STEP);	
			getCommand().click(lnk_activeOrder);
		}
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
        
		String containerNum=getCommand().getDriver().findElement(ByXPath.xpath("//*[@id='containerEnabledDisplay_referenceContainerID']/span[2]")).getText();
		String shippmentNum=getCommand().getDriver().findElement(ByXPath.xpath("//*[@id='containerEnabledDisplay_referenceShipmentID']/span[2]")).getText();
       log("Unique Container Number ::"+containerNum,LogType.STEP);
       log("Unique Shippment Number ::"+shippmentNum,LogType.STEP);
       
      
		return this;
	}
	public Esysco_IFG_Page validateContainersizeOrType()
	{
		if(getCommand().isTargetPresent(list_containerSize)){
			log("Select Container Size",LogType.STEP);	
			//getCommand().click(list_containerSize);
			Select dropdown = new Select(getCommand().getDriver().findElement(By.xpath("//*[@id='containerSize']")));
			Select dropdownType = new Select(getCommand().getDriver().findElement(By.xpath("//*[@id='containerType']")));
		   String[] valToBeSelected={"48HC'","53HC'"};
		   String[] typeToBeSelected={"DRY","REFRIGERATED","FROZEN","NOR","MULTI-TEMP"};
		   System.out.println(valToBeSelected.length);
		   int length=valToBeSelected.length;
		   int typeLen=typeToBeSelected.length;
		   List<WebElement> options=dropdown.getOptions();
		   List<WebElement> optionsType=dropdownType.getOptions();
		  System.out.println("option Len=="+options.size());
		  System.out.println("option Type Len=="+optionsType.size());
		  log("Container size option should have the below values:",LogType.STEP);

		// System.out.println(dropdown.get);
			//for (WebElement option : options) {
				for (int len=0;len<length;len++){
					
					
				//if (valToBeSelected[len].equalsIgnoreCase(option.get(1).toString())){
					
					WebElement opt=options.get(len);
					
					System.out.println("val===="+opt.getText());
					System.out.println("valToBeSelected[len]==="+valToBeSelected[len]);
					log("Values::"+valToBeSelected[len],LogType.STEP);
					if (valToBeSelected[len].toString().equals(opt.getText().toString())){
						System.out.println("Combo val==="+valToBeSelected[len]);
						 log("Verified the Container size option ",LogType.STEP);
					}
					else
					{
						 log("Container size option verification failed due to order change:",LogType.STEP);	
					}
				//System.out.println("Combo val==="+option.getText());	
				//}
				}
			//}
			log("Container Type option should have the below values:",LogType.STEP);
				//for (WebElement optionstype : optionsType) {
					for (int len=0;len<typeLen;len++){
						
						
					//if (valToBeSelected[len].equalsIgnoreCase(option.get(1).toString())){
						
						WebElement opt=optionsType.get(len);
						
						System.out.println("val===="+opt.getText());
						System.out.println("valToBeSelected[len]==="+typeToBeSelected[len]);
						log("Values::"+typeToBeSelected[len],LogType.STEP);
						if (typeToBeSelected[len].toString().equals(opt.getText().toString())){
							System.out.println("Combo val==="+typeToBeSelected[len]);
							 log("Verified the Container Type option ",LogType.STEP);
						}
						else
						{
							 log("Container Type option verification failed due to order change:",LogType.STEP);	
						}
					//System.out.println("Combo val==="+option.getText());	
					//}
					}
			   // } 
		}
		
		/*if(getCommand().isTargetPresent(list_containerType)){
			log("Select Container Type",LogType.STEP);	
			getCommand().click(list_containerType);
			//getCommand().selectDropDown(list_containerType, type);
		}*/
		
		return this;
	}
	public Esysco_IFG_Page validateContainersizeOrType_OCEANLCL ()
	{
		if(getCommand().isTargetPresent(list_containerSize)){
			log("Select Container Size",LogType.STEP);	
		//	getCommand().click(list_containerSize);
			Select dropdown = new Select(getCommand().getDriver().findElement(By.xpath("//*[@id='containerSize']")));
			List<WebElement> options=dropdown.getOptions();
		   System.out.println("option Len=="+options.size());
		   log("Container size option should have the below values:",LogType.STEP);
            int length =options.size();
            for (int len=0;len<length;len++){
				
				
				//if (valToBeSelected[len].equalsIgnoreCase(option.get(1).toString())){
					
					WebElement opt=options.get(len);
					
					System.out.println("val===="+opt.getText());
            
            String st=opt.getText().toString();
            log("Values::"+st,LogType.STEP);
            if(st.compareTo("NA")==0)
            {
            	log("Verified the Container size option ",LogType.STEP);	
            }
            else
            {
            	log("Failed the Verification of  the Container size option ",LogType.STEP);	
            }
		   
		}
		
		
		}
		return this;
	}
	public Esysco_IFG_Page validateContainersizeOrType_OCEANFCL ()
	{
		if(getCommand().isTargetPresent(list_containerSize)){
			log("Select Container Size",LogType.STEP);	
			//getCommand().click(list_containerSize);
			Select dropdown = new Select(getCommand().getDriver().findElement(By.xpath("//*[@id='containerSize']")));
			
		   String[] valToBeSelected={"20'","40'","40' Overweight","40HC'","45HC'","48HC'","53HC'"};
		  
		   System.out.println(valToBeSelected.length);
		   int length=valToBeSelected.length;
		   List<WebElement> options=dropdown.getOptions();
		   System.out.println("option Len=="+options.size());
		   log("Container size option should have the below values:",LogType.STEP);

		// System.out.println(dropdown.get);
			//for (WebElement option : options) {
				for (int len=0;len<length;len++){
					
					
				//if (valToBeSelected[len].equalsIgnoreCase(option.get(1).toString())){
					
					WebElement opt=options.get(len);
					
					System.out.println("val===="+opt.getText());
					System.out.println("valToBeSelected[len]==="+valToBeSelected[len]);
					log("Values::"+valToBeSelected[len],LogType.STEP);
					if (valToBeSelected[len].toString().equals(opt.getText().toString())){
						System.out.println("Combo val==="+valToBeSelected[len]);
						 log("Verified the Container size option ",LogType.STEP);
					}
					else
					{
						 log("Container size option verification failed due to order change:",LogType.STEP);	
					}
				//System.out.println("Combo val==="+option.getText());	
				//}
				}
			//}

		}
		
		/*if(getCommand().isTargetPresent(list_containerType)){
			log("Select Container Type",LogType.STEP);	
			getCommand().click(list_containerType);
			//getCommand().selectDropDown(list_containerType, type);
		}*/
		
		return this;
	}
	
	public Esysco_IFG_Page selectCustomer(String strCustomer)
	{
		getCommand().waitFor(5);
		getCommand().getDriver().switchTo().frame("botFrame");
		//String selectCust="//*[contains(text(),'" + strCustomer + "')]";
		if(getCommand().isTargetVisible(btn_SearchCust))
		{
		log("Enter Customer in Search : " + strCustomer ,LogType.STEP);	
		getCommand().sendKeys(txt_SearchCust, strCustomer);
		
		log("Click  on Search Customer button" ,LogType.STEP);	
		getCommand().click(btn_SearchCust);
		getCommand().waitFor(3);
		getCommand().getDriver().switchTo().frame("botFrame");
			if(getCommand().isTargetVisible(lnk_Customer.replace("<#>",strCustomer)))
			{
			log("Select Customer Link " ,LogType.STEP);	
			getCommand().click(lnk_Customer.replace("<#>",strCustomer));
			}
		}
		return this;
	}
	public Esysco_IFG_Page verifySMXOnly()
	{
		getCommand().waitFor(3);
		getCommand().getDriver().switchTo().frame("botFrame");
		
		if(getCommand().isTargetVisible(lnk_newUser))
		{
		log("Create New User " ,LogType.STEP);	
		getCommand().click(lnk_newUser);
		}
		getCommand().waitFor(2);
		getCommand().getDriver().switchTo().frame("botFrame");
		String UserName = RandomStringUtils.randomAlphabetic(10);
		getCommand().waitForTargetVisible(userID);
		List<WebElement> element =  getCommand().getDriver().findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("Count:"+element.size());
		log("Verify no of options in Order Management Program Enabled" ,LogType.STEP);	
		if(element.size()!=1){
			SoftAssertion.fail("There are more than one option in Order Management Program Enabled");
		}else{
			log("Only one option for Order Management Program Enabled as expected" ,LogType.STEP);
			log("Verify if option Sysco Market Express is available" ,LogType.STEP);
			if(getCommand().getText(chk_SMX).contains("Sysco Market Express")){
				log("Option Sysco Market Express displayed successfully" ,LogType.STEP);
			}
		}
		return this;
	}
	
	public Esysco_IFG_Page validateMsgSelected_MULTI_TEMP()
	{
		
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(alert_div);
		if(getCommand().isTargetPresent(alert_div))
		{
			log("Pop Up is occur" ,LogType.STEP);
			log("Click on Accept " ,LogType.STEP);	
			getCommand().getDriver().findElement(By.xpath("(//input[@type='checkbox'])[48]")).click();
		}
		else
		{
			SoftAssertion.fail("Pop up is not comming");
		}
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='crtordbtndiv']/div"));
		return this;
		
	}
	public Esysco_IFG_Page validateMsgSelected_MULTI_TEMP2()
	{
		
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(alert_div);
		if(getCommand().isTargetPresent(alert_div))
		{
			log("Pop Up is occur" ,LogType.STEP);
			log("Click on Accept " ,LogType.STEP);	
			getCommand().getDriver().findElement(By.xpath("(//input[@type='checkbox'])[34]")).click();
		}
		else
		{
			SoftAssertion.fail("Pop up is not comming");
		}
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='crtordbtndiv']/div"));
		return this;
		
	}
	public Esysco_IFG_Page validateMsgSelected_MULTI_TEMP_Change()
	{
		
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(alert_div);
		if(getCommand().isTargetPresent(alert_div))
		{
			log("Pop Up is occur" ,LogType.STEP);
			log("Click on Change " ,LogType.STEP);	
			getCommand().getDriver().findElement(By.xpath("(//input[@type='checkbox'])[35]")).click();
		}
		else
		{
			SoftAssertion.fail("Pop up is not comming");
		}
		
		return this;
		
	}
	public Esysco_IFG_Page addItemToOrder(String type)
	{
		
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(add_Item_List);
		if(getCommand().isTargetPresent(add_Item_List))
		{
			getCommand().click(add_Item_List);
			Select st=new Select(getCommand().getDriver().findElement(By.id("addItemToOrder")));
			st.selectByValue(type);
			if (Arrays.asList("*firefox","*iexplore").contains(TestProperties.getProperties("test.browser")))
			{
			st.selectByVisibleText(type);
			WebElement wedateWidget = getCommand().getDriver().findElement(By.id("addItemToOrder"));  
			
			wedateWidget.sendKeys(Keys.ENTER);
			}

			getCommand().waitFor(5);
			/*WebElement webDropDwn = getCommand().getDriver().findElement(By.id("addItemToOrder"));
			Select selDrop= new Select(webDropDwn);
			webDropDwn.click();
			selDrop.selectByValue(type);
			WebElement webDrpDwn = (WebElement)getCommand().getDriver().findElement(By.xpath("//*[@id='addItemToOrder']/option[@value='"+type+"']"));
			//webDrpDwn.sendKeys(Keys.ENTER);
			Actions act=new Actions(getCommand().getDriver());
			act.moveToElement(webDrpDwn);
			act.click();*/
			/*log("Add product from ::"+type,LogType.STEP);	
			getCommand().click(add_Item_List);
		
			Select st=new Select(getCommand().getDriver().findElement(By.id("addItemToOrder")));
			st.selectByValue(type);
			if (Arrays.asList("*firefox","*iexplore").contains(TestProperties.getProperties("test.browser")))
			{
			WebElement wedateWidget = getCommand().getDriver().findElement(By.id("addItemToOrder"));  
			wedateWidget.sendKeys(Keys.ENTER);
			}*/
			
		}
		else
		{
			SoftAssertion.fail("Target is Not visible");
		}
		
		return this;
		
	}
	
	public Esysco_IFG_Page alert_Product_Flag()
	{
		
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(alert_Product);
		if(getCommand().isTargetPresent(alert_Product))
		{
			log("Pop Up is occur" ,LogType.STEP);
			log("Click on Accept " ,LogType.STEP);	
			getCommand().getDriver().findElement(By.xpath("(//input[@type='checkbox'])[47]")).click();	
		}
		else
		{
			SoftAssertion.fail("Target is Not visible");
		}
		
		return this;
		
	}
	public Esysco_IFG_Page alert_Product_Flag_Accept_Change_Displayed()
	{
		
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(alert_Product);
		if(getCommand().isTargetPresent(alert_Product))
		{
			log("Pop Up is occur" ,LogType.STEP);
			
			if(getCommand().getDriver().findElement(By.xpath("(//input[@type='checkbox'])[47]")).isDisplayed())
			{
				log("Add container' check box is Displayed",LogType.STEP);
				
			}
			if(getCommand().getDriver().findElement(By.xpath("(//input[@type='checkbox'])[48]")).isDisplayed())
			{
				log("Change container' check box is Displayed",LogType.STEP);
			}
		}
		else
		{
			SoftAssertion.fail("Target is Not visible");
		}
		
		return this;
		
	}
	public Esysco_IFG_Page alert_Product_Flag_Change()
	{
		
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(alert_Product);
		if(getCommand().isTargetPresent(alert_Product))
		{
			log("Pop Up is occur" ,LogType.STEP);
			log("Click on Change " ,LogType.STEP);	
			getCommand().getDriver().findElement(By.xpath("(//input[@type='checkbox'])[48]")).click();	
		}
		else
		{
			SoftAssertion.fail("Target is Not visible");
		}
		
		return this;
		
	}
	public Esysco_IFG_Page update_containerType()
	{
		
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(alert_ContainerType);
		if(getCommand().isTargetPresent(alert_ContainerType))
		{
			log("Pop Up is occur" ,LogType.STEP);
			log("Click on Update Type " ,LogType.STEP);	
			getCommand().click(update_ContainerType);
		}
		else
		{
			SoftAssertion.fail("Target is Not visible");
		}
		
		return this;
		
	}
	public Esysco_IFG_Page close_containerType()
	{
		
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(close_ContainerType);
		if(getCommand().isTargetPresent(close_ContainerType))
		{
			log("Pop Up is occur" ,LogType.STEP);
			log("Click on Update order " ,LogType.STEP);	
			getCommand().getDriver().findElement(By.xpath("(//input[@id='closeChangeContainerTypeDialogBtn'])[3]")).click();
			//getCommand().click(close_ContainerType);
		}
		else
		{
			SoftAssertion.fail("Target is Not visible");
		}
		
		return this;
		//*[@id='closeChangeContainerTypeDialogBtn']
	}
	public Esysco_IFG_Page close_containerType1()
	{
		
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(close_ContainerType);
		if(getCommand().isTargetPresent(close_ContainerType))
		{
			log("Pop Up is occur" ,LogType.STEP);
			log("Click on Update order " ,LogType.STEP);	
			getCommand().getDriver().findElement(By.xpath("(//input[@id='closeChangeContainerTypeDialogBtn'])")).click();
		}
		else
		{
			SoftAssertion.fail("Target is Not visible");
		}
		
		return this;
		
	}
	public Esysco_IFG_Page changeContainerType(String type)
	{
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(alert_ContainerType);
		if(getCommand().isTargetPresent(alert_ContainerType))
		{
			log("Pop Up is occur" ,LogType.STEP);
			log("Click on Update Type " ,LogType.STEP);	
			
			getCommand().click(change_ContainerType);
			Select st=new Select(getCommand().getDriver().findElement(By.id("containerTypeUpdate")));
			st.selectByValue(type);
			if (Arrays.asList("*firefox","*iexplore").contains(TestProperties.getProperties("test.browser")))
			{
			WebElement wedateWidget = getCommand().getDriver().findElement(By.id("containerTypeUpdate"));  
			wedateWidget.sendKeys(Keys.ENTER);
			}
			
		}
		else
		{
			SoftAssertion.fail("Target is Not visible");
		}
		return this;
	}
	public Esysco_IFG_Page ckeckSubmitButton(String type,String shippment)
	{
		getCommand().waitFor(2);
		log("Validate the order header in the Order details page " ,LogType.STEP);	
		 (new SupportFunctions()).waitForLoading(1000, By.xpath("//*[@id='loadingDiv11']"));
		 if(getCommand().isTargetPresent(get_ContainerType))
		 {
			String conttype= getCommand().getText(get_ContainerType);
			System.out.println("Type===="+type);
			if(type.equals(conttype))
			{
				log("Validate the container Type " +conttype,LogType.STEP);		
			}
		 }
		 if(getCommand().isTargetPresent(get_shipmentType))
		 {
			 String shiptype= getCommand().getText(get_shipmentType);
				System.out.println("Type===="+shippment);
				if(shippment.equals(shiptype))
				{
					log("Validate the Shipment Type " +shiptype,LogType.STEP);		
				}
		 }
		 
		 if(getCommand().isTargetPresent(get_totalCube))
		 {
			 String shiptype= getCommand().getText(get_totalCube);
				System.out.println("Type===="+shiptype);
				log("Validate the Shipment Type " +shiptype,LogType.STEP);		
				
		 }
		 
		 if(getCommand().isTargetPresent(get_totalWeight))
		 {
			 String shiptype= getCommand().getText(get_totalWeight);
				System.out.println("Type===="+shippment);
				
					log("Validate the Shipment Type " +shiptype,LogType.STEP);		
				
		 }
		 
		 return this;
	}
	public Esysco_IFG_Page ckeckStandardUnits() {
		getCommand().waitFor(2);
		String beforeTotalCube="",beforetotalWeight="";;
		
		 if(getCommand().isTargetPresent(get_totalCube))
		 {
			 beforeTotalCube= getCommand().getText(get_totalCube);
				System.out.println("Type===="+beforeTotalCube);
					
				
		 }
		 if(getCommand().isTargetPresent(get_totalWeight))
		 {
			 beforetotalWeight= getCommand().getText(get_totalWeight);
			System.out.println("Type===="+beforetotalWeight);
					
		 }
		 if(getCommand().isTargetPresent(chk_standardUnits))
		 {
			 log("Select standard Units " ,LogType.STEP);		
			 getCommand().click(chk_standardUnits);
			 getCommand().waitFor(2);
			 if(!(beforeTotalCube.equals(getCommand().getText(get_totalCube).toString())))
				{
				 log("Before selecting standard units button.Cube Value="+beforeTotalCube,LogType.STEP);
				 log("After selecting standard units button.Cube Value="+getCommand().getText(get_totalCube).toString(),LogType.STEP);
					log("Cube in order summary page will change on n selecting standard units button",LogType.STEP);
					
				}
			 if(!(beforetotalWeight.equals(getCommand().getText(get_totalWeight).toString())))
				{
				 log("Before selecting standard units button.Cube Value="+beforetotalWeight,LogType.STEP);
				 log("After selecting standard units button.Cube Value="+getCommand().getText(get_totalWeight).toString(),LogType.STEP);
					log("Weight in order summary page will change on n selecting standard units button",LogType.STEP);
					
				}
			 
		 }
		return this;
		
	}
	 
	public Esysco_IFG_Page Checktihi_ShelLife()
	{
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(tihi_label);
		getCommand().waitForTargetPresent(shelLife_label);
		if(getCommand().isTargetPresent(tihi_label))
		{
			if(getCommand().isTargetVisible(tihi_label))
			{
			log("Ti* Hi values are captured " ,LogType.STEP);
			}
			else
			{
				log("Ti* Hi values are Not occur " ,LogType.STEP);
			}
		}
		
		if(getCommand().isTargetPresent(shelLife_label))
		{
			log("Shelf life  values are captured " ,LogType.STEP);
		}
		return this;
	}
	public Esysco_IFG_Page clickOn_ColumnSettings()
	{
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(label_ColmnSettings);
		
		if(getCommand().isTargetPresent(label_ColmnSettings))
		{
			
			log("Click On Column settings " ,LogType.STEP);
			getCommand().click(label_ColmnSettings);
		}
		
		
		return this;
	}
	public Esysco_IFG_Page chkDiv_ColmnSettings()
	{
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(div_ColmnSettings);
		
		if(getCommand().isTargetPresent(div_ColmnSettings))
		{
			
			log("column settings Div is Occur " ,LogType.STEP);
		
			if(getCommand().isTargetPresent(TiHi_ColmnSettings))
			{
				log("Remove /Add Ti/Hi " ,LogType.STEP);
			  getCommand().click(TiHi_ColmnSettings);
			}
			getCommand().waitFor(3);
			getCommand().click(lnk_Ok);
			
		}
		getCommand().waitFor(3);
		
		return this;
	}
	public Esysco_IFG_Page shippmentTab() {
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(tab_Shipment);
		if(getCommand().isTargetPresent(tab_Shipment)){
			
			log("Shipment Tab is present " ,LogType.STEP);
		}
		else
		{
			SoftAssertion.fail("Shipment tab is not Present");
		}
		return this;
	}
	
	public Esysco_IFG_Page clickOnshippmentTab() {
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(tab_Shipment);
		if(getCommand().isTargetPresent(tab_Shipment)){
			log("Click on Shipment Tab " ,LogType.STEP);
			getCommand().click(tab_Shipment);
		}
		else
		{
			SoftAssertion.fail("Shipment tab is not Present");
		}
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		return this;
	}
	
	public Esysco_IFG_Page validatePlus_minus() {
		getCommand().waitFor(2);
		String plus="/descendant::span[contains(@class,'plus')][1]";
		String minus="/descendant::span[contains(@class,'minus')]";
		if(getCommand().isTargetPresent(plusMinus_bttn.replace("<#>", plus))){
			log("Click on + button " ,LogType.STEP);
			getCommand().click(plusMinus_bttn.replace("<#>", plus));
			getCommand().waitFor(2);
			if(getCommand().isTargetPresent(plusMinus_bttn.replace("<#>", minus))){
				log("Click on _ button " ,LogType.STEP);
				getCommand().click(plusMinus_bttn.replace("<#>", minus));
				
			}
		
		}
		else
		{
			SoftAssertion.fail("Plus button not present");
		}
		
		return this;
	}
	public Esysco_IFG_Page CheckActiveOrder_green() {
		getCommand().waitFor(2);
		String weight="//*[@id='weightPercentlink'][contains(@style,'green')]";
		String cube="//*[@id='cubePercentlink'][contains(@style,'green')]";
	
		if(getCommand().isTargetPresent(weight_Label.replace("<#>", weight))){
			
			
			if(getCommand().isTargetPresent(cube_Label.replace("<#>", cube))){
				log("Total weight and total cube should be displayed in the active order section " ,LogType.STEP);
				log("Total dollar spent will not be displayed in the active order section " ,LogType.STEP);
				log("The text font color of total cube and total Weight value alone in is green",LogType.STEP);
				
				
			}
		
		}
		else
		{
			SoftAssertion.fail("Total weight and total cube should not be displayed in the active order section ");
		}
		
		return this;
	}
	
	public Esysco_IFG_Page CheckActiveOrder_red() {
		getCommand().waitFor(2);
		String weight="//*[@id='weightPercentlink'][contains(@style,'red')]";
		String cube="//*[@id='cubePercentlink'][contains(@style,'green')]";
		
		//if(getCommand().isTargetPresent(weight_Label.replace("<#>", weight))){
			
			
			if(getCommand().isTargetPresent(weight_Label.replace("<#>", weight))){
				log("Total weight and total cube should be displayed in the active order section " ,LogType.STEP);
				log("The text font color of total weight value alone in is red",LogType.STEP);

		}
		else
		{
			SoftAssertion.fail("Total weight is not changed to red color as expected ");
		}
		
			if(getCommand().isTargetPresent(cube_Label.replace("<#>", cube))){
				//log("Total weight and total cube should be displayed in the active order section " ,LogType.STEP);
				log("The text font color of total cube value alone in is green",LogType.STEP);
			}
			else
			{
				SoftAssertion.fail("Total cube value is not in green color ");
			}
				
			
		return this;
	}
	public Esysco_IFG_Page updateDeliveryCalander(String customerNum){
		String flag= (new SupportFunctions().updateData("update ESCMSNTF set SNDSDL = '0000000' WHERE trim(SNCUNO)='"+customerNum+"'"));
		if(flag.compareTo("True")==0)
		{
			System.out.println("UPDATION SUCCESS");
		}
		else
		{
			SoftAssertion.fail("Updation is not valid. Please re execute.");
		}
		return this;
		
		
	}
	public Esysco_IFG_Page custSetUpDay(String days) {
		getCommand().waitFor(3);
		getCommand().getDriver().switchTo().frame("botFrame");
		log("Customer Level setup",LogType.STEP);
		log("Orders can be created 10 days in advance",LogType.STEP);
		
		getCommand().getDriver().findElement(By.name("daysInAdvance")).sendKeys(days);
		log("Click on Save",LogType.STEP);
		getCommand().getDriver().findElement(By.name("Submit")).click();
		log("Accept the Alert message",LogType.STEP);
		Alert alert =getCommand().getDriver().switchTo().alert();
		alert.accept();
		getCommand().waitFor(2);
		return this;	
	}
	public Esysco_IFG_Page iteminsearchbox1( String enteritemnum, String quantity ) throws AWTException {
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		
		getCommand().isTargetPresent(txt_Search);
		log("Enter itemname " + enteritemnum,LogType.STEP);
		//Robot rb=new Robot();
		//rb.keyPress(KeyEvent.VK_BACK_SPACE);
		//rb.keyRelease(KeyEvent.VK_BACK_SPACE);
		log("Enter itemname " + enteritemnum,LogType.STEP);
		//getCommand().sendKeys(txt_Search, enteritemnum);
		getCommand().clear(txt_Search).sendKeys(txt_Search, enteritemnum);
		//getCommand().sendKeys(txt_Search, enteritemnum);
		getCommand().click(btn_search);
		getCommand().waitFor(5);
		getCommand().waitForTargetPresent(txt_Quantity.replace("<#>", enteritemnum));
		if(getCommand().isTargetPresent(txt_Quantity.replace("<#>", enteritemnum)));
		getCommand().sendKeys(txt_Quantity.replace("<#>",enteritemnum),quantity);
		Robot rb =new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		//rb.keyPress(KeyEvent.v);
		rb.keyRelease(KeyEvent.VK_TAB);
		getCommand().waitFor(6);
	return this;
	}
	public Esysco_IFG_Page ICTClose()
	
	{
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(alert_Product);
		if(getCommand().isTargetPresent(alert_Product))
		{
			getCommand().click(alertclose);
		}
		
		return this;	
	}
	
	public Esysco_IFG_Page addcont()
	
	{
		getCommand().isTargetPresent(add_con);
		{
			getCommand().click(add_con);
			getCommand().waitForTargetPresent(div_createNewOrderDiv);
			if(getCommand().isTargetPresent(div_createNewOrderDiv));
			{
				{
					log("Start new shipment pop up should be displayed",LogType.STEP);	
					}
			}
		}
		return this;
	}
	
	public Esysco_IFG_Page MultiTempAccept()
	{
		getCommand().isTargetPresent(MT_accpt);
		{
			getCommand().click(MT_accpt);
		}
		return this;
		
	}
	public  Esysco_IFG_Page clickOnViewOrder(){
		(new SupportFunctions()).waitForLoading(1000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(btn_ViewOrder);
		if(getCommand().isTargetPresent(btn_ViewOrder)){
            log("Click view Order Button",LogType.STEP);	
			getCommand().click(btn_ViewOrder);
		}
		(new SupportFunctions()).waitForLoading(1000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		return this;
		
	}
	public Esysco_IFG_Page alert_Product_Flag_Change1()
{
		
		getCommand().waitFor(5);
		getCommand().getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//getCommand().getDriver().switchTo().alert();
		
		if(getCommand().getDriver().findElements(By.xpath("//*[@id='alertProductFlagDialog' and @title='Incorrect Container Type']")).size()!=0)
		{
			log("Incorrect Container Type Pop Up is occur" ,LogType.STEP);
			getCommand().getDriver().findElement(By.xpath("(//input[@type='checkbox'])[49]")).click();	
			
		}
		else
		{
			SoftAssertion.fail("Incorrect Container Type is Not visible");
		}
		return this;
	}
	public Esysco_IFG_Page alert_Product_Flag_Change2()
	{
			
			getCommand().waitFor(5);
			getCommand().getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//getCommand().getDriver().switchTo().alert();
			
			if(getCommand().getDriver().findElements(By.xpath("//*[@id='alertProductFlagDialog' and @title='Incorrect Container Type']")).size()!=0)
			{
				log("Incorrect Container Type Pop Up is occur" ,LogType.STEP);
				getCommand().getDriver().findElement(By.xpath("(//input[@type='checkbox'])[48]")).click();	
				
			}
			else
			{
				SoftAssertion.fail("Incorrect Container Type is Not visible");
			}
			return this;
		}
	public Esysco_IFG_Page validateMsgSelected_MULTI_TEMP1()
	{
		
		getCommand().waitFor(5);
		getCommand().getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//getCommand().getDriver().switchTo().alert();
		
		if(getCommand().getDriver().findElements(By.xpath("//*[@id='alertTestDiv']' and @title='Confirm Container Type']")).size()!=0)
		{
			log("Confirm Container Type Pop Up is occur" ,LogType.STEP);
			getCommand().getDriver().findElement(By.xpath("(//input[@type='checkbox'])[48]")).click();	
			
		}
		else
		{
			SoftAssertion.fail("Confirm Container Type Pop Up type is Not visible");
		}
		
		return this;
	}
	public Esysco_IFG_Page validateContainersizeOrType1(String containerSize ,String value)
	{
		getCommand().waitFor(2);
		Select cz=new Select(getCommand().getDriver().findElement(By.id("containerSize")));
		cz.selectByValue(value);
		{
			log("48 HC size is present as expected",LogType.STEP);
		}
		
		return this;
	}
public Esysco_IFG_Page deleteorder()
	
	{
		if(getCommand().isTargetPresent(delete_order))
		{
			getCommand().click(delete_order);
			getCommand().waitForTargetPresent(delete_orderpopup);
			
			getCommand().click(delete_orderpopup);
			getCommand().waitForTargetPresent(delete_orderyes);
			getCommand().click(delete_orderyes);
			
		}
		
		return this;
	}
public Esysco_IFG_Page deleteorder1()

{
	if(getCommand().isTargetPresent(delete_order1))
	{
		getCommand().click(delete_order1);
		getCommand().waitForTargetPresent(delete_orderpopup);
		
		getCommand().click(delete_orderpopup);
		getCommand().waitForTargetPresent(delete_orderyes);
		getCommand().click(delete_orderyes);
		
	}
	
	return this;
}

public  Esysco_IFG_Page enterOrderName(String strOrderName){		
	if(getCommand().isTargetPresent(txt_OrderName)){
		log("Enter Order Name " + strOrderName,LogType.STEP);	
		getCommand().clear(txt_OrderName);
		getCommand().sendKeys(txt_OrderName, strOrderName);
	}
	return this;
}
public  Esysco_IFG_Page containerundercapacity()
{
	if(getCommand().isTargetPresent(cnt_under_cap))
	{
		log("container under capacity pop up is displayed " ,LogType.STEP);
	}
	getCommand().click(cnt_under_ca_accept);
	
return this;

}


}
