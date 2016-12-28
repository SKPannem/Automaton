/**
 ********************************************************************************************************************************************
 ********************************************************************************************************************************************
 *																																		   	*
 * 2011-2012 Infosys Limited, Banglore, India. All Rights Reserved																			*
 * Version: 2.0																																*
 * 																																			*
 * Except for any free or open source software components embedded in this Infosys proprietary software program ("Program"),				*
 * this Program is protected by copyright laws, international treaties and other pending or existing intellectual property rights in India, *
 * the United States and other countries. Except as expressly permitted, any unautorized reproduction, storage, transmission 				*
 * in any form or by any means (including without limitation electronic, mechanical, printing, photocopying, recording or otherwise), 		*
 * or any distribution of this Program, or any portion of it, may result in severe civil and criminal penalties, 							*
 * and will be prosecuted to the maximum extent possible under the law 																		*
 *																																			*
 ********************************************************************************************************************************************
 ********************************************************************************************************************************************
 **/
package com.components.pages;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.components.repository.SiteRepository;
import com.iwaf.framework.TestProperties;
import com.iwaf.framework.components.SoftAssertion;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;


public class HomePage extends SitePage{

	public static final Target btn_Express = new Target("btn_Express","//*[@id='syscoMarketExpress']",Target.XPATH);
	//public static final Target btn_ESysco = new Target("btn_ESysco","//*[@id='esysco']",Target.XPATH);
	public static final Target btn_ESyscostartnewOrder = new Target("btn_ESyscostartnewOrder","//input[@value='Start New Order']",Target.XPATH);
	public static final Target lnk_Logout = new Target("lnk_Logout","//a[@class='headlink'][contains(@href,'Logoff')]",Target.XPATH);
	public static final Target logo_Express = new Target("logo_Express","//*[@id='tp1']/a/img",Target.XPATH);
	public static final Target lst_OpCo = new Target("lst_OpCo","//*[@id='opCo_id']",Target.XPATH);
	public static final Target txt_Customer = new Target("txt_Customer","//*[@id='shipToSelectedSearch']",Target.XPATH);
	public static final Target cont_Location = new Target("cont_Location","//*[@id='locations-container']//p[contains(text(),'Account #: <#>')]",Target.XPATH);
	public static final Target sidebar_AccountSummary = new Target("sidebar_AccountSummary","//*[@id='left-sidebarcrashlink']",Target.XPATH);
	//public static final Target btn_StartNewOrder = new Target("btn_StartNewOrder","//*[@id='createNewOrderButton']",Target.XPATH);
	public static final Target btn_StartNewOrder = new Target("btn_StartNewOrder","//*[@class='crtordbtn basic']",Target.XPATH);
	public static final Target tab_OrderPage=new Target("tab_OrderPage","//*[@id='orderTab']",Target.XPATH);
	public static final Target txt_search=new Target("txt_search","//*[@id='txtSearch']",Target.XPATH);
	public static final Target btn_search=new Target("btn_search","//*[@id='btnSearch']",Target.XPATH);
	public static final Target id_submittedOrder=new Target("id_submittedOrder","//*[@id='122321']",Target.XPATH);
	public static final Target btn_OrderDetails=new Target("btn_OrderDetails","//*[@id='actord']/span[1]/a",Target.XPATH);
	public static final Target btn_Modify=new Target("btn_Modify","//*[@id='modifyOrderButTop']",Target.XPATH);
	public static final Target btn_AcceptedAlert=new Target("btn_AcceptedAlert","//*[@id='modifyOrder']",Target.XPATH);
	public static final Target btn_Ok=new Target("btn_Ok","html/body/div[42]/div[11]/div/button",Target.XPATH);
	public static final Target btn_OrderedItem=new Target("btn_OrderedItem","//*[@id='<#>']/td[19]",Target.XPATH);
	public static final Target btn_ConformModifyOrder=new Target("btn_ConformModifyOrder","//*[@id='modifyOrder' and @value='Yes']",Target.XPATH);
	public static final Target btn_QuickOrderEntry=new Target("btn_QuickOrderEntry","//input[@id='quickOrderButtonPopup']",Target.XPATH);
	public static final Target btn_SubmittedOrderLink=new Target("btn_SubmittedOrderLink","//a[@id='osSubmittedorders']",Target.XPATH);
	public static final Target btn_ModifySubmittedOrder=new Target("btn_ModifySubmittedOrder","//input[@id='modifyBttnTopBttn']",Target.XPATH);
	public static final Target btn_GoToList=new Target("btn_GoToList","//*[@id='golistbtn']",Target.XPATH);
	public static final Target btn_GoToOrderGuide=new Target("btn_GoToOrderGuide","//input[@id='goitmhisbtn']",Target.XPATH);
	public static final Target btn_CancellededOrderLink=new Target("btn_CancellededOrderLink","//a[@id='osRecentlyplacedorders']",Target.XPATH);
	public static final Target btn_PendingOrderLink=new Target("btn_PendingOrderLink","//a[@id='osPendingOrders']",Target.XPATH);
	public static final Target btn_Apply=new Target("btn_Apply","//*[@id='orderSummaryReportApplyBtn']",Target.XPATH);
	public static final Target btn_Location=new Target("btn_Location","//*[@id='callout']/ul/li[2]/a",Target.XPATH);
	public static final Target btn_Yes=new Target("btn_Yes","//*[@id='customerSwitchClose']",Target.XPATH);
	public static final Target btn_HomePage=new Target("btn_HomePage","//*[@id='showHomeTab']",Target.XPATH);
	public static final Target btn_ChkAllItems=new Target("btn_ChkAllItems","//*[@id='cb_productSearchGrid']",Target.XPATH);
	public static final Target btn_PrintProduct=new Target("btn_PrintProduct","//*[@id='printClick']",Target.XPATH);
	public static final Target btn_CancelPrintProduct=new Target("btn_CancelPrintProduct","//*[@id='asyncLoadingCancelButton']",Target.XPATH);
	public static final Target btn_OpenOrderLink=new Target("btn_OpenOrder","//a[@id='osOpenorders']",Target.XPATH);
	//public static final Target txt_EsyscoOrderName=new Target("txt_EsyscoOrderName","//input[@name='ORDER_DESCRIPTION']",Target.XPATH);
	public static final Target btn_ESysco = new Target("btn_ESysco","//*[@id='esysco']",Target.XPATH);
	public static final Target btn_Update=new Target("btn_Update","//*[@id='buttonUpdate']",Target.XPATH);
	//Create New User
	public static final Target lnk_newUser=new Target("lnk_newUser","//*[contains(text(),'Create New User')]",Target.XPATH);
	public static final Target userID=new Target("userID","USERID",Target.NAME);
	public static final Target contactName=new Target("contactName","ContactName",Target.NAME);
	public static final Target contactPhone=new Target("contactPhone","ContactPhone",Target.NAME);
	public static final Target chk_containerEnabled=new Target("chk_containerEnabled","containerEnabled",Target.NAME);
	public static final Target btn_Save=new Target("btn_Save","SUBMIT",Target.NAME);

	public static final Target link_Logout = new Target("lnk_Logout","//a[@class='headlink'][contains(@href,'Logoff')]",Target.XPATH);
	public static final Target link_OrderName=new Target("link_OrderName","//a[@id='<#>']",Target.XPATH);
	public static final Target link_Product=new Target("link_Product","//*[@id='<#>-CS_productName']",Target.XPATH);
	public static final Target link_DeleteItem=new Target("link_DeleteItemt","//a[@id='undefined']",Target.XPATH);
	public static final Target link_SUPC=new Target("link_SUPC","//*[@id='<#>-CS_supc']",Target.XPATH);


	public static final Target txt_Search=new Target("txt_Search","//*[@id='txtSearch']",Target.XPATH);
	public static final Target txt_Quantity=new Target("txt_Quantity","//*[@id='<#>-CS_syscoGridColumnEditableQuantityFormatter']",Target.XPATH);
	public static final Target txt_QuantityInProductInfo=new Target("txt_QuantityInProductInfo","//input[@type='text']",Target.XPATH);
	public static final Target txt_TotalPrice=new Target("txt_TotalPrice","//span[@class='modper']",Target.XPATH);
	public static final Target txt_StatusPendingOrder=new Target("txt_StatusPendingOrder","//*[@id='<#>']/td[18]",Target.XPATH);
	public static final Target txt_TotalItemPrice=new Target("txt_TotalItemPrice","//*[@id='<#>-CS']/td[24]",Target.XPATH);
	public static final Target txt_SUPCNumber=new Target("txt_SUPCNumber","//*[@id='<#>-CS']/td[19]",Target.XPATH);
	public static final Target txt_TotalQunatity=new Target("txt_TotalQunatity","//*[@id='totOrderQtyValue']",Target.XPATH);
	public static final Target txt_ChangeQuantity=new Target("txt_ChangeQuantity","//*[contains(@id,'CS_syscoGridColumnEditableQuantityFormatter')]",Target.XPATH);
	public static final Target txt_EsyscoOrderName=new Target("txt_EsyscoOrderName","//input[@name='ORDER_DESCRIPTION']",Target.XPATH);

	public static final Target chk_OrderSubmittedOption=new Target("chk_OrderSubmittedOption","//*[@id='sumbmittdOption']",Target.XPATH);
	public static final Target chk_DeliveryDateOption=new Target("chk_DeliveryDateOption","//*[@id='deliveryOption']",Target.XPATH);

	public static final Target lastModifiedBy=new Target("lastModifiedBy","//*[@id='blk1']/span[4]/span[1]",Target.XPATH);
	public static final Target lastModifiedByUser=new Target("lastModifiedByUser","//*[@id='blk1']/span[4]/span[2]",Target.XPATH);

	public static final Target tab_Report=new Target("tab_Report","//a[@title='Order Summary Report']",Target.XPATH);
	public static final Target summary_Report=new Target("summary_Report","//*[@id='order-summary-report-table']",Target.XPATH);
	public static final Target summary_ReportMA=new Target("summary_ReportMA","//*[@id='SA-report-div']",Target.XPATH);
	public static final Target box_Search=new Target("box_Search","//*[@id='srchTop']",Target.XPATH);

	public static final Target txt_OutOfStock=new Target("txt_OutOfStock","//img[@title='Click to add a Substitute']",Target.XPATH);
	public static final Target txt_Confirmed=new Target("txt_Confirmed","//*[@id='C']",Target.XPATH);
	public static final Target txt_Cancelled=new Target("txt_Cancelled","//*[@id='R']",Target.XPATH);
	public static final Target close = new Target("close","//*[@id='clsLink']",Target.XPATH);
	public static final Target close1 = new Target("close1","//*[@id='close']",Target.XPATH);
	public static String txt_OrderName="";
	public static String totalPriceFromDB="";
	public static float totalPrice=0;
	public static int totalQuantityActiveOrder=0;
	public static int tQuantityHOrder=0;
	ArrayList<String> itemPrice=new ArrayList<String>();
	ArrayList<String> itemQuantity=new ArrayList<String>();
	ArrayList<String> upcNumber=new ArrayList<String>();
	ArrayList<String> totalPrice_Item=new ArrayList<String>();
	public static final Target msg_HomePage =new Target("msg_HomePage","//*[@id='messagehome']",Target.XPATH);
	public static final Target menu_MenuAnalysis =new Target("menu_MenuAnalysis","//*[@id='menuAnalysisLabel']",Target.XPATH);
	public static final Target date_deliveryDate=new Target ("date_deliverydDate","//*[@type='radio' and @id='deliveryOption']",Target.XPATH);
	public static final Target popup_datePicker= new Target("popup_datePicker","//*[@id='ui-datepicker-div']",Target.XPATH);
	public static final Target popup_NextMon= new Target("popup_NextMon","//*[@id='ui-datepicker-div']/div/a[2]/span",Target.XPATH);
	public static final Target btn_summaryReport= new Target("btn_summaryReport","//*[@id='orderSummaryReportApplyBtn']",Target.XPATH);
	public static final Target btn_resetReport= new Target("btn_resetReport","//*[@id='orderSummaryReportRestBtn']",Target.XPATH);
	public static final Target date_submittedDate=new Target ("date_submittedDate","*[@type='radio' and @id='submittdOption']",Target.XPATH);
	public static final Target popup_PrevMon= new Target("popup_PrevMon","//*[@id='ui-datepicker-div']/div/a[1]/span",Target.XPATH);

	public static final Target enterQty=new Target("enterQty","//*[@id='1024231-CS_syscoGridColumnEditableQuantityFormatter']",Target.XPATH);public static final Target txt_CustomerOrder=new Target("txt_CustomerOrder","//*[@id='wrapToggle-<#>']",Target.XPATH);
	//public static final Target enterQty1=new Target("enterQty1","//*[@id='4045415-CS_syscoGridColumnEditableQuantityFormatter']",Target.XPATH);
	public static final Target enterQty1=new Target("enterQty1","//*[@id='<#>-CS_syscoGridColumnEditableQuantityFormatter']",Target.XPATH);
	//public static final Target currentprice1=new Target("currentprice1","//*[@id='4045415-CS_currentprice']",Target.XPATH);
	//public static final Target currentprice2=new Target("currentprice2","//*[@id='4045415-CS_currentprice']",Target.XPATH);
	public static final Target currentprice1=new Target("currentprice1","//*[@id='<#>-CS_currentprice']",Target.XPATH);
	public static final Target currentprice2=new Target("currentprice2","//*[@id='<#>-CS_currentprice']",Target.XPATH);

	public static final Target btn_CheckOnItem1=new Target("btn_CheckOnItem","//*[@id='jqg_productSearchGrid_4045415-CS']",Target.XPATH);
	public static final Target cust_search=new Target("cust_search","//*[@id='shipToSelectedSearch']",Target.XPATH);
	//public static final Target cust_select=new Target("cust_select","//*[@id='locations-container']/ul/li",Target.XPATH);
	public static final Target cust_select=new Target("cust_select","//*[@id='locations-container']/ul/li[@onclick=\"switchCustomer('108761')\"]",Target.XPATH);
	
	public static final Target lst_chcbx = new Target("lst_chcbx","//*[@id='cb_productSearchGrid']",Target.XPATH);
	public static final Target add_list = new Target("add_list","//*[@id='addToListBtn']",Target.XPATH);
	public static final Target lst_num1 = new Target("lst_num1","//*[@id='<#>']",Target.XPATH);
	public static final Target cnfrm_lst = new Target("cnfrm_lst","//*[@id='multiSelectConfirmButton']",Target.XPATH);
	public static final Target nationalcore1 = new Target("nationalcore1","//*[@id='1497999-CS_productName']",Target.XPATH);
	public static final Target nationalcore = new Target("nationalcore","<#>",Target.ID);

	public static final Target reportsma= new Target("reportsma","//*[@id='mnnav']/ul/li[11]/a",Target.XPATH);
	public static final Target osrma = new Target("osrma","//*[@id='orderSummaryReportLink2']",Target.XPATH);

	public static final Target materritory= new Target("materritory","//*[@id='territory-SQ']/a",Target.XPATH);
	public static final Target changePassword= new Target("changePassword","html/body/table[1]/tbody/tr[1]/td[2]/table/tbody/tr/td[6]/a",Target.XPATH);
	/*
	 * Silver search changes
	 */
	public static final Target link_UPCImage=new Target("link_UPCImage","<#>",Target.XPATH);
	
	public static final Target link_UPCImageClose=new Target("link_UPCImageClose","//a[contains(@class,'lb-close')]",Target.XPATH);
	
	public static final Target link_productImage=new Target("link_productImage","//*[@id='productImage']",Target.XPATH);
	
	public static final Target img_linkNext=new Target("img_linkNext","//*[contains(@class,'ca-nav-next')]",Target.XPATH);
	
	public static final Target img_linkPrev=new Target("img_linkPrev","//*[contains(@class,'ca-nav-prev')]",Target.XPATH);
	
	public static final Target link_NoImage=new Target("link_NoImage","<#>",Target.XPATH);
	public HomePage(SiteRepository repository){
		super(repository);
	}

	public HomePage atHomePage(){
		log("Launched eSysco Site",LogType.STEP);
		return this;
	}
	public HomePage clickOnHomePageTab(){
		//wait for load pop to be invisible
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		getCommand().getDriver().findElement(By.xpath("//*[@id='showHomeTab']")).click();
		log("Click on Home Tab",LogType.STEP);
		return this;
	}

	public HomePage clickOnExpress(){
		getCommand().waitFor(3);
		(new SupportFunctions()).waitForStatic(3);
		getCommand().getDriver().switchTo().frame("botFrame");
		getCommand().waitForTargetVisible(btn_Express);
		if(getCommand().isTargetPresent(btn_Express)){
			log("Click on Express button",LogType.STEP);
			getCommand().click(btn_Express);
			getCommand().waitFor(5);
		}
		return this;
	}


	/*public HomePage clickOnESysco(){
		getCommand().waitFor(3);
		(new SupportFunctions()).waitForStatic(3);
		getCommand().getDriver().switchTo().frame("botFrame");
		getCommand().waitForTargetVisible(btn_ESysco);
		if(getCommand().isTargetPresent(btn_ESysco)){
			log("Click on Esysco button",LogType.STEP);
			getCommand().click(btn_ESysco);
		}
		return this;
	}*/
	 public HomePage clickOnItemTab(){
			(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			WebDriver driver=getCommand().getDriver();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.switchTo().frame("topFrame");
			log("click on Item tab :",LogType.STEP);
			driver.findElement(By.partialLinkText("a")).click();
			driver.switchTo().defaultContent();
			return this;
		}
	/*public HomePage clickOnEsyscoStartNewOrder(){
		try{
		getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement element = getCommand().getDriver().findElement(By.xpath("//input[@value='Start New Order']"));
		log("Click on esysco start new order",LogType.STEP);
		element.click();
		}catch(NoSuchElementException e){
			System.out.println("Exception 1");
			getCommand().getDriver().switchTo().frame("topFrame");
			WebElement element = getCommand().getDriver().findElement(By.xpath("//input[@value='Start New Order']"));
			log("Click on esysco start new order",LogType.STEP);
			element.click();
		}catch(Exception e){
			System.out.println("Exception 2");
			getCommand().getDriver().switchTo().frame("botFrame");
			WebElement element = getCommand().getDriver().findElement(By.xpath("//input[@value='Start New Order']"));
			log("Click on esysco start new order",LogType.STEP);
			element.click();
		}
		return this;
	}*/
	/*public HomePage enterEsyscoOrderName(String orderName){
		getCommand().waitFor(3);
		System.out.println("Number of windows=="+getCommand().getDriver().getWindowHandles().size());

		Set <String> set = getCommand().getDriver().getWindowHandles();
		  Iterator<String> it = set.iterator();
		  String parentWindowId = it.next();
		  System.out.println("Parent window id=="+parentWindowId);
		  String childWindowId = it.next();
		  System.out.println("Child window id=="+childWindowId);
		  getCommand().getDriver().switchTo().window(childWindowId);
		  System.out.println(getCommand().getDriver().getTitle());
		  getCommand().waitForTargetVisible(txt_EsyscoOrderName);
		 log("Enter the Order name: "+orderName,LogType.STEP);
			getCommand().waitFor(3);
		getCommand().sendKeys(txt_EsyscoOrderName, orderName);
		log("Click on update button",LogType.STEP);
		getCommand().waitForTargetVisible(btn_Update);
		getCommand().click(btn_Update);
		getCommand().getDriver().switchTo().window(parentWindowId);
		return this;
	}
*/

	public HomePage logOut(){

		getCommand().getDriver().switchTo().frame("topFrame");

		if (getCommand().isTargetPresent(link_Logout)){
			log("Logged out from eSysco Site",LogType.STEP);
			getCommand().click(link_Logout);
			log("Confirmation message popped up",LogType.STEP);
			getCommand().getDriver().switchTo().alert().accept();
		}
		return this;
	}

	public HomePage atExpressHomePage(){
		getCommand().waitForTargetPresent(logo_Express);
		log("Moved to Sysco Express Site",LogType.STEP);
		return this;
	}

	public HomePage SelectLocation(String strOpCo, String strCustomer){

		getCommand().waitForTargetPresent(lst_OpCo);

		if(getCommand().isTargetPresent(lst_OpCo)){
			log("Click on dropdown",LogType.STEP);
			log("Select OpCo " + strOpCo,LogType.STEP);

			if(Arrays.asList("*chrome","*iexplore").contains(TestProperties.getProperties("test.browser"))){
				String[] all = strOpCo.split("-");
				(new SupportFunctions()).selectDropDownValue(By.xpath("//select[@id='opCo_id']"), all[0].trim());
				//getCommand().selectDropDown(lst_OpCo, 3);
			}else{
				getCommand().selectDropDown(lst_OpCo, strOpCo);
			}
		}

		//getCommand().getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.MINUTES);
		getCommand().waitForTargetPresent(txt_Customer);
		if(getCommand().isTargetPresent(txt_Customer)){
			log("Enter Customer " + strCustomer,LogType.STEP);
			getCommand().sendKeys(txt_Customer, strCustomer);
		}
		(new SupportFunctions()).waitForLoading(400, By.xpath("//*[@id='asyncLoadingMessageText']"));
		//getCommand().getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.MINUTES);
		getCommand().waitForTargetPresent(cont_Location.replace("<#>", strCustomer));
		if(getCommand().isTargetPresent(cont_Location.replace("<#>", strCustomer))){
			log("Select " + strCustomer,LogType.STEP);
			getCommand().click(cont_Location.replace("<#>", strCustomer));
			(new SupportFunctions()).waitForLoading(400, By.xpath("//*[@id='loadingDiv11']"));
		}

		return this;
	}
	public HomePage enterCustomerName(String customerName){
		if(getCommand().isTargetPresent(txt_Customer)){
			log("Enter Customer "+customerName,LogType.STEP);
			getCommand().sendKeys(txt_Customer, customerName);
			String link_Text="Account #:"+" "+customerName;
			log("Click On Customer "+customerName,LogType.STEP);
			getCommand().getDriver().findElement(By.linkText(link_Text)).click();
		}
		return this;
	}
	public HomePage clickYesToSwitch(){
		if(getCommand().isTargetPresent(btn_Yes)){
			log("Click On Yes To Switch",LogType.STEP);
			getCommand().click(btn_Yes);
		}
		return this;
	}
	public HomePage validateMsgAtSwitchCustomerPopUp(){
		String message=getCommand().getDriver().findElement(By.xpath("//*[@id='customerSwitchDiv']/div[2]/div/div/div[2]")).getText();
		System.out.println("Message=========="+message);
		String actualMessage="Are you sure you want to switch account?";
		if(message.contains(actualMessage)){
			log("Message Is Validated: '"+message+"'",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::Message Not Validated");
		}
		return this;
	}
	public HomePage validateHeaderPage(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='customerSwitchDiv']"));
		getCommand().getDriver().manage().timeouts().setScriptTimeout(120,TimeUnit.SECONDS);
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='tp2']")).isDisplayed()){
			log("WelCome Header Page Is Displayed",LogType.STEP);
		}
	   else{
			SoftAssertion.fail("Failed::WelCome Header Page Is Not Displayed");
		}
		return this;

	}

	public HomePage atExpressOrderingPage(){
		getCommand().waitForTargetPresent(sidebar_AccountSummary);
		log("Moved to Sysco Express Ordering Home page",LogType.STEP);
		return this;
	}
	public HomePage startNewOrder(){
		//wait for load pop to be invisible
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(btn_StartNewOrder);
		if(getCommand().isTargetPresent(btn_StartNewOrder)){
			log("Click on Start New Order",LogType.STEP);
			getCommand().click(btn_StartNewOrder);
		}
		return this;
	}
	public HomePage clickOnLocation(){
		getCommand().waitForTargetVisible(btn_Location);
		if(getCommand().isTargetPresent(btn_Location)){
			log("Click On Location",LogType.STEP);
			getCommand().click(btn_Location);


		}
		return this;
	}
	public HomePage clickOnReportTab(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetVisible(tab_Report);
		if(getCommand().isTargetPresent(tab_Report)){
			log("Report page  is Opened",LogType.STEP);
			getCommand().click(tab_Report);


		}
		return this;
	}
	public HomePage validateReportSummary(){
		getCommand().waitForTargetVisible(summary_Report);
		if(getCommand().isTargetPresent(summary_Report)){
			log("Report Summary  Is Displayed",LogType.STEP);
			}else{
				SoftAssertion.fail("Faile::Report Summary  Is Not Displayed");
			}
		return this;
	}
	public HomePage validateReportSummaryMauser(){
		getCommand().waitForTargetVisible(summary_ReportMA);
		if(getCommand().isTargetPresent(summary_ReportMA)){
			log("Report Summary  Is Displayed",LogType.STEP);
			}else{
				SoftAssertion.fail("Faile::Report Summary  Is Not Displayed");
			}
		return this;
	}
	public HomePage closeReportSummary(){
		   getCommand().getDriver().manage().timeouts().setScriptTimeout(120,TimeUnit.SECONDS);
		   WebElement element = getCommand().getDriver().findElement(By.xpath("//*[@id='order-summary-report-popup']/div[1]/span"));
			JavascriptExecutor executor = (JavascriptExecutor)getCommand().getDriver();
			executor.executeScript("arguments[0].click();", element);
			log("Close The Summary Report",LogType.STEP);
		return this;
	}
	public HomePage validateReportPopup(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().setScriptTimeout(120,TimeUnit.SECONDS);
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='order-summary-report-popup']")).isDisplayed()){
			log("Report Modal Pop up Is Displayed",LogType.STEP);
		}else{
			SoftAssertion.fail("Faile::Report Modal Pop up Is Displayed");
		}
		return this;

	}
	public HomePage selectCustomerFromDropDown(String cNumber){
		//wait for load pop to be invisible
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		(new SupportFunctions()).selectDropDownValue(By.xpath("//*[@id='order-summary-report-toolbar-select']"), cNumber);
		(new SupportFunctions()).keyBoardEvent();
		getCommand().waitFor(10);
		return this;
	}

	public HomePage enterAnyItemInSearchBox(String searchItemName){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(getCommand().isTargetPresent(txt_Search)){
			log("Enter Item In Search Box:"+searchItemName,LogType.STEP);
			getCommand().clear(txt_Search).sendKeys(txt_Search,searchItemName);
		}
		return this;
	}
	public HomePage clickOnSearchButton(){
		getCommand().waitForTargetVisible(btn_search);
			log("Click On Search Button",LogType.STEP);
			getCommand().click(btn_search);
			(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='res-loading']"));
		  //Waiting For The Element To Be Loaded in i.e browser only
		 (new SupportFunctions()).waitForStatic(10);
		return this;
	}
	public HomePage enterOrderQuantity(String upcName,String quantity ){
		enterUPCInSearchBox(upcName);
		getCommand().waitForTargetPresent(txt_Quantity.replace("<#>", upcName));
		if(getCommand().isTargetPresent(txt_Quantity.replace("<#>", upcName))){
			log("Enter Order Quantity:"+quantity,LogType.STEP);
			getCommand().clear(txt_Quantity.replace("<#>", upcName)).sendKeys(txt_Quantity.replace("<#>",upcName),quantity);
		}
		return this;
	}
	public HomePage enterOrderQuantityInProductWindow(String quantity,String upcName){
		getCommand().getDriver().manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
			log("Enter Order Quantity:"+quantity,LogType.STEP);
			//Waiting For The Object In IE
			new SupportFunctions().waitForStatic(5);
			WebElement element = getCommand().getDriver().findElement(By.xpath("//*[@id='caseQty']"));
			//Waiting For The Object In IE
			new SupportFunctions().waitForStatic(5);
			element.sendKeys(quantity);
		return this;
	}
	public  HomePage ClickOnOrderdetails() {
		getCommand().waitForTargetPresent(btn_OrderDetails);
	if(getCommand().isTargetPresent(btn_OrderDetails)){
		log("Click On Order Details",LogType.STEP);
		getCommand().click(btn_OrderDetails);
	}
		return this;
	}

	public HomePage getLastmodifiedby() {
		getCommand().waitForTargetPresent(lastModifiedBy);
		if(getCommand().isTargetPresent(lastModifiedBy)){
			log("Last modified Field Is Present",LogType.STEP);

		}
		else{
			SoftAssertion.fail("Failed::Last Modified Field Not Present");
		}
		return this;
	}

	public HomePage validateLastmodifiedbyuser(String userName) {
		//wait for load pop to be invisible
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(getCommand().isTargetPresent(lastModifiedByUser)){
			String modifiedUser=getCommand().getText(lastModifiedByUser);
			if(modifiedUser.equalsIgnoreCase(userName)){
				log("Modified User Is "+userName,LogType.STEP);
			}else{
				SoftAssertion.fail("Failed::Modified User Is:"+modifiedUser);
			}

		}
		return this;
	}
	public HomePage validateUserDB(String userName,String key) {
		//wait for load pop to be invisible
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		ArrayList srrData = new SupportFunctions().retrieveData("SELECT  NTMOI2 fROM ESOHNTTF WHERE NTEPO# ='    "+(String)getCommand().retrieveValue(key)+"'");
		System.out.println("ResultSet : " +srrData);
		ArrayList arrFirstRow=(ArrayList)srrData.get(0);
		String modifiedUserName=(String)arrFirstRow.get(0);
		System.out.println("Modified User===="+modifiedUserName);
		System.out.println("Actual User name===="+userName);
			if(modifiedUserName.trim().equals(userName.trim())){
				log("Modified User Is "+userName,LogType.STEP);
			}else{
				SoftAssertion.fail("Failed::Modified User Is:"+modifiedUserName);
			}


		return this;
	}
	public HomePage clickOnModify(){
		getCommand().waitForTargetVisible(btn_Modify);

		if(getCommand().isTargetPresent(btn_Modify)){
			log("click On Modify button",LogType.STEP);
			getCommand().click(btn_Modify);
		}
		return this;
	}
	public HomePage verifyModify(){
		//wait for load pop to be invisible
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(getCommand().getDriver().findElements(By.xpath("//*[@id='modifyOrderButTop']")).size()==0){
			log("Modification Can Not be Done",LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed::Modification Is Done");
		}
		return this;
	}
	public HomePage clickOnYesToConformModify(){

		getCommand().waitForTargetPresent(btn_ConformModifyOrder);
		if(getCommand().isTargetPresent(btn_ConformModifyOrder)){
			log("click On Yes To Modify",LogType.STEP);
			getCommand().click(btn_ConformModifyOrder);
		}
		return this;
	}
	public HomePage acceptAlert_Modify(){
		//Click Yes For Modify
		getCommand().waitForTargetVisible(btn_AcceptedAlert);
		if(getCommand().isTargetPresent(btn_AcceptedAlert)){
			log("Click Yes To Modify",LogType.STEP);
			getCommand().click(btn_AcceptedAlert);
		}
		return this;

	}
	public HomePage clickOnOkAfterSubmitInModify(){
		getCommand().waitForTargetPresent(btn_Ok);
		if(getCommand().isTargetPresent(btn_Ok)){
			log("Click On Ok Button",LogType.STEP);
			getCommand().click(btn_Ok);
		}
		return this;
	}

public HomePage vefifyTextInDescrition(){
	getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	((JavascriptExecutor)getCommand().getDriver()).executeScript("arguments[0].scrollIntoView(true);", getCommand().getDriver().findElement(By.xpath("//span[@class='redtxbold2']")));
	getCommand().getDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	String desCription01=getCommand().getDriver().findElement(By.xpath("//span[@class='redtxbold2']")).getText();
	String desCription02=getCommand().getDriver().findElement(By.xpath("//span[@class='bluetxbold2']")).getText();
	System.out.println(desCription01);
	System.out.println(desCription02);
	   if(desCription01.equals("Leaving Soon")){
		log(desCription01+" Text Is Present In Descrition",LogType.STEP);
	   }
		else{
			SoftAssertion.fail("Failed::'Leaving Soon' Text Not Present");
		}
		  if(desCription02.contains("Will be replaced by")){
		log(desCription02+" Text Is Present In Descrition",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::'Will be Replaced By' Text Not Present");
		}
	return this;
 }
public HomePage enterUPCInSearchBox(String strUPC){
		 getCommand().waitForTargetPresent(box_Search);
		if(getCommand().isTargetPresent(box_Search)){
			log("Enter Item number: " + strUPC,LogType.STEP);
			getCommand().clear(box_Search);
			getCommand().sendKeys(box_Search, strUPC).click(box_Search);
			//Waiting For The Object In IE
			 new SupportFunctions().waitForStatic(5);
		}

	return this;

   }

  public HomePage getOrderDetails(String key){
	//Getting item number and it's respective price
	ArrayList srrData_01 = new SupportFunctions().retrieveData("SELECT NQITEM,NQCSPS FROM ESODNQTF WHERE NQEPO#='   "+getCommand().retrieveValue(key)+"'");
	//Getting quantity of  items
	ArrayList srrData_02 = new SupportFunctions().retrieveData("SELECT NQQTY6 FROM ESODNQTF WHERE NQEPO#='   "+getCommand().retrieveValue(key)+"'");
	for(int i=0;i<srrData_01.size();i++){
		ArrayList arrRow = (ArrayList)srrData_01.get(i);
		for(int j=0;j<arrRow.size();j++){
			if(j==0){
				String upc=(String) arrRow.get(j);
				//Storing item number in arraylist
			   upcNumber.add(upc);
			}
			if(j==1){
				String price=(String) arrRow.get(j);
				//Storing price of the item in arraylist
				itemPrice.add(price);
			}
		}
		for(int k=0;k<srrData_02.size();k++){
			System.out.println("Size Of Q Array"+srrData_02.size());
			ArrayList arrFirstRow_02 = (ArrayList)srrData_02.get(k);
			String quantity=(String)arrFirstRow_02.get(k);
			//Storing quantity in arraylist
			itemQuantity.add(quantity);
		}
	}
	return this;
  }
public HomePage getTotalPriceForItem(){
	//Getting Total Price For The Item
	Iterator<String> read=itemQuantity.iterator();
	while(read.hasNext()){
		int quantity=Integer.parseInt(read.next());
		float price=Float.parseFloat(read.next());
		String totalPrice=(quantity*price)+"";
		totalPrice_Item.add(totalPrice);
		System.out.println(totalPrice_Item);
		log("Total price For The Order Is:"+(quantity*price),LogType.STEP);
	}


	return this;
}
public HomePage itemPriceValidation(){
	Iterator<String> read=upcNumber.iterator();
	while(read.hasNext()){
		String totalPrice=Integer.parseInt(getCommand().getText(txt_TotalItemPrice.replace("<#>",read.next())))+"";
		System.out.println(totalPrice);
		if(getCommand().isTargetPresent(txt_TotalItemPrice.replace("<#>",read.next()))){
		if(totalPrice.contains(totalPrice_Item.get(0))){
			log("Total price for item number("+read.next()+") is:"+totalPrice,LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed::Total Price Is Not Equal");
		}
	  }
	}
	return this;

}
public HomePage validateStatusOfOpenOrder(String key){
	(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	String orderNumber=(String)getCommand().retrieveValue(key);
	getCommand().waitForTargetPresent(btn_OrderedItem.replace("<#>",orderNumber));
	if(getCommand().isTargetPresent(btn_OrderedItem.replace("<#>",orderNumber))){
		String status=getCommand().getAttributeValue(btn_OrderedItem.replace("<#>",orderNumber), "title");
		System.out.println("Open Order Status By Att:"+status);
		//System.out.println("By Text:"+getCommand().getText(btn_OrderedItem.replace("<#>",orderNumber)));
		if(status.contains("Open")){
		log("The Status Of The Order Is:"+status,LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::The Status Of The Order Is Not open");
		}
	}

	return this;
 }
public HomePage validateStatusOfRejectOrder(String key){
	//wait for load pop to be invisible
	(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	getCommand().getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	String orderNumber=(String)getCommand().retrieveValue(key);
	getCommand().scrollTo(btn_OrderedItem.replace("<#>",orderNumber));
	if(getCommand().isTargetPresent(btn_OrderedItem.replace("<#>",orderNumber))){
		String status=getCommand().getText(btn_OrderedItem.replace("<#>",orderNumber));
		System.out.println(status);
		if(status.contains("Rejected")){
		log("The Status Of The Order Is:"+status,LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::The Status Of The Order Is Not open");
		}
	}

	return this;
}
public HomePage validatePendingApprovalOrderStatus(String key){
	//wait for load pop to be invisible
	(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	getCommand().getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	String orderNumber=(String)getCommand().retrieveValue(key);
	getCommand().waitForTargetPresent(txt_StatusPendingOrder.replace("<#>",orderNumber));
	if(getCommand().isTargetPresent(txt_StatusPendingOrder.replace("<#>",orderNumber))){
		String status=getCommand().getText(txt_StatusPendingOrder.replace("<#>",orderNumber));
		System.out.println(status);
		if(status.contains("Pending approval")){
		log("The Status Of The Order Is:"+status,LogType.STEP);
	  }else{
		  SoftAssertion.fail("Failed::The Status Is Not Pending Approval");
	  }
	}

	return this;
 }
public HomePage validateSubmittedOrderStatus(String key){
	String orderNumber=(String)getCommand().retrieveValue(key);
	/*getCommand().waitForTargetPresent(btn_OrderedItem.replace("<#>",orderNumber));
	if(getCommand().isTargetPresent(btn_OrderedItem.replace("<#>",orderNumber))){
		String status=getCommand().getText(btn_OrderedItem.replace("<#>",orderNumber));
		int iCount=0;
		while(iCount!=1){
			if(!(status=="Submitted")){
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			}
			status=getCommand().getText(btn_OrderedItem.replace("<#>",orderNumber));
			System.out.println("Submitted Order Status====="+status);
			iCount++;
		}*/
	ArrayList srrData = new SupportFunctions().retrieveData("select NTORST from ESOHNTTF where trim(NTEPO#)='"+orderNumber+"'");
	System.out.println("ResultSet : " +srrData);
	ArrayList arrFirstRow = (ArrayList)srrData.get(0);
	String status=(String) arrFirstRow.get(0);
	System.out.println("Submitted Order Status====="+status);
	if(status.equals("S")){
		   log("The Status Of The Order Is:"+status,LogType.STEP);
	   }else{
		   SoftAssertion.fail("Failed::The Status Of Order Is Not 'Submitted'");
	   }


	return this;
 }

public HomePage clickOnOpenOrderLink(){
	//wait for load pop to be invisible
	(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	getCommand().waitForTargetPresent(btn_OpenOrderLink);
	if(getCommand().isTargetPresent(btn_OpenOrderLink)){
		log("Click On Open Order Link",LogType.STEP);
		getCommand().click(btn_OpenOrderLink);
	}
	return this;
}
public HomePage clickOnAnySubmittedOrder(){
	System.out.println(txt_OrderName);
	getCommand().waitForTargetPresent(btn_OrderedItem.replace("<#>",txt_OrderName));
	String status=getCommand().getText(btn_OrderedItem.replace("<#>",txt_OrderName));
	while(!(status=="Submitted")){
		getCommand().getDriver().navigate().refresh();
	}
	if(getCommand().isTargetPresent(link_OrderName.replace("<#>",txt_OrderName))){
		log("Click On Any Order Link",LogType.STEP);
		getCommand().click(link_OrderName.replace("<#>",txt_OrderName));
	}
	return this;
}
 public  HomePage getTextOrderNumber(String key){
	getCommand().getDriver().manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
	String txt_OrderName=(getCommand().getDriver()).findElement(By.xpath("//*[@id='ordno']/span[2]")).getText();
	getCommand().storeValue(key,txt_OrderName);
	log("Order Number Is:"+txt_OrderName,LogType.STEP);
	return this;
  }
public HomePage clickOnAnyOrder(String key){
	(new SupportFunctions()).waitForLoading(1000, By.xpath("//*[@id='asyncLoadingMessageText']"));
	getCommand().waitFor(3);
	getCommand().waitForTargetPresent(link_OrderName.replace("<#>",(String)getCommand().retrieveValue(key)));
	if(getCommand().isTargetPresent(link_OrderName.replace("<#>",(String)getCommand().retrieveValue(key)))){
		log("Click On Order:"+(String)getCommand().retrieveValue(key),LogType.STEP);
		getCommand().click(link_OrderName.replace("<#>",(String)getCommand().retrieveValue(key)));
	}
	return this;
  }
 public HomePage clickOnSubmittedOrder(String key){
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	 int i=0;
	 if(!getCommand().isTargetPresent(link_OrderName.replace("<#>",(String)getCommand().retrieveValue(key)))){
		 while(i<5){
			 getCommand().getDriver().navigate().refresh(); 
		 }
		 i++;
	 }
	   getCommand().waitForTargetPresent(link_OrderName.replace("<#>",(String)getCommand().retrieveValue(key)));
	     if(getCommand().isTargetPresent(link_OrderName.replace("<#>",(String)getCommand().retrieveValue(key)))){
		     log("Click On Order:"+(String)getCommand().retrieveValue(key),LogType.STEP);
		      getCommand().click(link_OrderName.replace("<#>",(String)getCommand().retrieveValue(key)));
	     }
	return this;
  }
public HomePage getOrderNumberFromDataBase(char status,String key,String cNumber){
	//Getting Order Number From DB
	String txt_OrderName="";
	if(status=='S'){
	ArrayList srrData = new SupportFunctions().retrieveData("select NTEPO# from ESOHNTTF where NTCUNO='        "+cNumber+"' AND NTORST="+"'"+status+"' AND NTSRCC='8'");
	System.out.println("ResultSet : " +srrData);
	ArrayList arrFirstRow = (ArrayList)srrData.get(0);
	txt_OrderName=(String) arrFirstRow.get(0);
	getCommand().storeValue(key, txt_OrderName);
	System.out.println("Order Number============"+txt_OrderName);
	}else{
		ArrayList srrData = new SupportFunctions().retrieveData("select NTEPO# from ESOHNTTF where NTCUNO='        "+cNumber+"' AND NTORST="+"'"+status+"'");
		System.out.println("ResultSet : " +srrData);
		ArrayList arrFirstRow = (ArrayList)srrData.get(0);
		txt_OrderName=(String) arrFirstRow.get(0);
		getCommand().storeValue(key, txt_OrderName);
		System.out.println("Order Number============"+txt_OrderName);
	}
	return this;
  }

public HomePage clickOnQuickOrderEntry(){
	//wait for load pop to be invisible
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetVisible(btn_QuickOrderEntry);
		 WebElement element = getCommand().getDriver().findElement(By.xpath(btn_QuickOrderEntry.getTargetValue()));
		 JavascriptExecutor executor = (JavascriptExecutor)getCommand().getDriver();
		 executor.executeScript("arguments[0].click();", element);
		/*if (getCommand().isTargetPresent(btn_QuickOrderEntry)){
			log("Click On Quick Order Entry",LogType.STEP);
			getCommand().click(btn_QuickOrderEntry);

		}*/
		return this;
}
public HomePage clickOnDeleteItem(){
	//wait for load pop to be invisible
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(link_DeleteItem);
		if (getCommand().isTargetPresent(link_DeleteItem)){
			log("Click On Delete Item",LogType.STEP);
			getCommand().click(link_DeleteItem);

		}
		return this;
}
public HomePage clickOnSubmittedOrdersLink(){
	//wait for load pop to be invisible
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(btn_SubmittedOrderLink);
		if (getCommand().isTargetPresent(btn_SubmittedOrderLink)){
			log("Recent Orders Is Displayed",LogType.STEP);
			getCommand().waitFor(5);
			getCommand().click(btn_SubmittedOrderLink);

		}
		return this;
	}
public HomePage clickOnPendingOrdersLink(){
	//wait for load pop to be invisible
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(btn_PendingOrderLink);
		if (getCommand().isTargetPresent(btn_PendingOrderLink)){
			log("Click on pending order link",LogType.STEP);
			getCommand().click(btn_PendingOrderLink);

		}
		return this;
	}
public HomePage clickOnModifyInSubmittedOrder(){
	//Waiting For The Object In IE
	  new SupportFunctions().waitForStatic(5);
	getCommand().waitForTargetVisible(btn_ModifySubmittedOrder);
	if(getCommand().isTargetPresent(btn_ModifySubmittedOrder)){
		log("Click on Modify in Submitted Order",LogType.STEP);
		getCommand().click(btn_ModifySubmittedOrder);
	}
	return this;
}
  public HomePage getTotalPriceFromDB(String key){
	  //Getting the total Price
	ArrayList srrData = new SupportFunctions().retrieveData("select NTTTOR from ESOHNTTF where NTCUNO='        108761' AND NTORST='U' AND NTEPO#="    +"'"+(String)getCommand().retrieveValue(key)+"'");
	System.out.println("ResultSet : " +srrData);
	ArrayList arrFirstRow = (ArrayList)srrData.get(0);
	String totalPriceFromDB=(String) arrFirstRow.get(0);
	getCommand().storeValue(key, totalPriceFromDB);
	System.out.println("Total price is : " +totalPriceFromDB);
	return this;
  }
  public HomePage getTotalOrderFromDB(String keyOrder,String strCustomer){
	  //Getting the total Price
	System.out.println("select NTTTOR from ESOHNTTF where NTCUNO='        "+strCustomer.trim()+"' AND NTEPO#='    "+(String)getCommand().retrieveValue(keyOrder)+"'");
	ArrayList srrData = new SupportFunctions().retrieveData("select NTTTOR from ESOHNTTF where NTCUNO='        "+strCustomer.trim()+"' AND NTEPO#='    "+(String)getCommand().retrieveValue(keyOrder)+"'");
	System.out.println("ResultSet : " +srrData);
	ArrayList arrFirstRow = (ArrayList)srrData.get(0);
	String totalPriceFromDB=(String) arrFirstRow.get(0);
	getCommand().storeValue(keyOrder, totalPriceFromDB);
	System.out.println("Total price is : " +totalPriceFromDB);
	return this;
  }
  public HomePage validateTotalPrice(String key){
	 if(getCommand().isTargetPresent(txt_TotalPrice)){
		 String totalPrice=getCommand().getText(txt_TotalPrice);
		 System.out.println(totalPrice);
		 System.out.println(getCommand().retrieveValue(key));
		 if(totalPrice.equals((String)getCommand().retrieveValue(key)))
		 {
			 log("Total Price Is Equal:"+totalPrice,LogType.STEP);
		 }else{
			 SoftAssertion.fail("Failed::Total Price Is Not Equal");
		 }

	 }
	 return this;
  }
  public HomePage  getTotalQuantityAfterModify(String key){
		// getCommand().getDriver().manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
	  getCommand().waitForTargetVisible(txt_TotalQunatity);
		 String qValue= getCommand().getText(txt_TotalQunatity);
		 log("Total Quantity========="+qValue,LogType.STEP);
		 getCommand().storeValue(key, qValue);
		 return this;
	  }
  public HomePage  getUpdatedQuantity(String key,String[] caseQuantity){
		 int q=Integer.parseInt((String)getCommand().retrieveValue(key));
		 for(int i=0;i<caseQuantity.length;i++){
			 int qUpdated=Integer.parseInt(caseQuantity[i]);
			 q=q+qUpdated;
		 }
		 getCommand().storeValue(key,q+"");
		 System.out.println("Updated Quantity========="+q);
	  return this;
	  }

  public HomePage validateTotalPriceAfterModify(String key){
		 if(getCommand().isTargetPresent(txt_TotalPrice)){
			 String totalPrice=getCommand().getText(txt_TotalPrice);
			 System.out.println(totalPrice);
			 String modifiedPrice=(String)getCommand().retrieveValue(key);
			 System.out.println("Total Price After Modify==========="+(String)getCommand().retrieveValue(key));
			 if(totalPrice.equals(modifiedPrice))
			 {
				 log("Total Price Is Equal:"+totalPrice,LogType.STEP);
			 }else{
				 SoftAssertion.fail("Failed::Total Price Is Not Equal");
			 }
		 }

		 return this;
	  }
  public HomePage clickOnGoToList(){
	//wait for load pop to be invisible
	  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(btn_GoToList);
		if(getCommand().isTargetPresent(btn_GoToList)){
			log("Click On go to List",LogType.STEP);
			getCommand().click(btn_GoToList);
			}
		return this;
	}
  public HomePage clickOnGoToOrderGuide(){
	//wait for load pop to be invisible
	  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(btn_GoToOrderGuide);
		if(getCommand().isTargetPresent(btn_GoToOrderGuide)){
			log("Click On Go To Order Guide",LogType.STEP);
			getCommand().click(btn_GoToOrderGuide);
			}
		return this;
	}
   public HomePage validateDeletedOrder(String key){
	   getCommand().getDriver().manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
		  if(getCommand().getDriver().findElements(By.xpath("//*[@id='"+getCommand().retrieveValue(key)+"']")).size()==0){
			  log("Order Number "+getCommand().retrieveValue(key)+"  Deleted Successfully ",LogType.STEP);
		  }else{

	  SoftAssertion.fail("Failed::Order Number "+getCommand().retrieveValue(key)+"  Not Deleted Successfully ");
	  }
		 return this;
	 }
  public HomePage validateModifyOnPendingOrder(){
	  String Expectedmessage="This order is currently waiting to be approved. If you change this order it must be resubmitted for approval.";
	  String actualAlertMsg=getCommand().getDriver().findElement(By.xpath("//*[@id='modifyOrderPopUpMessage']")).getText();
	  if(Expectedmessage.equals(actualAlertMsg)){
		  log(actualAlertMsg+" alert is Found And Validated ",LogType.STEP);
	  }
	  else{
		  SoftAssertion.fail("Failed::'This order is currently waiting to be approved. If you change this order it must be resubmitted for approval.' Text Is Not Present");
	  }
	  return this;
  }

  public HomePage clickOnCancelledOrder(){
	//wait for load pop to be invisible
	  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(btn_CancellededOrderLink);
		if(getCommand().isTargetPresent(btn_CancellededOrderLink)){
			log("Click On Cancelled Order Link",LogType.STEP);
			getCommand().click(btn_CancellededOrderLink);

		}
		return this;
	}
  public HomePage clickOnPrduct(String upcName){
	//wait for load pop to be invisible
	  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	  enterUPCInSearchBox(upcName);
	  getCommand().getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  String path="//a[@id='"+upcName.trim()+"-CS_productName']";
	  getCommand().waitFor(3);
	  getCommand().getDriver().findElement(By.xpath(path)).click();
	  log("Click on product to get product information",LogType.STEP);
	 return this;
  }
  public HomePage switchToProductInfoWindow(){
		 new SupportFunctions().switchWindow();
	  //String winHandle=getCommand().getDriver().getWindowHandle();
		//	getCommand().getDriver().switchTo().window(winHandle);
			//String winHandle1=getCommand().getDriver().getWindowHandles().toString();
			//	getCommand().getDriver().switchTo().window(winHandle1); // switch focus of WebDriver to the next found window handle (that's your newly opened window)


		//Waiting For The Object In IE
		 new SupportFunctions().waitForStatic(5);
		 getCommand().getDriver().manage().window().maximize();
		 log("Switch To Product Info Window",LogType.STEP);
		return this;

	 }
  public HomePage switchToMainWindow(){
		 new SupportFunctions().switchWindowBack();
		 log("Switch Back To Main Window",LogType.STEP);
		return this;

	 }
  public HomePage switchToWindowAutomatic(String key){
		 Set<String> window=getCommand().getDriver().getWindowHandles();
		 Iterator<String> itr=window.iterator();
		 getCommand().storeValue(key,itr.next());
		 while(itr.hasNext()){
			 System.out.println("Window========"+itr.next());
		 }
		 log("Getting Windows Id",LogType.STEP);
		 return this;

	 }
  public HomePage switchToMainWindowClose(String key){
		 getCommand().getDriver().switchTo().window((String)getCommand().retrieveValue(key));
		 log("Switch Back To Main Window",LogType.STEP);
		return this;

	 }
  public HomePage checkOnAllItem(){
		getCommand().waitForTargetPresent(btn_ChkAllItems);
		if(getCommand().isTargetPresent(btn_ChkAllItems)){
			log("Check all items",LogType.STEP);
			getCommand().click(btn_ChkAllItems);
		}
		return this;
	}
  public HomePage clickOnPrintProductInfo(){
	//Waiting For The Object In IE
	  new SupportFunctions().waitForStatic(5);
	  /*String parent = getCommand().driver.getWindowHandle();

	  // after clicking on the link
	  //wait('100');
	  getCommand().waitFor(100);
	   Set<String> availableWindows = getCommand().driver.getWindowHandles();
	   String newWindow = null;
	   for (String window : availableWindows) {
		   if (!parent.equals(window)) {
			   newWindow = window;
		   }
	   }
	   //assertNotNull(newWindow);

	   // switch to new window
	   getCommand().driver.switchTo().window(newWindow);*/
	  System.out.println(getCommand().getPageTitle().toString());
	  //getCommand().click(btn_PrintProduct);
	  //System.out.println( getCommand().driver.getTitle().toString());
	  getCommand().waitForTargetVisible(btn_PrintProduct);
	  if(getCommand().isTargetPresent(btn_PrintProduct)){
		  log("Print preview is displayed",LogType.STEP);
		  getCommand().click(btn_PrintProduct);
	  }

	  return this;
  }
  public HomePage clickOnCancelPrintInProductInfo(){
	  getCommand().waitForTargetPresent(btn_CancelPrintProduct);
	  if(getCommand().isTargetPresent(btn_CancelPrintProduct)){
		  log("Click On Cancel Print Product Information",LogType.STEP);
		  getCommand().click(btn_CancelPrintProduct);
	  }

	  return this;
  }
  public HomePage selectOrderSubmittedOption(){
	  getCommand().waitForTargetPresent(chk_OrderSubmittedOption);
	  if(getCommand().isChecked(chk_OrderSubmittedOption)){
		  log("Submitted Option Is Already Selected",LogType.STEP);
	  }
	  else{
		  getCommand().click(chk_OrderSubmittedOption);
	  }
	  return this;
  }
 public HomePage selectDate(int day){
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getCommand().getDriver().findElement(By.xpath("//*[@id='orderSummaryReportStartDate']")).click();
		getCommand().waitFor(5);
		//Storing The Years Present In DropDown In A List
		Calendar cal = Calendar.getInstance();
		//Getting Date before mentioned weeks
		cal.add(Calendar.DATE, -day); //
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MMM-d");
		String dateBeforeWeeks=s.format(new Date(cal.getTimeInMillis()));
		System.out.println(dateBeforeWeeks);
		String[] dateSplit=dateBeforeWeeks.split("-");
		//getCommand().getDriver().findElement(By.linkText(dateSplit[2]));
		 WebElement element = getCommand().getDriver().findElement(By.linkText(dateSplit[2]));
		 JavascriptExecutor executor = (JavascriptExecutor)getCommand().getDriver();
		 executor.executeScript("arguments[0].click();", element);
		 return this;
  }
  public HomePage selectDeliveryDateOption(){
	  getCommand().waitFor(5);
	  getCommand().waitForTargetPresent(chk_DeliveryDateOption);
	  if(getCommand().isChecked(chk_DeliveryDateOption)){
		  log("Delivery Date Option Is Selected",LogType.STEP);
	  }
	  else{
		  getCommand().click(chk_DeliveryDateOption);
	  }
	  return this;
  }
  public HomePage clickOnApplyButton(){
	 /* getCommand().waitForTargetPresent(btn_Apply);
	  log("Click On Apply Button",LogType.STEP);
	  getCommand().click(btn_Apply);*/
	  WebElement element = getCommand().getDriver().findElement(By.xpath(btn_Apply.getTargetValue()));
	  JavascriptExecutor executor = (JavascriptExecutor)getCommand().getDriver();
	  executor.executeScript("arguments[0].click();", element);
	  return this;
  }
  public HomePage  verifyCreateOrder_DemoUser(){
	  getCommand().getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  if(!getCommand().getDriver().findElement(By.xpath("//*[@id='createNewOrderLink']")).isEnabled()){
		  log("Creat New Order Link Is Not Enabled",LogType.STEP);
	  }else{
		  SoftAssertion.fail("Failed::Creat New Order Link Is  Enabled");
	  }
	  return this;
  }
  public HomePage  verifyHomePage(){
	  getCommand().getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  if(getCommand().getDriver().findElement(By.xpath("//*[@id='main-contentlistsprs']")).isDisplayed()){
		  log("Home Page Is Displayed",LogType.STEP);
	  }else{
		  SoftAssertion.fail("Failed::Home Page Is Not Displayed");
	  }
	  return this;
  }

  public HomePage verifyOrder(){
	//wait for load pop to be invisible
	  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	  getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  if(getCommand().getDriver().findElement(By.xpath("//*[@id='cloutext']")).isDisplayed()){
		  log("Order Is Displayed",LogType.STEP);
	  }else{
		  SoftAssertion.fail("Failed::Order Is Not Displayed");
	  }
	  return this;

  }
  public HomePage clickOnOrder(){
	  getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  getCommand().getDriver().findElement(By.xpath("//*[@id='cloutext']")).click();
	  log("Click On Order",LogType.STEP);
	  return this;
  }
  public HomePage verifyValidItem(String upcNumber){
	//wait for load pop to be invisible
	  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	  getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String path="//*[@id='"+upcNumber+"-CS']/td[17]";
		if(getCommand().getDriver().findElement(By.xpath(path)).isDisplayed()){
		 log(" Search Item '"+upcNumber +"'Is Displayed",LogType.STEP);
	   }
		else{
			 SoftAssertion.fail("Failed::Search Item '"+upcNumber +"'Is Displayed");
	  }
	  return this;
  }
  public HomePage verifyInvalidItem(String upcNumber){
		//wait for load pop to be invisible
		  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		  getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  String path="//*[@id='"+upcNumber+"-CS']/td[17]";
			if(getCommand().getDriver().findElements(By.xpath(path)).isEmpty()){
			 log(" 'Invalid Item Number:: '"+upcNumber +"'Is Displayed",LogType.STEP);
		   }
			else{
				 SoftAssertion.fail("Failed::Invalid Item:: '"+upcNumber +"'Is Displayed");
		  }
		  return this;
	  }
  public HomePage verifyValidItemName(String itemName){
		//wait for load pop to be invisible
		  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		  getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  String path="//*[@title='"+itemName+"']";
			if(!getCommand().getDriver().findElements(By.xpath(path)).isEmpty()){
			 log("Valid Item Name:: '"+itemName +"'Is Displayed",LogType.STEP);
		   }
			else{
				 SoftAssertion.fail("Failed::Valid Item:: '"+itemName +"'Is Not Displayed");
		  }
		  return this;
	  }
  public HomePage verifyValidBrandName(String brandName){
		//wait for load pop to be invisible
		  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		  getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  String path="//*[@title='"+brandName+"']";
			if(getCommand().getDriver().findElements(By.xpath(path)).isEmpty()){
			 log("Valid Brand Name:: '"+brandName +"'Is Not Displayed",LogType.STEP);
		   }
			else{
				 SoftAssertion.fail("Failed::Valid Brand Name:: '"+brandName +"'Is Displayed");
		  }
		  return this;
	  }
  public HomePage verifyInValidBrandName(String brandName){
		//wait for load pop to be invisible
		  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		  getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  String path="//*[@title='"+brandName+"']";
		  
			if(getCommand().getDriver().findElements(By.xpath(path)).isEmpty()){
			 log("InValid Brand Name:: '"+brandName +"'Is Not Displayed",LogType.STEP);
		   }
			else{
				 SoftAssertion.fail("Failed::InValid Brand Name:: '"+brandName +"'Is Displayed");
		  }
		  return this;
	  }

  public HomePage verifyInValidItemName(String itemName){
		//wait for load pop to be invisible
		  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		  getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  String path="//*[@title='"+itemName+"']";
			if(getCommand().getDriver().findElements(By.xpath(path)).isEmpty()){
			 log("INValid Item Name:: '"+itemName +"'Is Not Displayed",LogType.STEP);
		   }
			else{
				 SoftAssertion.fail("Failed::Valid Item:: '"+itemName +"'Is Displayed");
		  }
		  return this;
	  }

  public HomePage verifySearchBox(){
	//wait for load pop to be invisible
	  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	  getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  if(getCommand().getDriver().findElement(By.xpath("//*[@id='txtSearch']")).isDisplayed()){
		  log("Search Box Is Displayed",LogType.STEP);
	  }else{
		  SoftAssertion.fail("Failed::Search Box Is Not Displayed");
	  }
	  return this;
  }
  public HomePage verifyDropDownInSearchBox(String partialText){
	  getCommand().waitFor(5);
	  // And now list the suggestions
	  List<WebElement> allSuggestions = getCommand().getDriver().findElements(By.xpath("//li[@name='dropdownSelect']"));
	  for (WebElement suggestion : allSuggestions) {
		  //if(suggestion.getText().contains("partialText"))
		  log(suggestion.getText()+" Is Displayed",LogType.STEP);
	  }

	  return this;
  }



  public HomePage verifyTextInProductName(String upcName){
	  getCommand().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  String path="//span[@class='redtxbold2']";
	  int size1=getCommand().getDriver().findElements(By.xpath(path)).size();
	  if(size1!=0){
		  log("'Leaving Soon' Is Displayed",LogType.STEP);
	  }else{
		  SoftAssertion.fail("Failed::Description 'Leaving Soon' Is  Not Displayed");
	  }
	  int size2=getCommand().getDriver().findElements(By.xpath("//span[@class='bluetxbold2']")).size();
	  if(size2!=0){
		  log("'Will be replaced by' Is Displayed",LogType.STEP);
	  }else{
		  SoftAssertion.fail("Failed::Description 'Will be replaced by' Is  Not Displayed");
	  }
	  return this;
  }
  public HomePage getOrderNumberByOrderName(String orderName,String key) {
		getCommand().getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

		String path="//a[@title='"+orderName+"']";
		String txt_OrderName=getCommand().getDriver().findElement(By.xpath(path)).getAttribute("id");
		System.out.println(txt_OrderName);
		getCommand().storeValue(key, txt_OrderName);
	  if(!orderName.isEmpty()){
		log(orderName+" Is Found",LogType.STEP);
	  }else{
		SoftAssertion.fail("Failed::"+orderName+" Is Not Found");
	  }
		return this;
  }
  public HomePage verifyOrderAndListQuantity(int ref,String upc[],String listQunatity[]){
	  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	 if(ref==0){
		 String quantity=getCommand().getAttributeValue(txt_Quantity.replace("<#>",upc[ref]), "value");
		 int oQunatity=Integer.parseInt(quantity);
		 int lQuantity=Integer.parseInt(listQunatity[ref]);
		 if(oQunatity==lQuantity){
			 log("List Quantity And Order Quantity Are Equal",LogType.STEP);
		 }else{
			 SoftAssertion.fail("Failed::List Quantity And Order Quantity Are Not Equal");
		 }
	 }
	 else if(ref==1){
		 String quantity=getCommand().getAttributeValue(txt_Quantity.replace("<#>",upc[ref]), "value");
		 int oQunatity=Integer.parseInt(quantity);
		 int lQuantity=Integer.parseInt(listQunatity[ref]);
		 if((oQunatity-1)==lQuantity){
			 log("List Quantity Is One Less Than  OrderQuantity",LogType.STEP);
		 }else{
			 SoftAssertion.fail("Failed::List Quantity Is Not One Less Than  OrderQuantity");
		  }
		 }
	 else if(ref==2){
		 String quantity=getCommand().getAttributeValue(txt_Quantity.replace("<#>",upc[ref]), "value");
		 int oQunatity=Integer.parseInt(quantity);
		 int lQuantity=Integer.parseInt(listQunatity[ref]);
		 if((oQunatity+1)==lQuantity){
			 log("List Quantity Is One More Than  OrderQuantity",LogType.STEP);
		 }else{
			 SoftAssertion.fail("Failed::List Quantity Is  Not One More Than  OrderQuantity");
		  }
	 }

	  return this;
  }
  public HomePage verifyDefaultOrder(String type){
	  getCommand().getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  if(getCommand().getDriver().findElement(By.xpath("//select[@id='addProductsFrom']/option[@value='"+type+"']")).isSelected()){
		  log(getCommand().getDriver().findElement(By.xpath("//select[@id='addProductsFrom']/option[@value='"+type+"']")).getText()+" Is By Default Selected ",LogType.STEP);
	  }else{
		  SoftAssertion.fail("Failed::"+getCommand().getDriver().findElement(By.xpath("//select[@id='addProductsFrom']/option[@value='"+type+"']")).getText()+" Is Not Selected");
	  }

	 return this;
  }
  public HomePage verifyListpage(){
	//wait for load pop to be invisible
	  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	  getCommand().getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  if(getCommand().getDriver().findElement(By.xpath("//*[@id='messagelist']")).isDisplayed()){
		  log("List Page Is Displayed",LogType.STEP);
	  }else{
		  SoftAssertion.fail("Failed::List Page Is Not Displayed");
	  }
	  return this;
  }
  public HomePage verifyOrderGuidepage(){
	//wait for load pop to be invisible
	  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	  getCommand().getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  if(getCommand().getDriver().findElement(By.xpath("//*[@class='item-history-wrap']")).isDisplayed()){
		  log("Order Guide Page Is Displayed",LogType.STEP);
	  }else{
		  SoftAssertion.fail("Failed::Order Guide Page Is Not Displayed");
	  }
	  return this;
  }
  public HomePage verifyCreateOrderpage(){
	  getCommand().getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  if(getCommand().getDriver().findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']")).isDisplayed()){
		  log("Create New Order Modal Page Is Displayed",LogType.STEP);
	  }else{
		  SoftAssertion.fail("Failed::Create New Order Modal  Page Is Not Displayed");
	  }
	  return this;
  }
  public HomePage verifyCreateOrderAfterCancel(){
	  if(!getCommand().getDriver().findElement(By.xpath("//*[@id='createNewOrderDiv']")).isDisplayed()){
		  log("Create New Order Modal Page Is Disappeared After Cancel",LogType.STEP);
	  }else{
		  SoftAssertion.fail("Failed::Create New Order Modal Page Is Not Disappeared After Cancel");
	  }
	  return this;
  }
  public HomePage verifyGTINNumber(){
	  //log("GTIN Is Displayedsss",LogType.STEP);
	  getCommand().getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  getCommand().waitFor(5);
	  if(getCommand().getDriver().findElement(By.xpath("//*[@id='productInformationTable']/tbody/tr[3]/td[2]/span")).isDisplayed()){
		  log("GTIN Is Displayed",LogType.STEP);
	  }else{
		  SoftAssertion.fail("Failed::GTIN Is Not Displayed");
	  }
	  if(getCommand().getDriver().findElement(By.xpath("//*[@id='productInformationTable']/tbody/tr[3]/td[2]/span")).isDisplayed()){
		  log("GTIN Number:"+getCommand().getDriver().findElement(By.xpath("//*[@id='productInformationTable']/tbody/tr[3]/td[2]/span")).getText(),LogType.STEP);
	  }else{
		  SoftAssertion.fail("Failed::GTIN Number Is Not Displayed");
	  }
	  return this;
  }
 public HomePage clickOnAddToOrderinProductWindow(){
	 getCommand().waitFor(5);
	 getCommand().getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	 if(getCommand().getDriver().findElement(By.xpath("//*[@id='addtoorderClick']")).isEnabled()){
		 getCommand().getDriver().findElement(By.xpath("//*[@id='addtoorderClick']")).click();
		 log("Click On Add To Order",LogType.STEP);
		 getCommand().waitFor(5);
	 }

	 return this;
 }
 public HomePage verifySourceColumnOpenOrder(){
	//wait for load pop to be invisible
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	 getCommand().getDriver().manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
	 if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_openOrdersTab_sourceCode']")).isDisplayed()){
		 log("Source Column Is Displayed Next to EST.Total ($) In Open Order",LogType.STEP);
		 List<WebElement> sourceElements=getCommand().getDriver().findElements(By.xpath("//*[@title='Express']"));
		 String textSource=sourceElements.get(0).getText();
		 if(textSource.equals("Express")){
			 log("Value Of Source Column In Open Order:"+textSource,LogType.STEP);
		 }else{
			 SoftAssertion.fail("Failed::value Of Source Column Not Found In Open Order");
		 }
	 }else{
		 SoftAssertion.fail("Failed::Source Column Is Not Displayed In Open Order");
	 }
	 return this;
 }
 public HomePage verifySourceColumnRecentOrder(){
	//wait for load pop to be invisible
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	 getCommand().getDriver().manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
	 if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_submittedOrdersTab_sourceCode']")).isDisplayed()){
		 log("Source Column Is Displayed Next to EST.Total ($) In Recent Order",LogType.STEP);
		 List<WebElement> sourceElements=getCommand().getDriver().findElements(By.xpath("//*[@title='Express']"));
		 String textSource=sourceElements.get(0).getText();
		 if(textSource.equals("Express")){
			 log("Value Of Source Column In Recent Order:"+textSource,LogType.STEP);
		 }else{
			 SoftAssertion.fail("Failed::value Of Source Column Not Found In Recent Order");
		 }
	 }else{
		 SoftAssertion.fail("Failed::Source Column Is Not Displayed In Recent Order");
	 }
	 return this;
 }
 public HomePage verifySourceColumnHistoricalOrder(){
	//wait for load pop to be invisible
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	 getCommand().getDriver().manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
	 if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_nonopenOrdersTab_sourceCode']")).isDisplayed()){
		 log("Source Column Is Displayed Next to EST.Total ($) In Historical Order",LogType.STEP);
		 List<WebElement> sourceElements=getCommand().getDriver().findElements(By.xpath("//*[@title='Express']"));
		 String textSource=sourceElements.get(0).getText();
		 if(textSource.equals("Express")){
			 log("Value Of Source Column In Historical Order:"+textSource,LogType.STEP);
		 }else{
			 SoftAssertion.fail("Failed::value Of Source Column Not Found In Historical Order");
		 }
	 }else{
		 SoftAssertion.fail("Failed::Source Column Is Not Displayed In Historical Order");
	 }
	 return this;
 }
 public HomePage verifyQunatityActiveOrder(String[] quantity){
	//wait for load pop to be invisible
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));

	 for(int i=0;i<quantity.length;i++){
		int amount=Integer.parseInt(quantity[i]);
		totalQuantityActiveOrder=totalQuantityActiveOrder+amount;
	 }
	 System.out.println(totalQuantityActiveOrder);
	 getCommand().getDriver().manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
	 String txtQunatity=getCommand().getDriver().findElement(By.xpath("//*[@id='itemcntlink']/b")).getText();
	 String amountActiveOrder=txtQunatity.substring(5);
	 System.out.println(amountActiveOrder+"");
	 log("Total Quantity In Active Order:"+amountActiveOrder,LogType.STEP);
	 if(amountActiveOrder.equals(totalQuantityActiveOrder+"")){
		 log("Total Qunantity  Are Equal In Active Order Section",LogType.STEP);

	 }else{
		 SoftAssertion.fail("Failed::Total Qunantity Are Not Equal In Active Order Section");
	 }
	 return this;
  }

 public HomePage verifyHistoricalOrderPage(){
	 getCommand().getDriver().manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
	 String text=getCommand().getDriver().findElement(By.xpath("//font[@class='greenheadd']")).getText();
	 if(text.contains("Historical Orders")){

		log("Historical Order Page is Displayed",LogType.STEP);
	 }else{
		 SoftAssertion.fail("Failed::Historical Order Page is Not Displayed");
	 }
	 return this;
 }
 public HomePage verifyViewOrderWithoutOrder(){
	//wait for load pop to be invisible
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	 getCommand().getDriver().manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
	 	String btn_ViewOrder="//*[@id='viewActiveOrderBtn']";
	 	//String btn_ViewOrder="//div[contains(text(),'No Active Order')]";
		if(!getCommand().getDriver().findElement(By.xpath(btn_ViewOrder)).isDisplayed()){
		 log("View Order button is Not Displayed",LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed::View Order button is  Displayed");
		}
	 return this;
 }
 public HomePage validateQunatityHistoricalOrders(String key){
	 getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 String totalQuantity=getCommand().getDriver().findElement(By.xpath("//*[@id='totOrderQtyValue']")).getText();
	 System.out.println("Total Quantity============"+totalQuantity);
	 getCommand().storeValue(key,totalQuantity);
	 String txtQunatity=getCommand().getDriver().findElement(By.xpath("//*[@id='itemcntlink']/b")).getText();
	 String amountActiveOrder=txtQunatity.substring(5);
	 System.out.println("Quantity At Active Order:"+amountActiveOrder+"");
	 log("Total Quantity In Active Order:"+amountActiveOrder,LogType.STEP);
	 if(amountActiveOrder.equals(totalQuantity)){
		 log("Total Qunantity  Are Equal In Active Order Section:",LogType.STEP);

	 }else{
		 SoftAssertion.fail("Failed::Total Qunantity Are Not Equal In Active Order Section");
	 }
	 return this;
 }

 public HomePage validateTotalPriceHistoricalOrder(){
	//wait for load pop to be invisible
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	 getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	 String totalPrice=getCommand().getDriver().findElement(By.xpath("//span[@class='modper']")).getText();
	 System.out.println("Total Price============"+totalPrice);

	 String txtPrice=getCommand().getDriver().findElement(By.xpath("//*[@id='totallink']/b")).getText();
	 System.out.println("Total price At Active Order:"+txtPrice.substring(7));
	 if(totalPrice.equals(txtPrice.substring(7))){
		 log("Total Price  Are Equal In Active Order Section:"+txtPrice.substring(7),LogType.STEP);

	 }else{
		 SoftAssertion.fail("Failed::Total Price Are Not Equal In Active Order Section");
	 }
	 return this;
 }
 public HomePage verifyUpdatedQuantity(String quantity,String key){
	//wait for load pop to be invisible
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 int q=Integer.parseInt(quantity);
		 int tQuantity=Integer.parseInt((String)getCommand().retrieveValue(key));
		 int tUpdated=tQuantity+q;
		 System.out.println("Update Quantity======="+tUpdated);
		 getCommand().storeValue(key,""+tUpdated);
		 String txtQunatity=getCommand().getDriver().findElement(By.xpath("//*[@id='itemcntlink']/b")).getText();
		 System.out.println("Text In Active Order====="+txtQunatity);
		 String amountActiveOrder=txtQunatity.substring(5);
		 System.out.println("Quantity At Active Order:"+amountActiveOrder+"");
		 log("Total Quantity In Active Order:"+amountActiveOrder,LogType.STEP);
		 if(amountActiveOrder.contains(""+tUpdated)){
			 log("Total Qunantity  Are Equal In Active Order Section:",LogType.STEP);

		 }else{
			 SoftAssertion.fail("Failed::Total Qunantity Are Not Equal In Active Order Section");
		 }
		 return this;

 }
 public HomePage enterMultipleQuantity(){
	//wait for load pop to be invisible
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	 /*  for(int i=0;i<upcNumber.size();i++){
		getCommand().waitForTargetPresent(txt_Quantity.replace("<#>", upcNumber.get(i)));
		log("Enter Quantity For The Item("+upcNumber.get(i)+") is:"+itemQuantity,LogType.STEP);
		 getCommand().clear(txt_Quantity.replace("<#>", upcNumber.get(i))).sendKeys(txt_Quantity.replace("<#>", upcNumber.get(i)),itemQuantity.get(i));

		}*/
	   List<WebElement> listUPC=getCommand().getDriver().findElements(By.xpath("//*[contains(@id,'CS_syscoGridColumnEditableQuantityFormatter')]"));
		for(WebElement ele:listUPC){
			//getCommand().waitForTargetPresent(txt_Quantity.replace("<#>",ele.getText()));
			//log("Enter Quantity For The Item("+ele.getText()+") is:"+itemQuantity,LogType.STEP);
			 //getCommand().clear(txt_Quantity.replace("<#>", ele.getText())).sendKeys(txt_Quantity.replace("<#>", ele.getText()),"2");
			 ele.sendKeys(RandomStringUtils.randomNumeric(1));
		}
		return this;

	}

	public HomePage moveToMenuAnalysis(){
		getCommand().waitForTargetPresent(menu_MenuAnalysis);
		if(getCommand().isTargetPresent(menu_MenuAnalysis)){
			log("Navigate to Menu Analysis Home page",LogType.STEP);
			getCommand().click(menu_MenuAnalysis);
		}
		return this;
	}
	public HomePage validateSUPCInList(String[] upcs){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		for(int i=0;i<upcs.length;i++){
			String path="//*[@id='"+upcs[i].trim()+"-CS']/td[19]";
		getCommand().scrollTo(txt_SUPCNumber.replace("<#>",upcs[i]));
		int size=getCommand().getDriver().findElements(By.xpath(path)).size();
		if(size!=0){
			log(upcs[i]+" Is Present In List",LogType.STEP);
		}else{
			SoftAssertion.fail(upcs[i]+" Is Not Present In List");
		}
		}
		return this;
	}

	public HomePage updateOutOfStockDB(String key,String upcNumber){
		new SupportFunctions().updateData("update esednsv0 set nshe32='NNNNNYNNNNNNNNYNNNNNNNNNNNNNNNNN' WHERE NSEPO# ='    "+getCommand().retrieveValue(key)+"' AND NSITEM='  "+upcNumber+"'");
		return this;
	}
	public HomePage updateSubstituteItem(String key,String upcNumber){
		new SupportFunctions().updateData(" update esednsv0 set nshe32='NNNNNYNNNNNNNNYNNNNNNNNNNNNNNNNN' WHERE NSEPO# ='    "+getCommand().retrieveValue(key)+"' AND NSITEM='  "+upcNumber+"'");
		return this;
	}
	public HomePage orderToDeliveredStatus(String key){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		String strActualOrderNumber=getCommand().getDriver().findElement(By.xpath("(//*[@id='"+(String)getCommand().retrieveValue(key)+"'])")).getAttribute("title");
		//String strActualOrderNumber=getCommand().
		System.out.println("Actual Order number==="+strActualOrderNumber.trim());
		System.out.println("update esohnttf set ntorst ='C' WHERE NTornz ='"+strActualOrderNumber.trim()+"'");
		new SupportFunctions().updateData("update esohnttf set ntorst ='C' WHERE NTornz ='"+strActualOrderNumber.trim()+"'");
		log("Order number: "+strActualOrderNumber+" moved to delivered status",LogType.STEP);
		return this;
	}

	public HomePage validateConfirmedItem(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		System.out.println("Started Confirmed Stock");
		if(getCommand().isTargetPresent(txt_Confirmed)){
			System.out.println("passed Confirmed");
			log("Confirmed Item Are  Validated",LogType.STEP);
		}else{
			SoftAssertion.fail("Confirmed Items Are Not Validated");
		}
		return this;
	}
	public HomePage validateOutOfStock(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		System.out.println("Started Out Of Stock");
		if(getCommand().isTargetPresent(txt_OutOfStock)){
			System.out.println("passed Out Of Stock");
			log("Out Of Stock Item Is Present",LogType.STEP);
		}else{
			SoftAssertion.fail("Out Of Stock Item Is Not Present");
		}
		return this;
	}
	public HomePage connectToUrl(String url){

		log("Go to Url : " + url,LogType.STEP);
		getCommand().goTo(url);

		return this;
	}
  public HomePage clickOnSUPCVerifyInventory(String SUPC){
	  getCommand().waitFor(4);
		log("Click on SUPC:"+SUPC,LogType.STEP);
		getCommand().waitForTargetPresent(link_SUPC.replace("<#>",SUPC));
		getCommand().click(link_SUPC.replace("<#>",SUPC));
		getCommand().getDriver().manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='ui-tooltip-0-content']")).isDisplayed()){
			log("Inventory pop up is displayed",LogType.STEP);
			String invValue=getCommand().getDriver().findElement(By.xpath("//*[@id='manusubAvailableQty']")).getText();
			log("Inventory value :"+invValue,LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::Inventory pop up is not displayed");
		}
		return this;
	}
public HomePage changePopupDelDate()
	{
		log("Select Delivery Dates Range In Next 7 Days ",LogType.STEP);
		getCommand().isTargetPresent(date_deliveryDate);
		getCommand().click(date_deliveryDate);
		 DateFormat df = new SimpleDateFormat("dd/MM/yy");
		 Date dateobj = new Date();

		 int DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
			String prevDate = dateFormat.format(date.getTime() - (DAY_IN_MILLIS)*3);
			String currDate = dateFormat.format(date.getTime());
			String nextDate = dateFormat.format(date.getTime() +((DAY_IN_MILLIS)*7));

			String setDate[]=nextDate.split("/");
			String setCurDate[]=currDate.split("/");
			String curMon=setCurDate[1];
			String endDate=getCommand().getDriver().findElement(By.xpath("//*[@id='orderSummaryReportEndDate']")).getAttribute("value").toString();
			String cal_date[]=endDate.split("/");

			int cal_month=Integer.parseInt(cal_date[0]);
			int cal_day=Integer.parseInt(cal_date[1]);
			String nextMon=setDate[1];
			int next_date=Integer.parseInt(nextMon);
			int cur_date=Integer.parseInt(curMon);
			String setDay1=setDate[0];
			String setDay=setDate[0];
			if(setDay1.equals("01")) setDay="1"; else if(setDay1.equals("02")) setDay="2"; else if(setDay1.equals("03")) setDay="3"; else if(setDay1.equals("04")) setDay="4";
			else if(setDay1.equals("05")) setDay="5"; else if(setDay1.equals("06")) setDay="6"; else if(setDay1.equals("07")) setDay="7"; else if(setDay1.equals("08")) setDay="8"; else if(setDay1.equals("09")) setDay="9";

			getCommand().getDriver().findElement(By.xpath("//*[@id='orderSummaryReportEndDate']")).click();
			if(cal_month==next_date)
			{
				getCommand().isTargetPresent(date_deliveryDate);
				getCommand().isTargetPresent(popup_datePicker);

					WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));
					  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));
					  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

					  for (WebElement cell: columns){
					   //Select 7th Date
					   if (cell.getText().equals(setDay)){
					   cell.findElement(By.linkText(setDay)).click();
					   break;
					   }
					  }
			}
			else if(cal_month<next_date)
			{
				getCommand().isTargetPresent(date_deliveryDate);
				getCommand().isTargetPresent(popup_datePicker);
				getCommand().isTargetPresent(popup_NextMon);
				getCommand().click(popup_NextMon);

				WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));
				  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));
				  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

				  for (WebElement cell: columns){
				   //Select 7th Date
				   if (cell.getText().equals(setDay)){
				   cell.findElement(By.linkText(setDay)).click();
				   break;
				   }
				  }
			}

		 return this;
	}
	public HomePage changePopupSubDate()
	{
		log("Select Submitted Date Range Within Previous 7 Days ",LogType.STEP);
		getCommand().isTargetPresent(date_submittedDate);
		getCommand().getDriver().findElement(By.xpath("//*[@id='orderSummaryReportStartDate']")).click();
		 DateFormat df = new SimpleDateFormat("dd/MM/yy");
		 Date dateobj = new Date();
		 System.out.println(df.format(dateobj));
		 int DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
			String prevDate = dateFormat.format(date.getTime() - (DAY_IN_MILLIS)*7);
			String currDate = dateFormat.format(date.getTime());
			String nextDate = dateFormat.format(date.getTime() +((DAY_IN_MILLIS)*2+ DAY_IN_MILLIS));
			String setDate[]=prevDate.split("/");
			String setCurDate[]=currDate.split("/");
			String curMon=setCurDate[1];
			String endDate=getCommand().getDriver().findElement(By.xpath("//*[@id='orderSummaryReportEndDate']")).getAttribute("value").toString();
			String cal_date[]=endDate.split("/");

			int cal_month=Integer.parseInt(cal_date[0]);
			int cal_day=Integer.parseInt(cal_date[1]);
			String prevMon=setDate[1];
			int prev_date=Integer.parseInt(prevMon);
			int cur_date=Integer.parseInt(curMon);
			String setDay1=setDate[0];
			String setDay=setDate[0];
			if(setDay1.equals("01")) setDay="1"; else if(setDay1.equals("02")) setDay="2"; else if(setDay1.equals("03")) setDay="3"; else if(setDay1.equals("04")) setDay="4";
			else if(setDay1.equals("05")) setDay="5"; else if(setDay1.equals("06")) setDay="6"; else if(setDay1.equals("07")) setDay="7"; else if(setDay1.equals("08")) setDay="8"; else if(setDay1.equals("09")) setDay="9";

				if(cal_month==prev_date)
				{
					getCommand().isTargetPresent(date_submittedDate);
					getCommand().isTargetPresent(popup_datePicker);

						WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));
						  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));
						  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

						  for (WebElement cell: columns){
						   //Select date range within past 7 days
						   if (cell.getText().equals(setDay)){
						   cell.findElement(By.linkText(setDay)).click();
						   break;
						   }
						  }
				}
				else if(cal_month>prev_date)
				{
					getCommand().isTargetPresent(date_submittedDate);
					getCommand().isTargetPresent(popup_datePicker);
					getCommand().isTargetPresent(popup_PrevMon);
					getCommand().click(popup_PrevMon);

					WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));
					  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));
					  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

					  for (WebElement cell: columns){
					   //Select date range within past 7 days
					   if (cell.getText().equals(setDay)){
					   cell.findElement(By.linkText(setDay)).click();
					   break;
					   }
					  }
				}
				return this;
	}
	public HomePage clickApply()
	{
		getCommand().isTargetPresent(btn_summaryReport);
		log("Click on Apply  ",LogType.STEP);
		getCommand().click(btn_summaryReport);
		return this;
	}
	public HomePage clickReset()
	{
		getCommand().waitForTargetVisible(btn_resetReport);
		log("Click on Reset  ",LogType.STEP);
		getCommand().click(btn_resetReport);
		return this;
	}
	public HomePage validateDefaultDates(){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String startDate=getCommand().getDriver().findElement(By.xpath("//*[@id='orderSummaryReportStartDate']")).getAttribute("value").toString();
		String endDate=getCommand().getDriver().findElement(By.xpath("//*[@id='orderSummaryReportEndDate']")).getAttribute("value").toString();

		if(startDate.equals(endDate)){
			log("Default Dates Are Displayed on Reset",LogType.STEP);
			}else{
				SoftAssertion.fail("Failed::Default Dates Are Not Displayed");
			}
		return this;
	}
	public HomePage verifyCustomerInOrderSummaryReport(String cName){
		getCommand().waitForTargetVisible(summary_Report);
		getCommand().waitForTargetPresent(txt_CustomerOrder.replace("<#>", cName));
		if(getCommand().isTargetPresent(txt_CustomerOrder.replace("<#>", cName))){
			log("Order Summary Report For the Selected Customer Is Displayed",LogType.STEP);
			}else{
				SoftAssertion.fail("Failed::Order Summary Report For the Selected Customer Not Displayed");
			}
		return this;
	}

	public HomePage validateOrderStatus(){
		 getCommand().getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		if(getCommand().getDriver().findElement(By.xpath("//*[@title='Open']")).getText().equals("Open") &
				getCommand().getDriver().findElement(By.xpath("//*[@title='Submitted']")).getText().equals("Submitted") &
				getCommand().getDriver().findElement(By.xpath("//*[@title='Canceled']")).getText().equals("Canceled")){
			log("Report Has Following Order Status Submitted, Open And Cancelled",LogType.STEP);
			}else{
				SoftAssertion.fail("Failed:Report Doesn't Have Following Order Status Submitted, Open And Cancelled");
			}
		return this;
	}

	public HomePage iteminsearchbox() {
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));

		getCommand().isTargetPresent(txt_Search);
		getCommand().sendKeys(txt_Search, "1024231");
		getCommand().click(btn_search);
		getCommand().waitFor(5);
		getCommand().sendKeys(enterQty, "2");
	return this;
	}

	public HomePage iteminsearchbox1( String enteritemnum, String quantity ) {
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));

	getCommand().isTargetPresent(txt_Search);
	log("Enter itemname " + enteritemnum,LogType.STEP);
	getCommand().sendKeys(txt_Search, enteritemnum);
	getCommand().click(btn_search);
	getCommand().waitFor(5);
	getCommand().waitForTargetPresent(txt_Quantity.replace("<#>", enteritemnum));
	if(getCommand().isTargetPresent(txt_Quantity.replace("<#>", enteritemnum)));
	getCommand().sendKeys(txt_Quantity.replace("<#>",enteritemnum),quantity);
	//getCommand().sendKeys(enterQty,"2");
	return this;
	}

	public HomePage CSRhandprice( String enteritemnumber) throws AWTException {
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));

		getCommand().isTargetPresent(txt_Search);
		//getCommand().sendKeys(txt_Search, "4045415");
		getCommand().sendKeys(txt_Search, enteritemnumber);
		getCommand().click(btn_search);
		getCommand().waitFor(30);
		getCommand().click(currentprice1.replace("<#>", enteritemnumber));
		String abd=getCommand().getAttributeValue(currentprice1.replace("<#>", enteritemnumber), "value");
		System.out.println("old"+abd);
		Robot rb =new Robot();
		rb.keyPress(KeyEvent.VK_BACK_SPACE);
		rb.keyRelease(KeyEvent.VK_BACK_SPACE);
		getCommand().sendKeys(currentprice1.replace("<#>", enteritemnumber),"P1");
		getCommand().waitFor(5);
		rb.keyPress(KeyEvent.VK_TAB);
	   rb.keyRelease(KeyEvent.VK_TAB);
	   getCommand().waitFor(3);
	   String abd1 =getCommand().getAttributeValue(currentprice1.replace("<#>", enteritemnumber), "value");
	   getCommand().storeValue("sub1", abd1);
		System.out.println("aaff"+abd1);
		getCommand().waitFor(5);
		if(abd.equals(abd1))
		{
			SoftAssertion.fail("Failed:Price is not changed as expected");
		}
		else
		{
			getCommand().click(enterQty1.replace("<#>", enteritemnumber));
			getCommand().sendKeys(enterQty1.replace("<#>", enteritemnumber),"2");
		}
		return this;



	}
	public HomePage clickOnESysco(){
		getCommand().waitFor(3);
		(new SupportFunctions()).waitForStatic(3);
		getCommand().getDriver().switchTo().frame("botFrame");
		getCommand().waitForTargetVisible(btn_ESysco);
		if(getCommand().isTargetPresent(btn_ESysco)){
			log("Click on Esysco button",LogType.STEP);
			(new SupportFunctions()).waitForStatic(3);
			getCommand().click(btn_ESysco);
		}
		return this;
	}

	public HomePage clickOnEsyscoStartNewOrder(){
		try{
		getCommand().getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement element = getCommand().getDriver().findElement(By.xpath("//input[@value='Start New Order']"));
		log("Click on esysco start new order",LogType.STEP);
		element.click();
		}catch(NoSuchElementException e){
			System.out.println("Exception 1");
			getCommand().getDriver().switchTo().frame("topFrame");
			WebElement element = getCommand().getDriver().findElement(By.xpath("//input[@value='Start New Order']"));
			log("Click on esysco start new order",LogType.STEP);
			element.click();
		}catch(Exception e){
			System.out.println("Exception 2");
			getCommand().getDriver().switchTo().frame("botFrame");
			WebElement element = getCommand().getDriver().findElement(By.xpath("//input[@value='Start New Order']"));
			log("Click on esysco start new order",LogType.STEP);
			element.click();
		}
		return this;
	}
	public HomePage enterEsyscoOrderName(String orderName){
		getCommand().waitFor(3);
		System.out.println("Number of windows=="+getCommand().getDriver().getWindowHandles().size());

		Set <String> set = getCommand().getDriver().getWindowHandles();
		  Iterator<String> it = set.iterator();
		  String parentWindowId = it.next();
		  System.out.println("Parent window id=="+parentWindowId);
		  String childWindowId = it.next();
		  System.out.println("Child window id=="+childWindowId);
		  getCommand().getDriver().switchTo().window(childWindowId);
		  System.out.println(getCommand().getDriver().getTitle());
		  getCommand().waitForTargetVisible(txt_EsyscoOrderName);
		 log("Enter the Order name: "+orderName,LogType.STEP);
			getCommand().waitFor(10);
		getCommand().sendKeys(txt_EsyscoOrderName, orderName);
		log("Click on update button",LogType.STEP);
		getCommand().waitForTargetVisible(btn_Update);
		getCommand().click(btn_Update);
		getCommand().getDriver().switchTo().window(parentWindowId);
		return this;
	}
	public HomePage eSyscoClickOnOrderGuide(String orderType,String subType){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		log("Click on order guide link",LogType.STEP);
		WebDriver driver=getCommand().getDriver();
		driver.switchTo().frame("botFrame");
		driver.switchTo().frame("mainFrame");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.linkText(orderType)).click();
		driver.switchTo().frame("botFrame");
		driver.switchTo().frame("mainFrame");
		log("Click on order guide BD031",LogType.STEP);
		driver.findElement(By.partialLinkText(subType)).click();
		driver.switchTo().defaultContent();

		return this;
	}
	public HomePage eSyscoEnterQuantity(String strQunatity){

		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		WebDriver driver=getCommand().getDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.switchTo().frame("botFrame");
		driver.switchTo().frame("mainFrame");
		log("Enter Quantity :"+strQunatity,LogType.STEP);
		getCommand().waitFor(7);
		driver.findElement(By.xpath("//input[@onkeypress='return handleKeyPress(this, event, 0 )']")).sendKeys(strQunatity);

		Actions action1 = new Actions(driver);
		WebElement element1 = getCommand().getDriver().findElement(By.xpath("//input[@value='Add/Save Items to Order']"));
		action1.moveToElement(element1).perform();
		getCommand().waitFor(7);
		action1.click();
		action1.perform();
		driver.switchTo().defaultContent();
		return this;

	}
  public HomePage eSyscoQuickEntryOrder(String SUPC,String quantity,String splitQuantity){

		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		WebDriver driver=getCommand().getDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.switchTo().frame("botFrame");
		driver.switchTo().frame("mainFrame");
		log("Enter Item  :"+SUPC,LogType.STEP);
		driver.findElement(By.xpath("//input[@name='SUPC_1']")).sendKeys(SUPC);
		log("Enter Qunatity  :"+quantity,LogType.STEP);
		driver.findElement(By.xpath("//input[@name='CASE_1']")).sendKeys(quantity);


		log("Enter split  Qunatity  :"+quantity,LogType.STEP);
		driver.findElement(By.xpath("//input[@name='SPLIT_1']")).sendKeys(splitQuantity);


		Actions action1 = new Actions(driver);
		WebElement element1 = getCommand().getDriver().findElement(By.xpath("//input[@value='Add to Order']"));
		action1.moveToElement(element1).perform();
		action1.click();
		action1.perform();
		driver.switchTo().defaultContent();
		return this;

	}
  public HomePage clickOnReviewOrder(){

		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		WebDriver driver=getCommand().getDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		log("Click on review order button:",LogType.STEP);
		driver.switchTo().frame("botFrame");
		driver.switchTo().frame("midFrame");
		WebElement element = driver.findElement (By.xpath ("//a/img[@src='images/ReviewOrder.gif']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , element);

		driver.switchTo().defaultContent();
		return this;

	}
   public HomePage eSyscoClickonSubmitButton() throws IOException{
	  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		WebDriver driver=getCommand().getDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		log("Click on submit button:",LogType.STEP);
		driver.switchTo().frame("botFrame");
		driver.switchTo().frame("mainFrame");
		try{
		driver.findElement (By.xpath ("//a/b")).click();
		log("Click on ok button:",LogType.STEP);
		getCommand().waitFor(5);
		 Runtime.getRuntime().exec(TestProperties.getProperties("autoit.path")+"esyscoFirefox.exe");
		}
		catch(Exception e){
			System.out.println("Exception found due to windows pop up!!Please check the windows poup title");
		}
	  return this;
  }

   public HomePage entercustomerMA( String Customer)

	{
		if(getCommand().isTargetPresent(cust_search))
		{

			getCommand().waitFor(5);
			log("Enter Customer " + Customer,LogType.STEP);
			getCommand().sendKeys(cust_search, Customer);
			
		}

		return this;
	}

	public HomePage selectCustomerMA( )

	{
		getCommand().waitFor(5);
		if(getCommand().isTargetPresent(cust_select))

		{

			getCommand().click(cust_select);

		}
		return this;
	}
	public HomePage iteminsearchbox2( String itemname)
	{
		getCommand().waitFor(5);
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		
		getCommand().isTargetPresent(txt_Search);
		log("Enter itemname " + itemname,LogType.STEP);
		getCommand().sendKeys(txt_Search, itemname);
		getCommand().click(btn_search);
		getCommand().waitFor(10);
		
		return this;
	}
  public HomePage enterItemInSearchBox(String itemType) throws AWTException{
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		WebDriver driver=getCommand().getDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	 log("Enter item type :"+itemType,LogType.STEP);
	 driver.findElement(By.xpath("//input[@name='SEARCHSTRING1']")).sendKeys(itemType);
	   Robot obj1 = new Robot();
		System.out.println("robot");
		obj1.keyPress(KeyEvent.VK_ENTER);
		obj1.keyRelease(KeyEvent.VK_ENTER);
		return this;
	}
	/*public HomePage eSyscoEnterItem(String strQunatity){

		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));

		getCommand().isTargetPresent(txt_Search);
		log("Enter itemname " + itemname,LogType.STEP);
		getCommand().sendKeys(txt_Search, itemname);
		getCommand().click(btn_search);
		getCommand().waitFor(10);

		return this;
	}*/
	public HomePage additemtoList()
	{
		getCommand().waitFor(5);

		getCommand().click(lst_chcbx);
		getCommand().waitFor(2);
		getCommand().click(add_list);

		getCommand().waitFor(4);
		String listnum2=(String) getCommand().retrieveValue("listnum1");

		System.out.println("listnum2" + listnum2);

		getCommand().isTargetPresent(lst_num1.replace("<#>",listnum2));

		getCommand().click(lst_num1.replace("<#>", listnum2));

		getCommand().waitFor(5);
		getCommand().click(cnfrm_lst);


		return this;
	}
	public HomePage iteminsearchbox3( String entersupc)
	{
      (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		
		getCommand().isTargetPresent(txt_Search);
		log("Enter itemname " + entersupc,LogType.STEP);
		getCommand().sendKeys(txt_Search, entersupc);
		
		getCommand().storeValue("national", entersupc);
		getCommand().click(btn_search);
		
		
       return this;
	}
	/*public HomePage clickOnItemTab(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));

		getCommand().isTargetPresent(txt_Search);
		log("Enter itemname " + entersupc,LogType.STEP);
		getCommand().sendKeys(txt_Search, entersupc);

		getCommand().storeValue("national", entersupc);
		getCommand().click(btn_search);

		return this;
	}*/

	public HomePage nationalcoreitems()
	{
		getCommand().waitFor(5);
		String n3=(String) getCommand().retrieveValue("national");
		String n4= n3+"-CS_productName";
		System.out.println("n3"+ n3);
		System.out.println("n4"+n4);
		getCommand().waitForTargetVisible(nationalcore.replace("<#>", n4.trim()));
		getCommand().isTargetPresent(nationalcore.replace("<#>", n4.trim()));
		String n1=getCommand().getAttributeValue(nationalcore.replace("<#>", n4.trim()),"style");
		System.out.println("style"+ n1);
		String n5=("font-size: 12px; font-weight: bold;");
		if(n1.equalsIgnoreCase(n5))
		{
			log("It's an national core item",LogType.STEP);
		}
		else
		{
			SoftAssertion.fail("Failed:Its' not an national core item ");
		}
		return this;
	}
public HomePage close(){
	(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitFor(5);
		getCommand().isTargetPresent(close);
		getCommand().click(close);
		getCommand().isTargetPresent(close1);
		getCommand().click(close1);
		getCommand().waitFor(5);
		return this;
	}

public HomePage iteminsearchbox4(String enteritemnum, String orderqty)
{
	(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	getCommand().waitForTargetPresent(txt_Quantity.replace("<#>", enteritemnum));
	if(getCommand().isTargetPresent(txt_Quantity.replace("<#>", enteritemnum)));
	getCommand().sendKeys(txt_Quantity.replace("<#>",enteritemnum),orderqty);
	return this;
}

public HomePage ordersummaryMAuser()

{
	getCommand().getDriver().findElement(By.partialLinkText("Reports"));

	if(getCommand().isTargetPresent(osrma));
	{
		getCommand().click(reportsma);
	}
	(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	getCommand().getDriver().findElement(By.xpath("//*[@id='mnnav']/ul/li[11]/a")).click();
	getCommand().getDriver().findElement(By.xpath("//*[@id='orderSummaryReportLink2']")).click();
	
	return this;

}
public HomePage validateReportMAuser(){
	(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	getCommand().click(materritory);
	getCommand().waitFor(5);
	return this;
}
public HomePage PasswordChange()
{
	(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	getCommand().waitFor(3);
	(new SupportFunctions()).waitForStatic(3);
	getCommand().getDriver().switchTo().frame("topFrame");
	if(getCommand().isTargetPresent(changePassword)){
		getCommand().click(changePassword);
		getCommand().waitFor(10);
	}
	return this;

}
public HomePage activeordersectionverification()
{
	getCommand().waitFor(5);
	String txtPrice=getCommand().getDriver().findElement(By.xpath("//*[@id='totallink']/b")).getText();

	 String amountActiveOrder1=txtPrice.substring(7);
	 System.out.println(amountActiveOrder1);
	String txtQunatity=getCommand().getDriver().findElement(By.xpath("//*[@id='itemcntlink']/b")).getText();
	String amountActiveOrderQty=txtQunatity.substring(5);
	 System.out.println(amountActiveOrderQty);
	String txtPrice1=getCommand().getDriver().findElement(By.xpath("//*[@id='blk2']/span[5]/span")).getText();
	System.out.println(txtPrice1);
	String txtQunatity2=getCommand().getDriver().findElement(By.xpath("//*[@id='totOrderQtyValue']")).getText();
	System.out.println(txtQunatity2);

	if(txtPrice1.equalsIgnoreCase(amountActiveOrder1))
	{
		log("Estimated order total is matching in both active order section and view orders page",LogType.STEP);
	}
	else
	{
		SoftAssertion.fail("Estimated order total is NOT matching in both active order section and view orders page");
	}

	if(txtQunatity2.equalsIgnoreCase(amountActiveOrderQty))
	{
		log("Order Qty is matching in both active order section and view orders page",LogType.STEP);
	}
	else
	{
		SoftAssertion.fail("Order Qty is NOT matching in both active order section and view orders page");
	}

	return this;
 }

/* 
 * Silver search for sprint Item Search 
 */
public HomePage searchOnPrductDescription (String appupcName,String xlItemDescription){
	//wait for load pop to be invisible
	  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	  //enterUPCInSearchBox(appupcName);
	//  getCommand().getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  String path="//a[@id='"+appupcName.trim()+"-CS_productName']";
	  getCommand().waitFor(3);
	  String itemDescriptionDB="select KET255 from ESCAKETF where trim(KEMITM)= '"+appupcName+"'" ;
		System.out.println(itemDescriptionDB);
		ArrayList item_Description_DB=(new SupportFunctions()).retrieveData(itemDescriptionDB);
		System.out.println(item_Description_DB);
		ArrayList ItemNumDesDB=(ArrayList)(item_Description_DB.get(0));
		 String DB_Item_Des=ItemNumDesDB.get(0).toString();
	  String itemDescription=getCommand().getDriver().findElement(By.xpath(path)).getText().toString();
	 // if(itemDescription.trim().equals(xlItemDescription.trim()))
	  if(itemDescription.trim().equals(DB_Item_Des.trim()))
	  {
		  log("Verify whether CAKE product description is "+itemDescription+" getting displayed for the item "+appupcName+"  the items ",LogType.STEP); 
	  }
	  else
		{
			SoftAssertion.fail("Verify whether CAKE product description is  failed .Actual description is "+itemDescription);
		}

	  
	 return this;
  }
public HomePage searchOnPrductDescriptionInProductcard (String appupcName,String xlItemDescription){
	//wait for load pop to be invisible
	  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	  //enterUPCInSearchBox(appupcName);
	//  getCommand().getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  String path="//*[@id='divForProductName']";
	  getCommand().waitFor(3);
	  String itemDescription=getCommand().getDriver().findElement(By.xpath(path)).getText().toString();
	  String strDescription[]=itemDescription.split("-");
	  String itemDescriptionDB="select KET255 from ESCAKETF where trim(KEMITM)= '"+appupcName+"'" ;
		System.out.println(itemDescriptionDB);
		ArrayList item_Description_DB=(new SupportFunctions()).retrieveData(itemDescriptionDB);
		System.out.println(item_Description_DB);
		ArrayList ItemNumDesDB=(ArrayList)(item_Description_DB.get(0));
		 String DB_Item_Des=ItemNumDesDB.get(0).toString();
	  if(strDescription[0].trim().equals(DB_Item_Des.trim()))
	  {
		
		  log("Verify whether CAKE product description is "+strDescription[0]+" getting displayed for the item "+appupcName+"  ",LogType.STEP); 
	  }
	  else
		{
			SoftAssertion.fail("Verify whether CAKE product description is  failed .Actual description is "+itemDescription);
		}

	  
	 return this;
  }
public HomePage searchOnPrductDescriptionInQuickOrderEntry (String appupcName,String xlItemDescription){
	//wait for load pop to be invisible
	  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	  //enterUPCInSearchBox(appupcName);
	//  getCommand().getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  String path="//*[@id='"+appupcName+"']/td[2]";
	  getCommand().waitFor(3);
	  String itemDescription=getCommand().getDriver().findElement(By.xpath(path)).getText().toString();
	  String itemDescriptionDB="select KET255 from ESCAKETF where trim(KEMITM)= '"+appupcName+"'" ;
		System.out.println(itemDescriptionDB);
		ArrayList item_Description_DB=(new SupportFunctions()).retrieveData(itemDescriptionDB);
		System.out.println(item_Description_DB);
		ArrayList ItemNumDesDB=(ArrayList)(item_Description_DB.get(0));
		 String DB_Item_Des=ItemNumDesDB.get(0).toString();
	  if(itemDescription.trim().equals(DB_Item_Des.trim()))
	  {
		  log("Verify whether CAKE product description is "+itemDescription+" getting displayed for the item "+appupcName+"  the items ",LogType.STEP); 
	  }
	  else
		{
			SoftAssertion.fail("Verify whether CAKE product description is  failed .Actual description is "+itemDescription);
		}

	  
	 return this;
  }

public HomePage orderToDeliveredStatusDB(String key){
	(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	getCommand().getDriver().manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
	String strActualOrderNumber=(String)getCommand().retrieveValue(key);
	DateFormat df = new SimpleDateFormat("dd/MM/yy");
    Date dateobj = new Date();
    System.out.println(df.format(dateobj));
    int DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
	    Date date = new Date();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
	    String prevDate = dateFormat.format(date.getTime() - DAY_IN_MILLIS);
	//String strActualOrderNumber=getCommand().
	System.out.println("Actual Order number==="+strActualOrderNumber.trim());
	System.out.println("update esohnttf set ntorst ='C' WHERE trim(NTEPO#) ='"+strActualOrderNumber.trim()+"'");
	new SupportFunctions().updateData("update esohnttf set ntorst ='C' WHERE trim(NTEPO#) ='"+strActualOrderNumber.trim()+"'");
	new SupportFunctions().updateData("update esohnttf set ntdeld =" + prevDate + "  WHERE trim(NTEPO#) ='"+strActualOrderNumber.trim()+"'");
	log("Order number: "+strActualOrderNumber+" moved to delivered status",LogType.STEP);
	return this;
}

public HomePage enterAnyBrandInSearchBox(String searchbrandName){
	(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	if(getCommand().isTargetPresent(txt_Search)){
		//Add [] to brand name
		String strBrandName="["+searchbrandName.trim()+"]";
		System.out.println("strBrandName===="+strBrandName);
		log("Enter Brand name In Search Box:"+strBrandName,LogType.STEP);
		getCommand().clear(txt_Search).sendKeys(txt_Search,strBrandName.trim());
	}
	return this;
}
public HomePage verifySearchValidBrandName(String brandNameDB)
{
	//wait for load pop to be invisible
	  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	  getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String brandName=(String)getCommand().retrieveValue(brandNameDB);
	  String path="//*[contains(text(),'"+brandName.trim()+"')]";
	  
		if(getCommand().getDriver().findElements(By.xpath(path)).isEmpty()){
		 
		 SoftAssertion.fail("Failed::InValid Brand Name:: '"+brandName +"'Is Displayed");
			
	   }
		else{
			log("In Valid Brand Name:: '"+brandName +"'Is Displayed",LogType.STEP);
	  }
	  return this;
	
	
}
public HomePage selectOnPrductDescriptionFromDB (String appupcName,String key){
	
	    String itemDescriptionDB="select KET255 from ESCAKETF where trim(KEMITM)= '"+appupcName+"'" ;
		System.out.println(itemDescriptionDB);
		ArrayList item_Description_DB=(new SupportFunctions()).retrieveData(itemDescriptionDB);
		System.out.println(item_Description_DB);
		ArrayList ItemNumDesDB=(ArrayList)(item_Description_DB.get(0));
		String DB_Item_Des=ItemNumDesDB.get(0).toString();
		if(!(DB_Item_Des.equals(null))||(!(DB_Item_Des.equals("")))){
			getCommand().storeValue(key,DB_Item_Des);
		}
		else
		{
			 SoftAssertion.fail("Selected item is not in DB");
		}
	  
	 return this;
  }
//*[contains(text(),'andes')]

public HomePage enterAnyCakeDescriptiondInSearchBox(String tcID) {
	String strDescription=(String)getCommand().retrieveValue(tcID);
	System.out.println("strDescription++++++++++++++"+strDescription);
	(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	if(getCommand().isTargetPresent(txt_Search)){
		log("Enter CAKE description :"+strDescription,LogType.STEP);
		System.out.println("Brand Name====="+strDescription.trim().toLowerCase());
		getCommand().clear(txt_Search).sendKeys(txt_Search,strDescription.trim().toLowerCase());
	}
	return this;
}
//*[@id='4113650-CS']/td[16]/a/img

public HomePage checkImage(String UPC) {
	
	//String image_path="//a[contains(@href,'https://image.sysco.com/image-server/product/image/"+UPC.trim()+"/web/1.jpg')]";
	//https://image.sysco.com/image-server/product/image/0515494/web/1.jpg
	String image_path="//a[contains(@href,'"+UPC.trim()+"')]";
	getCommand().waitForTargetPresent(link_UPCImage.replace("<#>",image_path ));
	
	
		if(getCommand().isTargetPresent(link_UPCImage.replace("<#>",image_path )))
		{
			log("Verify  thumbnail image is getting displayed :"+UPC,LogType.STEP);
		}
		else{
			 SoftAssertion.fail("Verify  thumbnail image is not getting displayed  for the Item :"+UPC);
			
		}
	
	
	return this;
}
public HomePage checkImagenotPresent(String UPC) {
	
	//String image_path="//a[contains(@href,'https://image-dev.sysco.com/image-server/product/image/"+UPC.trim()+"/web/1.jpg')]";

	String image_path="//a[contains(@href,'"+UPC.trim()+"')]";
	
		if(getCommand().isTargetPresent(link_UPCImage.replace("<#>",image_path )))
		{
			 SoftAssertion.fail("Verify  thumbnail image is getting displayed ");
		}
		else{
			log("Verify  thumbnail image is not getting displayed  for the Item :"+UPC,LogType.STEP);
			
		}
	
	
	return this;
}
public HomePage clickOnImagePath(String UPC) {
	
	//String image_path="//a[contains(@href,'https://image-dev.sysco.com/image-server/product/image/"+UPC.trim()+"/web/1.jpg')]";

	String image_path="//a[contains(@href,'"+UPC.trim()+"')]";
	
		if(getCommand().isTargetPresent(link_UPCImage.replace("<#>",image_path )))
		{
			log("Click on the Image :",LogType.STEP);
			getCommand().click(link_UPCImage.replace("<#>",image_path ));
			log("Full size image of the product should  get displayed:",LogType.STEP);
			log("Click on the Image close button:"+UPC,LogType.STEP);
			getCommand().click(link_UPCImageClose);
			log("Close the image",LogType.STEP);
			
		}
		else{
			SoftAssertion.fail("Verify  thumbnail image is not  getting displayed ");
			
		}
	
	
	return this;
}
public HomePage checkImageInProductInfoWindow(String UPC) {
	
	//String image_path="//a[contains(@href,'https://image-dev.sysco.com/image-server/product/image/"+UPC.trim()+"/web/1.jpg')]";

	System.out.println("Product Window");
	     getCommand().waitForTargetPresent(link_productImage);
		if(getCommand().isTargetPresent(link_productImage ))
		{
			String styleVal=getCommand().getAttribute(link_productImage, "style").toString();	
			System.out.println("styleVal&&&&&&&"+styleVal);
			if(styleVal.contains(UPC))
			{
				log("Image is present of the item "+UPC+" in Product Window ",LogType.STEP);	
			}
			else{
				log("Image is not present of the item "+UPC+" in Product Window ",LogType.STEP);
			}
		}
		else{
			SoftAssertion.fail("Verify  thumbnail image is not  getting displayed ");
			
		}
	
	
	return this;
}
public HomePage checkMultipleImageInProductInfoWindow(String UPC) {
	
	//String image_path="//a[contains(@href,'https://image-dev.sysco.com/image-server/product/image/"+UPC.trim()+"/web/1.jpg')]";

	System.out.println("Product Window");
	     getCommand().waitForTargetPresent(img_linkNext);
		if(getCommand().isTargetPresent(img_linkNext ))
		{
			log("Multiple iImage is present for the item "+UPC+" in Product Window ",LogType.STEP);
			log("Click on next button  "+UPC+" in Product Window ",LogType.STEP);
			getCommand().click(img_linkNext);
			String styleVal=getCommand().getAttribute(link_productImage, "style").toString();	
			System.out.println("styleVal&&&&&&&"+styleVal);
			if(styleVal.contains(UPC))
			{
				log("Image is present of the item "+UPC+" in Product Window ",LogType.STEP);
				if(getCommand().isTargetPresent(img_linkNext ))
				{
					getCommand().click(img_linkNext);
					log("Click on next button  "+UPC+" in Product Window ",LogType.STEP);	
					String styleValSecond=getCommand().getAttribute(link_productImage, "style").toString();	
					System.out.println("styleVal&&&&&&&"+styleValSecond);
					if(styleValSecond.contains(UPC))
					{
						log("Image is present of the item "+UPC+" in Product Window ",LogType.STEP);
					}
					else{
						log("Image is not present of the item "+UPC+" in Product Window ",LogType.STEP);
					    }
				}
				if(getCommand().isTargetPresent(img_linkPrev))
				{
					log("Click on Prev button  "+UPC+" in Product Window ",LogType.STEP);
					getCommand().click(img_linkPrev);
					String styleValSecond=getCommand().getAttribute(link_productImage, "style").toString();	
					System.out.println("styleVal&&&&&&&"+styleValSecond);
					if(styleValSecond.contains(UPC))
					{
						log("Image is present of the item "+UPC+" in Product Window ",LogType.STEP);
					}
					else{
						log("Image is not present of the item "+UPC+" in Product Window ",LogType.STEP);
					    }	
				}
			}
			
			else{
				log("Image is not present of the item "+UPC+" in Product Window ",LogType.STEP);
			    }
			
		}
			//String styleVal=getCommand().getAttribute(link_productImage, "style").toString();	
			//System.out.println("styleVal&&&&&&&"+styleVal);
			/*if(styleVal.contains(UPC))
			{
				log("Image is present of the item "+UPC+" in Product Window ",LogType.STEP);	
			}
			else{
				log("Image is not present of the item "+UPC+" in Product Window ",LogType.STEP);
			    }
		}
		else{
			SoftAssertion.fail("Verify  thumbnail image is not  getting displayed ");
			
		    }*/
	
	
	return this;
}
public HomePage checkOMXMountainImage(String UPC) {
	
	String image_path="//*[@id='"+UPC.trim()+"-CS']/td[16]/img[contains(@src,'/no-image_360.png')]";
	//*[@id='"+UPC.trim()+"-CS']/td[16]/img[contains(@src,'/no-image_360.png')]
	
	
		if(getCommand().isTargetPresent(link_NoImage.replace("<#>",image_path )))
		{
			 log("Verify the standard OMX mountain image is getting displayed for item :"+UPC,LogType.STEP);
		}
		else{
			SoftAssertion.fail("Verify standard OMX mountain image  is not getting displayed");
			
		}
	
	
	return this;
}
}
