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

	// get normal driver
	public WebDriver getSeleniumDriver() {
		WebDriver driver = new FirefoxDriver();

		return driver;
	}

	// get headless driver
	public WebDriver getSeleniumHeadlessDriver() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("-headless");
		WebDriver driver = new FirefoxDriver(options);

		return driver;
	}

	// get all url

	public ArrayList<String> seleniumGetAllCoverImages(String p_id) {
		// create object to use unility methon ex:setlog, set sleep
		HelpBySelenium mini = new HelpBySelenium();
		// convert p_id -> url
		DataCsv data = new DataCsv();
		String url_fetch = data.takeIdThenReturnUrl(p_id);
		// create driver
		WebDriver driver = new HelpBySelenium().getSeleniumHeadlessDriver();
		driver.get(url_fetch);
		mini.setLog("Browser open...");
		setSleep(2);

		// create arrayList for return
		ArrayList<String> all_images_link = new ArrayList<>();
		// collect all data
		String xpath = "//div[@class='swiper-slide']";
		List<WebElement> items = driver.findElements(By.xpath(xpath));
		for (WebElement x : items) {
//			all_images_link.add(x.findElement(By.tagName("img")).getAttribute("src"));
			System.out.println(x.findElement(By.tagName("img")).getAttribute("src"));
		}
		driver.close();
		return all_images_link;
	}

	@Test
	public void seleniumGetGeoDetails() {
		// help easy method
		HelpBySelenium mini = new HelpBySelenium();
		// inti test url
		String test_url = "https://www.fazwaz.co.th/%E0%B8%82%E0%B8%B2%E0%B8%A2%E0%B8%9A%E0%B9%89%E0%B8%B2%E0%B8%99/%E0%B8%82%E0%B8%B2%E0%B8%A2-%E0%B8%A7%E0%B8%B4%E0%B8%A5%E0%B8%A5%E0%B9%88%E0%B8%B2-6-%E0%B8%AB%E0%B9%89%E0%B8%AD%E0%B8%87%E0%B8%99%E0%B8%AD%E0%B8%99-%E0%B8%97%E0%B8%B5%E0%B9%88-%E0%B8%A5%E0%B8%B2%E0%B8%81%E0%B8%B9%E0%B8%99%E0%B8%B2-%E0%B8%9E%E0%B8%B2%E0%B8%A3%E0%B9%8C%E0%B8%84-2-%E0%B9%83%E0%B8%99-%E0%B9%80%E0%B8%8A%E0%B8%B4%E0%B8%87%E0%B8%97%E0%B8%B0%E0%B9%80%E0%B8%A5-%E0%B8%A0%E0%B8%B9%E0%B9%80%E0%B8%81%E0%B9%87%E0%B8%95-u1683530";
		// create driver
		WebDriver driver = new HelpBySelenium().getSeleniumDriver();
		driver.get(test_url);
		// check if is visible do A
		mini.setLog("Driver Open...");
		mini.setSleep(2);
		List<WebElement> columns = driver.findElements(By.xpath("//span[@class='highlight__title']"));
		Boolean found_streed_view = false;
		// check if สตรีทวิว is visible
		for (WebElement x : columns) {
//			System.out.println(x.getText());
			if (x.getText().equals("สตรีท วิว")) {
//				System.out.println("พบ สตรีท วิว แล้วนะ");
				found_streed_view = true;
			}
		}

		if (found_streed_view == true) {
			mini.setLog("Click it...");
			List<WebElement> open_streetView = driver.findElements(By.xpath("//a[@href='#streetview']"));
			for (WebElement x : open_streetView) {
				System.out.println(x.getText());
			}
			WebElement test_btn = open_streetView.get(2);
			test_btn.click();
		}
		// find xpath of street view then send click
		// find xpath of street view then send click
		// if it not visible do B
		// if other visible Do C
		// driver exit
		mini.setLog("Closing driver...");
		mini.setSleep(3);
		driver.close();
	}

	public void setSleep(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// send to console
	public void setLog(String context) {
		System.out.println(context);
	}
}
