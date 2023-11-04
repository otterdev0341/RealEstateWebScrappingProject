package writefile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WriteDataToFile {
	
	ArrayList<String> context = new ArrayList<>();
	
	public void letWriteFile(ArrayList<String> inputData) {
		
		try {
			//set location to write
			Path file_path = Paths.get("P:\\ScrappyFazWaz\\ScrappingFazWaz\\AllUrl.txt");
			// create writer
			BufferedWriter write = Files.newBufferedWriter(file_path, StandardCharsets.UTF_8);
			
			// write to the last line of inputData
			for(int i = 0; i < inputData.size(); i++) 
			{
				write.write(inputData.get(i));
				write.newLine();
			}
			
			write.close();
			
		}catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());
		}
	}
}
