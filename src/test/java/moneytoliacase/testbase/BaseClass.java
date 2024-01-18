package moneytoliacase.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.core.options.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import moneytoliacase.utils.ConfigsReader;
import moneytoliacase.utils.Constant;

public class BaseClass {
	public static WebDriver driver;
	
	

	
	
	public static void setUp() throws InterruptedException {
		ConfigsReader.readProperties(Constant.CONFIGURATION_FILEPATH);

		String browser = ConfigsReader.getProperty("browser");
		

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver();
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}

		Thread.sleep(2000);
		driver.manage().window().maximize();
		String website = ConfigsReader.getProperty("url");
		driver.get(website);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		PageInitializer.initialize();
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
