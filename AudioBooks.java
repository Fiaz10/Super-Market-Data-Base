package project2;

// class for Audio books 
// it is derived from the books class
public class AudioBooks extends Books {
	
	private double runningTime = 0;
	AudioBooks()
	{
		
	}
	AudioBooks(String aN , String bT, int ISBNnum, double bP, double rT)
	{
		super (aN, bT, ISBNnum, bP);	// uses the overloaded constructor of parent class
		discountPrice = 0.5;
		runningTime = rT;
	}
	public double getBookPrice()
	{
		
		double price = discountPrice*bookPrice;		// added super
		return price;
	}

	public String toString()
	{
		return  "Title: " + getTitle() + " | Author: "  + getAuthorName() + " | Price: " + getBookPrice() + " | ISBN:  " + getISBN() + " | Running Time:" + runningTime;
	}
}
