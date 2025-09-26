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

public class LoginFun2_WithParaMeter {
	
	WebDriver driver;


	@Given("Open chrome browser and hit test URL")
	public void open_chrome_browser_and_hit_test_url() {
        WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.navigate().to("http://192.168.1.11:83/Home/index");
	}
	@When("Enter valid user name {string} and password {string}")
	public void enter_valid_user_name_and_password(String uName, String pwd) {
		//WebElements
		WebElement userName = driver.findElement(By.xpath("//input[@placeholder = 'Employee ID']"));
		WebElement password = driver.findElement(By.id("password"));
				
		//Login Credentials
		userName.sendKeys(uName);
		password.sendKeys(pwd);
	}
	@When("Clicking the login button to ensure login success")
	public void clicking_the_login_button_to_ensure_login_success() {
		//WebElement
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		loginBtn.click();
	}
	@Then("User should be logged in successfully on expected site")
	public void user_should_be_logged_in_successfully_on_expected_site() {
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



	


