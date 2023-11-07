package seleniumwork;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import csv.DataCsv;

public class HelpBySelenium {
	
	//get normal driver
	public WebDriver getSeleniumDriver()
	{
		WebDriver driver = new FirefoxDriver();
		
		return driver;
	}
	//get headless driver
	public WebDriver getSeleniumHeadlessDriver()
	{
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("-headless");
		WebDriver driver = new FirefoxDriver(options);
		
		return driver;
	}
	
	//get all url
	
	public ArrayList<String> seleniumGetAllCoverImages(String p_id)
	{
		//create object to use unility methon ex:setlog, set sleep
		HelpBySelenium mini = new HelpBySelenium();
		//convert p_id -> url
		DataCsv data = new DataCsv();
		String url_fetch = data.takeIdThenReturnUrl(p_id);
		//create driver
		WebDriver driver = new HelpBySelenium().getSeleniumHeadlessDriver();
		driver.get(url_fetch);
		mini.setLog("Browser open...");
		setSleep(2);
		
		//create arrayList for return
		ArrayList<String> all_images_link = new ArrayList<>();
		//collect all data
		String xpath = "//div[@class='swiper-slide']";
		List<WebElement> items = driver.findElements(By.xpath(xpath));
		for (WebElement x : items) {
//			all_images_link.add(x.findElement(By.tagName("img")).getAttribute("src"));
			System.out.println(x.findElement(By.tagName("img")).getAttribute("src"));
			
		}
		
		driver.close();
		return all_images_link;
		
	}
	
	
	//sleep
	public void setSleep(int second)
	{
		try {
			Thread.sleep(second * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//send to console
	public void setLog(String context)
	{
		System.out.println(context);
	}
}
