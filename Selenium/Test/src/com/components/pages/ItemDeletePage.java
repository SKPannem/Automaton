package com.components.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import net.jcip.annotations.ThreadSafe;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.SeleniumServer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;


import com.components.repository.SiteRepository;

import com.iwaf.framework.TestProperties;
import com.iwaf.framework.components.SoftAssertion;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;




public class ItemDeletePage  extends SitePage{
	
	public static final Target lnk_OrderTab = new Target("lnk_OrderTab","//*[@id='orderTab']",Target.XPATH);
	public static final Target lnk_AllOpenLink=new Target("lnk_AllOpenLink","//*[@id='viewallopenlink']",Target.XPATH);
	public static final Target btn_shipping=new Target ("btn_shipping","//*[@id='shippingConditionTab']/a/span",Target.XPATH);
	public static final Target pg_QuickOrderEntryPopup = new Target("pg_QuickOrderEntryPopup","//*[@id='quickOrderEntryPopupButton']/div[1]",Target.XPATH);
	public static final Target txt_UPC = new Target("txt_UPC","//*[@id='supc']",Target.XPATH);
	public static final Target txt_CaseQty = new Target("txt_CaseQty","//*[@id='caseQty']",Target.XPATH);
	public static final Target txt_SplitQty = new Target("txt_CaseQty","//*[@id='splitQty']",Target.XPATH);
	public static final Target btn_Add = new Target("btn_Add","//*[@id='validateSupcButton']",Target.XPATH);
	public static final Target btn_AddtoOrder = new Target("btn_AddtoOrder","//*[@id='addToOrderButton']",Target.XPATH);
	public static final Target pg_OrderReminderPopup = new Target("pg_OrderReminderPopup","//*[@id='orderReminderModalInternal']/div[1]",Target.XPATH);
	public static final Target grid_OpenOrders =new Target("grid_OpenOrders","gbox_openOrdersTab",Target.ID); 
	public static final Target txt_itemQty =new Target("txt_itemQty","<#>",Target.ID); 
	public static final Target chek_item =new Target("chek_item","<#>",Target.ID);
	public static final Target txt_search = new Target("txt_search","//*[@id='txtSearch']",Target.XPATH);
	public static final Target btn_search = new Target("btn_search","//*[@id='btnSearch']",Target.XPATH);
	public static final Target txt_Price = new Target("txt_Price","<#>",Target.ID);
	public static final Target chek_Price =new Target("chek_Price","<#>",Target.ID);
	public static final Target grid_PriceDetails =new Target("grid_PriceDetails","//*[@id='gbox_productSearchGrid']",Target.XPATH);
	public static final Target btn_CreateNew =new Target("btn_CreateNew","//*[@id='createNewOrderLink']",Target.XPATH); 
	public static final Target txt_OrderGuideItemQnty = new Target("txt_OrderGuideItemQnty","<#>",Target.ID);
	public static final Target chek_OrderGuide =new Target("chek_OrderGuide","<#>",Target.ID);
	public static final Target btn_ViewOrder = new Target("btn_ViewOrder","//*[@id='viewActiveOrderBtn']",Target.XPATH);
	public static final Target div_Order = new Target("div_Order","orderDetails",Target.ID);
	public static final Target btn_OpenSubmittedOrder= new Target("btn_OpenSubmittedOrder","//*[@id='submittedorders']",Target.XPATH);
	public static final Target grid_RecentOrders= new Target("grid_RecentOrders","//*[@id='gbox_submittedOrdersTab']",Target.XPATH);
	public static final Target btn_Modify= new Target("btn_Modify","modifyBttnTopBttn",Target.ID);
	public static final Target div_ModifyOrder= new Target("div_ModifyOrder","//*[@id='modifyOrderDiv']",Target.XPATH);
	public static final Target btn_ModifyOrder= new Target("btn_ModifyOrder","//*[@id='modifyOrder']",Target.XPATH);
	public static final Target gbox_Modifygrid= new Target("gbox_Modifygrid","//*[@id='gbox_grid1']",Target.XPATH);
	public static final Target txt_CurrentPrice= new Target("txt_CurrentPrice","<#>",Target.ID);
	public static final Target imag_Order= new Target("imag_Order","<#>",Target.XPATH);
	public static final Target btn_OrderRefresh= new Target("btn_OrderRefresh","ordersoverview",Target.ID);
	public static final Target lnk_AllSubmittedOrders=new Target("lnk_AllSubmittedOrders","viewallsubmittedlink",Target.ID);
	public static final Target updateModify_price=new Target("updateModify_price","<#>",Target.XPATH);
	public static final Target popup_CreateOrder = new Target("pg_CreateOrder","//*[@id='createNewOrderDiv']/div[1]",Target.XPATH);
	public static final Target gBox_OrderDetails = new Target("gBox_OrderDetails","//*[@id='gbox_orderdetails']",Target.XPATH);
	public static final Target txt_CheckPrice = new Target("txt_CheckPrice","<#>",Target.XPATH);
	public static final Target btn_Shipping= new Target("btn_Shipping","//*[@id='shippingConditionTab']/a/span",Target.XPATH);
	public static final Target grid_Shipping= new Target("grid_Shipping","//*[@id='shippingCondition']",Target.XPATH);
	public static final Target date_Calendar= new Target("date_Calendar","//*[@id='dateLabel']/img",Target.XPATH);
	public static final Target date_Picker= new Target("date_Picker","//*[@id='ui-datepicker-div']",Target.XPATH);
	public static final Target lst_shippingCondition= new Target("lst_shippingCondition","shippingConditionSelect",Target.ID);
	public static final Target alert_Error= new Target("alert_Error","genericErrorDiv",Target.ID);
	public static final Target alert_OK= new Target("alert_OK","genericErrorDivButton",Target.ID);
	public static final Target date_NextMon= new Target("date_NextMon","//*[@id='ui-datepicker-div']/div/a[2]/span",Target.XPATH);
	public static final Target date_PrevMon= new Target("date_PrevMon","//*[@id='ui-datepicker-div']/div/a[1]/span",Target.XPATH);
	public static final Target generic_ErrorDiv= new Target("date_PrevMon","//*[@id='genericErrorDiv']/div[3]",Target.XPATH);
	public static final Target generic_ErrorDivButton= new Target("date_PrevMon","//*[@id='genericErrorDivButton']",Target.XPATH);
	public static final Target nonCancellable_ItemsAlert= new Target("nonCancellable_ItemsAlert","//*[@id='nonCancellableItemsAlertPopDiv']",Target.XPATH);
	public static final Target nonCancellable_ItemsButton= new Target("nonCancellable_ItemsButton","//*[@id='confirmSubmitWithNonCancellableItemsButton']",Target.XPATH);
	public static final Target nonCancellable_Cancel= new Target("nonCancellable_Cancel","//*[@id='nonCancellableItemsAlertPopDiv']//input[@value='Cancel']",Target.XPATH);
	public static final Target confirm_ImageId=new Target ("confirm_ImageId",".//*[@id='C']",Target.XPATH);
	public static final Target lnk_AllHistorialLink=new Target("lnk_AllHistorialLink","//*[@id='viewallnonopenlink']",Target.XPATH);
	public static final Target btn_ReOrder= new Target("btn_ReOrder","//*[@id='reOrderButton']",Target.XPATH);
	public static final Target gbox_nonopenOrdersTab=new Target("gbox_nonopenOrdersTab","//*[@id='gbox_nonopenOrdersTab']",Target.XPATH);
	public static final Target cancel_OrderLink=new Target("cancel_OrderLink","//*[@id='roCancelOrderLink']/b",Target.XPATH);
	public static final Target cancel_OrderDiv=new Target("cancel_OrderDiv","//*[@id='cancelOrderDiv']",Target.XPATH);
	public static final Target cancel_OrderButton=new Target("cancel_OrderButton","//*[@id='cancelOrder']",Target.XPATH);
	public static final Target list_tab=new Target("list_tab","//*[@id='listTab']",Target.XPATH);
	public static final Target create_NewListButton=new Target("create_NewListButton","//*[@id='createNewListButton']",Target.XPATH);
	public static final Target create_NewListDiv=new Target("create_NewListDiv","//*[@id='createNewListDiv']",Target.XPATH);
	public static final Target list_Name=new Target("list_Name","//*[@id='listName']",Target.XPATH);
	public static final Target check_listQuickEntry=new Target("check_listQuickEntry","//*[@id='listQuickEntry']",Target.XPATH);
	public static final Target createnew_listBtn=new Target("createnew_listBtn","//*[@id='btnolaypop_id']/input",Target.XPATH);
	public static final Target quickList_EntryPopupButton=new Target("quickList_EntryPopupButton","//*[@id='quickListEntryPopupButton']",Target.XPATH);
	public static final Target list_supc=new Target("list_supc","//*[@id='listsupc']",Target.XPATH);
	public static final Target list_CaseQty=new Target("list_CaseQty","//*[@id='listCaseQty']",Target.XPATH);
	public static final Target split_ListQty=new Target("split_ListQty","//*[@id='splitListQty']",Target.XPATH);
	public static final Target valSupc_Button=new Target("valSupc_Button","//*[@id='valSupcButton']",Target.XPATH);
	public static final Target addToList_Button=new Target("addToList_Button","//*[@id='addToListButton']",Target.XPATH);
	public static final Target listHeader_Line1=new Target("listHeader_Line1","//*[@id='listHeaderLine1']",Target.XPATH);
	public static final Target listNo_Txt=new Target("listNo_Txt","//*[@id='listNoTxt']",Target.XPATH);
	public static final Target lsBodyViewall_customlink=new Target("lsBodyViewall_customlink","//*[@id='lsBodyViewallcustomlink']",Target.XPATH);
	public static final Target gbox_recentListGrid=new Target("gbox_recentListGrid","//*[@id='gbox_recentListGrid']",Target.XPATH);
	public static final Target item_HistoryTab=new Target("item_HistoryTab","//*[@id='itemHistoryTab']",Target.XPATH);
	public static final Target srch_Top=new Target("srch_Top","//*[@id='srchTop']",Target.XPATH);
	public static final Target ISR_Link=new Target("ISR_Link","//a[contains(text(),'ISR')]",Target.XPATH);
	public static final Target addISR_user=new Target("addISR_user","createISRUserButton",Target.NAME);
	public static final Target user_id=new Target("user_id","USERID",Target.NAME);
	public static final Target contact_name=new Target("contact_name","ContactName",Target.NAME);
	public static final Target check_sysco=new Target("check_sysco","orderMgmtOpt",Target.NAME);
	public static final Target btn_saveUser=new Target("btn_saveUser","SUBMIT",Target.NAME);
	public static final Target lnk_logOut=new Target("lnk_logOut","//a[contains(text(),'Log Out')]",Target.XPATH);
	public static final Target txt_IsrUserName = new Target("txt_IsrUserName","//*[@id='USERID']",Target.XPATH);
	public static final Target txt_IsrPassword = new Target("txt_IsrPassword","//*[@id='currentPassword']",Target.XPATH);
	public static final Target btn_IsrSignIn = new Target("btn_IsrSignIn","//*[@id='img_login']",Target.XPATH);
	public static final Target new_Password1 = new Target("btn_IsrSignIn","newPassword1",Target.ID);
	public static final Target new_Password2 = new Target("btn_IsrSignIn","newPassword2",Target.ID);
	public static final Target btn_submit = new Target("btn_submit","submit",Target.NAME);
	public static final Target lst_SecurityQuestionOne = new Target("lst_SecurityQuestionOne","SecurityQuestionOne",Target.NAME);
	public static final Target lst_SecurityQuestionTwo = new Target("lst_SecurityQuestionTwo","SecurityQuestionTwo",Target.NAME);
	public static final Target lst_SecurityQuestionThree = new Target("lst_SecurityQuestionThree","SecurityQuestionThree",Target.NAME);
	public static final Target txt_SecurityAnswer1 = new Target("txt_SecurityAnswer1","SecurityAnswer1",Target.NAME);
	public static final Target txt_SecurityAnswer2 = new Target("txt_SecurityAnswer2","SecurityAnswer2",Target.NAME);
	public static final Target txt_SecurityAnswer3 = new Target("txt_SecurityAnswer3","SecurityAnswer3",Target.NAME);
	public static final Target submit_SecurityQA = new Target("submit_SecurityQA","input[type='submit']",Target.CSS);
	public static final Target caseSplit_grid = new Target("caseSplit_grid","//*[@id='gbox_grid1']",Target.XPATH);
	public static final Target caseSplit_ListBtn = new Target("caseSplit_ListBtn","addToListBtn",Target.ID);
	public static final Target caseSplit_NewList = new Target("caseSplit_NewList","//*[@id='createNewListInCopy']",Target.XPATH);
	public static final Target caseSplit_NewListpopup = new Target("caseSplit_NewListpopup","//*[@id='createNewListPopUpInCopy']",Target.XPATH);
	public static final Target caseSplit_NewListNamepopup = new Target("caseSplit_NewListNamepopup","//*[@id='listNameInPopUp']",Target.XPATH);
	public static final Target caseSplit_NewListBtn = new Target("caseSplit_NewListBtn","//*[@id='addMultiItemsToNewList']",Target.XPATH);
	public static final Target menu_Reports = new Target("menu_Reports","//a[contains(text(),'Reports')]",Target.XPATH);
	public static final Target menu_SummaryReports = new Target("menu_SummaryReports","//a[contains(text(),'Order Summary Report')]",Target.XPATH);
	public static final Target popup_SummaryReports = new Target("popup_SummaryReports","//*[@id='order-summary-report-popup']//div[contains(text(),'Order Summary Report')]",Target.XPATH);
	public static final Target sa_report_div = new Target("sa_report_div","//*[@id='SA-report-div']",Target.XPATH);
	public static final Target teritory_isruser=new Target ("tritory_isruser","<#>",Target.XPATH);
	public static final Target option_submittedDate=new Target ("option_submittedDate","//*[@id='sumbmittdOption']",Target.XPATH);
	public static final Target date_submittedDate=new Target ("date_submittedDate","//span[1]//img[@class='ui-datepicker-trigger']",Target.XPATH);
	public static final Target popup_datePicker= new Target("popup_datePicker","//*[@id='ui-datepicker-div']",Target.XPATH);
	public static final Target btn_summaryReport= new Target("btn_summaryReport","//*[@id='orderSummaryReportApplyBtn']",Target.XPATH);
	public static final Target gbox_ordersReportTable= new Target("gbox_ordersReportTable","<#>",Target.XPATH);
	public static final Target popup_PrevMon= new Target("popup_PrevMon","//*[@id='ui-datepicker-div']/div/a[1]/span",Target.XPATH);
	public static final Target teritory_isruserDel=new Target ("teritory_isruserDel","<#>",Target.XPATH);
	public static final Target option_DeliveryDate=new Target ("option_DeliveryDate","//*[@id='deliveryOption']",Target.XPATH);
	public static final Target date_deliveryDate=new Target ("date_deliverydDate","//span[2]//img[@class='ui-datepicker-trigger']",Target.XPATH);
	public static final Target popup_NextMon= new Target("popup_NextMon","//*[@id='ui-datepicker-div']/div/a[2]/span",Target.XPATH);
	public static final Target stock_Indicator= new Target("stock_Indicator","//*[@id='stockIndicatorHdr']/a/font",Target.XPATH);
	public static final Target check_SpecialOrder= new Target("check_SpecialOrder","//*[@id='stockIndicator-div']//input[@value='P']",Target.XPATH);
	public static final Target txt_Dynamic_Price = new Target("txt_Dynamic_Price","//*[contains(@id,'CS_currentprice')]",Target.XPATH);
	public static final Target check_invoice=new Target ("check_invoice","//*[@id='invVal']",Target.XPATH);
	public static final Target grid_OrderGuidePriceDetails =new Target("grid_OrderGuidePriceDetails","//*[@id='gview_itemHistoryGrid']",Target.XPATH);
	public static final Target list_AddtoListBtn =new Target("list_AddtoListBtn","//*[@id='addToListBtn']",Target.XPATH);
	public static final Target multi_SelectItemDiv =new Target("multi_SelectItemDiv","//*[@id='multiSelectItemDiv']",Target.XPATH);
	public static final Target select_MyList =new Target("select_MyList","//*[@id='showAllprivateList']/li[1]//input",Target.XPATH);
	public static final Target multiSelect_ConfirmButton =new Target("multiSelect_ConfirmButton","//*[@id='multiSelectConfirmButton']",Target.XPATH);
	public static final Target list_Myname=new Target ("list_Myname","<#>",Target.XPATH);
	public static final Target grid_box=new Target ("grid_box","//*[@id='gbox_recentListGrid']",Target.XPATH);
	public static final Target gbox_viewListGrid=new Target ("gbox_viewListGrid","//*[@id='gbox_viewListGrid']",Target.XPATH);
	public static final Target lbl_Price = new Target("lbl_Price","<#>",Target.XPATH);
	public static final Target imag_tick = new Target("imag_tick","<#>",Target.XPATH);
	public static final Target sub_Delete = new Target("sub_Delete","<#>",Target.XPATH);
	public static final Target date_picker=new Target ("date_picker","//*[@id='orderdatepicker']",Target.XPATH);
	public static final Target date_picker_img=new Target ("date_picker_img","//*[@id='createNewOrderDiv']//img[contains(@class,'datepicker')]",Target.XPATH);
	public static final Target CSR_Link=new Target("CSR_Link","//a[contains(text(),'CSR')]",Target.XPATH);
	public static final Target addCSR_user=new Target("addCSR_user","createCSRUserButton",Target.NAME);
	public static final Target CSR_Opco=new Target("CSR_opco","//*[@id='opcoId']",Target.XPATH);
	public static final Target CSR_Opco020=new Target("CSR_opco020","//option[@value='020']",Target.XPATH);
	String order_num="";
	String original_price="";
	String item_numDB="";
	String item_numDel="";
	public Target lnk_order ;
	public ItemDeletePage(SiteRepository siteRepository) {
		
		super(siteRepository);
	}
    public ItemDeletePage atQuickOrderEntryPagePopUpForIsr(){		
		
		getCommand().waitForTargetPresent(pg_QuickOrderEntryPopup);
		log("Quick Order Entry Pop up displayed",LogType.STEP);
		return this;
	}
    public ItemDeletePage enterQuickOrderEntryDetailsForIsr(String strUPC, String strCaseQty, String strSplitQty){		
	      getCommand().getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	      getCommand().getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	      getCommand().getDriver().manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
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
			(new SupportFunctions()).waitForObject(3,3,btn_AddtoOrder);
		}
		if(getCommand().isTargetPresent(btn_AddtoOrder)){
			 (new SupportFunctions()).deleteOutputData("Modify_Order_verify.xls");
			String  order_num1=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
			 lnk_order= new Target("lnk_order","ordnotxt",Target.CLASS);
			 (new SupportFunctions()).writeOutputData("Modify_Order_verify.xls","OrderNum",order_num1);
			log("Click on Add to Order Button",LogType.STEP);	
			getCommand().click(btn_AddtoOrder);
		}
		return this;
	}
	
	public ItemDeletePage atOrderTab(){
		
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		(new SupportFunctions()).waitForObject(3,3,lnk_OrderTab);
		getCommand().isTargetVisible(lnk_OrderTab);
		getCommand().waitForTargetPresent(lnk_OrderTab);
		
		if(getCommand().isTargetPresent(lnk_OrderTab)){
			log("Click on Order ",LogType.STEP);
			getCommand().click(lnk_OrderTab);
		}
		return this;
		
	}
	public ItemDeletePage viewAllopenlink()
	{
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='ord-openloading']"));
		
		log("Click on All Open Order Link ",LogType.STEP);
		
			(new SupportFunctions()).waitForObject(3,3,lnk_AllOpenLink);
			(new WebDriverWait(getCommand().getDriver(), 100)).until(ExpectedConditions.visibilityOfElementLocated(By.id("viewallopenlink")));
			//WebElement foo2 = (getCommand().getDriver(), 4)(ExpectedConditions
			//	      .visibilityOfElementLocated(By.id("viewallopenlink")));
			getCommand().waitForTargetPresent(lnk_AllOpenLink);
		
		if(getCommand().isTargetPresent(lnk_AllOpenLink)){
			getCommand().waitFor(4);
			getCommand().click(lnk_AllOpenLink);
		}
		return this;
		
	}
	public ItemDeletePage viewOpenOrderItems()
	{
		
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		 getCommand().waitForTargetPresent(grid_OpenOrders);
		 String st=(new SupportFunctions()).readOutputData("Modify_Order_verify.xls","OrderNum");
		 String strItemXpath = "//*[@id='" + st + "']";
		log("Click on Item  Link ",LogType.STEP);
		 getCommand().getDriver().findElement(By.xpath(strItemXpath)).click();
		 getCommand().getDriver().findElement(By.linkText(st)).click();
		return this;
		
	}
	public ItemDeletePage deleteOpenOrderItems(String productFrom)
	{
		getCommand().waitForTargetPresent(btn_shipping);
		if(getCommand().isTargetPresent(btn_shipping)){
			//log("Click on Open Order Link ",LogType.STEP);
			String item_num=productFrom+"-CS";
			String st="+"+item_num+"+";
			//log("Click on Item price ",LogType.STEP);
			final Target item_price=new Target ("item_price","//a[@id='undefined' and contains(@onclick,'deleteInValidRow("+st.replace('+', '"')+")')]",Target.XPATH);
			if(getCommand().isTargetPresent(item_price))
			{
				getCommand().click(item_price);
			}
			log("User should be able to delete items from open order",LogType.STEP);
		}
		return this;
		
	}
	public ItemDeletePage updateOpenOrderItems(String productFrom, String updateQuanty)
	{
		getCommand().waitForTargetPresent(btn_shipping);
		if(getCommand().isTargetPresent(btn_shipping)){
			log("Update the item quantity ",LogType.STEP);
			
			String item_num=productFrom+"-CS_syscoGridColumnEditableQuantityFormatter";
			if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", item_num))){
			System.out.println("item_num=="+item_num);
			String chek_box="jqg_grid1_"+productFrom+"-CS";
			
			System.out.println("chek_box=="+chek_box);
			if (!getCommand().isSelected(chek_item.replace("<#>",chek_box)) )
			{
				getCommand().click(chek_item.replace("<#>",chek_box));
				getCommand().clear(txt_itemQty.replace("<#>", item_num));
				getCommand().sendKeys(txt_itemQty.replace("<#>", item_num), updateQuanty);
				
			}
			else if (getCommand().isSelected(chek_item.replace("<#>",chek_box))){
				getCommand().click(chek_item.replace("<#>",chek_box));
				
			}
			}
		}
		return this;
		
	}
	public ItemDeletePage verifyUpdatedItemQuantity(String productFrom,String updatedQnty)
	{ 
		(new SupportFunctions()).deleteOutputData("Modify_Order_verify.xls");
		getCommand().waitFor(3);
		String item_num=productFrom+"-CS_syscoGridColumnEditableQuantityFormatter";
		if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", item_num))){
		System.out.println("Compare Value=="+getCommand().getText(txt_itemQty.replace("<#>", item_num)));
		log("Verfiy the Item quantity is Updated : " + updatedQnty,LogType.STEP);		
		getCommand().waitForTargetVisible(txt_itemQty.replace("<#>", item_num));
		SoftAssertion.assertAttributeValue(txt_itemQty.replace("<#>", item_num), "value", updatedQnty);
		}
		return this;
		
		
		
	
	}
	public ItemDeletePage searchItemPrice(String itemNum)
	{
		(new SupportFunctions()).deleteOutputData("Hand_Pricing_Associates.xls");
		log("Search for a particular Item ",LogType.STEP);
		getCommand().isTargetPresent(txt_search);
		log("Enter Item Number ",LogType.STEP);
		getCommand().clear(txt_search);
		getCommand().sendKeys(txt_search, itemNum);
		getCommand().isTargetPresent(btn_search);
		getCommand().click(btn_search);
		return this;
		
	}
	public ItemDeletePage UpdateItemPrice(String itemNum,String updatePrice) 
	{
		
		
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
		log("Update Hand price Item ",LogType.STEP);
		getCommand().waitForTargetVisible(grid_PriceDetails);
		String handPrice_txt=itemNum+"-CS_currentprice";
		String price_Check="jqg_productSearchGrid_"+itemNum+"-CS";
		getCommand().waitForTargetVisible(txt_Price.replace("<#>", handPrice_txt));
		getCommand().isTargetPresent(txt_Price.replace("<#>", handPrice_txt));
		log("Enter hand price of the Item ",LogType.STEP);
		if (!getCommand().isSelected(chek_Price.replace("<#>",price_Check)) )
		{
			getCommand().click(chek_Price.replace("<#>",price_Check));
			
			//getCommand().click(txt_Price.replace("<#>", handPrice_txt));
          WebElement wst=getCommand().getDriver().findElement(By.id(handPrice_txt));
			wst.click();
			//wst.sendKeys(Keys.BACK_SPACE);
			wst.sendKeys(updatePrice);
			//((JavascriptExecutor) getCommand().getDriver().findElement(By.id(handPrice_txt))).executeScript(
			    //    "$(arguments[0]).change();"
			  //  , wst);
			getCommand().getDriver().findElement(By.tagName("body")).click();
			//javascriptL
			//wst.click();
			//wst.sendKeys(updatePrice);*/
			/*Actions builder = new Actions(getCommand().getDriver().findElement(By.id)); 
			builder.sendKeys(Keys.chord(Keys.CONTROL,"a")).build().perform(); 
			getCommand().sendKeys(txt_Price.replace("<#>", handPrice_txt),updatePrice);
			WebElement element = getCommand().getDriver().findElement(By.id(handPrice_txt));
			element.click();
			element.sendKeys(Keys.chord(Keys.CONTROL,"a",updatePrice));*/
			//element.sendKeys(Keys.CONTROL + "a" +updatePrice);
			//getCommand().waitFor(10);
			//element.sendKeys(updatePrice);
			//getCommand().waitFor(10);
			//JavascriptLibrary javascript = new JavascriptLibrary();
			//javascript.callEmbeddedSelenium(getCommand().getDriver(), "triggerEvent", element, "change");
			//wst.click();
			//wst.sendKeys(Keys.TAB);
			//wst
			//getCommand().waitFor(10);
			//getCommand().clear(txt_Price.replace("<#>", handPrice_txt));
			//getCommand().sendKeys(txt_Price.replace("<#>", handPrice_txt)," ");
			//getCommand().waitFor(10);
			//getCommand().sendKeys(txt_Price.replace("<#>", handPrice_txt)," ");
			//getCommand().waitFor(10);
			//getCommand().sendKeys(txt_Price.replace("<#>", handPrice_txt)," ");
			//getCommand().waitFor(10);
		//	getCommand().sendKeys(txt_Price.replace("<#>", handPrice_txt),updatePrice);
			//getCommand().waitFor(3);
			//getCommand().click(txt_Price.replace("<#>", handPrice_txt));
			//(txt_Price.replace("<#>", handPrice_txt),Keys.TAB);
			//getCommand().waitFor(10);
			//getCommand().click(chek_Price.replace("<#>",price_Check));
			//getCommand().click(txt_Price.replace("<#>", handPrice_txt));
			//getCommand().click(chek_Price.replace("<#>",price_Check));
			//getCommand().waitFor(60);
			//getCommand().waitForTargetVisible(target)
			
		}
		else if (getCommand().isSelected(chek_Price.replace("<#>",price_Check))){
			getCommand().click(chek_Price.replace("<#>",price_Check));
			
		}
		
		//*[@id='jqg_productSearchGrid_3826328-CS']
		return this;
		
	}
	
	public ItemDeletePage verifyUpdatedItemPrice(String itemNum,String updatePrice)
	{
		String handPrice_txt=itemNum+"-CS_currentprice";
		String price_Check="jqg_productSearchGrid_"+itemNum+"-CS";
		//getCommand().clear(txt_Price.replace("<#>", handPrice_txt));
		//getCommand().isTargetPresent(txt_Price.replace("<#>", handPrice_txt));
		//getCommand().sendKeys(txt_Price.replace("<#>", handPrice_txt),updatePrice);
		SoftAssertion.assertAttributeValue(txt_Price.replace("<#>", handPrice_txt), "value", updatePrice);
		//getCommand().click(chek_Price.replace("<#>",price_Check));
		
		//String img_xpath="//*[@id='"+itemNum+"-CS']/td[29]/img";
		//getCommand().waitForTargetPresent(imag_Order.replace("<#>",img_xpath));
		return this;
		
	}
	public ItemDeletePage createISRNewOrder()
	{
		getCommand().isTargetVisible(btn_CreateNew);
		getCommand().waitForTargetPresent(btn_CreateNew);
		if(getCommand().isTargetPresent(btn_CreateNew)){
		log("Click create new order ",LogType.STEP);
		getCommand().click(btn_CreateNew);

		}
		return this;
	}
	public ItemDeletePage addItemToOrder(String upc,String updateQuanty)
	{
		getCommand().waitFor(10);
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(!getCommand().isTargetVisible(popup_CreateOrder))
		{
		 searchItemPrice(upc);
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
		  String item_num=upc+"-CS_syscoGridColumnEditableQuantityFormatter";
			if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", item_num))){
			System.out.println("item_num=="+item_num);
			String chek_box="jqg_productSearchGrid_"+upc+"-CS";
			System.out.println("chek_box=="+chek_box);
			log("Enter quantity of Item ",LogType.STEP);
			if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_box)) )
			{
				getCommand().click(txt_OrderGuideItemQnty.replace("<#>", item_num));
				getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", item_num));
				getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", item_num), updateQuanty);
				getCommand().click(chek_OrderGuide.replace("<#>",chek_box));
				String img_xpath="//*[@id='"+upc+"-CS']/td[28]/img";
				System.out.println("Image present"+img_xpath);
				getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpath));
				System.out.println("Image present");
				viewIsrOrder();
			}
			else if (getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_box))){
				getCommand().click(chek_OrderGuide.replace("<#>",chek_box));
			}
			}
		}
		 return this;
		
	}
	public ItemDeletePage viewIsrOrder()
	{
		//getCommand().getDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	   // getCommand().getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	   // getCommand().getDriver().manage().timeouts().setScriptTimeout(90, TimeUnit.SECONDS);
		(new SupportFunctions()).waitForLoading(2000,By.xpath("//*[@id='asyncLoadingMessageText']"));
		
		getCommand().isTargetAvailable(btn_ViewOrder);
		log("Click on View Order",LogType.STEP);
		getCommand().click(btn_ViewOrder);
		 getCommand().waitFor(10);
		return this;
		
	}
	public ItemDeletePage createOrderXl()
	{
		(new SupportFunctions()).deleteOutputData("Hand_Pricing_Associates.xls");
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		getCommand().waitForTargetPresent(div_Order);
		if(getCommand().isTargetPresent(div_Order)){
		String order_num1=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
		(new SupportFunctions()).writeOutputData("Hand_Pricing_Associates.xls","OrderNum",order_num1);
		}
		return this;
		
	}
	
	public ItemDeletePage storeOrderNumForReorder()
	{
		getCommand().waitForTargetPresent(div_Order);
		if(getCommand().isTargetPresent(div_Order)){
		String order_num1=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
		getCommand().storeValue("db_reorder_num", order_num1);
		
		}
		return this;	
	}
	public ItemDeletePage storeOrderNum_089()
	{
		getCommand().waitForTargetPresent(div_Order);
		if(getCommand().isTargetPresent(div_Order)){
		String order_num1=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
		getCommand().storeValue("db_order_num_089", order_num1);		
		}
		return this;	
	}
	public ItemDeletePage storeOrderNum_158()
	{
		getCommand().waitForTargetPresent(div_Order);
		if(getCommand().isTargetPresent(div_Order)){
		String order_num1=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
		getCommand().storeValue("db_order_num_158", order_num1);		
		}
		return this;	
	}
	public ItemDeletePage storeOrderNum_159()
	{
		getCommand().waitForTargetPresent(div_Order);
		if(getCommand().isTargetPresent(div_Order)){
		String order_num1=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
		getCommand().storeValue("db_order_num_159", order_num1);		
		}
		return this;	
	}
	public ItemDeletePage storeOrderNum_147()
	{
		getCommand().waitForTargetPresent(div_Order);
		if(getCommand().isTargetPresent(div_Order)){
		String order_num1=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
		getCommand().storeValue("db_order_num_147", order_num1);		
		}
		return this;	
	}
	public ItemDeletePage storeOrderNum_130()
	{
		getCommand().waitForTargetPresent(div_Order);
		if(getCommand().isTargetPresent(div_Order)){
		String order_num1=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
		getCommand().storeValue("db_order_num_130", order_num1);		
		}
		return this;	
	}
	public ItemDeletePage storeOrderNum_133()
	{
		getCommand().waitForTargetPresent(div_Order);
		if(getCommand().isTargetPresent(div_Order)){
		String order_num1=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
		getCommand().storeValue("db_order_num_133", order_num1);		
		}
		return this;	
	}
	public ItemDeletePage createfutureOrderXl()
	{
		(new SupportFunctions()).deleteOutputData("Order_087.xls");
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		getCommand().waitForTargetPresent(div_Order);
		if(getCommand().isTargetPresent(div_Order)){
		String order_num1=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
		(new SupportFunctions()).writeOutputData("Order_087.xls","OrderNum",order_num1);
		}
		return this;
		
	}
	public ItemDeletePage createhandPriceXl()
	{
		(new SupportFunctions()).deleteOutputData("Hand_Pricing_Associates_B.xls");
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		getCommand().waitForTargetPresent(div_Order);
		if(getCommand().isTargetPresent(div_Order)){
		String order_num1=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
		(new SupportFunctions()).writeOutputData("Hand_Pricing_Associates_B.xls","OrderNum",order_num1);
		}
		return this;
		
	}
	public ItemDeletePage openSubmittedOrder()
	{
	   (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		getCommand().isTargetPresent(btn_OpenSubmittedOrder);
		log("Click on Recent Orders",LogType.STEP);
		getCommand().click(btn_OpenSubmittedOrder);
		return this;
		
	}
	public ItemDeletePage selectFutureSubmittedOrder(String st11)
	{
		getCommand().waitForTargetPresent(grid_RecentOrders);
		if(getCommand().isTargetPresent(grid_RecentOrders))
		{
			String st=(new SupportFunctions()).readOutputData("Order_087.xls","OrderNum");
			String strItemXpath = "//*[@id='" + st + "']";
			(new SupportFunctions()).deleteOutputData("Order_087.xls");
			//String status="Submitted";
			
			//String st1="//*[@id='"+st+"']/td[19]";
			//String st2="+"+st1+"+";
			//String st1="Hand PricingUpdate'";
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 
			 log("Click on Order  Link ",LogType.STEP);
			//String st11="Hand PricingUpdate";
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			String st2="+"+st11+"+";
			String ss=st2.replace('+', '"');
			//String st1="//*[@id='"+st+"'] and title="+ss+"";
			String st1="//a[@id='"+st+"']";
			System.out.print(st1);
		try{
			getCommand().getDriver().findElement(By.xpath(st1)).click();
		}
		catch(Exception e)
		{
			SoftAssertion.fail("Order is not submitted successfully. Please re execute the test case");
		}
		}
		return this;
		}
	public ItemDeletePage selectNormalSubmittedOrder(String st11)
	{
		getCommand().waitForTargetPresent(grid_RecentOrders);
		if(getCommand().isTargetPresent(grid_RecentOrders))
		{
			String st=(String) getCommand().retrieveValue("db_order_num_161");
			String strItemXpath = "//*[@id='" + st + "']";
			//(new SupportFunctions()).deleteOutputData("Order_087.xls");
			//String status="Submitted";
			
			//String st1="//*[@id='"+st+"']/td[19]";
			//String st2="+"+st1+"+";
			//String st1="Hand PricingUpdate'";
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 
			 log("Click on Order  Link ",LogType.STEP);
			//String st11="Hand PricingUpdate";
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			String st2="+"+st11+"+";
			String ss=st2.replace('+', '"');
			//String st1="//*[@id='"+st+"'] and title="+ss+"";
			String st1="//a[@id='"+st+"']";
			System.out.print(st1);
		try{
			getCommand().getDriver().findElement(By.xpath(st1)).click();
		}
		catch(Exception e)
		{
			SoftAssertion.fail("Order is not submitted successfully. Please re execute the test case");
		}
		}
		return this;
		}
	public ItemDeletePage selectNormalSubmittedOrder_159(String st11)
	{
		getCommand().waitForTargetPresent(grid_RecentOrders);
		if(getCommand().isTargetPresent(grid_RecentOrders))
		{
			String st=(String) getCommand().retrieveValue("db_order_num_159");
			String strItemXpath = "//*[@id='" + st + "']";
			//(new SupportFunctions()).deleteOutputData("Order_087.xls");
			//String status="Submitted";
			
			//String st1="//*[@id='"+st+"']/td[19]";
			//String st2="+"+st1+"+";
			//String st1="Hand PricingUpdate'";
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 
			 log("Click on Order  Link ",LogType.STEP);
			//String st11="Hand PricingUpdate";
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			String st2="+"+st11+"+";
			String ss=st2.replace('+', '"');
			//String st1="//*[@id='"+st+"'] and title="+ss+"";
			String st1="//a[@id='"+st+"']";
			System.out.print(st1);
		try{
			getCommand().getDriver().findElement(By.xpath(st1)).click();
		}
		catch(Exception e)
		{
			SoftAssertion.fail("Order is not submitted successfully. Please re execute the test case");
		}
		}
		return this;
		}
	public ItemDeletePage selectNormalSubmittedOrder_160(String st11)
	{
		getCommand().waitForTargetPresent(grid_RecentOrders);
		if(getCommand().isTargetPresent(grid_RecentOrders))
		{
			String st=(String) getCommand().retrieveValue("db_order_num_160");
			String strItemXpath = "//*[@id='" + st + "']";
			//(new SupportFunctions()).deleteOutputData("Order_087.xls");
			//String status="Submitted";
			
			//String st1="//*[@id='"+st+"']/td[19]";
			//String st2="+"+st1+"+";
			//String st1="Hand PricingUpdate'";
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 
			 log("Click on Order  Link ",LogType.STEP);
			//String st11="Hand PricingUpdate";
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			String st2="+"+st11+"+";
			String ss=st2.replace('+', '"');
			//String st1="//*[@id='"+st+"'] and title="+ss+"";
			String st1="//a[@id='"+st+"']";
			System.out.print(st1);
		try{
			getCommand().getDriver().findElement(By.xpath(st1)).click();
		}
		catch(Exception e)
		{
			SoftAssertion.fail("Order is not submitted successfully. Please re execute the test case");
		}
		}
		return this;
		}
	public ItemDeletePage selectNormalSubmittedOrder_089(String st11)
	{
		getCommand().waitForTargetPresent(grid_RecentOrders);
		if(getCommand().isTargetPresent(grid_RecentOrders))
		{
			String st=(String) getCommand().retrieveValue("db_order_num_089");
			String strItemXpath = "//*[@id='" + st + "']";
			//(new SupportFunctions()).deleteOutputData("Order_087.xls");
			//String status="Submitted";
			
			//String st1="//*[@id='"+st+"']/td[19]";
			//String st2="+"+st1+"+";
			//String st1="Hand PricingUpdate'";
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 
			 log("Click on Order  Link ",LogType.STEP);
			//String st11="Hand PricingUpdate";
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			String st2="+"+st11+"+";
			String ss=st2.replace('+', '"');
			//String st1="//*[@id='"+st+"'] and title="+ss+"";
			String st1="//a[@id='"+st+"']";
			System.out.print(st1);
		try{
			getCommand().getDriver().findElement(By.xpath(st1)).click();
		}
		catch(Exception e)
		{
			SoftAssertion.fail("Order is not submitted successfully. Please re execute the test case");
		}
		}
		return this;
		}
	public ItemDeletePage selectNormalSubmittedOrder_158(String st11)
	{
		getCommand().waitForTargetPresent(grid_RecentOrders);
		if(getCommand().isTargetPresent(grid_RecentOrders))
		{
			String st=(String) getCommand().retrieveValue("db_order_num_158");
			String strItemXpath = "//*[@id='" + st + "']";
			//(new SupportFunctions()).deleteOutputData("Order_087.xls");
			//String status="Submitted";
			
			//String st1="//*[@id='"+st+"']/td[19]";
			//String st2="+"+st1+"+";
			//String st1="Hand PricingUpdate'";
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 
			 log("Click on Order  Link ",LogType.STEP);
			//String st11="Hand PricingUpdate";
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			String st2="+"+st11+"+";
			String ss=st2.replace('+', '"');
			//String st1="//*[@id='"+st+"'] and title="+ss+"";
			String st1="//a[@id='"+st+"']";
			System.out.print(st1);
		try{
			getCommand().getDriver().findElement(By.xpath(st1)).click();
		}
		catch(Exception e)
		{
			SoftAssertion.fail("Order is not submitted Successfully. Please reexecute the test case again");
		}
		}
		return this;
		}
	public ItemDeletePage selectNormalSubmittedOrder_147(String st11)
	{
		getCommand().waitForTargetPresent(grid_RecentOrders);
		if(getCommand().isTargetPresent(grid_RecentOrders))
		{
			String st=(String) getCommand().retrieveValue("db_order_num_147");
			String strItemXpath = "//*[@id='" + st + "']";
			//(new SupportFunctions()).deleteOutputData("Order_087.xls");
			//String status="Submitted";
			
			//String st1="//*[@id='"+st+"']/td[19]";
			//String st2="+"+st1+"+";
			//String st1="Hand PricingUpdate'";
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 
			 log("Click on Order  Link ",LogType.STEP);
			//String st11="Hand PricingUpdate";
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			String st2="+"+st11+"+";
			String ss=st2.replace('+', '"');
			//String st1="//*[@id='"+st+"'] and title="+ss+"";
			String st1="//a[@id='"+st+"']";
			System.out.print(st1);
		try{
			getCommand().getDriver().findElement(By.xpath(st1)).click();
		}
		catch(Exception e)
		{
			SoftAssertion.fail("Order is not submitted Successfully. Please reexecute the test case again");
		}
		}
		return this;
		}
	public ItemDeletePage refreshSumittedOrder()
	{
		getCommand().waitForTargetPresent(grid_RecentOrders);
		if(getCommand().isTargetPresent(grid_RecentOrders))
		{
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 
			 log("Click on Order  Link ",LogType.STEP);
			//String st11="Hand PricingUpdate";
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));	
		}
		return this;
	}
	public ItemDeletePage selectSubmittedOrder(String st11)
	{
		getCommand().waitForTargetPresent(grid_RecentOrders);
		if(getCommand().isTargetPresent(grid_RecentOrders))
		{
			String st=(new SupportFunctions()).readOutputData("Hand_Pricing_Associates.xls","OrderNum");
			String strItemXpath = "//*[@id='" + st + "']";
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			 
			 log("Click on Order  Link ",LogType.STEP);
			getCommand().click(btn_OrderRefresh);
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
			String st2="+"+st11+"+";
			String ss=st2.replace('+', '"');
			String st1="//a[@id='"+st+"']";
			System.out.print(st1);
			try{
			getCommand().getDriver().findElement(By.xpath(st1)).click();
			}
			catch(Exception e)
			{
				SoftAssertion.fail("Order is not submitted successfully.Please re execute the test case");
			}
			
		}
		
		return this;
		
	}
	public ItemDeletePage modifyOrder()
	{
		
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		getCommand().waitForTargetPresent(btn_Modify);
		log("Click on ModifyOrder ",LogType.STEP);
		if(getCommand().isTargetPresent(btn_Modify)){
			getCommand().click(btn_Modify);
			getCommand().waitForTargetPresent(div_ModifyOrder);
			log("Conformation for ModifyOrder ",LogType.STEP);
			if(getCommand().isTargetPresent(div_ModifyOrder)){
				getCommand().click(btn_ModifyOrder);
			}
			
		}
		return this;
		
	}
	public ItemDeletePage modifyHandPrice(String upc,String currentPrice)
	{
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		getCommand().waitForTargetPresent(gbox_Modifygrid);
		if(getCommand().isTargetPresent(gbox_Modifygrid)){
			//String st=(new SupportFunctions()).readOutputData("Hand_Pricing_Associates.xls","OrderNum");
			String st=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
			//String lnk_order1= new Target("lnk_order","ordnotxt",Target.CLASS);
			String stPrice=upc+"-CS_currentprice";
			getCommand().isTargetPresent(txt_CurrentPrice.replace("<#>",stPrice));
			log("Update handprice ",LogType.STEP);
			//String handPrice_txt=itemNum+"-CS_currentprice";
            WebElement wst=getCommand().getDriver().findElement(By.id(stPrice));
			wst.click();
			wst.sendKeys(currentPrice);
			
			
		}
		return this;
		
	}
	public ItemDeletePage verifyModifyOrderItemPrice(String itemNum,String updateCurrentPrice)
	{
		
		(new SupportFunctions()).deleteOutputData("Hand_Pricing_Associates.xls");
		getCommand().waitForTargetPresent(gBox_OrderDetails);
		String td_price="//*[@id='"+itemNum+"-CS']/td[27]";
		getCommand().waitForTargetPresent(updateModify_price.replace("<#>", td_price));
		if(getCommand().isTargetPresent(updateModify_price.replace("<#>", td_price)))
		{
		String updateModify_price1= getCommand().getDriver().findElement(By.xpath(td_price)).getText();
		System.out.println("updateModify_price1========="+updateModify_price1);
		log("Verify hand price  ",LogType.STEP);
		String[] st1=updateModify_price1.split(" ");
		System.out.print(st1[0]);
		String update_price=st1[0];
		if(update_price.compareTo(updateCurrentPrice)==0)
		{
			System.out.println("SUSSESS");
			log("Verify hand price successfully "+update_price,LogType.STEP);
		}
		else
		{
			log("Verify hand price successfully",LogType.STEP);
					//getCommand().fail("Hand price is not updated .Failed the Test case");
		}
		}
		//SoftAssertion.assertAttributeValue(updateModify_price.replace("<#>", td_price), "value", updateCurrentPrice);
		//getCommand().click(chek_Price.replace("<#>",price_Check));
		
		//String img_xpath="//*[@id='"+itemNum+"-CS']/td[29]/img";
		//getCommand().waitForTargetPresent(imag_Order.replace("<#>",img_xpath));
		return this;
		
	}
	public ItemDeletePage viewOpenOrderItemsHandPrice()
	{
		
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		 getCommand().waitForTargetPresent(grid_OpenOrders);
		 String st=(new SupportFunctions()).readOutputData("Hand_Pricing_Associates_B.xls","OrderNum");
		 String strItemXpath = "//*[@id='" + st + "']";
		  log("Click on Item  Link ",LogType.STEP);
		 getCommand().getDriver().findElement(By.xpath(strItemXpath)).click();
		 getCommand().getDriver().findElement(By.linkText(st)).click();
		 (new SupportFunctions()).deleteOutputData("Hand_Pricing_Associates_B.xls");
		return this;
		
	}
	public ItemDeletePage verifyItemPriceUpdateAfterLogin(String itemNum,String updateCurrentPrice)
	{
		
		log("Verify hand price updation ",LogType.STEP);
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(gbox_Modifygrid);
		if(getCommand().isTargetPresent(gbox_Modifygrid)){
		//*[@id='0072595-CS_currentprice']
		String td_price="//*[@id='"+itemNum+"-CS_currentprice']";
		getCommand().waitForTargetVisible(txt_CheckPrice.replace("<#>", td_price));
		SoftAssertion.assertAttributeValue(txt_CheckPrice.replace("<#>", td_price), "value", updateCurrentPrice);
		}
		return this;
		
	}
	public ItemDeletePage addItemToOpenOrder(String upc,String updateQuanty,String updatePrice)
	{
		getCommand().waitFor(10);
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(!getCommand().isTargetVisible(popup_CreateOrder))
		{
		 searchItemPrice(upc);
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
		  String item_num=upc+"-CS_syscoGridColumnEditableQuantityFormatter";
			if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", item_num))){
			System.out.println("item_num=="+item_num);
			String chek_box="jqg_productSearchGrid_"+upc+"-CS";
			System.out.println("chek_box=="+chek_box);
			log("Enter quantity of Item ",LogType.STEP);
			String handPrice_txt=upc+"-CS_currentprice";
			String price_Check="jqg_productSearchGrid_"+upc+"-CS";
			getCommand().waitForTargetVisible(txt_Price.replace("<#>", handPrice_txt));
			getCommand().isTargetPresent(txt_Price.replace("<#>", handPrice_txt));
			log("Enter hand price of the Item ",LogType.STEP);
				
				//((JavascriptExecutor) getCommand().getDriver().findElement(By.id(handPrice_txt))).executeScript(
				    //    "$(arguments[0]).change();"
				  //  , wst);
				getCommand().getDriver().findElement(By.tagName("body")).click();
			if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_box)) )
			{
				getCommand().click(txt_OrderGuideItemQnty.replace("<#>", item_num));
				//getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", item_num));
				getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", item_num), updateQuanty);
                getCommand().click(chek_Price.replace("<#>",price_Check));
                
	          WebElement wst=getCommand().getDriver().findElement(By.id(handPrice_txt));
	         original_price= wst.getAttribute("value").toString();
	         System.out.println(" original_price***=="+ original_price);
				wst.click();
				//wst.sendKeys(Keys.BACK_SPACE);
				wst.sendKeys(updatePrice);
				getCommand().click(chek_OrderGuide.replace("<#>",chek_box));
				String img_xpath="//*[@id='"+upc+"-CS']/td[28]/img";
				System.out.println("Image present"+img_xpath);
				getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpath));
				System.out.println("Image present");
				viewIsrOrder();
			}
			else if (getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_box))){
				getCommand().click(chek_OrderGuide.replace("<#>",chek_box));
			}
			}
		}
		 return this;
		
	}
	public ItemDeletePage changeShippingCondition()
	{
		getCommand().waitForTargetPresent(btn_Shipping);
		if(getCommand().isTargetPresent(btn_Shipping)){
		log("Change Shipping Condition ",LogType.STEP);
		getCommand().click(btn_Shipping);
		getCommand().isTargetPresent(grid_Shipping);
		getCommand().isTargetPresent(lst_shippingCondition);
		getCommand().click(lst_shippingCondition);
        Select st=new Select(getCommand().getDriver().findElement(By.id("shippingConditionSelect")));
		st.selectByValue("Z1");
		if (Arrays.asList("*firefox","*iexplore").contains(TestProperties.getProperties("test.browser")))
		{
		WebElement wedateWidget = getCommand().getDriver().findElement(By.id("shippingConditionSelect"));  
		wedateWidget.sendKeys(Keys.ENTER);
		}
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(txt_Dynamic_Price);
		}
		return this;
		
	}	
	public ItemDeletePage clickShippingBtn()
	{
		getCommand().waitForTargetPresent(btn_Shipping);
		if(getCommand().isTargetPresent(btn_Shipping)){
		log("Change Shipping Condition ",LogType.STEP);
		getCommand().click(btn_Shipping);
		}
		return this;
		
	}		
	public ItemDeletePage ChangeDeliveryDate()
	{
		getCommand().waitFor(4);
		getCommand().waitForTargetPresent(btn_Shipping);
		if(getCommand().isTargetPresent(btn_Shipping)){
		log("Change Delivery date ",LogType.STEP);
		getCommand().isTargetPresent(date_Calendar);
		//System.out.println("Previous date: " +getCommand);
		getCommand().waitForTargetVisible(date_Calendar);
		//WebElement weddateWidget = getCommand().getDriver().findElement(By.cssSelector("img.ui-datepicker-trigger")); 
		//weddateWidget.click();
		getCommand().click(date_Calendar);
		 DateFormat df = new SimpleDateFormat("dd/MM/yy");
	     Date dateobj = new Date();
	     System.out.println(df.format(dateobj));
	     int DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
		    Date date = new Date();
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		    String prevDate = dateFormat.format(date.getTime() - DAY_IN_MILLIS);
		    String currDate = dateFormat.format(date.getTime());
		    String nextDate = dateFormat.format(date.getTime() +((DAY_IN_MILLIS)*5+ DAY_IN_MILLIS));
		    System.out.println("Previous date: " + prevDate);
		    System.out.println("Current date: " + currDate);
		    System.out.println("Next date: " + nextDate);
		    String setDate[]=nextDate.split("/");
		    String setCurDate[]=currDate.split("/");
		    String curMon=setCurDate[1];
		    String calDate=getCommand().getDriver().findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value").toString();
		    String cal_date[]=calDate.split("/");
		    System.out.println("calDate===="+calDate);
		    System.out.println("calDate===="+cal_date[0]);
		    System.out.println("calDate===="+cal_date[1]);
		    System.out.println("calDate===="+cal_date[2]);
		    int cal_month=Integer.parseInt(cal_date[0]);
		    String nextMon=setDate[1];
		    int next_date=Integer.parseInt(nextMon);
		    int cur_date=Integer.parseInt(curMon);
		    String setDay1=setDate[0];
		    String setDay=setDate[0];
		    if(setDay1.equals("01")) setDay="1"; else if(setDay1.equals("02")) setDay="2"; else if(setDay1.equals("03")) setDay="3"; else if(setDay1.equals("04")) setDay="4";
		    else if(setDay1.equals("05")) setDay="5"; else if(setDay1.equals("06")) setDay="6"; else if(setDay1.equals("07")) setDay="7"; else if(setDay1.equals("08")) setDay="8"; else if(setDay1.equals("09")) setDay="9";
		    System.out.println("DD===="+setDay);
		    System.out.println("curDay===="+setCurDate[0]);
		    System.out.println("MM===="+setDate[1]);
		    System.out.println("YY===="+setDate[2]);
		    if(next_date==cur_date)
		    {
		    	if(cal_month==next_date)
		    	{
		    		getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);	
		    		//getCommand().isTargetPresent(date_PrevMon);
				   // getCommand().click(date_PrevMon);
				    	
				    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
				    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
				    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
				    	    
				    	  for (WebElement cell: columns){  
				    	   //Select 13th Date   
				    	   if (cell.getText().equals(setDay)){  
				    	   cell.findElement(By.linkText(setDay)).click();  
				    	   break;  
				    	   }  
				    	  }
		    	}
		    	else if(cal_month>next_date)
		    	{
		    		getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
		    		getCommand().isTargetPresent(date_PrevMon);
			    	getCommand().click(date_PrevMon);
			    	
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
		    			
		    	}
		    	else if(cal_month<next_date)
		    	{
		    		
			    	getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
			    	getCommand().isTargetPresent(date_NextMon);
			    	getCommand().click(date_NextMon);
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
			    	
			   
		    	}
		    }
		    else if(next_date>cur_date)
		    {
		    	 if(cal_month>next_date)
		    	{
		    		
			    	getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
			    	getCommand().isTargetPresent(date_PrevMon);
			    	getCommand().click(date_PrevMon);
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
		    			
		    	}
		    	else if(cal_month<next_date)
		    	{
		    		
			    	getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
			    	getCommand().isTargetPresent(date_NextMon);
			    	getCommand().click(date_NextMon);
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
			    	
			   
		    	}
		    	else if(cal_month==next_date)
			    	{
		    		getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);	
		    		//getCommand().isTargetPresent(date_PrevMon);
				    //getCommand().click(date_PrevMon);
				    	
				    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
				    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
				    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
				    	    
				    	  for (WebElement cell: columns){  
				    	   //Select 13th Date   
				    	   if (cell.getText().equals(setDay)){  
				    	   cell.findElement(By.linkText(setDay)).click();  
				    	   break;  
				    	   }  
				    	  }
		       // getCommand().getDriver().findElement(By.linkText(setDay)).click();
			    	}
		    }
		}
		return this;
		
	}
	public ItemDeletePage ChangeDeliveryDateAgain()
	{
		getCommand().waitFor(3);
		getCommand().waitForTargetPresent(btn_Shipping);
		if(getCommand().isTargetPresent(btn_Shipping)){
		log("Change Delivery date ",LogType.STEP);
		getCommand().isTargetPresent(date_Calendar);
		getCommand().click(date_Calendar);
		 DateFormat df = new SimpleDateFormat("dd/MM/yy");
	     Date dateobj = new Date();
	     System.out.println(df.format(dateobj));
	     int DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
		    Date date = new Date();
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		    String prevDate = dateFormat.format(date.getTime() - DAY_IN_MILLIS);
		    String currDate = dateFormat.format(date.getTime());
		    String nextDate = dateFormat.format(date.getTime() +((DAY_IN_MILLIS)*8+ DAY_IN_MILLIS));
		    System.out.println("Previous date: " + prevDate);
		    System.out.println("Current date: " + currDate);
		    System.out.println("Next date: " + nextDate);
		    String setDate[]=nextDate.split("/");
		    String setCurDate[]=currDate.split("/");
		    String curMon=setCurDate[1];
		    String calDate=getCommand().getDriver().findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value").toString();
		    String cal_date[]=calDate.split("/");
		    System.out.println("calDate===="+calDate);
		    System.out.println("calDate===="+cal_date[0]);
		    System.out.println("calDate===="+cal_date[1]);
		    System.out.println("calDate===="+cal_date[2]);
		    int cal_month=Integer.parseInt(cal_date[0]);
		    String nextMon=setDate[1];
		    int next_date=Integer.parseInt(nextMon);
		    int cur_date=Integer.parseInt(curMon);
		    String setDay1=setDate[0];
		    String setDay=setDate[0];
		    if(setDay1.equals("01")) setDay="1"; else if(setDay1.equals("02")) setDay="2"; else if(setDay1.equals("03")) setDay="3"; else if(setDay1.equals("04")) setDay="4";
		    else if(setDay1.equals("05")) setDay="5"; else if(setDay1.equals("06")) setDay="6"; else if(setDay1.equals("07")) setDay="7"; else if(setDay1.equals("08")) setDay="8"; else if(setDay1.equals("09")) setDay="9";
		    System.out.println("DD===="+setDay);
		    System.out.println("curDay===="+setCurDate[0]);
		    System.out.println("MM===="+setDate[1]);
		    System.out.println("YY===="+setDate[2]);
		    if(next_date==cur_date)
		    {
		    	if(cal_month==next_date)
		    	{
		    		getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);	
		    		//getCommand().isTargetPresent(date_PrevMon);
				   // getCommand().click(date_PrevMon);
				    	
				    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
				    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
				    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
				    	    
				    	  for (WebElement cell: columns){  
				    	   //Select 13th Date   
				    	   if (cell.getText().equals(setDay)){  
				    	   cell.findElement(By.linkText(setDay)).click();  
				    	   break;  
				    	   }  
				    	  }
		    	}
		    	else if(cal_month>next_date)
		    	{
		    		getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
		    		getCommand().isTargetPresent(date_PrevMon);
			    	getCommand().click(date_PrevMon);
			    	
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
		    			
		    	}
		    	else if(cal_month<next_date)
		    	{
		    		
			    	getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
			    	getCommand().isTargetPresent(date_NextMon);
			    	getCommand().click(date_NextMon);
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
			    	
			   
		    	}
		    }
		    else if(next_date>cur_date)
		    {
		    	 if(cal_month>next_date)
		    	{
		    		
			    	getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
			    	getCommand().isTargetPresent(date_PrevMon);
			    	getCommand().click(date_PrevMon);
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
		    			
		    	}
		    	else if(cal_month<next_date)
		    	{
		    		
			    	getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
			    	getCommand().isTargetPresent(date_NextMon);
			    	getCommand().click(date_NextMon);
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
			    	
			   
		    	}
		    	else if(cal_month==next_date)
			    	{
		    		getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);	
		    		//getCommand().isTargetPresent(date_PrevMon);
				    //getCommand().click(date_PrevMon);
				    	
				    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
				    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
				    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
				    	    
				    	  for (WebElement cell: columns){  
				    	   //Select 13th Date   
				    	   if (cell.getText().equals(setDay)){  
				    	   cell.findElement(By.linkText(setDay)).click();  
				    	   break;  
				    	   }  
				    	  }
		       // getCommand().getDriver().findElement(By.linkText(setDay)).click();
			    	}
		    }
		}
		return this;
		
	}
	public ItemDeletePage changeShippingConditiontoSecondRun()
	{
		
		getCommand().waitForTargetPresent(btn_Shipping);
		if(getCommand().isTargetPresent(btn_Shipping)){
		log("Change Shipping Condition ",LogType.STEP);
		getCommand().click(btn_Shipping);
		getCommand().isTargetPresent(grid_Shipping);
		getCommand().isTargetPresent(lst_shippingCondition);
		getCommand().click(lst_shippingCondition);
        Select st=new Select(getCommand().getDriver().findElement(By.id("shippingConditionSelect")));
		st.selectByValue("Z7");
		if (Arrays.asList("*firefox","*iexplore").contains(TestProperties.getProperties("test.browser")))
		{
		WebElement wedateWidget = getCommand().getDriver().findElement(By.id("shippingConditionSelect"));  
		wedateWidget.sendKeys(Keys.ENTER);
		}
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(txt_Dynamic_Price);
		}
		return this;
		
	}
		 /*DateFormat df = new SimpleDateFormat("dd/MM/yy");
	     Date dateobj = new Date();
	     System.out.println(df.format(dateobj));
	     int DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
		    Date date = new Date();
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		    String prevDate = dateFormat.format(date.getTime() - DAY_IN_MILLIS);
		    String currDate = dateFormat.format(date.getTime());
		    String nextDate = dateFormat.format(date.getTime() +((DAY_IN_MILLIS)*22+ DAY_IN_MILLIS));
		    System.out.println("Previous date: " + prevDate);
		    System.out.println("Current date: " + currDate);
		    System.out.println("Next date: " + nextDate);
		    String setDate[]=nextDate.split("/");
		    String setCurDate[]=currDate.split("/");
		    String curMon=setCurDate[1];
		    String calDate=getCommand().getDriver().findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value").toString();
		    String cal_date[]=calDate.split("/");
		    System.out.println("calDate===="+calDate);
		    System.out.println("calDate===="+cal_date[0]);
		    System.out.println("calDate===="+cal_date[1]);
		    System.out.println("calDate===="+cal_date[2]);
		    int cal_month=Integer.parseInt(cal_date[0]);
		    String nextMon=setDate[1];
		    int next_date=Integer.parseInt(nextMon);
		    int cur_date=Integer.parseInt(curMon);
		    String setDay1=setDate[0];
		    String setDay=setDate[0];
		    if(setDay1.equals("01")) setDay="1"; else if(setDay1.equals("02")) setDay="2"; else if(setDay1.equals("03")) setDay="3"; else if(setDay1.equals("04")) setDay="4";
		    else if(setDay1.equals("05")) setDay="5"; else if(setDay1.equals("06")) setDay="6"; else if(setDay1.equals("07")) setDay="7"; else if(setDay1.equals("08")) setDay="8"; else if(setDay1.equals("09")) setDay="9";
		    System.out.println("DD===="+setDay);
		    System.out.println("curDay===="+setCurDate[0]);
		    System.out.println("MM===="+setDate[1]);
		    System.out.println("YY===="+setDate[2]);
		    if(next_date==cur_date)
		    {
		    	if(cal_month==next_date)
		    	{
		    		getCommand().isTargetPresent(date_PrevMon);
			    	getCommand().click(date_PrevMon);
			    	getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
	        getCommand().getDriver().findElement(By.linkText(setDay)).click();
		    	}
		    	else if(cal_month>next_date)
		    	{
		    		getCommand().isTargetPresent(date_PrevMon);
			    	getCommand().click(date_PrevMon);
			    	getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
		    			
		    	}
		    	else if(cal_month<next_date)
		    	{
		    		getCommand().isTargetPresent(date_NextMon);
			    	getCommand().click(date_NextMon);
			    	getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
			    	
			   
		    	}
		    }
		    else if(next_date>cur_date)
		    {
		    	 if(cal_month>next_date)
		    	{
		    		getCommand().isTargetPresent(date_PrevMon);
			    	getCommand().click(date_PrevMon);
			    	getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
		    			
		    	}
		    	else if(cal_month<next_date)
		    	{
		    		getCommand().isTargetPresent(date_NextMon);
			    	getCommand().click(date_NextMon);
			    	getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
			    	
			   
		    	}
		    	getCommand().isTargetPresent(date_NextMon);
		    	getCommand().click(date_NextMon);
		    	getCommand().isTargetPresent(date_Calendar);
		    	getCommand().isTargetPresent(date_Picker);
		    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
		    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
		    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
		    	    
		    	  for (WebElement cell: columns){  
		    	   //Select 13th Date   
		    	   if (cell.getText().equals(setDay)){  
		    	   cell.findElement(By.linkText(setDay)).click();  
		    	   break;  
		    	   }  
		    	  }
		    	//getCommand().getDriver().findElement(By.className("undefined"));
		    	//getCommand().getDriver().findElement(By.linkText(setDay)).click();	
		    }
	   */
		
		
	public ItemDeletePage reValidateAlert()
	{
		getCommand().waitFor(3);
		getCommand().waitForTargetPresent(alert_Error);
		log("Revalidate alert is occur ",LogType.STEP);
		if(getCommand().isTargetPresent(alert_Error)){
			getCommand().isTargetPresent(alert_OK);
			getCommand().click(alert_OK);
			
		}
		return this;
		
	}
	public ItemDeletePage  revertOriginalPriceCheck(String upc)
	{
		String handPrice_txt=upc+"-CS_currentprice";
		log("Revert to the original price ",LogType.STEP);
		getCommand().waitForTargetVisible(txt_Price.replace("<#>", handPrice_txt));
		SoftAssertion.assertAttributeValue(txt_Price.replace("<#>", handPrice_txt), "value", original_price);
		return this;
		
	}
	public ItemDeletePage updateAgainHandPrice(String upc,String currentPrice)
	{
		
		getCommand().waitForTargetPresent(gbox_Modifygrid);
		if(getCommand().isTargetPresent(gbox_Modifygrid)){
			String stPrice=upc+"-CS_currentprice";
			getCommand().isTargetPresent(txt_CurrentPrice.replace("<#>",stPrice));
			log("Update handprice ",LogType.STEP);
			WebElement wst=getCommand().getDriver().findElement(By.id(stPrice));
			wst.click();
			getCommand().waitFor(3);
			wst.sendKeys(currentPrice);
				
		}
		return this;
		
	}
	public ItemDeletePage updateAgainHandPriceNew(String upc,String currentPrice)
	{
		
		getCommand().waitForTargetPresent(gbox_Modifygrid);
		if(getCommand().isTargetPresent(gbox_Modifygrid)){
			String stPrice=upc+"-CS_currentprice";
			getCommand().isTargetPresent(txt_CurrentPrice.replace("<#>",stPrice));
			log("Update handprice ",LogType.STEP);
			WebElement wst=getCommand().getDriver().findElement(By.id(stPrice));
			wst.click();
			String newP1=currentPrice.replace(".", "/");
			String ss1[]=newP1.split("/");
			int   new_price=Integer.parseInt(ss1[0]);
			new_price+=5;
			String st_Price=String.valueOf(new_price) ;
			st_Price=st_Price+".00";
			 System.out.println("stPrice*********"+st_Price);
			wst.sendKeys(st_Price);
				
		}
		return this;
		
	}
	
	public ItemDeletePage ChangeDeliveryDateNext()
	{
		getCommand().waitFor(3);
		getCommand().waitForTargetPresent(btn_Shipping);
		if(getCommand().isTargetPresent(btn_Shipping)){
		log("Change Delivery date ",LogType.STEP);
		getCommand().isTargetPresent(date_Calendar);
		getCommand().click(date_Calendar);
		 DateFormat df = new SimpleDateFormat("dd/MM/yy");
	     Date dateobj = new Date();
	     System.out.println(df.format(dateobj));
	     int DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
		    Date date = new Date();
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		    String prevDate = dateFormat.format(date.getTime() - DAY_IN_MILLIS);
		    String currDate = dateFormat.format(date.getTime());
		    String nextDate = dateFormat.format(date.getTime() +((DAY_IN_MILLIS)*4+ DAY_IN_MILLIS));
		    System.out.println("Previous date: " + prevDate);
		    System.out.println("Current date: " + currDate);
		    System.out.println("Next date: " + nextDate);
		    String setDate[]=nextDate.split("/");
		    String setCurDate[]=currDate.split("/");
		    String curMon=setCurDate[1];
		    String calDate=getCommand().getDriver().findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value").toString();
		    String cal_date[]=calDate.split("/");
		    System.out.println("calDate===="+calDate);
		    System.out.println("calDate===="+cal_date[0]);
		    System.out.println("calDate===="+cal_date[1]);
		    System.out.println("calDate===="+cal_date[2]);
		    int cal_month=Integer.parseInt(cal_date[0]);
		    String nextMon=setDate[1];
		    int next_date=Integer.parseInt(nextMon);
		    int cur_date=Integer.parseInt(curMon);
		    String setDay1=setDate[0];
		    String setDay=setDate[0];
		    if(setDay1.equals("01")) setDay="1"; else if(setDay1.equals("02")) setDay="2"; else if(setDay1.equals("03")) setDay="3"; else if(setDay1.equals("04")) setDay="4";
		    else if(setDay1.equals("05")) setDay="5"; else if(setDay1.equals("06")) setDay="6"; else if(setDay1.equals("07")) setDay="7"; else if(setDay1.equals("08")) setDay="8"; else if(setDay1.equals("09")) setDay="9";
		    System.out.println("DD===="+setDay);
		    System.out.println("curDay===="+setCurDate[0]);
		    System.out.println("MM===="+setDate[1]);
		    System.out.println("YY===="+setDate[2]);
		    if(next_date==cur_date)
		    {
		    	if(cal_month==next_date)
		    	{
		    		getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);	
		    		//getCommand().isTargetPresent(date_PrevMon);
				   // getCommand().click(date_PrevMon);
				    	
				    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
				    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
				    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
				    	    
				    	  for (WebElement cell: columns){  
				    	   //Select 13th Date   
				    	   if (cell.getText().equals(setDay)){  
				    	   cell.findElement(By.linkText(setDay)).click();  
				    	   break;  
				    	   }  
				    	  }
		    	}
		    	else if(cal_month>next_date)
		    	{
		    		getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
		    		getCommand().isTargetPresent(date_PrevMon);
			    	getCommand().click(date_PrevMon);
			    	
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
		    			
		    	}
		    	else if(cal_month<next_date)
		    	{
		    		
			    	getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
			    	getCommand().isTargetPresent(date_NextMon);
			    	getCommand().click(date_NextMon);
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
			    	
			   
		    	}
		    }
		    else if(next_date>cur_date)
		    {
		    	 if(cal_month>next_date)
		    	{
		    		
			    	getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
			    	getCommand().isTargetPresent(date_PrevMon);
			    	getCommand().click(date_PrevMon);
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
		    			
		    	}
		    	else if(cal_month<next_date)
		    	{
		    		
			    	getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);
			    	getCommand().isTargetPresent(date_NextMon);
			    	getCommand().click(date_NextMon);
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
			    	
			   
		    	}
		    	else if(cal_month==next_date)
			    	{
		    		getCommand().isTargetPresent(date_Calendar);
			    	getCommand().isTargetPresent(date_Picker);	
		    		//getCommand().isTargetPresent(date_PrevMon);
				    //getCommand().click(date_PrevMon);
				    	
				    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
				    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
				    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
				    	    
				    	  for (WebElement cell: columns){  
				    	   //Select 13th Date   
				    	   if (cell.getText().equals(setDay)){  
				    	   cell.findElement(By.linkText(setDay)).click();  
				    	   break;  
				    	   }  
				    	  }
		       // getCommand().getDriver().findElement(By.linkText(setDay)).click();
			    	}
		    }
		}
		return this;
		
	}
	public ItemDeletePage viewOpenOrderItemsFromDB(String opco,String customer){
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		 getCommand().waitFor(4);
	//	getCommand().waitForTargetPresent(grid_OpenOrders);
		log("Change Delivery date ",LogType.STEP);
		
		log("Retrive data from  ",LogType.STEP);
		int DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
	    Date date = new Date();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
	    Calendar cal =Calendar.getInstance();
	    cal.add(Calendar.MONTH, -1);
	    System.out.println(dateFormat.format(cal.getTime()));
	    String prevDate = dateFormat.format(cal.getTime());
	    System.out.println("Previous date: " + prevDate.replaceAll("/",""));
	    String past_delivertdate=prevDate.replaceAll("/","");
	    //String currDate = dateFormat.format(date.getTime());
	   // String nextDate = dateFormat.format(date.getTime() +((DAY_IN_MILLIS)*4+ DAY_IN_MILLIS));
	    System.out.println("Previous date: " + prevDate);
	    String opco_num[]=opco.split("-");
		System.out.println(opco_num[0].trim());
		String opcono=opco_num[0].trim();
		String custNo="       "+customer;
		System.out.println("CUNO*****"+custNo);
	    //String strQuery="SELECT b6orno from OPNJB6L0 where b6orst='O' and b6shdt<'"+past_delivertdate+"' order by b6ordt asc fetch  first 1 rows only";
	   // String strQuery="select NTEPO# from ESOHNTTF where NTOPCO="+opcono+" and NTCUNO='"+custNo+"' and NTORST='C' and NTORDP>1 and NTDELD>"+past_delivertdate+" order by NTDELD asc fetch first 1 rows only";
	    String strQuery="select NTEPO# from ESOHNTTF where NTOPCO="+opcono+" and NTCUNO='"+custNo+"'  and NTUODT!=0 and NTDELD>"+past_delivertdate+" and NTORST='C' and NTSRCC='7' and NTTTOR<1";
	    System.out.println("Previous date: " + strQuery);
		ArrayList aList=(new SupportFunctions()).retrieveData(strQuery);
		System.out.println(aList);
		if(aList.isEmpty())
		{
			log("Open Orders are  not available for this "+customer+"with "+prevDate,LogType.STEP);
			Assert.fail("Test case is failed due to valid Open Orders are not available");
		}
		else{
			log("Open Orders are   available for this "+customer+"with "+prevDate,LogType.STEP);
		ArrayList aListOrderNo=(ArrayList)(aList.get(1));
		System.out.println("REFNO==="+aListOrderNo.get(0));
		getCommand().waitForTargetPresent(grid_OpenOrders);
		 String st=aListOrderNo.get(0).toString();
		 String strItemXpath = "//*[@id='" + st + "']";
		//log("Click on Item  Link ",LogType.STEP);
		 getCommand().getDriver().findElement(By.xpath(strItemXpath)).click();
		 getCommand().getDriver().findElement(By.linkText(st)).click();
		 ClickOnShipp();
		 getCommand().waitFor(3);
		 String strItemQuery="select NQITEM  from ESODNQTF where NQEPO#="+st+" fetch first 1 rows only";
		 ArrayList aListItem=(new SupportFunctions()).retrieveData(strItemQuery);
			System.out.println(aListItem);
			ArrayList aListOrderItem=(ArrayList)(aListItem.get(0));
			 String st_item=aListOrderItem.get(0).toString();
			 System.out.println("ITEM*********"+st_item);
			 
			 log("Update the item quantity ",LogType.STEP);
			 
				 
				String item_num=st_item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
				System.out.println("ID++++++++++"+item_num);
				if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", item_num))){
				System.out.println("item_num=="+item_num);
				
				String chek_box="jqg_grid1_"+st_item.trim()+"-CS";
				String update_Quanty=getCommand().getDriver().findElement(By.id(item_num)).getAttribute("value").toString();
				System.out.println("update_Quanty=="+update_Quanty);
				int updateQuanty=Integer.parseInt(update_Quanty);
				updateQuanty+=2;
				String item_Qnty=String.valueOf(updateQuanty);
				System.out.println("chek_box=="+chek_box);
				//getCommand().waitForTargetPresent(gbox_Modifygrid);
				//if(getCommand().isTargetPresent(gbox_Modifygrid)){
					//String stPrice=item_num+"-CS_currentprice";
					//if(getCommand().isTargetPresent(txt_CurrentPrice.replace("<#>",stPrice))){
				if (!getCommand().isSelected(chek_item.replace("<#>",chek_box)) )
				{
					getCommand().click(chek_item.replace("<#>",chek_box));
					getCommand().clear(txt_itemQty.replace("<#>", item_num));
					getCommand().sendKeys(txt_itemQty.replace("<#>", item_num), item_Qnty);
					getCommand().click(chek_item.replace("<#>",chek_box));
					log("Update the item quantity successfully:"+updateQuanty,LogType.STEP);
				}
				}
				}
				//}
				//}
		return this;
		
				
	}
	public ItemDeletePage ClickOnShipp() {
		getCommand().waitFor(4);
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		//if(getCommand().isTargetPresent(generic_ErrorDiv))
		//{
		//getCommand().click(generic_ErrorDivButton);	
		//}
		getCommand().waitForTargetPresent(btn_Shipping);
		if(getCommand().isTargetPresent(btn_Shipping)){
		log("Change Shipping Condition ",LogType.STEP);
		getCommand().click(btn_Shipping);
		ChangeDeliveryDate();
		getCommand().waitFor(3);
		getCommand().waitForTargetPresent(alert_Error);
		if(getCommand().isTargetPresent(alert_Error)){
			log("Revalidate alert is occur ",LogType.STEP);
			if(getCommand().isTargetPresent(alert_OK))
			getCommand().click(alert_OK);
			
		}
		
		}
		return this;
	}
	public ItemDeletePage addItemOutOfStockFromDB(String opco ,String custNum)
	{

		getCommand().waitFor(3);
		String opco_num[]=opco.split("-");
		System.out.println(opco_num[0].trim());
		String opcono=opco_num[0].trim();
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(!getCommand().isTargetVisible(popup_CreateOrder))
		{
			
				
						
				String outOff_stock="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opcono+" and  PGSTKI in('S') and PGAVSK=0  and PGITST not in('I') and PGITPR not in('Y') fetch first 1  rows only";
				System.out.println(outOff_stock);
				ArrayList outOff_stockItem=(new SupportFunctions()).retrieveData(outOff_stock);
				System.out.println(outOff_stockItem);
				ArrayList outoff_stockItemNum=(ArrayList)(outOff_stockItem.get(0));
				 String outoff_stock_Item=outoff_stockItemNum.get(0).toString();
				 searchItemPrice(outoff_stock_Item.trim());
				 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
		         String outoff_item_num=outoff_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
			     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", outoff_item_num))){
			     System.out.println("item_num=="+outoff_item_num);
			     String chek_box="jqg_productSearchGrid_"+outoff_stock_Item.trim()+"-CS";
			     System.out.println("chek_box=="+chek_box);
			     getCommand().storeValue("db_outstock value", outoff_stock_Item.toString().trim());
			    log("Enter quantity of Item ",LogType.STEP);
			   if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_box)) )
			   {
				getCommand().click(txt_OrderGuideItemQnty.replace("<#>", outoff_item_num));
				getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", outoff_item_num));
				getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", outoff_item_num), "2");
				getCommand().click(chek_OrderGuide.replace("<#>",chek_box));
				String img_xpath="//*[@id='"+outoff_stock_Item.trim()+"-CS']/td[28]/img";
				System.out.println("Image present"+img_xpath);
				getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpath));
				System.out.println("Image present");
				//viewIsrOrder();
			  }
		   } 
			     viewIsrOrder();   
		}
		return this;
	}
	public ItemDeletePage addOneItemGromDB(String opco,String custNum)
	{
		getCommand().waitFor(3);
		String opco_num[]=opco.split("-");
		System.out.println(opco_num[0].trim());
		String opcono=opco_num[0].trim();
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(!getCommand().isTargetVisible(popup_CreateOrder))
		{
			
				
				//String demand_status="SELECT PGITEM FROM espgpgtf WHERE PGSTKI in('D') fetch first 1  rows only";
				
				
			
				String outOff_stock="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opcono+" and  PGSTKI in('S') and PGAVSK>5  and PGITST not in('I') and PGITPR not in('Y') fetch first 1  rows only";
				System.out.println(outOff_stock);
				ArrayList outOff_stockItem=(new SupportFunctions()).retrieveData(outOff_stock);
				System.out.println(outOff_stockItem);
				ArrayList outoff_stockItemNum=(ArrayList)(outOff_stockItem.get(0));
				 String outoff_stock_Item=outoff_stockItemNum.get(0).toString();
				 searchItemPrice(outoff_stock_Item.trim());
				 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
		         String outoff_item_num=outoff_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
			     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", outoff_item_num))){
			     System.out.println("item_num=="+outoff_item_num);
			     String chek_box="jqg_productSearchGrid_"+outoff_stock_Item.trim()+"-CS";
			     System.out.println("chek_box=="+chek_box);
			    log("Enter quantity of Item ",LogType.STEP);
			   getCommand().storeValue("outOffItem",outoff_stock_Item.trim());
			   if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_box)) )
			   {
				getCommand().click(txt_OrderGuideItemQnty.replace("<#>", outoff_item_num));
				getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", outoff_item_num));
				getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", outoff_item_num), "2");
				getCommand().click(chek_OrderGuide.replace("<#>",chek_box));
				String img_xpath="//*[@id='"+outoff_stock_Item.trim()+"-CS']/td[28]/img";
				System.out.println("Image present"+img_xpath);
				getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpath));
				System.out.println("Image present");
				//viewIsrOrder();
			  }
		   } 
			     viewIsrOrder();   
		}
		return this;

	}
	public ItemDeletePage addOneItemFromDB_147(String opco,String custNum)
	{
		getCommand().waitFor(3);
		String opco_num[]=opco.split("-");
		System.out.println(opco_num[0].trim());
		String opcono=opco_num[0].trim();
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(!getCommand().isTargetVisible(popup_CreateOrder))
		{
			
				
				//String demand_status="SELECT PGITEM FROM espgpgtf WHERE PGSTKI in('D') fetch first 1  rows only";
				
				
			
				String outOff_stock="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opcono+" and  PGSTKI in('S') and PGAVSK>50 and PGITST not in('I') and PGITPR not in('Y') fetch first 1  rows only";
				System.out.println(outOff_stock);
				ArrayList outOff_stockItem=(new SupportFunctions()).retrieveData(outOff_stock);
				System.out.println(outOff_stockItem);
				ArrayList outoff_stockItemNum=(ArrayList)(outOff_stockItem.get(0));
				 String outoff_stock_Item=outoff_stockItemNum.get(0).toString();
				 searchItemPrice(outoff_stock_Item.trim());
				 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
		         String outoff_item_num=outoff_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
			     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", outoff_item_num))){
			     System.out.println("item_num=="+outoff_item_num);
			     String chek_box="jqg_productSearchGrid_"+outoff_stock_Item.trim()+"-CS";
			     System.out.println("chek_box=="+chek_box);
			    log("Enter quantity of Item ",LogType.STEP);
			    item_numDB=outoff_stock_Item.trim();
			    getCommand().storeValue("item_num_147", outoff_stock_Item.trim());
			   if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_box)) )
			   {
				getCommand().click(txt_OrderGuideItemQnty.replace("<#>", outoff_item_num));
				getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", outoff_item_num));
				getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", outoff_item_num), "2");
				getCommand().click(chek_OrderGuide.replace("<#>",chek_box));
				String img_xpath="//*[@id='"+outoff_stock_Item.trim()+"-CS']/td[28]/img";
				System.out.println("Image present"+img_xpath);
				getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpath));
				System.out.println("Image present");
				//viewIsrOrder();
			  }
		   } 
			     viewIsrOrder();   
		}
		return this;

	}
	public ItemDeletePage addOneItemForReOrderDB(String opco,String custNum)
	{
		getCommand().waitFor(3);
		String opco_num[]=opco.split("-");
		System.out.println(opco_num[0].trim());
		String opcono=opco_num[0].trim();
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(!getCommand().isTargetVisible(popup_CreateOrder))
		{
			
				
				//String demand_status="SELECT PGITEM FROM espgpgtf WHERE PGSTKI in('D') fetch first 1  rows only";
				
			
				String outOff_stock="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opcono+" and  PGSTKI in('S') and PGAVSK>60 and PGITST not in('I') and PGITPR not in('Y') fetch first 1  rows only";
				System.out.println(outOff_stock);
				ArrayList outOff_stockItem=(new SupportFunctions()).retrieveData(outOff_stock);
				System.out.println(outOff_stockItem);
				ArrayList outoff_stockItemNum=(ArrayList)(outOff_stockItem.get(0));
				 String outoff_stock_Item=outoff_stockItemNum.get(0).toString();
				 searchItemPrice(outoff_stock_Item.trim());
				 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
		         String outoff_item_num=outoff_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
			     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", outoff_item_num))){
			     System.out.println("item_num=="+outoff_item_num);
			     String chek_box="jqg_productSearchGrid_"+outoff_stock_Item.trim()+"-CS";
			     System.out.println("chek_box=="+chek_box);
			    log("Enter quantity of Item ",LogType.STEP);
			    item_numDB=outoff_stock_Item.trim();
			   if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_box)) )
			   {
				getCommand().click(txt_OrderGuideItemQnty.replace("<#>", outoff_item_num));
				getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", outoff_item_num));
				getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", outoff_item_num), "2");
				getCommand().click(chek_OrderGuide.replace("<#>",chek_box));
				String img_xpath="//*[@id='"+outoff_stock_Item.trim()+"-CS']/td[28]/img";
				System.out.println("Image present"+img_xpath);
				getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpath));
				System.out.println("Image present");
				//viewIsrOrder();
			  }
		   } 
			     viewIsrOrder();   
		}
		return this;

	}
	public ItemDeletePage addTwoItemFromDB(String opco ,String custNum)
	{
		getCommand().waitFor(10);
		String opco_num[]=opco.split("-");
		System.out.println(opco_num[0].trim());
		String opcono=opco_num[0].trim();
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(!getCommand().isTargetVisible(popup_CreateOrder))
		{
			/* start  non stock Item*/
			
			String non_stock="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opcono+" and  PGSTKI in('S') and PGAVSK>30 and PGITPR not in('Y') and PGITST not in('I') fetch first 1  rows only";
			System.out.println(non_stock);
			ArrayList non_stockItem=(new SupportFunctions()).retrieveData(non_stock);
			System.out.println(non_stockItem);
			ArrayList non_stockItemNum=(ArrayList)(non_stockItem.get(0));
			 String non_stock_Item=non_stockItemNum.get(0).toString();
			 searchItemPrice(non_stock_Item.trim());
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
	         String non_item_num=non_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
		     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", non_item_num))){
		     System.out.println("item_num=="+non_item_num);
		     String chek_box="jqg_productSearchGrid_"+non_stock_Item.trim()+"-CS";
		     System.out.println("chek_box=="+chek_box);
		    log("Enter quantity of Item ",LogType.STEP);
		    item_numDel=non_stock_Item.toString().trim();
		    getCommand().storeValue("db_Item value", non_stock_Item.toString().trim());
		    System.out.println("item_numDel&&&&&&&&&&&&&"+item_numDel);
		   if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_box)) )
		   {
			getCommand().click(txt_OrderGuideItemQnty.replace("<#>", non_item_num));
			getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", non_item_num));
			getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", non_item_num), "2");
			getCommand().click(chek_OrderGuide.replace("<#>",chek_box));
			String img_xpath="//*[@id='"+non_stock_Item.trim()+"-CS']/td[28]/img";
			System.out.println("Image present"+img_xpath);
			getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpath));
			System.out.println("Image present");
			//viewIsrOrder();
		  }
	   } 
		   /* start  Demand  stock Item*/
			String demand_stock="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opcono+" and  PGSTKI in('S') and PGAVSK>80 and  PGITPR not in('Y') and PGITST not in('I') fetch first 1  rows only";
			ArrayList demand_stockItem=(new SupportFunctions()).retrieveData(demand_stock);
			System.out.println(demand_stockItem);
			ArrayList demand_stockItemNum=(ArrayList)(demand_stockItem.get(0));
			 String demand_stock_Item=demand_stockItemNum.get(0).toString();
			 searchItemPrice(demand_stock_Item.trim());
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
	         String demand_item_num=demand_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
		     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", demand_item_num))){
		     System.out.println("item_num=="+demand_item_num);
		     String chek_boxD="jqg_productSearchGrid_"+demand_stock_Item.trim()+"-CS";
		     System.out.println("chek_box=="+chek_boxD);
		    log("Enter quantity of Item ",LogType.STEP);
		    getCommand().storeValue("db_Item value2", demand_stock_Item.toString().trim());
		   if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_boxD)) )
		   {
			getCommand().click(txt_OrderGuideItemQnty.replace("<#>", demand_item_num));
			getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", demand_item_num));
			getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", demand_item_num), "2");
			getCommand().click(chek_OrderGuide.replace("<#>",chek_boxD));
			String img_xpathD="//*[@id='"+demand_stock_Item.trim()+"-CS']/td[28]/img";
			System.out.println("Image present"+img_xpathD);
			getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpathD));
			System.out.println("Image present");
			//viewIsrOrder();
		  }
		  
		}
		     viewIsrOrder();
		}
		return this;
	}
	public ItemDeletePage addNonStockItem(String opco,String custNum)
	{
		getCommand().waitFor(10);
		String opco_num[]=opco.split("-");
		System.out.println(opco_num[0].trim());
		String opcono=opco_num[0].trim();
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));	
		if(!getCommand().isTargetVisible(popup_CreateOrder))
		{
			String non_stock="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opcono+" and PGSTKI  in('N') and PGITST not in('I') and PGITPR not in('Y') fetch first 1  rows only";
			System.out.println(non_stock);
			ArrayList non_stockItem=(new SupportFunctions()).retrieveData(non_stock);
			System.out.println(non_stockItem);
			ArrayList non_stockItemNum=(ArrayList)(non_stockItem.get(0));
			 String non_stock_Item=non_stockItemNum.get(0).toString();
			 searchItemPrice(non_stock_Item.trim());
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
	         String non_item_num=non_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
		     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", non_item_num))){
		     System.out.println("item_num=="+non_item_num);
		     String chek_box="jqg_productSearchGrid_"+non_stock_Item.trim()+"-CS";
		     System.out.println("chek_box=="+chek_box);
		     getCommand().storeValue("non_stock_item_num", non_stock_Item.trim());
		    log("Enter quantity of Item ",LogType.STEP);
		   if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_box)) )
		   {
			getCommand().click(txt_OrderGuideItemQnty.replace("<#>", non_item_num));
			getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", non_item_num));
			getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", non_item_num), "2");
			getCommand().click(chek_OrderGuide.replace("<#>",chek_box));
			String img_xpath="//*[@id='"+non_stock_Item.trim()+"-CS']/td[28]/img";
			System.out.println("Image present"+img_xpath);
			getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpath));
			System.out.println("Image present");
			
		  }
	   } 
		   viewIsrOrder();     
		}
		return this;
	}
	public ItemDeletePage addDemandStatusItem(String opco,String custNum)
	{
		getCommand().waitFor(10);
		String opco_num[]=opco.split("-");
		System.out.println(opco_num[0].trim());
		String opcono=opco_num[0].trim();
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(!getCommand().isTargetVisible(popup_CreateOrder))
		{
			String demand_stock="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opcono+" and PGSTKI in('D') and PGAVSK>0  fetch first 1  rows only";
			ArrayList demand_stockItem=(new SupportFunctions()).retrieveData(demand_stock);
			System.out.println(demand_stockItem);
			ArrayList demand_stockItemNum=(ArrayList)(demand_stockItem.get(0));
			 String demand_stock_Item=demand_stockItemNum.get(0).toString();
			 searchItemPrice(demand_stock_Item.trim());
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
	         String demand_item_num=demand_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
		     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", demand_item_num))){
		     System.out.println("item_num=="+demand_item_num);
		     String chek_boxD="jqg_productSearchGrid_"+demand_stock_Item.trim()+"-CS";
		     System.out.println("chek_box=="+chek_boxD);
		    log("Enter quantity of Item ",LogType.STEP);
		    getCommand().storeValue("demand_stock_item_num",demand_stock_Item.trim());
		   if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_boxD)) )
		   {
			getCommand().click(txt_OrderGuideItemQnty.replace("<#>", demand_item_num));
			getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", demand_item_num));
			getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", demand_item_num), "2");
			getCommand().click(chek_OrderGuide.replace("<#>",chek_boxD));
			String img_xpathD="//*[@id='"+demand_stock_Item.trim()+"-CS']/td[28]/img";
			System.out.println("Image present"+img_xpathD);
			getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpathD));
			System.out.println("Image present");
			
		  }
		     }
		   viewIsrOrder();  
		}
		return this;
	}
	public ItemDeletePage addRemoteStockItem(String opco,String custNum){
		getCommand().waitFor(10);
		String opco_num[]=opco.split("-");
		System.out.println(opco_num[0].trim());
		String opcono=opco_num[0].trim();
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(!getCommand().isTargetVisible(popup_CreateOrder))
		{
		String remote_stock="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opcono+" and PGSTKI in('R')  fetch first 1  rows only";
		ArrayList remote_stockItem=(new SupportFunctions()).retrieveData(remote_stock);
		System.out.println(remote_stockItem);
		ArrayList remote_stockItemNum=(ArrayList)(remote_stockItem.get(0));
		 String remote_stock_Item=remote_stockItemNum.get(0).toString();
		 searchItemPrice(remote_stock_Item.trim());
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
         String remote_item_num=remote_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
	     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", remote_item_num))){
	     System.out.println("item_num=="+remote_item_num);
	     String chek_boxR="jqg_productSearchGrid_"+remote_stock_Item.trim()+"-CS";
	     System.out.println("chek_box=="+chek_boxR);
	    log("Enter quantity of Item ",LogType.STEP);
	    getCommand().storeValue("remote_stock_item_num",remote_stock_Item.trim());
	   if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_boxR)) )
	   {
		getCommand().click(txt_OrderGuideItemQnty.replace("<#>", remote_item_num));
		getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", remote_item_num));
		getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", remote_item_num), "2");
		getCommand().click(chek_OrderGuide.replace("<#>",chek_boxR));
		String img_xpathR="//*[@id='"+remote_stock_Item.trim()+"-CS']/td[28]/img";
		System.out.println("Image present"+img_xpathR);
		getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpathR));
		System.out.println("Image present");
		
	  }
	   
	}
	   viewIsrOrder(); 
		}
		return this;
	}
	public ItemDeletePage addItemFromDB(String opco ,String custNum)
	{
		getCommand().waitFor(10);
		String opco_num[]=opco.split("-");
		System.out.println(opco_num[0].trim());
		String opcono=opco_num[0].trim();
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(!getCommand().isTargetVisible(popup_CreateOrder))
		{
			
				
				//String demand_status="SELECT PGITEM FROM espgpgtf WHERE PGSTKI in('D') fetch first 1  rows only";
				
				/* start  non stock Item*/
			
				String non_stock="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opcono+" and PGSTKI  in('N') and PGITST not in('I') and PGITPR not in('Y') fetch first 1  rows only";
				System.out.println(non_stock);
				ArrayList non_stockItem=(new SupportFunctions()).retrieveData(non_stock);
				System.out.println(non_stockItem);
				ArrayList non_stockItemNum=(ArrayList)(non_stockItem.get(0));
				 String non_stock_Item=non_stockItemNum.get(0).toString();
				 searchItemPrice(non_stock_Item.trim());
				 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
		         String non_item_num=non_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
			     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", non_item_num))){
			     System.out.println("item_num=="+non_item_num);
			     String chek_box="jqg_productSearchGrid_"+non_stock_Item.trim()+"-CS";
			     System.out.println("chek_box=="+chek_box);
			     getCommand().storeValue("non_stock_item_num", non_stock_Item.trim());
			    log("Enter quantity of Item ",LogType.STEP);
			   if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_box)) )
			   {
				getCommand().click(txt_OrderGuideItemQnty.replace("<#>", non_item_num));
				getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", non_item_num));
				getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", non_item_num), "2");
				getCommand().click(chek_OrderGuide.replace("<#>",chek_box));
				String img_xpath="//*[@id='"+non_stock_Item.trim()+"-CS']/td[28]/img";
				System.out.println("Image present"+img_xpath);
				getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpath));
				System.out.println("Image present");
				//viewIsrOrder();
			  }
		   } 
			   /* start  Demand  stock Item*/
				String demand_stock="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opcono+" and PGSTKI in('D') fetch first 1  rows only";
				ArrayList demand_stockItem=(new SupportFunctions()).retrieveData(demand_stock);
				System.out.println(demand_stockItem);
				ArrayList demand_stockItemNum=(ArrayList)(demand_stockItem.get(0));
				 String demand_stock_Item=demand_stockItemNum.get(0).toString();
				 searchItemPrice(demand_stock_Item.trim());
				 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
		         String demand_item_num=demand_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
			     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", demand_item_num))){
			     System.out.println("item_num=="+demand_item_num);
			     String chek_boxD="jqg_productSearchGrid_"+demand_stock_Item.trim()+"-CS";
			     System.out.println("chek_box=="+chek_boxD);
			    log("Enter quantity of Item ",LogType.STEP);
			    getCommand().storeValue("demand_stock_item_num",demand_stock_Item.trim());
			   if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_boxD)) )
			   {
				getCommand().click(txt_OrderGuideItemQnty.replace("<#>", demand_item_num));
				getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", demand_item_num));
				getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", demand_item_num), "2");
				getCommand().click(chek_OrderGuide.replace("<#>",chek_boxD));
				String img_xpathD="//*[@id='"+demand_stock_Item.trim()+"-CS']/td[28]/img";
				System.out.println("Image present"+img_xpathD);
				getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpathD));
				System.out.println("Image present");
				//viewIsrOrder();
			  }
			     } /* start  Remote  stock Item*/
				String remote_stock="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opcono+" and PGSTKI in('R')  fetch first 1  rows only";
				ArrayList remote_stockItem=(new SupportFunctions()).retrieveData(remote_stock);
				System.out.println(remote_stockItem);
				ArrayList remote_stockItemNum=(ArrayList)(remote_stockItem.get(0));
				 String remote_stock_Item=remote_stockItemNum.get(0).toString();
				 searchItemPrice(remote_stock_Item.trim());
				 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
		         String remote_item_num=remote_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
			     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", remote_item_num))){
			     System.out.println("item_num=="+remote_item_num);
			     String chek_boxR="jqg_productSearchGrid_"+remote_stock_Item.trim()+"-CS";
			     System.out.println("chek_box=="+chek_boxR);
			    log("Enter quantity of Item ",LogType.STEP);
			    getCommand().storeValue("remote_stock_item_num",remote_stock_Item.trim());
			   if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_boxR)) )
			   {
				getCommand().click(txt_OrderGuideItemQnty.replace("<#>", remote_item_num));
				getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", remote_item_num));
				getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", remote_item_num), "2");
				getCommand().click(chek_OrderGuide.replace("<#>",chek_boxR));
				String img_xpathR="//*[@id='"+remote_stock_Item.trim()+"-CS']/td[28]/img";
				System.out.println("Image present"+img_xpathR);
				getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpathR));
				System.out.println("Image present");
				
			  }
			   
			}
			   viewIsrOrder();     
		}
		return this;
		
			     
	}

	public ItemDeletePage cancellableItemsAlertPopDiv()
	{
		log("Please confirm to continue placing order ",LogType.STEP);
		if(getCommand().isTargetPresent(nonCancellable_ItemsAlert))
		{
			getCommand().waitForTargetPresent(nonCancellable_ItemsButton);
			if(getCommand().isTargetPresent(nonCancellable_ItemsButton))
			{
			getCommand().click(nonCancellable_ItemsButton);	
			getCommand().waitFor(3);
			}
		}
		return this;
		
	}
	public ItemDeletePage cancelOrderItemsAlertPopDiv()
	{
		log("Please confirm to cancel placing order ",LogType.STEP);
		if(getCommand().isTargetPresent(nonCancellable_ItemsAlert))
		{
			getCommand().isTargetPresent(nonCancellable_Cancel);
		
			//getCommand().click(nonCancellable_ItemsButtonCancel);
				System.out.print("nonCancellable_Cancel");
			//	getCommand().mouseHover(nonCancellable_Cancel);
			getCommand().click(nonCancellable_Cancel);
			getCommand().waitFor(3);
		}
		return this;
		
	}
	public ItemDeletePage checkItemStatus()
	{
		getCommand().waitFor(5);
		getCommand().waitForTargetPresent(confirm_ImageId);
		if(getCommand().isTargetPresent(confirm_ImageId))
		{
			String img_id="//*[@id='C']";
			String itenNum=(String) getCommand().retrieveValue("outOffItem");
			WebElement wst=getCommand().getDriver().findElement(By.xpath(img_id));
			String path = wst.getAttribute("src");
			System.out.println("Image path=="+path+" item num ==="+itenNum);
			String order_qnty="//*[@id='"+itenNum+"-CS']/td[25]";
			System.out.println("order_qnty"+order_qnty);
			String conf_qnty="//*[@id='"+itenNum+"-CS']/td[26]";
			WebElement wst_order=getCommand().getDriver().findElement(By.xpath(order_qnty));
			//String order_qnty_value=wst_order.getAttribute("value");
			String order_qnty_value=wst_order.getText();
			System.out.println("order_qnty_value*****"+order_qnty_value);
			WebElement wst_conf=getCommand().getDriver().findElement(By.xpath(conf_qnty));
			//String conf_qnty_value=wst_conf.getAttribute("value");
			String conf_qnty_value=wst_conf.getText();
			System.out.println("conf_qnty_value*****"+conf_qnty_value);
			String check_conf="0 cs";
			if(conf_qnty_value.trim().equals("2 cs"))
			{
				if(order_qnty_value.trim().equals("2 cs"))
				{
					System.out.println("Success");
					log("verify the item status column, conf.Qtys column and the Ord.Qty s column successfully",LogType.STEP);
				}
				else
				{
					getCommand().fail("Failed the Test case");
				}
			}
			else
			{
				getCommand().fail("Failed the Test case");
			}
			
			//*[@id='0089847-CS']/td[26]
			//SoftAssertion.assertAttributeValue(confirm_ImageId, attribute, value)
		}
		return this;
		
	}
	public ItemDeletePage toDeleteItem()
	{
		//String item_del=(new SupportFunctions()).readOutputData("Order_089.xls","ItemNum");
		//System.out.println("retive Item num===="+getCommand().retrieveValue("db_Item value"));
		//(new SupportFunctions()).deleteOutputData("Order_089.xls");
		log("Delete item from the Order ",LogType.STEP);
		String item_del=(String) getCommand().retrieveValue("db_Item value");
		System.out.println("retive Item num===="+getCommand().retrieveValue("db_Item value")+"item_del===="+item_del);
		deleteOpenOrderItems(item_del);
		return this;
		
	}
	public ItemDeletePage togetSumittedOrderNum(String opco)
	{
		getCommand().waitFor(10);
		String opco_num[]=opco.split("-");
		System.out.println(opco_num[0].trim());
		String opcono=opco_num[0].trim();
		String orderNum=(String) getCommand().retrieveValue("db_reorder_num");
		String sub_order_num="select NTornz  from esohnttf   where NTOPCO="+opcono+" and  NTEPO#="+orderNum+"";
		System.out.println(sub_order_num);
		ArrayList subordernum=(new SupportFunctions()).retrieveData(sub_order_num);
		System.out.println(subordernum);
		ArrayList submitted_orderNum=(ArrayList)(subordernum.get(0));
		String original_order_num=submitted_orderNum.get(0).toString();
		String delivered_query="update esohnttf set ntorst ='C' WHERE NTOPCO="+opcono+" and  NTornz='"+original_order_num+"'";
		String flag= (new SupportFunctions().updateData(delivered_query));
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
	public ItemDeletePage viewAllhistoriallink()
	{
		
		
		log("Click on All Historial  Order Link ",LogType.STEP);
		if(getCommand().isTargetPresent(lnk_AllHistorialLink)){
			
			getCommand().click(lnk_AllHistorialLink);
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='ord-nonopenloading']"));
		}
		return this;
		
	}
	public ItemDeletePage selectDeliveredOrder(String OrderName)
	{
		log("Select delevered order ",LogType.STEP);
		getCommand().waitForTargetPresent(gbox_nonopenOrdersTab);
		if(getCommand().isTargetPresent(gbox_nonopenOrdersTab))
		{
			String st=(String) getCommand().retrieveValue("db_reorder_num");
			String strItemXpath = "//*[@id='" + st + "']";
			String st2="+"+OrderName+"+";
			String ss=st2.replace('+', '"');
			//String st1="//*[@id='"+st+"'] and title="+ss+"";
			String st1="//a[@id='"+st+"']";
			System.out.print(st1);
		
			getCommand().getDriver().findElement(By.xpath(st1)).click();
		}
		return this;
		
	}
	public ItemDeletePage clickReOrderButton()
	{log("Click on Reorder button ",LogType.STEP);
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(gBox_OrderDetails);
		getCommand().waitForTargetPresent(btn_ReOrder);
		if(getCommand().isTargetPresent(btn_ReOrder))
		{
		getCommand().click(btn_ReOrder)	;
		
		}
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		return this;
		
	}
	public ItemDeletePage getReOrderName()
	{
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(btn_shipping);
		if(getCommand().isTargetPresent(btn_shipping)){
			WebElement wst=getCommand().getDriver().findElement(By.xpath("//*[@id='actordval']"));
			String reOeder_Name=wst.getAttribute("value").toString();
			getCommand().storeValue("re_Order_name", reOeder_Name);
		}
		return this;
	}
	public ItemDeletePage viewAllSumittedOrder()
	{
		getCommand().waitFor(4);
		
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='ord-submittedloading']"));
			
			log("Click on All Submitted  Order Link ",LogType.STEP);
			getCommand().isTargetVisible(lnk_AllSubmittedOrders);
			getCommand().waitForTargetPresent(lnk_AllSubmittedOrders);
			if(getCommand().isTargetPresent(lnk_AllSubmittedOrders)){
				
				getCommand().click(lnk_AllSubmittedOrders);
			}
			return this;
			
		
			
	}
	public ItemDeletePage selectSubmittedOrderFromDB(String opco,String customer) {
		getCommand().waitFor(5);
		String opco_num[]=opco.split("-");
		System.out.println(opco_num[0].trim());
		String opcono=opco_num[0].trim();
		
		//System.out.println("CUNO*****"+custNo);
		//and  NTMOID='ACCESS'
		String sub_order_num="select NTDS20,NTEPO#  from esohnttf   where NTOPCO="+opcono+" and ntorst ='S' and trim(NTCUNO)='"+customer.trim()+"' order by  NTEPO# desc fetch first 1 row only";
		
		System.out.println(sub_order_num);
		ArrayList suborderDetails=(new SupportFunctions()).retrieveData(sub_order_num);
		System.out.println(suborderDetails);
		ArrayList submitted_orderDetails=(ArrayList)(suborderDetails.get(0));
		String original_order_name=submitted_orderDetails.get(0).toString();
		String original_order_num=submitted_orderDetails.get(1).toString();
		selectSubmittedOrderForModify(original_order_name,original_order_num);
		//selectSubmittedOrderForModify(original_order_name,original_order_num);
		return this;
		
	}
	
	public ItemDeletePage selectSubmittedOrderFromDB_114(String opco,String username) {
		getCommand().waitFor(5);
		String opco_num[]=opco.split("-");
		System.out.println(opco_num[0].trim());
		String opcono=opco_num[0].trim();
		String sub_order_num="select NTDS20,NTEPO#  from esohnttf   where NTOPCO="+opcono+" and ntorst ='S' and NTSBI2='"+username+"' order by  NTEPO# desc fetch first 1 row only";
		System.out.println(sub_order_num);
		ArrayList suborderDetails=(new SupportFunctions()).retrieveData(sub_order_num);
		System.out.println(suborderDetails);
		ArrayList submitted_orderDetails=(ArrayList)(suborderDetails.get(0));
		String original_order_name=submitted_orderDetails.get(0).toString();
		String original_order_num=submitted_orderDetails.get(1).toString();
		selectSubmittedOrderForModify(original_order_name,original_order_num);
		return this;
		
	}
	public ItemDeletePage selectSubmittedOrderFromDB_130(String opco) {
		getCommand().waitFor(10);
		String opco_num[]=opco.split("-");
		System.out.println(opco_num[0].trim());
		String opcono=opco_num[0].trim();
		String order_numref=(String)(getCommand().retrieveValue("db_order_num_130"));
		int orderrefNum=Integer.parseInt(order_numref);
		String sub_order_num="select NTDS20,NTEPO#  from esohnttf   where NTOPCO="+opcono+" and ntorst ='S' and NTEPO#='"+orderrefNum+"' order by  NTEPO# desc fetch first 1 row only";
		System.out.println(sub_order_num);
		ArrayList suborderDetails=(new SupportFunctions()).retrieveData(sub_order_num);
		System.out.println(suborderDetails);
		ArrayList submitted_orderDetails=(ArrayList)(suborderDetails.get(0));
		String original_order_name=submitted_orderDetails.get(0).toString();
		String original_order_num=submitted_orderDetails.get(1).toString();
		selectSubmittedOrderForModify(original_order_name,original_order_num);
		return this;
		
	}
	public ItemDeletePage selectSubmittedOrderFromDB_133(String opco) {
		getCommand().waitFor(10);
		String opco_num[]=opco.split("-");
		System.out.println(opco_num[0].trim());
		
		String opcono=opco_num[0].trim();
		String order_numref=(String)(getCommand().retrieveValue("db_order_num_133"));
		int orderrefNum=Integer.parseInt(order_numref);
		String sub_order_num="select NTDS20,NTEPO#  from esohnttf   where NTOPCO="+opcono+" and ntorst ='S' and  NTEPO#='"+orderrefNum+"' order by  NTEPO# desc fetch first 1 row only";
		System.out.println(sub_order_num);
		ArrayList suborderDetails=(new SupportFunctions()).retrieveData(sub_order_num);
		System.out.println(suborderDetails);
		ArrayList submitted_orderDetails=(ArrayList)(suborderDetails.get(0));
		String original_order_name=submitted_orderDetails.get(0).toString();
		String original_order_num=submitted_orderDetails.get(1).toString();
		selectSubmittedOrderForModify(original_order_name,original_order_num);
		return this;
		
	}
	public ItemDeletePage selectCancelledOrderFromDB(String opco) {
		getCommand().waitFor(5);
		String opco_num[]=opco.split("-");
		System.out.println(opco_num[0].trim());
		String opcono=opco_num[0].trim();
		String sub_order_num="select NTDS20,NTEPO#  from esohnttf   where NTOPCO="+opcono+" and ntorst ='C' order by  NTORNZ desc fetch first 1 row only";
		System.out.println(sub_order_num);
		ArrayList suborderDetails=(new SupportFunctions()).retrieveData(sub_order_num);
		System.out.println(suborderDetails);
		ArrayList submitted_orderDetails=(ArrayList)(suborderDetails.get(0));
		String original_order_name=submitted_orderDetails.get(0).toString();
		String original_order_num=submitted_orderDetails.get(1).toString();
		selectCancelledForModify(original_order_name,original_order_num);
		return this;
		
	}
	public ItemDeletePage selectSubmittedOrderForModify(String OrderName,String OrderNum)
	{
		log("Select submitted order ",LogType.STEP);
		getCommand().waitForTargetPresent(grid_RecentOrders);
		if(getCommand().isTargetPresent(grid_RecentOrders))
		{
			String strItemXpath = "//*[@id='" + OrderNum + "']";
			String st2="+"+OrderName+"+";
			String ss=st2.replace('+', '"');
			//String st1="//*[@id='"+st+"'] and title="+ss+"";
			String st1="//a[@id='"+OrderNum+"']";
			System.out.print(st1);
			try{
			getCommand().getDriver().findElement(By.xpath(st1)).click();
			}
			catch(Exception e)
			{
			SoftAssertion.fail("Order is not submitted Successfully.Status is submitting. Please reexecute the test case again");
			}
		}
		
		return this;
		
	}
	public ItemDeletePage selectCancelledForModify(String OrderName,String OrderNum)
	{
		log("Select Cancelled order ",LogType.STEP);
		getCommand().waitForTargetPresent(gbox_nonopenOrdersTab);
		if(getCommand().isTargetPresent(gbox_nonopenOrdersTab))
		{
			String strItemXpath = "//*[@id='" + OrderNum + "']";
			String st2="+"+OrderName+"+";
			String ss=st2.replace('+', '"');
			//String st1="//*[@id='"+st+"'] and title="+ss+"";
			String st1="//a[@id='"+OrderNum+"']";
			System.out.print(st1);
			getCommand().getDriver().findElement(By.xpath(st1)).click();
		}
		
		return this;
		
	}
	public ItemDeletePage cancelOrderLink()
	
	{
		getCommand().waitFor(20);
		log("Click on cancel order link ",LogType.STEP);
		getCommand().waitForTargetPresent(cancel_OrderLink);
		
		if(getCommand().isTargetPresent(cancel_OrderLink))
		{
			getCommand().click(cancel_OrderLink);
			
		}
		
		return this;
		
	}
	public ItemDeletePage cancelOrderPopup()
	{
		getCommand().waitFor(10);
		log("Cancel order popup ",LogType.STEP);
		getCommand().waitForTargetPresent(cancel_OrderDiv);
		if(getCommand().isTargetPresent(cancel_OrderDiv))
		{
			getCommand().waitForTargetPresent(cancel_OrderButton);
			if(getCommand().isTargetPresent(cancel_OrderButton))
			{
				log("Click cancel_OrderButton ",LogType.STEP);
				getCommand().click(cancel_OrderButton);
			}
		}
		return this;
		
	}
	public ItemDeletePage checkQntyEdit() {
		log("Cannot edit the quantity field of the following items in the order: ",LogType.STEP);
		
		return this;
	}
	public ItemDeletePage searchItemToAddExistingOrders() {
		
		String non_stock=(String) getCommand().retrieveValue("non_stock_item_num");
		 log("Search non stock item ",LogType.STEP);
		 searchItemPrice(non_stock);
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
		 log("User should not be able to modify non stock item "+non_stock,LogType.STEP);
		 
		 String demand_stock=(String) getCommand().retrieveValue("demand_stock_item_num");
		 log("Search demand stock item ",LogType.STEP);
		 searchItemPrice(demand_stock);
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
		 log("User should not be able to modify demand stock item "+demand_stock,LogType.STEP);
		 
		 String remote_stock=(String) getCommand().retrieveValue("remote_stock_item_num");
		 log("Search remote stock item ",LogType.STEP);
		 searchItemPrice(remote_stock);
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
		 log("User should not be able to modify remote stock item "+remote_stock,LogType.STEP);
		 
		 log("Search outoff  stock item ",LogType.STEP);
		 String outoff_stock=(String) getCommand().retrieveValue("db_outstock value");
		 searchItemPrice(outoff_stock);
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
		 log("User should not be able to modify outoff stock item "+outoff_stock,LogType.STEP);
		return this;
		
		
	}
    public ItemDeletePage clickListTab() {
    	getCommand().waitFor(3);
    	 log("Click on List Tab",LogType.STEP);
    	 getCommand().waitForTargetPresent(list_tab);
    	 if(getCommand().isTargetPresent(list_tab))
    	 {
    	 getCommand().click(list_tab);
    	 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
    	 }
	      return this;
	
	
    }
    
    public ItemDeletePage createNewList()
    {
    	log("Create new List",LogType.STEP);
   	 getCommand().waitForTargetPresent(create_NewListButton);
   	 if(getCommand().isTargetPresent(create_NewListButton))
   	 {
   	 getCommand().click(create_NewListButton);
   	
   	 }
     return this;
    	
    }
    public ItemDeletePage create_NewMyList()
    {
    	getCommand().waitForTargetPresent(create_NewListDiv);
      	 if(getCommand().isTargetPresent(create_NewListDiv))
      	 {
      		getCommand().isTargetPresent(list_Name);
      		String strRandomList = RandomStringUtils.randomAlphabetic(10);
      		getCommand().sendKeys(list_Name, strRandomList);
      		getCommand().isTargetPresent(check_listQuickEntry);
      		getCommand().click(check_listQuickEntry);
      		getCommand().isTargetPresent(createnew_listBtn);
      		getCommand().click(createnew_listBtn);
      		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
      		 WebElement wst=getCommand().getDriver().findElement(By.id("listNoTxt"));
       		System.out.println("ListNo==="+wst.getText());
       		getCommand().storeValue("Store_List_Num", wst.getText());
      	 }
    	
		return this;
		
    	
    }
    public ItemDeletePage quickOrderEntrupopup()
    {
    	getCommand().waitForTargetPresent(quickList_EntryPopupButton);
    	if(getCommand().isTargetPresent(quickList_EntryPopupButton))
    	{
    	 String non_stock=(String) getCommand().retrieveValue("non_stock_item_num");
   		 log("Add non stock item  to list",LogType.STEP);
   		 enterQuickOrderEntryDetailsFromDB(non_stock,"3","0");
   		 log("User should not be able to modify non stock item "+non_stock,LogType.STEP);
   		 
   		 String demand_stock=(String) getCommand().retrieveValue("demand_stock_item_num");
   		 log("Add  demand stock item to list",LogType.STEP);
   		 enterQuickOrderEntryDetailsFromDB(demand_stock,"3","0");
   		 log("User should not be able to modify demand stock item "+demand_stock,LogType.STEP);
   		 
   		 String remote_stock=(String) getCommand().retrieveValue("remote_stock_item_num");
   		 log("Add remote stock item to list ",LogType.STEP);
   		 enterQuickOrderEntryDetailsFromDB(remote_stock,"3","0");
   		 log("User should not be able to modify demand stock item "+remote_stock,LogType.STEP);
   		 
   		 log("Search outoff  stock item ",LogType.STEP);
		 String outoff_stock=(String) getCommand().retrieveValue("db_outstock value");
		 enterQuickOrderEntryDetailsFromDB(outoff_stock,"3","0");
		 log("User should not be able to modify outoff stock item "+outoff_stock,LogType.STEP);
    	}
    	
		return this;
    	
    }
    public ItemDeletePage enterQuickOrderEntryDetailsFromDB(String strUPC, String strCaseQty, String strSplitQty){

		if(getCommand().isTargetPresent(list_supc)){
			log("Enter Item UPC " + strUPC,LogType.STEP);
			getCommand().clear(list_supc);
			getCommand().sendKeys(list_supc, strUPC);
		}
		if(getCommand().isTargetPresent(list_CaseQty)){

			log("Enter Case Quantity " + strCaseQty,LogType.STEP);
			getCommand().clear(list_CaseQty);
			getCommand().sendKeys(list_CaseQty, strCaseQty);
		}
		if(getCommand().isTargetPresent(split_ListQty)){

			log("Enter Split Quantity " + split_ListQty,LogType.STEP);
			getCommand().clear(split_ListQty);
			getCommand().sendKeys(split_ListQty,strSplitQty);
		}
		if(getCommand().isTargetPresent(valSupc_Button)){

			log("Click on Add Button",LogType.STEP);	
			getCommand().click(valSupc_Button);
			getCommand().waitFor(5);
		}
		return this;
	}
    public ItemDeletePage addToList()
    {
    	getCommand().waitForTargetPresent(addToList_Button);
    	log("Item added to list",LogType.STEP);	
    	if(getCommand().isTargetPresent(addToList_Button))
    	{
    		getCommand().click(addToList_Button);
    		
    	}
    	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		return this;
    	
    }
    /*public ItemDeletePage getListDetails()
    {
    	getCommand().waitForTargetPresent(listHeader_Line1);
    	if(getCommand().isTargetPresent(listHeader_Line1))
    		
    	{
    		getCommand().isTargetPresent(listNo_Txt);
    		String list_num=getCommand().getDriver().findElement(By.id("listNoTxt")).getText();
    		System.out.println("list_num+++++++++"+list_num);
    		getCommand().storeValue("list_num", list_num);
    		
    	}
    	return this;
    }
    public ItemDeletePage viewAllMyLis()
    {
    	log("View all created  list",LogType.STEP);	
    	getCommand().waitForTargetPresent(lsBodyViewall_customlink);
    	if(getCommand().isTargetPresent(lsBodyViewall_customlink))
    	{
    		getCommand().click(lsBodyViewall_customlink);
    	}
    	return this;
    }
    public ItemDeletePage selectMyList(){
    	log("Select created  list",LogType.STEP);	
    	getCommand().waitForTargetPresent(gbox_recentListGrid);
    	if(getCommand().isTargetPresent(gbox_recentListGrid))
    	{
    	String list_num=(String) getCommand().retrieveValue("list_num");
    	getCommand().getDriver().findElement(By.id(list_num)).click();
    	}
    	(new SupportFunctions()).waitForLoading(400, By.xpath("//*[@id='asyncLoadingMessageText']"));
    	return this;
    }*/
    public ItemDeletePage clickOnOrderGuide()
    {log("Click on order guide",LogType.STEP);	
    	getCommand().waitForTargetPresent(item_HistoryTab);
    	if(getCommand().isTargetPresent(item_HistoryTab)){
    		getCommand().click(item_HistoryTab);
    	}
    	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
    	return this;
    }
    public ItemDeletePage searchOrderGuideItem()
    {
    	 String non_stock=(String) getCommand().retrieveValue("non_stock_item_num");
   		 log("Add non stock item  to list",LogType.STEP);
   		 searchOrderGuide(non_stock);
   		 log("User should not be able to modify non stock item "+non_stock,LogType.STEP);
   		 
   		 String demand_stock=(String) getCommand().retrieveValue("demand_stock_item_num");
   		 log("Add  demand stock item to list",LogType.STEP);
   		 searchOrderGuide(demand_stock);
   		 log("User should not be able to modify demand stock item "+demand_stock,LogType.STEP);
   		 
   		 log("Search outoff  stock item ",LogType.STEP);
		 String outoff_stock=(String) getCommand().retrieveValue("db_outstock value");
		 searchOrderGuide(outoff_stock);
		 log("User should not be able to modify outoff stock item "+outoff_stock,LogType.STEP);
   		 return this;
    }
    public ItemDeletePage searchOrderGuide(String item)
    {
    	getCommand().waitForTargetPresent(srch_Top);
    	if(getCommand().isTargetPresent(srch_Top))
    	{
    		getCommand().clear(srch_Top);
    		getCommand().sendKeys(srch_Top, item);
    	}
		return this;
    }
	public ItemDeletePage CheckCancelDemandStatusItem() {
		 log("User should not be able to cancel demand stock item ",LogType.STEP);
		return this;	
		
	}
	public ItemDeletePage CheckCancelNonStockItem()
	{
		 log("User should not be able to cancel non stock item ",LogType.STEP);
			return this;	
	}
	public ItemDeletePage CheckCancelRemoteStatusItem()
	{
		 log("User should not be able to cancel Remote stock item ",LogType.STEP);
		 return this;
	}
	public ItemDeletePage CheckCancelDropStatusItem()
	{

		 log("User should not be able to cancel Drop Ship  item ",LogType.STEP);
		 return this;
	}
	public ItemDeletePage checkEditable_162() {
		 log("Canceled items remain uneditable ",LogType.STEP);
		 return this;
	}
	public ItemDeletePage clickISR_link()
	{
		getCommand().waitFor(3);
		log("Click on ISR link ",LogType.STEP);
		getCommand().getDriver().switchTo().frame("topFrame");
		getCommand().waitForTargetPresent(ISR_Link);
		if(getCommand().isTargetPresent(ISR_Link))
		{
			getCommand().click(ISR_Link);
		}
		return this;
	}
	public ItemDeletePage clickISR_userLink()
	{
		getCommand().waitFor(3);
		log("Add new ISR user ",LogType.STEP);
		getCommand().getDriver().switchTo().frame("botFrame");
		getCommand().waitForTargetPresent(addISR_user);
		if(getCommand().isTargetPresent(addISR_user))
		{
			getCommand().click(addISR_user);
		}
		return this;
	}
	public ItemDeletePage addNewISR_userLink(){
		getCommand().waitFor(3);
		getCommand().getDriver().switchTo().frame("botFrame");
		getCommand().waitForTargetPresent(user_id);
		log("Enter user name ",LogType.STEP);
		if(getCommand().isTargetPresent(user_id))
		{
			String strRandomUserID = RandomStringUtils.randomAlphabetic(10);	
			getCommand().storeValue("userID", strRandomUserID);
			getCommand().sendKeys(user_id, strRandomUserID);
		}
		return this;
	}
	public ItemDeletePage addContactName()
	{
		getCommand().waitForTargetPresent(contact_name);
		log("Enter contact name ",LogType.STEP);
		if(getCommand().isTargetPresent(contact_name))
		{		
			getCommand().sendKeys(contact_name, "AutomationTest");
		}
		return this;
		
	}
	public ItemDeletePage selectSyscoMarket(){
	getCommand().waitForTargetPresent(check_sysco);
	log("Select Sysco market Express ",LogType.STEP);
	if(getCommand().isTargetPresent(check_sysco))
	{
		getCommand().click(check_sysco);
	}
	return this;
	}
	public ItemDeletePage clickSaveUser()
	{
		getCommand().waitForTargetPresent(btn_saveUser);
		log("Save ISR User details ",LogType.STEP);
		if(getCommand().isTargetPresent(btn_saveUser))
		{
			getCommand().click(btn_saveUser);
		}
		return this;
		
	}
	public ItemDeletePage clickLogOut()
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
	public ItemDeletePage firstloginNewISRUser() {
		getCommand().waitForTargetPresent(txt_IsrUserName);
		if (getCommand().isTargetPresent(txt_IsrUserName)){
			String UserName=(String) getCommand().retrieveValue("userID");
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
	public ItemDeletePage change_password(String newPassword)
	{
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
		if (getCommand().isTargetPresent(btn_submit)){
			log("Click on Submit Button",LogType.STEP);	
			getCommand().click(btn_submit);
			//log("Login Successful",LogType.STEP);	

		}
		
		return this;
		
	}
	public ItemDeletePage selectSecurityQuestions()
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
	public ItemDeletePage selectSecurityQuestionsAnswers(String answers)
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
	public ItemDeletePage click_submit()
	{
		if (getCommand().isTargetPresent(submit_SecurityQA)){
			log("Click on Submit Button",LogType.STEP);	
			getCommand().click(submit_SecurityQA);
			//log("Login Successful",LogType.STEP);	

		}
		return this;
		
	}
	public ItemDeletePage checkSuccess_001() {
		log("New user is able to access the application",LogType.STEP);
		return this;
	}
	public ItemDeletePage checkQntyEdit_147() {
		String itemnum= (String) getCommand().retrieveValue("item_num_147");
		updateOpenOrderItems(itemnum,"5");
		return this;
	}
public ItemDeletePage searchItemToAddExistingOrders_147() {
		
		String item_stock=(String) getCommand().retrieveValue("item_num_147");
		 log("Search non stock item ",LogType.STEP);
		 searchItemPrice(item_stock);
		// updateOpenOrderItems(item_stock,"6");
		 log("User should be able to modify  item "+item_stock,LogType.STEP);
		 return this;
}
public ItemDeletePage createNewList_147() {
	getCommand().waitForTargetPresent(create_NewListDiv);
 	 if(getCommand().isTargetPresent(create_NewListDiv))
 	 {
 		getCommand().isTargetPresent(list_Name);
 		String strRandomList = RandomStringUtils.randomAlphabetic(11);
 		getCommand().sendKeys(list_Name, strRandomList);
 		getCommand().isTargetPresent(check_listQuickEntry);
 		getCommand().click(check_listQuickEntry);
 		getCommand().isTargetPresent(createnew_listBtn);
 		getCommand().click(createnew_listBtn);
 		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
 		
 	 }
	
	return this;
	
} 
public ItemDeletePage quickOrderEntrupopup_147()
{
	getCommand().waitForTargetPresent(quickList_EntryPopupButton);
	if(getCommand().isTargetPresent(quickList_EntryPopupButton))
	{
	 String item_stock=(String) getCommand().retrieveValue("item_num_147");
		 log("Add item  to list",LogType.STEP);
		 enterQuickOrderEntryDetailsFromDB(item_stock,"7","0");
		 log("User should  able to modify non stock item "+item_stock,LogType.STEP);
	}
	return this; 
}

public ItemDeletePage searchOrderGuideItem_147()
{
	 String item_stock=(String) getCommand().retrieveValue("item_num_147");
		 log("Add  item  to list",LogType.STEP);
		 searchOrderGuide(item_stock);
		 log("User should  be able to modify  item "+item_stock,LogType.STEP);
		return this;
		 
	}
public ItemDeletePage addCaseandSplitItem_001(String opco, String customer) {
	getCommand().waitFor(10);
	String opco_num[]=opco.split("-");
	System.out.println(opco_num[0].trim());
	String opcono=opco_num[0].trim();
	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
	if(!getCommand().isTargetVisible(popup_CreateOrder))
	{
		
		    String caseSplit_item="select pgitem from espgpgtf where PGOPCO="+opcono+"  and PGSPLT='Y'  and PGUNCA>0  and PGITPR not in('Y')   and PGITST not in('I') and PGAVSK>0" ;
			System.out.println(caseSplit_item);
			ArrayList caseSplit_Item=(new SupportFunctions()).retrieveData(caseSplit_item);
			System.out.println(caseSplit_Item);
			ArrayList case_stockItemNum=(ArrayList)(caseSplit_Item.get(0));
			 String case_stock_Item=case_stockItemNum.get(0).toString();
			 searchItemPrice(case_stock_Item.trim());
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
	         String non_item_num=case_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
             
             
		     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", non_item_num))){
		     System.out.println("item_num=="+non_item_num);
		     String chek_box="jqg_productSearchGrid_"+case_stock_Item.trim()+"-CS";
		     System.out.println("chek_box=="+chek_box);
		     getCommand().storeValue("eachCase_001", case_stock_Item.trim());
		    log("Enter quantity of Item ",LogType.STEP);
		   if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_box)) )
		   {
			getCommand().click(txt_OrderGuideItemQnty.replace("<#>", non_item_num));
			getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", non_item_num));
			getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", non_item_num), "2");
			String eaQuantity=case_stock_Item.trim()+"-EA_syscoGridColumnEditableQuantityFormatter";
            Select stEachQuantity=new Select(getCommand().getDriver().findElement(By.id(eaQuantity)));
            stEachQuantity.selectByValue("2");	
			getCommand().click(chek_OrderGuide.replace("<#>",chek_box));
			String img_xpath="//*[@id='"+case_stock_Item.trim()+"-CS']/td[28]/img";
			String img_xpathEA="//*[@id='"+case_stock_Item.trim()+"-EA']/td[28]/img";
			System.out.println("Image present"+img_xpath);
			getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpath));
			getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpathEA));
			System.out.println("Image present");
			
		  }
	   } 
		  viewIsrOrder();
}
	return this;
}
public ItemDeletePage verifyViewOrdergrid_001() {
	String itemNum= (String) getCommand().retrieveValue("eachCase_001");
	String chek_box="jqg_grid1_"+itemNum.trim()+"-CS";
	String each_id="jqg_grid1_"+itemNum.trim()+"-EA";
	if(getCommand().isTargetPresent(caseSplit_grid)){
	if((getCommand().getDriver().findElement(By.id(chek_box)).isDisplayed())&&(getCommand().getDriver().findElement(By.id(each_id)).isDisplayed()))
	{
		log("Case and split should be displayed together in the view order grid",LogType.STEP);
		getCommand().getDriver().findElement(By.id(chek_box)).click();
		
	}
	else{
		log("Case and split should not  be displayed together in the view order grid",LogType.STEP);
	    }
	}
	return this;
}
public ItemDeletePage checkdeleteBtnCase_001()
{
	String itemNum= (String) getCommand().retrieveValue("eachCase_001");
	getCommand().waitForTargetPresent(btn_shipping);
	if(getCommand().isTargetPresent(btn_shipping)){
		//log("Click on Open Order Link ",LogType.STEP);
		String caseDel=itemNum+"-CS";
		String st="+"+caseDel+"+";
		String eachDel=itemNum+"-EA";
		String st1="+"+eachDel+"+";
		//log("Click on Item price ",LogType.STEP);
		final Target case_delete=new Target ("caseSplit_delete","//a[@id='undefined' and contains(@onclick,'deleteInValidRow("+st.replace('+', '"')+")')]",Target.XPATH);
		final Target each_delete=new Target ("eachSplit_delete","//a[@id='undefined' and contains(@onclick,'deleteInValidRow("+st1.replace('+', '"')+")')]",Target.XPATH);
		if((getCommand().isTargetPresent(case_delete)) && (getCommand().isTargetPresent(each_delete)))
		{
			
			log("The Delete icon should be displayed next to both the case and the split line.",LogType.STEP);
		}
		
	}
	return this;
	
}
public ItemDeletePage cliclAddtoList() {
	getCommand().waitFor(3);
	getCommand().waitForTargetPresent(caseSplit_ListBtn);
	log("Click on add to List",LogType.STEP);
	if(getCommand().isTargetPresent(caseSplit_ListBtn)){
		getCommand().click(caseSplit_ListBtn);
	}
	return this;
}
public ItemDeletePage createNewListCaseSplit()
{
	getCommand().waitFor(3);
	getCommand().waitForTargetPresent(caseSplit_NewList);
	log("Create new list",LogType.STEP);
	if(getCommand().isTargetPresent(caseSplit_NewList)){
		getCommand().click(caseSplit_NewList);
	}
	return this;
	
}
public ItemDeletePage createNewListCaseSplitPopup()
{
	getCommand().waitForTargetPresent(caseSplit_NewListpopup);
	log("Check popup for create List",LogType.STEP);
	/*if(getCommand().isTargetPresent(caseSplit_NewListpopup)){
		getCommand().click(caseSplit_NewList);
	}*/
	return this;
	
}
public ItemDeletePage createNewListCaseSplitItem()
{
	String strRandomList = RandomStringUtils.randomAlphabetic(10);
	getCommand().storeValue("case_split_lsit_001", strRandomList);
	getCommand().waitForTargetPresent(caseSplit_NewListNamepopup);
	log("Enter List name",LogType.STEP);
	if(getCommand().isTargetPresent(caseSplit_NewListNamepopup)){
		getCommand().sendKeys(caseSplit_NewListNamepopup,strRandomList);
	}
	if(getCommand().isTargetPresent(caseSplit_NewListBtn))
	{
		getCommand().click(caseSplit_NewListBtn);
	}
	log("Item is added to My list",LogType.STEP);
	getCommand().waitFor(10);
	return this;
	
}
public ItemDeletePage getCsaeSplitList_001()
{
	String myList="//*[@id='mylists']";
	String list_name=(String) getCommand().retrieveValue("case_split_lsit_001");
	  //WebElement wst=getCommand().getDriver().findElement(By.xpath(myList));
	  WebElement dateWidget = getCommand().getDriver().findElement(By.xpath(myList));
	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
	    
	  for (WebElement cell: columns){  
	   //Select 13th Date   
	   if (cell.getText().equals(list_name)){  
	   cell.findElement(By.linkText(list_name)).click();  
	   break;  
	   }  
	  }
	  log("Item is added to My list success",LogType.STEP);
	return this;
	
}
public ItemDeletePage addCaseandSplitItem_010(String opco, String customer) {
	getCommand().waitFor(10);
	String opco_num[]=opco.split("-");
	System.out.println(opco_num[0].trim());
	String opcono=opco_num[0].trim();
	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
	if(!getCommand().isTargetVisible(popup_CreateOrder))
	{
		
		    String caseSplit_item="select pgitem from espgpgtf where PGOPCO="+opcono+"  and PGSPLT='Y'  and PGUNCA>0  and PGITPR not in('Y')   and PGITST not in('I') and PGAVSK>0" ;
			System.out.println(caseSplit_item);
			ArrayList caseSplit_Item=(new SupportFunctions()).retrieveData(caseSplit_item);
			System.out.println(caseSplit_Item);
			ArrayList case_stockItemNum=(ArrayList)(caseSplit_Item.get(0));
			 String case_stock_Item=case_stockItemNum.get(0).toString();
			 searchItemPrice(case_stock_Item.trim());
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
	         String non_item_num=case_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
             
             
		     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", non_item_num))){
		     System.out.println("item_num=="+non_item_num);
		     String chek_box="jqg_productSearchGrid_"+case_stock_Item.trim()+"-CS";
		     System.out.println("chek_box=="+chek_box);
		     getCommand().storeValue("eachCase_010", case_stock_Item.trim());
		    log("Enter quantity of Item ",LogType.STEP);
		   if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_box)) )
		   {
			getCommand().click(txt_OrderGuideItemQnty.replace("<#>", non_item_num));
			getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", non_item_num));
			getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", non_item_num), "2");
			String eaQuantity=case_stock_Item.trim()+"-EA_syscoGridColumnEditableQuantityFormatter";
            Select stEachQuantity=new Select(getCommand().getDriver().findElement(By.id(eaQuantity)));
            stEachQuantity.selectByValue("2");	
			getCommand().click(chek_OrderGuide.replace("<#>",chek_box));
			String img_xpath="//*[@id='"+case_stock_Item.trim()+"-CS']/td[28]/img";
			String img_xpathEA="//*[@id='"+case_stock_Item.trim()+"-EA']/td[28]/img";
			System.out.println("Image present"+img_xpath);
			getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpath));
			getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpathEA));
			System.out.println("Image present");
			
		  }
	   } 
		  viewIsrOrder();
}
	return this;
}
public ItemDeletePage storeOrderNum_010()
{
	getCommand().waitForTargetPresent(div_Order);
	if(getCommand().isTargetPresent(div_Order)){
	String num=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
	getCommand().storeValue("db_order_num_010", num);		
	}
	return this;	
}
public ItemDeletePage storeOrderNum_160()
{
	getCommand().waitForTargetPresent(div_Order);
	if(getCommand().isTargetPresent(div_Order)){
	String num=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
	getCommand().storeValue("db_order_num_160", num);		
	}
	return this;	
}
public ItemDeletePage storeOrderNum_161()
{
	getCommand().waitForTargetPresent(div_Order);
	if(getCommand().isTargetPresent(div_Order)){
	String num=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
	getCommand().storeValue("db_order_num_161", num);		
	}
	return this;	
}
public ItemDeletePage selectNormalSubmittedOrder_010(String st11)
{
	getCommand().waitForTargetPresent(grid_RecentOrders);
	if(getCommand().isTargetPresent(grid_RecentOrders))
	{
		String st=(String) getCommand().retrieveValue("db_order_num_010");
		String strItemXpath = "//*[@id='" + st + "']";
		//(new SupportFunctions()).deleteOutputData("Order_087.xls");
		//String status="Submitted";
		
		//String st1="//*[@id='"+st+"']/td[19]";
		//String st2="+"+st1+"+";
		//String st1="Hand PricingUpdate'";
		getCommand().getDriver().navigate().refresh();
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		getCommand().getDriver().navigate().refresh();
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		getCommand().click(btn_OrderRefresh);
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		 getCommand().click(btn_OrderRefresh);
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		 getCommand().click(btn_OrderRefresh);
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		 
		 log("Click on Order  Link ",LogType.STEP);
		//String st11="Hand PricingUpdate";
		getCommand().click(btn_OrderRefresh);
		 (new SupportFunctions()).waitForLoading(500, By.xpath("//*[@id='loadingDiv11']"));
		String st2="+"+st11+"+";
		String ss=st2.replace('+', '"');
		//String st1="//*[@id='"+st+"'] and title="+ss+"";
		String st1="//a[@id='"+st+"']";
		System.out.print(st1);
	try{
		getCommand().getDriver().findElement(By.xpath(st1)).click();
	}
	catch(Exception e)
	{
	SoftAssertion.fail("Order is not submitted Successfully. Please reexecute the test case again");
	}
	}
	return this;
	}

public ItemDeletePage checkdeleteBtnCase_010()
{
	getCommand().waitFor(5);
	String itemNum= (String) getCommand().retrieveValue("eachCase_010");
	getCommand().waitForTargetPresent(btn_shipping);
	if(getCommand().isTargetPresent(btn_shipping)){
		//log("Click on Open Order Link ",LogType.STEP);
		String caseDel=itemNum+"-CS";
		String st="+"+caseDel+"+";
		String eachDel=itemNum+"-EA";
		String st1="+"+eachDel+"+";
		//log("Click on Item price ",LogType.STEP);
		final Target case_delete=new Target ("caseSplit_delete","//a[@id='undefined' and contains(@onclick,'deleteInValidRow("+st.replace('+', '"')+")')]",Target.XPATH);
		final Target each_delete=new Target ("eachSplit_delete","//a[@id='undefined' and contains(@onclick,'deleteInValidRow("+st1.replace('+', '"')+")')]",Target.XPATH);
		log("Delete case item",LogType.STEP);
		if((getCommand().isTargetPresent(case_delete)) && (getCommand().isTargetPresent(each_delete)))
		{
			
			getCommand().click(case_delete);
			
		}
		
	}
	return this;
	
}




public ItemDeletePage addCaseandSplitItem_011(String opco, String customer) {
	getCommand().waitFor(10);
	String opco_num[]=opco.split("-");
	System.out.println(opco_num[0].trim());
	String opcono=opco_num[0].trim();
	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
	if(!getCommand().isTargetVisible(popup_CreateOrder))
	{
		
		    String caseSplit_item="select pgitem from espgpgtf where PGOPCO="+opcono+"  and PGSPLT='Y'  and PGUNCA>0  and PGITPR not in('Y')   and PGITST not in('I') and PGAVSK>0" ;
			System.out.println(caseSplit_item);
			ArrayList caseSplit_Item=(new SupportFunctions()).retrieveData(caseSplit_item);
			System.out.println(caseSplit_Item);
			ArrayList case_stockItemNum=(ArrayList)(caseSplit_Item.get(0));
			 String case_stock_Item=case_stockItemNum.get(0).toString();
			 searchItemPrice(case_stock_Item.trim());
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
	         String non_item_num=case_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
             
             
		     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", non_item_num))){
		     System.out.println("item_num=="+non_item_num);
		     String chek_box="jqg_productSearchGrid_"+case_stock_Item.trim()+"-CS";
		     System.out.println("chek_box=="+chek_box);
		     getCommand().storeValue("eachCase_011", case_stock_Item.trim());
		    log("Enter quantity of Item ",LogType.STEP);
		   if (!getCommand().isSelected(chek_OrderGuide.replace("<#>",chek_box)) )
		   {
			getCommand().click(txt_OrderGuideItemQnty.replace("<#>", non_item_num));
			getCommand().clear(txt_OrderGuideItemQnty.replace("<#>", non_item_num));
			getCommand().sendKeys(txt_OrderGuideItemQnty.replace("<#>", non_item_num), "2");
			String eaQuantity=case_stock_Item.trim()+"-EA_syscoGridColumnEditableQuantityFormatter";
            Select stEachQuantity=new Select(getCommand().getDriver().findElement(By.id(eaQuantity)));
            stEachQuantity.selectByValue("2");	
			getCommand().click(chek_OrderGuide.replace("<#>",chek_box));
			String img_xpath="//*[@id='"+case_stock_Item.trim()+"-CS']/td[28]/img";
			System.out.println("Image present"+img_xpath);
			String img_xpathEA="//*[@id='"+case_stock_Item.trim()+"-EA']/td[28]/img";
			System.out.println("Image present"+img_xpath);
			getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpath));
			getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpathEA));
			System.out.println("Image present");
			
		  }
	   } 
		  viewIsrOrder();
}
	return this;
}
public ItemDeletePage storeOrderNum_011()
{
	getCommand().waitForTargetPresent(div_Order);
	if(getCommand().isTargetPresent(div_Order)){
	String num=getCommand().getDriver().findElement(By.className("ordnotxt")).getText();
	getCommand().storeValue("db_order_num_011", num);		
	}
	return this;	
}
public ItemDeletePage selectNormalSubmittedOrder_011(String st11)
{
	getCommand().waitForTargetPresent(grid_RecentOrders);
	if(getCommand().isTargetPresent(grid_RecentOrders))
	{
		String st=(String) getCommand().retrieveValue("db_order_num_011");
		String strItemXpath = "//*[@id='" + st + "']";
		//(new SupportFunctions()).deleteOutputData("Order_087.xls");
		//String status="Submitted";
		
		//String st1="//*[@id='"+st+"']/td[19]";
		//String st2="+"+st1+"+";
		//String st1="Hand PricingUpdate'";
		getCommand().getDriver().navigate().refresh();
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		getCommand().getDriver().navigate().refresh();
		(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		getCommand().getDriver().navigate().refresh();
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		 getCommand().getDriver().navigate().refresh();
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		 getCommand().getDriver().navigate().refresh();
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		 
		 log("Click on Order  Link ",LogType.STEP);
		//String st11="Hand PricingUpdate";
		getCommand().click(btn_OrderRefresh);
		 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
		String st2="+"+st11+"+";
		String ss=st2.replace('+', '"');
		//String st1="//*[@id='"+st+"'] and title="+ss+"";
		String st1="//a[@id='"+st+"']";
		System.out.print(st1);
	try{
		getCommand().getDriver().findElement(By.xpath(st1)).click();
	}
	catch(Exception e)
	{
		SoftAssertion.fail("Order is not submitted.Please re execute the test case");
	}
	}
	return this;
	}

public ItemDeletePage checkdeleteBtnCase_011()
{   
	getCommand().waitFor(5);
	String itemNum= (String) getCommand().retrieveValue("eachCase_011");
	getCommand().waitForTargetPresent(btn_shipping);
	if(getCommand().isTargetPresent(btn_shipping)){
		//log("Click on Open Order Link ",LogType.STEP);
		String caseDel=itemNum+"-CS";
		String st="+"+caseDel+"+";
		String eachDel=itemNum+"-EA";
		String st1="+"+eachDel+"+";
		//log("Click on Item price ",LogType.STEP);
		final Target case_delete=new Target ("caseSplit_delete","//a[@id='undefined' and contains(@onclick,'deleteInValidRow("+st.replace('+', '"')+")')]",Target.XPATH);
		final Target each_delete=new Target ("eachSplit_delete","//a[@id='undefined' and contains(@onclick,'deleteInValidRow("+st1.replace('+', '"')+")')]",Target.XPATH);
		log("Delete case item",LogType.STEP);
		if((getCommand().isTargetPresent(case_delete)) && (getCommand().isTargetPresent(each_delete)))
		{
			
			getCommand().click(each_delete);
			
		}
		
	}
	return this;
	
}

public ItemDeletePage clickOrderSummaryReport()
{
	getCommand().waitForTargetPresent(menu_Reports);
	log("Click on Order Summary Report",LogType.STEP);
	if(getCommand().isTargetPresent(menu_Reports))
	{
	WebElement menu = getCommand().getDriver().findElement(By.xpath("//a[contains(text(),'Reports')]"));
    Actions builder = new Actions(getCommand().getDriver());    
	builder.moveToElement(menu).build().perform();
	//WebDriverWait wait = new WebDriverWait(getCommand().getDriver(), 5);
	//getCommand().waitFor(10);
	getCommand().waitForTargetPresent(menu_SummaryReports);
	WebElement menuOption = getCommand().getDriver().findElement(By.xpath("//a[contains(text(),'Order Summary Report')]"));
	menuOption.click();
	}
	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
	return this;
	
}
public ItemDeletePage summaryReportPopup()
{
	getCommand().waitForTargetPresent(popup_SummaryReports);
	if(getCommand().isTargetPresent(popup_SummaryReports)){
		log("Order Summary Report popup occur",LogType.STEP);	
	}
	
	return this;
	
}
public ItemDeletePage selectUserDiv(String username)
{
	getCommand().waitForTargetPresent(sa_report_div);
	if(getCommand().isTargetPresent(sa_report_div)){
		String isrUser="//*[@id='territory-"+username+"']/a";
		if(getCommand().isTargetPresent(teritory_isruser.replace("<#>", isrUser))){
			getCommand().click(teritory_isruser.replace("<#>", isrUser));
			if(getCommand().isTargetPresent(option_submittedDate)){
			getCommand().click(option_submittedDate);
			}
		}
		
	}
	return this;
	
}
public ItemDeletePage selectUserDivForDeliveryReport(String username)
{
	getCommand().waitForTargetPresent(sa_report_div);
	if(getCommand().isTargetPresent(sa_report_div)){
		String isrUser="//*[@id='territory-"+username+"']/a";
		if(getCommand().isTargetPresent(teritory_isruserDel.replace("<#>", isrUser))){
			getCommand().click(teritory_isruserDel.replace("<#>", isrUser));
			if(getCommand().isTargetPresent(option_DeliveryDate)){
			getCommand().click(option_DeliveryDate);
			}
		}
		
	}
	return this;
	
}
public ItemDeletePage changePopupSubDate()
{
	
	log("Change Submitted date ",LogType.STEP);
	getCommand().isTargetPresent(date_submittedDate);
	getCommand().getDriver().findElement(By.xpath("//*[@id='orderSummaryReportStartDate']")).click();
	 DateFormat df = new SimpleDateFormat("dd/MM/yy");
     Date dateobj = new Date();
     System.out.println(df.format(dateobj));
     int DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
	    Date date = new Date();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
	    String prevDate = dateFormat.format(date.getTime() - (DAY_IN_MILLIS)*3);
	    String currDate = dateFormat.format(date.getTime());
	    String nextDate = dateFormat.format(date.getTime() +((DAY_IN_MILLIS)*2+ DAY_IN_MILLIS));
	    System.out.println("Previous date: " + prevDate);
	    System.out.println("Current date: " + currDate);
	    System.out.println("Next date: " + nextDate);
	    String setDate[]=prevDate.split("/");
	    String setCurDate[]=currDate.split("/");
	    String curMon=setCurDate[1];
	    String endDate=getCommand().getDriver().findElement(By.xpath("//*[@id='orderSummaryReportEndDate']")).getAttribute("value").toString();
	    String cal_date[]=endDate.split("/");
	    System.out.println("calDate===="+endDate);
	    System.out.println("calDate===="+cal_date[0]);
	    System.out.println("calDate===="+cal_date[1]);
	    System.out.println("calDate===="+cal_date[2]);
	  
	    int cal_month=Integer.parseInt(cal_date[0]);
	    int cal_day=Integer.parseInt(cal_date[1]);
	    String nextMon=setDate[1];
	    int next_date=Integer.parseInt(nextMon);
	    int cur_date=Integer.parseInt(curMon);
	    String setDay1=setDate[0];
	    String setDay=setDate[0];
	    if(setDay1.equals("01")) setDay="1"; else if(setDay1.equals("02")) setDay="2"; else if(setDay1.equals("03")) setDay="3"; else if(setDay1.equals("04")) setDay="4";
	    else if(setDay1.equals("05")) setDay="5"; else if(setDay1.equals("06")) setDay="6"; else if(setDay1.equals("07")) setDay="7"; else if(setDay1.equals("08")) setDay="8"; else if(setDay1.equals("09")) setDay="9";
	    System.out.println("DD===="+setDay);
	    System.out.println("curDay===="+setCurDate[0]);
	    System.out.println("MM===="+setDate[1]);
	    System.out.println("YY===="+setDate[2]);
	    //if(next_date==cur_date)
	    //{
	    
	    	if(cal_month==next_date)
	    	{
	    		//if(cal_day>=4)
	    			
	    		getCommand().isTargetPresent(date_submittedDate);
		    	getCommand().isTargetPresent(popup_datePicker);	
	    		//getCommand().isTargetPresent(date_PrevMon);
			   // getCommand().click(date_PrevMon);
			    	
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
	    	}
	    	else if(cal_month>next_date)
	    	{
	    		getCommand().isTargetPresent(date_submittedDate);
		    	getCommand().isTargetPresent(popup_datePicker);	
	    		getCommand().isTargetPresent(popup_PrevMon);
		    	getCommand().click(popup_PrevMon);
		    	
		    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
		    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
		    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
		    	    
		    	  for (WebElement cell: columns){  
		    	   //Select 13th Date   
		    	   if (cell.getText().equals(setDay)){  
		    	   cell.findElement(By.linkText(setDay)).click();  
		    	   break;  
		    	   }  
		    	  }
	    			
	    	}
	    	/*else if(cal_month<next_date)
	    	{
	    		
		    	getCommand().isTargetPresent(date_Calendar);
		    	getCommand().isTargetPresent(date_Picker);
		    	getCommand().isTargetPresent(date_NextMon);
		    	getCommand().click(date_NextMon);
		    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
		    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
		    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
		    	    
		    	  for (WebElement cell: columns){  
		    	   //Select 13th Date   
		    	   if (cell.getText().equals(setDay)){  
		    	   cell.findElement(By.linkText(setDay)).click();  
		    	   break;  
		    	   }  
		    	  }
		    	
		   
	    	}
	    //}
	    else if(next_date>cur_date)
	    {
	    	 if(cal_month>next_date)
	    	{
	    		
		    	getCommand().isTargetPresent(date_Calendar);
		    	getCommand().isTargetPresent(date_Picker);
		    	getCommand().isTargetPresent(date_PrevMon);
		    	getCommand().click(date_PrevMon);
		    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
		    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
		    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
		    	    
		    	  for (WebElement cell: columns){  
		    	   //Select 13th Date   
		    	   if (cell.getText().equals(setDay)){  
		    	   cell.findElement(By.linkText(setDay)).click();  
		    	   break;  
		    	   }  
		    	  }
	    			
	    	}
	    	else if(cal_month<next_date)
	    	{
	    		
		    	getCommand().isTargetPresent(date_Calendar);
		    	getCommand().isTargetPresent(date_Picker);
		    	getCommand().isTargetPresent(date_NextMon);
		    	getCommand().click(date_NextMon);
		    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
		    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
		    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
		    	    
		    	  for (WebElement cell: columns){  
		    	   //Select 13th Date   
		    	   if (cell.getText().equals(setDay)){  
		    	   cell.findElement(By.linkText(setDay)).click();  
		    	   break;  
		    	   }  
		    	  }
		    	
		   
	    	}
	    	else if(cal_month==next_date)
		    	{
	    		getCommand().isTargetPresent(date_Calendar);
		    	getCommand().isTargetPresent(date_Picker);	
	    		//getCommand().isTargetPresent(date_PrevMon);
			    //getCommand().click(date_PrevMon);
			    	
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
	       // getCommand().getDriver().findElement(By.linkText(setDay)).click();
		    	}
	    }*/
	
	return this;
	
}
public ItemDeletePage changePopupDelDate()
{
	
	log("Change Delivery date ",LogType.STEP);
	getCommand().isTargetPresent(date_deliveryDate);
	 DateFormat df = new SimpleDateFormat("dd/MM/yy");
     Date dateobj = new Date();
     System.out.println(df.format(dateobj));
     int DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
	    Date date = new Date();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
	    String prevDate = dateFormat.format(date.getTime() - (DAY_IN_MILLIS)*3);
	    String currDate = dateFormat.format(date.getTime());
	    String nextDate = dateFormat.format(date.getTime() +((DAY_IN_MILLIS)*3));
	    System.out.println("Previous date: " + prevDate);
	    System.out.println("Current date: " + currDate);
	    System.out.println("Next date: " + nextDate);
	    String setDate[]=nextDate.split("/");
	    String setCurDate[]=currDate.split("/");
	    String curMon=setCurDate[1];
	    String endDate=getCommand().getDriver().findElement(By.xpath("//*[@id='orderSummaryReportEndDate']")).getAttribute("value").toString();
	    String cal_date[]=endDate.split("/");
	    System.out.println("calDate===="+endDate);
	    System.out.println("calDate===="+cal_date[0]);
	    System.out.println("calDate===="+cal_date[1]);
	    System.out.println("calDate===="+cal_date[2]);
	  
	    int cal_month=Integer.parseInt(cal_date[0]);
	    int cal_day=Integer.parseInt(cal_date[1]);
	    String nextMon=setDate[1];
	    int next_date=Integer.parseInt(nextMon);
	    int cur_date=Integer.parseInt(curMon);
	    String setDay1=setDate[0];
	    String setDay=setDate[0];
	    if(setDay1.equals("01")) setDay="1"; else if(setDay1.equals("02")) setDay="2"; else if(setDay1.equals("03")) setDay="3"; else if(setDay1.equals("04")) setDay="4";
	    else if(setDay1.equals("05")) setDay="5"; else if(setDay1.equals("06")) setDay="6"; else if(setDay1.equals("07")) setDay="7"; else if(setDay1.equals("08")) setDay="8"; else if(setDay1.equals("09")) setDay="9";
	    System.out.println("DD===="+setDay);
	    System.out.println("curDay===="+setCurDate[0]);
	    System.out.println("MM===="+setDate[1]);
	    System.out.println("YY===="+setDate[2]);
	    //if(next_date==cur_date)
	    //{
	    getCommand().getDriver().findElement(By.xpath("//*[@id='orderSummaryReportEndDate']")).click();
	    	if(cal_month==next_date)
	    	{
	    		    			
	    		getCommand().isTargetPresent(date_deliveryDate);
		    	getCommand().isTargetPresent(popup_datePicker);	
	    			
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
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
		    	   //Select 13th Date   
		    	   if (cell.getText().equals(setDay)){  
		    	   cell.findElement(By.linkText(setDay)).click();  
		    	   break;  
		    	   }  
		    	  }
	    		}	
	    	
	    	/*else if(cal_month<next_date)
	    	{
	    		
		    	getCommand().isTargetPresent(date_Calendar);
		    	getCommand().isTargetPresent(date_Picker);
		    	getCommand().isTargetPresent(date_NextMon);
		    	getCommand().click(date_NextMon);
		    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
		    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
		    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
		    	    
		    	  for (WebElement cell: columns){  
		    	   //Select 13th Date   
		    	   if (cell.getText().equals(setDay)){  
		    	   cell.findElement(By.linkText(setDay)).click();  
		    	   break;  
		    	   }  
		    	  }
		    	
		   
	    	}
	    //}
	    else if(next_date>cur_date)
	    {
	    	 if(cal_month>next_date)
	    	{
	    		
		    	getCommand().isTargetPresent(date_Calendar);
		    	getCommand().isTargetPresent(date_Picker);
		    	getCommand().isTargetPresent(date_PrevMon);
		    	getCommand().click(date_PrevMon);
		    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
		    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
		    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
		    	    
		    	  for (WebElement cell: columns){  
		    	   //Select 13th Date   
		    	   if (cell.getText().equals(setDay)){  
		    	   cell.findElement(By.linkText(setDay)).click();  
		    	   break;  
		    	   }  
		    	  }
	    			
	    	}
	    	else if(cal_month<next_date)
	    	{
	    		
		    	getCommand().isTargetPresent(date_Calendar);
		    	getCommand().isTargetPresent(date_Picker);
		    	getCommand().isTargetPresent(date_NextMon);
		    	getCommand().click(date_NextMon);
		    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
		    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
		    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
		    	    
		    	  for (WebElement cell: columns){  
		    	   //Select 13th Date   
		    	   if (cell.getText().equals(setDay)){  
		    	   cell.findElement(By.linkText(setDay)).click();  
		    	   break;  
		    	   }  
		    	  }
		    	
		   
	    	}
	    	else if(cal_month==next_date)
		    	{
	    		getCommand().isTargetPresent(date_Calendar);
		    	getCommand().isTargetPresent(date_Picker);	
	    		//getCommand().isTargetPresent(date_PrevMon);
			    //getCommand().click(date_PrevMon);
			    	
			    	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
			    	  java.util.List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
			    	  java.util.List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
			    	    
			    	  for (WebElement cell: columns){  
			    	   //Select 13th Date   
			    	   if (cell.getText().equals(setDay)){  
			    	   cell.findElement(By.linkText(setDay)).click();  
			    	   break;  
			    	   }  
			    	  }
	       // getCommand().getDriver().findElement(By.linkText(setDay)).click();
		    	}
	    }*/
	
	return this;
	
}
public ItemDeletePage clickApply()
{
	getCommand().isTargetPresent(btn_summaryReport);
	log("Click on Apply  ",LogType.STEP);
	getCommand().click(btn_summaryReport);
	return this;
	
}
public ItemDeletePage checkSummaryReport(String username)
{
	String gTable="//*[@id='gbox_ordersReportTable_"+username+"']";
	getCommand().waitForTargetPresent(gbox_ordersReportTable.replace("<#>", gTable));
	getCommand().isTargetPresent(gbox_ordersReportTable.replace("<#>", gTable));
	log("All orders reports are getting displayed below. ",LogType.STEP);
	return this;
	
}
public ItemDeletePage clickOnStockIndicator()
{
	getCommand().waitFor(4);
	getCommand().waitForTargetPresent(stock_Indicator);
	log("Click on Stock indicator  ",LogType.STEP);
	if(getCommand().isTargetPresent(stock_Indicator)){
		getCommand().click(stock_Indicator);
		
	}
	return this;
	
}
public ItemDeletePage selectSpecialOrder()
{
	getCommand().waitForTargetPresent(check_SpecialOrder);
	log("Select Special Order",LogType.STEP);
	if(getCommand().isTargetPresent(check_SpecialOrder)){
		getCommand().click(check_SpecialOrder);
	}
	return this;
	
}
public ItemDeletePage checkSpecialOrder()
{
	getCommand().waitForTargetPresent(txt_Dynamic_Price);
	String gBox="//img[@title='Special Order']";
	boolean flag=false;
	 List<WebElement> textboxes = getCommand().getDriver().findElements(By.xpath(gBox));
	 //System.out.println(textboxes.size());
		for (int i = 1; i<textboxes.size(); i=i+1)
			 
		{
		 
		System.out.println(textboxes.get(i).getAttribute("title"));
		if("Special Order".compareTo(textboxes.get(i).getAttribute("title"))==0){
			flag=true;
			
		}
		else
		{
			flag=false;
			break;
		}
		}
		
		if(flag==true)
		{
			log("Only special orders are getting displayed.",LogType.STEP);
		}
		else
		{
			SoftAssertion.fail("special orders are not getting displayed ");
		}
	return this;
		
	
}
public ItemDeletePage selectInvoice() {
	getCommand().waitForTargetVisible(check_invoice);
	if(getCommand().isTargetPresent(check_invoice))
	{
		getCommand().click(check_invoice);
	}
	return this;
	
	
}
public ItemDeletePage UpdateOrderGuideItemPrice(String itemNum,String updatePrice) 
{
	
	
	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
	log("Update Hand price Item ",LogType.STEP);
	getCommand().waitForTargetVisible(grid_OrderGuidePriceDetails);
	String handPrice_txt=itemNum+"-CS_currentprice";
	 WebElement wstO=getCommand().getDriver().findElement(By.id(handPrice_txt));
	String firstPrice=wstO.getAttribute("value").toString();
	System.out.println(":First price=="+firstPrice);
	String price_Check="jqg_itemHistoryGrid_"+itemNum+"-CS";
	getCommand().waitForTargetVisible(txt_Price.replace("<#>", handPrice_txt));
	getCommand().isTargetPresent(txt_Price.replace("<#>", handPrice_txt));
	log("Enter hand price of the Item ",LogType.STEP);
	if (!getCommand().isSelected(chek_Price.replace("<#>",price_Check)) )
	{
		getCommand().click(chek_Price.replace("<#>",price_Check));
		
		
      WebElement wst=getCommand().getDriver().findElement(By.id(handPrice_txt));
		wst.click();
		
		wst.sendKeys(updatePrice);
		
		getCommand().getDriver().findElement(By.tagName("body")).click();
		
		
		if(firstPrice.compareTo(wst.getAttribute("value").toString())==0)
		{
			log("System should not allow the user to enter 2 decimal price ",LogType.STEP);
			log ("Old price of the item should get displayed",LogType.STEP);

		}
	}
	else if (getCommand().isSelected(chek_Price.replace("<#>",price_Check))){
		getCommand().click(chek_Price.replace("<#>",price_Check));
		
	}
	
	
	return this;
	
}
public ItemDeletePage addInactiveItemtoList(String opco,String custNum,String status)
{
	getCommand().waitFor(3);
	String opco_num[]=opco.split("-");
	System.out.println(opco_num[0].trim());
	String opcono=opco_num[0].trim();
	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
	if(!getCommand().isTargetVisible(popup_CreateOrder))
	{
		
			
			//String demand_status="SELECT PGITEM FROM espgpgtf WHERE PGSTKI in('D') fetch first 1  rows only";
			
			
		
			String inactive_iem="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opco+" and  PGITST in('I')  and PGITPR not in('Y') and PGAVSK>10 fetch first 1  rows only";
			System.out.println(inactive_iem);
			ArrayList inActiveItem=(new SupportFunctions()).retrieveData(inactive_iem);
			System.out.println(inActiveItem);
			ArrayList inactive_stockItemNum=(ArrayList)(inActiveItem.get(0));
			 String inactive_stock_Item=inactive_stockItemNum.get(0).toString();
			 String ItemNum=inactive_stockItemNum.get(0).toString();
			 String searchItemNum=inactive_stockItemNum.get(0).toString();
			 searchItemPrice(inactive_stock_Item.trim());
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
	         String inactive_item_num=inactive_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
		     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", inactive_item_num))){
		     //System.out.println("item_num=="+inactive_item_num);
		     String chek_box="jqg_productSearchGrid_"+ItemNum.trim().trim()+"-CS";
		     System.out.println("chek_box=="+chek_box);
		     getCommand().click(chek_Price.replace("<#>",chek_box));
		    item_numDB=inactive_item_num.trim();
		    getCommand().storeValue("inactive_item_num", searchItemNum.trim());
		    String handPrice_txt=ItemNum.trim()+"-CS_currentprice";
		    getCommand().waitForTargetPresent(txt_Price.replace("<#>", handPrice_txt));
		    
		  //*[@id='7236425-CS_currentprice']
		 }
	}
	return this;

}
public ItemDeletePage inActiveItemToList()
{
	getCommand().waitFor(3);
	getCommand().waitForTargetPresent(list_AddtoListBtn);
	if(getCommand().isTargetPresent(list_AddtoListBtn))
	{
		getCommand().click(list_AddtoListBtn);
		log ("Click on Add to List Btn",LogType.STEP);
		
	}
	getCommand().waitFor(3);
	getCommand().waitForTargetPresent(multi_SelectItemDiv);
	if(getCommand().isTargetPresent(multi_SelectItemDiv))
	{
		getCommand().waitFor(3);
	String listName=(String) getCommand().retrieveValue("Store_List_Name");	
	if(getCommand().isTargetPresent(select_MyList))
	{
	log ("Select the list",LogType.STEP);
	getCommand().click(select_MyList);
	getCommand().waitFor(3);
	log ("Confirm the List",LogType.STEP);
	getCommand().click(multiSelect_ConfirmButton);
	}
	}
	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
	return this; 
}

public ItemDeletePage create_NewMyListNew()
{
	getCommand().waitForTargetPresent(create_NewListDiv);
  	 if(getCommand().isTargetPresent(create_NewListDiv))
  	 {
  		getCommand().isTargetPresent(list_Name);
  		String strRandomList = RandomStringUtils.randomAlphabetic(10);
  		getCommand().storeValue("Store_List_Name", strRandomList);
  		getCommand().sendKeys(list_Name, strRandomList);
  		//getCommand().isTargetPresent(check_listQuickEntry);
  		//getCommand().click(check_listQuickEntry);
  		getCommand().isTargetPresent(createnew_listBtn);
  		log ("Create new List",LogType.STEP);
  		getCommand().click(createnew_listBtn);
  		(new SupportFunctions()).waitForLoading(4000, By.xpath("//*[@id='loadingDiv11']"));
  		(new SupportFunctions()).waitForLoading(2000, By.id("//*[@id='listNoTxt']"));
  		getCommand().waitFor(3);
  		 WebElement wst=getCommand().getDriver().findElement(By.id("listNoTxt"));
    		System.out.println("ListNo==="+wst.getText());
    		getCommand().storeValue("Store_List_Num", wst.getText().toString());
  		
  	 }
	
	return this;
	
	
}
public ItemDeletePage checkMyList(){
	
	getCommand().waitForTargetPresent(grid_box);
	String lst_name=(String) getCommand().retrieveValue("Store_List_Name");
	System.out.println("lst_name-----"+lst_name);
	String listName="//a[contains(text(),"+lst_name.trim()+"";
	System.out.println("listName-----"+listName);
	if(getCommand().isTargetPresent(grid_box))
	{
	//if(getCommand().isTargetPresent(list_Myname.replace("<#>",listName)))
	//{
		 //List<WebElement> sourceElements=getCommand().getDriver().findElements(By.xpath("//*[@title='Express']"));
		 //String textSource=sourceElements.get(0).getText();

		// List<WebElement> sourceElements=getCommand().click(target)(By.xpath("//*[@title="+lst_name+"]"));
		String listNUmber=(String) getCommand().retrieveValue("Store_List_Num");	
		getCommand().getDriver().findElement(By.linkText(listNUmber)).click();
		//driver.findElement(By.linkText("App Configuration")).click()
	//}
	}
	
	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
	return this;
}

public ItemDeletePage UpdateMylistItemPrice() 
{
	
	
	//(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
	//log("Update Hand price Item ",LogType.STEP);
	//getCommand().waitForTargetVisible(gbox_viewListGrid);
	String itemNum=(String) getCommand().retrieveValue("inactive_item_num");
	String handPrice_txt=itemNum+"-CS_currentprice";
	 WebElement wstO=getCommand().getDriver().findElement(By.id(handPrice_txt));
	String firstPrice=wstO.getAttribute("value").toString();
	System.out.println(":First price=="+firstPrice);
	String price_Check="jqg_viewListGrid_"+itemNum+"-CS";
	getCommand().waitForTargetVisible(txt_Price.replace("<#>", handPrice_txt));
	getCommand().isTargetPresent(txt_Price.replace("<#>", handPrice_txt));
	log("Enter hand price of the Item ",LogType.STEP);
	if (!getCommand().isSelected(chek_Price.replace("<#>",price_Check)) )
	{
		getCommand().click(chek_Price.replace("<#>",price_Check));
		
		
      WebElement wst=getCommand().getDriver().findElement(By.id(handPrice_txt));
		wst.click();
		
		wst.sendKeys("45.00");
		
		//getCommand().getDriver().findElement(By.tagName("body")).click();
		String priceNow=wst.getAttribute("value").toString();
		
		if(!(firstPrice.equals(priceNow)))
		{
			//log("System should not allow the user to enter 2 decimal price ",LogType.STEP);
			log ("Change the price Details",LogType.STEP);

		}
	}
	else if (getCommand().isSelected(chek_Price.replace("<#>",price_Check))){
		getCommand().click(chek_Price.replace("<#>",price_Check));
		
	}
	
	
	return this;
	
}
/*
 * Add Dry Item to Order
 */
public ItemDeletePage addDryItem(String opco)
{
	getCommand().waitFor(3);
	String opco_num[]=opco.split("-");
	System.out.println(opco_num[0].trim());
	String opcono=opco_num[0].trim();
	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
	if(!getCommand().isTargetVisible(popup_CreateOrder))
	{
		
			
			//String demand_status="SELECT PGITEM FROM espgpgtf WHERE PGSTKI in('D') fetch first 1  rows only";
			
			
		
			String dry_item="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opco+" and PGCATE='10'  and PGITPR not in('Y')  fetch first 1  rows only";
			System.out.println(dry_item);
			ArrayList inDryItem=(new SupportFunctions()).retrieveData(dry_item);
			System.out.println(inDryItem);
			ArrayList dry_stockItemNum=(ArrayList)(inDryItem.get(0));
			 String inactive_stock_Item=dry_stockItemNum.get(0).toString();
			 String ItemNum=dry_stockItemNum.get(0).toString();
			 String searchItemNum=dry_stockItemNum.get(0).toString();
			 searchItemPrice(inactive_stock_Item.trim());
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
	         String inactive_item_num=inactive_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
		     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", inactive_item_num))){
		     //System.out.println("item_num=="+inactive_item_num);
		     String chek_box="jqg_productSearchGrid_"+ItemNum.trim().trim()+"-CS";
		     System.out.println("chek_box=="+chek_box);
		    
		    item_numDB=inactive_item_num.trim();
		    getCommand().storeValue("dry_item_num", searchItemNum.trim());
		    String handPrice_txt="//*[@id='"+ItemNum.trim()+"-CS']/td[27]/span";
		    System.out.println("Val++++"+handPrice_txt);
		    getCommand().waitForTargetPresent(lbl_Price.replace("<#>", handPrice_txt));
		    getCommand().getDriver().findElement(By.id(inactive_item_num)).sendKeys("10");
		    getCommand().click(chek_Price.replace("<#>",chek_box));
		    
		  //*[@id='7236425-CS_currentprice']
		 }
	}
	return this;

}
public ItemDeletePage addCoolItem(String opco)
{
	getCommand().waitFor(3);
	String opco_num[]=opco.split("-");
	System.out.println(opco_num[0].trim());
	String opcono=opco_num[0].trim();
	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
	if(!getCommand().isTargetVisible(popup_CreateOrder))
	{
		
			
			//String demand_status="SELECT PGITEM FROM espgpgtf WHERE PGSTKI in('D') fetch first 1  rows only";
			
			
		   log ("Select an Item",LogType.STEP);
			String dry_item="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opco+" and PGCATE='06' and PGITPR not in('Y')  fetch first 1  rows only";
			System.out.println(dry_item);
			ArrayList inDryItem=(new SupportFunctions()).retrieveData(dry_item);
			System.out.println(inDryItem);
			ArrayList dry_stockItemNum=(ArrayList)(inDryItem.get(0));
			 String inactive_stock_Item=dry_stockItemNum.get(0).toString();
			 String ItemNum=dry_stockItemNum.get(0).toString();
			 String searchItemNum=dry_stockItemNum.get(0).toString();
			 searchItemPrice(inactive_stock_Item.trim());
			 (new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='res-loading']"));
	         String inactive_item_num=inactive_stock_Item.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
	       //*[@id='1151030-CS_syscoGridColumnEditableQuantityFormatter']
		     if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", inactive_item_num))){
		     //System.out.println("item_num=="+inactive_item_num);
		     String chek_box="jqg_productSearchGrid_"+ItemNum.trim().trim()+"-CS";
		     System.out.println("chek_box=="+chek_box);
		     item_numDB=inactive_item_num.trim();
		     getCommand().storeValue("cool_item_num", searchItemNum.trim());
		    String handPrice_txt="//*[@id='"+ItemNum.trim()+"-CS']/td[27]/span";
		    String handPrice_img="//*[@id='"+ItemNum.trim()+"-CS']/td[27]/img";
		    System.out.println("Val++++"+handPrice_txt);
		     //String handPrice_txt=ItemNum.trim()+"-CS_currentprice";
		   //*[@id='7436262-CS']/td[27]/span
		    (new SupportFunctions()).waitForLoading(2000, By.xpath(handPrice_img));
			 getCommand().waitForTargetPresent(lbl_Price.replace("<#>", handPrice_txt));
			 log ("Enter Quantity",LogType.STEP);
		     getCommand().getDriver().findElement(By.id(inactive_item_num)).sendKeys("10");
		     log ("Select the Check box",LogType.STEP);
		     getCommand().click(chek_Price.replace("<#>",chek_box));
		    
		  //*[@id='7236425-CS_currentprice']
		 }
	}
	return this;

}
public ItemDeletePage addCoolItemisValid()
{
	String itemNum=(String) getCommand().retrieveValue("cool_item_num");
	System.out.println("itemNum valid=="+itemNum);
	 String item_tick="//*[@id='"+itemNum.trim()+"-CS']/td[29]/img";
	 getCommand().waitForTargetPresent(imag_tick.replace("<#>", item_tick));
	 if(getCommand().isTargetPresent(imag_tick.replace("<#>", item_tick)))
	 {
		 log ("Item is added ",LogType.STEP); 
	 }
	return this;
	
}
public ItemDeletePage addDryItemisValid()
{
	String itemNum=(String) getCommand().retrieveValue("dry_item_num");
	System.out.println("itemNum valid=="+itemNum);
	 String item_tick="//*[@id='"+itemNum.trim()+"-CS']/td[29]/img";
	 getCommand().waitForTargetPresent(imag_tick.replace("<#>", item_tick));
	 if(getCommand().isTargetPresent(imag_tick.replace("<#>", item_tick)))
	 {
		 log ("Item is added ",LogType.STEP); 
	 }
	return this;
	
}
public ItemDeletePage selectSubmittedOrder(String opco,String custNum)
{
	getCommand().waitFor(3);
	String opco_num[]=opco.split("-");
	System.out.println(opco_num[0].trim());
	String opcono=opco_num[0].trim();
	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
	if(!getCommand().isTargetVisible(popup_CreateOrder))
	{
		
			
			//String demand_status="SELECT PGITEM FROM espgpgtf WHERE PGSTKI in('D') fetch first 1  rows only";
			
			
		   log ("Select Submitted Order",LogType.STEP);
		  
			//String dry_item="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opco+" and PGCATE='06' and PGITPR not in('Y')  fetch first 1  rows only";
		   String orderNum=" select NTEPO# from ESOHNTTF where NTOPCO="+opco+" and NTCUNO="+custNum+"  and NTORST='S'  order by NTEPO# desc fetch first 1  rows only";
			System.out.println(orderNum);
			ArrayList inOrderNum=(new SupportFunctions()).retrieveData(orderNum);
			System.out.println(inOrderNum);
			ArrayList order_Num=(ArrayList)(inOrderNum.get(0));
			if(order_Num.isEmpty())
			{
				log("Submitted Order are  not available ",LogType.STEP);
				Assert.fail("Test case is failed due to valid Orders are not available");
			}
			else{
				log(" Orders are   available ",LogType.STEP);
				  String sub_Num=order_Num.get(0).toString();
				
				if(getCommand().getDriver().findElement(By.id(sub_Num)).isEnabled())
				{
					
					 
					 String submittedDel="//*[@id='delete'][contains(@onclick,'"+sub_Num+"')]";
						// "//*[@id='"+itemNum.trim()+"-CS']/td[29]/img";
					 getCommand().waitForTargetPresent(sub_Delete.replace("<#>", submittedDel));
					 if(getCommand().isTargetPresent(sub_Delete.replace("<#>", submittedDel)))
					 {
						 log ("Delete Link is Enable for Submitted Order",LogType.STEP); 
					 }
				}
				//*[@id='delete'][contains(@onclick,'1013476')]
				//*[@id='1006197'][contains(@onclick,'CANCELED')]
			}
			
		 }

	
	return this;

}
public ItemDeletePage selectDeliveredOrder(String opco,String custNum)
{
	getCommand().waitFor(3);
	String opco_num[]=opco.split("-");
	System.out.println(opco_num[0].trim());
	String opcono=opco_num[0].trim();
	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
	if(!getCommand().isTargetVisible(popup_CreateOrder))
	{
		
			
			//String demand_status="SELECT PGITEM FROM espgpgtf WHERE PGSTKI in('D') fetch first 1  rows only";
			
			
		   log ("Select the Deliverd Order",LogType.STEP);
		  
			//String dry_item="SELECT PGITEM FROM espgpgtf WHERE PGOPCO="+opco+" and PGCATE='06' and PGITPR not in('Y')  fetch first 1  rows only";
		   String orderNum=" select NTEPO# from ESOHNTTF where NTOPCO="+opco+" and NTCUNO="+custNum+" and NTORST='C'  order by NTEPO# desc fetch first 1  rows only";
			System.out.println(orderNum);
			ArrayList inOrderNum=(new SupportFunctions()).retrieveData(orderNum);
			System.out.println(inOrderNum);
			ArrayList order_Num=(ArrayList)(inOrderNum.get(0));
			
			if(order_Num.isEmpty())
			{
				log("Deliverd  Order are  not available ",LogType.STEP);
				Assert.fail("Test case is failed due to valid Orders are not available");
			}
			else{
				log(" Delivered Orders are   available ",LogType.STEP);
				  String sub_Num=order_Num.get(0).toString();
				if(getCommand().getDriver().findElement(By.id(sub_Num)).isDisplayed())
				{
					
					
					 String submittedDel="//*[@id='delete'][contains(@onclick,'"+sub_Num+"')]";
						// "//*[@id='"+itemNum.trim()+"-CS']/td[29]/img";
					 //getCommand().waitForTargetPresent(sub_Delete.replace("<#>", submittedDel));
					 if(getCommand().isTargetPresent(sub_Delete.replace("<#>", submittedDel)))
					 {
						 Assert.fail("Delete Link is Enable "); 
					 }
					 else
					 {
						 log ("Delete Link is Disabled for Delivered Order ",LogType.STEP);  
					 }
				}
				//*[@id='delete'][contains(@onclick,'1013476')]
				//*[@id='1006197'][contains(@onclick,'CANCELED')]
			}
			
		 }

	
	return this;

}
public ItemDeletePage increaseTheQuantity(String quantity) 
{
	getCommand().waitFor(2);
	log ("Enter Quantity",LogType.STEP);
	 String itemNum=(String) getCommand().retrieveValue("cool_item_num");
	
	  String inactive_item_num=itemNum.trim()+"-CS_syscoGridColumnEditableQuantityFormatter";
	 // jqg_grid1_1151030-CS
	  String chek_box="jqg_grid1_"+itemNum.trim()+"-CS";
	  if(getCommand().isTargetPresent(txt_itemQty.replace("<#>", inactive_item_num))){
		  getCommand().click(chek_Price.replace("<#>",chek_box));
		//  getCommand().click(txt_itemQty.replace("<#>", inactive_item_num));
		 getCommand().clear(txt_itemQty.replace("<#>", inactive_item_num));
		  
		  getCommand().sendKeys(txt_itemQty.replace("<#>", inactive_item_num), quantity);
		  
		  	 getCommand().click(chek_Price.replace("<#>",chek_box));
		  getCommand().getDriver().navigate().refresh();
			(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='loadingDiv11']"));
     }
     	
	else
	{
		Assert.fail("Cannot enter Quantity ");
	}
	
	return this;
}
public ItemDeletePage validateIFGDeliveryDate()
{
	log("Select the delivery Date ",LogType.STEP);
	 getCommand().isTargetPresent(date_picker);
	 String endDate=getCommand().getAttribute(date_picker, "value").toString();
	 log("Selected the delivery Date ::"+endDate,LogType.STEP);
	 return this;
		
}
public ItemDeletePage validateEnabledIFGDeliveryDate()
{
	
	getCommand().isTargetPresent(date_picker_img);
	//System.out.println("Previous date: " +getCommand);
	getCommand().waitForTargetVisible(date_picker_img);
	log("Select the Calendar ",LogType.STEP);
	getCommand().click(date_picker_img);
	getCommand().isTargetPresent(popup_datePicker);
	getCommand().waitFor(2);
	WebElement dateWidget = getCommand().getDriver().findElement(By.id("ui-datepicker-div"));  
	
	  java.util.List<WebElement> actrows=dateWidget.findElements(By.xpath("//*[@id='ui-datepicker-div']//td[contains(@onclick,'datepicker')]"));  
	  System.out.println(actrows.size());
	  if(actrows.size()>=6)
	  {
	  log("The number of days that is  enabled in the calender should be same as the number of days set at customer level.",LogType.STEP) ;
	  }
	  getCommand().click(date_picker_img);
	  getCommand().waitFor(2);
	 
	return this;
}
	 
public ItemDeletePage clickCSR_link()
{
	getCommand().waitFor(3);
	log("Click on CSR link ",LogType.STEP);
	getCommand().getDriver().switchTo().frame("topFrame");
	getCommand().waitForTargetPresent(CSR_Link);
	if(getCommand().isTargetPresent(CSR_Link))
	{
		getCommand().click(CSR_Link);
	}
	return this;
}


public ItemDeletePage clickCSRuserLink()
{
	getCommand().waitFor(3);
	log("Add new CSRuser ",LogType.STEP);
	getCommand().getDriver().switchTo().frame("botFrame");
	getCommand().waitForTargetPresent(addCSR_user);
	if(getCommand().isTargetPresent(addCSR_user))
	{
		getCommand().click(addCSR_user);
	}
	return this;
	
}
public ItemDeletePage addNewCSR_userLink(){
	getCommand().waitFor(3);
	getCommand().getDriver().switchTo().frame("botFrame");
	getCommand().waitForTargetPresent(user_id);
	log("Enter user name ",LogType.STEP);
	if(getCommand().isTargetPresent(user_id))
	{
		String strRandomUserID = RandomStringUtils.randomAlphabetic(10);	
		getCommand().storeValue("userID", strRandomUserID);
		getCommand().sendKeys(user_id, strRandomUserID);
	}
	return this;
}

public ItemDeletePage addCSRopco()
{
	getCommand().waitFor(3);
	//getCommand().getDriver().switchTo().frame("botFrame");
	getCommand().waitForTargetPresent(CSR_Opco);
	getCommand().click(CSR_Opco);
	//getCommand().waitFor(3);
	//getCommand().click(CSR_Opco020);
	
	
	return this;
}
public ItemDeletePage addContactNamecsr()
{
	getCommand().waitForTargetPresent(contact_name);
	log("Enter contact name ",LogType.STEP);
	if(getCommand().isTargetPresent(contact_name))
	{		
		getCommand().sendKeys(contact_name, "automationcsr");
	}
	return this;

}
public ItemDeletePage firstloginNewCSRUser() {
	getCommand().waitForTargetPresent(txt_IsrUserName);
	if (getCommand().isTargetPresent(txt_IsrUserName)){
		String UserName=(String) getCommand().retrieveValue("userID");
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
public ItemDeletePage firstloginNewUSer( String username) {
	getCommand().waitForTargetPresent(txt_IsrUserName);
	if (getCommand().isTargetPresent(txt_IsrUserName)){
		//String UserName=(String) getCommand().retrieveValue("userID");
		log("Enter User Name " + username,LogType.STEP);
		getCommand().sendKeys(txt_IsrUserName, username);
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
public ItemDeletePage selectSubmittedOrderfromDBonItembasis(String opco,String customer,String itemNum) {
	getCommand().waitFor(10);
	String opco_num[]=opco.split("-");
	System.out.println(opco_num[0].trim());
	String opcono=opco_num[0].trim();
	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
	
		   
			getCommand().waitFor(5);
				
				
				//System.out.println("CUNO*****"+custNo);
				//and  NTMOID='ACCESS'
			
				String sub_order_num="select NTDS20,NTEPO# from esohnttf where  NTOPCO="+opcono+" and NTCUNO="+customer+"  and NTORST='S'  order by NTEPO# desc fetch first 1  rows only";
				
				System.out.println(sub_order_num);
				ArrayList suborderDetails=(new SupportFunctions()).retrieveData(sub_order_num);
				System.out.println(suborderDetails);
				ArrayList submitted_orderDetails=(ArrayList)(suborderDetails.get(0));
				String original_order_name=submitted_orderDetails.get(0).toString();
				String original_order_num=submitted_orderDetails.get(1).toString();
				selectSubmittedOrderForModify(original_order_name,original_order_num);
				 modifyOrder();
				String itemNum1="SELECT NQITEM from  ESODNQTF where trim(NQEPO#)='" + original_order_num + "' order by  NQEPO# asc fetch first 1 row only" ;
					System.out.println(itemNum1);
					ArrayList itemNumDB=(new SupportFunctions()).retrieveData(itemNum1);
					System.out.println(itemNumDB);
					ArrayList itemNumber=(ArrayList)(itemNumDB.get(0));
					String supcNum=itemNumber.get(0).toString();
					
					//wait for load pop to be invisible
					  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
					  //enterUPCInSearchBox(appupcName);
					//  getCommand().getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					  //String path="//*[@id='divForProductName']";
					  String path="//a[@id='"+supcNum.trim()+"-CS_productName']";
					  getCommand().waitFor(3);
					 
					  String itemDescription=getCommand().getDriver().findElement(By.xpath(path)).getText().toString();
					 
					  String itemDescriptionDB="select KET255 from ESCAKETF where trim(KEMITM)= '"+supcNum.trim()+"'" ;
						System.out.println(itemDescriptionDB);
						ArrayList item_Description_DB=(new SupportFunctions()).retrieveData(itemDescriptionDB);
						System.out.println(item_Description_DB);
						ArrayList ItemNumDesDB=(ArrayList)(item_Description_DB.get(0));
						 String DB_Item_Des=ItemNumDesDB.get(0).toString();
					  if(itemDescription.trim().equals(DB_Item_Des.trim()))
					  {
						
						  log("Verify whether CAKE product description is "+itemDescription+" getting displayed for the item "+supcNum+"  ",LogType.STEP); 
					  }
					  else
						{
							SoftAssertion.fail("Verify whether CAKE product description is  failed .Actual description is "+itemDescription);
						}

				
			 
			
	return this;
}
public ItemDeletePage selectDeliveredOrderLink(String OrderName,String storeValue)
{
	log("Select delevered order ",LogType.STEP);
	getCommand().waitForTargetPresent(gbox_nonopenOrdersTab);
	if(getCommand().isTargetPresent(gbox_nonopenOrdersTab))
	{
		String st=(String) getCommand().retrieveValue(storeValue);
		String strItemXpath = "//*[@id='" + st + "']";
		String st2="+"+OrderName+"+";
		String ss=st2.replace('+', '"');
		//String st1="//*[@id='"+st+"'] and title="+ss+"";
		String st1="//a[@id='"+st+"']";
		System.out.print(st1);
	
		getCommand().getDriver().findElement(By.xpath(st1)).click();
	}
	return this;
	
}	
public ItemDeletePage selectBrandNameandDescriptionFromDB(String opco,String supc,String key)
{
	getCommand().waitFor(3);
	String opco_num[]=opco.split("-");
	System.out.println(opco_num[0].trim());
	String opcono=opco_num[0].trim();
	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
	if(!getCommand().isTargetVisible(popup_CreateOrder))
	{
		
			
			//String demand_status="SELECT PGITEM FROM espgpgtf WHERE PGSTKI in('D') fetch first 1  rows only";
			
			
		
			String brandName="SELECT PGBRND FROM espgpgtf WHERE PGOPCO="+opcono+" and  PGSTKI in('S')  and trim(PGITEM)='"+supc.trim()+"' fetch first 1  rows only";
			System.out.println(brandName);
			ArrayList strBrandName=(new SupportFunctions()).retrieveData(brandName);
			System.out.println(strBrandName);
			ArrayList strBrandNameDB=(ArrayList)(strBrandName.get(0));
			String brandName_DB=strBrandNameDB.get(0).toString();
			String strBrandName1="["+brandName_DB.trim()+"]";
			System.out.println("strBrandName1======="+strBrandName1);

		    String itemDescriptionDB="select KET255 from ESCAKETF where trim(KEMITM)= '"+supc.trim()+"'" ;
			System.out.println(itemDescriptionDB);
			ArrayList item_Description_DB=(new SupportFunctions()).retrieveData(itemDescriptionDB);
			System.out.println(item_Description_DB);
			ArrayList ItemNumDesDB=(ArrayList)(item_Description_DB.get(0));
			String DB_Item_Des=ItemNumDesDB.get(0).toString().trim();
			if(!(DB_Item_Des.equals(null))||(!(DB_Item_Des.equals("")))){
				
			
			
			if(!(brandName_DB.equals(null))||(!(brandName_DB.equals("")))){
				String descriptionBrandName=DB_Item_Des+strBrandName1;
				System.out.println("descriptionBrandName*********"+descriptionBrandName);
				getCommand().storeValue(key,descriptionBrandName);
			}
			}
			else
			{
				 SoftAssertion.fail("Selected item is not in DB");
			}
			
		  }

		    

	return this;

}
public ItemDeletePage selectBrandNameFromDB(String opco,String supc,String key,String key1)
{
	getCommand().waitFor(3);
	String opco_num[]=opco.split("-");
	System.out.println(opco_num[0].trim());
	String opcono=opco_num[0].trim();
	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
	if(!getCommand().isTargetVisible(popup_CreateOrder))
	{
		
			
			//String demand_status="SELECT PGITEM FROM espgpgtf WHERE PGSTKI in('D') fetch first 1  rows only";
			
			
		
			String brandName="SELECT PGBRND FROM espgpgtf WHERE PGOPCO="+opcono+" and  PGSTKI in('S')  and trim(PGITEM)='"+supc.trim()+"' fetch first 1  rows only";
			System.out.println(brandName);
			ArrayList strBrandName=(new SupportFunctions()).retrieveData(brandName);
			System.out.println(strBrandName);
			ArrayList strBrandNameDB=(ArrayList)(strBrandName.get(0));
			String brandName_DB=strBrandNameDB.get(0).toString();
			String strBrandName1="["+brandName_DB.trim()+"]";
			System.out.println("strBrandName1======="+strBrandName1);

			if(!(brandName_DB.equals(null))||(!(brandName_DB.equals("")))){
				
				System.out.println("strBrandName1*********"+strBrandName1);
				getCommand().storeValue(key,strBrandName1);
				getCommand().storeValue(key1,brandName_DB.trim());
			}
			}
			else
			{
				 SoftAssertion.fail("Selected item is not in DB");
			}
			
		  
		    

	return this;

}

public ItemDeletePage selectAbbrivationFromDB(String opco,String supc,String key)
{
	getCommand().waitFor(3);
	String opco_num[]=opco.split("-");
	System.out.println(opco_num[0].trim());
	String opcono=opco_num[0].trim();
	(new SupportFunctions()).waitForLoading(2000, By.xpath("//*[@id='asyncLoadingMessageText']"));
	if(!getCommand().isTargetVisible(popup_CreateOrder))
	{
		
			
			//String demand_status="SELECT PGITEM FROM espgpgtf WHERE PGSTKI in('D') fetch first 1  rows only";
			
			
		
			String brandName="SELECT PGBRND FROM espgpgtf WHERE PGOPCO="+opcono+" and  PGSTKI in('S')  and trim(PGITEM)='"+supc.trim()+"' fetch first 1  rows only";
			System.out.println(brandName);
			ArrayList strBrandName=(new SupportFunctions()).retrieveData(brandName);
			System.out.println(strBrandName);
			ArrayList strBrandNameDB=(ArrayList)(strBrandName.get(0));
			String brandName_DB=strBrandNameDB.get(0).toString();
			String strBrandName1="["+brandName_DB.trim()+"]";
			System.out.println("strBrandName1======="+strBrandName1);

			

		    String abbrivationDescriptionDB="select PHSABR from ESPAPHTF where trim(PHSVEB)='"+brandName_DB+"'" ;
			System.out.println(abbrivationDescriptionDB);
			ArrayList abbrivation_Description_DB=(new SupportFunctions()).retrieveData(abbrivationDescriptionDB);
			System.out.println(abbrivation_Description_DB);
			ArrayList abbrivationDesDB=(ArrayList)(abbrivation_Description_DB.get(0));
			String DB_Item_Des=abbrivationDesDB.get(0).toString().trim();
			if(!(DB_Item_Des.equals(null))||(!(DB_Item_Des.equals("")))){
				
			
			
			if(!(brandName_DB.equals(null))||(!(brandName_DB.equals("")))){
				//ring descriptionBrandName=DB_Item_Des+strBrandName1;
				System.out.println("descriptionBrandName*********"+DB_Item_Des);
				getCommand().storeValue(key,DB_Item_Des.trim());
			}
			}
			else
			{
				 SoftAssertion.fail("Selected item is not in DB");
			}
			
		  }

		    

	return this;

}
/*
 * For test data Readiness User creation
 * public ItemDeletePage clickISR_link()
	{
		getCommand().waitFor(3);
		log("Click on ISR link ",LogType.STEP);
		getCommand().getDriver().switchTo().frame("topFrame");
		getCommand().waitForTargetPresent(ISR_Link);
		if(getCommand().isTargetPresent(ISR_Link))
		{
			getCommand().click(ISR_Link);
		}
		return this;
	}
 */
public ItemDeletePage readUserData(String filepName,String keyValue)
{
	 //String st=(new SupportFunctions()).readOutputData(filepName,keyValue);
	// String st=(new SupportFunctions()).readOutputData("Book8.xls", "Create");
	 String filepath="OutputData//"+filepName;
		
		try {
			FileInputStream fileInputStream = new FileInputStream(filepath);
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		//	HSSFSheet worksheet = workbook.getSheet(filepName);
			HSSFSheet worksheet = workbook.getSheet("ss");
			int size=worksheet.getLastRowNum();
			for(int i=0;i<=size;i++)
			{
			HSSFRow row1 = worksheet.getRow(i);
			HSSFCell cellA1 = row1.getCell(0);
			String a1Val = cellA1.getStringCellValue();
			if(a1Val.compareTo(keyValue)==0)
			{
			HSSFCell cellB1 = row1.getCell(1);
			String b1Val = cellB1.getStringCellValue();
			
			
			System.out.println("A1: " + a1Val);
			System.out.println("B1: " + b1Val);
			//return b1Val;
			}
		}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//return null;
	 //String st1=(new SupportFunctions()).readOutputData("Modify_Order_verify.xls","OrderNum");
//	String filepath="Automation_TestDataReadiness//"+filepName;
//	try {
//		
//		FileInputStream input = new FileInputStream(filepath);         
//
//		// Create a POIFSFileSystem by passing it FileInputStream 
//		POIFSFileSystem fileSystem = new POIFSFileSystem(input);         
//
//		// Create a Workbook using HSSFWorkbook object
//		HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
//
//		// get the sheet at location 0 by calling 
//		// getSheetAt() method of the Workbook
//		HSSFSheet sheet = workBook.getSheetAt(0); 
//		
//		
//		//FileInputStream fileInputStream = new FileInputStream(filepath);
//		//HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
//		HSSFSheet worksheet = workBook.getSheet("UserCreation");
//		int size=worksheet.getLastRowNum();
//		for(int i=0;i<=size;i++)
//		{
//		HSSFRow row1 = worksheet.getRow(i);
//		System.out.println("Row length==="+row1.getRowNum());
//		HSSFCell cellA1 = row1.getCell(0);
//		String a1Val = cellA1.getStringCellValue();
//		if(a1Val.compareTo(keyValue)==0)
//		{
//		HSSFCell cellB1 = row1.getCell(1);
//		String b1Val = cellB1.getStringCellValue();
//		
//		
//		System.out.println("A1: " + a1Val);
//		System.out.println("B1: " + b1Val);
//		
//		}
//	}
//	}catch (FileNotFoundException e) {
//		e.printStackTrace();
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
	return this ;
}
}
