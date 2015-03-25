package com.mayank.test.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import com.mayank.test.client.APIClient;
import com.mayank.test.xml.LocationTime;

public class ProcessCSV {

	
	public static void readWriteCsv(String filePath,String outputPath) {
		System.out.println("started conversion");
		
		String csvFilename = filePath;
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(csvFilename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CSVWriter writer = null;
		try {
			writer = new CSVWriter(new FileWriter(outputPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] row = null;
		try {
			while((row = csvReader.readNext()) != null) {
			    
				String date = row[0];
				String lattitude = row[1] ;
				String longitude= row[2];
				long dayLightSaving = 0L;
				
				APIClient api = new APIClient(lattitude,longitude);
				LocationTime  lt = api.getLocationTime();
				
				String zoneName = lt.getZoneName();
				
				String dst = lt.getDst();
				if(dst.equals("1")){
					
					dayLightSaving = 60*60;
				}
				
				long locationtimeStamp = api.getTimeStamp(date)+Long.parseLong(lt.getGmtOffset())-dayLightSaving;
				
				String timeZone = lt.getAbbreviation();
				String newDate = api.getDate(locationtimeStamp,timeZone);
				
				String outputArray[] = {date,lattitude,longitude,zoneName,newDate};
				
				writer.writeNext(outputArray);
				System.out.println("Finished conversion");
			}
		} catch (NumberFormatException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Problem in parsing/reading");
			e.printStackTrace();
		}finally{
			try {
				csvReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}
