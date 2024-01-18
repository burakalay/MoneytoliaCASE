package moneytoliacase.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import moneytoliacase.testbase.BaseClass;

public class ViewCartpageElements extends BaseClass {
	
	@FindBy(id="cart_info_table")
	public List<WebElement> cartInfoTable;
	
	@FindBy(xpath="//table[@id='cart_info_table']/tbody/tr[1]/td[2]")
	public WebElement firstProductDescription;
	
	@FindBy(xpath="//table[@id='cart_info_table']/tbody/tr[2]/td[2]")
	public WebElement secondProductDescription;
	
	
	public ViewCartpageElements() {
		
		PageFactory.initElements(driver, this);
	}
	

}
