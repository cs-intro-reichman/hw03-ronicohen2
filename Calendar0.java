
public class Calendar0 
{	
	
	public static void main(String args[]) 
	{
		int year = Integer.parseInt(args[0]);
		isLeapYearTest(year);
		nDaysInMonthTest(year);
	}
		 
	private static void isLeapYearTest(int year) 
	{
		String commonOrLeap = "common";
		if (isLeapYear(year)) 
		{
			commonOrLeap = "leap";
		}
		System.out.println(year + " is a " + commonOrLeap + " year");  
	}

	private static void nDaysInMonthTest(int year) 
	{
		int month = 1;
		int days = 0;
		for (int i = 1; i <= 12; i++)
		{
			days = nDaysInMonth(month, year);
			System.out.println("Month " + month + " has " + days + " days" ); 
			month ++;
		}
	}

	public static boolean isLeapYear(int year) 
	{
		if (year % 4 == 0)
		{
			return true;
		}	
		if ((year % 100 ==0) && (year % 400 == 0))
		{
			return true;
		}	
		else return false;
	}
	
	public static int nDaysInMonth(int month, int year) 
	{
		int days = 0;
		if (month == 2)
		{
			if (isLeapYear(year))
			{
				days = 29;
			}
			else days = 28;
		}
		else if ((month == 4) || (month == 6) || (month == 9) || (month == 11))
		{
			days = 30;
		}
		else days = 31;
		return days;
	}
}

