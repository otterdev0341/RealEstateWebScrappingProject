package csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.google.common.io.FileWriteMode;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import readfile.ReadAllItemFromTextFile;

public class DataCsv {

//	public static void main(String[] args) {
//		
//		
//	}

	// convert all url to csv
	public void TranformAllUrlIntoCsv(ArrayList<String> input_array) {

		String file_path = "P:\\ScrappyFazWaz\\ScrappingFazWaz\\URL_CSV.csv";

		try {
			Path path = Paths.get(file_path);

			BufferedWriter write = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
			System.out.println("Ready to write...");
			for (int i = 0; i < input_array.size(); i++) {
				write.write(i + "");
				write.write(",");
				write.write(input_array.get(i));
				write.newLine();
			}
			System.out.println("Write done..");
			write.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// <!-- test done -->

	public String takeUrlThenReturnId(String input_url) {

		String id = null;
		String path = "P:\\ScrappyFazWaz\\ScrappingFazWaz\\URL_CSV.csv";
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(path));
			String[] value;
			while ((value = csvReader.readNext()) != null) {
//				System.out.println(value[0] +" " +value[1]);
				if (value[1].toString().equals(input_url)) {
					id = value[0].toString();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (id);

	}

	public String takeIdThenReturnUrl(String p_id) {
		String url = null;
		String path = "P:\\ScrappyFazWaz\\ScrappingFazWaz\\URL_CSV.csv";
		CSVReader csvReader = null;

		try {
			csvReader = new CSVReader(new FileReader(path));
			String[] value;
			while ((value = csvReader.readNext()) != null) {
				if (value[0].toString().equals(p_id)) {
					url = value[1];
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
	// Convert AssestType to CSV

	public void TranformAllAssestTypeToCsv() throws IOException {
		String file_path = "P:\\ScrappyFazWaz\\ScrappingFazWaz\\ASSEST_TYPE.csv";
		ArrayList<String> allAssestType = new ReadAllItemFromTextFile().getAllAssestType();
		try {
			Path path = Paths.get(file_path);

			BufferedWriter write = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
			System.out.println("Ready to write...");
			for (int i = 0; i < allAssestType.size(); i++) {
				write.write(i + "");
				write.write(",");
				write.write(allAssestType.get(i));
				write.newLine();
			}
			System.out.println("Write done..");
			write.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Convert facility to csv

	public void TranformAllFacilitesToCsv() throws IOException {
		String file_path = "P:\\ScrappyFazWaz\\ScrappingFazWaz\\FACILITIES.csv";
		ArrayList<String> allFacilities = new ReadAllItemFromTextFile().getAllFacilites();
		try {
			Path path = Paths.get(file_path);

			BufferedWriter write = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
			System.out.println("Ready to write...");
			for (int i = 0; i < allFacilities.size(); i++) {
				write.write(i + "");
				write.write(",");
				write.write(allFacilities.get(i));
				write.newLine();
			}
			System.out.println("Write done..");
			write.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String takeAssestTypeThenReturnIndex(String p_assestType) {
		String assest_type = null;
		String path = "P:\\ScrappyFazWaz\\ScrappingFazWaz\\ASSEST_TYPE.csv";
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(path));
			String[] value;
			while ((value = csvReader.readNext()) != null) {
//				System.out.println(value[0] +" " +value[1]);

				if (value[1].equals(p_assestType)) {
//					System.out.println(value[1]+"x");
					assest_type = value[0];
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return assest_type;
	}

	public ArrayList<String> takeAllOfFacilitiesThenReturnIndex(ArrayList<String> facilities) {
		ArrayList<String> facilitiesIndex = new ArrayList<>();
//		facilities.add(null);
		
		try {
			DataCsv checker = new DataCsv();
			for (String x : facilities) {
				facilitiesIndex.add(checker.takeOneOfFacilityThenReturnIndex(x));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return facilitiesIndex;
	}
	
	public String takeOneOfFacilityThenReturnIndex(String p_facility_item)
	{
		String index_of_facility = null;
		String path = "P:\\ScrappyFazWaz\\ScrappingFazWaz\\FACILITIES.csv";
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(path));
			String[] value;
			while ((value = csvReader.readNext()) != null) {
//				System.out.println(value[0] +" " +value[1]);

				if (value[1].equals(p_facility_item)) {
//					System.out.println(value[1]+"x");
					index_of_facility = value[0];
//					System.out.println(index_of_facility);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return index_of_facility;
		
	}
}
