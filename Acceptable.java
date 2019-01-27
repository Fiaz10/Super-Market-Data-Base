package project2;

// this is the interface ued for validation which is implemented in the validator class
public interface Acceptable {
	boolean isNonEmptyString(String s);  	// public static?
	boolean isPositiveInput(double d);
	boolean isNumerical(String s);
	boolean isInRange(int a, int r1, int r2);
	boolean isSingleChar(String s);

}
