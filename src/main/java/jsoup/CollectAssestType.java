package jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import readfile.ReadAllUrlFromTextFile;
import writefile.WriteDataToFile;

public class CollectAssestType {

	public static void main(String[] args) {
		Set<String> assestTypeList = new HashSet<String>();
		ReadAllUrlFromTextFile getAll = new ReadAllUrlFromTextFile();
			//initial arrayList from all value of AllUrl.txt
		ArrayList<String> all_url = getAll.getAllUrl();
			// create object for writer
		WriteDataToFile writer = new WriteDataToFile();
			// create path to file for method of WriteDataToFile
		String pathToAssestType = "P:\\ScrappyFazWaz\\ScrappingFazWaz\\Assest_type.txt";
			//create object to get assest url
		CollectAssestType collectBy = new CollectAssestType();
		int i = 1;
		for (String current_url : all_url) {
			if(current_url != null)
			{
				
				assestTypeList.add(collectBy.getAssestTypeFromUrl(current_url));
				
			}
			i++;
			System.out.println("Result now is : " + assestTypeList.size() + assestTypeList);
			System.out.println("Round to complete : " + (all_url.size()-i));
		}
		writer.letWriteFileTo_((ArrayList<String>) assestTypeList, pathToAssestType);
		

	}// end main
	public String getAssestTypeFromUrl(String input_url)
	{
		String result = null;
		try {

			Document doc = Jsoup.connect(input_url).get();
			Elements type = doc.select("div.basic-information__item");
			for (Element x : type) {
				if (x.select("span.basic-information-info > a[href]") != null) {
					if (x.text().contains("ประเภทอสังหาริมทรัพย์")) {
						String temp_value = x.text();
						result = temp_value.substring(21).replaceAll("\\s+", "");
//						System.out.println(result);
					}

				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		return result;
		
	}
}
