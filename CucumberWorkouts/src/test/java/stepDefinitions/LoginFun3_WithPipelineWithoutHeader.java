package stepDefinitions;

import java.time.Duration;
import java.util.List;

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

public class LoginFun3_WithPipelineWithoutHeader {
	
	WebDriver driver;

	@Given("Pipeline without header - Open chrome browser and hit test URL")
	public void pipeline_without_header_open_chrome_browser_and_hit_test_url() {
        WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.navigate().to("http://192.168.1.11:83/Home/index");
	}
	@When("Pipeline without header - Enter valid user name and password")
	public void pipeline_without_header_enter_valid_user_name_and_password(DataTable value) {
	    
		//WebElements
	    WebElement userName = driver.findElement(By.xpath("//input[@placeholder = 'Employee ID']"));
		WebElement password = driver.findElement(By.id("password"));
		
		//User credentials retrieve from data table
		List<List<String>> credentails = value.asLists(String.class);
	 		
		
		//Login Credentials
		for (List<String> datas : credentails) {
			userName.sendKeys(datas.get(0));
			password.sendKeys(datas.get(1));
		}
			    
	}
	@When("Pipeline without header - Clicking the login button to ensure login success")
	public void pipeline_without_header_clicking_the_login_button_to_ensure_login_success() {
		//WebElement
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		loginBtn.click();
	}
	@Then("Pipeline without header- User should be logged in successfully on expected site")
	public void pipeline_without_header_user_should_be_logged_in_successfully_on_expected_site() {
        String loginUserName = "ABUser1";
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
		    By.className("spn-userProfileName"), loginUserName
		));

		WebElement profileNameElement = driver.findElement(By.className("spn-userProfileName"));
		String profileName = profileNameElement.getText().trim();
		
		if (profileName.equalsIgnoreCase(loginUserName)) {
			System.out.println("User Login sucessfully with pipeline without header Profile Name: " + profileName);
		} else {
			System.out.println("User not Login sucessfully with pipeline without header Profile Name: " + profileName);
		}
	}



	

}
