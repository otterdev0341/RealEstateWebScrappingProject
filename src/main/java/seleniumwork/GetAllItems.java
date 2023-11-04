package seleniumwork;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import writefile.WriteDataToFile;

public class GetAllItems {
	
	ArrayList<String> assest_list = new ArrayList<>();
	@Test
	public void getAllPages() {
		//defind 1st url
		String first_url = "https://www.fazwaz.co.th/%E0%B8%82%E0%B8%B2%E0%B8%A2%E0%B8%9A%E0%B9%89%E0%B8%B2%E0%B8%99/%E0%B8%A0%E0%B8%B9%E0%B9%80%E0%B8%81%E0%B9%87%E0%B8%95?type=villa,house,townhouse&mapEnable=0";
		String second_url = "https://www.fazwaz.co.th/%E0%B8%82%E0%B8%B2%E0%B8%A2%E0%B8%9A%E0%B9%89%E0%B8%B2%E0%B8%99/%E0%B8%A0%E0%B8%B9%E0%B9%80%E0%B8%81%E0%B9%87%E0%B8%95?type=villa,house,townhouse&mapEnable=0&order_by=rank|asc&page=2";
		String last_url = "https://www.fazwaz.co.th/%E0%B8%82%E0%B8%B2%E0%B8%A2%E0%B8%9A%E0%B9%89%E0%B8%B2%E0%B8%99/%E0%B8%A0%E0%B8%B9%E0%B9%80%E0%B8%81%E0%B9%87%E0%B8%95?type=villa,house,townhouse&mapEnable=0&order_by=rank|asc&page=77";
		String flex_url = "https://www.fazwaz.co.th/%E0%B8%82%E0%B8%B2%E0%B8%A2%E0%B8%9A%E0%B9%89%E0%B8%B2%E0%B8%99/%E0%B8%A0%E0%B8%B9%E0%B9%80%E0%B8%81%E0%B9%87%E0%B8%95?type=villa,house,townhouse&mapEnable=0&order_by=rank|asc&page=";
		int page = 2;
		//create write Object
		WriteDataToFile writeItOn = new WriteDataToFile();
		//create driver
		
		WebDriver driver = new FirefoxDriver();
		driver.get(first_url);
		sendLog("Driver Created");
		setSleep(3);
		
		// if it first_url need to wait to handle popup
		//resue
		String current_url = driver.getCurrentUrl();
		
		if(first_url.equals(current_url))
		{
			//catch 1st popup wait for 60 second.
			WebDriverWait handle_popup_1 = new WebDriverWait(driver, Duration.ofSeconds(6000));
			WebElement pop_up_1 = handle_popup_1.until(ExpectedConditions.elementToBeClickable(By.id("onesignal-slidedown-cancel-button")));
			pop_up_1.click();
			sendLog("Done with 1st popup.. in 1st page");
			
			//catch 2nd popup wait for 60 second
			WebDriverWait handle_popup_2 = new WebDriverWait(driver, Duration.ofSeconds(6000));
			WebElement pop_up_2 = handle_popup_2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='questions-contact__form']")));
			WebElement btn_close_pup_up_2 = driver.findElement(By.xpath("//input[@placeholder='ชื่อ - นามสกุล']"));
			btn_close_pup_up_2.click();
			btn_close_pup_up_2.sendKeys(Keys.ESCAPE);
			sendLog("Done with 2nd popup in 1st page");
			sendLog("Start collect data...");
			setSleep(5);
			
			//collect like on site store to temp List
			List<WebElement> collection_line = driver.findElements(By.xpath("//a[@class='link-unit']"));
			//append data into ArrayList
			sendLog("Add data into aray List");
			for(WebElement x : collection_line)
			{
				assest_list.add(x.getAttribute("href"));
			}
			sendLog("Write data into file");
			writeItOn.letWriteFile(assest_list);
			setSleep(3);
			
			//if no the first_page Area
			//go into this else mean : it not the fist page for sure
			while(page <= 77) //now i know the last page is no.77
			{
				sendLog("now on page : "+page);
				//every while set to page to equle var page
				//chage site of driver depend of value of page
				driver.navigate().to(flex_url+page);
				setSleep(5);
				//collect all link and add into ArrayList
				List<WebElement> collected_list = driver.findElements(By.xpath("//a[@class='link-unit']"));
				for(WebElement x : collected_list)
				{
					assest_list.add(x.getAttribute("href"));
				}
				sendLog("collected done now wil change to page.");
				//write the link of page into file
				writeItOn.letWriteFile(assest_list);
				sendLog("All wirte out into file");
				//clear temp list for collect the new page
				collected_list.clear();
				sendLog("temp List now clear");
				
				page++;
				sendLog("incressing page to : " + page);
				sendLog((77-page)+" round to complete collected...");
				setSleep(1);
			}
			
		
		
		
		
		
		// if first_url != last url collect data and go next
		
			//wait untill the data present
		
		
		//-> take current url and drive
		// collect element in site
		
		// append data into assestList
		// call write into file method
		// go next page
		// close driver
		sendLog("Close Driver.");
		driver.close();
		
	}
	}

	
	public void getAllItems(WebDriver driver) {
		
		
	}
	
	// method for set sleep to wait browser work
	public void setSleep(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
	//method to print log instend of sysout
	public void sendLog(String log_detail) {
		System.out.println(log_detail);
	}
}
