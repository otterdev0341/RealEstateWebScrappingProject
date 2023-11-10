package collectPrice;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import csv.DataCsv;

public class JsoupGetPrice {
	
	
	public String JsoupGetPrice(String p_id)
	{
//		String test_url = "https://www.fazwaz.co.th/%E0%B8%82%E0%B8%B2%E0%B8%A2%E0%B8%9A%E0%B9%89%E0%B8%B2%E0%B8%99/%E0%B8%82%E0%B8%B2%E0%B8%A2-%E0%B8%97%E0%B8%B2%E0%B8%A7%E0%B8%99%E0%B9%8C%E0%B9%80%E0%B8%AE%E0%B9%89%E0%B8%B2%E0%B8%AA%E0%B9%8C-3-%E0%B8%AB%E0%B9%89%E0%B8%AD%E0%B8%87%E0%B8%99%E0%B8%AD%E0%B8%99-%E0%B8%97%E0%B8%B5%E0%B9%88-%E0%B8%A8%E0%B8%B8%E0%B8%A0%E0%B8%B2%E0%B8%A5%E0%B8%B1%E0%B8%A2-%E0%B8%A5%E0%B8%B2%E0%B8%81%E0%B8%B9%E0%B8%99-%E0%B8%A0%E0%B8%B9%E0%B9%80%E0%B8%81%E0%B9%87%E0%B8%95-%E0%B9%83%E0%B8%99-%E0%B9%80%E0%B8%81%E0%B8%B2%E0%B8%B0%E0%B9%81%E0%B8%81%E0%B9%89%E0%B8%A7-%E0%B8%A0%E0%B8%B9%E0%B9%80%E0%B8%81%E0%B9%87%E0%B8%95-u1687550";
		
		//Tranfor id to url
		DataCsv getData = new DataCsv();
		String url = getData.takeIdThenReturnUrl(p_id);
		
		
		String price = "";
		Element getPrice = null;
		try {
			Document doc = Jsoup.connect(url).get();
			
			if(doc.selectXpath("//div[@class='price-message']") != null)
			{
				getPrice = doc.selectXpath("//div[@class='price-message']").first();
			}else if((doc.selectXpath("//div[@class='new-investment-value']").first())!=null) {
				getPrice = doc.selectXpath("//div[@class='new-investment-value']").first();
			}else {
				getPrice = null;
			}
			
			
//			System.out.println(getPrice.text());
			
			price = getPrice.text().substring(1).replaceAll(",", "");
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		return price;
	}
	
}
