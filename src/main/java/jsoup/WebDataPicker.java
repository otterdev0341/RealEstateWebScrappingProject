package jsoup;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import csv.DataCsv;

public class WebDataPicker {

	public static void main(String[] args) {
		WebDataPicker picker = new WebDataPicker();
		String test_data = picker.FazWazGetLandArea("10");

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
	public String FazWazGetLandArea(String p_id)
	{
		String landArea = null;
		DataCsv getId = new DataCsv();
		String fetch_url = getId.takeIdThenReturnUrl(p_id);
		
		try {
			Document doc = Jsoup.connect(fetch_url).get();
			Elements listData = doc.select("span.basic-information-info");
			String temp_data = listData.get(7).text().replace(",", "");
			landArea = temp_data.replaceAll(" ตรม.", "");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return landArea;
	}
	public String FazWazGetFloor(String p_id)
	{
		String floor = null;
		DataCsv getId = new DataCsv();
		String fetch_url = getId.takeIdThenReturnUrl(p_id);
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return floor;
	}
}
