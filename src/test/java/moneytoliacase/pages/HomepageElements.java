package moneytoliacase.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import moneytoliacase.testbase.BaseClass;

public class HomepageElements extends BaseClass {
	
	@FindBy(xpath="//section[@id='slider']")
	public WebElement slider;

	@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
	public WebElement productButton;
	
	public HomepageElements() {
		PageFactory.initElements(driver, this);
	}
}
