package readfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class ReadAllUrlFromTextFile {
	
	
	public ArrayList<String> getAllUrl()
	{
		ArrayList<String> allUrl = new ArrayList<>();
		
		try {
			String temp_data;
			File text_file = new File("P:\\ScrappyFazWaz\\ScrappingFazWaz\\AllUrl.txt");
			Scanner myReader = new Scanner(text_file);
			
			while(myReader.hasNextLine())
			{
				temp_data = myReader.nextLine();
				allUrl.add(temp_data);
				
			}
			myReader.close();
			
		}catch (FileNotFoundException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
		
		
		return (allUrl);
	}
}
