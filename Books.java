package project2;

// this is the class for Books 

public class Books implements Comparable <Books> {
	private String authorName;	// declaration of private variables
	private int ISBN;
	private String bookTitle;
	protected double bookPrice;					// changed to protected
	protected double discountPrice = 0.9;
	
	Books()		// default constructor 
	{
		
	}
	Books(String aN, String bT, int isbnNum, double bP)	// overloaded constructor 
	{
		authorName = aN;
		ISBN = isbnNum;
		bookTitle = bT;
		bookPrice = bP;
		
	}
	// all the getter methods 
	public int getISBN()
	{
		int isbnNum = ISBN;
		return isbnNum;
	}
	public String getTitle()
	{
		String title = bookTitle;
		return title;
	}
	public double getBookPrice()
	{
		double price = discountPrice * bookPrice;
		return price;
	}
	public String getAuthorName()
	{
		String author = authorName;
		return author;
	}
	
	public int compareTo(Books b)
	{
		if(b.getBookPrice() == this.getBookPrice())
		{
			return 0;
		}
		if(b.getBookPrice() < this.getBookPrice())
		{
			return 1;
		}
		
		else
		{
			return -1;
		}
			
	}
	
	// tostring method to print 
	public String toString()
	{
		return "Title: " + bookTitle + " | Author: "  + authorName + " | Price: " + getBookPrice() + " | ISBN:  " + ISBN;
	}
	
	
}
