package com.testautomation.driver;

import static org.testng.Assert.assertTrue;

import org.apache.bcel.generic.LADD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.testautomation.core.BaseDriver;

public class TestDriver {
	
	@Test
	public void ProductPurchase() throws InterruptedException {
		WebDriver driver = BaseDriver.initDriver();
		
//		Landing Page
		String landingPageVerfiyText = driver.findElement(By.id("nava")).getText().trim();
		System.out.println(landingPageVerfiyText);
//		System.out.println((landingPageVerfiyText.equals("PRODUCT STORE");
		assertTrue(landingPageVerfiyText.equals("PRODUCT STORE"), "DemoBlaze landing page NOT loaded");
		
		driver.findElement(By.linkText("Samsung galaxy s6")).click();
		
//		Product Page
		String productPage = driver.findElement(By.cssSelector("h2.name")).getText().trim();
		assertTrue(productPage.equals("Samsung galaxy s6"), "Product page NOT loaded");
		Thread.sleep(5000);
		driver.findElement(By.linkText("Add to cart")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.findElement(By.linkText("Cart")).click();
		Thread.sleep(3000);
		
//		Payment Page
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		driver.findElement(By.id("name")).sendKeys("Test");
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("city")).sendKeys("Hyderbad");
		driver.findElement(By.id("card")).sendKeys("4811 1111 1111 1114");
		driver.findElement(By.id("month")).sendKeys("12");
		driver.findElement(By.id("year")).sendKeys("2024");
		driver.findElement(By.cssSelector("#orderModal button.btn.btn-primary")).click();
		
		String successMsg = driver.findElement(By.cssSelector("div.sweet-alert.showSweetAlert.visible h2")).getText().trim();
		System.out.println(successMsg);
		assertTrue(successMsg.equals("Thank you for your purchase!"), "Purchase was NOT successfull");
		String purchaseDetails = driver.findElement(By.cssSelector("p.lead.text-muted")).getText().trim();
		System.out.println(purchaseDetails);
		driver.findElement(By.cssSelector("button.confirm.btn.btn-lg.btn-primary")).click();
		
		driver.quit();	
			
	}

}
