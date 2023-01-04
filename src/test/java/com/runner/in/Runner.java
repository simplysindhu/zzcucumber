package com.runner.in;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.basic.in.Base_Class2;
import com.properties.in.FileReader;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "S:\\eclipse-java-2019-06-R-win32-x86_64\\eclipse\\practicing space\\ZZCucumber\\src\\test\\java\\com\\script\\in\\scripts.feature"
		, glue = "com.step.in")

public class Runner {

	public static WebDriver driver;

	@BeforeClass
	public static void setup() throws Exception {
		String browser = FileReader.fileReaderFR().ConfigReaderCR().getBrowser();
		driver = Base_Class2.webpage(browser);
	}

	
		

	}
	
	
	
	
	
	
	
	

