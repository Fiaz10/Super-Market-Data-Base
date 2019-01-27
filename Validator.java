package project2;

// this class is used to reduce redundant code for validation 
// it implements the Acceptable interface

public class Validator implements Acceptable {

	public Validator() {
		// TODO Auto-generated constructor stub
	}
	public boolean isNonEmptyString(String s)
	{
		if(s.isEmpty())
		{
			System.out.println("Please enter a non-empty string");
			return false;
			
		}
		return true;
		
	}
	public boolean isPositiveInput(double d)
	{
		if(d > 0)
		{
			return true;
		}
		else
		{
			System.out.println("Please enter a positive value");
			return false;
		}
	}
	public boolean isNumerical(String s)
	{
		if(s.isEmpty())
		{
			return false;
		}
		
		for(char c : s.toCharArray())
		{
			if(!Character.isDigit(c))
			{
				System.out.println("Please enter a numerical value");
				return false;
			}
			
		}
		return true;		// check this syntax
		
		
	}
	public boolean isInRange(int a, int r1, int r2)
	{
		if(!(a > r1 && a < r2))
		{
			System.out.println("Please enter a value in the proper range");
			return false;
			
		}
		return true;
	}
	public boolean isSingleChar(String s)
	{
		if(s.length() == 1)
		{
			
			return true;
			
		}
		else
		{
			System.out.println("Please enter a single character");
			return false;
		}
			
	}
}
