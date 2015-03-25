package com.mayank.test.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import com.mayank.test.classes.Word;
import com.mayank.test.common.StopWorlds;



public class ProcessCSV {

	
	public static void readCsv(String filePath,String outputPath) {
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
		HashMap<String,Word> keywordsMap = new HashMap<String,Word>();
		try {
			while((row = csvReader.readNext()) != null) {
			    
				String phrases = row[1];
				String wordArrays[] = phrases.split(" ");
				
				for(int i=0;i<wordArrays.length;i++){
					
					String inputWord = wordArrays[i].trim();
					if(!StopWorlds.isPresent(inputWord)){
						if(keywordsMap.get(inputWord)==null){
							Word word = new Word();
							word.value = inputWord;
							word.count = 0;
							keywordsMap.put(inputWord,word);
						}else{
							Word o = keywordsMap.get(inputWord);
							o.count++;
							keywordsMap.put(inputWord, o);
						}
						
					}
					
				}
				
				
				/*String lattitude = row[1] ;
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
				
				String outputArray[] = {date,lattitude,longitude,zoneName,newDate};*/
				
				/*writer.writeNext(outputArray);
				System.out.println("Finished conversion");*/

			}
			System.out.println(keywordsMap);
			System.out.println(sortByCount(keywordsMap));
		
				
			
			
		} catch (NumberFormatException | IOException e) {
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
	
	public static List<Word> sortByCount(
		    HashMap<String, Word> wordHashMap
		  ) 
		{

		    if (wordHashMap != null) {
		        List<Word> values = new ArrayList();
		        values.addAll(wordHashMap.values());
		        Collections.sort(values, new Comparator<Word>() {
		            public int compare(Word o1, Word o2) {
		                return o2.getCount().compareTo(o1.getCount());
		            }
		        });

		        return values;
		    }

		    return null;
		}
	
	
}
