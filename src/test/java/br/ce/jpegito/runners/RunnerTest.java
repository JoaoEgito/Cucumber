package br.ce.jpegito.runners;
import org.junit.BeforeClass;
import org.junit.runner.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "br.ce.jpegito.steps",
		tags = "@tag",
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = false,
		snippets = SnippetType.CAMELCASE,
		dryRun = false
		)
public class RunnerTest {
	
	@BeforeClass
	public static void reset() {
		System.setProperty("webdriver.chrome.driver","/Users/joaoegito/Projects/selenium-drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/");
		driver.findElement(By.id("email")).sendKeys("a1@a1.com");
		driver.findElement(By.id("senha")).sendKeys("12345");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}
	

}
