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
package com.components.repository;

import com.components.pages.Esysco_IFG_Page;
import com.components.pages.HistoricalOrderPage;
import com.components.pages.HomePage;
import com.components.pages.ItemDeletePage;
import com.components.pages.ListPage;
import com.components.pages.OrderGuidePage;
import com.components.pages.OrderPage;
import com.components.pages.LoginPage;
import com.components.pages.ProductCatalogPage;

public class SiteRepository{

	
	public HomePage homePage(){
		return new HomePage(this);
	}

	public LoginPage loginPage(){
			return new LoginPage(this);
	}

	public OrderPage orderPage(){
		return new OrderPage(this);
    }
	public ListPage listPage(){
		return new ListPage(this);
	}
	public OrderGuidePage orderGuidePage(){
		return new OrderGuidePage(this);
	}
	public HistoricalOrderPage historicalOrderPage(){
		return new HistoricalOrderPage(this);
	}
	public ProductCatalogPage productCatalogPage(){
		return new ProductCatalogPage(this);
	}
	public ItemDeletePage itemDeletePage(){
		return new ItemDeletePage(this);
	}
	public Esysco_IFG_Page esyscoIFGPage(){
		return new Esysco_IFG_Page(this);
	}
}