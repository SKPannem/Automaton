package com.components.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.components.repository.SiteRepository;
import com.iwaf.framework.TestProperties;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.SoftAssertion;
import com.iwaf.framework.components.Target;

public class ProductCatalogPage extends SitePage {
	public static final Target btn_ViewOrder=new Target("btn_ViewOrder","//*[@id='viewActiveOrderBtn']",Target.XPATH);
	public static final Target btn_ProductTab=new Target("btn_ProductTab","//*[@id='productsTab']",Target.XPATH);
	public static final Target btn_NarrowResult=new Target("btn_NarrowResult","//font[@id='filterpdtsDiv_font']",Target.XPATH);
	public static final Target btn_ShowHidePrice=new Target("btn_ShowPrice","//*[@id='showHideButtonTop']",Target.XPATH);
	public static final Target btn_Print=new Target("btn_Print","//*[@id='printSearchResultsLink']/img",Target.XPATH);
	public static final Target btn_ResetFilter=new Target("btn_ResetFilter","//a[@id='resetFilterBtn']",Target.XPATH);
	public static final Target btn_StockIndicator=new Target("btn_StockIndicator","//*[@id='stockIndicatorHdr']",Target.XPATH);
	public static final Target btn_Category=new Target("btn_Category","//*[@id='categoryHdr']",Target.XPATH);
	public static final Target btn_Brand=new Target("btn_Brand","//*[@id='brandHdr1']",Target.XPATH);
	public static final Target btn_Storage=new Target("btn_Storage","//*[@id='storageHdr']",Target.XPATH);
	
	public static final Target chk_StockItem=new Target("chk_StockItem","//*[@value='S']",Target.XPATH);
	public static final Target chk_RemoteItem=new Target("chk_RemoteItem","//*[@value='R']",Target.XPATH);
	public static final Target chk_DemandStatus=new Target("chk_DemandStatus","//*[@value='X']",Target.XPATH);
	public static final Target chk_GroupByCategory=new Target("chk_GroupByCategory","//*[@id='groupByCategoryButtonTop']",Target.XPATH);
	public static final Target chk_Category=new Target("chk_Category","//*[@id='category-div']/span[1]/input",Target.XPATH);
	
	public static final Target txt_Columns=new Target("txt_Columns","//*[@id='colchooser_productSearchGrid']/div/div/div[2]/ul/li[<#>]",Target.XPATH);
	public static final Target txt_Histroy=new Target("txt_Histroy","//*[@id='graphText']",Target.XPATH);
	
	public static final Target lnk_Disclaimer = new Target("lnk_Disclaimer","//*[@id='disclosure']", Target.XPATH);
	public static final Target tab_Nutrition = new Target("tab_Nutrition","//*[@id='nutritionTab']", Target.XPATH);
	public static final Target tab_History = new Target("tab_History","//a[@id='historyTab']", Target.XPATH);
	
	ArrayList<String> addAllList=new ArrayList<String>();
	ArrayList<String> columnList=new ArrayList<String>();
	ArrayList<String> columns_AtProductPage=new ArrayList<String>();
	public ProductCatalogPage(SiteRepository repository){
		super(repository);
	}
	public ProductCatalogPage atProductCatalogpage(){
		log("Click On Product Catalog Page",LogType.STEP);
		return this;
	}
	public ProductCatalogPage clickOnProductCategory(String productCategory){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log("Click On Any Category:"+productCategory,LogType.STEP);
		getCommand().getDriver().findElement(By.linkText(productCategory)).click();
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		return this;
	}
	public ProductCatalogPage clickOnSubCategory(String subCategory){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log("Click On Any Sub-Category",LogType.STEP);
		getCommand().getDriver().findElement(By.linkText(subCategory)).click();
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		return this;
	}
	public ProductCatalogPage clickOnSelectedItem(String itemName){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log("Click On Particular Item Under Sub-Category",LogType.STEP);
		getCommand().getDriver().findElement(By.linkText(itemName)).click();
		 (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='res-loading']"));
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		return this;
	
	}
	public ProductCatalogPage clickOnViewOrder(){
		getCommand().waitForTargetPresent(btn_ViewOrder);
		if(getCommand().isTargetPresent(btn_ViewOrder)){
			log("Click On View Order",LogType.STEP);
			getCommand().click(btn_ViewOrder);
		}
		return this;
	}
	
	public ProductCatalogPage clickOnProductTab(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(btn_ProductTab);
		if(getCommand().isTargetPresent(btn_ProductTab)){
			log("Click On Product tab",LogType.STEP);
			getCommand().click(btn_ProductTab);
		}
		return this;
	}
	public ProductCatalogPage clickOnNarrowResult(){
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		getCommand().waitForTargetPresent(btn_NarrowResult);
		if(getCommand().isTargetPresent(btn_NarrowResult)){
			log("Click On Narrow Result",LogType.STEP);
			getCommand().click(btn_NarrowResult);
		}
		return this;
	}
	public ProductCatalogPage clickOnCategory(){
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(5);
		getCommand().waitForTargetPresent(btn_Category);
		if(getCommand().isTargetPresent(btn_Category)){
			log("Click On Category",LogType.STEP);
			getCommand().click(btn_Category);
		}
		return this;
	}
	public ProductCatalogPage clickOnBrand(){
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(5);
		getCommand().waitForTargetPresent(btn_Brand);
		if(getCommand().isTargetPresent(btn_Brand)){
			log("Click On Brand",LogType.STEP);
			getCommand().click(btn_Brand);
		}
		return this;
	}
	public ProductCatalogPage clickOnStorage(){
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(5);
		getCommand().waitForTargetPresent(btn_Storage);
		if(getCommand().isTargetPresent(btn_Storage)){
			log("Click On Storage",LogType.STEP);
			getCommand().click(btn_Storage);
		}
		return this;
	}
	public ProductCatalogPage verifyNarrowResult(String[] options){
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
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
	public ProductCatalogPage validateStockIndicatorFilter(){
		getCommand().waitForTargetPresent(btn_StockIndicator);
		getCommand().click(btn_StockIndicator);
		log("Click On Stock Indicator",LogType.STEP);
		new SupportFunctions().ScrollInToView(btn_ResetFilter);
		for(int i=1;i<=3;i++){
		String path="//*[@id='stockIndicator-div']/span["+(2*i)+"]";
		String option=getCommand().getDriver().findElement(By.xpath(path)).getText();
                  System.out.println("Options====="+option);
		getCommand().waitFor(7);
		
                 if(option.equals("Remote Item")){
			log("'"+option+"' is Verified",LogType.STEP);
		}
		else if(option.equals("Stock Item")){
			log("'"+option+"' is Verified",LogType.STEP);
		}
		else if(option.equals("Demand Status")){
			log("'"+option+"' is Verified",LogType.STEP);
		}
		else{
			 SoftAssertion.fail("Failed::No Options is Verified");
		}
		
	  }
		return this;
	}
	public ProductCatalogPage checkOnStockItem(){
			getCommand().waitForTargetPresent(chk_StockItem);
			if(getCommand().isTargetPresent(chk_StockItem)){
				log("Check On StockItem",LogType.STEP);
				getCommand().click(chk_StockItem);
			}
			return this;
	}
	public ProductCatalogPage checkOnCategory(){
		getCommand().waitForTargetPresent(chk_Category);
		if(getCommand().isTargetPresent(chk_Category)){
			log("Check On Category",LogType.STEP);
			getCommand().click(chk_Category);
		}
		return this;
   }
	public ProductCatalogPage validateBrand(){
		log("Check On Diferent Brands",LogType.STEP);
		int i=1;
	      while( i<20){
	    	  getCommand().waitFor(3);
			String path="//*[@id='brand-div']/span["+i+"]/input";
			getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			getCommand().getDriver().findElement(By.xpath(path)).click();
			clickOnResetFilter();
			if ("*iexplore".contains(TestProperties.getProperties("test.browser")))
			{
			WebElement webObj = getCommand().getDriver().findElement(By.xpath(path));
			((JavascriptExecutor)getCommand().getDriver()).executeScript("arguments[0].scrollIntoView(true);", webObj);
			}
			i=i+2;
	      }
	      return this;
	}
	public ProductCatalogPage validateStorage(){
		log("Check On Storage",LogType.STEP);
		int i=1;
	      while( i<4){
	    	  getCommand().waitFor(3);
			String path="//*[@id='storage-div']/span["+i+"]/input";
			getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			getCommand().getDriver().findElement(By.xpath(path)).click();
			clickOnResetFilter();
			i=i+2;
	      }
	      return this;
	}
	public ProductCatalogPage checkOnRemoteItem(){
		getCommand().waitFor(5);
		getCommand().waitForTargetPresent(chk_RemoteItem);
		if(getCommand().isTargetPresent(chk_StockItem)){
			log("Check On Remote Item",LogType.STEP);
			getCommand().click(chk_RemoteItem);
		}
		return this;
    }
	public ProductCatalogPage checkOnDemandStatus() {
		getCommand().waitFor(5);
		getCommand().waitForTargetPresent(chk_DemandStatus);
		if(getCommand().isTargetPresent(chk_DemandStatus)){
			log("Check On Demand Status",LogType.STEP);
			getCommand().click(chk_DemandStatus);
		}
		return this;
	}
	public ProductCatalogPage checkValidationStockType(){
			getCommand().waitFor(5);
			getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			List<WebElement> list=getCommand().getDriver().findElements(By.xpath("//*[@aria-describedby='productSearchGrid_stockTypeFlag']"));
			for(WebElement ele:list){
				String s=ele.getAttribute("title");
				//System.out.println("Value="+s);
			if(s.equals("")){
					log("Stock Item is Validated",LogType.STEP);
			}
			else{
				 SoftAssertion.fail("Failed::The Value In Stock Column Filtered By Stock Item is Not empty");
			}
		}
		return this;
	}
	public ProductCatalogPage checkValidationCategory(String item){
		getCommand().waitFor(5);
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> list=getCommand().getDriver().findElements(By.xpath("//*[@title='"+item+"']"));
		for(WebElement ele:list){
			String s=ele.getAttribute("title");
			//System.out.println("Value="+s);
		if(s.equals(item)){
				log("Filtered By Category is Validated",LogType.STEP);
		}
		else{
			 SoftAssertion.fail("Filtered By Category is Not Validated");
		}
	}
	return this;
}
	public ProductCatalogPage checkValidationRemoteType(){
		   getCommand().waitFor(5);
		   getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    List<WebElement> list=getCommand().getDriver().findElements(By.xpath("//*[@title='Remote Stock']"));
		     for(WebElement textONStockColumn:list){
				if(textONStockColumn.getAttribute("title")!=""){
					log("The Value In Stock Column filtered By Remote Item is :"+textONStockColumn.getAttribute("title"),LogType.STEP);
					
				}
				else{
					log("The Value In Stock Column Filtered By Remote Item is empty",LogType.STEP);
				}
			}

	    return this;
	}
	public ProductCatalogPage checkValidationDemandStatus(){
		getCommand().waitFor(5);
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> list=getCommand().getDriver().findElements(By.xpath("//*[@title='Demand Status, Non Cancelable']"));
		for(WebElement ele:list){
		if(ele.getAttribute("title")!=""){
				log("The Value In Stock Column Filtered By Demand Status is:"+ele.getAttribute("title"),LogType.STEP);
		}
		else{
			 SoftAssertion.fail("Failed::The Value In Stock Column Filtered By Demand Status is Empty");
		}
	}
	return this;
	}
	public ProductCatalogPage clickOnColumnSetting(){
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		getCommand().getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);		
		getCommand().getDriver().findElement(By.xpath("//span[@class='ui-icon ui-icon-wrench']")).click();
		log("Click On Column Setting Link",LogType.STEP);
		return this;
	}
	public ProductCatalogPage clickOnCloseWindow(){
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		getCommand().getDriver().findElement(By.linkText("close")).click();
		log("Close Column Setting Screen",LogType.STEP);
		return this;
	}
	public ProductCatalogPage clickOnRemoveAll(){
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		getCommand().getDriver().findElement(By.xpath("//a[@class='remove-all']")).click();
		log("Click On Remove All",LogType.STEP);
		return this;
	}
	public ProductCatalogPage clickOnAddAll(){
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		getCommand().getDriver().findElement(By.xpath("//a[@class='add-all']")).click();
		log("Click On Add All",LogType.STEP);
		return this;
	}
	public ProductCatalogPage validateItems_RemoveAll(){
		getCommand().getDriver().manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		String totalColumns=getCommand().getDriver().findElement(By.xpath("//span[@class='count']")).getText();
		String[] countColumns=totalColumns.split(" ");
		int count=Integer.parseInt(countColumns[0]);
		if(count==0){
			log("Total Column Count In Add All Section:"+count,LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed::Total Columns Are Not Moved To Remove All Section");
		}
		return this;
	}
	public ProductCatalogPage validateItems_AddAll(){
		getCommand().getDriver().manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		String totalColumns=getCommand().getDriver().findElement(By.xpath("//span[@class='count']")).getText();
		System.out.println("Total columns : " +totalColumns);
		String[] countColumns=totalColumns.split(" ");
		int count=Integer.parseInt(countColumns[0]);
		if(count==11){
			log("Total Column Count In Remove All Section::"+count,LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed::Total Columns Are Not Moved To Add All Section");
		}
		return this;
	}
	public ProductCatalogPage getColumns_AddAllSection(){
		//ArrayList<String> addAllList=new ArrayList<String>();
		for(int i=2;i<13;i++){
			String linkText=i+"";
			String list=getCommand().getText(txt_Columns.replace("<#>", linkText));
			addAllList.add(list);
		}
		//getCommand().storeValue(key, addAllList);
		return this;
	}
	public ProductCatalogPage validateColumnInProductPageAfterRemoveAll(){
		System.out.println(addAllList);
		getCommand().getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			if(!getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_proImg']")).getText().contains(addAllList.get(0))){
				log(addAllList.get(0)+" Is Not Displayed In Product Page After Remove All Columns",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(0) + " Column Is Displayed After Remove All");
			}
		
			if(!getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_agreementFlag']")).getText().contains(addAllList.get(1))){
				log(addAllList.get(1)+" Is Not Displayed In Product Page After Remove All Columns",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(1) + " Column Is Displayed After Remove All");
			}

	    	if(!getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_orderedBefore']")).getText().contains(addAllList.get(2))){
				log(addAllList.get(2)+" Is Not Displayed In Product Page After Remove All Columns",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(2)+" Column Is Displayed After Remove All");
			}
		
			if(!getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_stockTypeFlag']")).getText().contains(addAllList.get(3))){
				log(addAllList.get(3)+" Is Not Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(3)+" Column Is Displayed After Remove All");
			}
			if(!getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_materialId']")).getText().contains(addAllList.get(4))){
				log(addAllList.get(4)+" Is Not Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(4)+" Column Is  Displayed After Remove All");
			}
			if(!getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_packSize']")).getText().contains(addAllList.get(5))){
				log(addAllList.get(5)+" Is Not Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(5)+" Column Is Displayed After Remove All");
			}
			if(!getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_brandName']")).getText().contains(addAllList.get(6))){
				log(addAllList.get(6)+" Is Not Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(6)+" Column Is  Displayed After Remove All");
			}
			if(!getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_categoryName']")).getText().contains(addAllList.get(7))){
				log(addAllList.get(7)+" Is Not Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(7)+" Column Is  Displayed After Remove All");
			}
			if(!getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_quantity']")).getText().contains(addAllList.get(8))){
				log(addAllList.get(8)+" Is Not Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(8)+" Column Is Displayed After Remove All");
			}
			if(!getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_quantity']")).getText().contains(addAllList.get(9))){
				log(addAllList.get(9)+" Is Not Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(9)+" Column Is Displayed After Remove All");
			}
			if(!getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_estTotal']")).getText().contains(addAllList.get(10))){
				log(addAllList.get(10)+" Is Not Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(10)+" Column Is Displayed After Remove All");
			}
			
		return this;
	}
	public ProductCatalogPage validateColumnInProductPageAfterAddAll(){
		//Waiting For The Element To Be Loaded in i.e browser only
		   (new SupportFunctions()).waitForStatic(3);
		System.out.println(addAllList);
		
		getCommand().getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_proImg']")).getText().contains(addAllList.get(0))){
				log(addAllList.get(0)+" Is  Displayed In Product Page ",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(0) + " Column Is Not Displayed");
			}
			
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_agreementFlag']")).getText().contains(addAllList.get(1))){
				log(addAllList.get(1)+" Is  Displayed In Product Page ",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(1) + " Column Is Not Displayed");
			}

	    	if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_orderedBefore']")).getText().contains("Prvsly")){
				log(addAllList.get(2)+" Is  Displayed In Product Page ",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(2)+" Column Is Not Displayed ");
			}
		
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_stockTypeFlag']")).getText().contains("Stock")){
				log(addAllList.get(3)+" Is  Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(3)+" Column Is Not Displayed");
			}
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_materialId']")).getText().contains("Sysco")){
				log(addAllList.get(4)+" Is Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(4)+" Column Is Not  Displayed");
			}
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_packSize']")).getText().contains(addAllList.get(5))){
				log(addAllList.get(5)+" Is  Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(5)+" Column Is Not Displayed");
			}
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_brandName']")).getText().contains(addAllList.get(6))){
				log(addAllList.get(6)+" Is  Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(6)+" Column Is Not  Displayed");
			}
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_categoryName']")).getText().contains(addAllList.get(7))){
				log(addAllList.get(7)+" Is  Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(7)+" Column Is Not  Displayed");
			}
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_quantity']")).getText().contains("Order")){
				log(addAllList.get(8)+" Is  Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(8)+" Column Is Not  Displayed");
			}
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_price']")).getText().contains(addAllList.get(9))){
				log(addAllList.get(9)+" Is Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(9)+" Column Is Not Displayed");
			}
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='jqgh_productSearchGrid_estTotal']")).getText().contains("Est.")){
				log(addAllList.get(10)+" Is  Displayed In Product Page",LogType.STEP);
			}else{
				SoftAssertion.fail(addAllList.get(10)+" Column Is Not Displayed");
			}
			
		return this;
	}
	public ProductCatalogPage clickOnOkButton() {
		getCommand().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		getCommand().getDriver().findElement(By.xpath("//button[@type='button'][1]")).click();
		log("Click On Ok Button",LogType.STEP);
		return this;
		
	}
	public ProductCatalogPage validateSelectedColumn(String[] column) {
		getCommand().waitFor(5);
		getCommand().getDriver().manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		for(int i=0;i<column.length;i++){
			if(column[i]=="Ordered Before" && column[i]=="Stock Type" && column[i]=="Sysco UPC" && column[i]=="Order Qty." && column[i]=="Est. Total($)"){
				column[i].substring(0,4);
			}
			System.out.println("//div[contains(text(),'"+column[i]+"')]");
		if(!getCommand().getDriver().findElements(By.xpath("//div[contains(text(),'"+column[i]+"')]")).isEmpty()){
			log(column[i]+" Is Displayed",LogType.STEP);	
		}else{
			SoftAssertion.fail("Failed::"+column[i]+" Is Not Displayed");
		}
		}
		return this;
		
	}
	public ProductCatalogPage selectColumnsInAnySection(String[] column){
		List<WebElement> columnList=getCommand().getDriver().findElements(By.xpath("//span[@class='ui-corner-all ui-icon ui-icon-plus']"));
		for(int i=0;i<column.length;i++){
			for(int j=0;j<addAllList.size();j++){
				if(column[i].equalsIgnoreCase(addAllList.get(j))){
					columnList.get(j).click();
					log("Selected Coulmn is:"+addAllList.get(j),LogType.STEP);
					break;
				}
			}
		}
		System.out.println(columnList);
		return this;
	}
	public ProductCatalogPage validateSelectedColumns(){
		for(int i=0;i<columnList.size();i++){
			String column_ProductPage=getCommand().getDriver().findElement(By.partialLinkText(columnList.get(i))).getText();
			columns_AtProductPage.add(column_ProductPage);
		}
		for(int i=0;i<columnList.size();i++){//*[@id='colchooser_productSearchGrid']/div/div/div[2]/ul/li[2]/a/span
			if(columnList.get(i)==columns_AtProductPage.get(i)){
				log("Column Validated In Product Page",LogType.STEP);
			}
		}
		return this;
	}
	public ProductCatalogPage clickOnShowHidePrice() {		
		getCommand().waitForTargetPresent(btn_ShowHidePrice);
		if(getCommand().isTargetPresent(btn_ShowHidePrice)){
			log("Click On Button:"+getCommand().getAttributeValue(btn_ShowHidePrice,"value"),LogType.STEP);
			getCommand().click(btn_ShowHidePrice);
			getCommand().waitFor(5);
			if(getCommand().getAttributeValue(btn_ShowHidePrice,"value").equals("Hide Price")){
				log("Hide Price Is Displayed",LogType.STEP);
			}
			else if(getCommand().getAttributeValue(btn_ShowHidePrice,"value").equals("Show Price")){
				log("Show Price Is Displayed",LogType.STEP);
			}
			else if(getCommand().getAttributeValue(btn_ShowHidePrice,"value").isEmpty()){
				log("No Button Displayed",LogType.STEP);
			}
			else{
				SoftAssertion.fail("Failed::Neither Show Price Nor Hide Price Is Displayed");

			}
			
		}
		
		return this;
	}
	public ProductCatalogPage clickOnPrint(){
		(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		getCommand().waitForTargetPresent(btn_Print);
		log("Click On Print Button",LogType.STEP);
		getCommand().click(btn_Print);
		return this;
	}
	public ProductCatalogPage validatePrintWindow(){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='includeHistoryCheckBox']")).isDisplayed());
		{
			log("'Include 4 Week Order History' is Present",LogType.STEP);
		}
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='includePricingCheckBox']")).isDisplayed());
		{
			log("'Include Pricing is Present'",LogType.STEP);
		}
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='setDefaultCheckBox']")).isDisplayed());
		{
			log("'Save Setting' is Present'",LogType.STEP);
		}
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='printOptionsPopUp']/span")).isDisplayed());
		{
			String text=getCommand().getDriver().findElement(By.xpath("//*[@id='printOptionsPopUp']/span")).getText();
			log(text+" is Present'",LogType.STEP);
		}
		for(int i=1;i<3;i++){
			String xPATH="//*[@id='printDisclamer"+i+"']";
			String helpMessage=getCommand().getDriver().findElement(By.xpath(xPATH)).getText();
			log("'"+helpMessage+"' is Present'",LogType.STEP);
		}
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='blankColumnsCheckBox']")).isDisplayed());
		{
			log("'Print with Additional Blank Columns' is Displayed",LogType.STEP);
		}
		if(getCommand().getDriver().findElement(By.xpath("//button[@type='button'][2]")).isDisplayed());
		{
			log("'Ok' is Displayed",LogType.STEP);
		}
		if(getCommand().getDriver().findElement(By.xpath("//button[@type='button'][1]")).isDisplayed());
		{
			log("'Cancel' is Displayed",LogType.STEP);
		}
		return this;
		
	}
	public ProductCatalogPage checkPrintAddtionalColumn(){
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='blankColumnsCheckBox']")).isSelected())
		{
			log("Check Box Is Selected",LogType.STEP);
			List<WebElement> dropDownMenu=(new SupportFunctions()).getDropdownList(By.xpath("//*[@id='printQtyColumn']"));
			for(int i=0;i<dropDownMenu.size();i++){
				String menu=dropDownMenu.get(i).getText();
			log(menu+" is present",LogType.STEP);
			}
		}
		else{
			getCommand().getDriver().findElement(By.xpath("//*[@id='blankColumnsCheckBox']")).click();
			log("Check Box Is Selected",LogType.STEP);
			List<WebElement> dropDownMenu=(new SupportFunctions()).getDropdownList(By.xpath("//*[@id='printQtyColumn']"));
			for(int i=0;i<dropDownMenu.size();i++){
				String menu=dropDownMenu.get(i).getText();
			log(menu+" is present",LogType.STEP);
			}
			
		}
		return this;
	}
	public ProductCatalogPage uncheckAdditionalColumn(){
		log("Unchecking Print with additional Columns button",LogType.STEP);
		getCommand().getDriver().findElement(By.xpath("//*[@id='blankColumnsCheckBox']")).click();
		getCommand().waitFor(3);
		if(!getCommand().getDriver().findElement(By.xpath("//*[@id='printQtyColumn']")).isDisplayed()){
			log("Drop Down Is Not Present",LogType.STEP);
		}
		else{
			SoftAssertion.fail("Drop Down Is  Present");
		}
		return this;
	}
	public ProductCatalogPage validateProductInfo(){
		
		   getCommand().waitFor(3);
		//Verifying All The Options In Product Window
		getCommand().getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		if(getCommand().getDriver().findElement(By.xpath("//a[@id='summaryTab']")).isDisplayed())
		{
			log("'Product Information' Tab is Displayed",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::'Product Information' Tab is Not Displayed");
		}
		
		if(getCommand().isTargetPresent(tab_History)){
			if(getCommand().getDriver().findElement(By.xpath("//a[@id='historyTab']")).isDisplayed())
			{
				log("'Item History' Tab is Displayed",LogType.STEP);
				
				getCommand().getDriver().findElement(By.xpath("//a[@id='historyTab']")).click();
				//Waiting For The Element To Be Loaded in i.e browser only
				 getCommand().waitFor(5);
				if(getCommand().waitForTargetVisible(txt_Histroy).isTargetPresent(txt_Histroy))
				{
					log("'Week Purchase History' is Displayed",LogType.STEP);
				}else{
					SoftAssertion.fail("Failed::'Week Purchase History' is Not Displayed");
				}
			}else{
				log("'Item History' Tab is not Present",LogType.STEP);
			}
		}else{
			log("'Item History' Tab is not Present",LogType.STEP);
		}
		
		if(getCommand().isTargetPresent(tab_Nutrition)){
			if(getCommand().getDriver().findElement(By.xpath("//*[@id='nutritionTab']")).isDisplayed())
			{
				log("'Nutrition' Tab is Displayed",LogType.STEP);
				
				getCommand().getDriver().findElement(By.xpath("//*[@id='nutritionTab']")).click();
				
				if(getCommand().getDriver().findElement(By.xpath("//*[@id='productInformationNutrition']")).isDisplayed())
				{
					log("'Nutrition facts table' is Displayed",LogType.STEP);
				}
				else{
					SoftAssertion.fail("Failed::'Nutrition Facts table' is Not Displayed");
				}
			}else{
				log("'Nutrition' Tab is not Present",LogType.STEP);
			}
		}else{
			log("'Nutrition' Tab is not Present",LogType.STEP);
		}
		
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='addtolistClick']")).isDisplayed())
		{
			log("'Add To List' is Displayed",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::'Add To List' is Not Displayed");
		}
		
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='addtoorderClick']")).isDisplayed())
		{
			log("'Add To Order' is Displayed",LogType.STEP);
		}else{
			SoftAssertion.fail("Failed::'Add To Order' is Not Displayed");
		}
		
		if(getCommand().getDriver().findElement(By.xpath("//*[@id='printClick']")).isDisplayed())
		{
			log("'Print Option' is Displayed",LogType.STEP);
		}
		else{
			SoftAssertion.fail("Failed::'Print Option' is Not Displayed");
		}		
		
	return this;
		
	}
	
	public ProductCatalogPage clickOnCancelButton(){
		getCommand().getDriver().findElement(By.xpath("//button[@type='button'][1]")).click();
		log("Click On Cancel Button",LogType.STEP);
		return this;
	}
	public ProductCatalogPage clickOnGroupByCategory(){
		getCommand().waitForTargetPresent(chk_GroupByCategory);
		if(getCommand().isTargetPresent(chk_GroupByCategory)){
			log("Click On Group By Category",LogType.STEP);
			getCommand().click(chk_GroupByCategory);
		}
		
		return this;
	}
	public ProductCatalogPage verifyProductButton(){
		  (new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
		  getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  if(getCommand().getDriver().findElement(By.xpath("//*[@id='productsTab']")).isDisplayed()){
			  log("Product Button Is Displayed",LogType.STEP);
		  }else{
			  SoftAssertion.fail("Failed::Product Button Is Displayed");
		  }
		  return this;
		 
	  }
	public ProductCatalogPage validateColumnSelectWindowAfterCancel(){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  if(getCommand().getDriver().findElements(By.xpath(".//*[@id='colchooser_productSearchGrid']")).isEmpty()){
			  log("Column Selector Grid Is Not Displayed After Cancel",LogType.STEP);
		  }else{
			  SoftAssertion.fail("Failed::Column Selector Grid  Is Displayed");
		  }
		  return this;
	}
	public ProductCatalogPage verifyBrowseCatalogOption(){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  if(getCommand().getDriver().findElement(By.xpath("//*[@id='browseCatalogDisplay']")).isDisplayed()){
			  log("Browse Catalog Is Displayed",LogType.STEP);
		  }else{
			  
			  SoftAssertion.fail("Failed::Browse Catalog Is Displayed");
		  }
		  return this;
	}
	public ProductCatalogPage verifyShowAllCategoryOption(){
		getCommand().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  if(getCommand().getDriver().findElement(By.xpath("//*[@id='reloadAllCategories']")).isDisplayed()){
			  log("Show All Categories Is Displayed",LogType.STEP);
		  }else{
			  SoftAssertion.fail("Failed::Show All Categories Is Displayed");
		  }
		  return this;
	}
	public ProductCatalogPage clickOnResetFilter(){
		     getCommand().waitFor(5);
		     new SupportFunctions().ScrollInToView(btn_ResetFilter);
			getCommand().waitForTargetPresent(btn_ResetFilter);
			if(getCommand().isTargetPresent(btn_ResetFilter)){
				//log("Click On Reset Filter",LogType.STEP);
				getCommand().click(btn_ResetFilter);
			}
			return this;
		}
	
	public ProductCatalogPage clickOnNutritionTab() {
		getCommand().waitForTargetPresent(tab_Nutrition);
		if (getCommand().isTargetPresent(tab_Nutrition)) {
			log("Click On Nutrtion", LogType.STEP);
			getCommand().click(tab_Nutrition);
		}
		return this;
	}
	
	public ProductCatalogPage mouseHoverOnDisclaimer() {
		getCommand().waitForTargetPresent(lnk_Disclaimer);
		if (getCommand().isTargetPresent(lnk_Disclaimer)) {
			log("Mouse hover on Disclaimer", LogType.STEP);
			getCommand().mouseHover(lnk_Disclaimer);
		}
		return this;
	}
	public ProductCatalogPage VerifyGlutenFreeDisclaimer() {
		log("Verify disclaimer text", LogType.STEP);
//	System.out.println(getCommand().getDriver().switchTo().frame(0).getTitle());
		getCommand().mouseHover(lnk_Disclaimer);
		return this;
	}
	
}
