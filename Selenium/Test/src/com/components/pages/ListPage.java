package com.components.pages;



import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.components.repository.SiteRepository;
import com.iwaf.framework.TestProperties;
import com.iwaf.framework.components.SoftAssertion;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;

public class ListPage extends SitePage{
	
	
	public static final Target btn_list=new Target("btn_list","//a[@id='<#>']",Target.XPATH);
	public static final Target btn_CheckOnItem=new Target("btn_CheckOnItem","//*[@id='jqg_viewListGrid_<#>-CS']",Target.XPATH);
	public static final Target btn_ViewOrder=new Target("btn_ViewOrder","//*[@id='viewActiveOrderBtn']",Target.XPATH);
	public static final Target btn_submit=new Target("btn_submit","//*[@id='chkOutBtn1']",Target.XPATH);
	public static final Target btn_AddToList=new Target("btn_AddToList","//*[@id='addToListBtn']",Target.XPATH);
	public static final Target btn_CreateNewList=new Target("btn_CreateNewList","//*[@id='addMultiItemsToNewList']",Target.XPATH);
	public static final Target btn_Conform=new Target("btn_Conform","//*[@id='multiSelectConfirmButton']",Target.XPATH);
	public static final Target btn_NewList=new Target("btn_NewList", "//*[@id='createNewListButton']", Target.XPATH);
	public static final Target btn_CreateList=new Target("btn_CreateList", "//*[@id='btnolaypop_id']/input", Target.XPATH);
	public static final Target btn_AddToListInProductWindow=new Target("btn_AddToListInProductWindow", "//input[@id='addtolistClick']", Target.XPATH);
	public static final Target btn_CreateNewListInProductWindow=new Target("btn_CreateNewListInProductWindow", "//a[@id='createNewListFlyOut']", Target.XPATH);
	public static final Target btn_CreateListInProductWindow=new Target("btn_CreateListInProductWindow", "//input[@class='createorderbtn']", Target.XPATH);
	public static final Target btn_CancelAddToList=new Target("btn_CancelAddToList","//*[@id='multiSelectCancelButton']",Target.XPATH);
	public static final Target btn_CancelImportOrder=new Target("btn_CancelImportOrder","//*[@id='importCancellink_id']",Target.XPATH);
	public static final Target btn_ImportList=new Target("btn_ImportList","//*[@id='importList']",Target.XPATH);
	public static final Target btn_Existinglist=new Target("btn_Existinglist","//*[@id='<#>' and @value='C']",Target.XPATH);
	public static final Target btn_VisitlistNow=new Target("btn_VisitlistNow","//input[@id='viewlistnow_id']",Target.XPATH);
	public static final Target btn_CancelInPopup=new Target("btn_CancelInPopup","//input[@class='cancelorderbtn simplemodal-close']",Target.XPATH);
	public static final Target btn_CancelInToolsList=new Target("btn_CancelInToolsList","//button[@aria-disabled='false'][1]",Target.XPATH);
	public static final Target btn_saveList=new Target("btn_saveList","//*[@id='saveListbtn']",Target.XPATH);
	
	public static final Target box_Search=new Target("box_Search","//*[@id='srchTop']",Target.XPATH);
	public static final Target txt_OrderQuantity=new Target("txt_OrderQuantity","//*[@id='<#>-CS_syscoGridColumnEditableQuantityFormatter']",Target.XPATH);
	public static final Target txt_ListQuantity=new Target("txt_ListQuantity","//*[@id='<#>-CS_syscoGridColumnEditableListQuantityFormatter']",Target.XPATH);
	public static final Target txt_ListName=new Target("txt_ListName","//*[@id='listNameInPopUp']",Target.XPATH);
	public static final Target txt_ListNumber=new Target("txt_ListNumber", "//*[@id='listNoTxt']", Target.XPATH);
	public static final Target txt_NewListName=new Target("txt_NewListName", "//*[@id='listNameInPopUp']", Target.XPATH);
	public static final Target txt_DuplicateName=new Target("txt_DuplicateName", "//*[@id='duplicateListName_copypopup']", Target.XPATH);
	public static final Target txt_UPCName=new Target("txt_UPCName", "//*[@title='<#>']", Target.XPATH);
	public static final Target txt_NewListNameInProductInfoWindow=new Target("txt_NewListNameInProductInfoWindow", "//input[@id='listName']", Target.XPATH);
	public static final Target txt_SUPCNumber=new Target("txt_SUPCNumber","//*[@id='<#>-CS']/td[19]",Target.XPATH);
	public static final Target txt_Price=new Target("txt_Price","//input[@id='<#>-CS_currentprice']",Target.XPATH);
	
	public static final Target link_CreateNewList=new Target("link_CreateNewList","//*[@id='createNewListInCopy']",Target.XPATH);
	public static final Target link_MyList=new Target("link_MyList", "//a[@id='myLists']", Target.XPATH);
	public static final Target link_ShareList=new Target("link_ShareList", "//a[@id='sharedLists']", Target.XPATH);
	public static final Target link_SyscoList=new Target("link_SyscoList", "//a[@id='syscoRecommended']", Target.XPATH);
	public static final Target link_ListName=new Target("link_ListName", "//a[@title='<#>']", Target.XPATH);
	public static final Target link_Mark=new Target("link_Mark", "//*[@id='<#>-CS']/td[31]/img", Target.XPATH);
	public static final Target link_MarkSearch=new Target("link_MarkSearch", "//*[@id='<#>-CS']/td[25]/img", Target.XPATH);
	public static final Target imag_Order= new Target("imag_Order","<#>",Target.XPATH);
	
	public static final Target chk_Item=new Target("chk_Item", "//*[@id='jqg_productSearchGrid_<#>-CS']", Target.XPATH);
	public static final Target tab_List=new Target("tab_List","//*[@id='listTab']",Target.XPATH);
	public static final Target chk_User = new Target("chk_User","//input[contains(@id,'<#>')]",Target.XPATH);
	public static final Target btn_Update = new Target("btn_Update","//*[@id='updatePerBtn']",Target.XPATH);
	public static final Target lst_Users = new Target("lst_Users","//*[@id='shareListCusts']",Target.XPATH);
	public static final Target tbl_Users = new Target("tbl_Users","//*[@id='usersListPerTable']",Target.XPATH);
	public static final Target chk_Perm = new Target("chk_Perm","//input[@name='Permission_<#>'][@id='<#>-<#>']",Target.XPATH);
	public static final Target btn_DeleteItem = new Target("btn_DeleteItem","//input[@id='deleteListItems']",Target.XPATH);
//afterr14
	public static final Target list_tab = new Target("list_tab","//*[@id='listTab']",Target.XPATH);
	public static final Target lst_name = new Target("lst_name","//*[@id='listName']",Target.XPATH);
	public static final Target lst_num = new Target("lst_num","//*[@id='listNoTxt']",Target.XPATH);
	public static final Target save_lstPop= new Target("save_lstPop","//*[@id='savelistpopupdiv']",Target.XPATH);
	public static final Target savelist2= new Target("savelist2","//*[@id='savelist']",Target.XPATH);
	public static final Target savelist1= new Target("savelist1","//*[@id='saveListbtn']",Target.XPATH);
	public static final Target selectall = new Target("selectall","//*[@id='cb_productSearchGrid']",Target.XPATH);
	public static final Target itm_sts_chkbox = new Target("itm_sts_chkbox","//*[@id='expIncludePSMSCheckBox']",Target.XPATH);
	public static final Target export_btn = new Target("export_btn","html/body/div[36]/div[3]/div/button[2]",Target.XPATH);
	public static final Target lst_num2 = new Target("lst_num2","//*[@id='<#>']",Target.XPATH);
	
	public static String listNumber="";
	public static String listName="";
	public static String listNameUser2="";
	public static String listQuantity="";
	public static String listNumber2="";
	
	ArrayList<String> arr=new ArrayList<String>();
	ArrayList<Float> listQnty=new ArrayList<Float>();
	ArrayList<String> upcNumber=new ArrayList<String>();
	
	public ListPage(SiteRepository repository){
		super(repository);
	}
	public ListPage atListPage(){
		log("Launch List Page",LogType.STEP);
		return this;
	}
	public ListPage clickOnAnyListInMyList(String userName,String TCId) {
		//Getting list numbers in mylist
		String finalListNumber="";
		ArrayList srrData = new SupportFunctions().retrieveData("SELECT NKCUSL from ESLHNKTF where NKCUNO='        108761' and NKUSGN='"+userName+"'");
		ArrayList arrFirstRow = (ArrayList)srrData.get(0);
		String listNumberInMyList=(String) arrFirstRow.get(0);
		listNumber=listNumberInMyList;
		String[] splitList=listNumberInMyList.split(",");
		for(int i=0;i<splitList.length;i++){
			 finalListNumber=finalListNumber+splitList[i];
			 System.out.println(finalListNumber);
		}
		if(getCommand().isTargetPresent(btn_list.replace("<#>", finalListNumber))){
			getCommand().click(btn_list.replace("<#>", finalListNumber));
			log("Click On List Number:"+finalListNumber,LogType.STEP);
		}
		return this;
	}
	public ListPage clickOnParticularList(String key){
		getCommand().waitForTargetPresent(btn_list.replace("<#>",(String)getCommand().retrieveValue(key)));
		if(getCommand().isTargetPresent(btn_list.replace("<#>", (String)getCommand().retrieveValue(key)))){
			getCommand().waitFor(10);
			getCommand().click(btn_list.replace("<#>",(String)getCommand().retrieveValue(key)));
			log("Click On A Particulat  List",LogType.STEP);
		}
		return this;
	}
	
	public ListPage enterTypeInSearchBox(String searchType){
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
	public ListPage enterQuantityListMultiple(String[] upcName,String[] orderQuantity)
	{
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
  
		for(int i=0;i<upcName.length;i++){
		getCommand().waitForTargetPresent(txt_OrderQuantity.replace("<#>", upcName[i]));
		if(getCommand().isTargetPresent(txt_OrderQuantity.replace("<#>", upcName[i]))){
			log("Enter Order Quantity:"+orderQuantity[i],LogType.STEP);
			getCommand().sendKeys(txt_OrderQuantity.replace("<#>", upcName[i]),orderQuantity[i]);
			//getCommand().waitForTargetVisible(link_Mark.replace("<#>",upcName[i]));
			//new SupportFunctions().keyBoardEvent();
			checkItemsFromLists(upcName[i]);
			getCommand().waitFor(3);
			
		 }
		}
		return this;
	}
	public ListPage enterQuantitySearchMultiple(String[] upcName,String[] orderQuantity)
	{
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
  
		for(int i=0;i<upcName.length;i++){
			enterTypeInSearchBox(upcName[i]);
		getCommand().waitForTargetPresent(txt_OrderQuantity.replace("<#>", upcName[i]));
		if(getCommand().isTargetPresent(txt_OrderQuantity.replace("<#>", upcName[i]))){
			log("Enter Order Quantity:"+orderQuantity[i],LogType.STEP);
			getCommand().sendKeys(txt_OrderQuantity.replace("<#>", upcName[i]),orderQuantity[i]);
			//getCommand().waitForTargetVisible(link_MarkSearch.replace("<#>",upcName[i]));
			new SupportFunctions().keyBoardEvent();
			getCommand().waitFor(3);
		 }
		}
		return this;
	}
	public ListPage enterQuantityOrderGuide(String upcName,String orderQuantity)
	{
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			enterTypeInSearchBox(upcName);
		getCommand().waitForTargetPresent(txt_OrderQuantity.replace("<#>", upcName));
		if(getCommand().isTargetPresent(txt_OrderQuantity.replace("<#>", upcName))){
			log("Enter Order Quantity:"+orderQuantity,LogType.STEP);
			getCommand().sendKeys(txt_OrderQuantity.replace("<#>", upcName),orderQuantity);
			getCommand().waitFor(5);
			String img_xpath="//*[@id='"+upcName+"-CS']/td[28]/img";
			System.out.println("Image present"+img_xpath);
			getCommand().waitForTargetVisible(imag_Order.replace("<#>",img_xpath));
		 }
		
		return this;
	}
	public ListPage checkOnItem(String[] upcName){
		for(int i=0;i<upcName.length;i++){
			enterTypeInSearchBox(upcName[i]);
		getCommand().waitForTargetPresent(chk_Item.replace("<#>",upcName[i]));
		if(getCommand().isTargetPresent(chk_Item.replace("<#>",upcName[i]))){

			log("Click On Check Box Of Item Number:"+upcName[i],LogType.STEP);	
			getCommand().click(chk_Item.replace("<#>",upcName[i]));
		}
		}
		return this;
		
	}
	public ListPage clickOnViewOrder(){
		if(getCommand().isTargetPresent(btn_ViewOrder)){
			log("Click On View Order",LogType.STEP);
			getCommand().click(btn_ViewOrder);
		}
		return this;
	}
	public ListPage clickOnSubmitOrder(){
		if(getCommand().isTargetPresent(btn_submit)){
			log("Submitted Successfully",LogType.STEP);
			getCommand().click(btn_submit);
		}
		return this;
   }
	public ListPage clickOnMyListLink(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(getCommand().isTargetPresent(link_MyList)){
			log("Click on MyList",LogType.STEP);
			getCommand().click(link_MyList);
		}
		getCommand().waitFor(3);
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		return this;
   }
	public ListPage clickOnShareListLink(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(getCommand().isTargetPresent(link_ShareList)){
			log("Click On ShareList",LogType.STEP);
			getCommand().click(link_ShareList);
			getCommand().waitFor(3);
		}
		return this;
   }
	public ListPage clickOnSyscoRecommendedLink(String syscoList){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(getCommand().isTargetPresent(link_SyscoList)){
			log("Click On SyscoList",LogType.STEP);
			getCommand().click(link_SyscoList);
			//listNumber=syscoList;
		}
		return this;
   }
	public ListPage clickOnListTab(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(tab_List);
		if(getCommand().isTargetPresent(tab_List)){
			log("Click On List Tab",LogType.STEP);
			getCommand().click(tab_List);
			(new SupportFunctions()).waitForStatic(3);
		}
		return this;
	}
	public ListPage clickOnAnyListNumber(String key){
		(new SupportFunctions()).waitForLoading(1000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitFor(10);
		getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement element = getCommand().getDriver().findElement(By.xpath("//a[@title='"+(String)getCommand().retrieveValue(key)+"']"));
        JavascriptExecutor executor = (JavascriptExecutor)getCommand().getDriver();
        executor.executeScript("arguments[0].click();", element);
        log("Click On List:"+(String)getCommand().retrieveValue(key),LogType.STEP);
        
	    /*getCommand().waitForTargetVisible(btn_list.replace("<#>",(String)getCommand().retrieveValue(key)));
	    getCommand().scrollTo(btn_list.replace("<#>", (String)getCommand().retrieveValue(key)));
	    if(getCommand().isTargetPresent(btn_list.replace("<#>",(String)getCommand().retrieveValue(key)))){
	    	getCommand().click(btn_list.replace("<#>", (String)getCommand().retrieveValue(key)));
	    	log("Click On List:"+(String)getCommand().retrieveValue(key),LogType.STEP);
	    }*/
	  //Waiting For The Element To Be Loaded in i.e browser only
	    (new SupportFunctions()).waitForStatic(3);
	    (new SupportFunctions()).waitForLoading(1000, By.xpath("//*[@id='asyncLoadingMessageText']"));
	
	    return this;
	}
	
	public ListPage clickOnAnyListNumberwithId(String key){
		(new SupportFunctions()).waitForLoading(1000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitFor(10);
		getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement element = getCommand().getDriver().findElement(By.xpath("//a[@id='"+(String)getCommand().retrieveValue(key)+"']"));
        JavascriptExecutor executor = (JavascriptExecutor)getCommand().getDriver();
        executor.executeScript("arguments[0].click();", element);
        log("Click On List:"+(String)getCommand().retrieveValue(key),LogType.STEP);
        
	    /*getCommand().waitForTargetVisible(btn_list.replace("<#>",(String)getCommand().retrieveValue(key)));
	    getCommand().scrollTo(btn_list.replace("<#>", (String)getCommand().retrieveValue(key)));
	    if(getCommand().isTargetPresent(btn_list.replace("<#>",(String)getCommand().retrieveValue(key)))){
	    	getCommand().click(btn_list.replace("<#>", (String)getCommand().retrieveValue(key)));
	    	log("Click On List:"+(String)getCommand().retrieveValue(key),LogType.STEP);
	    }*/
	  //Waiting For The Element To Be Loaded in i.e browser only
	    (new SupportFunctions()).waitForStatic(3);
	    (new SupportFunctions()).waitForLoading(1000, By.xpath("//*[@id='asyncLoadingMessageText']"));
	
	    return this;
	}
	public ListPage verifyEditListInSyscoList(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		   getCommand().getDriver().manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		  System.out.println("status====================="+getCommand().getDriver().findElement(By.xpath("//input[@id='editListButtonTop']")).getAttribute("class"));
		   if(getCommand().getDriver().findElement(By.xpath("//input[@id='editListButtonTop']")).getAttribute("class").contains("sali disablelink")){
			   log("Edit List In Sysco List Is Disabled",LogType.STEP);
		   }else{
			   SoftAssertion.fail("Failed::Edit List In Sysco List Is Enabled");
		   }
		return this;
	}
	public ListPage verifyEditListInMyList(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		   getCommand().getDriver().manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		   if(getCommand().getDriver().findElement(By.xpath("//input[@id='editListButtonTop']")).isEnabled()){
			   log("Edit List In My List Is Enabled",LogType.STEP);
		   }else{
			   SoftAssertion.fail("Failed::Edit List In My List Is Disabled");
		   }
		return this;
	}
	public ListPage verifyEditListInSharedList(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		   getCommand().getDriver().manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		   if(getCommand().getDriver().findElement(By.xpath("//input[@id='editListButtonTop']")).getAttribute("class").equals("sali disablelink")){
			   log("Edit List In Shared List Is Enabled",LogType.STEP);
		   }else{
			   SoftAssertion.fail("Failed::Edit List In Shared List Is Disabled");
		   }
		return this;
	}
	/*public ListPage clickOnSecondListNumber(){
		//Click On List Number To Add Items In Another List
	    getCommand().waitForTargetPresent(btn_list.replace("<#>", listNumber2));
	    getCommand().scrollTo(btn_list.replace("<#>", listNumber2));
	    if(getCommand().isTargetPresent(btn_list.replace("<#>", listNumber2))){
	    	getCommand().click(btn_list.replace("<#>", listNumber2));
	    	log("Click On List:"+listNumber2,LogType.STEP);
	    }
	  //Waiting For The Element To Be Loaded in i.e browser only
	    (new SupportFunctions()).waitForStatic(3);
	
	    return this;
	}
	public ListPage clickOnOtherExistingList(){
		getCommand().waitForTargetPresent(btn_Existinglist.replace("<#>", listNumber2));
	    if(getCommand().isTargetPresent(btn_Existinglist.replace("<#>", listNumber2))){
	    	getCommand().click(btn_Existinglist.replace("<#>", listNumber2));
	    	log("Click On List:"+listNumber,LogType.STEP);
	    }

		return this;
	}*/
	/*public ListPage enterQuantityList(){
		getCommand().waitForTargetPresent(txt_Orderquantity.replace("<#>", ));
		if(getCommand().isTargetPresent()){
			getCommand().click(txt_Orderquantity).clear(txt_Orderquantity).sendKeys(txt_Orderquantity, CaseQuantity);
		}
		return this;
	}*/
	public ListPage selectUseListQuantityFromDropDown(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		(new SupportFunctions()).selectDropDownValue(By.xpath("//*[@id='moreListToolsTop']"),"useListQtyTop");
	    log("'Use List Quantity Is Selected'",LogType.STEP);
	    getCommand().waitFor(3);
	   // getCommand().getDriver().findElement(By.xpath("//*[@id='confirmUseListQtyButton']")).click();
	    //log("Click On Yes On Use List Qunatity Pop up",LogType.STEP);
     	return this;
		
	}
	public ListPage validateUseListQunatity(String[] upc){
		for(int i=0;i<upc.length;i++){
		getCommand().waitFor(3);
		String path="//*[@title='"+upc[i]+"']";
		int size=getCommand().getDriver().findElements(By.xpath(path)).size();
		if(size!=0){
			log(upcNumber+" Is Arranged According To Use List:",LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed::"+upc[i]+"  Is Not Arranged According To Use List:");
		}
		}
		return this;
	}
	public ListPage clickOnAddToList(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		//Waiting For The Element To Be Loaded in i.e browser only
		   getCommand().waitFor(3);
		getCommand().waitForTargetVisible(btn_AddToList);
		if(getCommand().isTargetPresent(btn_AddToList)){
			log("Click To Add In List",LogType.STEP);
			getCommand().click(btn_AddToList);
		}
		return this;
	}
	
	public ListPage clickOnCreateNewListLink(){
		getCommand().waitForTargetPresent(link_CreateNewList);
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		   getCommand().waitFor(3);
		if(getCommand().isTargetPresent(link_CreateNewList)){
			log("Click To Create New List",LogType.STEP);
			getCommand().click(link_CreateNewList);
		}
		return this;
	}
	public ListPage clickOnCancelOnAddToListPopUp(){
		getCommand().waitForTargetPresent(btn_CancelAddToList);
		if(getCommand().isTargetPresent(btn_CancelAddToList)){
			log("Click On Cancel Add To List",LogType.STEP);
			getCommand().click(btn_CancelAddToList);
		}
		return this;
	}
	/*public void listName(){
		ArrayList srrData = new SupportFunctions().retrieveData("Select CAMSLC,CAITEM from ESPGCATF where CAMSLC=100");
	    System.out.println("ResultSet : " +srrData);
	    ArrayList arrFirstRow = (ArrayList)srrData.get(0);
	    System.out.println("First Item : " +arrFirstRow.get(1));
	    System.out.println("Item Price : " +arrFirstRow.get(0));
	}*/
	public ListPage clickOnConform(){
		getCommand().waitForTargetVisible(btn_Conform);
		if(getCommand().isTargetPresent(btn_Conform)){
			log("Click On Conform To Add Item In Created List ",LogType.STEP);
			getCommand().click(btn_Conform);
			 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		}
		(new SupportFunctions()).waitForStatic(3);
		return this;
	}
	public static  String itemNumberFromDatabase(){
		ArrayList srrData = new SupportFunctions().retrieveData("Select B6ORNO from OPNJB6L0");
		System.out.println("ResultSet : " +srrData);
	    ArrayList arrFirstRow = (ArrayList)srrData.get(0);
	    String itemNumber=(String) arrFirstRow.get(0);
	    System.out.println("Item Number : " +itemNumber);
      	return itemNumber;
		
	}
	public ListPage clickOnCreateNewList(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(getCommand().isTargetPresent(btn_NewList)){
			log("Click On Create New List",LogType.STEP);
			getCommand().click(btn_NewList);
		}
		return this;
	}
	public ListPage enterListName(String tcID){
		if(getCommand().isTargetPresent(txt_NewListName)){
			String listName=RandomStringUtils.randomAlphanumeric(10);
			getCommand().storeValue(tcID, listName);
			log("Enter List Name:"+listName,LogType.STEP);
			getCommand().clear(txt_NewListName).sendKeys(txt_NewListName,listName);
		}
		return this;
	}
	public ListPage enterDuplicateListName(String tcID){
		if(getCommand().isTargetPresent(txt_NewListName)){
			log("Enter List Name:"+(String)getCommand().retrieveValue(tcID),LogType.STEP);
			getCommand().clear(txt_NewListName).sendKeys(txt_NewListName,(String)getCommand().retrieveValue(tcID));
		}
		return this;
	}
	public ListPage enterListNameInPopup(String tcID){
		if(getCommand().isTargetPresent(txt_NewListNameInProductInfoWindow)){
			String listName=RandomStringUtils.randomAlphanumeric(10);
			getCommand().storeValue(tcID, listName);
			log("Enter List Name:"+listName,LogType.STEP);
			getCommand().clear(txt_NewListNameInProductInfoWindow).sendKeys(txt_NewListNameInProductInfoWindow,listName);
		}
		return this;
	}
	public ListPage getListNumber(String key){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		String listNumber=getCommand().getText(txt_ListNumber);
		getCommand().storeValue(key,listNumber);
		log("List Number:"+listNumber,LogType.STEP);
		return this;
	}
	 public ListPage verifyList(){
		  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		  getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  if(getCommand().getDriver().findElement(By.xpath("//*[@id='listTab']")).isDisplayed()){
			  log("List Button Is Displayed",LogType.STEP);
		  }else{
			  SoftAssertion.fail("Failed::List Button Is Not Displayed");
		  }
		  return this;
		 
	  }
	public ListPage clickOnCreateList(){
		if(getCommand().isTargetPresent(btn_CreateList)){
			log("Click on Create Order",LogType.STEP);
			getCommand().click(btn_CreateList);
			//Waiting For The Element To Be Loaded in i.e browser only
			   (new SupportFunctions()).waitForStatic(3);
			(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='createNewListDiv']"));
		}
		return this;
    }
	public ListPage saveItemNumber(){
		arr.add(listNumber);
		return this;
	}
	public ListPage validateListNameInMyList(String tcID){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		String path="//a[@id='"+(String)getCommand().retrieveValue(tcID)+"']";
	    if(!getCommand().getDriver().findElements(By.xpath(path)).isEmpty()){
	    	log("'"+(String)getCommand().retrieveValue(tcID)+"' Is found In MyList",LogType.STEP);
	    }else{
	    	SoftAssertion.fail("Failed:'"+(String)getCommand().retrieveValue(tcID)+"' Is Not found In MyList");
	    }
		return this;
	}
	public ListPage validateListNameInSaveList(String tcID){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		String path="//a[@title='"+getCommand().retrieveValue(tcID)+"']";
	    if(!getCommand().getDriver().findElements(By.xpath(path)).isEmpty()){
	    	log("'"+getCommand().retrieveValue(tcID)+"' Is found In MyList",LogType.STEP);
	    }else{
	    	SoftAssertion.fail("Failed:"+"'"+getCommand().retrieveValue(tcID)+"' Is Not found In MyList");
	    }
		return this;
	}
	public ListPage validateListNameInMyListAfterDelete(String key){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		String path="//a[@title='"+(String)getCommand().retrieveValue(key)+"']";
	    if(getCommand().getDriver().findElements(By.xpath(path)).size()==0){
	    	log("'"+(String)getCommand().retrieveValue(key)+"' Is Not found In MyList After Delete",LogType.STEP);
	    }else{
	    	SoftAssertion.fail("Failed:"+"'"+(String)getCommand().retrieveValue(key)+"' Is Not found In MyList After Delete");
	    }
		return this;
	}
	public ListPage validateListNameInSharedList(String key){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		String path="//a[@id='"+(String)getCommand().retrieveValue(key)+"']";
	    if(!getCommand().getDriver().findElements(By.xpath(path)).isEmpty()){
	    	log("'"+(String)getCommand().retrieveValue(key)+"' Is found In SharedList",LogType.STEP);
	    }else{
	    	SoftAssertion.fail("Failed:"+"'"+(String)getCommand().retrieveValue(key)+"' Is Not found In SharedList");
	    }
		return this;
	}
	public ListPage validateListNameInSharedListNewUser(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		String path="//a[@title='"+listName+"']";
	    if(!getCommand().getDriver().findElements(By.xpath(path)).isEmpty()){
	    	log("'"+listName+"' Is found In SharedList",LogType.STEP);
	    }else{
	    	SoftAssertion.fail("Failed:"+"'"+listName+"' Is Not found In SharedList");
	    }
		return this;
	}
	public ListPage validateSharedListNumberInMyList(int ref){
		ArrayList srrData = new SupportFunctions().retrieveData("SELECT NKCUSL from ESLHNKTF where NKCUNO='        108761'");
		for(int i=0;i<srrData.size();i++){
			ArrayList arrFirstRow = (ArrayList)srrData.get(i);
		    String s=(String) arrFirstRow.get(i);
		    //Comparing Sysco lists created for first user
		    if(ref==1){
		    	if(arr.get(0).equals(s)){
		    		log("List number:"+arr.get(0)+" Is Found In ShareList",LogType.STEP);
		    	}
		    	else{
		    		 SoftAssertion.fail("Failed::Not Found In Shared List");
		    	}
		    }
		  //Comparing Sysco lists created for second user
		    else if(ref==2){
		    	if(arr.get(1).equals(s)){
			    	   log("List number:"+arr.get(1)+" Is Found In SharedList",LogType.STEP);
			    	}else{
			    		SoftAssertion.fail("Failed::Not Found In Shared List");
			    	}
		    	}
		    }
	  return this;
	}
	public ListPage verifyEditList(){
		if(getCommand().getDriver().findElement(By.xpath("//input[@id='editListButtonTop']")).isEnabled()){
			log("Edit_list_option Is Enabled",LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed::Edit_list_option Is Enabled");
		}
		return this;
	}
	public ListPage clickOnAddToListInProductInfoWindow(){
		getCommand().waitFor(5);
		//if(getCommand().isTargetVisible(btn_AddToListInProductWindow)){
		System.out.println("Hai");
		if(getCommand().isTargetPresent(btn_AddToListInProductWindow)){
			log("Click On add_To_List",LogType.STEP);
			getCommand().click(btn_AddToListInProductWindow);
			//Waiting For The Element To Be Loaded in i.e browser only
			   (new SupportFunctions()).waitForStatic(3);
			  	

		}
		return this;
    }
	public ListPage clickOnCreateNewListInProductInfoWindow(){
		getCommand().waitFor(3);
		if(getCommand().isTargetPresent(btn_CreateNewListInProductWindow)){
			log("Click On Create New List",LogType.STEP);
			getCommand().click(btn_CreateNewListInProductWindow);
			  	

		}
		return this;
    }
	public ListPage clickOnCreatNewListInAddListPopup(){
		getCommand().waitForTargetVisible(btn_CreateNewList);
		if(getCommand().isTargetPresent(btn_CreateNewList)){
			getCommand().waitFor(3);
			log("Click On Create New List",LogType.STEP);
			getCommand().click(btn_CreateNewList);
			(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='createNewListPopUpInCopy']"));
			//Waiting For The Element To Be Loaded in i.e browser only
			   (new SupportFunctions()).waitForStatic(3);
			  	

		}
		return this;
    }
	public ListPage clickOnCreateNewListPopup(){
		if(getCommand().isTargetPresent(btn_CreateListInProductWindow)){
			log("Click On Create  List",LogType.STEP);
			getCommand().click(btn_CreateListInProductWindow);
			getCommand().waitFor(3);
			  	

		}
		return this;
    }
	public ListPage validateListNumberInAnyList(){
		ArrayList srrData = new SupportFunctions().retrieveData("SELECT NKCUSL from ESLHNKTF where NKCUNO='        108761'");
		for(int i=0;i<srrData.size();i++){
			ArrayList arrFirstRow = (ArrayList)srrData.get(i);
		    String s=(String) arrFirstRow.get(i);
		    //Comparing created list in sysco list
		    	if(listNumber.equals(s)){
		    		log("List number:"+listNumber+" Is Found In Share List",LogType.STEP);
		    	}else{
		    		SoftAssertion.fail("Failed::Not Found In Shared List");
		    	}
		    }
	  return this;
	}
	public ListPage selectDeleteListFromDropDown(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		(new SupportFunctions()).selectDropDownValue(By.xpath("//*[@id='moreListToolsTop']"),"deleteList");
			log("Select Delete List From DropDown",LogType.STEP);
		   return this;
	}
	public ListPage clickOnCancelInDeleteListPopup(){
		getCommand().getDriver().manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
        WebElement element = getCommand().getDriver().findElement(By.xpath("//*[@value='Cancel']"));
        JavascriptExecutor executor = (JavascriptExecutor)getCommand().getDriver();
        executor.executeScript("arguments[0].click();", element);
		log("Click On Cancel Button",LogType.STEP);
		return this;
	}
	public ListPage validateDeleteListPopupAfterCancel(){
		getCommand().getDriver().manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
        if(!getCommand().getDriver().findElement(By.xpath("//*[@id='deletelistpopupdiv']")).isDisplayed()){
        	log("Delete List Pop up Disappeared",LogType.STEP);

        }else{
        	SoftAssertion.fail("Failed::Delete List Pop up Not Disappeared After Cancel");
        }
		return this;
	}

	public ListPage clickOnDeleteInDeleteListPopup(){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		getCommand().getDriver().findElement(By.xpath("//*[@id='deletelist']")).click();
		log("Click On Delete Button In Delete List Pop up",LogType.STEP);
		return this;
	}
	public ListPage getUpcNumber(){
		//Getting item numbers from a particular  list
		ArrayList srrData = new SupportFunctions().retrieveData("SELECT NXITEM FROM ESLDNXTF WHERE NXCUSL='     "+listNumber+"'");
		for(int i=0;i<srrData.size();i++){
			ArrayList arrFirstRow = (ArrayList)srrData.get(i);
			String s=(String) arrFirstRow.get(i);
			upcNumber.add(s);
		}
		return this;
	}
	public ListPage enterOrderQuanity(String quantity){
		
		getCommand().waitForTargetPresent(txt_OrderQuantity.replace("<#>",upcNumber.get(0)));
		getCommand().clear(txt_OrderQuantity.replace("<#>",upcNumber.get(0))).sendKeys(txt_OrderQuantity.replace("<#>",upcNumber.get(0)),quantity);
		new SupportFunctions().keyBoardEvent();
		log("Enter Quantity For SUPC:"+upcNumber.get(0)+"="+quantity,LogType.STEP);
		
		return this;
	}
	public ListPage getItemNumberAndQuanity(){
		//Getting items number from a list and it's quantity
		System.out.println("ListNumber:"+listNumber);
		ArrayList upcData = new SupportFunctions().retrieveData("SELECT NXITEM FROM ESLDNXTF WHERE NXCUSL='     "+listNumber+"'");
		System.out.println(upcData);
		for(int i=0;i<upcData.size();i++){
		ArrayList arrUPC = (ArrayList)upcData.get(i);
		String upc=(String)arrUPC.get(0);
		upcNumber.add(upc);
		
		}
		System.out.println("UPCS:"+upcNumber);
		return this;
		
	}
	public ListPage enterOrderQuantity(int ref,String[] upc,String[] quantity){
		if(ref==0){
		getCommand().waitForTargetPresent(txt_OrderQuantity.replace("<#>",upc[ref]));
		getCommand().clear(txt_OrderQuantity.replace("<#>",upc[ref])).sendKeys(txt_OrderQuantity.replace("<#>",upc[ref]),quantity[ref]);
		log("Enter Quantity For Upsc:"+upc[ref]+"========"+quantity[ref],LogType.STEP);
		//getCommand().getDriver().findElement(By.xpath(txt_OrderQuantity.replace("<#>",upc[ref]).getTargetValue())).sendKeys(Keys.ENTER);
	   }
		else if(ref==1){
			getCommand().waitForTargetPresent(txt_OrderQuantity.replace("<#>",upc[ref]));
			int q=Integer.parseInt(quantity[ref]);
			getCommand().clear(txt_OrderQuantity.replace("<#>",upc[ref])).sendKeys(txt_OrderQuantity.replace("<#>",upc[ref]),(q+1)+"");
			log("Enter Quantity For Upsc:"+upc[ref]+"========="+(q+1),LogType.STEP);
		}
		else if(ref==2){
			getCommand().waitForTargetPresent(txt_OrderQuantity.replace("<#>",upc[ref]));
			int p=Integer.parseInt(quantity[ref]);
			getCommand().clear(txt_OrderQuantity.replace("<#>",upc[ref])).sendKeys(txt_OrderQuantity.replace("<#>",upc[ref]),(p-1)+"");
			log("Enter Quantity For Upsc:"+upc[ref]+"========"+(p-1),LogType.STEP);
		}
		return this;
 
	}
	public ListPage checkDropDowninList(String[] toolsMenu){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		List<WebElement> dropDownMenu=(new SupportFunctions()).getDropdownList(By.xpath("//*[@id='moreListToolsTop']"));
		for(int i=0;i<dropDownMenu.size();i++){
			String menu=dropDownMenu.get(i).getText();
			if(!dropDownMenu.get(i).isEnabled()){
				log(menu+" Is Disabled",LogType.STEP);
			}
			if(menu.equals(toolsMenu[i]))
			{
				log(menu+" Is Verified",LogType.STEP);
		    }
			else{
				SoftAssertion.fail("Failed::"+menu+" Is Not Verified");
			}
		}
		return this;
	
	}
	public ListPage selectPrintListFromDropDown(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		(new SupportFunctions()).selectDropDownValue(By.xpath("//*[@id='moreListToolsTop']"),"printList");
			log("Print_list Is Displayed",LogType.STEP);
			//Waiting For The Element To Be Loaded in i.e browser only
			  (new SupportFunctions()).waitForStatic(3);
			getCommand().getDriver().findElement(By.xpath("//button[contains(@class,'cancel')]")).click();
			log("Click On Cancel Button",LogType.STEP);
			return this;
	}
	public ListPage selectCopyListFromDropDown(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		(new SupportFunctions()).selectDropDownValue(By.xpath("//*[@id='moreListToolsTop']"),"duplicateTop");
			log("Copy_List Is Displayed",LogType.STEP);
			//Waiting For The Element To Be Loaded in i.e browser only
			  (new SupportFunctions()).waitForStatic(3);
			  getCommand().waitFor(3);
			//getCommand().getDriver().findElement(By.xpath("//*[@id='cancelCopyToListButton']/input")).click();
			JavascriptExecutor executor = (JavascriptExecutor)getCommand().getDriver();
			executor.executeScript("arguments[0].click();", getCommand().getDriver().findElement(By.xpath("//*[@id='cancelCopyToListButton']/input")));
			log("Click On Cancel Button",LogType.STEP);
			return this;
	}
	public ListPage selectExportListFromDropDown(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		(new SupportFunctions()).selectDropDownValue(By.xpath("//*[@id='moreListToolsTop']"),"exportList");
			log("Export_List Is Displayed",LogType.STEP);
			//Waiting For The Element To Be Loaded in i.e browser only
			return this;
	}
	public ListPage clickCancelOnExport(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		(new SupportFunctions()).waitForStatic(3);
		//getCommand().waitForTargetPresent(btn_CancelInToolsList);
		//getCommand().getDriver().findElement(By.xpath("html/body/div[37]/div[3]/div/button[1]")).click();
		JavascriptExecutor executor = (JavascriptExecutor)getCommand().getDriver();
		executor.executeScript("arguments[0].click();", getCommand().getDriver().findElement(By.xpath("//*[@aria-disabled='false'][1]")));
		log("Click On Cancel Button",LogType.STEP);
		return this;
	}
	public ListPage selectSendListFromDropDown(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		(new SupportFunctions()).selectDropDownValue(By.xpath("//*[@id='moreListToolsTop']"),"reassign");
			log("Send_List Is Displayed",LogType.STEP);
			//Waiting For The Element To Be Loaded in i.e browser only
			  (new SupportFunctions()).waitForStatic(3);
			  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			  //getCommand().getDriver().findElement(By.xpath("html/body/div[37]/div[3]/div/button[1]")).click();
			  JavascriptExecutor executor = (JavascriptExecutor)getCommand().getDriver();
			  (new SupportFunctions()).waitForStatic(3);
				executor.executeScript("arguments[0].click();", getCommand().getDriver().findElement(By.xpath("html/body/div[37]/div[3]/div/button[1]")));
			log("Click On Cancel Button",LogType.STEP);
			return this;
	}
	public ListPage checkDropDownInExportList(String[] menuExport){
		List<WebElement> dropDownMenu=(new SupportFunctions()).getDropdownList(By.xpath("//*[@id='expFormat']"));
		System.out.println(dropDownMenu);
		for(int i=0;i<dropDownMenu.size();i++){
			String menu=dropDownMenu.get(i).getText();
			if(menu.contains(menuExport[i])){
			log(menu+" Is Present ",LogType.STEP);
			}else{
				SoftAssertion.fail(menu+" Is Not Present ");
			}
		}
		
		return this;
	
	}
	public ListPage clickOnImportList(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(getCommand().isTargetPresent(btn_ImportList)){
			log("click on Import List",LogType.STEP);
			getCommand().click(btn_ImportList);
		}
		return this;
	}
	public ListPage clickOnCancelImportList(){
		getCommand().waitForTargetPresent(btn_CancelImportOrder);
		if(getCommand().isTargetPresent(btn_CancelImportOrder)){
			log("Click To Cancel Import List",LogType.STEP);
			getCommand().click(btn_CancelImportOrder);
		}
		return this;
	}
	public ListPage getListNumberInMyList(String userName){
		//getting list number in my_list
		ArrayList srrData = new SupportFunctions().retrieveData("SELECT NKCUSL FROM ESLHNKTF WHERE 	='"+userName+"'");
		ArrayList arrFirstRow = (ArrayList)srrData.get(0);
		listNumber=(String) arrFirstRow.get(0);
		return this;
	}
	public ListPage clickOnBrowseButton(){
		getCommand().getDriver().findElement(By.xpath("//*[@id='importListBrowser']/input")).click();
		log("Click On Browse Button",LogType.STEP);
		return this;
	}
	public ListPage clickOnImportListButton(){
		getCommand().getDriver().findElement(By.xpath("//*[@id='importListBtn']")).click();
		log("Click On Import Button",LogType.STEP);
		return this;
	}
	public ListPage uploadFiles(String fileName){
		String strFilePath = null;
		StringSelection ss = new StringSelection("D:\\ESYSCO_PROJECT\\TestData\\Files\\export.csv");
		//strFilePath =TestProperties.getProperties("testdata.path") + "Files" + strFile;
		return this;
	}
	public ListPage getGroupItemsDropDown(String[] syscoDropdown){
		(new SupportFunctions()).waitForLoading(1000, By.xpath("//*[@id='asyncLoadingMessageText']"));
		List<WebElement> dropDownMenu=(new SupportFunctions()).getDropdownList(By.xpath("//*[@id='groupByCategoryButtonTop']"));
		for(int i=0;i<dropDownMenu.size();i++){
			String menu=dropDownMenu.get(i).getText();
			if(menu.equals(syscoDropdown[i]))
			{
				log(menu+" Is Verified",LogType.STEP);
		    }
			else{
				SoftAssertion.fail("Failed::"+menu+" Is Not Displayed");
			}
		}
		return this;
	
	}
   public ListPage selectFromGroupBy(String groupBy) {
	  (new SupportFunctions()).selectDropDownValue(By.xpath("//*[@id='groupByCategoryButtonTop']"), groupBy);
	    log("Group By:"+groupBy,LogType.STEP);
		return this;
	}
   public ListPage validatGroupByDontGroup(){
	   //Waiting For The Element To Be Loaded in i.e browser only
	   (new SupportFunctions()).waitForStatic(3);
	   getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	   if(getCommand().getDriver().findElements(By.xpath("//*[@id='category0']/td")).isEmpty()){
    		   log("Group By 'Do Not Group' Is Validated",LogType.STEP);
    	   }else{
    		  SoftAssertion.fail("Failed::Group By 'Do Not Group' Is Not Validated"); 
    	   }
 
    	   return this;
   }
   public ListPage validatGroupBySysoCategories(){
	   //Waiting For The Element To Be Loaded in i.e browser only
	   (new SupportFunctions()).waitForStatic(3);
	      getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	   if(!getCommand().getDriver().findElements(By.xpath("//*[@aria-describedby='viewListGrid_cb']")).isEmpty()){
    		   log("Group By 'Sysco Categories' Is Validated",LogType.STEP);
    	   }else{
    		  SoftAssertion.fail("Failed::Group By 'Sysco Categories' Is Not Validated"); 
    	   }
         
    	   return this;
   }
    public ListPage validatGroupByMyCategories(){
    	 //Waiting For The Element To Be Loaded in i.e browser only
    	   (new SupportFunctions()).waitForStatic(3);
	      getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	   if(!getCommand().getDriver().findElements(By.xpath("//*[@aria-describedby='viewListGrid_cb']")).isEmpty()){
    		   log("Group By 'My Categories' Is Validated",LogType.STEP);
    	   }else{
    		  SoftAssertion.fail("Failed::Group By 'My Categories' Is Not Validated"); 
    	   }
         
    	   return this;
   }
	
	public ListPage getListNumberFromDB(){
		//Getting All List Number From DB
		ArrayList srrData = new SupportFunctions().retrieveData("SELECT NKCUSL from ESLHNKTF where NKCUNO='        108761'");
		ArrayList arrFirstRow = (ArrayList)srrData.get(0);
		listNumber=(String) arrFirstRow.get(0);
		return this;
	}
	public ListPage clickOnEditList(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
		getCommand().getDriver().findElement(By.xpath("//input[@id='editListButtonTop']")).click();
		log("Click On Edit List",LogType.STEP);
		return this;
	}
	public ListPage selectAllListInEditList(){
		getCommand().waitFor(3);
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
		getCommand().getDriver().findElement(By.xpath("//input[@class='checkallforslickgrid']")).click();
		log("Select All Items On Edit List",LogType.STEP);
		return this;
	}
	public ListPage deleteAllSelectedList(){
		getCommand().waitFor(3);
		getCommand().getDriver().manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
		WebElement element=getCommand().getDriver().findElement(By.xpath("//input[@id='deleteListItems']"));
		JavascriptExecutor executor = (JavascriptExecutor)getCommand().getDriver();
		executor.executeScript("arguments[0].click();", element);
		log("Delete All Selected  Items On Edit List",LogType.STEP);
		return this;
		
	}
	public ListPage validateDeletedList(String[] upcs){
			(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			getCommand().getDriver().manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			for(int i=0;i<upcs.length;i++){
				//Enter UPC in Search Box
				String path="//*[@id='"+upcs[i].trim()+"-CS']/td[19]";
		     getCommand().getDriver().findElements(By.xpath(path)).size();
			if(getCommand().getDriver().findElements(By.xpath(path)).isEmpty()){
				log(upcs[i]+" Is Deleted From List",LogType.STEP);
			}else{
				SoftAssertion.fail(upcs[i]+" Is Not Deleted From List");
			}
			}
			return this;
	}
	public ListPage enterListQuantity(String[] upcNumber,String[] quantity){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		for(int i=0;i<upcNumber.length;i++){
		/*//Waiting For The Element To Be Loaded in i.e browser only
	   (new SupportFunctions()).waitForStatic(3);*/
		getCommand().waitForTargetPresent(txt_ListQuantity.replace("<#>",upcNumber[i]));
		getCommand().clear(txt_ListQuantity.replace("<#>",upcNumber[i])).sendKeys(txt_ListQuantity.replace("<#>",upcNumber[i]),quantity[i]);
		new SupportFunctions().keyBoardEvent();
		log("Enter Quantity For Upsc:"+upcNumber[i]+"="+quantity[i],LogType.STEP);
		}
		return this;
	}
	public ListPage clickOnSaveList(){
		getCommand().waitFor(3);
		getCommand().getDriver().manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		WebElement element=getCommand().getDriver().findElement(By.xpath("//*[@id='saveListbtn']"));
		JavascriptExecutor executor = (JavascriptExecutor)getCommand().getDriver();
		executor.executeScript("arguments[0].click();", element);
		log("Click On Save List",LogType.STEP);
		getCommand().getDriver().findElement(By.xpath("//*[@id='publishList']")).click();
		log("Click On Yes On Save List Pop up",LogType.STEP);
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		return this;
	}
	public ListPage clickOnSaveList1()
	{
		getCommand().waitFor(3);
		getCommand().getDriver().manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		//WebElement element1=getCommand().getDriver().findElement(By.xpath("//*[@id='saveListbtn']"));
		getCommand().click(savelist1);
		getCommand().waitFor(2);
		getCommand().waitForTargetPresent(save_lstPop);
		//getCommand().isTargetPresent(save_lstPop);
		getCommand().click(savelist2);
		
		return this ;
	}
	
	public ListPage verifyMoreListTool_DemoUser(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);
		if(getCommand().getDriver().findElements(By.xpath("//*[@id='editListButtonTop']")).isEmpty()){
			  log("Edit List Is Disabled",LogType.STEP);
		  }else{
			  SoftAssertion.fail("Failed::Edit List Is Enaabled");
		  }
			if(getCommand().getDriver().findElements(By.xpath("//*[@id='moreListToolsTop']/option[@value='duplicateTop']")).isEmpty()){
				log("Copy List Is Disabled",LogType.STEP);
			}
			else{
				SoftAssertion.fail("Failed::Copy List Is Enabled");
			}
			if(getCommand().getDriver().findElements(By.xpath("//*[@id='moreListToolsTop']/option[@value='reassign']")).isEmpty()){
				log("Sene List Is Disabled",LogType.STEP);
			}
			else{
				SoftAssertion.fail("Failed::Send List Is Enabled");
			}
			if(getCommand().getDriver().findElements(By.xpath("//*[@id='deleteListLink1']")).isEmpty()){
				log("Delete List Is Disabled",LogType.STEP);
			}
			else{
				SoftAssertion.fail("Failed::Delete List Is Enabled");
			}
	   return this;
		
	}
	public ListPage verifyListDemoUser(){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		if(!getCommand().getDriver().findElement(By.xpath("//*[@id='createNewListButton']")).isEnabled()){
			  log("Creat New List  Is Disabled",LogType.STEP);
		  }else{
			  SoftAssertion.fail("Failed::Creat New List Is Enabled");
		  }
		if(!getCommand().getDriver().findElement(By.xpath("//*[@id='importList']")).isEnabled()){
			  log("Import List Is Disabled",LogType.STEP);
		  }else{
			  SoftAssertion.fail("Failed::Import List Is Enabled");
		  }
		return this;
	}
	public ListPage getListNumberByListName(String key) {
		getCommand().getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        String path="//a[@title='"+getCommand().retrieveValue(key)+"']";
		String listNumber=getCommand().getDriver().findElement(By.xpath(path)).getAttribute("id");
		getCommand().storeValue(key,listNumber);
		log("List Number Is:"+listNumber,LogType.STEP);
        if(!listNumber.isEmpty()){
        	log(listName+" Is Found",LogType.STEP);
        }else{
        	log(listName+"Name Is Empty",LogType.STEP);
        }
        //Waiting For The Element To Be Loaded in i.e browser only
        (new SupportFunctions()).waitForStatic(3);
		return this;
	}
	public ListPage getListNumberForSyscoList(String listName,String key) {
		getCommand().getDriver().manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);

		String path="//a[@title='"+listName+"']";
		String listNumber=getCommand().getDriver().findElement(By.xpath(path)).getAttribute("title");
		getCommand().storeValue(key,listNumber);
        if(!listNumber.isEmpty()){
        	log(listName+" Is Found",LogType.STEP);
        }else{
        	log(listName+"Name Is Empty",LogType.STEP);
        }
        //Waiting For The Element To Be Loaded in i.e browser only
        (new SupportFunctions()).waitForStatic(3);
		return this;
	}
	
	public ListPage verifyItemsInList(String upcNumber){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		String path="//*[@title='"+upcNumber+"']";
		int size=getCommand().getDriver().findElements(By.xpath(path)).size();
		if(size!=0){
			log(upcNumber+" Is Displayed in List:"+listName,LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed::"+upcNumber+" Is Not Displayed in List:"+listName);
		}
		/*try{if(getCommand().isTargetPresent(txt_UPCName.replace("<#>", upcNumber))){
			log(upcNumber+" Is Displayed in List:"+listName,LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::"+upcNumber+" Is Not Displayed in List:"+listName);
		}
		}catch(Exception e){
			SoftAssertion.fail("Failed::"+upcNumber+" Is Not Displayed in List:"+listName);
		}*/
		return this;
	}
	public ListPage verifyMultpleItemsInList(String[] upcNumber) {
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
	    for(int i=0;i<upcNumber.length;i++){
		String path="//*[@title='"+upcNumber[i]+"']";
		int size=getCommand().getDriver().findElements(By.xpath(path)).size();
		if(size!=0){
			log(upcNumber[i]+" Is Displayed in List:"+listName,LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed::"+upcNumber[i]+" Is Not Displayed in List:"+listName);
		}
		/*try{
			if(getCommand().isTargetPresent(txt_UPCName.replace("<#>", upcNumber[i]))){
			log(upcNumber[i]+" Is Displayed in List:"+listName,LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::"+upcNumber[i]+" Is Not Displayed in List:"+listName);
		}
		}catch(Exception e){
			SoftAssertion.fail("Failed::"+upcNumber[i]+" Is Not Displayed in List:"+listName);
		}*/
	 }
	return this;
	}
	public ListPage checkItemsFromLists(String[] upcName){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		for(int i=0;i<upcName.length;i++){
		getCommand().scrollTo(btn_CheckOnItem.replace("<#>",upcName[i] ));
		getCommand().waitForTargetPresent(btn_CheckOnItem.replace("<#>",upcName[i] ));
		if(getCommand().isTargetPresent(btn_CheckOnItem.replace("<#>",upcName[i] ))){
			log("Check Item NO:"+upcName[i].toString(),LogType.STEP);
			getCommand().click(btn_CheckOnItem.replace("<#>",upcName[i] ));
		}}
		return this;
	}
	public ListPage checkItemsFromLists(String upcName){
		getCommand().scrollTo(btn_CheckOnItem.replace("<#>",upcName));
		getCommand().waitForTargetPresent(btn_CheckOnItem.replace("<#>",upcName ));
		if(getCommand().isTargetPresent(btn_CheckOnItem.replace("<#>",upcName ))){
			log("Check Item NO:"+upcName.toString(),LogType.STEP);
			getCommand().click(btn_CheckOnItem.replace("<#>",upcName));
		}
		return this;
	}
	public ListPage clickOnVisitListNow(){
		getCommand().waitForTargetPresent(btn_VisitlistNow);
		log("Click On Visit List Now",LogType.STEP);
		getCommand().click(btn_VisitlistNow);
		return this;
	}
	public ListPage verifyCreateListPopup(){
		if(getCommand().isTargetPresent(btn_CreateList)){
			log("Create List Button Is Present",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::Create List Button Is Not Present");
		}
		if(getCommand().isTargetPresent(btn_CancelInPopup)){
			log("Cancel Button Is Present",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::Cancel Button Is Not Present");
		}
		if(getCommand().isTargetPresent(txt_NewListNameInProductInfoWindow)){
			log("Text Box For List Page Is Present",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::Text Box For List Page Is Not Present");
		}
		return this;
	}
	public ListPage verifyDeleteListPopup(){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String deletedMsg=getCommand().getDriver().findElement(By.xpath("//*[@id='deletelistpopupdiv']/div[2]/div/div/div[1]")).getText();
		if(deletedMsg.contains("Are you sure you want to delete this list?")){
			log("'"+deletedMsg+"' Is Displayed",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::'Are you sure you want to delete this list?' Message Is Not Present");
		}
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='deletelist']")).isDisplayed()){
			log("Delete List Button Is Present",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::Delete List Button Is Not Present");
		}
		if(!getCommand().getDriver().findElements(By.xpath("//*[@id='dellistno_1']/input")).isEmpty()){
			log("Cancel List Button Is Displayed",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::Cancel List Button Is Not Dispalyed");
		}
		getCommand().waitFor(3);
		return this;
	}
	public ListPage clickOnSyscoLIst(String listName){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		String path="//a[@title=\""+listName+"\"]";
		getCommand().getDriver().findElement(By.xpath(path)).click();
		log("Click On List Name:"+listName,LogType.STEP);
		return this;
	}
	public ListPage clickOnSharedLIst(String listName){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		String path="//a[@title='"+listName+"']";
		getCommand().getDriver().findElement(By.xpath(path)).click();
		log("Click On List Name:"+listName,LogType.STEP);
		return this;
	}
	public ListPage validateNumberOfItemsInList() {
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		//Getting Number Of Items
		String textNumberItem=getCommand().getDriver().findElement(By.xpath("//span[@id='showAllItemsHeading']")).getText();
		int totalItems=Integer.parseInt((textNumberItem.split(" "))[2]);
		if(totalItems>=500){
			log("Total Number Of Items Added In List Name("+listName+") Are:"+totalItems,LogType.STEP);
		}
		else{
			 SoftAssertion.fail("Failed::Total Items:"+totalItems);
		}
		return this;
		
	}
	public ListPage clickOnExistingList(String tcID){
		 //Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		getCommand().waitForTargetPresent(btn_Existinglist.replace("<#>",(String)getCommand().retrieveValue(tcID)));
	    if(getCommand().isTargetPresent(btn_Existinglist.replace("<#>", (String)getCommand().retrieveValue(tcID)))){
	    	getCommand().click(btn_Existinglist.replace("<#>",(String)getCommand().retrieveValue(tcID)));
	    	log("Click On List:"+(String)getCommand().retrieveValue(tcID),LogType.STEP);
	    }
		return this;
	}
	public ListPage shareListWithUser(String userName,String permission){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		(new SupportFunctions()).selectDropDownValue(By.xpath("//*[@id='moreListToolsTop']"),"shareList");
			log("Share List is Selected",LogType.STEP);
			//Waiting For The Element To Be Loaded in i.e browser only
			getCommand().waitForTargetVisible(tbl_Users);
			(new SupportFunctions()).waitForStatic(1);
			//String userName = getCommand().retrieveValue(key + "_name").toString();
			//select the user
			//click on update button
			getCommand().click(lst_Users);	
			log("Check the user:"+userName,LogType.STEP);	
			
			new SupportFunctions().ScrollInToView(chk_User.replace("<#>",userName));			
			getCommand().click(chk_User.replace("<#>",userName));	
			(new SupportFunctions()).waitForStatic(1);
			
			String chkId = getCommand().getAttributeValue(chk_User.replace("<#>",userName), "id");
			String[] arrChkId=chkId.split("-");
			
			log("Provide Permission to User : "+userName,LogType.STEP);	
			String[] splitPerm=permission.split(";");
			for(int i=0;i<splitPerm.length;i++){
				if(splitPerm[i].equalsIgnoreCase("A") || splitPerm[i].equalsIgnoreCase("D") || splitPerm[i].equalsIgnoreCase("S")){
					log("Provide Permission :" + splitPerm[i] + " for User : "+userName,LogType.STEP);
					
					getCommand().click(chk_Perm.replace("<#>", splitPerm[i]).replace("<#>", splitPerm[i]).replace("<#>", arrChkId[1]));
				}else{
					log("No Permission provided to User : "+userName,LogType.STEP);	
				}
			}
			//click on update button
			getCommand().click(btn_Update);	
			
			(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			return this;
	}
	public ListPage verifyDeleteItemEnabled(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='loadingDiv11']"));
		log("Verify delete item button is enabled",LogType.STEP);
		if (!getCommand().getAttributeValue(btn_DeleteItem, "class").equals("sali inactivebtn")){
			SoftAssertion.fail("Failed::Delete Items button is enabled");
		}else{
			log("Delete Items button is disbled as expected",LogType.STEP);	
		}
		return this;
		
	}
public ListPage clickListsTab()
	
	{
		getCommand().waitForTargetPresent(list_tab);
		
		if(getCommand().isTargetPresent(list_tab))
		{
			getCommand().click(list_tab);
			log("List tab is presetn",LogType.STEP );
			(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			
			getCommand().click(btn_NewList);
			
			getCommand().click(lst_name);
			
		}
		return this;
	}
	
	public ListPage additemstolist()
	
	{
		return this;
	}
	public ListPage enterListNameInPopup1(String l1){
		if(getCommand().isTargetPresent(lst_name)){
			String listName=RandomStringUtils.randomAlphanumeric(10);
			getCommand().storeValue(l1, listName);
			log("Enter List Name:"+listName,LogType.STEP);
			getCommand().clear(lst_name).sendKeys(lst_name,listName);
			getCommand().click(btn_CreateList);
			//getCommand().waitFor(5);
			getCommand().waitFor(5);
			String listnum=getCommand().getText(lst_num);
			getCommand().storeValue("listnum1", listnum );
			System.out.println("list numm"+ listnum);
			
		}
		return this;
	
	}
	public ListPage selectAllItems()
	{
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		if(getCommand().isTargetPresent(selectall))
		{
			getCommand().click(selectall);
		}
		return this;
		
	}
	public ListPage includeItemStatus()
	{
		getCommand().waitForTargetPresent(itm_sts_chkbox);
		if(getCommand().isTargetPresent(itm_sts_chkbox))
		{
		log("item status check box is present", LogType.STEP);
		getCommand().click(itm_sts_chkbox);
		//getCommand().waitFor(5);
		}
		else
		{
			SoftAssertion.fail("Item status check box is not present");
		}
		getCommand().click(export_btn);
		getCommand().waitFor(5);
		return this;
	}
	public ListPage includeItemStatusinOG()
	{
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='expIncludePSMSCheckBox']")).isDisplayed())
			
		{
			SoftAssertion.fail("Item status check box is present");
			
		}
		else
		{
			log("item status check box is NOT present as expected", LogType.STEP);
		}
		return this;
	}
	public ListPage syscoList(String SL)
	{
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitFor(2);
		getCommand().click(lst_num2.replace("<#>", SL ));
		log("Sysco Lists is opened", LogType.STEP);
		
		return this;
	}
	public ListPage clickOnMultiAddValidation(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='multiAddValidation']")).isDisplayed()){
			log("Multi add validation pop up is displayed !!!please click on Ok button",LogType.STEP);
			getCommand().getDriver().findElement(By.xpath("(//button[@type='button'])[3]")).click();
			 
		}
		
		return this;
	}
	public ListPage clickOnSelectedSyscoList(String listName){
		System.out.println(listName);
		
		getCommand().getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(getCommand().getDriver().findElement(By.xpath("//a[contains(text(),'"+listName+"')]")).isDisplayed()){
			log("Sysco list "+listName+" is Present " ,LogType.STEP);
			log("Click on selected List " ,LogType.STEP);
			String slInk="//a[contains(text(),'"+listName+"')]";
			System.out.println("sLink==="+slInk);
			getCommand().getDriver().findElement(By.xpath(slInk)).click();
			(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			 
		}
		
		return this;
	}
	public ListPage searchOnPrductDescriptionInEditList (String xlItemDescription){
		//wait for load pop to be invisible
		  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		  //enterUPCInSearchBox(appupcName);
		//  getCommand().getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  String path="//*[contains(text(),'"+xlItemDescription.trim()+"')]";
			
		  getCommand().waitFor(3);
		  String itemDescription=getCommand().getDriver().findElement(By.xpath(path)).getText().toString();
		  if(itemDescription.trim().equals(xlItemDescription.trim()))
		  {
			  log("Verify whether CAKE product description is "+itemDescription+" getting displayed for the item  ",LogType.STEP); 
		  }
		  else
			{
				SoftAssertion.fail("Verify whether CAKE product description is  failed .Actual description is "+itemDescription);
			}

		  
		 return this;
	  }
	
	//*[contains(text(),'Cucumber Select Fresh')]
}
