package project2;


import java.util.*;
import java.io.File;
//this class is used for File I/O specially for reading credentials from the file
public class ReadFile {

	private Scanner sc;
	
	public void openFile()
	{
		
		try
		{
			sc = new Scanner(new File("/Users/Fiaz10/eclipse-workspace_for_java/project2/src/credentials.txt"));
		}
		catch(Exception e)
		{
			System.out.println("File could not be found");
		}
		System.out.println("File opened");
		
	}	
	public String[] readFile()
	{
		String[] b = {"",""};
		
		{
			String a = sc.next();
			b = a.split(",");		// using the split function to break the string into username and password
	
		}
		return b;
	}
	public String verification()
	{
		String userName, pW;
		System.out.println("Manager Login");
		System.out.println("------------------------------");
		Scanner cr = new Scanner(System.in);
		System.out.print("Please enter your user name: ");
		userName = cr.nextLine();
		System.out.print("Please enter your password: ");
		pW = cr.nextLine();
		
		String[] b = {"",""};
		boolean exitLoop = true;
		while(sc.hasNext() && exitLoop)
		{
			String a = sc.next();
			b = a.split(",");
			
			if(userName.equals(b[0]) && pW.equals(b[1]))
			{
				System.out.println("Login Successfull");
				System.out.println(" ");
				exitLoop = false;
				return "Login Successful";
			}
			//return "Login Unsuccessful";
		}
		
		return "Login Unsuccessful";
	}

	public void closeFile()
	{
		
		sc.close();
		System.out.println("File closed");
	}
	
}
