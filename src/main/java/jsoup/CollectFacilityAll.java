package jsoup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.util.Elements;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.testng.annotations.Test;

import readfile.ReadAllUrlFromTextFile;
import seleniumwork.GetAllItems;
import writefile.WriteDataToFile;

public class CollectFacilityAll {

//	public static void main(String[] args) {
//		// init
//		// create set to check that must not be dupicate
//		Set<String> facilities = new HashSet<>();
//		// and set into arrayList before send to write to file
//		ArrayList<String> final_facilities = new ArrayList<String>();
//		// init arrayList that have all url
//		ArrayList<String> all_url = new ReadAllUrlFromTextFile().getAllUrl();
//		// init path to write the result
//		String file_path = "P:\\\\ScrappyFazWaz\\\\ScrappingFazWaz\\\\AllFacilities.txt";
//
//		// collect data return as array list
//		// TEST //
//		
//		// add into list
//	}
	@Test
	public void getAllFacilityController() {
		WriteDataToFile write = new WriteDataToFile();
		String file_path = "P:\\\\ScrappyFazWaz\\\\ScrappingFazWaz\\\\AllFacilities.txt";
		ArrayList<String> result = new ArrayList<>();
		ArrayList<String> all_url = new ReadAllUrlFromTextFile().getAllUrl();
		Set<String> final_result = new HashSet<String>();
		CollectFacilityAll collect = new CollectFacilityAll();
		int i = 1;
		while(i < all_url.size())
		{
			
			// loop add result into Set
			result = collect.getUnitFacility(all_url.get(i));
			for (String x : result) {
				final_result.add(x);

			}
			System.out.println("Round : " + (all_url.size() - i) + " to complete...");
			System.out.println("Now have " + final_result.size() + "facilites");
			i++;
			
		}
		ArrayList<String> sendToWrite = new ArrayList<String>();
		for (String q : final_result) {
			sendToWrite.add(q);
		}
		write.letWriteFileTo_(sendToWrite, file_path);
		System.out.println("Write Done.");
	}
	//use this for villa site
	public ArrayList<String> getVillaFacility(String input_url){
		ArrayList<String> result = new ArrayList<>();
		String temp_var = null;
		try {
			Document doc = Jsoup.connect(input_url).get();
			org.jsoup.select.Elements data = doc.select("span.project-features__span > img[alt]");
			for (Element x : data) 
			{
				temp_var = x.attr("alt");
				result.add(temp_var);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;

		}
	
	public ArrayList<String> getUnitFacility(String input_url){
		ArrayList<String> result = new ArrayList<>();
		
		String temp_var = null;
		try {
			Document doc = Jsoup.connect(input_url).get();
			org.jsoup.select.Elements data = doc.select("span.unit-features__item > img[alt]");
			for (Element x : data) 
			{
				temp_var = x.attr("alt");
//				System.out.println(temp_var)
				result.add(temp_var);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	}
