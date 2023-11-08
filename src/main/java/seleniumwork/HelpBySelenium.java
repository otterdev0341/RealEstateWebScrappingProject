package seleniumwork;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		String collect_url = null;
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
		// do if found สตรีท วิว
		if (found_streed_view == true) 
		{
			//click cover images to open new tab
			setLog("Open cover image");
			WebElement cover_image = driver.findElement(By.xpath("//a[@class='photo-gallery-detail-page__main-box modal-toggle']"));
			cover_image.click();		
			setSleep(1);
			//go to street view tab
			setLog("Choose street view tab..");
			List<WebElement> streetViewList = driver.findElements(By.xpath("//li[@class='nav-item']"));
			WebElement streetViewTab = null;
			for (WebElement x : streetViewList) {
				if(x.getText().equals("สตรีท วิว"))
				{
					streetViewTab = x;
				}
//				System.out.println(x.getText());
			}
			setLog("Street tab open..");
			streetViewTab.click();
			setSleep(1);
			// click link url
			// chagee to new tab
			// click to location icon
			// get current url
			setLog("Try to click google map link.");
			WebElement gg_map_link = driver.findElement(By.xpath("//div[@class='gm-iv-address-link']"));
			gg_map_link.click();
			// >>> Collect all tab
			
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			
			// --> swith to tab 2
			setLog("move to new tab");
			driver.switchTo().window(tabs.get(1));
			setLog("Working on tab 2");
			// wait until map loading done
			WebDriverWait wait_loading_map = new WebDriverWait(driver, Duration.ofSeconds(7));
			WebElement loding_map = wait_loading_map.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='แสดงตำแหน่งบนแผนที่']")));
			// find xpath of streetView icon then send click
			WebElement new_tab_icon = driver.findElement(By.xpath("//button[@aria-label='แสดงตำแหน่งบนแผนที่']"));
			setLog("Working on tab 2");
			new_tab_icon.click();
			setLog("Url collected");
			collect_url = driver.getCurrentUrl();
			System.out.println(collect_url);
			setSleep(2);
			driver.close();
			setLog("Move to original tab");
			// --> swith to tab 1 
			driver.switchTo().window(tabs.get(0));
		}
		//check and do
		if(collect_url != null)
		{
			//call geo function then assign to array and return all data
			
		}

		
		
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
