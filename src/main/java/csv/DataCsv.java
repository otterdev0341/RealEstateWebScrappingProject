package csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

import readfile.ReadAllUrlFromTextFile;

public class DataCsv {

//	public static void main(String[] args) {
//		String test_to_get_id = "https://www.fazwaz.co.th/%E0%B8%82%E0%B8%B2%E0%B8%A2%E0%B8%9A%E0%B9%89%E0%B8%B2%E0%B8%99/%E0%B8%82%E0%B8%B2%E0%B8%A2-%E0%B8%A7%E0%B8%B4%E0%B8%A5%E0%B8%A5%E0%B9%88%E0%B8%B2-2-%E0%B8%AB%E0%B9%89%E0%B8%AD%E0%B8%87%E0%B8%99%E0%B8%AD%E0%B8%99-%E0%B9%83%E0%B8%99-%E0%B8%A3%E0%B8%B2%E0%B9%84%E0%B8%A7%E0%B8%A2%E0%B9%8C-%E0%B8%A0%E0%B8%B9%E0%B9%80%E0%B8%81%E0%B9%87%E0%B8%95-u1683990";
//		DataCsv test_object = new DataCsv();
//		String recive_id = test_object.takeUrlThenReturnId(test_to_get_id);
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

}
