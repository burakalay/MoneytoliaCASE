from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.common.keys import Keys
import time

# Set the path to your ChromeDriver executable
chrome_path = "webdriver.chromedriver.exe"
driver = webdriver.Chrome(executable_path=chrome_path)

# Initialize Actions, WebDriverWait, and URL
actions = ActionChains(driver)
wait = WebDriverWait(driver, 10)
url = "http://automationexercise.com"
driver.get(url)
driver.maximize_window()

# Home Page Validation
slider = driver.find_element(By.XPATH, "//section[@id='slider']")
if slider.is_displayed():
    print("User landed on the Home Page successfully")
else:
    print("You're not on the Home Page")

# Navigating to the Product Page
product_button = driver.find_element(By.XPATH, "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
product_button.click()

# Locating elements on the Product Page
first_product = driver.find_element(By.XPATH, "(//div[@class='product-image-wrapper'])[1]")
second_product = driver.find_element(By.XPATH, "(//div[@class='product-image-wrapper'])[2]")

add_to_cart_first = driver.find_element(By.XPATH, "(//a[@data-product-id='1' and contains(@class, 'btn btn-default add-to-cart')])[2]")
add_to_cart_second = driver.find_element(By.XPATH, "(//a[@data-product-id='2' and contains(@class, 'btn btn-default add-to-cart')])[2]")

continue_shopping = driver.find_element(By.XPATH, "//*[@id=\"cartModal\"]/div/div/div[3]/button")
view_cart = driver.find_element(By.XPATH, "//*[@id=\"cartModal\"]//p[2]//a/u")

# Hover over the first product
actions.move_to_element(first_product).perform()

# Wait for Add to Cart button to be clickable
wait.until(EC.element_to_be_clickable((By.XPATH, "(//a[@data-product-id='1' and contains(@class, 'btn btn-default add-to-cart')])[2]")))
add_to_cart_first.click()

# Wait for Continue Shopping button to be clickable
wait.until(EC.element_to_be_clickable((By.XPATH, "//*[@id=\"cartModal\"]/div/div/div[3]/button")))
continue_shopping.click()

# Hover over the second product
actions.move_to_element(second_product).perform()

# Wait for Add to Cart button to be clickable
wait.until(EC.element_to_be_clickable((By.XPATH, "(//a[@data-product-id='2' and contains(@class, 'btn btn-default add-to-cart')])[2]")))
add_to_cart_second.click()

# Wait for View Cart button to be clickable
wait.until(EC.element_to_be_clickable((By.XPATH, "//*[@id=\"cartModal\"]//p[2]//a/u")))

# Navigate to View Cart Page
view_cart.click()

# Locating elements on the View Cart Page
first_product_description = driver.find_element(By.XPATH, "//table[@id='cart_info_table']/tbody/tr[1]/td[2]")
second_product_description = driver.find_element(By.XPATH, "//table[@id='cart_info_table']/tbody/tr[2]/td[2]")

# Verify products in the cart
if first_product_description.text == "Blue Top":
    print("First product is in the cart!")
else:
    print("First product is not in the cart!")

if second_product_description.text == "Men Tshirt":
    print("Second product is in the cart!")
else:
    print("Second product is not in the cart!")

# Loop through every single row in the table
rows = driver.find_elements(By.XPATH, "//table[@id='cart_info_table']/tbody/tr")

# Specify expected values for each product
expected_values = {
    "Blue Top": {"quantity": 1, "price": "Rs. 500", "total": "Rs. 500"},
    "Men Tshirt": {"quantity": 1, "price": "Rs. 400", "total": "Rs. 400"}
}

# Loop through each row in the table and verify values
for row in rows:
    product_name = row.find_element(By.CSS_SELECTOR, "td.cart_description h4 a").text

    # Get actual values from the current row
    actual_quantity = int(row.find_element(By.CSS_SELECTOR, "td.cart_quantity button").text)
    actual_price = row.find_element(By.CSS_SELECTOR, "td.cart_price p").text
    actual_total = row.find_element(By.CSS_SELECTOR, "td.cart_total p.cart_total_price").text

    # Verify the values
    expected_quantity = expected_values[product_name]["quantity"]
    expected_price = expected_values[product_name]["price"]
    expected_total = expected_values[product_name]["total"]

    if actual_quantity == expected_quantity and actual_price == expected_price and actual_total == expected_total:
        print(f"Test Passed! Product details are correct for {product_name}")
    else:
        print(f"Test Failed! Product details are incorrect for {product_name}")

# Close the browser
driver.quit()
