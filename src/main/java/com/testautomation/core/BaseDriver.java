package com.testautomation.core;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {

	public static WebDriver driver;
	public static String browser = "firefox";

	public static WebDriver initDriver() {
		if (driver == null) {
			browser = browser.toLowerCase();
			switch (browser) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			default:
				System.out.println("browseType not matched or empty. Invoking HtmlUnitDriver");
				driver = new HtmlUnitDriver();
			}
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://demoblaze.com/");
		}
		else {
			System.out.println("Driver is already initilized");
		}
		return driver;

	}

	public static WebDriver getDriverInstance() {
		if (driver == null) {
			return initDriver();
		}
		return driver;
	}
	public static void exitDriver() {
		driver.quit();
		driver = null;
	}

//		System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
//		System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");
//		System.setProperty("webdriver.edge.driver", "/path/to/msedgedriver.exe");
//		System.setProperty("webdriver.opera.driver", "/path/to/operadriver");
//		System.setProperty("phantomjs.binary.path", "/path/to/phantomjs");
//		System.setProperty("webdriver.ie.driver", "C:/path/to/IEDriverServer.exe");
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

    }

}
