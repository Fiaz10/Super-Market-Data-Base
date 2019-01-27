package project2;

// this class is used for File I/O specially for writing to file to backup data
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.*;
import java.text.*;		// for simple date format

public class WriteFile {

	public void writeBackup( ArrayList<Books> b, ArrayList<DVDs> d)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");		// for some reason the month MM has to be capitalized maybe cause minutes is mm 
		
		Calendar c = Calendar.getInstance();
		
		String dateStr = sdf.format(c.getTime());
		
		
		
		String fileName = "catalog_backup_" + dateStr + ".txt";
		System.out.println(fileName);
		
		try 
		{
			
			FileWriter  writer = new FileWriter(fileName);
			PrintWriter printWriter = new PrintWriter(writer);
			
			for(int i = 0; i < b.size(); i++ )
			{
				printWriter.println(b.get(i));
			}
			printWriter.println("----------------------------------------------------------------------------------------");
			for(int i = 0; i < d.size(); i++ )
			{
				printWriter.println(d.get(i));
			}
			
			printWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("exception in reading");
		}
		
		

		
	}
	

}
