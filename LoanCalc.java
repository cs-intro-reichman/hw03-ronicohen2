
public class LoanCalc 
{
	
	static double epsilon = 0.001;  
	static int iterationCounter;    
	
	public static void main(String[] args) 
	{		

		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}

    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) 
    {  
    	iterationCounter = 0;
    	double g = loan/n;
    	while (endBalance(loan, rate, n, g)>0)
    	{
    		g = g + epsilon;
    		iterationCounter++;
    	}
    	return g;
    }
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) 
    {  
    	iterationCounter = 0;
    	double max = loan;
    	double min = 0;
    	double g = (max + min)/2;
    	while (max - min > epsilon)
    	{
    		if ((endBalance(loan, rate, n, max)* endBalance(loan, rate, n, g)) < 0)
    		{
    			min = g;
    		}
    		else 
    		{
    			max = g;
    		}
    		g = (max + min)/2;
    		iterationCounter++;

    	}	
    	return g;

    }
	
	private static double endBalance(double loan, double rate, int n, double payment) 
	{
		double balance = 0;
		double current = loan; 
		for (int i = 1; i <= n; i++)
		{
			balance = (current-payment)*(1 + (rate/100));
			current = balance;
		}
    	return balance;
	}
}














