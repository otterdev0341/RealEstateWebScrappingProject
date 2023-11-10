package dataclass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.internal.junit.ArrayAsserts;

import com.opencsv.CSVWriter;

import collectPrice.AssestPrice;

public class WriteObjectToCsv {
	/*
	 * assest_id, assest_name, assest_url, date_of_post, assest_landmark,
	 * price_per_sqr_m, land_area, floor, bedroom useable_area, location,
	 * assest_type -->> ASSEST_DETAIL.csv
	 * 
	 * assest_facilities : transaction (id, assest_facilities_code) -->>
	 * ASSEST_FAC_TSN.csv
	 * 
	 * assest_image : transaction (id, assest_image_url) -->> ASSEST_IMG_TSN.csv
	 * 
	 * geo_details : transaction (id, lat, long, map_url) -->> ASSEST_GEO_TSN.csv
	 * 
	 */
	public void WriteAssestPriceTN(AssestPrice AP)throws IOException
	{
		File file_name = new File("P:\\ScrappyFazWaz\\ScrappingFazWaz\\ExportData\\ASSEST_PRICE_TN.csv");
		try {
			FileWriter outputfile = null;
			if(AP.getId().equals("0"))
			{
				outputfile = new FileWriter(file_name);
			}else {
				outputfile = new FileWriter(file_name,true);
			}
			CSVWriter writer = new CSVWriter(outputfile);
			List<String[]> data = new ArrayList<String[]>();
			if(AP.getId().equals("0"))
			{
				data.add(new String[] {"AssestID","AssestPrice"});
			}
			data.add(new String[] {AP.getId(), AP.getPrice()});
			writer.writeAll(data);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void writeMainDetail(AssestDetail AD) throws IOException {
		File file_main = new File("P:\\ScrappyFazWaz\\ScrappingFazWaz\\ExportData\\ASSEST_DETAIL.csv");

		try {
			FileWriter outputfile = null;
			if(AD.getAssest_id().equals("0"))
			{
				outputfile = new FileWriter(file_main);
			}else {
				outputfile = new FileWriter(file_main,true);
			}
			
			// setup place to write
//			FileWriter outputfile = new FileWriter(file_main);
			
			// create csv write
			CSVWriter writer = new CSVWriter(outputfile);

			// contain array
			List<String[]> data = new ArrayList<String[]>();

			//add header
			if(AD.getAssest_id().equals("0"))
			{
				data.add(new String[] { "AssestID", "AssestName", "AssestUrl", "DateOfPost", "AssestLandmark",
						"PricePerSqrM", "LandArea", "Floor", "Bedroom", "UseableArea", "Location", "AssestType" });
			}
			
			data.add(new String[] { AD.getAssest_id(), AD.getAssest_name(), AD.getAssest_url(), AD.getDate_of_post(),
					AD.getAssest_landmark(), AD.getPrice_per_sqr_m(), AD.getLand_area(), AD.getFloor(), AD.getBedroom(),
					AD.getUseable_area(), AD.getLocation(), AD.getAssest_type() });
			writer.writeAll(data);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void writeFacilitiesTransection(AssestDetail AD) throws IOException {
		File file_facilities = new File("P:\\ScrappyFazWaz\\ScrappingFazWaz\\ExportData\\ASSEST_FAC_TSN.csv");
		// get Array of facilities from Object(AD)
		AssestDetail temp_AD = AD;
		ArrayList<String> temp_facilities = temp_AD.getAssest_facilities();
		try {
			FileWriter outputfile = null;
			if(AD.getAssest_id().equals("0"))
			{
				outputfile = new FileWriter(file_facilities);
			}else {
				outputfile = new FileWriter(file_facilities,true);
			}
			//setup place to write
//			FileWriter outputfile = new FileWriter(file_facilities);
			CSVWriter writter = new CSVWriter(outputfile);
			// contain array
			
			List<String[]> data = new ArrayList<String[]>();
			
			// add header
			if(AD.getAssest_id().equals("0")) {
				data.add(new String[] { "AssestID", "FacilityID" });
			}
			
			// add facility
			for (String x : temp_facilities) {
				data.add(new String[] { AD.getAssest_id(), x });
			}
			writter.writeAll(data);
			writter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeImagesTransection(AssestDetail AD) throws IOException {
		File file_images = new File("P:\\ScrappyFazWaz\\ScrappingFazWaz\\ExportData\\ASSEST_IMG_TSN.csv");
		// get Array of facilities from Object(AD)
		AssestDetail temp_AD = AD;
		ArrayList<String> temp_imgs = temp_AD.getAssest_images();
		try {
			FileWriter outputfile = null;
			if(AD.getAssest_id().equals("0")){
				outputfile = new FileWriter(file_images);
			}else {
				outputfile = new FileWriter(file_images,true);
			}
			//set object to writer
//			FileWriter outputfile = new FileWriter(file_images);
			CSVWriter writter = new CSVWriter(outputfile);
			// contain array
			List<String[]> data = new ArrayList<String[]>();
			// add header
			if(AD.getAssest_id().equals("0"))
			{
				data.add(new String[] { "AssestID", "ImageURL" });
			}
			
			// add images
			for (String x : temp_imgs) {
				data.add(new String[] { AD.getAssest_id(), x });
			}
			writter.writeAll(data);
			writter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeGeoTransection(AssestDetail AD) throws IOException {
		File file_geo = new File("P:\\ScrappyFazWaz\\ScrappingFazWaz\\ExportData\\ASSEST_GEO_TSN.csv");
		// get Array of facilities from Object(AD)
		AssestDetail temp_AD = AD;
		ArrayList<String> temp_geo = temp_AD.getGeo_details();
		try {
			FileWriter outputfile = null;
			if(AD.getAssest_id().equals("0")) {
				outputfile = new FileWriter(file_geo);
			}else {
				outputfile = new FileWriter(file_geo,true);
			}
			//set object to writer
//			FileWriter outputfile = new FileWriter(file_geo);
			CSVWriter writter = new CSVWriter(outputfile);
			// contain array
			List<String[]> data = new ArrayList<String[]>();
			// add header
			if(AD.getAssest_id().equals("0"))
			{
				data.add(new String[] { "AssestID", "Lat", "Long", "GeoURL" });
			}
			
			// add Geo detail
			data.add(new String[] { AD.getAssest_id(), temp_geo.get(0), temp_geo.get(1), temp_geo.get(2) });

			writter.writeAll(data);
			writter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
