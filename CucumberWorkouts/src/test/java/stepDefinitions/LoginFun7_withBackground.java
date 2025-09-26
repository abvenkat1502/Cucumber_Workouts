package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFun7_withBackground {
	
	//Background
	@Given("BG1 Cucumber Background one")
	public void bg1_cucumber_start_one() {
	    System.out.println("BG1 Cucumber Background one");
	}

	@When("BG1 Cucumber Background two")
	public void bg1_cucumber_start_two() {
	    System.out.println("BG1 Cucumber Background two");
	}

	//Scenario: BG1 Login with valid functionality
	@Given("BG1 Launch chrome browser and hit test URL")
	public void bg1_launch_chrome_browser_and_hit_test_url() {
		System.out.println("BG1 Launch chrome browser and hit test URL");
	}

	@When("BG1 Enter valid user name and password")
	public void bg1_enter_valid_user_name_and_password() {
		System.out.println("BG1 Enter valid user name and password");
	}

	@When("BG1 Click login button to ensure login success")
	public void bg1_click_login_button_to_ensure_login_success() {
		System.out.println("BG1 Click login button to ensure login success");
	}

	@Then("BG1 User should be logged in successfully")
	public void bg1_user_should_be_logged_in_successfully() {
		System.out.println("BG1 User should be logged in successfully");
	}

	//Scenario: BG2 Login with valid functionality
	@Given("BG2 Launch chrome browser and hit test URL")
	public void bg2_launch_chrome_browser_and_hit_test_url() {
		System.out.println("BG2 Launch chrome browser and hit test URL");
	}

	@When("BG2 Enter valid user name and password")
	public void bg2_enter_valid_user_name_and_password() {
		System.out.println("BG2 Enter valid user name and password");
	}

	@When("BG2 Click login button to ensure login success")
	public void bg2_click_login_button_to_ensure_login_success() {
		System.out.println("BG2 Click login button to ensure login success");
	}

	@Then("BG2 User should be logged in successfully")
	public void bg2_user_should_be_logged_in_successfully() {
		System.out.println("BG2 User should be logged in successfully");
	}

}
