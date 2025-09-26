package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFun4_WithPipelineWithHeader {

	WebDriver driver;
	

	@Given("Pipeline with header - Open chrome browser and hit test URL")
	public void pipeline_with_header_open_chrome_browser_and_hit_test_url() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
		driver.navigate().to("http://192.168.1.11:83/Home/index");
	}

	@When("Pipeline with header - Enter valid user name and password")
	public void pipeline_with_header_enter_valid_user_name_and_password(DataTable values) {

		//WebElements
		WebElement userName = driver.findElement(By.xpath("//input[@placeholder = 'Employee ID']"));
		WebElement password = driver.findElement(By.id("password"));

		//User credentials retrieve from data table
		List<Map<String, String>> credentials = values.asMaps(String.class, String.class);

		//Login Credentials
		for (Map<String, String> data : credentials) {
			userName.sendKeys(data.get("USERNAME"));
			password.sendKeys(data.get("PASSWORD"));
		}

	}

	@When("Pipeline with header - Clicking the login button to ensure login success")
	public void pipeline_with_header_clicking_the_login_button_to_ensure_login_success() {
		//WebElement
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		loginBtn.click();
	}
	@Then("Pipeline with header- User should be logged in successfully on expected site")
	public void pipeline_with_header_user_should_be_logged_in_successfully_on_expected_site() {
		String loginUserName = "ABUser1";

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.className("spn-userProfileName"), loginUserName
				));

		WebElement profileNameElement = driver.findElement(By.className("spn-userProfileName"));
		String profileName = profileNameElement.getText().trim();

		if (profileName.equalsIgnoreCase(loginUserName)) {
			System.out.println("User Login sucessfully with pipeline with header Profile Name: " + profileName);
		} else {
			System.out.println("User not Login sucessfully with pipeline with header Profile Name: " + profileName);
		}
	}


}
