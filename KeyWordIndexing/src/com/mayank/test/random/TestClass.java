package com.mayank.test.random;

import com.mayank.test.common.StopWorlds;
import com.mayank.test.reader.ProcessCSV;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(StopWorlds.isPresent("mayank"));
		String input = "C:/Users/mayank.kumar/Desktop/JavaScripts/clusters.csv";
	    String output = "C:/abc.txt";
		ProcessCSV.readCsv(input, output); 

	}

}
