package seleniumwork;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GetAllItems {
	
	ArrayList<String> assest_list = new ArrayList<>();
	@Test
	public void getAllPages() {
		//defind 1st url
		String first_url = "https://www.fazwaz.co.th/%E0%B8%82%E0%B8%B2%E0%B8%A2%E0%B8%9A%E0%B9%89%E0%B8%B2%E0%B8%99/%E0%B8%A0%E0%B8%B9%E0%B9%80%E0%B8%81%E0%B9%87%E0%B8%95?type=villa,house,townhouse&mapEnable=0";
		String second_url = "https://www.fazwaz.co.th/%E0%B8%82%E0%B8%B2%E0%B8%A2%E0%B8%9A%E0%B9%89%E0%B8%B2%E0%B8%99/%E0%B8%A0%E0%B8%B9%E0%B9%80%E0%B8%81%E0%B9%87%E0%B8%95?type=villa,house,townhouse&mapEnable=0&order_by=rank|asc&page=2";
		String last_url = "https://www.fazwaz.co.th/%E0%B8%82%E0%B8%B2%E0%B8%A2%E0%B8%9A%E0%B9%89%E0%B8%B2%E0%B8%99/%E0%B8%A0%E0%B8%B9%E0%B9%80%E0%B8%81%E0%B9%87%E0%B8%95?type=villa,house,townhouse&mapEnable=0&order_by=rank|asc&page=77";
		int page = 2;
		//create driver
		
		WebDriver driver = new FirefoxDriver();
		driver.get(first_url);
		sendLog("Driver Created");
		setSleep(3);
		
		// if it first_url need to wait to handle popup
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
		}
		setSleep(5);
		
		// if first_url != last url collect data and go next
		
		// append data into assestList
		// call write into file method
		// go next page
		// close driver
		sendLog("Close Driver.");
		driver.close();
		
	}
	@Test
	public void getAllItems() {
		
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
