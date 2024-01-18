package moneytoliacase.testbase;

import moneytoliacase.pages.HomepageElements;
import moneytoliacase.pages.ProductspageElements;
import moneytoliacase.pages.ViewCartpageElements;


public class PageInitializer extends BaseClass{
	
	public static HomepageElements home;
	public static ProductspageElements products;
	public static ViewCartpageElements viewCart;
	
	
	
	public static void initialize() {
		
		home = new HomepageElements();
		products = new ProductspageElements();
		viewCart = new ViewCartpageElements();
		
		
	}

}
