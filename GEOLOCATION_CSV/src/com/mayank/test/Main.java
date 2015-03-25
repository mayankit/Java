package com.mayank.test;

import java.io.InputStreamReader;
import java.util.Scanner;

import com.mayank.test.reader.ProcessCSV;

public class Main {

	private static Scanner scanner;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String filePath = "C:\\abc.txt";
		//String outputPath = "C:\\bcd.txt";
		
		scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Reading input from console using Scanner in Java ");
        System.out.println("Please enter your input file path: ");
        String input = scanner.nextLine();
        
        System.out.println("Please enter your output file path: ");
        String output = scanner.nextLine();

		ProcessCSV.readWriteCsv(input, output); 

	}

}
