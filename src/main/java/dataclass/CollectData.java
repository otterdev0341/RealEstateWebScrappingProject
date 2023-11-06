package dataclass;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import csv.DataCsv;
import jsoup.WebDataPicker;
import readfile.ReadAllItemFromTextFile;

public class CollectData {
	
	public static void main(String[] args) {
		String test_url = new ReadAllItemFromTextFile().getAllUrl().get(0);
		// main attibute
//		private String assest_id; <!-- DONE -->
//		private String assest_name; <!-- DONE -->
//		private String assest_url; <!-- DONE -->
//		//details attibute
//		private String date_of_post;   <!-- DONE -->
//		private String assest_landmark; <!-- DONE -->
//		private String price_per_sqr_m; <!-- DONE -->
//		private String land_area;  <!-- DONE -->
//		private String floor; <!-- DONE -->
//		private String bedroom; <!-- DONE -->
//		private String useable_area; <!-- DONE -->
		//location
//		private String location; <!-- DONE -->
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
	
	public String helpGetAssest_url(String p_id)
	{
		String id = null;
		
		DataCsv getData = new DataCsv();
		id = getData.takeIdThenReturnUrl(p_id);
		
		
		return id;
	}
	public String HelpGetDate_of_post(String p_id)
	{
		String date_of_post = null;
		WebDataPicker pick_data = new WebDataPicker();
		date_of_post = pick_data.FazWazGetDateOfPost(p_id);
		
		return date_of_post;
	}
	public String helpGetAssest_landmark(String p_id)
	{
		String land_mark = null;
		WebDataPicker pick_data = new WebDataPicker();
		land_mark = pick_data.FazWazGetLandmark(p_id);
		return land_mark;
	}
	public String helpGetPrice_per_sqr_m(String p_id)
	{
		String pricePerSqrM = null;
		WebDataPicker pick_data = new WebDataPicker();
		pricePerSqrM = pick_data.FazWazGetPrice_per_sqr_m(p_id);
		return pricePerSqrM;
	}
	public String helpGetLandArea(String p_id)
	{
		String land_area = null;
		WebDataPicker pick_data = new WebDataPicker();
		land_area = pick_data.FazWazGetLandArea(p_id);
		return land_area;
	}
	public String helpGetFloor(String p_id)
	{
		String floor = null;
		WebDataPicker pick_data = new WebDataPicker();
		floor = pick_data.FazWazGetFloor(p_id);
		return floor;
	}
	public String helpGetBedRoom(String p_id)
	{
		String bedroom = null;
		WebDataPicker pick_data = new WebDataPicker();
		bedroom = pick_data.FazWazGetFloor(p_id);
		return bedroom;
	}
	public String helpGetUseableArea(String p_id)
	{
		String useable_area = null;
		WebDataPicker pick_data = new WebDataPicker();
		useable_area = pick_data.FazWazGetUseableArea(p_id);
		return useable_area;
	}
	public String helpGetLocation(String p_id)
	{
		String location = null;
		WebDataPicker pick_data = new WebDataPicker();
		location = pick_data.FazWazGetLocation(p_id);
		return location;
	}
}
