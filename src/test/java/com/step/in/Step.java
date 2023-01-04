package com.step.in;

import org.openqa.selenium.WebDriver;

import com.basic.in.Base_Class2;
import com.basic.in.POM;
import com.runner.in.Runner;

import io.cucumber.java.en.*;

public class Step extends Base_Class2 {
	public static WebDriver driver = Runner.driver;
	
	POM pom = new POM(driver);

	@Given("url should be launched")
	public void url_should_be_launched() {
		OpenUrl("https://adactinhotelapp.com/");
	}

	@When("user enter the username")
	public void user_enter_the_username() {
		inputvalues(pom.getUsername(), "Sindhudsm535");
	}

	@When("user enter the password")
	public void user_enter_the_password() {
		inputvalues(pom.getPassword(), "pen@123");
	}

	@Then("user click the login button")
	public void user_click_the_login_button() {
		clickonelement(pom.getLogin());
	}

}
