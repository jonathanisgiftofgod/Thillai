package org.thillai;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenOrange {
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(Base.readValue("Sheet2", 0, 0));
		driver.findElement(By.id("txtPassword")).sendKeys(Base.readValue("Sheet2", 1, 0));
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("txtUsername")).getAttribute("value");
	}
}
