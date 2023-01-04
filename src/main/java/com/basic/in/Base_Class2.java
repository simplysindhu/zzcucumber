package com.basic.in;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class2 {
	public static WebDriver driver;

	public static WebDriver webpage(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"S:\\eclipse-java-2019-06-R-win32-x86_64\\eclipse\\practicing space\\ZZCucumber\\driver\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"S\\eclipse-java-2019-06-R-win32-x86_64\\eclipse\\practicing space\\Mavenprojectmorng\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else {
			System.out.println("check the browser name");
		}
		return driver;
	}

	public static void OpenUrl(String Url) {
		driver.get(Url);
	}

	public static void ClosethePage() {
		driver.close();
	}

	public static void quittheBrowser() {
		driver.quit();
	}

	public static void clickonelement(WebElement ele) {
		ele.click();
	}

	public static void inputvalues(WebElement ele, String str) {
		ele.sendKeys(str);
	}

	public static void isSelected(WebElement el) {
		boolean selected = el.isSelected();
		System.out.println(selected);
	}

	public static void printText(WebElement e) {
		String text = e.getText();
		System.out.println(text);
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static void getcrurl() {
		driver.getCurrentUrl();
	}

	public static void titlename() {
		driver.getTitle();
	}

	public static void leftclick(WebElement ele) {
		Actions ac = new Actions(driver);
		ac.click(ele).build().perform();
	}

	public static void rightclick(WebElement ele) {
		Actions ac = new Actions(driver);
		ac.contextClick(ele).build().perform();
	}

	public static void doubleclick(WebElement ele) {
		Actions ac = new Actions(driver);
		ac.doubleClick(ele).build().perform();
	}

	public static void mouseover(WebElement ele) {
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).build().perform();
	}

	public static void navigateto(String Url) {
		driver.navigate().to(Url);
	}

	public static void navigateforward() {
		driver.navigate().forward();

	}

	public static void navigateback() {
		driver.navigate().back();

	}

	public static void navigateRefresh() {
		driver.navigate().refresh();

	}

	public static void screenshot(String loc) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(loc);
		FileUtils.copyFile(screenshotAs, dest);
	}

	public static void Robot(WebElement ele) throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void Alertsimple(WebElement ele, String value) {
		ele.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	public static void Alertss(WebElement ele, WebElement e, String value) {
		ele.click();
		e.click();
		Alert alert = driver.switchTo().alert();

		if (value.equals("accept")) {
			alert.accept();
			driver.switchTo().defaultContent();

		}

		else {
			alert.dismiss();
			driver.switchTo().defaultContent();

		}

	}

	public static void proAlert(WebElement ele, WebElement e, String pass, String value) {
		ele.click();
		e.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(pass);
		if (value.equals("accept")) {
			alert.accept();
			driver.switchTo().defaultContent();
		} else {
			alert.dismiss();
			driver.switchTo().defaultContent();
		}
	}

	public static void Alerttext(WebElement ele, String value) {
		ele.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	public static void getwindowhandles() {
		Set<String> allid = driver.getWindowHandles();
		for (String id : allid) {
			driver.switchTo().window(id).getTitle();
			System.out.println("title");
		}
		String mypage = "loc";
		for (String i : allid) {
			if (driver.switchTo().window(i).getTitle().equals(mypage)) {
				break;
			}

		}

	}

	public static void dropdown(WebElement ele, String type, String ind, String text) {
		Select s = new Select(ele);
		if (type.equals("index")) {
			s.selectByIndex(Integer.parseInt(ind));
		} else if (type.equals("value")) {
			s.selectByValue(type);
		} else if (type.equals("text")) {
			s.selectByVisibleText(text);
		}

	}

	public static void ImplicitWait(WebElement ele) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	public static void explicitwait(WebElement ele) {
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void fluentwait(WebElement ele) {
		Wait fwait = new FluentWait(driver).withTimeout(Duration.ofMinutes(15)).pollingEvery(Duration.ofSeconds(30))
				.ignoring(Exception.class);
	}

	public static void dragdrop(WebElement ele1, WebElement ele2) {
		Actions ac = new Actions(driver);
		ac.dragAndDrop(ele1, ele2).build().perform();
	}

	public static void iframe(WebElement ele) {
		driver.switchTo().frame(ele);
	}

	public static void scroll(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}

	public static void getoptions(WebElement ele) {
		Select t = new Select(ele);
		List<WebElement> options = t.getOptions();
		for (WebElement t1 : options) {
			System.out.println(t1.getText());
		}
	}

	public static void firstSelectedOption(WebElement ele) {
		Select s = new Select(ele);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
	}

	public static void ismultiple(WebElement ele) {
		Select s = new Select(ele);
		boolean multiple = s.isMultiple();

	}

}
