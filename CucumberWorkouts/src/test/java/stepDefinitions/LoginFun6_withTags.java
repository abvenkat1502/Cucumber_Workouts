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

public class LoginFun6_withTags {

	WebDriver driver;

	@Given("tags - Launch chrome browser and hit test URL")
	public void tags_launch_chrome_browser_and_hit_test_url() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("http://192.168.1.11:83/Home/index");

	}

	@When("tags - Enter valid user name and password")
	public void tags_enter_valid_user_name_and_password() {

		//WebElements
		WebElement userName = driver.findElement(By.xpath("//input[@placeholder = 'Employee ID']"));
		WebElement password = driver.findElement(By.id("password"));

		//Login Credentials
		userName.sendKeys("AB1");
		password.sendKeys("Test@123");


	}

	@Given("tags - Click login button to ensure login success")
	public void tags_click_login_button_to_ensure_login_success() {
		//WebElement
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		loginBtn.click();
	}

	@Then("tags - User should be logged in successfully")
	public void tags_user_should_be_logged_in_successfully() {
		String loginUserName = "ABUser1";

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.className("spn-userProfileName"), loginUserName
				));

		WebElement profileNameElement = driver.findElement(By.className("spn-userProfileName"));
		String profileName = profileNameElement.getText().trim();

		if (profileName.equalsIgnoreCase(loginUserName)) {
			System.out.println("User Login sucessfully Profile Name: " + profileName);
		} else {
			System.out.println("User not Login sucessfully Profile Name: " + profileName);
		}

	}



}
