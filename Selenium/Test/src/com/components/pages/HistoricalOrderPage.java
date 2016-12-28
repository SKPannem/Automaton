package com.components.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import com.components.repository.SiteRepository;
import com.iwaf.framework.components.IReporter.LogType;
import com.iwaf.framework.components.Target;

public class HistoricalOrderPage extends SitePage {
		public static final Target btn_submit=new Target("btn_submit","//*[@id='chkOutBtn1']",Target.XPATH);
		public static final Target btn_ReOrder=new Target("btn_ReOrder","//input[@id='reOrderButton']",Target.XPATH);
		public static final Target btn_ChkItem=new Target("btn_ChkItem","//*[@id='jqg_orderdetails_<#>-CS']",Target.XPATH);
		
		public static final Target txt_Quantity=new Target("txt_Quantity","//*[@id='<#>-CS_syscoGridColumnEditableQuantityFormatter']",Target.XPATH);
		public static final Target chk_Order=new Target("chk_Order","//*[@id='<#>']",Target.XPATH);
		
		public static String cancel_OrderName="";
		ArrayList<String> upc_Number=new ArrayList<String>();
		
		public HistoricalOrderPage(SiteRepository repository){
			super(repository);
		}
		public HistoricalOrderPage atHistoricalOrderPage(){
			log("Opened Historical Order Page",LogType.STEP);
			return this;
		}
		public HistoricalOrderPage clickOnReOrder(){
			(new SupportFunctions()).waitForLoading(300, By.xpath("//*[@id='asyncLoadingMessageText']"));
			getCommand().waitForTargetVisible(btn_ReOrder);
			if(getCommand().isTargetPresent(btn_ReOrder)){
				//log("click on reorder button",LogType.STEP);
				getCommand().click(btn_ReOrder);
			}
			return this;
		}
		public HistoricalOrderPage checkOnOrder(){
			//Click On Check Box For The Item
			for(int i=0;i<upc_Number.size();i++){
			getCommand().waitForTargetPresent(btn_ChkItem.replace("<#>", upc_Number.get(i)));
			if(getCommand().isTargetPresent(btn_ChkItem.replace("<#>", upc_Number.get(i)))){
				log("Check On The Item:"+upc_Number.get(i),LogType.STEP);
				getCommand().click(btn_ChkItem.replace("<#>", upc_Number.get(i)));	
			   }
			}
			return this;
      }
		public HistoricalOrderPage enterQuantity(String case_Quantity){
			//Enter Quantity For Multiple item
			for(int i=0;i<upc_Number.size();i++){
			getCommand().waitForTargetPresent(txt_Quantity.replace("<#>", upc_Number.get(i)));
			if(getCommand().isTargetPresent(txt_Quantity.replace("<#>", upc_Number.get(i)))){
				log("Enter Quantity For The Item("+upc_Number.get(i)+") is:"+case_Quantity,LogType.STEP);
			   getCommand().clear(txt_Quantity.replace("<#>", upc_Number.get(i))).sendKeys(txt_Quantity.replace("<#>", upc_Number.get(i)),case_Quantity);
			 }
			}
			return this;
			
		}
}
