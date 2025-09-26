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

public class LoginFun5_WithExamplePipeline {

	WebDriver driver;

	@Given("Pipeline with Example Keyword - Open chrome browser and hit test URL")
	public void pipeline_with_example_keyword_open_chrome_browser_and_hit_test_url() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.navigate().to("http://192.168.1.11:83/Home/index");
	}


	@When("Pipeline with Example Keyword Enter valid user name {string} and password {string}")
	public void pipeline_with_example_keyword_enter_valid_user_name_ab1_and_password(String uName, String pwd) {
		//WebElements
		WebElement userName = driver.findElement(By.xpath("//input[@placeholder = 'Employee ID']"));
		WebElement password = driver.findElement(By.id("password"));

		//Login Credentials
		userName.sendKeys(uName);
		password.sendKeys(pwd);
	}


	@When("Pipeline with Example Keyword - Clicking the login button to ensure login success")
	public void pipeline_with_example_keyword_clicking_the_login_button_to_ensure_login_success() {
		//WebElement
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		loginBtn.click();
	}


	@Then("Pipeline with Example Keyword - User should be logged in successfully on expected site")
	public void pipeline_with_example_keyword_user_should_be_logged_in_successfully_on_expected_site() {
		String loginUserName = "ABUser1";

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.className("spn-userProfileName"), loginUserName
				));

		WebElement profileNameElement = driver.findElement(By.className("spn-userProfileName"));
		String profileName = profileNameElement.getText().trim();

		if (profileName.equalsIgnoreCase(loginUserName)) {
			System.out.println("User Login sucessfully with parameter Profile Name: " + profileName);
		} else {
			System.out.println("User not Login sucessfully with parameter Profile Name: " + profileName);
		}
	}



}
