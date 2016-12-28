package com.components.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;

import com.components.repository.SiteRepository;
import com.iwaf.framework.TestProperties;
import com.iwaf.framework.components.SoftAssertion;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;

public class OrderPage extends SitePage{
	
	public static final Target btn_CreateNewOrder = new Target("btn_CreateNewOrder","//*[@id='createNewOrder' and @value='Create Order']",Target.XPATH);
	public static final Target btn_Add = new Target("btn_Add","//*[@id='validateSupcButton']",Target.XPATH);
	public static final Target btn_AddtoOrder = new Target("btn_AddtoOrder","//*[@id='addToOrderButton']",Target.XPATH);
	public static final Target btn_OrderReminderSubmit = new Target("btn_OrderReminderSubmit","//*[@id='orderReminderSubmitButton']",Target.XPATH);
	public static final Target btn_OrderCreationSucess = new Target("btn_OrderCreationSucess","//button[@type='button']",Target.XPATH);
	public static final Target btn_OrderOverview = new Target("btn_OrderOverview","//*[@id='ordersoverview']",Target.XPATH);
	public static final Target btn_CloseConfirmation = new Target("btn_CloseConfirmation","//*[@id='close']",Target.XPATH);
	public static final Target btn_ContinueNonCancelledItem=new Target("btn_ContinueNonCancelledItem","//*[@value='Continue']",Target.XPATH);

	//public static final Target btn_CreatNewOrderFromOrderPage=new Target("btn_CreatNewOrderFromOrderPage","//input[@id='createNewOrderButton']",Target.XPATH);
	public static final Target btn_CreatNewOrderFromOrderPage=new Target("btn_CreatNewOrderFromOrderPage","//input[@class='crtordbtnew basic']",Target.XPATH);
	public static final Target btn_addItemToOrder=new Target("btn_addItemToOrder","//select[@id='addProductsFrom']",Target.XPATH);
	public static final Target btn_Cancel=new Target("btn_Cancel","//*[@id='crtordbtndiv']/input[@class='cancelorderbtn cancelorderbtnforIE7 simplemodal-close']",Target.XPATH);
	public static final Target btn_DeliveryDate=new Target("btn_DeliveryDate","//*[@id='createNewOrderDiv']/div[2]/div[1]/span[3]/span[1]/span[2]/img",Target.XPATH);
	public static final Target btn_Import=new Target("btn_Import","//*[@id='importOrder']",Target.XPATH);
    public static final Target btn_Browser=new Target("btn_Browser","//*[@id='importOrderName']",Target.XPATH);
    public static final Target btn_ImportOrderDropDown=new Target("btn_ImportOrderDropDown","//*[@id='impOrderFormat']",Target.XPATH);
    public static final Target btn_Acknowledged=new Target("btn_Acknowledged","//*[@id='acknowledgeButton']",Target.XPATH);
    public static final Target btn_ImportOrder=new Target("btn_ImportOrder","//*[@id='importOrderBtn']",Target.XPATH);
    public static final Target btn_RejectOrder=new Target("btn_RejectOrder","//*[@id='rejectOrderButTop']",Target.XPATH);
    public static final Target btn_Continue=new Target("btn_Continue","//input[@id='qtyValidation' and @class='cancelbtn']",Target.XPATH);
    public static final Target btn_SubmitOrder = new Target("btn_SubmitOrder","//*[@id='chkOutBtn1']",Target.XPATH);
    public static final Target btn_ApproveOrder=new Target("btn_ApproveOrder","//*[@id='approveOrderButTop']",Target.XPATH);
    public static final Target btn_CancelOrder=new Target("btn_CancelOrder","//*[@id='cancelAddToOrder']",Target.XPATH);
    public static final Target btn_ViewOrder=new Target("btn_ViewOrder","//*[@id='viewActiveOrderBtn']", Target.XPATH);
    public static final Target btn_PrintOrder=new Target("btn_PrintOrder","//*[@id='printIconClick']", Target.XPATH);
    public static final Target btn_QuantityValidation=new Target("btn_QuantityValidation","//*[@id='qtyValidationDiv']", Target.XPATH);
	
	public static final Target txt_UPC = new Target("txt_UPC","//*[@id='supc']",Target.XPATH);
	public static final Target txt_CaseQty = new Target("txt_CaseQty","//*[@id='caseQty']",Target.XPATH);
	public static final Target txt_SplitQty = new Target("txt_CaseQty","//*[@id='splitQty']",Target.XPATH);
	public static final Target txt_OrderName = new Target("txt_OrderName","//*[@id='createdorderName']",Target.XPATH);
    public static final Target txt_ChangeQuantity=new Target("txt_ChangeQuantity","//*[contains(@id,'CS_syscoGridColumnEditableQuantityFormatter')]",Target.XPATH);
    public static final Target txt_DeleteOrder=new Target("txt_DeleteOrder","//*[@id='roCancelOrderLink']/b",Target.XPATH);
    public static final Target txt_SubmittedOrderStatus=new Target("txt_SubmittedOrderStatus","//*[@id='<#>']/td[17]",Target.XPATH);
    public static final Target txt_SubmittedOrderNumber=new Target("txt_SubmittedOrderNumber","//*[@id='<#>']",Target.XPATH);
    public static final Target txt_Status=new Target("txt_Status","//*[@id='<#>']/td[1]",Target.XPATH);
    public static final Target txt_Quantity=new Target("txt_Quantity","//*[@id='<#>_CASE']",Target.XPATH);
    public static final Target txt_SplitQuantity=new Target("txt_SplitQuantity","//*[@id='<#>']/td[5]",Target.XPATH);
    public static final Target txt_errorUPC=new Target("txt_errorUPC","//p[@id='emptySupcError']",Target.XPATH);
    public static final Target txt_Dynamic_Price = new Target("txt_Dynamic_Price","//*[contains(@id,'CS_currentprice')]",Target.XPATH);
    public static final Target lbl_Dynamic_Price1 = new Target("lbl_Dynamic_Price1","//*[@id='gbox_shouldBuyItemsGrid']//*[contains(@id,'-CS')]",Target.XPATH);
    public static final Target lbl_Dynamic_Price2 = new Target("lbl_Dynamic_Price2","//*[@id='gbox_quantityShouldIncreaseGrid']//*[contains(@id,'-CS')]",Target.XPATH);
    public static final Target txt_RejectMessage=new Target("txt_RejectMessage","//*[@id='pendingTextArea']",Target.XPATH);
    public static final Target txt_StatusInQuickOrder=new Target("txt_StatusInQuickOrder","//*[@id='<#>']/td[1]",Target.XPATH);
    public static final Target txt_QuantityInQuickOrderZero=new Target("txt_QuantityInQuickOrderZero","//*[@id='<#>']/td[4]",Target.XPATH);
    public static final Target txt_SplitQuantityInQuickOrdeNonZero=new Target("txt_SplitQuantityInQuickOrderNonZero","//*[@id='<#>_SPLIT']",Target.XPATH); 
    public static final Target txt_IvalidSplitStatus=new Target("txt_IvalidSplitStatus","//span[@class='gc-pcf']",Target.XPATH);
    public static final Target txt_Price=new Target("txt_Price","//input[@id='<#>-CS_currentprice']",Target.XPATH);
    public static final Target txt_PriceSubmitted=new Target("txt_PriceSubmitted","//*[@id='<#>-CS']/td[26]",Target.XPATH);
    
    public static final Target alert_OpenOrder=new Target("alert_OpenOrder","//*[@id='openOrdersTab_orderAlertsList']",Target.XPATH);
    public static final Target alert_SubmittedOrder=new Target("alert_SubmittedOrder","//*[@id='jqgh_submittedOrdersTab_orderAlertsList']",Target.XPATH);
    public static final Target alert_NonOpenOrder=new Target("alert_NonOpenOrder","//*[@id='jqgh_nonopenOrdersTab_orderAlertsList']",Target.XPATH);
	
	public static final Target pg_CreateOrder = new Target("pg_CreateOrder","//*[@id='createNewOrderDiv']/div[1]",Target.XPATH);
	public static final Target pg_OrderReminderPopup = new Target("pg_OrderReminderPopup","//*[@id='orderReminderModalInternal']/div[1]",Target.XPATH);
	public static final Target pg_QuickOrderEntryPopup = new Target("pg_QuickOrderEntryPopup","//*[@id='quickOrderEntryPopupButton']/div[1]",Target.XPATH);
	
	public static final Target lnk_Close = new Target("lnk_Close","//*[@id='clsLink']",Target.XPATH);
	public static final Target link_DeleteOrder=new Target("link_DeleteOrder","//a[@id='deleteOrderLink']",Target.XPATH);
    public static final Target link_DeleteSubmittedOrder=new Target("link_DeleteOneLineFromSubmittedOrder" ,"//a[@id='undefined']",Target.XPATH);
    public static final Target link_Cancel=new Target("link_Cancel" ,"//*[@id='importOrderCancellink_id']",Target.XPATH);
    public static final Target link_Delete=new Target("link_Delete" ,"//a[@onclick='javascript:deleteRow(\"<#>\");']",Target.XPATH);
    public static final Target grd_OpenOrderTab = new Target("grd_OpenOrderTab","//*[@id='gbox_openOrdersTab']",Target.XPATH);
	public static final Target grd_OrderListTab = new Target("grd_OrderListTab","//*[@id='gbox_existOrdersTab']",Target.XPATH);
	public static final Target lnk_ShippingCondition = new Target("lnk_ShippingCondition","//*[@id='shippingConditionTab']",Target.XPATH);
	
	public static final Target chk_saveSetting=new Target("chk_savesetting","//div[@class='checkbox-input-wrapper mobile-margin-top']",Target.XPATH);
	public static final Target chk_Item=new Target("chk_Item", "//*[@id='jqg_productSearchGrid_<#>-CS']", Target.XPATH);
	
	public static final Target order_Name=new Target("order_Name","//*[@id='createNewOrderDiv']/div[2]/div[1]/span[1]",Target.XPATH);
	public static final Target delivery_Date=new Target("delivery_Date","//*[@id='createNewOrderDiv']/div[2]/div[1]/span[3]/span[1]/span[1]",Target.XPATH);
	public static final Target add_ProductFrom=new Target("add_ProductFrom","//*[@id='createNewOrderDiv']/div[2]/div[2]/span",Target.XPATH);
	public static final Target po_Number=new Target("po_Number","//*[@id='createNewOrderDiv']/div[2]/div[1]/span[3]/span[2]/span[1]",Target.XPATH);
	public static final Target menu_ReviewAndSubmit = new Target("menu_ReviewandSubmit","//*[@id='navvbarrvsw']/div[4]",Target.XPATH);
	public static final Target tab_Order=new Target("tab_Order","//*[@id='orderTab']",Target.XPATH);
	public static final Target lst_ProductFrom = new Target("lst_ProductFrom","//*[@id='addItemToOrder']",Target.XPATH);
	public static final Target click_Outside = new Target("click_Outside","//*[@id='message1']",Target.XPATH);
	public static final Target alert_Column=new Target("alert_OpenOrder","//*[contains(text(),'Alert')]",Target.XPATH);
	public static final Target btn_Alert=new Target("btn_Alert","//img[@src='/OMAPX_r8.0.0.0/resources/images/warn.gif']",Target.XPATH);
	public static final Target box_Search=new Target("box_Search","//*[@id='srchTop']",Target.XPATH);
	
	public static final Target img_Calendar=new Target("img_Calendar","//*[@id='srchTop']",Target.XPATH);
	public static final Target shipdropdown =new Target("shipdropdown","//*[@id='shippingConditionSelect']",Target.XPATH);
	public static final Target shipdropdown2 =new Target("shipdropdown2","//option[@value='Z1']",Target.XPATH);
	public static final Target shipdropdown3 =new Target("shipdropdown3","//option[@value='Z8']",Target.XPATH);
	public static final Target refrencenum=new Target("refrencenum","//*[@id='ordno']/span[2]",Target.XPATH);
	public static final Target viewallrecentorders=new Target("viewallrecentorders","//*[@id='viewallsubmittedlink']",Target.XPATH);
	public static final Target refrencenum1=new Target("refrencenum1"," //*[@id='<#>']",Target.XPATH);
	public static final Target sort=new Target("sort","//*[@id='jqgh_submittedOrdersTab_documentName']/span/span[2]",Target.XPATH);
	public static final Target refresh=new Target("refresh","//*[@id='ordsumrefbtn']",Target.XPATH);
	public static final Target modifyorder=new Target("modifyorder","//*[@id='modifyBttnTopBttn']",Target.XPATH);
	//public static final Target submittedhp=new Target("submittedhp","//*[@id='4045415-CS']/td[26]",Target.XPATH);
	public static final Target submittedhp=new Target("submittedhp","//*[@id='<#>-CS']/td[26]",Target.XPATH);
	public static final Target acceptalert=new Target("acceptalert","//*[@id='modifyOrder']",Target.XPATH);
	//public static final Target currentprice4=new Target("currentprice4","//*[@id='4045415-CS_currentprice']",Target.XPATH);
	
	public static final Target currentprice4=new Target("currentprice4","//*[@id='<#>-CS_currentprice']",Target.XPATH);
	public static final Target ordergp= new Target("ordergp","//*[@id='tbOrderGP']",Target.XPATH);
	public static final Target ordergp1= new Target("ordergp1","//*[@id='tbOrderGP']",Target.XPATH);
	public static final Target ordergp2= new Target("ordergp2","//*[@id='tbOrderGPP']",Target.XPATH);
	
	public static final Target ordergpOSR1=new Target("ordergpOSR1","//*[@id='jqg50']/td[13]",Target.XPATH);
	public static final Target ordergpOSR2=new Target("ordergpOSR2","//*[@id='jqg50']/td[14]",Target.XPATH);
	
	public static final Target refrencenum2=new Target("refrencenum2"," //*[@id='<#>']/td[13]",Target.XPATH);
	public static final Target refrencenum3=new Target("refrencenum3"," //*[@id='<#>']/td[14]",Target.XPATH);
	public static final Target OSRrefresh= new Target("OSRrefresh","//*[@id='order-summary-report-toolbar-refresh2']",Target.XPATH);
	public static final Target option1 =new Target("option1","//option[@value='1']",Target.XPATH);
	public static final Target option2 =new Target("option2","//option[@value='2']",Target.XPATH);
	public static final Target option3 =new Target("option3","//option[@value='3']",Target.XPATH);
	public static final Target option4 =new Target("option4","//option[@value='4']",Target.XPATH);
	public static final Target option6 =new Target("option6","//option[@value='6']",Target.XPATH);
	public static final Target option5 =new Target("option6","//option[@value='5']",Target.XPATH);
	public static final Target orderdropdown =new Target("orderdropdown","//*[@id='addItemToOrder']",Target.XPATH);
	public static final Target QOE =new Target("QOE","//option[@value='Quick Order Entry']",Target.XPATH);
	public static final Target importlist=new Target("importlist","//*[@id='impOrderFormat']",Target.XPATH);
	
	public static final Target product_Model=new Target("product_Model","//*[@id='reminderModalOption2']",Target.XPATH);
	public static final Target txt_Item=new Target("txt_Item","//*[@id='<#>-CS']/td[4]",Target.XPATH);
	public static final Target img_TickMark=new Target("img_TickMark","//*[@id='<#>_CS_accept']/a/img",Target.XPATH);
	public static final Target btn_Close=new Target("btn_Close","(//span[text()='Close'])[2]",Target.XPATH);
	public static final Target img_CrossMark=new Target("img_CrossMark","//*[@id='<#>_CS_reject']/a/img",Target.XPATH);
	public static final Target btn_ContinueRemainder=new Target("btn_ContinueRemainder","//*[@id='reminder_continue']",Target.XPATH);
	public static final Target btn_ConfirmRemainder=new Target("btn_ConfirmRemainder","//*[@id='replaceItemConfirmButton']",Target.XPATH);
	public static final Target btn_OkAfterSubmit=new Target("btn_OkAfterSubmit","//span[contains(text(),'OK')]",Target.XPATH);
	
	
	public OrderPage(SiteRepository repository){
		super(repository);
	}
	
	public OrderPage atCreateOrderPage(){		
		
		getCommand().waitForTargetPresent(pg_CreateOrder);
		log("Create Order Pop up displayed",LogType.STEP);
		return this;
	}
	
	public OrderPage enterOrderDetails(String strOrderName,String strProductFrom){		
		Date dtNow = new Date();
		SimpleDateFormat sdfNow = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		String strNow = sdfNow.format(dtNow);
		
		if(getCommand().isTargetPresent(txt_OrderName)){
			//strOrderName =strOrderName + "_" + strNow;
			log("Enter Order Name " + strOrderName,LogType.STEP);	
			if(getCommand().isTargetPresent(grd_OrderListTab))
			{
			getCommand().waitForTargetPresent(grd_OrderListTab);
			}
			getCommand().clear(txt_OrderName);
			//WebElement wbElem = getCommand().getDriver().findElement(By.id("orderName"));
			//wbElem.sendKeys(Keys.CONTROL + "a");
			//wbElem.sendKeys(Keys.DELETE);
			
			getCommand().sendKeys(txt_OrderName, strOrderName);
		}
		if(getCommand().isTargetPresent(lst_ProductFrom)){

			log("Select Add Product From type " + strProductFrom,LogType.STEP);	
			getCommand().selectDropDown(lst_ProductFrom, strProductFrom);
		}
		if(getCommand().isTargetPresent(btn_CreateNewOrder)){

			log("Click on Create New Order",LogType.STEP);	
			getCommand().click(btn_CreateNewOrder);
		}
		return this;
	}
	
	public OrderPage atQuickOrderEntryPagePopUp(){		
		
		getCommand().waitForTargetPresent(pg_QuickOrderEntryPopup);
		log("Quick Order Entry Pop up displayed",LogType.STEP);
		return this;
	}
	
	public OrderPage enterQuickOrderEntryDetails(String strUPC, String strCaseQty, String strSplitQty){		
		
		if(getCommand().isTargetPresent(txt_UPC)){
			log("Enter Item UPC " + strUPC,LogType.STEP);	
			getCommand().sendKeys(txt_UPC, strUPC);
		}
		if(getCommand().isTargetPresent(txt_CaseQty)){

			log("Enter Case Quantity " + strCaseQty,LogType.STEP);	
			getCommand().sendKeys(txt_CaseQty, strCaseQty);
		}
		if(getCommand().isTargetPresent(txt_SplitQty)){

			log("Enter Split Quantity " + strSplitQty,LogType.STEP);	
			getCommand().sendKeys(txt_SplitQty,strSplitQty);
		}
		if(getCommand().isTargetPresent(btn_Add)){

			log("Click on Add Button",LogType.STEP);	
			getCommand().click(btn_Add);
		}
		if(getCommand().isTargetPresent(btn_AddtoOrder)){
			log("Click on Add to Order Button",LogType.STEP);	
		}
		getCommand().click(btn_AddtoOrder);
		return this;
	}
	public OrderPage enterQuickOrderEntryDetailsWithoutAdd(String[] strUPC, String[] strCaseQty, String[] strSplitQty){
		for(int i=0;i<strUPC.length;i++){
			(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='loaderImg']/img"));
		if(getCommand().isTargetPresent(txt_UPC)){
			log("Enter Item UPC " + strUPC[i],LogType.STEP);
			getCommand().clear(txt_UPC);
			getCommand().sendKeys(txt_UPC, strUPC[i]);
		}
		if(getCommand().isTargetPresent(txt_CaseQty)){
             
			log("Enter Case Quantity " + strCaseQty[i],LogType.STEP);	
			if ("*iexplore".contains(TestProperties.getProperties("test.browser")))
			{
			getCommand().clear(txt_CaseQty);
			}
			getCommand().sendKeys(txt_CaseQty, strCaseQty[i]);
		}
		if(getCommand().isTargetPresent(txt_SplitQty)){

			log("Enter Split Quantity " + strSplitQty[i],LogType.STEP);	
			getCommand().sendKeys(txt_SplitQty,strSplitQty[i]);
		}
		if(getCommand().isTargetPresent(btn_Add)){
            (new SupportFunctions()).waitForStatic(5);
			log("Click on Add Button",LogType.STEP);
			if ("*iexplore".contains(TestProperties.getProperties("test.browser")))
			{
			  //Wait For the element to be available in IE
			 new SupportFunctions().waitForStatic(7);
			 WebElement element = getCommand().getDriver().findElement(By.xpath(btn_Add.getTargetValue()));
			 JavascriptExecutor executor = (JavascriptExecutor)getCommand().getDriver();
			 executor.executeScript("arguments[0].click();", element);
			}else{
				getCommand().click(btn_Add);
				getCommand().waitFor(7);
			}
			/*getCommand().click(btn_Add);
			getCommand().waitFor(7);*/
		}
		}
		return this;
	}
	
	public OrderPage clickSubmitOrder(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		//Wait For the element to be available in IE
		new SupportFunctions().waitForStatic(5);
		getCommand().waitForTargetPresent(btn_SubmitOrder);
		if (getCommand().isTargetPresent(btn_SubmitOrder)){
			log("Click On Submit Order.",LogType.STEP);	
			getCommand().click(btn_SubmitOrder);
			
		}
		return this;
	}
	public OrderPage validateQunatityPopup(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetVisible(btn_QuantityValidation);
		if (getCommand().isTargetPresent(btn_QuantityValidation)){
			log("Pop Up Is Dispalyed",LogType.STEP);	
			
		}else{
			SoftAssertion.fail("Failed::Pop Up Is Not Displayed");
		} 
	  
		return this;
	}
	public OrderPage clickOnContinue_NonCancelledItem(){
		getCommand().waitForTargetVisible(btn_ContinueNonCancelledItem);
		if (getCommand().isTargetPresent(btn_ContinueNonCancelledItem)){
			log("Click On Continie To Submit Order.",LogType.STEP);	
			getCommand().click(btn_ContinueNonCancelledItem);
			
		}
		return this;
	}
	
	public OrderPage atOrderReminderPagePopUp(){		
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='prepareOrderReminderPopup']"));
		//Wait For the element to be available in IE
		new SupportFunctions().waitForStatic(5);
		getCommand().waitForTargetPresent(pg_OrderReminderPopup);
		log("Order Reminder Pop up displayed",LogType.STEP);
		return this;
	}
	public OrderPage validateOrderInQuickOrderPopUp(String[] upcNumber,String[] quantity,String[] splitQuantity){
		for(int i=0;i<upcNumber.length;i++){
		String status=getCommand().getText(txt_StatusInQuickOrder.replace("<#>",upcNumber[i]));
		
		if(status.equalsIgnoreCase("Valid")){
			log("Status Of The Item("+upcNumber[i]+") Is:"+status,LogType.STEP);
		}else{
			SoftAssertion.fail("Failed:The Status Is Invalid");
		}
		}
		return this;
	}
	public OrderPage clickOrderReminderSubmit(){

		getCommand().waitForTargetPresent(txt_Dynamic_Price);
	
		getCommand().waitForTargetPresent(btn_OrderReminderSubmit);
		if (getCommand().isTargetPresent(btn_OrderReminderSubmit)){
			log("Click on Order Reminder Submit.",LogType.STEP);	
			getCommand().click(btn_OrderReminderSubmit);			
		}
		return this;
	}
	public OrderPage clickOrderReminderSubmitNormal(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='prepareOrderReminderPopup']"));
        if(getCommand().getDriver().findElement(By.xpath("//*[@id='orderReminderModalInternal']")).isDisplayed()){
	getCommand().waitForTargetVisible(lbl_Dynamic_Price2);
	getCommand().waitForTargetPresent(btn_OrderReminderSubmit);
	if (getCommand().isTargetPresent(btn_OrderReminderSubmit)){
		log("Click on Order Reminder Submit.",LogType.STEP);	
		getCommand().click(btn_OrderReminderSubmit);			
	}
	if(!getCommand().getDriver().findElements(By.xpath("//*[@id='gbox_shouldBuyItemsGrid']//*[contains(@id,'-CS')]")).isEmpty()){
	getCommand().waitForTargetVisible(lbl_Dynamic_Price1);
	
	getCommand().waitForTargetPresent(btn_OrderReminderSubmit);
	if (getCommand().isTargetPresent(btn_OrderReminderSubmit)){
		//log("Click on Order Reminder Submit.",LogType.STEP);	
		//getCommand().click(btn_OrderReminderSubmit);			
	}
	}
	
        }
		

		return this;
	}
	
	public OrderPage verifyAndConfirmOrder(){		
		getCommand().waitForTargetVisible(btn_OrderCreationSucess);
		if (getCommand().isTargetPresent(btn_OrderCreationSucess)){
			log("Order Creation Sucess.",LogType.STEP);	
			getCommand().click(btn_OrderCreationSucess);			
		}
		return this;
	}
	public OrderPage verifyOrderOverviewAfterCreate(){		
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		getCommand().waitForTargetPresent(grd_OpenOrderTab);
		log("Order Overview Page displayed.",LogType.STEP);	

		return this;
	}
	public OrderPage close(){	
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if (getCommand().isTargetPresent(lnk_Close)){
			(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			log("Close Sysco Express Market.",LogType.STEP);	
			getCommand().click(lnk_Close);		
			getCommand().waitForTargetPresent(btn_CloseConfirmation);			
			if (getCommand().isTargetPresent(btn_CloseConfirmation)){
				log("Confirm Close.",LogType.STEP);
				getCommand().click(btn_CloseConfirmation);
			}
			//Waiting For The Element To Be Loaded in i.e browser only
			//(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			//(new SupportFunctions()).waitForStatic(3);
			
		}
		return this;
	}
	public OrderPage clickOncreatNewOrderFromOrderPage(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(btn_CreatNewOrderFromOrderPage);
		if(getCommand().isTargetPresent(btn_CreatNewOrderFromOrderPage)){
			log("Click on Start New Order",LogType.STEP);
			getCommand().click(btn_CreatNewOrderFromOrderPage);
		}
		return this;
	}
	public OrderPage verifyCreateOrderPopupFunctions(){
		if(getCommand().isTargetPresent(order_Name)){
			log("'Order Name' Present",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::'Order Name' Is Not Present");
		}
		if(getCommand().isTargetPresent(delivery_Date)){
			log("'Delivery Date' Present",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::'Delivery Date' Is Not Present");
		}
		if(getCommand().isTargetPresent(add_ProductFrom)){
			log("'add_ProductFrom' Present",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::'add_ProductFrom' Is Not Present");
		}
		if(getCommand().isTargetPresent(po_Number)){
			log("'po_Number' Present",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::'po_Number' Is Not Present");
		}
		if(getCommand().isTargetPresent(chk_saveSetting)){
			log("'chk_saveSetting' Present",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::'chk_saveSetting' Is Not Present");
		}
		if(getCommand().isTargetPresent(btn_CreateNewOrder)){
			log("'btn_CreateNewOrder' Present",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::'btn_CreateNewOrder' Is Not Present");
		}
		if(getCommand().isTargetPresent(btn_Cancel)){
			log("'btn_Cancel' Present",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::'btn_Cancel' Is Not Present");
		}
		return this;
	}
	public OrderPage clickOnSaveSetting(){
		if(getCommand().isTargetPresent(chk_saveSetting)){
			getCommand().click(chk_saveSetting);
			log("Click On Save_These_setting check box ",LogType.STEP);
		}
		return this;
	}
	public OrderPage viewDropDown(String orderDropDown){
		getCommand().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String[] arrExpectedValue = StringUtils.split(orderDropDown,";");
		int iCnt = 0;
		log("Verfiy Order  drop down : " + orderDropDown,LogType.STEP);	
		List<WebElement> dropDownValues= (new SupportFunctions()).getDropdownList((By.id("addItemToOrder")));
		for(WebElement weOption:dropDownValues){
			if(weOption.getText().equals(arrExpectedValue[iCnt])){			
				log("'"+weOption.getText()+"' Is Verified",LogType.STEP);
			}else{
				SoftAssertion.fail("Failed::"+weOption.getText()+" is Not Verified ");
				break;
			}
			iCnt = iCnt+1;
		}

		return this;
	
	}
	public OrderPage clickOnCancelButton(){
		getCommand().waitForTargetVisible(btn_Cancel);
		if(getCommand().isTargetPresent(btn_Cancel)){
			log("click on Cancel_button",LogType.STEP);
			getCommand().click(btn_Cancel);
		}
		return this;
	}
	public OrderPage orderGuideFromDropDown(){
			log("Select Ordre Guide",LogType.STEP);
			getCommand().selectDropDown(lst_ProductFrom, "Order Guide");
			getCommand().waitFor(5);
		return this;
	}
	public OrderPage clickOnCreatNewOrder(){
		//getCommand().waitFor(3);
		getCommand().waitForTargetPresent(btn_CreateNewOrder);
		if(getCommand().isTargetPresent(btn_CreateNewOrder)){
			log("click on create New Order",LogType.STEP);
			//Waiting for the element to be available in IE
			(new SupportFunctions()).waitForStatic(5);
			getCommand().waitFor(3);
			getCommand().click(btn_CreateNewOrder);
			(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='createNewOrderDiv']"));
		
		}
		
		return this;
	}
	public OrderPage clickOnDeliveyDate(){
		getCommand().waitForTargetPresent(btn_DeliveryDate);
		if(getCommand().isTargetPresent(btn_DeliveryDate)){
			log("Click On Delivery Date",LogType.STEP);
			getCommand().click(btn_DeliveryDate);
		
	    }
		return this;
	}
	public OrderPage selectTypeFromDropDown(String type){
		if(getCommand().isTargetPresent(btn_addItemToOrder)){
			log("Selected Type:"+type,LogType.STEP);
			if(Arrays.asList("*chrome").contains(TestProperties.getProperties("test.browser"))){	
			//dropDownSelection(By.xpath("//*[@id='addItemToOrder']"),type);
			dropDownSelection(By.xpath("//*[@id='addProductsFrom']"),type);
			}
			else{
				getCommand().waitFor(3);
				if(type.contains("Select Option")){
					getCommand().sendKeys(btn_addItemToOrder, "Select Option");
				}
				else if(type.contains("Order Guide")){
					getCommand().sendKeys(btn_addItemToOrder, "Order Guide");
				}
				else if(type.contains("Lists")){
					getCommand().sendKeys(btn_addItemToOrder, "Lists");
				}
				else if(type.contains("Historical Orders")){
					getCommand().waitFor(2);
					getCommand().sendKeys(btn_addItemToOrder, "Historical Orders");
				}
				else if(type.contains("Product Catalog")){
					getCommand().sendKeys(btn_addItemToOrder, "Product Catalog");
				}
				else if(type.contains("Quick Order Entry")){
					
					getCommand().sendKeys(btn_addItemToOrder, "Quick Order Entry");
					getCommand().waitFor(3);
				}
			}
			
		}
		return this;
	}
	public OrderPage selectDropDownValue(String type){
		getCommand().waitForTargetVisible(btn_addItemToOrder);
		 log("Select dropdown type: "+type,LogType.STEP);
	   getCommand().selectDropDown(btn_addItemToOrder,type);
	   getCommand().waitFor(3);
		return this;
	}
	public OrderPage dropDownSelection(By xpath,String strValue){
		WebElement webDropDwn = getCommand().getDriver().findElement(xpath);
		Select selDrop= new Select(webDropDwn);
		webDropDwn.click();
		selDrop.selectByValue(strValue);
		WebElement webDrpDwn = (WebElement)getCommand().getDriver().findElement(By.xpath("//*[@id='addItemToOrder']/option[@value='"+strValue+"']"));
		//webDrpDwn.sendKeys(Keys.ENTER);
		Actions act=new Actions(getCommand().getDriver());
		act.moveToElement(webDrpDwn);
		act.click();
		return this;
	}
	public OrderPage selectSaturday(){
		  new SupportFunctions().updateData("update ESCMSNTF set SNDSDL = ' 00000 ' WHERE trim(sncuno) ='108761'");
		  //Date now = new Date();
		  SimpleDateFormat f = new SimpleDateFormat("d-MMM-yyyy");
		  Calendar c = Calendar.getInstance();
		  c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		  System.out.println(f.format(c.getTime()));
		  String date=f.format(c.getTime());
		  String[] e=date.split("-");
		  String sat=e[0];
		  System.out.println("Month======"+getCommand().getDriver().findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText());
		  if(!getCommand().getDriver().findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().contains(e[1])){
			  getCommand().getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span")).click(); 
		  }
		 // System.out.println("Size=========="+getCommand().getDriver().findElements(By.linkText(sat)).size());
		  if(getCommand().getDriver().findElements(By.linkText(sat)).size()==0){
			  log("Saturday is disabled",LogType.STEP); 
		  }
		  else{
			  SoftAssertion.fail("Failed::Saturday Is Enabled");
		  }
		return this;
	}
	public OrderPage selectSunday(){
		 // Date now = new Date();
		  SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		  Calendar c = Calendar.getInstance();
		  c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		  System.out.println(f.format(c.getTime()));
		  String date=f.format(c.getTime());
		  String[] e=date.split("-");
		  String sat=e[0];
		  int dateConverted=Integer.parseInt(sat)+1;
		  
		  if(getCommand().getDriver().findElements(By.linkText(dateConverted+"")).size()==0){
			  log("Sunday is disabled",LogType.STEP); 
		  }
		  else{
			  SoftAssertion.fail("Failed::SundDay Is Enabled");
		  }
		return this;
	}
	
	public OrderPage selectOffDay(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		getCommand().getDriver().findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
		getCommand().getDriver().manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		getCommand().getDriver().findElement(By.xpath("//td[@class=' ui-datepicker-week-end ui-date-offdays']")).click();
		
		return this;
	}
	public OrderPage selectWeekDay(){
		//  Date now = new Date();
		  SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		  Calendar c = Calendar.getInstance();
		  c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		  System.out.println(f.format(c.getTime()));
		  String date=f.format(c.getTime());
		  String[] e=date.split("-");
		  String sat=e[0];
		  int dateConverted=Integer.parseInt(sat)+2;
		  //System.out.println("Size=========="+getCommand().getDriver().findElements(By.linkText(dateConverted+"")).size());
		  if(getCommand().getDriver().findElements(By.linkText(dateConverted+"")).size()!=0){
			  log("Weekdays Are Enabled",LogType.STEP); 
		  }
		  else{
			  SoftAssertion.fail("Failed::Weekday Are Disabled");
		  }
		return this;
	}
	
	public OrderPage orderPageTab(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(getCommand().isTargetPresent(tab_Order)){
			log("Click On Order Tab",LogType.STEP);
			getCommand().click(tab_Order);
		}
		return this;
	}
	public OrderPage selectProductCatalogFromDropDown(){
		if(getCommand().isTargetPresent(btn_addItemToOrder)){
			log("Product catalog is selected",LogType.STEP);
			getCommand().selectDropDown(btn_addItemToOrder, "Product Catalog");
		}
		return this;
	}
	public OrderPage clickOncancelOrder(){
		if(getCommand().isTargetPresent(btn_CancelOrder)){
			log("click on cancel button",LogType.STEP);
			getCommand().click(btn_CancelOrder);
		}
		return this;
	}
	public OrderPage verifyAlertAnyOrder(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(alert_Column);
		if(getCommand().isTargetPresent(alert_Column)){
			log("Alert Column is verified",LogType.STEP);
		}else{

           SoftAssertion.fail("Failed::Alert Column is Not verified");
		}
		return this;
	}
	public OrderPage selectDeliveryDateAfterModify(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		 getCommand().getDriver().manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		getCommand().getDriver().findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
		  SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		  Calendar c = Calendar.getInstance();
		  System.out.println(f.format(c.getTime()));
		  String date=f.format(c.getTime());
		  String[] e=date.split("-");
		  int nextDate=Integer.parseInt(e[0]);
		  System.out.println("Today Date============="+e[0]);
		  System.out.println("Tomorrow Date==========="+(nextDate+1));
		  getCommand().getDriver().findElement(By.linkText((nextDate+1)+"")).click();
		return this;
	}
	public OrderPage moveCursorToAlertColummn(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement element=getCommand().getDriver().findElement(By.tagName("img"));
		String alertText=element.getAttribute("title");
		log("Moving the mouse over alert column",LogType.STEP);
		if(!alertText.isEmpty()){
		log("Alert Message is:"+"'"+alertText+"'",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::No Message On Alert Indicator");
		}
		return this;
	}
	public OrderPage clickOnAddToOrderInQuickOrder(){
		getCommand().waitForTargetVisible(btn_AddtoOrder);
		if(getCommand().isTargetPresent(btn_AddtoOrder)){

			log("Click on Add to Order Button",LogType.STEP);	
			getCommand().click(btn_AddtoOrder);
		}
		return this;
	}
	public OrderPage clickOnViewOrder(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(btn_ViewOrder);
		if(getCommand().isTargetPresent(btn_ViewOrder)){
            log("Click view Order Button",LogType.STEP);	
			getCommand().click(btn_ViewOrder);
		}
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		return this;
	}
	
	public OrderPage clickOnShippingTab(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(lnk_ShippingCondition);
		if(getCommand().isTargetPresent(lnk_ShippingCondition)){
            log("Click view Order Button",LogType.STEP);	
			getCommand().click(lnk_ShippingCondition);
		}
		return this;
	}
	public OrderPage verifyshippingtab()
{
		
		getCommand().click(shipdropdown);
		getCommand().waitFor(5);	
		if(getCommand().isTargetPresent(shipdropdown2))
		{
			log("Will call condition is present",LogType.STEP);	
		}
		getCommand().waitFor(5);
	
		if(getCommand().isTargetPresent(shipdropdown3))
		{
			log(" Delivered Will call condition is present",LogType.STEP);	
		}
		
		return this;
	
	}
	/*public OrderPage clickOnShippingTabWillcall(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(lnk_ShippingCondition);
		if(getCommand().isTargetPresent(lnk_ShippingCondition)){
            log("Click view Order Button",LogType.STEP);	
			getCommand().click(lnk_ShippingCondition);
			getCommand().click(shipdropdown);
			getCommand().waitFor(5);
			//option[@value='Z1']
			getCommand().click(shipdropdown2);
			//getCommand().selectDropDown(shipdropdown2, "Will Call");
		}
		return this;
	}*/
	
	public OrderPage clickOnShippingTabWillcall(String shippingConditionSelect, String value){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(lnk_ShippingCondition);
		if(getCommand().isTargetPresent(lnk_ShippingCondition)){
            log("Click shipping condition tab",LogType.STEP);	
			getCommand().click(lnk_ShippingCondition);
			Select wc=new Select (getCommand().getDriver().findElement(By.id("shippingConditionSelect")));
			wc.selectByValue(value);
			/*if (Arrays.asList("*firefox","*iexplore").contains(TestProperties.getProperties("test.browser")))
			{
			WebElement aa = getCommand().getDriver().findElement(By.id("shippingConditionSelect"));  
			aa.sendKeys(Keys.ENTER);
			}*/
		}
		return this;
	}
	public OrderPage clickOnShippingTabDeliveredWillcall(String shippingConditionSelect, String value ){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(lnk_ShippingCondition);
		if(getCommand().isTargetPresent(lnk_ShippingCondition)){
            log("Click view Order Button",LogType.STEP);	
			getCommand().click(lnk_ShippingCondition);
			Select wc=new Select (getCommand().getDriver().findElement(By.id("shippingConditionSelect")));
			wc.selectByValue(value);
			if (Arrays.asList("*firefox","*iexplore").contains(TestProperties.getProperties("test.browser")))
			{
			WebElement aa = getCommand().getDriver().findElement(By.id("shippingConditionSelect"));  
			aa.sendKeys(Keys.ENTER);
			}
		}
		return this;
	}
	
	public OrderPage verifyViewOrderButton(){

        (new SupportFunctions()).waitForLoading(400, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String btn_ViewOrder="//input[@value='View Order']";
		if(getCommand().getDriver().findElement(By.xpath(btn_ViewOrder)).isDisplayed()){
            log("View Order button is Displayed",LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed::View Order button is  Not Displayed");
		}
		return this;
	}
	public OrderPage enterUPCInSearchBox(String strUPC){
	     getCommand().waitForTargetPresent(box_Search);
		if(getCommand().isTargetPresent(box_Search)){
			log("Enter Item number: " + strUPC,LogType.STEP);	
			getCommand().sendKeys(box_Search, strUPC).click(box_Search);
			//Waiting For The Object In IE
			 new SupportFunctions().waitForStatic(5);
		}
	
	return this;

  }
	
	public OrderPage checkOnItem(String[] upcName){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		for(int i=0;i<upcName.length;i++){
		enterUPCInSearchBox(upcName[i]);
		getCommand().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		new SupportFunctions().ScrollInToView(chk_Item.replace("<#>",upcName[i]));
		String path="//input[@id='jqg_productSearchGrid_"+upcName[i]+"-CS']";
		getCommand().getDriver().findElement(By.xpath(path)).click();
         log("Check the item:"+upcName[i],LogType.STEP);	
		}
		return this;
	}
	public OrderPage clickOnImportOrder(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(btn_Import);
		if(getCommand().isTargetPresent(btn_Import)){
			log("import Order popup is displayed",LogType.STEP);
			getCommand().click(btn_Import);
		}
		return this;
	}
	public OrderPage clickOnBrowseButton(){
		getCommand().waitForTargetPresent(btn_Browser);
		if(getCommand().isTargetPresent(btn_Browser)){
			log("click on Browse to upload",LogType.STEP);
			getCommand().click(btn_Browser);
		}
		return this;
	}
	public OrderPage viewImportOrderDropDown(String[] importMenu){
		List<WebElement> dropDownMenu=(new SupportFunctions()).getDropdownList(By.xpath("//*[@id='impOrderFormat']"));
		for(int i=0;i<dropDownMenu.size();i++){
			String menu=dropDownMenu.get(i).getText();
		if(menu.equals(importMenu[i])){
			log("'"+menu+"' Is Verified",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::'"+menu+"' Is Not verified");
		}
		}
		return this;
	
	}
	public OrderPage selectCSVFromImportDropMenu(){
		getCommand().selectDropDown(btn_ImportOrderDropDown,"Option 6 - CSV, Import/Export Format");
		log("'Option 6 - CSV, Import/Export Format' Is Selected",LogType.STEP);
		return this;
	}
	public OrderPage verifyimportoptionsorder()
	{
		(new SupportFunctions()).getDropdownList(By.xpath("//*[@id='impOrderFormat']"));
		if(getCommand().isTargetPresent(option1))
		{
			log("Option 1 - Computrition Compatible is present",LogType.STEP);
		}
		else
		{
			SoftAssertion.fail("Option 1 - Computrition Compatible is NOT present");
		}
		if(getCommand().isTargetPresent(option2))
		{
			log("Option 2 - Food-Trak Compatible is present",LogType.STEP);
		}
		else
		{
			SoftAssertion.fail("Option 2 - Food-Trak Compatible is NOT present");
		}
		if(getCommand().isTargetPresent(option3))
		{
			log("Option 3 - CBORD Compatible is present",LogType.STEP);
		}
		else
		{
			SoftAssertion.fail("Option 3 - CBORD Compatible is NOT present");
		}
		if(getCommand().isTargetPresent(option4))
		{
			log("Option 4 - Ingenium Max Compatible is present",LogType.STEP);
		}
		else
		{
			SoftAssertion.fail("Option 4 - Ingenium Max Compatible is NOT present");
		}
		if(getCommand().isTargetPresent(option6))
		{
			log("Option 6 - CSV, Import/Export Format is present",LogType.STEP);
		}
		else
		{
			SoftAssertion.fail("Option 6 - CSV, Import/Export Format is NOT present");
		}
		getCommand().waitFor(5);
		getCommand().selectDropDown(importlist, "6");
		log("user is able to select CSV option",LogType.STEP);
		
		return this;
	}
	
	public OrderPage clickOnAcknowledgementButton(){
		 //Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		   (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='loadingDiv11']"));
		  getCommand().waitForTargetVisible(btn_Acknowledged);
			 if(getCommand().isTargetPresent(btn_Acknowledged)){
			        log("Click On Ok after submit",LogType.STEP);
				    getCommand().click(btn_Acknowledged);
			      }
			
		return this;
	}
 public OrderPage addMultipleItems(){		
	
		/*if(getCommand().isTargetPresent(txt_UPC)){
			
			getCommand().clear(txt_UPC);
			log("Enter Item UPC " + strUPC,LogType.STEP);	
			getCommand().sendKeys(txt_UPC, strUPC);
			
		}
		if(getCommand().isTargetPresent(txt_CaseQty)){
			getCommand().clear(txt_CaseQty);
			log("Enter Case Quantity " + strCaseQty,LogType.STEP);	
			getCommand().sendKeys(txt_CaseQty, strCaseQty);
		}
		if(getCommand().isTargetPresent(txt_SplitQty)){
			getCommand().clear(txt_SplitQty);
			log("Enter Split Quantity " + strSplitQty,LogType.STEP);	
			getCommand().sendKeys(txt_SplitQty,strSplitQty);
		}
		if(getCommand().isTargetPresent(btn_Add)){
			
            
			log("Click on Add Button",LogType.STEP);	
			getCommand().click(btn_Add);
		}*/
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	 List<WebElement> list=getCommand().getDriver().findElements(By.xpath(txt_ChangeQuantity.getTargetValue()));
	 for(int i=0;i<list.size();i++){
		 list.get(i).sendKeys("5");
		 ((JavascriptExecutor)getCommand().getDriver()).executeScript("arguments[0].scrollIntoView(true);",list.get(i));	
			getCommand().getDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	 }
	 
		return this;
 }
 public OrderPage uploadFile(String strFile){
		getCommand().waitForTargetVisible(btn_Browser);
		String strFilePath = null;
		if(getCommand().isTargetPresent(btn_Browser)){
			log("Click on 'Browse' button",LogType.STEP);
			getCommand().click(btn_Browser);
			//send key the image path
			//Actions aSendText = new Actions(getCommand().getDriver());
			WebElement fileInput = getCommand().getDriver().findElement(By.xpath("//input[@id='file']"));
			//strFilePath = System.getProperty("user.dir")+ "/" + TestProperties.getProperties("testdata.path") + "Files/" + strFile;
			strFilePath =TestProperties.getProperties("testdata.path") + "Files/" + strFile;
			System.out.println(strFilePath);
			fileInput.sendKeys(strFilePath);
			//fileInput.sendKeys(Keys.ESCAPE);
			//fileInput.sendKeys(Keys.ENTER);
			//aSendText.sendKeys(strFilePath);
			//aSendText.sendKeys(Keys.ENTER);
		}
		return this;
	}
 public OrderPage clickOnImportButton(){		
		getCommand().waitForTargetPresent(btn_ImportOrder);
		if (getCommand().isTargetPresent(btn_ImportOrder)){
			log("Click on import Order.",LogType.STEP);	
			getCommand().click(btn_ImportOrder);
			
		}
		return this;
	}
 public OrderPage changeOrderQuantity(String sUPC,String changeQuantity) throws AWTException{
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	 getCommand().waitForTargetPresent(txt_ChangeQuantity.replace("<#>",sUPC));
	 if(getCommand().isTargetPresent(txt_ChangeQuantity.replace("<#>",sUPC))){
		getCommand().clear(txt_ChangeQuantity.replace("<#>",sUPC)).sendKeys(txt_ChangeQuantity.replace("<#>",sUPC),changeQuantity);
		Robot rb1 =new Robot();
		rb1.keyPress(KeyEvent.VK_TAB);
		//rb.keyPress(KeyEvent.v);
		rb1.keyRelease(KeyEvent.VK_TAB);
		getCommand().waitFor(3);
	 }
	 return this;
   }
	 public OrderPage clickOnContinueButton(){		
			getCommand().waitForTargetPresent(btn_Continue);
			if (getCommand().isTargetPresent(btn_Continue)){
				log("Click on continue button.",LogType.STEP);	
				getCommand().click(btn_Continue);
				
			}
			return this;
		}
	
	 public OrderPage verifyDeleteLink(){
		 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		int size= getCommand().getDriver().findElements(By.xpath("//a[@title='Delete Order']")).size();
		if(size==0){
		log("Delete_Submitted_Order_Link Is Not Present",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::Delete_Submitted_Order_Link Is Present");
		}
		 return this;
		 
	 }
	 public OrderPage verifyCancelLink(){
		 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			int size= getCommand().getDriver().findElements(By.xpath("//*[@id='roCancelOrderLink']/b")).size();
			if(size!=0){
			log("Cancel_Link Is  Present",LogType.STEP);
			}else{
				SoftAssertion.fail("Failed::Cancel_Order_Link Is Not Present");
			}
			
		 return this;
		 
	 }
	 public OrderPage clickOnSubmittedOrder(String orderNumber){
		 getCommand().waitForTargetPresent(txt_SubmittedOrderStatus.replace("<#>",orderNumber));
		 String txt_Submitted=getCommand().getText(txt_SubmittedOrderStatus.replace("<#>",orderNumber));
		 if(getCommand().isTargetPresent(txt_SubmittedOrderStatus.replace("<#>",orderNumber))){
		 log("Check The Status If It Is Submitted",LogType.STEP);
		 if(txt_Submitted.equalsIgnoreCase("Submitted"))
		 {
			 getCommand().waitForTargetPresent(txt_SubmittedOrderNumber.replace("<#>",orderNumber));
			 log("Click On The Submitted Order ",LogType.STEP);
			 getCommand().click(txt_SubmittedOrderNumber.replace("<#>",orderNumber)); 
		  }
		}
		 return this;
	 }
	 public OrderPage enterOrderName(String strOrderName){		
			if(getCommand().isTargetPresent(txt_OrderName)){
				log("Enter Order Name " + strOrderName,LogType.STEP);	
				getCommand().clear(txt_OrderName);
				getCommand().sendKeys(txt_OrderName, strOrderName);
			}
			return this;
		}
	
	 public OrderPage validateValidItemStatus(String upcNumber){
		 String status=getCommand().getText(txt_StatusInQuickOrder.replace("<#>",upcNumber));
			System.out.println("Status For Item======="+upcNumber  +status);
			if(status.equalsIgnoreCase("Valid")){
				log("Status Of The Item("+upcNumber+") Is:"+status,LogType.STEP);
			}else{
				SoftAssertion.fail("Failed:The Status Is Invalid For Valid UPC");
			}
		 return this;
	 }
	 public OrderPage validateInvalidItemStatus(String upcNumber){
		    String status=getCommand().getText(txt_StatusInQuickOrder.replace("<#>",upcNumber));
			System.out.println("Invalid status======"+status);
			if(status.equalsIgnoreCase("Invalid")){
				log("Status Of The Item("+upcNumber+") Is:"+status,LogType.STEP);
			}else{
				SoftAssertion.fail("Failed:The Status Is valid For Invalid UPC");
			}
		 return this;
	 }
	 public OrderPage validateNotSplitItemStatus(String upcNumber){
		   String status=getCommand().getText(txt_StatusInQuickOrder.replace("<#>",upcNumber));
			
			if(status.equalsIgnoreCase("Split Not offered")){
				log("Status Of The Item("+upcNumber+") Is:"+status,LogType.STEP);
			}else{
				SoftAssertion.fail("Failed:The Status For Non Split Item Is Not Validated");
			}
		 return this;
	 }
	 public OrderPage validateInvalidSplitItemStatus(String upcNumber){
		 System.out.println("Start==================");
		   String status=getCommand().getText(txt_StatusInQuickOrder.replace("<#>", upcNumber));
			System.out.println("Invalid Split status======="+status);
			if(status.equalsIgnoreCase("Invalid Split")){
				log("Status Of The Item("+upcNumber+") Is:"+status,LogType.STEP);
			}else{
				SoftAssertion.fail("Failed:The Status For Over Splited ");
			}
		 return this;
	 }
	 public OrderPage validateQuickOrderQunatity(String upcName,String quantity){
		 System.out.println("==================Case Qunatity=============");
		 int aCount=getCommand().getDriver().findElements(By.xpath("//*[@id='"+upcName+"_CASE']")).size();
		 int bCount=getCommand().getDriver().findElements(By.xpath("//*[@id='"+upcName+"']/td[4]")).size();
	  if(aCount>0){
		 String caseValue=getCommand().getAttribute(txt_Quantity.replace("<#>",upcName), "value").split("@")[0];
		 if(caseValue.equals(quantity)){
			log("Order Quantity Is Validated:"+quantity,LogType.STEP); 
		 }
		 else{
			 SoftAssertion.fail("Fails::Quanity Not Equal");
		 }
		 }
	  else if(bCount>0){ 
		  if(getCommand().getText(txt_QuantityInQuickOrderZero.replace("<#>", upcName)).equals(quantity))
		  {
			 log("Order Quantity With Zero Is Validated:"+quantity,LogType.STEP);  
		 }
		 else{
			 SoftAssertion.fail("Fails::Quanity Not Equal");
		 }
		}
	  else{
		  SoftAssertion.fail("Fails::Quanity Not Equal");
	  }
		 return this;
	 }
	 public OrderPage validateQuickSplitItem(String upcName,String splitValue){
		 System.out.println("==================split Qunatity=============");
		 if(splitValue==""){
			 splitValue=0+"";
		 }
		 int aSplitCount=getCommand().getDriver().findElements(By.xpath("//*[@id='"+upcName+"_SPLIT']")).size();
		 int bSplitCount=getCommand().getDriver().findElements(By.xpath("//*[@id='"+upcName+"']/td[5]")).size();
		 System.out.println("Split With Value==="+aSplitCount);
		 System.out.println("Split WithOut Value==="+bSplitCount);
	  if(aSplitCount>0){
		 String splitQunatity=getCommand().getAttribute(txt_SplitQuantityInQuickOrdeNonZero.replace("<#>",upcName), "value").split("@")[0];
		 if(splitValue.equals(splitQunatity)){
			log("Split Quantity Is Validated:"+splitValue,LogType.STEP); 
		 }
		 else{
			 SoftAssertion.fail("Fails::Split Quanity Not Equal");
		 }
		 }
	  else if(bSplitCount>0){ 
		  if(getCommand().getText(txt_SplitQuantity.replace("<#>", upcName)).equals(splitValue))
		  {
			 log("Split Quantity With Zero Is Validated:"+splitValue,LogType.STEP);  
		 }
		 else{
			 SoftAssertion.fail("Fails::Split Quanity Not Equal"+splitValue);
		 }
		}
	  else{
		  SoftAssertion.fail("Fails::Split Quanity Not Equal");
	  }
		 return this;
	 }
	 public OrderPage validateNullUpc(String upcName){
		 if(getCommand().getText(txt_errorUPC).contains("SUPCs must be entered before adding to order")){
			 log("Message For Item Without UPC"+getCommand().getText(txt_errorUPC),LogType.STEP); 
		 }else{
			 SoftAssertion.fail("Fails:There Is No Message When Without UPC Is Entered");
		 }
		 return this;
	 }
	 
	 public OrderPage clickToDeleteOneLine(String upcName){	
		 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			getCommand().waitForTargetPresent(link_DeleteSubmittedOrder.replace("<#>",upcName));
			if (getCommand().isTargetPresent(link_DeleteSubmittedOrder.replace("<#>",upcName))){
				log("Click To Delete One Line In Submitted Order.",LogType.STEP);	
				getCommand().click(link_DeleteSubmittedOrder.replace("<#>",upcName));
				
			}
			return this;
		}
	 public OrderPage clickOnDeleteLink(){	
		 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			getCommand().waitForTargetVisible(link_DeleteOrder);
			if (getCommand().isTargetPresent(link_DeleteOrder)){
				log("Click on Delete_link in Open Order",LogType.STEP);	
				getCommand().click(link_DeleteOrder);
			}
			return this;
		}
	 public OrderPage  validateAlertDeleteOrder(){
		 getCommand().getDriver().manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		 String expectedAlert="Are you sure you want to delete this order?";
			String alertMsg=getCommand().getDriver().findElement(By.xpath("//span[@class='wrtx']")).getText();
			if(alertMsg.contains(expectedAlert)){
				log("A pop up with '"+alertMsg+"' is displayed",LogType.STEP);	
			}
			else{
				SoftAssertion.fail("Failed::Alert Message Is not Displayed");
			}
			getCommand().getDriver().findElement(By.xpath("//*[@id='deleteOrder']")).click();
			log("Click On Yes To Delete",LogType.STEP);
		 return this;
	 }
	 public OrderPage clickOnApproveButton(){
		 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			getCommand().waitForTargetPresent(btn_ApproveOrder);
			if (getCommand().isTargetPresent(btn_ApproveOrder)){
				log("Click on Approve Button",LogType.STEP);	
				getCommand().click(btn_ApproveOrder);
				
			}
			return this;
		}
	 public OrderPage clickOnOkButton(){	
		      getCommand().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		      getCommand().getDriver().findElement(By.xpath("//input[@value='OK']")).click();
			log("Click On Ok Button After Approval",LogType.STEP);	
			return this;
		}
	 public OrderPage clickOnRejectOrderButton(){
		 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			getCommand().waitForTargetPresent(btn_RejectOrder);
			if (getCommand().isTargetPresent(btn_RejectOrder)){
				log("Click On Reject Order",LogType.STEP);	
				getCommand().click(btn_RejectOrder);
				
			}
			return this;
		}
	 public OrderPage enterRejectMessage(){		
			getCommand().waitForTargetPresent(txt_RejectMessage);
			if (getCommand().isTargetPresent(txt_RejectMessage)){
				log("Click On Reject Order",LogType.STEP);	
				getCommand().clear(txt_RejectMessage).sendKeys(txt_RejectMessage, "CanCel The Order");
				getCommand().getDriver().findElement(By.xpath("//*[@id='pendingOrderRejectButton']")).click();
				(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='rejectOrderDiv']"));
			}
			return this;
		}
	 public OrderPage verifyQuickOrder_DemoUser(){
		 (new SupportFunctions()).waitForLoading(300, By.xpath("/img[@src='/OMAPX_r6.0.0.3/resources/images/ajax-loader-small.gif']"));
		// getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 getCommand().getDriver().manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		 //Click On Ok Button 
		 WebElement element = getCommand().getDriver().findElement(By.id("shareListResultButton"));
		 JavascriptExecutor executor = (JavascriptExecutor)getCommand().getDriver();
		 executor.executeScript("arguments[0].click();", element);
		 //getCommand().getDriver().findElement(By.xpath("//input[@value='OK']")).click();;
	 if(!getCommand().getDriver().findElement(By.xpath("//input[@id='quickOrderButtonPopup']")).isEnabled()){
			 log("Quick Order Entry Actions Is Disabled",LogType.STEP);
		 }else{
			 SoftAssertion.fail("Failed::Quick Order Entry Actions Is Enabled");
		 }
		 return this;
	 }
    public OrderPage verifySubmitOrder_DemoUser(){
		 getCommand().getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 if(!getCommand().getDriver().findElement(By.xpath("//*[@id='chkOutBtn1']")).isEnabled()){
			 log("Submit Order Actions Is Disabled",LogType.STEP);
		 }else{
			 SoftAssertion.fail("Failed::Submit Order Actions Is Enabled");
		 }
		 return this;
	 }
	 public OrderPage verifyCreateOrder_DemoUser(){
		 getCommand().getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 if(!getCommand().getDriver().findElement(By.xpath("//*[@id='createNewOrderButton']")).isEnabled()){
			 log("Create New Order Actions Is Disabled",LogType.STEP);
		 }else{
			 SoftAssertion.fail("Failed::Create New Order Actions Is Enabled");
		 }
		 return this;
	 }
	 public OrderPage verifyModifyOrder_DemoUser(){
		 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));

		 getCommand().getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 if(!getCommand().getDriver().findElement(By.xpath("//*[@id='modifyBttnTopBttn']")).isEnabled()){
			 log("Modify Order Actions Is Disabled",LogType.STEP);
		 }else{
			 SoftAssertion.fail("Failed::Modify Order Actions Is Enabled");
		 }
		 return this;
	 }
	 public OrderPage clickOnPrintOrder(){
		 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		 getCommand().waitForTargetVisible(btn_PrintOrder);
			/*if (getCommand().isTargetPresent(btn_PrintOrder)){
				log("Click On Print Order",LogType.STEP);	
				getCommand().click(btn_PrintOrder);
				
			}*/
		 WebElement element = getCommand().getDriver().findElement(By.xpath(btn_PrintOrder.getTargetValue()));
		 JavascriptExecutor executor = (JavascriptExecutor)getCommand().getDriver();
		 executor.executeScript("arguments[0].click();", element);
		 return this;
	 }
	 public OrderPage validatePrintPopup(){
		 getCommand().getDriver().manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
			if (getCommand().getDriver().findElement(By.xpath("//*[@id='printOptionsPopUp']")).isDisplayed()){
				log("Print Modal Is Displayed",LogType.STEP);
			}else{
				SoftAssertion.fail("Failed::Print Modal Is Not Displayed");
			}
		 return this;
	 }

	public OrderPage clickOnCancelPrint(){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getCommand().getDriver().findElement(By.xpath("//button[@type='button'][1]")).click();
		log("Click On Cacel Button ",LogType.STEP);
		return this;
	}
	 public OrderPage clickForPopup(){
		 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		 getCommand().waitForTargetPresent(click_Outside);
			if (getCommand().isTargetPresent(click_Outside)){
				log("Creat Order Page Displayed",LogType.STEP);	
				getCommand().click(click_Outside);
				
			}
		 return this;
	 }
	 public OrderPage  verifyOrderPage(){
		 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		  getCommand().getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		  if(getCommand().getDriver().findElement(By.xpath("//*[@id='message']")).isDisplayed()){
			  log("Order Page Is Displayed",LogType.STEP);
		  }else{
			  SoftAssertion.fail("Failed::Order Page Is Not Displayed");
		  }
		  return this;
	  }

	public OrderPage verifyOrderlandingPage() {
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		  getCommand().getDriver().manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		  if(getCommand().getDriver().findElement(By.xpath("//*[@id='main-contentlistsprs']")).isDisplayed()){
			  log("Order Landing Page Is Displayed",LogType.STEP);
		  }else{
			  SoftAssertion.fail("Failed::Order Landing Page Is Not Displayed");
		  }
		return this;
		
	}

	public OrderPage clickOnImportCancelButton() {
		getCommand().waitForTargetVisible(link_Cancel);
		log("Click On Cancel On Import Order",LogType.STEP);
		getCommand().click(link_Cancel);
		return this ;
		
	}
	public OrderPage deleteRow(String upc){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		log("Click To Delete Item",LogType.STEP);
		getCommand().click(link_Delete.replace("<#>", upc));
		
		return this;
	}
	public OrderPage getOrigionalPrice(String upcName,String key)
	{
		    (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		    getCommand().waitForTargetPresent(txt_Price.replace("<#>", upcName));
			String orgPrice=getCommand().getAttribute(txt_Price.replace("<#>", upcName), "value");
			getCommand().storeValue(key, orgPrice.split("@")[0]);
			log("Original Price for the item :"+orgPrice.split("@")[0],LogType.STEP);
			return this;
	}
	
	public OrderPage getOrignalpricenew(String p ,String b)
	{
		
		return this;
		
	}
	public OrderPage enterHandPrice(String upcName) throws AWTException
	{
		    (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		    getCommand().waitForTargetPresent(txt_Price.replace("<#>", upcName));
			String orgPrice=getCommand().getAttribute(txt_Price.replace("<#>", upcName), "value");
			System.out.println("Origional Price of the item=="+orgPrice);
			log("Original Price for the item :"+orgPrice.split("@")[0],LogType.STEP);
			log("Enter Handprice of the item :"+(Double.parseDouble(orgPrice.split("@")[0])-5),LogType.STEP);
			System.out.println("Hand price to be done==="+(Double.parseDouble(orgPrice.split("@")[0])-5));
			getCommand().click(txt_Price.replace("<#>", upcName));
			Robot rb=new Robot();
			rb.keyPress(KeyEvent.VK_BACK_SPACE);
			rb.keyRelease(KeyEvent.VK_BACK_SPACE);
			getCommand().clear(txt_Price.replace("<#>", upcName)).sendKeys(txt_Price.replace("<#>", upcName), ""+(Double.parseDouble(orgPrice.split("@")[0])-5));
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		   return this;
	}
	public OrderPage verifyHandPrice(String upcName,String key)
	{
		    (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		    getCommand().waitForTargetPresent(txt_Price.replace("<#>", upcName));
			String handPrice=getCommand().getAttribute(txt_Price.replace("<#>", upcName), "value");
			if(!handPrice.split("@")[0].equals((String)getCommand().retrieveValue(key))){
				log("Original Price for the item is changed to hand price as expected :"+handPrice.split("@")[0],LogType.STEP);
			}else{
				SoftAssertion.fail("Failed::Original Price for the item is not changed to hand price as expected ");	
			}
		   return this;
	}
	public OrderPage verifyHandPriceAfterLogOut(String upcName,String key)
	{
		    (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		    getCommand().waitForTargetPresent(txt_Price.replace("<#>", upcName));
			String handPrice=getCommand().getAttribute(txt_Price.replace("<#>", upcName), "value");
			if(handPrice.split("@")[0].equals((String)getCommand().retrieveValue(key))){
				log("Original Price for the item is same after logout as expected :"+(String)getCommand().retrieveValue(key),LogType.STEP);
			}
			else{
				SoftAssertion.fail("Failed::Original Price for the item is not same after logout as expected ");	
			}
		   return this;
	}
	//*[@id='1737782-CS']/td[26]
	public OrderPage verifyHandPriceSubmittedOrder(String upcName,String key)
	{
		    (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		    getCommand().waitForTargetPresent(txt_PriceSubmitted.replace("<#>", upcName));
			String handPrice=getCommand().getAttribute(txt_PriceSubmitted.replace("<#>", upcName), "title");
			System.out.println("HandPrice for the item=="+handPrice);
			if(!handPrice.split(" ")[0].equals((String)getCommand().retrieveValue(key))){
				log("Handprice Price for the item is same after order is submitted as expected :"+handPrice.split(" ")[0],LogType.STEP);
			}
			else{
				SoftAssertion.fail("Failed::Handprice Price for the item is not same after order is submitted as expected ");	
			}
		   return this;
	}
public OrderPage storerefnumber(String strKey)
	
	{
		getCommand().waitForTargetPresent(refrencenum);
		String ss=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
		System.out.println(ss +"refvalue" );
		getCommand().storeValue(strKey, ss);
			
		return this;
	}
	
	public OrderPage checkrefnumber(String strkey)
	{
		{
			getCommand().waitFor(15);
			getCommand().click(refresh);
			getCommand().waitFor(30);
			getCommand().click(refresh);
			getCommand().waitFor(15);
			getCommand().click(viewallrecentorders);
			getCommand().waitFor(10);
			//getCommand().click(sort);
			//getCommand().waitFor(5);
			String ss1=(String) getCommand().retrieveValue(strkey);
			getCommand().isTargetPresent(refrencenum1.replace("<#>", ss1));
			getCommand().click(refrencenum1.replace("<#>", ss1));
			
			return this;
	}
}
	
public OrderPage tocheckhpinsubmittedorder(String item)
	
	{
		String ss2=(String) getCommand().retrieveValue("sub1");
		
		//String ss3=getCommand().getAttributeValue(submittedhp, "title");
		String ss3=getCommand().getAttributeValue(submittedhp.replace("<#>", item),"title");
		System.out.println( "submittedhp" +ss3);
		System.out.println("oldhp" + ss2);

		System.out.println(ss3.replaceAll("cs",""));
		
		//String ss4=ss3.substring(1,6);
		if(ss2.equals(ss3.replaceAll("cs","").trim()))
		//if(ss2.equals(ss4))
		{
			
			log("Handprice Price for the item is same after order is submitted as expected :",LogType.STEP);
		}
		else 
		{
			SoftAssertion.fail("Failed:Price is not changed in submitted order");			
		}
		
		return this;
	}
public OrderPage modifybutton()

{
	getCommand().waitForTargetPresent(modifyorder);
	
	if ( getCommand().isTargetPresent(modifyorder))
	{
		getCommand().click(modifyorder);
		getCommand().waitForTargetVisible(acceptalert);
		getCommand().click(acceptalert);	
	}
	return this ;
}

public OrderPage HPinsubmittedorder( String item2) throws AWTException

{
	getCommand().waitFor(10);
	getCommand().click(currentprice4.replace("<#>", item2));
	//String m=getCommand().getAttributeValue(currentprice4, "value");
	String m=getCommand().getAttributeValue(currentprice4.replace("<#>", item2), "value");
	Robot rb =new Robot();
	rb.keyPress(KeyEvent.VK_BACK_SPACE);
	rb.keyRelease(KeyEvent.VK_BACK_SPACE);
	getCommand().sendKeys(currentprice4.replace("<#>", item2),"P1");
	getCommand().waitFor(5);
    rb.keyPress(KeyEvent.VK_TAB);
   rb.keyRelease(KeyEvent.VK_TAB);
   getCommand().waitFor(3);
   String m1 =getCommand().getAttributeValue(currentprice4.replace("<#>", item2), "value");
   //String abd2=getCommand().storeValue("sub1", abd1);
   //getCommand().storeValue("sub1", m1);
	System.out.println("aaff"+m1);
	getCommand().waitFor(5);
	if(m.equals(m1))
	{
		SoftAssertion.fail("Failed:Price is not changed as expected");		
	}
	else 
	{
		log("user is able to do hand price in submitted order :"+m1,LogType.STEP);
		
	}
	
	return this;
}
public OrderPage Gpvalues()
{
	getCommand().waitFor(5);
	getCommand().click(ordergp1);
	//String ordergp1 = getCommand().getAttributeValue(ordergp , "class");
	//String ss3=getCommand().getAttributeValue(submittedhp,"title");
	String or_gp1 = getCommand().getText(ordergp1);
	getCommand().storeValue("or_gp1", or_gp1);
	getCommand().click(ordergp2);
	String or_gp2 = getCommand().getText(ordergp2);
	getCommand().storeValue("or_gp2", or_gp2);
	System.out.println("ordergp$"+ or_gp1 );
	System.out.println("ordergp%"+ or_gp2 );
	return this;
}
public OrderPage GpvaluesinOSR()
{
	 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	//String ss1=(String) getCommand().retrieveValue("refnum");
	//if( getCommand().isTargetPresent(refrencenum2.replace("<#>", ss1)));
		//String or_gp3 = getCommand().getAttributeValue(refrencenum2.replace("<#>", ss1), "title");
		//String or_gp4 = getCommand().getAttributeValue(refrencenum3.replace("<#>", ss1), "title");
	 	getCommand().click(OSRrefresh);
	 	getCommand().waitFor(3);
	 	getCommand().click(OSRrefresh);
	 	getCommand().waitFor(3);
	 	String or_gp3=getCommand().getAttributeValue(ordergpOSR1, "title");
		String g5="$"+or_gp3;
		String or_gp4=getCommand().getAttributeValue(ordergpOSR2, "title");
		//String g6="$"+or_gp4;
		System.out.println("or_gp3"+g5);
		System.out.println("or_gp4"+or_gp4);
		String g1=(String) getCommand().retrieveValue("or_gp1");
		String g2=(String) getCommand().retrieveValue("or_gp2");
		
		if(g5.equals(g1))
		{
			log("order Gp% value is same in OSR :"+g1,LogType.STEP);
		}
		else
		{
			SoftAssertion.fail("Failed OrderGP% value is not same in OSR tab");	
		}
		if(or_gp4.equals(g2))
		{
			log("order Gp$value is same in OSR :"+g1,LogType.STEP);
		}
		else
		{
			SoftAssertion.fail("Failed OrderGP$ value is not same in OSR tab");	
		}
		
	return this;
}
public OrderPage QOE ()
{
	getCommand().click(orderdropdown);
	//getCommand().waitFor(5);
	
	if(getCommand().isTargetPresent(QOE))
	{
		log("QOE option is present",LogType.STEP);	
	}
	getCommand().waitFor(2);
	getCommand().click(QOE);
	getCommand().waitFor(2);
	return this;
	
}


  public OrderPage verifyProductReminderModel(){

      (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	  getCommand().getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  String model_ProductRemainder="//*[@id='reminderModalOption2']";
	  if(getCommand().getDriver().findElement(By.xpath(model_ProductRemainder)).isDisplayed()){
        log("Product Remainder model is Displayed",LogType.STEP);
	  }
	  else{
		SoftAssertion.fail("Failed::Product remainder model is  Not Displayed as expected");
	  }
	   return this;
}
  public OrderPage verifySubstituteItemInModel(String strItem){

      (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	  System.out.println("Items====="+strItem);
	  if(getCommand().isTargetPresent(txt_Item.replace("<#>",strItem.trim()))){
        log(strItem+" Substitute item is Displayed",LogType.STEP);
	  }
	  else{
		SoftAssertion.fail("Failed::"+strItem+" Substitute item  is  Not Displayed as expected");
	  }
	   return this;
  }
  
  public OrderPage clickVerifyTickMarkAndYNButton(String strItem,String strKey){
	  
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		getCommand().waitForTargetPresent(img_TickMark.replace("<#>",strItem));
		if (getCommand().isTargetPresent(img_TickMark.replace("<#>",strItem))){
			log("Click On tick mark of substitute item.",LogType.STEP);	
			getCommand().click(img_TickMark.replace("<#>",strItem));
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='prefferProductAcceptanceButton']")).isDisplayed()){
				
				log("'Yes' button in preferred product acceptance model is Displayed as expected",LogType.STEP);
				
			}else{
				SoftAssertion.fail("'Yes' button in preferred product acceptance model is not Displayed as expected");
			}
			
			
             if(getCommand().getDriver().findElement(By.xpath("//*[@id='prefferProductResjectButton']")).isDisplayed()){
            	 
            	 log("'No' button in preferred product acceptance model is Displayed as expected",LogType.STEP);
            	 
			}else{
				SoftAssertion.fail("'No' button in preferred product acceptance model is not Displayed as expected");
			}
			
             
             //strKey is used to click on Yes or No button
             
             if(strKey.equalsIgnoreCase("N")){
            	 log("Click On No button",LogType.STEP);	
            	 getCommand().getDriver().findElement(By.xpath("//*[@id='prefferProductResjectButton']")).click();
             }
             else if(strKey.equalsIgnoreCase("Y")){
            	 log("Click On Yes button",LogType.STEP);	
            	 getCommand().getDriver().findElement(By.xpath("//*[@id='prefferProductAcceptanceButton']")).click(); 
             }
             
             
		}
		return this;
	}
  
  
  public OrderPage clickOnCloseButton(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		//Wait For the element to be available in IE
		new SupportFunctions().waitForStatic(5);
		getCommand().waitForTargetPresent(btn_Close);
		if (getCommand().isTargetPresent(btn_Close)){
			log("Click On Close button",LogType.STEP);	
			getCommand().click(btn_Close);
			
		}
		return this;
	}
  
  public OrderPage clickOnCrossImage(String strItem){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		//Wait For the element to be available in IE
		new SupportFunctions().waitForStatic(5);
		getCommand().getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		getCommand().waitForTargetPresent(img_CrossMark.replace("<#>",strItem));
		if (getCommand().isTargetPresent(img_CrossMark.replace("<#>",strItem))){
			log("Click On Croos mark to reject the items",LogType.STEP);	
			getCommand().click(img_CrossMark.replace("<#>",strItem));
		}
		return this;
	}
  
  
  public OrderPage clickOnContinueButtonOnOrderRemainder(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		//Wait For the element to be available in IE
		new SupportFunctions().waitForStatic(5);
		getCommand().waitForTargetPresent(btn_ContinueRemainder);
		if (getCommand().isTargetPresent(btn_ContinueRemainder)){
			log("Click On continue button",LogType.STEP);	
			getCommand().click(btn_ContinueRemainder);
			
		}
		return this;
	}
  
  
  public OrderPage clickOnConfirmListInPopup(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		//Wait For the element to be available in IE
		new SupportFunctions().waitForStatic(2);
		getCommand().waitForTargetPresent(btn_ConfirmRemainder);
		if (getCommand().isTargetPresent(btn_ConfirmRemainder)){
			log("Click On confirm button",LogType.STEP);	
			getCommand().click(btn_ConfirmRemainder);
			
		}
		return this;
	}
  

}


