package moneytoliacase.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import moneytoliacase.testbase.BaseClass;

public class ProductspageElements extends BaseClass{
	
	@FindBy(xpath="(//div[@class='product-image-wrapper'])[1]")
	public WebElement firstProduct;
	
	@FindBy(xpath="(//a[@data-product-id='1' and contains(@class, 'btn btn-default add-to-cart')])[2]")
	public WebElement addToCartFirst;
	
	@FindBy(xpath="(//div[@class='product-image-wrapper'])[2]")
	public WebElement secondProduct;
	
	@FindBy(xpath="(//a[@data-product-id='2' and contains(@class, 'btn btn-default add-to-cart')])[2]")
	public WebElement addToCartSecond;
	
	@FindBy(xpath="//*[@id=\"cartModal\"]/div/div/div[3]/button")
	public WebElement continueShopping;
	
	@FindBy(xpath="//*[@id=\"cartModal\"]//p[2]//a/u")
	public WebElement viewCart;
	


	public ProductspageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
