package collectPrice;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import csv.DataCsv;
import dataclass.WriteObjectToCsv;

public class CollectPrice {
	
	public static void main(String[] args) {
		
	}
	
	@Test
	public void GetAllPrice() throws IOException
	{
		//intit all id to array list
		DataCsv getData = new DataCsv();
		ArrayList<String> allId = getData.initAllIdIntoArrayList();
		JsoupGetPrice getPrice = new JsoupGetPrice();
		AssestPrice tempAssest = new AssestPrice();
		WriteObjectToCsv writeIt = new WriteObjectToCsv();
		for (String x : allId) {
			System.out.println("Working on : " + x);
			tempAssest.setId(x);
			tempAssest.setPrice(getPrice.JsoupGetPrice(x));
			writeIt.WriteAssestPriceTN(tempAssest);
			System.out.println("Write done..");
			System.out.println("Have " + ( allId.size()- Integer.parseInt(x) ) + " to complete...");
			
		}
	}
}
