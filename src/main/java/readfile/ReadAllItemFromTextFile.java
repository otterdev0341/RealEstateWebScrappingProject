package readfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.testng.annotations.Test;

public class ReadAllItemFromTextFile {

	public ArrayList<String> getAllUrl() {
		ArrayList<String> allUrl = new ArrayList<>();

		try {
			String temp_data;
			File text_file = new File("P:\\ScrappyFazWaz\\ScrappingFazWaz\\AllUrl.txt");
			Scanner myReader = new Scanner(text_file);

			while (myReader.hasNextLine()) {
				temp_data = myReader.nextLine();
				allUrl.add(temp_data);

			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}

		return (allUrl);
	}
	
	public ArrayList<String> getAllAssestType() throws IOException {
		ArrayList<String> allAssestType = new ArrayList<>();
		try {
			String temp_data;
			File text_file = new File("P:\\ScrappyFazWaz\\ScrappingFazWaz\\AssestType");
			Scanner myReader = new Scanner(text_file);

			while (myReader.hasNextLine()) {
				temp_data = myReader.nextLine();
				allAssestType.add(temp_data);
				
			}
			myReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allAssestType;
	}
	
	public ArrayList<String> getAllFacilites() throws IOException
	{
		ArrayList<String> allFacility = new ArrayList<>();
		try {
			String temp_data;
			File text_file = new File("P:\\ScrappyFazWaz\\ScrappingFazWaz\\AllFacilities.txt");
			Scanner myReader = new Scanner(text_file);

			while (myReader.hasNextLine()) {
				temp_data = myReader.nextLine();
				allFacility.add(temp_data);
				
				
			}
			myReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allFacility;
	}
}
