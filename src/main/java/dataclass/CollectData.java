package dataclass;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import csv.DataCsv;
import readfile.ReadAllUrlFromTextFile;

public class CollectData {
	
	public static void main(String[] args) {
		String test_url = new ReadAllUrlFromTextFile().getAllUrl().get(0);
		// main attibute
//		private String assest_id; <!-- DONE -->
//		private String assest_name;
//		private String assest_url; 
		
	}
	
	public String helpGetAssest_id(String url)
	{
		
		DataCsv check_id = new DataCsv();
		String assest_id = check_id.takeUrlThenReturnId(url);
		
		return (assest_id);
	}
	
	public String helpGetAssest_name(String url)
	{
		
		String name = null;
		
		try {
			
			Document doc = Jsoup.connect(url).get();
			Element assest_name = doc.select("h2.header-data-topic").first();
			name = assest_name.text();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return name;
	}
	
	
}
