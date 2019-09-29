import java.text.DecimalFormat;

public class CSV_Data 
{
	int totalpages = 0; 
	int total_colour_pages = 0;
	int difference;                          // This will be used to calculate the total number of color pages
		 
	double blk_total_cost = 0, clr_total_cost= 0;
	double cost_per_job = 0;
		
	double complete_cost = 0;               // This will calculate the cost of all the jobs put together
	
	// Restrict the job cost display to only two decimal places
	DecimalFormat df = new DecimalFormat("####0.00");
}
