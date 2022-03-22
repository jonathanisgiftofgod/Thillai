package org.openorangethillai;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	static WebDriver driver;
	@BeforeClass
	public static void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@Before
	public void launchUrl() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	@Test
	public void test1() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}
	@After
	public void test2() {
		WebElement element = driver.findElement(By.xpath("//a[text()='Welcome Paul']"));
		String text = element.getText();
		Assert.assertTrue(text.contains("Welcome"));
	}
	@AfterClass
	public static void test3() {
		driver.quit();
		System.out.println("All the best");
	}
}
