package moneytoliacase.steps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import moneytoliacase.utils.CommonMethods;

public class AddProductInCartSteps extends CommonMethods {

	Actions actions = new Actions(driver);

	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {

		// Home Page Validation
		if (home.slider.isDisplayed()) {

			System.out.println("User land in Home Page successfully");
		} else {
			System.out.println("You're not in Home Page");
		}
	}

	@When("the user clicks the Product button")
	public void the_user_clicks_the_product_button() {

		home.productButton.click();

	}

	@When("hovers over the first product and clicks Add to Cart")
	public void hovers_over_the_first_product_and_clicks_add_to_cart() throws InterruptedException {

		actions.moveToElement(products.firstProduct).perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(products.addToCartFirst));

		products.addToCartFirst.click();

	}

	@When("clicks the Continue Shopping button")
	public void clicks_the_continue_shopping_button() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(products.continueShopping));

		products.continueShopping.click();

	}

	@When("hovers over the second product and clicks Add to Cart")
	public void hovers_over_the_second_product_and_clicks_add_to_cart() throws InterruptedException {

		actions.moveToElement(products.secondProduct).perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(products.addToCartSecond));

		products.addToCartSecond.click();

	}

	@When("clicks the View Cart button")
	public void clicks_the_view_cart_button() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(products.viewCart));

		products.viewCart.click();

	}

	@Then("verify that products are added to the cart")
	public void verify_that_products_are_added_to_the_cart() {

		if (viewCart.firstProductDescription.getText().equals("Blue Top")) {

			System.out.println("First product is in the cart!");

		} else {
			System.out.println("First product is not in the cart!");
		}

		if (viewCart.secondProductDescription.getText().equals("Men Tshirt")) {

			System.out.println("Second product is in the cart!");

		} else {
			System.out.println("Second product is not in the cart!");
		}

	}

	@Then("verify their prices, quantity, and total price")
	public void verify_their_prices_quantity_and_total_price() {

		// Getting all rows from the table
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='cart_info_table']/tbody/tr"));

		// Loop through every single row in the table
		for (WebElement row : rows) {
			// Getting product's names from the current row
			String productName = row.findElement(By.cssSelector("td.cart_description h4 a")).getText();

			// Specify the expected values for each product
			int expectedQuantity = 0;
			String expectedPrice = "";
			String expectedTotal = "";

			// Update expected values based on the product name
			if ("Blue Top".equals(productName)) {
				expectedQuantity = 1;
				expectedPrice = "Rs. 500";
				expectedTotal = "Rs. 500";
			} else if ("Men Tshirt".equals(productName)) {
				expectedQuantity = 1;
				expectedPrice = "Rs. 400";
				expectedTotal = "Rs. 400";
			}

			// Get actual values from the current row
			int actualQuantity = Integer.parseInt(row.findElement(By.cssSelector("td.cart_quantity button")).getText());
			String actualPrice = row.findElement(By.cssSelector("td.cart_price p")).getText();
			String actualTotal = row.findElement(By.cssSelector("td.cart_total p.cart_total_price")).getText();

			// Verify the values
			if (actualQuantity == expectedQuantity && actualPrice.equals(expectedPrice)
					&& actualTotal.equals(expectedTotal)) {
				System.out.println("Test Passed! Product details are correct for " + productName);
			} else {
				System.out.println("Test Failed! Product details are incorrect for " + productName);
			}
		}

	}

}
