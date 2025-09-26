package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksFile {
	
	@Before(order = 1)
	public void BeforeScenario2() {
		System.out.println("Before Scenario 2");
	}
	
	@After(order = 0)
	public void AfterScenario2() {
		System.out.println("After Scenario 2");
	}
	
	
	@Before(order = 0)
	public void BeforeScenario1() {
		System.out.println("Before Scenario 1");
	}
	
	@After(order = 1)
	public void AfterScenario1() {
		System.out.println("After Scenario 1");
	}
	
	@Before()
	public void BeforeScenario() {
		System.out.println("Before Scenario");
	}
	
	@After()
	public void AfterScenario() {
		System.out.println("After Scenario");
	}
	
	@Before("@One-1 or @One-2")
	public void BeforeScenarioOneTwo12() {
		System.out.println("Before Scenario @One-1, @One-2");
	}
	
	@After("@One-1")
	public void AfterScenarioOne1() {
		System.out.println("After Scenario @One-1");
	}

}
