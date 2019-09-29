/*
 * Paper Cut Code Challenge Sahil Bora
 * 29/9/2019
 */

import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.text.DecimalFormat;


public class SourceFile extends CSV_Data
{	
	private static final String CSV_FILE_PATH = "sample.csv";      // CSV file to be read in using csv
	
	public void read_file()
	{
		try
		(
				// Using Opencsv library to help read in csv file
	            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
	            
	            // Need to skip the heading in the excel file using withSkipLines
	            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
	    )
		
		{
				
			System.out.print("PaperCut Code Challenge - Sahil Bora" + "\n\n");
			
			// Iterate through the entire csv file to read all the data 
			// Using a data collection
			// For smaller embedded applications, we want to support large files easily
			List<String[]> print_jobs = csvReader.readAll();
			
			for(String[] record: print_jobs)
					{					
						// Display total pages per job
						System.out.println("Total pages: " + record[0]);
						
						// Compute value total pages from each job in the csv file
						int csv_total_pages = Integer.parseInt(record[0]);     /*theValue*/  // Black and white pages
						
						// Compute value color pages from each job in the csv file
						int csv_color_pages = Integer.parseInt(record[1]);     // theValue2 // Color pages
						
						// String value of either true or false
						String double_sided = record[2].toString();
						
						// In future we could add paper size here using record[3] code here
						
						
						// Check to see if the job is not double sided
						if(double_sided.startsWith(" false"))
								{
									// If the page is single sided the cost 
									// 15 cents per black and white page
									// 25 cents per colour page
									
									// Black and white pages cost calculation
									difference = csv_total_pages - csv_color_pages;
									
									// Calculate price for black and white print outs
									blk_total_cost = difference * 0.15;
									
									// Calculate price for colour prints
									clr_total_cost = csv_color_pages * 0.25;
									
									// Calculate total cost for the particular job
									cost_per_job = blk_total_cost + clr_total_cost;
									
								}
						
								// The job is classified as double sided
								else
								{
									// If the page is double sided the cost 
									// 10 cents per black and white page
									// 20 cents per colour page
									
									// Black and white pages cost calculation
									difference = csv_total_pages - csv_color_pages;
									
									// Calculate price for black and white print outs
									blk_total_cost = difference * 0.10;
									
									// Calculate price for colour prints
									clr_total_cost = csv_color_pages * 0.20;
									
									// Calculate total cost for the particular job
									cost_per_job = blk_total_cost + clr_total_cost;
									
								}
								
								// Iterate through the csv to calculate the total number of pages
								// and the total number of colour pages from all the jobs together
								totalpages += Integer.parseInt(record[0]);
								total_colour_pages += Integer.parseInt(record[1]);
								
								// Calculate cost of all the jobs together in the csv
								complete_cost += blk_total_cost + clr_total_cost;
											
								// Display Total Colour Pages from CSV file
								System.out.println("Total colour pages: " + record[1]);
									
								// Display if double sided or not from CSV File
								System.out.println("Double Sided: " + record[2]);
								
								// Display the total cost per each job read from the csv file
								System.out.println("Cost of print job: "+"$"+df.format(cost_per_job) + "\n");
							}
									
		}
		catch (Exception e)
		{
			System.out.println("File Not Found!\n");
		}
		
		
	}
	
	public void display_total()
	{
		// Display the total number of pages from all the jobs 
		System.out.println("Total Number of Pages: " + totalpages);
				
		// Display the total number of colour pages from the jobs
		System.out.println("Total Number of Colour Pages: " + total_colour_pages);	
					
		// Display the total cost of all print jobs together
		System.out.println("Total cost of all print jobs: $"+df.format(complete_cost));
		
	}
	
	
	public static void main(String[] args)
	{
		// Create an object for the sample print job
		SourceFile sample_printjob = new SourceFile();
		
		sample_printjob.read_file();
		sample_printjob.display_total();
	}
}