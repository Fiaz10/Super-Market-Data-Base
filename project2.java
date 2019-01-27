package project2;



import java.util.ArrayList;	// we import the necessary libraries
import java.util.Collections;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//This is the driver class 
public class project2 {
	
	static ArrayList<Books> BookInfo = new ArrayList<Books>();		// we create two arraylist of objects of type Books and DVD for the catalog
	static ArrayList<DVDs> DVDInfo = new ArrayList<DVDs>(); 
	
	static ArrayList<Books> BookCart = new ArrayList<Books>();		// we create two arraylist of objects Book and DVD objects for customers cart
	static ArrayList<DVDs> DVDCart = new ArrayList<DVDs>(); 
	
	
	static Acceptable v = new Validator();
	
	public static void main(String[] args) {
		//DisplayCustomerMenu();
		MainMenuDisplay();// calling the methode to display the menu
	
	}
	
	//Method definition for the Main Menu
	public static void MainMenuDisplay()
	{
		Scanner input = new Scanner(System.in);	
		String firstInput = "z";
	
		
		while (!(firstInput.equals("C")))		// use of a while and do-while loop for input validation
		{
			do
			{
				System.out.println("**Welcome to the Comets Books and DVDs Store**");
				System.out.println("Please use the capital letters A,B or C to select your role:");
				System.out.println("A-Store Manager");
				System.out.println("B-Customer");
				System.out.println("C-Exit Store");
				
				
				firstInput = input.nextLine();
				
				
				if(firstInput.equals("A"))			// for option A 
				{
					try {
						Scanner sc1 = new Scanner(new File("/Users/Fiaz10/eclipse-workspace_for_java/project2/src/credentials.txt"));
					}
					catch(Exception e )
					{
						System.out.println("no file");
					}
					
					ReadFile r = new ReadFile();		// creates an instance of the ReadFile class
					r.openFile();						// opens the file
			
					if(r.verification().equals("Login Successful"))		// checks if login successful
					{
						DisplayManagerMenu(); // recursive call
					
					}
					else 
					{
						System.out.println("Invalid Credentials");	// gets out the loop if invalid credentials entered
						break;
					}
					r.closeFile();								// closes the file
				}									
				if(firstInput.equals("B"))						// option B
				{
					DisplayCustomerMenu();
				}
				if(v.isNonEmptyString(firstInput) && v.isSingleChar(firstInput))
				{
					continue;
				}
				
			}
			while(!firstInput.equals("A")  && !firstInput.equals("B") && !firstInput.equals("C"));
		}
		System.out.println("Good Bye!");
		
		
	}
				// method definition for the customer menu
	public static void DisplayCustomerMenu()
	{
		String userInput = "";		// this is the user input for the primary menu 
		while(!userInput.equals("9"))	// the loop repeats as long as the user doesn't enter 9	
		{
			int intVal = 0;

			do	// the do while loop repeats as long as the user doesn't enters a valid input
			{
		
				System.out.println("**Welcome to the Comets Books and DVDs Store(Customer Section)**");
				System.out.println("Choose from the following options:");
				System.out.println("1 - Browse Books Inventory (Price low to high)");
				System.out.println("2 - Browse DVDs inventory (Price low to high)");
				System.out.println("3 - Add a Book to the cart");
				System.out.println("4 - Add a DVD to the cart");
				System.out.println("5 – Delete a Book from cart");
				System.out.println("6 - Delete a DVD from cart");
				System.out.println("7 - View cart");
				System.out.println("8 - Checkout");
			
				System.out.println("9 - Done Shopping");
				
				Scanner input = new Scanner(System.in);	
				userInput = input.nextLine();
				
				intVal = Integer.parseInt(userInput);
			
			}
			
			while(!(v.isInRange(intVal, 0, 10)));
			
			//System.out.println("Test");
			// SWITCH CASSES DETERMINES HOW TO INTERPRETE USER INPUT
			switch(intVal)
			{
				case 1:
					DisplayBookInventory();// display book inventory
					break;
					
				case 2: 
					DisplayDVDInventory();// display dvds inventory
					break;
				
				case 3: 
				
					addBookToCart();
				//	DisplayCustomerMenu();
					break;
				
				case 4:
				
					addDVDToCart();
					break;
				
				case 5:
				
					deleteBookFromCart();
					break;
				
				case 6:
					deleteDVDFromCart();
					break;
				
				case 7:
					viewCart();
					break;
					
				case 8: 
					cartCheckout();// checkout
					break;
				
				case 9:
					return;
					//break;
					
				default: 
					System.out.println("Invalid Input! This option is not acceptable");
			}		
					
			
		}	
	}
		// Method definition for the manager menu
	public static void DisplayManagerMenu()
	{
		String userInput = "";		// this is the user input for the primary menu 
		while(!userInput.equals("9"))	// the loop repeats as long as the user doesn't enter 9	
		{
			int intVal = 0;

			do	// the do while loop repeats as long as the user doesn't enters a valid input
			{
		
				System.out.println("**Welcome to the Comets Books and DVDs Store(Catalog Section)**");
				System.out.println("");
				System.out.println("Choose from the following options:");
				System.out.println("1 - Add Book");
				System.out.println("2 - Add Audio Book");
				System.out.println("3 – Add DVD");
				System.out.println("4 - Remove Book");
				System.out.println("5 - Remove DVD");
				System.out.println("6 - Display Catalog");
				System.out.println("7 - Create Bacukup file");
				System.out.println("9 - Exit Catalog section");
				
				Scanner input = new Scanner(System.in);	
				userInput = input.nextLine();
				
				intVal = Integer.parseInt(userInput);
//				
			}
			
			while(!(v.isInRange(intVal, 0, 10)));
			
			
			// SWITCH CASSES DETERMINES HOW TO INTERPRETE USER INPUT
			switch(intVal)
			{
				case 1: 
				
					addBook();
					break;
				
				case 2:
					addAudioBook();
					break;
				
				case 3:
					addDVDs();
					break;
				
				case 4:
					removeBook();
					break;
				
				case 5:
					removeDVD();
					break;
				
				case 6:
					DisplayCatalog();
					break;
				case 7:
					WriteFile wF = new WriteFile();			// creates an instance of the writeFile class and uses the modified constructor to pass in the info
					wF.writeBackup(BookInfo, DVDInfo);
					break;
				case 9:
					return;
				//	break;
					
				default: 
					System.out.println("Invalid Input! This option is not acceptable");
			}		
					
			
		}	
	}
	
	// method implementation for adding books to the catalog
	public static void addBook()
	{
		// declarations of local variables 
		String aN = "",bT = "";
		int ISBN = 0;
		double bP = 0.0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the Book's ISBN number");
		// validation for integer data
		while(!input.hasNextInt())
		{
			System.out.println("The input is invalid. Please enter again");
			input.next();	
		}
		ISBN = input.nextInt();
		while(ISBN <= 0)
		{
			System.out.println("The input is invalid. Please enter again");
			while(!input.hasNextInt())
			{
				System.out.println("The input is invalid. Please enter again");
				input.next();
			}
			ISBN = input.nextInt();
		}
		
		// clears buffer
		input.nextLine();
		
		// checks if book is already in catalog
		for(int i = 0; i < BookInfo.size(); i++)
		{
			if(ISBN==BookInfo.get(i).getISBN())
			{
				System.out.println("The BOOK is already in the catalog");
				DisplayCustomerMenu();
				
				
			}
		}
		
		
		
		System.out.println("Enter the Book title");
		do
		{
				bT = input.nextLine();
				if(bT.equals(""))		// checks if bookname is empty
				{
					System.out.println("The BOOK needs to have a title");
				}
		}
		while(bT.equals(""));
		
		
		System.out.println("Enter the Book Author's name");
		
		do
		{
				aN = input.nextLine();
				if(aN.equals(""))
				{
					System.out.println("The BOOK needs to have a Author's Name");
				}
		}
		while(aN.equals(""));
		
		System.out.println("Enter the Book Price");
		
		while(!input.hasNextDouble())
		{
			System.out.println("The input is invalid. Please enter again");
			input.next();	
		}
		
		
		bP = input.nextDouble();
		
		while(bP <= 0)
		{
			System.out.println("The input is invalid. Please enter again");
			while(!input.hasNextDouble())
			{
				System.out.println("The input is invalid. Please enter again");
				input.next(); 
			}
			bP = input.nextDouble();
		}
		
		
		BookInfo.add(new Books(aN, bT, ISBN, bP));		// instantiates an object of Books class with the following arguments 
	}
	
	// this is method implemtation for audioBooks to be added to the catalog
	// it acts similar to books
	public static void addAudioBook()
	{
		// declarations of local variables 
		String aN,bT;
		int ISBN = 0;
		double bP, rT = 0.0;
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the Audio Book's ISBN number");
		while(!input.hasNextInt())
		{
			System.out.println("The input is invalid. Please enter again");
			input.next();	
		}
		ISBN = input.nextInt();
		while(ISBN <= 0)
		{
			System.out.println("The input is invalid. Please enter again");
			while(!input.hasNextInt())
			{
				System.out.println("The input is invalid. Please enter again");
				input.next();
			}
			ISBN = input.nextInt();
		}
	
		input.nextLine();
		
		for(int i = 0; i < BookInfo.size(); i++)
		{
			if(ISBN==BookInfo.get(i).getISBN())
			{
				System.out.println("The Audio Book is already in the catalog");
				DisplayCustomerMenu();
			}
		}
		
		System.out.println("Enter the Audio Book title");
		
		do
		{
				bT = input.nextLine();
				if(bT.equals(""))
				{
					System.out.println("The Audio Book needs to have a title");
				}
		}
		while(bT.equals(""));
		
		System.out.println("Enter the Book Author's name");
		
		do
		{
				aN = input.nextLine();
				if(aN.equals(""))
				{
					System.out.println("The Audio Book needs to have a Author's Name");
				}
		}
		while(aN.equals(""));
		
		System.out.println("Enter the Book Price");
		bP = input.nextDouble();
		
		
		System.out.println("Enter the Book's Running Time");
		
		while(!input.hasNextDouble())
		{
			System.out.println("The input is invalid. Please enter again");
			input.next();	
		}
		
		rT = input.nextDouble();
		
		while(rT <= 0)
		{
			System.out.println("The input is invalid. Please enter again");
			while(!input.hasNextDouble())
			{
				System.out.println("The input is invalid. Please enter again");
				input.next();
			}
			rT = input.nextDouble();
		}
		
		
		BookInfo.add(new AudioBooks(aN, bT, ISBN, bP , rT));
	}
	
	// this is method implementation to add Dvds to the catalog
	
	public static void addDVDs()
	{
		String dN,dT;
		int dY=0, dC=0;
		double dP = 0.0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the DVD's code number");
		while(!input.hasNextInt())
		{
			System.out.println("The input is invalid. Please enter again");
			input.next();	
		}
		dC = input.nextInt();
		while(dC <= 0)
		{
			System.out.println("The input is invalid. Please enter again");
			while(!input.hasNextInt())
			{
				System.out.println("The input is invalid. Please enter again");
				input.next();
			}
			dC = input.nextInt();
		}
		
		input.nextLine();
		
		for(int i = 0; i < DVDInfo.size(); i++)
		{
			if(dC == DVDInfo.get(i).getDvdCode())
			{
				System.out.println("The DVD is already in the catalog");
				DisplayCustomerMenu();
			}
		}
		
		System.out.println("Enter the DVD title");
		
		do
		{
				dT = input.nextLine();
				if(dT.equals(""))
				{
					System.out.println("The DVD needs to have a Title");
				}
		}
		while(dT.equals(""));
		
		System.out.println("Enter the Director's name");
		
		do
		{
				dN = input.nextLine();
				if(dN.equals(""))
				{
					System.out.println("The DVD needs to have a Director's Name");
				}
		}
		while(dN.equals(""));
		
		System.out.println("Enter the DVD's Price");
		while(!input.hasNextDouble())
		{
			System.out.println("The input is invalid. Please enter again");
			input.next();	
		}
		
		dP = input.nextDouble();
		
		while(dP <= 0)
		{
			System.out.println("The input is invalid. Please enter again");
			while(!input.hasNextDouble())
			{
				System.out.println("The input is invalid. Please enter again");
				input.next();
			}
			dP = input.nextDouble();
		}
		
		System.out.println("Enter the DVD's year of release");
		
		while(!input.hasNextInt())
		{
			System.out.println("The input is invalid. Please enter again");
			input.next();	
		}
		dY = input.nextInt();
		while(dY <= 0)
		{
			System.out.println("The input is invalid. Please enter again");
			while(!input.hasNextInt())
			{
				System.out.println("The input is invalid. Please enter again");
				input.next();
			}
			dY = input.nextInt();
		}
		
		
		
		DVDInfo.add(new DVDs(dN, dT, dC, dY, dP));
		
	}
	
	// this is method implementation to remove book by isbn number
	public static void removeBook()
	{
		int ISBNr = 0;
		System.out.println("Enter the ISBN number of the Book you'd like to remove");
	
		Scanner input = new Scanner(System.in);
		ISBNr = input.nextInt();
		
		for(int i = 0; i< BookInfo.size();i++)
		{
			if(ISBNr == BookInfo.get(i).getISBN())
			{
				BookInfo.remove(i);
				System.out.println("Book Successfully removed");
			}
			else
			{
				System.out.println("Book does not exist");
			}
		}
		
		// after removal of book display the catalog and redisplay the menue 
		DisplayCatalog();
		DisplayCustomerMenu();
		
	}
	
	// this is mehtod declaration to remove dvds by code
	public static void removeDVD()
	{
		int dvdCode = 0;
		System.out.println("Enter the DVD code number you'd like to remove");
	
		Scanner input = new Scanner(System.in);
		dvdCode = input.nextInt();
		
		for(int i = 0; i< DVDInfo.size();i++)
		{
			if(dvdCode == DVDInfo.get(i).getDvdCode())
			{
				DVDInfo.remove(i);
				System.out.println("DVD Successfully removed");
			}
			else
			{
				System.out.println("DVD does not exist");
			}
		}
		
		
		
		// after removal of book display the catalog and redisplay the menu
		DisplayCatalog();
		DisplayCustomerMenu();
		
	}
	
	// display catalog method
	
	public static void DisplayCatalog()
	{
		Collections.sort(BookInfo);		// sorting the array list before displaying, this uses the compareTo method
		Collections.sort(DVDInfo);
		for(int i = 0; i < BookInfo.size(); i++ )
		{
			System.out.println(BookInfo.get(i));
		}
		System.out.println("----------------------------------------------------------------------------------------");
		for(int i = 0; i < DVDInfo.size(); i++ )
		{
			System.out.println(DVDInfo.get(i));
		}
	}
	// method for exiting store
	public static void exitStore()
	{
		System.out.println("********* Exiting Catalog *********");
		System.exit(0);
	}
	// method for dsiplaying book inventory
	public static void DisplayBookInventory()
	{
		if(BookInfo.size() == 0)
		{
			System.out.println("The Book Inventory is Empty at this point. Please come back later");
		}
		else 
		{
			Collections.sort(BookInfo);
			for(int i = 0; i < BookInfo.size(); i++ )
			{
				System.out.println(BookInfo.get(i));
			}
		}
		
	}
	// method for dsiplaying dvd inventory
	public static void DisplayDVDInventory()
	{
		if(DVDInfo.size() == 0)
		{
			System.out.println("The DVD Inventory is Empty at this point. Please come back later");
		}
		else
		{
			Collections.sort(DVDInfo);
			for(int i = 0; i < DVDInfo.size(); i++ )
			{
				System.out.println(DVDInfo.get(i));
			}
		}
		
	}
	// adding book to the cart
	public static void addBookToCart()
	{
		// declarations of local variables 
		int ISBN = 0;
				
				
		Scanner input = new Scanner(System.in);
				
		System.out.println("Enter the ISBN number of the Book you want to add: ");
		// validation for integer data
		while(!input.hasNextInt())
		{
			System.out.println("The input is invalid. Please enter again");
			input.next();	
		}
		ISBN = input.nextInt();
		while(ISBN <= 0)
		{
			System.out.println("The input is invalid. Please enter again");
			while(!input.hasNextInt())
			{
				System.out.println("The input is invalid. Please enter again");
				input.next();
			}
			ISBN = input.nextInt();
		}
				
				
		// clears buffer
		input.nextLine();
		int InfoIdx = 0;
		//int CartIdx = 0;
		boolean bookAdded = false;
		for(int i = 0; i < BookInfo.size(); i++ )
		{
			if(ISBN == (BookInfo.get(i)).getISBN())
			{
				InfoIdx = i;
				BookCart.add(BookInfo.get(InfoIdx));
				System.out.println("Book was succesfully added");
				//System.out.println(BookCart.size());
				bookAdded = true;
				break;
				
			}
			
		}	
		if(bookAdded == false)
		{
			System.out.println("Book with this ISBN Number doesnt exist");
			
		}
		
		
	}
	// adding dvd to the cart
	public static void addDVDToCart()
	{
		int dC=0;
	
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the code number for the DVD you want to add");
		while(!input.hasNextInt())
		{
			System.out.println("The input is invalid. Please enter again");
			input.next();	
		}
		dC = input.nextInt();
		while(dC <= 0)
		{
			System.out.println("The input is invalid. Please enter again");
			while(!input.hasNextInt())
			{
				System.out.println("The input is invalid. Please enter again");
				input.next();
			}
			dC = input.nextInt();
		}
		
		input.nextLine();
		
		int InfoIdx = 0;
		//int CartIdx = 0;
		boolean bookAdded = false;
		for(int i = 0; i < DVDInfo.size(); i++ )
		{
			if(dC == (DVDInfo.get(i)).getDvdCode())
			{
				InfoIdx = i;
				DVDCart.add(DVDInfo.get(InfoIdx));
				System.out.println("DVD was succesfully added");
				//System.out.println(BookCart.size());
				bookAdded = true;
				break;
				
			}
			
		}	
		if(bookAdded == false)
		{
			System.out.println("DVD with this code Number doesnt exist");
			
		}
		
		DisplayCustomerMenu();
		
	}
	// deleting book fro the cart
	public static void deleteBookFromCart()
	{
		// declarations of local variables 
		int ISBN = 0;
				
				
		Scanner input = new Scanner(System.in);
				
		System.out.println("Enter the ISBN number of the Book you want to delete: ");
		// validation for integer data
		while(!input.hasNextInt())
		{
			System.out.println("The input is invalid. Please enter again");
			input.next();	
		}
		ISBN = input.nextInt();
		while(ISBN <= 0)
		{
			System.out.println("The input is invalid. Please enter again");
			while(!input.hasNextInt())
			{
				System.out.println("The input is invalid. Please enter again");
				input.next();
			}
			ISBN = input.nextInt();
		}
			
				
		// clears buffer
		input.nextLine();
		int CartIdx = 0;
		//int CartIdx = 0;
		boolean bookAdded = false;
		
		for(int i = 0; i < BookCart.size(); i++ )
		{
			if(ISBN == (BookCart.get(i)).getISBN())
			{
				CartIdx = i;
				BookCart.remove((CartIdx));
				System.out.println("Book was succesfully deleted");
				//System.out.println(BookCart.size());
				bookAdded = true;
				break;
				
			}
			
		}	
		if(bookAdded == false)
		{
			System.out.println("Book with this ISBN Number doesnt exist");
			
		}
		
		DisplayCustomerMenu();
	}
	
	public static void deleteDVDFromCart()
	{
		int dC=0;
	
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the code number for the DVD you want to delete");
		while(!input.hasNextInt())
		{
			System.out.println("The input is invalid. Please enter again");
			input.next();	
		}
		dC = input.nextInt();
		while(dC <= 0)
		{
			System.out.println("The input is invalid. Please enter again");
			while(!input.hasNextInt())
			{
				System.out.println("The input is invalid. Please enter again");
				input.next();
			}
			dC = input.nextInt();
		}
		
		input.nextLine();
		
		//int InfoIdx = 0;
		int CartIdx = 0;
		boolean bookAdded = false;				// change it to deleted
		for(int i = 0; i < DVDCart.size(); i++ )
		{
			if(dC == (DVDCart.get(i)).getDvdCode())
			{
				CartIdx = i;
				DVDCart.remove((CartIdx));
				System.out.println("DVD was succesfully removed");
				//System.out.println(BookCart.size());
				bookAdded = true;
				break;
				
			}
			
		}	
		if(bookAdded == false)
		{
			System.out.println("DVD with this code Number doesnt exist");
			
		}
		
		DisplayCustomerMenu();
		
	}
	
	
	public static void viewCart()
	{
		double Total = 0;
		double Tax = 1.0825;
		
		if(BookCart.size() == 0 && DVDCart.size() == 0)
		{
			System.out.println("The cart is empty");
		}
		else
		{
			System.out.println("Items in cart: ");
			System.out.println("");
			System.out.println("----------------------------------------------------------------------------------------");
			
			for(int i = 0; i < BookCart.size(); i++ )
			{
				Total += BookCart.get(i).getBookPrice();
				System.out.println(BookCart.get(i));
			}
		//	System.out.println(Total);
			//System.out.println("----------------------------------------------------------------------------------------");
			for(int i = 0; i < DVDCart.size(); i++ )
			{
				Total += DVDCart.get(i).getDvdPrice();
				System.out.println(DVDCart.get(i));
			}
			System.out.println("----------------------------------------------------------------------------------------");
		//	System.out.println(Total);
			System.out.println("Total + Tax: " + (Total*Tax) );
			System.out.println("");
		}
		
		
	}
	public static void cartCheckout()
	{
		viewCart();
		
		BookCart.clear();
		DVDCart.clear();
		System.out.println("Thank You for shoping with us!");
	}
	
}