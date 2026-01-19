package stepDefinitions;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFun1 {

	WebDriver driver;

	//Verifying the login functionality
	@Given("Launch chrome browser and hit test URL")
	public void launch_chrome_browser_and_hit_test_url() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.navigate().to("http://192.168.1.11:81/Home/index");

	}
	@When("Enter valid user name and password")
	public void enter_valid_user_name_and_password() {

		//WebElements
		WebElement userName = driver.findElement(By.xpath("//input[@placeholder = 'Employee ID']"));
		WebElement password = driver.findElement(By.id("password"));

		//Login Credentials
		userName.sendKeys("AB1");
		password.sendKeys("Test@123");


	}
	@When("Click login button to ensure login success")
	public void click_login_button_to_ensure_login_success() {

		//WebElement
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		loginBtn.click();

	}
	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() throws InterruptedException {
		String loginUserName = "AB_User 1";

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.className("spn-userProfileName"), loginUserName
				));

		WebElement profileNameElement = driver.findElement(By.className("spn-userProfileName"));
		String profileName = profileNameElement.getText().trim();

		if (profileName.equalsIgnoreCase(loginUserName)) {
			System.out.println("User Login sucessfully Profile Name: " + profileName);
			Thread.sleep(2000);
			driver.quit();
		} else {
			System.out.println("User not Login sucessfully Profile Name: " + profileName);
		}

	}

	//Invalid - Login with valid functionality
	@Given("Invalid - Launch chrome browser and hit test URL")
	public void invalid_launch_chrome_browser_and_hit_test_url() {
		System.out.println("Invalid - Launch chrome browser and hit test URL");
	}

	@When("Invalid - Enter valid user name and password")
	public void invalid_enter_valid_user_name_and_password() {
		System.out.println("Invalid - Enter valid user name and password");
	}

	@When("Invalid - Click login button to ensure login success")
	public void invalid_click_login_button_to_ensure_login_success() {
		System.out.println("Invalid - Click login button to ensure login success");
	}

	@Then("Invalid - User should be logged in successfully")
	public void invalid_user_should_be_logged_in_successfully() {
		System.out.println("Invalid - User should be logged in successfully");
	}

}
