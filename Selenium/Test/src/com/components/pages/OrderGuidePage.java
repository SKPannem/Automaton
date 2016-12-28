package com.components.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.SoftAssertion;
import com.iwaf.framework.components.Target;

public class OrderGuidePage extends SitePage {
	public static final Target btn_list=new Target("btn_list","//a[@id='<#>']",Target.XPATH);
	public static final Target btn_ViewOrder=new Target("btn_ViewOrder","//*[@id='viewActiveOrderBtn']",Target.XPATH);
	public static final Target btn_submit=new Target("btn_submit","//*[@id='chkOutBtn1']",Target.XPATH);
	public static final Target btn_SaveList=new Target("btn_SaveList","//*[@id='createsaveNewList']",Target.XPATH);
    public static final Target btn_ViewList=new Target("btn_ViewList","//*[@id='viewlistnow_id']",Target.XPATH);
    public static final Target btn_ViewHistory=new Target("lnk_Export","//*[@id='viewitemhistory']",Target.XPATH);
    public static final Target btn_Print=new Target("btn_Print","//*[@id='printOrderGuideLink']/img",Target.XPATH);
    public static final Target btn_DropDownDate=new Target("btn_DropDownDate","//*[@id='orderGuideDateRange']",Target.XPATH);
    public static final Target btn_CreateNewList=new Target("btn_CreateNewList","//*[@id='addMultiItemsToNewList']",Target.XPATH);
  
    public static final Target txt_SUPCNumber=new Target("txt_SUPCNumber","//*[@id='<#>-CS']/td[19]",Target.XPATH);
    public static final Target txt_CS=new Target("txt_CS","//*[@id='<#>-CS']/td[23]",Target.XPATH);
    public static final Target txt_EA=new Target("txt_EA","//*[@id='<#>-EA']/td[23]",Target.XPATH);
    public static final Target txt_ListNamePopupInOrderGuide=new Target("txt_ListNamePopupInOrderGuide", "//*[@id='savelistName']",Target.XPATH);
    public static final Target txt_Quantity=new Target("txt_Quantity","//*[@id='<#>-CS_syscoGridColumnEditableQuantityFormatter']",Target.XPATH);
    public static final Target txt_OrderBetwenDate=new Target("txt_OrderBetwenDate","//*[@id='dateRangeViewAllHeading']",Target.XPATH);
    public static final Target txt_UPC=new Target("txt_UPC","//*[@id='<#>-CS']/td[18]",Target.XPATH);
    public static final Target txt_Description=new Target("txt_Description","//span[@class='bluetxbold2']",Target.XPATH);
    public static final Target link_Mark=new Target("link_Mark", "//*[@id='<#>-CS']/td[26]/img", Target.XPATH);
    
    public static final Target link_SaveAsList=new Target("link_SaveAsList","//*[@id='saveitemsaslisttop']",Target.XPATH);
    public static final Target link_PMT=new Target("link_PMT","//*[@id='jqgh_itemHistoryGrid_pMTResult']",Target.XPATH);
    public static final Target link_CancelSaveAsList=new Target("link_CancelSaveAsList","//*[@id='saveitems_cancellink_id']/input",Target.XPATH);
    public static final Target link_OrderGuide=new Target("link_OrderGuide","//*[@id='itemHistoryTab']",Target.XPATH);
    public static final Target link_Export=new Target("link_Export","//*[@id='exportOrderGuideLink']",Target.XPATH);
   
    public static final Target chk_GroupByCategory=new Target("chk_GroupByCategory","//*[@id='groupByCategoryButtonTop']",Target.XPATH);
    public static final Target chk_SplitItem=new Target("chk_SplitItem","//*[@id='jqg_itemHistoryGrid_<#>-EA']",Target.XPATH);
    public static final Target chk_Item=new Target("chk_Item","//*[@id='jqg_itemHistoryGrid_<#>-CS']",Target.XPATH);
    public static final Target chk_Pmt=new Target("chk_Pmt","//*[@id='pmt_<#>-CS']",Target.XPATH);
    
    public static final Target box_Search=new Target("box_Search","//*[@id='srchTop']",Target.XPATH);
    public static final Target dropDown_SplitItem=new Target("dropDown_SplitItem","//*[@id='<#>-EA_syscoGridColumnEditableQuantityFormatter']",Target.XPATH);
    public static final Target txt_Id=new Target("txt_Id","//td[@aria-describedby='viewListGrid_materialId']",Target.XPATH);
    public static final Target tab_Price=new Target("tab_Price","//*[@id='priceTable']",Target.XPATH);
    public static final Target txt_handPrice=new Target("txt_handPrice","//*[@id='<#>-CS_currentprice']",Target.XPATH);
    public static final Target searchinlist=new Target("searchinlist","//*[@id='srchTop']",Target.XPATH);
    public static final Target searchinlist1=new Target("searchinlist1","//*[@id='jqg_viewListGrid_<#>-CS']",Target.XPATH);
    public static final Target itm_sts_chkbox1 = new Target("itm_sts_chkbox1","//*[@id='expIncludePSMSCheckBox']",Target.XPATH);
    
  
    
    public static String listName="";
    public OrderGuidePage(SiteRepository repository){
		super(repository);
   }
	public OrderGuidePage atOrderGuidePage(){
			log("Welcome to order Guide Page",LogType.STEP);
		     return this;
	}
	public OrderGuidePage enterOrderQuantity(String[] upcName,String[] casequantity){

			(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			for(int i=0;i<upcName.length;i++){
				enterTypeInSearchBox(upcName[i].trim());
				
			getCommand().waitForTargetPresent(txt_Quantity.replace("<#>", upcName[i].trim()));
			if(getCommand().isTargetPresent(txt_Quantity.replace("<#>", upcName[i].trim()))){
				log("Enter Order Quantity:"+txt_Quantity,LogType.STEP);
				getCommand().sendKeys(txt_Quantity.replace("<#>", upcName[i].trim()),casequantity[i].trim());
				getCommand().waitFor(5);
				
			 }
			}
			return this;

       
	}
	public OrderGuidePage clickOnViewOrder(){
		if(getCommand().isTargetPresent(btn_ViewOrder)){
			log("click on View Order",LogType.STEP);
			getCommand().click(btn_ViewOrder);
		}
		return this;
	}
	public OrderGuidePage clickOnSubmitOrder(){
		if(getCommand().isTargetPresent(btn_submit)){
			log("submitted successfully",LogType.STEP);
			getCommand().click(btn_submit);
		}
		return this;
	}
	public OrderGuidePage checkMultipleItem(String[] upcName){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		for(int i=0;i<upcName.length;i++){
		enterTypeInSearchBox(upcName[i].trim());	
		getCommand().waitForTargetPresent(chk_Item.replace("<#>",upcName[i].trim() ));
		(new SupportFunctions()).ScrollInToView(chk_Item.replace("<#>",upcName[i].trim()));
		if(getCommand().isTargetPresent(chk_Item.replace("<#>",upcName[i].trim() ))){
			log("Check Item NO:"+upcName[i],LogType.STEP);
			getCommand().click(chk_Item.replace("<#>",upcName[i].trim() ));
		}}
		return this;
	}
	public OrderGuidePage clickOnSaveAsList(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		getCommand().waitForTargetPresent(link_SaveAsList);
		if(getCommand().isTargetPresent(link_SaveAsList)){
			log("Click On Save_As_List in OrderGuide Page",LogType.STEP);
			getCommand().click(link_SaveAsList);
		}
		return this;
	}
	public OrderGuidePage clickOnCancelSaveAsListPopUp(){
		getCommand().waitForTargetVisible(link_CancelSaveAsList);
		if(getCommand().isTargetPresent(link_CancelSaveAsList)){
			log("Click On CAncel On Save_As_List Pop up",LogType.STEP);
			getCommand().click(link_CancelSaveAsList);
			getCommand().waitFor(3);
		}
		return this;
	}
	public OrderGuidePage enterNameOfList(){
		if(getCommand().isTargetPresent(txt_ListNamePopupInOrderGuide)){
			listName=RandomStringUtils.randomAlphanumeric(10);
			getCommand().storeValue("ListNameSaveList",listName);
			log("Enter List Name in OrderGuide Page",LogType.STEP);
			getCommand().clear(txt_ListNamePopupInOrderGuide).sendKeys(txt_ListNamePopupInOrderGuide,listName);
		}
		return this;
	}
	public OrderGuidePage clickOnOrderGuideTab(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(getCommand().isTargetPresent(link_OrderGuide)){
			log("Click On orderGuide",LogType.STEP);
			getCommand().click(link_OrderGuide);
		}
		return this;
	}
	public OrderGuidePage clickOnSaveNewList(){
		if(getCommand().isTargetPresent(btn_SaveList)){
			log("Click On save new list",LogType.STEP);
			getCommand().click(btn_SaveList);
			(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='saveItemsAsListDiv']"));
		}
		return this;
	}
	public OrderGuidePage clickOnViewList(){
		if(getCommand().isTargetPresent(btn_ViewList)){
			log("Click On view  lists ",LogType.STEP);
			getCommand().click(btn_ViewList);
		}
		return this;
	}
	public OrderGuidePage clickOnCreatNewListPopup(){
		if(getCommand().isTargetPresent(btn_CreateNewList)){
			//Waiting For The Element To Be Loaded in i.e browser only
			   (new SupportFunctions()).waitForStatic(3);
			log("Click On Create New List",LogType.STEP);
			getCommand().click(btn_CreateNewList);
		}
		return this;
    }
	public OrderGuidePage validatePriceColumn(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		 getCommand().getDriver().manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		List<WebElement> countPriceColumn=getCommand().getDriver().findElements(By.xpath("//*[@id='jqgh_itemHistoryGrid_price']"));
		if(countPriceColumn.size()==1){
			log("Total No. Column For Price="+countPriceColumn.size(),LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed:: No Of Price column:'"+countPriceColumn.size()+"'");
		}return this;
	}
		public OrderGuidePage validatePriceColumnName(){
		getCommand().getDriver().manage().timeouts().setScriptTimeout(120,TimeUnit.SECONDS);
		//Getting  Name of Price Column 
		String textPrice=getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_itemHistoryGrid_price']")).getText();
		if(textPrice.equals("Price($)")){
			log("Column Name Is:"+textPrice,LogType.STEP);
		}
		else{
			SoftAssertion.fail("Falied::Column  Is Not Displayed");
		}
		return this;
		}
	public OrderGuidePage clickOnPrint(){
		//wait for load pop to be invisible
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(btn_Print);
		log("Click On Print Button",LogType.STEP);
		getCommand().click(btn_Print);
		return this;
	}
	public OrderGuidePage validateDiaLogBoxPopup(){
		getCommand().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='printOptionsPopUp']")).isDisplayed()){
			log("Print Pop up Is Displayed",LogType.STEP);
		}else{
			SoftAssertion.fail("Falied::Dialog Box Is Not Displayed");
		}
		return this;
	}
	public OrderGuidePage checkOnLivePricing(){
		getCommand().getDriver().findElement(By.xpath("//*[@id='includePricingCheckBox']")).click();
		log("Click On Live Pricing",LogType.STEP);
		return this;
	}
	public OrderGuidePage clickOnExport(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(getCommand().isTargetPresent(link_Export)){
			log("Click On Export Link",LogType.STEP);
			getCommand().click(link_Export);
		}
		return this;
	}
	public OrderGuidePage checkOnLivePricingInExportPopUp(){
		getCommand().getDriver().findElement(By.xpath("//*[@id='expIncludePricingCheckBox']")).click();
		log("Click On Live Pricing In Export Popup",LogType.STEP);
		return this;
	}
	public OrderGuidePage validateProductColumn(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		String desCription=getCommand().getDriver().findElement(By.xpath("//span[@class='bluetxbold2']")).getText();
		getCommand().scrollTo(txt_Description);
		if(desCription.contains("Will be replaced by")){
			log(desCription+" Is Displayed",LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed:: 'Will be replaced by' Is Not Displayed In product Column");
		}
		
		return this;
		
	}
	public OrderGuidePage validateItemsHistory(int week){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Storing The Years Present In DropDown In A List
		Calendar cal = Calendar.getInstance();
		//Getting Date before mentioned weeks
		cal.add(Calendar.DATE, -week); // 
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MMM-d"); 
		String dateBeforeWeeks=s.format(new Date(cal.getTimeInMillis()));
		System.out.println(dateBeforeWeeks);
		String[] dateSplit=dateBeforeWeeks.split("-");
		log("Click On Date Pick",LogType.STEP);
		getCommand().waitFor(5);
		getCommand().getDriver().findElement(By.xpath("//*[@id='left-sidebarcrashlink']/div/div/div[2]/span[2]/img")).click();
		Select selYear=new Select(getCommand().getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]")));
		selYear.selectByValue(dateSplit[0]);
        Select selMonth=new Select(getCommand().getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]")));
	    selMonth.selectByVisibleText(dateSplit[1]);
		log(dateBeforeWeeks+" Is Selected",LogType.STEP);
		//Click On Date
		getCommand().waitFor(3);
		getCommand().getDriver().findElement(By.linkText(dateSplit[2])).click();
		clickOnViewItems();
		//Validating 
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		String orderBetween=getCommand().getDriver().findElement(By.xpath(txt_OrderBetwenDate.getTargetValue())).getText();
		System.out.println("========"+orderBetween);
		if(!orderBetween.isEmpty()){
			if(orderBetween.contains("/")){
				log(orderBetween,LogType.STEP);
			}else{
				SoftAssertion.fail("Failed::There Are Items Between This Range But Not Displayed");
			}
		}else{
			String noOrders=getCommand().getDriver().findElement(By.xpath("//*[@id='noresults-div']/p[1]")).getText();
			log("There Is No Items In This  date Range",LogType.STEP);
			System.out.println(noOrders);
			log(noOrders,LogType.STEP);
		}

	 
		
        return this;
	}
	public OrderGuidePage selectCustomDate(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(getCommand().isTargetPresent(btn_DropDownDate)){
			new SupportFunctions().selectDropDownValue(By.xpath("//*[@id='orderGuideDateRange']"),"0");
			log("Select Custom From Drop Down",LogType.STEP);
		}
		(new SupportFunctions()).keyBoardEvent();
		return this;
		
	}
	public OrderGuidePage clickOnViewItems(){
		//getCommand().click(btn_ViewHistory);
		getCommand().getDriver().manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		WebElement element = getCommand().getDriver().findElement(By.xpath(btn_ViewHistory.getTargetValue()));
        JavascriptExecutor executor = (JavascriptExecutor)getCommand().getDriver();
        executor.executeScript("arguments[0].click();", element);
		log("Click On View Item History",LogType.STEP);
	    getCommand().waitFor(3);
		return this;
	}
	public OrderGuidePage verifyNarrowResult(String[] options){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> narrrowResultOptions=getCommand().getDriver().findElements(By.xpath("//font[@class='bybold checkboxmiddle']"));
	    for(int i=0;i<options.length;i++){
		   for(int j=0;j<narrrowResultOptions.size();j++){
			if(options[i].contains(narrrowResultOptions.get(j).getText())){
			log(options[i]+" Is Displayed",LogType.STEP);
			}else{
				if(j!=(narrrowResultOptions.size()-1)){
					continue;
				}else{
					SoftAssertion.fail("Failed::"+options[i]+"Not Found");
				}
			}
			break;
		   
			   
		}
	    }
		return this;
	 }
	public OrderGuidePage validateProductInfo(String upc){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='productInformationTable']")).isDisplayed()){
			log("Product for"+upc+"  Info Displayed",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::Product Info for"+ upc+" Is Not Displayed");
		}
		getCommand().waitFor(10);
		return this;
		
	}
	public OrderGuidePage checkOnPreviousOrder(){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log("Click Previous Order History",LogType.STEP);
		getCommand().getDriver().findElement(By.xpath("//*[@id='previousOrderedCheckBox']")).click();
		getCommand().waitFor(10);
		return this;
		
	}
	public OrderGuidePage enterTypeInSearchBox(String searchType){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	     getCommand().waitForTargetPresent(box_Search);
		if(getCommand().isTargetPresent(box_Search)){
			log("Enter Search Type: " + searchType,LogType.STEP);	
			getCommand().clear(box_Search).sendKeys(box_Search, searchType);
			(new SupportFunctions()).keyBoardEvent();
			//Waiting For The Object In IE
			 new SupportFunctions().waitForStatic(5);
	   }
	
	return this;

  }
	public OrderGuidePage checkGroupByCategory(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(chk_GroupByCategory);
		if(getCommand().isSelected(chk_GroupByCategory)){
			log("Group By Category Selected",LogType.STEP);
		}
		else{
			log("Check Group By Category",LogType.STEP);
			getCommand().click(chk_GroupByCategory);
		}
		getCommand().waitFor(10);
		return this;
	}
	public OrderGuidePage UnCheckGroupByCategory(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(chk_GroupByCategory);
		if(getCommand().isSelected(chk_GroupByCategory)){
			log("Uncheck Group By Category",LogType.STEP);
			getCommand().click(chk_GroupByCategory);
		}
		else{
			SoftAssertion.fail("Failed::Group By Category Is Not Selected");
		}
		getCommand().waitFor(10);
		return this;
	}
	public OrderGuidePage validateYes(){
		getCommand().getDriver().manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		if(!getCommand().getDriver().findElements(By.xpath("//*[@title='Yes']")).isEmpty()){
			log("Yes Is Present in Order Before Column",LogType.STEP);
		}else{
			log("Yes Is Not Present in Order Before Column",LogType.STEP);
		}
		return this;
	}
	public OrderGuidePage validateItemsInList(String[] upcName){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		for(int i=0;i<upcName.length;i++){
			String path="//*[@id='"+upcName[i].trim()+"-CS']/td[21]";
		String textUPC=getCommand().getDriver().findElement(By.xpath(path)).getText();
		if(textUPC.equals(upcName[i].trim())){
			log(upcName[i]+" Item is  Validated",LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed::"+upcName[i]+" Item Number Is Not Present");
		}
	  }
		return this;
	}
	public OrderGuidePage validateItemsInList1(String item1)
	{
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().isTargetPresent(searchinlist);
		getCommand().sendKeys(searchinlist, item1.trim());
		getCommand().waitForTargetPresent(searchinlist1);
		if(getCommand().isTargetPresent(searchinlist1.replace("<#>", item1.trim())))
		{
			getCommand().click(searchinlist1.replace("<#>", item1.trim()));
		}
		
		return this;
	}
	public OrderGuidePage validateDuplicateListName(){
		//Waiting For The Element To Be Loaded in i.e browser only
		   getCommand().waitFor(3);
		getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String textMessage=getCommand().getDriver().findElement(By.xpath("//div[@id='duplicateListName_copypopup']")).getText();
		System.out.println("Message:"+textMessage);
		if(textMessage.contains("List name already exists. Please enter a different name.")){
			log(textMessage,LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::Duplicate List Text Message Is  Not Found");
		}
		
		return this;
	}
	public OrderGuidePage clickOnClearSetting(){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log("Click On Clear Setting",LogType.STEP);
		getCommand().getDriver().findElement(By.xpath("//*[@id='itemHistoryGrid_toppager_left']/table/tbody/tr/td[3]/div/span[2]")).click();
		System.out.println("stop");
		return this;
		
	}
	public OrderGuidePage validateSplitRecordUPC(String upc){
		getCommand().getDriver().manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		System.out.println("No Of Records======"+getCommand().getDriver().findElements(By.xpath("//a[@title='Click for more product information']")).size());
		if(getCommand().getDriver().findElements(By.xpath("//a[@title='Click for more product information']")).size()==2){
			log("No Of Records======"+getCommand().getDriver().findElements(By.xpath("//a[@title='Click for more product information']")).size(),LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::No. Of Records for item"+upc+" is Not 2");
		}
		return this;
	}
	public OrderGuidePage validateNonSplitRecordUPC(String upc){
		getCommand().getDriver().manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		System.out.println("No Of Records======"+getCommand().getDriver().findElements(By.xpath("//*[contains(@title,'Click for more product information')]")).size());
		if(getCommand().getDriver().findElements(By.xpath("//*[contains(@title,'Click for more product information')]")).size()==1){
			log("No Of Records======"+getCommand().getDriver().findElements(By.xpath("//*[contains(@title,'Click for more product information')]")).size(),LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::No. Of Records for item"+upc+" is Not 1");
		}
		return this;
	}
	public OrderGuidePage validateOrderQunatityUnitCS(String upcNumber){
		getCommand().waitForTargetPresent(txt_CS.replace("<#>", upcNumber));
		if(getCommand().isTargetPresent(txt_CS.replace("<#>", upcNumber))){
			log("Order Qunatity Having Unit CS Is Displayed",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::Order Qunatity Having Unit CS Is Not Displayed");
		}
		return this;
	}
	public OrderGuidePage validateOrderQunatityUnitEA(String upcNumber){
	    getCommand().waitForTargetPresent(txt_EA.replace("<#>", upcNumber));
		if(getCommand().isTargetPresent(txt_EA.replace("<#>", upcNumber))){
			log("Order Qunatity Having Unit EA Is Displayed",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::Order Qunatity Having Unit EA Is Not Displayed");
		}
	  return this;	
	}
	public OrderGuidePage validateCheckBox(String upcNumber){
		getCommand().waitForTargetPresent(chk_Item.replace("<#>", upcNumber));
		String textCheckBox=getCommand().getAttributeValue(chk_Item.replace("<#>", upcNumber), "type");
		if(textCheckBox.equalsIgnoreCase("checkbox")){
			log("Check Box For The Item "+upcNumber +" Is Present",LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed::Check Box For The Item "+upcNumber +" Is Not Present");
		}
		
		return this;
	}
	public OrderGuidePage validateQunatityText(String upc){
		String attValue=getCommand().getDriver().findElement(By.xpath("//*[@id='"+upc+"-CS_syscoGridColumnEditableQuantityFormatter']")).getAttribute("type");
		if(attValue.contains("text")){
			log("Text  Is Present For Quanity For Item:"+upc ,LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::Text  Is Present For Quanity For Item:"+upc);
		}
		return this;
	}
	public OrderGuidePage validateSplitQunatity(String upc){
		int size=getCommand().getDriver().findElements(By.tagName("select")).size();
		if(size!=0){
			log("DropDown  Is Present For Quanity For Item:"+upc ,LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::DropDown  Is Not Present For Quanity For Item:"+upc);
		}
		return this;
	}
	public OrderGuidePage validateSplitDown(String upc){
		int size=getCommand().getDriver().findElements(By.tagName("select")).size();
		if(size>1 && size==1){
			log("DropDown  Is Present For Quanity For Item:"+upc ,LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::DropDown  Is Present For Quanity For Item:"+upc);
		}
		return this;
	}
	
	public OrderGuidePage validateCheckBoxForSplitItem(String upcNumber){
			String textSplitCheckBox=getCommand().getAttributeValue(chk_SplitItem.replace("<#>", upcNumber), "type");
			System.out.println("check box=========="+textSplitCheckBox);
			if(textSplitCheckBox==null){
				log("Check Box For The Item "+upcNumber +"Is Not Present",LogType.STEP);
			}
			else{
				SoftAssertion.fail("Failed::Check Box For The Item "+upcNumber +" Is Not Present");
		}
		return this;
	}
	public OrderGuidePage verifyOrderQuantity(String upcName){
		if(getCommand().isTargetPresent(txt_Quantity.replace("<#>", upcName))){
			log("Order Quantity Text Is Displayed",LogType.STEP);
			}else{
				SoftAssertion.fail("Failed::Order Quantity Text Is Not Displayed");
			}
		return this;
	}
	public OrderGuidePage verifyDropDownInSplitItem(String upcName){
		if(getCommand().isTargetPresent(dropDown_SplitItem.replace("<#>", upcName))){
			log("Drop Down  Is Displayed",LogType.STEP);
			}
		return this;
	}
	public OrderGuidePage verifyDropDownValuesInSplitItem(String upcName){
		
		if(getCommand().isTargetPresent(dropDown_SplitItem.replace("<#>", upcName))){
			List<WebElement> dropDownList=(new SupportFunctions()).getDropdownList(By.xpath("//*[@id='"+upcName+"-EA_syscoGridColumnEditableQuantityFormatter']"));
			for(WebElement e:dropDownList){
					log(e.getText()+" Is Verified Split Quantity",LogType.STEP);
				
			}
		 }
		return this;
	}
	public OrderGuidePage verifyOrderGuideButton(){
		//Verifying Order Guide page
		  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		  getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  if(getCommand().getDriver().findElement(By.xpath("//*[@id='itemHistoryTab']")).isDisplayed()){
			  log("Order Guide Is Displayed",LogType.STEP);
		  }else{
			  SoftAssertion.fail("Failed::Order Guide Is Not Displayed");
		  }
		  return this;
		 
	  }
	public OrderGuidePage verifyOrderGuidepage(){
		//Verifying Order Guide page
		  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		  getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  if(getCommand().getDriver().findElement(By.xpath("//*[@id='gbox_itemHistoryGrid']")).isDisplayed()){
			  log("Order Guide Page Is Displayed",LogType.STEP);
		  }else{
			  SoftAssertion.fail("Failed::Order Guide Page Is Not Displayed");
		  }
		  return this;
		 
	  }
	public OrderGuidePage validateUPC(String upcNumber){
		//Validating UPC
		getCommand().waitFor(3);
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		String path="//*[@id='"+upcNumber+"-CS']/td[18]";
		getCommand().scrollTo(txt_UPC.replace("<#>", upcNumber));
		if(getCommand().getDriver().findElement(By.xpath(path)).isDisplayed()){
			log("Item'"+upcNumber+"' Displayed",LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed:: Enter Valid UPC");
		}
		getCommand().waitFor(5);
		return this;
	}
	public OrderGuidePage validateBrandName(String brandName){
		//Validating Brand name
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String path="//td[@aria-describedby='itemHistoryGrid_brandName']";
		List<WebElement> listOfBrand=getCommand().getDriver().findElements(By.xpath(path));
		if(listOfBrand.size()>0){
			log("Items Arranged By "+brandName,LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed:: Not Arranged By "+brandName);
		  }

		return this;
	}
	public OrderGuidePage validateItemName(String itemName){
		//Validating Brand name
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String path="//td[@aria-describedby='itemHistoryGrid_categoryName']";
		List<WebElement> listOfBrand=getCommand().getDriver().findElements(By.xpath(path));
		if(listOfBrand.size()>0){
			log("Items Arranged By "+itemName,LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed:: Not Arranged By "+itemName);
		  }

		return this;
	}
	public OrderGuidePage validateOrderBefore(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_itemHistoryGrid_orderedBefore']")).getText().contains("Ordered")){
			log("Ordered Before Is  Displayed  ",LogType.STEP);
		}else{
			SoftAssertion.fail("Falied::Column Ordered Before Is Not Displayed ");
		}
		return this;
	}
	public OrderGuidePage validateLastOrder(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(getCommand().getDriver().findElements(By.linkText("LastOrder")).isEmpty()){
			log("Last Order Column Is Not Present",LogType.STEP);
		}else{
			SoftAssertion.fail("Falied::Last Order Column Is Not Present ");
		}
		return this;
	}
	public OrderGuidePage validateDefaultColumn(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		getCommand().getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_itemHistoryGrid_agreementFlag']")).getText().contains("Agr.")){
				log("Agr. Is  Displayed  ",LogType.STEP);
			}else{
				SoftAssertion.fail("Falied::Column Agr. Is Not Displayed ");
			}
		
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_itemHistoryGrid_orderedBefore']")).getText().contains("Ordered")){
				log("Ordered Before Is  Displayed  ",LogType.STEP);
			}else{
				SoftAssertion.fail("Falied::Column Ordered Before Is Not Displayed ");
			}

	    	if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_itemHistoryGrid_stockTypeFlag']")).getText().contains("Stock")){
				log("Stock Type Is  Displayed ",LogType.STEP);
			}else{
				SoftAssertion.fail("Stock Type Is Not Displayed ");
			}
		
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_itemHistoryGrid_materialId']")).getText().contains("UPC")){
				log("Sysco UPC Is  Displayed",LogType.STEP);
			}else{
				SoftAssertion.fail("UPC Column Is Not Displayed");
			}
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='itemHistoryGrid_packSize']")).getText().contains("Pack/Size")){
				log("Pack/Size Is Displayed",LogType.STEP);
			}else{
				SoftAssertion.fail("Pack/Size Column Is Not  Displayed");
			}
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_itemHistoryGrid_brandName']")).getText().contains("Brand")){
				log("Brand Is  Displayed",LogType.STEP);
			}else{
				SoftAssertion.fail("Brand Column Is Not Displayed");
			}
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='itemHistoryGrid_categoryName']")).getText().contains("Category")){
				log("Category Is  Displayed ",LogType.STEP);
			}else{
				SoftAssertion.fail("Category Column Is Not  Displayed");
			}
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_itemHistoryGrid_quantity']")).getText().contains("Qty.")){
				log("Order Qty. Is  Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail("Order Qty. Column Is Not  Displayed");
			}
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_itemHistoryGrid_price']")).getText().contains("Price($)")){
				log("Price($) Is Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail("Price($) Column Is Not Displayed");
			}
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_itemHistoryGrid_estTotal']")).getText().contains("Est.")){
				log("Est.Price Is  Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail("Est.Price Column Is Not Displayed");
			}
			
		return this;
	}
	public OrderGuidePage validateItemName(){
		//Verifyng Item Information
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String path="//*[@class='itemInformationClick']";
		List<WebElement> listOfItemName=getCommand().getDriver().findElements(By.xpath(path));
		for(WebElement itemName:listOfItemName){
		if(itemName.isDisplayed()){
			log("Item'"+itemName.getText()+"' Displayed",LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed:: Enter Valid UPC");
		  }
		}
		getCommand().waitFor(5);
		return this;
	}
	public OrderGuidePage validateCategory(){
		
		return this;
	}
	public OrderGuidePage validateSaveAsListPopup() {
		//Verifying Save List Pop up
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='saveItemsAsListDiv']")).isDisplayed()){
			log("SaveList Pop Up Is Displayed",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::SaveList Pop Up Is Not Displayed ");
		}
		return this;
	}
	public OrderGuidePage validateAddListPopupAfterCancel() {
		getCommand().waitFor(3);
		//Verifying Save List Pop up
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(!getCommand().getDriver().findElement(By.xpath("//*[@id='showAllprivateList']")).isDisplayed()){
			log("Add List Pop up Disappered After cancel",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::Add List Pop up Still Exists After cancel ");
		}
		return this;
	}
	public OrderGuidePage validateSaveListPopupAfterCancel() {
		getCommand().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if(!getCommand().getDriver().findElement(By.xpath("//*[@id='savelistName']")).isDisplayed()){
        	log("Save List Pop up Disappered After cancel",LogType.STEP);
        }else{
        	SoftAssertion.fail("Failed::Save List Pop up Still Exists After cancel");
        }
		return this;
		
	}
	public OrderGuidePage verifyPMTColumnSA(String user) {
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_itemHistoryGrid_pMTResult']")).isDisplayed()){
        	log("PMT coulmn is displayed in "+user +" as expected",LogType.STEP);
        }else{
        	SoftAssertion.fail("Failed::PMT coulmn is not displayed in  "+user +" as expected");
        }
		return this;
		
	}
	public OrderGuidePage verifyPMTColumnOtherUser(String user) {
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
        if(!getCommand().isTargetPresent(link_PMT)){
        	log("PMT coulmn is not displayed in "+user +" as expected",LogType.STEP);
        }else{
        	SoftAssertion.fail("Failed::PMT coulmn is  displayed in  "+user +" as expected");
        }
		return this;
		
	}
	public OrderGuidePage verifyPricingTab() throws AWTException{
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		Actions key = new Actions(getCommand().getDriver());
		 getCommand().getDriver().manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		 log("Press Alt+G:",LogType.STEP);
		 //key.keyUp(Keys.ALT);
		 //key.sendKeys("%(g)");
		 if(!getCommand().getDriver().findElement(By.xpath("//*[@id='priceTable']")).isDisplayed()){
			getCommand().waitFor(3);
		    Robot rb =new Robot();
		    rb.keyPress(KeyEvent.VK_ALT);
		    rb.keyPress(KeyEvent.VK_G); 
		    rb.keyRelease(KeyEvent.VK_ALT);
		    rb.keyRelease(KeyEvent.VK_G);
		 }
		 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		 //getCommand().waitForTargetVisible(tab_Price);
		 if(getCommand().getDriver().findElement(By.xpath("//*[@id='priceTable']")).isDisplayed()){
		    log("Pricing tab is displayed as expected",LogType.STEP);	 
		 }else{
			 SoftAssertion.fail("Falied::Pricing tab  is not displayed as expected");
		 }
		 return this;
	}
	public OrderGuidePage clickOnPMTCheckBox(String SUPC) {
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
    	getCommand().waitFor(3);
        if(getCommand().isTargetPresent(chk_Pmt.replace("<#>", SUPC))){

        	log("Click on PMT check box for the item: "+SUPC,LogType.STEP);
        	getCommand().click(chk_Pmt.replace("<#>", SUPC));
        }else{
        	SoftAssertion.fail("Failed::PMT check box is not displayed for the item  "+SUPC +" as expected");
        }
		return this;
		
	}
	public OrderGuidePage verifyPMTCheckBox(String SUPC) {
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitFor(3);
        if(getCommand().isChecked(chk_Pmt.replace("<#>", SUPC))){
        	
        	log("PMT check box is enabled for the item : "+SUPC,LogType.STEP);
        }else{
        	SoftAssertion.fail("Failed::PMT check box is not enabled for the item : "+SUPC);
        }
		return this;
		
	}
	public OrderGuidePage setHandPrice(String SUPC) throws AWTException {
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		enterTypeInSearchBox(SUPC);
		String aPrice=getCommand().getAttributeValue(txt_handPrice.replace("<#>",SUPC),"value");
		log("Actual price for the item : "+aPrice,LogType.STEP);
		
		double handPrice=Double.parseDouble(aPrice)+3;
		getCommand().click(txt_handPrice.replace("<#>", SUPC));
		getCommand().waitFor(3);
		Robot rb =new Robot();
	    rb.keyPress(KeyEvent.VK_BACK_SPACE);
	    
	    rb.keyRelease(KeyEvent.VK_BACK_SPACE);
	   
		log("Enter hand price for the item : "+SUPC+" :"+handPrice,LogType.STEP);
		
		getCommand().sendKeys(txt_handPrice.replace("<#>",SUPC), handPrice+"");
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		(new SupportFunctions()).keyBoardEvent();
    	return this;
		
	}
	public OrderGuidePage itemStatusCheckboxOG()
	{
		if(getCommand().isTargetPresent(itm_sts_chkbox1))
		{
			SoftAssertion.fail("Item status check box is present in order guide page");
		}
		else
		{
			log("item status check box is NOT present in Order guide as expected", LogType.STEP);
		}
		return this;
	}
	
	
}

 