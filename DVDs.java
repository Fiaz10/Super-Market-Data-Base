package project2;
// this is the class for DVDs 

public class DVDs implements Comparable <DVDs> {
	
	private String directorName;	// all the private variables 
	private int dvdCode;
	private int dvdYear;
	private String dvdTitle;
	private double dvdPrice;
	private double discountPrice = 0.8;
	
	DVDs()		// default constructor
	{	
		
	}
	DVDs(String dN, String dT, int dC, int dY, double dP)	// overloaded constructor 
	{
		directorName = dN;
		dvdCode 	 = dC;
		dvdTitle 	 = dT;
		dvdYear   	 = dY;
		dvdPrice 	 = dP;
		
	}
	public int getDvdCode()
	{
		int dCode = dvdCode;
		return dCode;
	}
	public int getDvdYear()
	{
		int dYear = dvdYear;
		return dYear;
	}
	public String getTitle()
	{
		String dTitle = dvdTitle;
		return dTitle;
	}
	public double getDvdPrice()
	{
		double dprice = discountPrice  * dvdPrice;
		return dprice;
	}
	public String getDirectorName()
	{
		String director = directorName;
		return director;
	}
	
	public int compareTo(DVDs d)
	{
		if(d.getDvdPrice() == this.getDvdPrice())
		{
			return 0;
		}
		if(d.getDvdPrice() < this.getDvdPrice())
		{
			return 1;
		}
		
		else
		{
			return -1;
		}
	}
	public String toString()
	{
		return "Title: " + dvdTitle + " | Director: " + directorName + " | Price " + getDvdPrice() + " | Year: " + dvdYear + " | DvdCode | " + dvdCode;
	}
	
}
