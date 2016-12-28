package com.components.pages;

import com.components.repository.SiteRepository;
import com.iwaf.framework.BasePage;



public class SitePage extends BasePage{
	protected SiteRepository repository;
	
	SitePage(SiteRepository repository){
		this.repository=repository;
	}

	public LoginPage _atLoginPage() {
		return this.repository.loginPage();
	}
	public HomePage _GoToHomePage() {
		return this.repository.homePage();
	}

	public LoginPage _GoToLoginPage() {
		return this.repository.loginPage();
	}

	public OrderPage _GoOrderPage() {
		return this.repository.orderPage();
	}
	public ListPage _GoToListPage(){
		return this.repository.listPage();
	}
	public OrderGuidePage _GoToOrdeGuidePage(){
		return this.repository.orderGuidePage();
	}
	public HistoricalOrderPage _GoToHistoricalOrderPage(){
		return this.repository.historicalOrderPage();
		
	}
	public ProductCatalogPage _GoToProductCatalog(){
		return this.repository.productCatalogPage();
	}
	public ItemDeletePage _GoItemDeletePage() {
		return this.repository.itemDeletePage();
	}
	public Esysco_IFG_Page _GoIFGPage() {
		return this.repository.esyscoIFGPage();
	}
	
}