package dataclass;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import csv.DataCsv;


public class AssetUtill {
	public static void main(String[] args) {
		
	}
	
	@Test
	public void initAllAssest() throws IOException
	{	
		// init arrayList to return
		ArrayList<AssestDetail> AssestData = new ArrayList<>();
		//get all id to call all method
		ArrayList<String> allId = new DataCsv().initAllIdIntoArrayList();
		
		//use collecDta to init each variable
		CollectData controller = new CollectData();
		AssestDetail temp_assest = new AssestDetail();
		//test Write		
		WriteObjectToCsv letWrite = new WriteObjectToCsv();
		
		int i = 2095;
		String id = Integer.toString(i);
//		for (String id : allId) {
		while(i < allId.size())
		{
			System.out.println("Working on ID : " + id);
			System.out.println("=============================");
			
			temp_assest.setAssest_id(id);
			temp_assest.setAssest_name(controller.helpGetAssest_name(id));
			temp_assest.setAssest_url(controller.helpGetAssest_url(id));
			
			temp_assest.setDate_of_post(controller.HelpGetDate_of_post(id));
			temp_assest.setAssest_landmark(controller.helpGetAssest_landmark(id));
			temp_assest.setPrice_per_sqr_m(controller.helpGetPrice_per_sqr_m(id));
			temp_assest.setLand_area(controller.helpGetLandArea(id));
			temp_assest.setFloor(controller.helpGetFloor(id));
			temp_assest.setBedroom(controller.helpGetBedRoom(id));
			temp_assest.setUseable_area(controller.helpGetUseableArea(id));
			
			temp_assest.setLocation(controller.helpGetLocation(id));
			
			temp_assest.setAssest_type(controller.helpGetIndexAssestType(id));
			
			temp_assest.setAssest_facilities(controller.helpGetIndexFacilities(id));
			
			temp_assest.setAssest_images(controller.helpGetAllAssestImages(id));
			
			temp_assest.setGeo_details(controller.helpGetAllGeoDetails(id));
			//test writer
			letWrite.writeMainDetail(temp_assest);
			letWrite.writeFacilitiesTransection(temp_assest);
			letWrite.writeImagesTransection(temp_assest);
			letWrite.writeGeoTransection(temp_assest);
			System.out.println("All write done..");
			System.out.println("=============================");
			System.out.println("have " + (allId.size() - Integer.parseInt(id)) + " to complete...");
		i++;	
			id = Integer.toString(i);
		}

	}
}
