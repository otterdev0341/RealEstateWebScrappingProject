package jsoup;

import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import csv.DataCsv;

public class WebDataPicker {

	public static void main(String[] args) {
		WebDataPicker picker = new WebDataPicker();
		String test_data = picker.FazWazGetAssestType("10");
		ArrayList<String> facilities_test = picker.FazWazGetFacilites("10");
		for (String x : facilities_test) {
			System.out.println(x);
		}

	}

	public String FazWazGetDateOfPost(String p_id) {
		String date_of_post = null;
		DataCsv data = new DataCsv();
		String url_fetch = data.takeIdThenReturnUrl(p_id);

		try {
			Document doc = Jsoup.connect(url_fetch).get();
			Element extract_dada = doc.select("span.basic-information-info").first();
			date_of_post = extract_dada.text();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date_of_post;
	}

	public String FazWazGetLandmark(String p_id) {
		String landmark = null;
		DataCsv data = new DataCsv();
		String url_fetch = data.takeIdThenReturnUrl(p_id);

		try {
			Document doc = Jsoup.connect(url_fetch).get();
			Elements extract_data = doc.selectXpath("//span[@class='basic-information-info']");
			landmark = extract_data.get(3).text();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return landmark;
	}

	public String FazWazGetPrice_per_sqr_m(String p_id) {
		String pricePerSqrM = null;
		DataCsv getId = new DataCsv();
		String fetch_url = getId.takeIdThenReturnUrl(p_id);

		try {
			Document doc = Jsoup.connect(fetch_url).get();
			Elements listData = doc.select("span.basic-information-info");
			String temp_data = listData.get(8).text().replace('฿', ' ').trim();
			pricePerSqrM = temp_data.replace(",", "");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pricePerSqrM;
	}

	public String FazWazGetLandArea(String p_id) {
		String landArea = null;
		DataCsv getId = new DataCsv();
		String fetch_url = getId.takeIdThenReturnUrl(p_id);

		try {
			Document doc = Jsoup.connect(fetch_url).get();
			Elements listData = doc.select("span.basic-information-info");
			String temp_data = listData.get(10).text().replace(",", "").trim();
			landArea = temp_data.replaceAll(" ตรว.", "");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return landArea;
	}

	public String FazWazGetFloor(String p_id) {
		String floor = null;
		DataCsv getId = new DataCsv();
		String fetch_url = getId.takeIdThenReturnUrl(p_id);

		try {
			Document doc = Jsoup.connect(fetch_url).get();
			Elements listData = doc.select("span.basic-information-info");
			floor = listData.get(3).text();
			System.out.println(floor);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return floor;
	}
	
	public String FazWazGetBedroom(String p_id)
	{
		String bedroom = null;
		DataCsv getId = new DataCsv();
		String fetch_url = getId.takeIdThenReturnUrl(p_id);
		
		try {
			Document doc = Jsoup.connect(fetch_url).get();
			Elements listData = doc.select("span.basic-information-info");
			bedroom = listData.get(5).text();
			System.out.println(bedroom);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bedroom;
	}
	public String FazWazGetUseableArea(String p_id)
	{
		String useable_area = null;
		DataCsv getId = new DataCsv();
		String fetch_url = getId.takeIdThenReturnUrl(p_id);
		try {
			Document doc = Jsoup.connect(fetch_url).get();
			Elements listData = doc.select("span.basic-information-info");
			String temp_data = listData.get(7).text().replace(",", "").trim();
			useable_area = temp_data.replaceAll(" ตรม.", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return useable_area;
	}
	public String FazWazGetLocation(String p_id)
	{
		String location = null;
		DataCsv getId = new DataCsv();
		String fetch_url = getId.takeIdThenReturnUrl(p_id);
		try {
			Document doc = Jsoup.connect(fetch_url).get();
			Elements listData = doc.select("span.basic-information-info");
			location = listData.get(4).text().replaceAll(" ", "").trim();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}
	public String FazWazGetAssestType(String p_id)
	{
		String assestType = null;
		String assestIndex = null;
		DataCsv getId = new DataCsv();
		String fetch_url = getId.takeIdThenReturnUrl(p_id);
		try {
			//fetch assest type
			Document doc = Jsoup.connect(fetch_url).get();
			Elements listData = doc.select("span.basic-information-info");
			assestType = listData.get(2).text().replaceAll(" ", "").trim();
			
			//compare to our csv to get index
			DataCsv compare = new DataCsv();
			assestIndex = compare.takeAssestTypeThenReturnIndex(assestType);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return assestIndex;
	}
	@Test
	public ArrayList<String> FazWazGetFacilites(String p_id)
	{
		ArrayList<String> facilities = new ArrayList<>();
		ArrayList<String> temp_list = new ArrayList<>();
		DataCsv getId = new DataCsv();
		String fetch_url = getId.takeIdThenReturnUrl(p_id);
		try {
			//fetch all facilites
			Document doc = Jsoup.connect(fetch_url).get();
			Elements datalist = doc.select("span.unit-features__item");
			// add into arraylist
			for (Element x : datalist) {
//				System.out.println(x.text());
				temp_list.add(x.text());
				
			}
			//send to check and add the index
			DataCsv getAllIndex = new DataCsv();
			facilities = getAllIndex.takeAllOfFacilitiesThenReturnIndex(temp_list);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return facilities;
	}
}
